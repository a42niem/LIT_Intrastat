package it.idIta.idempiere.LIT_Intrastat.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.compiere.model.MInvoice;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

import it.idIta.idempiere.LIT_Intrastat.model.MInvoiceIntrastat;

public class CreateSummaryIntrastat extends SvrProcess {

	private int p_record_ID = -1;

	@Override
	protected void prepare() {

		p_record_ID = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		String tableName = MInvoice.Table_Name;
		List<MInvoice> listInvoice = null;
		String whereClause = "";
		if(p_record_ID>0)
			whereClause = tableName+"_ID=?";
		
		Query qry = new Query(getCtx(), tableName, whereClause, null)
				.setClient_ID()
				.setOnlyActiveRecords(true);
		if(p_record_ID>0)
			qry = qry.setParameters(p_record_ID);
		else
			qry = qry.setOnlySelection(getAD_PInstance_ID());
		listInvoice = qry.list();
		
		if(listInvoice!=null && !listInvoice.isEmpty()) {
			String sql = "select sum(il.LineNetAmt), sum((il.QtyEntered*p.Weight)) as totWeight, p.LIT_Intrastat_ID " + 
					"from c_invoiceline il " + 
					"inner join M_Product p ON il.m_product_id = p.m_product_id " + 
					"where il.c_invoice_id = ? " + 
					"group by p.LIT_Intrastat_ID";
			String sql_ForSUM = "select sum(il.LineNetAmt) " + 
					"from c_invoiceline il " + 
					"inner join M_Product p ON il.m_product_id = p.m_product_id " + 
					"where il.c_invoice_id =? and p.LIT_Intrastat_ID is null and p.ProductType ='S' " + 
					"group by p.LIT_Intrastat_ID";
			int invoiceID = 0;
			BigDecimal amt = null;
			BigDecimal totWeight = null;
			int lit_intrastat_id = 0;
			MInvoiceIntrastat invIntra = null;
			for (MInvoice invoice : listInvoice) {
				invoiceID = invoice.getC_Invoice_ID();
				////DELETE line LIT_InvoiceIntrastat 
				DB.executeUpdate("DELETE FROM LIT_InvoiceIntrastat WHERE C_Invoice_ID=?",invoiceID, null);
				
				List<List<Object>> rows = DB.getSQLArrayObjectsEx(null, sql, invoiceID);
				if (rows != null && rows.size() > 0) {
					for (List<Object> row : rows) {
						if(row.get(2)==null)
							continue;
						lit_intrastat_id = ((BigDecimal)row.get(2)).intValue();
						amt = (BigDecimal)row.get(0);
						totWeight = (BigDecimal)row.get(1);
						invIntra = new MInvoiceIntrastat(getCtx(), 0, null);
						invIntra.setC_Invoice_ID(invoiceID);
						invIntra.setLIT_Intrastat_ID(lit_intrastat_id);
						invIntra.setAmtSource(amt); //Orginario
						invIntra.setActualAmt(amt); //Effettivo
						invIntra.setWeight(totWeight);
						invIntra.saveEx();
					}
				}
				invoice.load(invoice.get_TrxName());
				invoice.getLines(true);
				
				BigDecimal sumServices = DB.getSQLValueBD(null, sql_ForSUM, invoiceID);
				BigDecimal sumIntrastat = MInvoiceIntrastat.getTotIntrastat(invoiceID);
				if(sumServices!=null && sumServices.compareTo(BigDecimal.ZERO)==1
						&& sumIntrastat!=null && sumIntrastat.compareTo(BigDecimal.ZERO)==1) {
					BigDecimal calDistributed = (sumServices.divide(sumIntrastat)).setScale(2, RoundingMode.HALF_UP);
					BigDecimal amtCalc = BigDecimal.ZERO;
					for(MInvoiceIntrastat mi_intra : MInvoiceIntrastat.getListInvoiceIntrastat(invoiceID)){
						amtCalc = mi_intra.getAmtSource();
						amtCalc = (amtCalc.multiply(calDistributed)).add(amtCalc);
						mi_intra.setAmtSource(amtCalc);
						mi_intra.setActualAmt(amtCalc);
						mi_intra.saveEx();
					}
				}
			}
		}

		return "";
	}

}
