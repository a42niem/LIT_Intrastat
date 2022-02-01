package it.idIta.idempiere.LIT_Intrastat.process;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MOrg;
import org.compiere.model.MOrgInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import it.idIta.idempiere.LIT_Intrastat.Type_Enum;

public class GenerateFileIntrastat extends SvrProcess {

	private int adOrg_ID = 0;
	private String progress = "00"; //TODO
	private Timestamp dateFrom = null;
	private Timestamp dateTo = null;
	private boolean generateSales = false;
	private boolean generatePurchase = false;
	private int vatJournal_ID = 0;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else if (name.equals("AD_Org_ID"))
				adOrg_ID = Integer.parseInt(para[i].getParameter().toString());
			else if (name.equals("DateInvoicedFrom"))
				dateFrom = (Timestamp) para[i].getParameter();
			else if (name.equals("DateInvoicedTo"))
				dateTo = (Timestamp) para[i].getParameter();
			else if (name.equals("Progressive"))
				progress = para[i].getParameter().toString();
			else if(name.equals("isGenIntraSale"))
				generateSales = para[i].getParameter().toString().equals("Y");
			else if(name.equals("isGenIntraPurchase"))
				generatePurchase = para[i].getParameter().toString().equals("Y");
			else if(name.equals("LIT_VATJournal_ID"))
				vatJournal_ID = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}

	}

	@Override
	protected String doIt() throws Exception {

//		String whereClause = "DocStatus='CO' AND AD_Org_ID=? AND DateInvoiced>=? AND DateInvoiced<=?";
//		
//		List<MInvoice> listInvoice = new Query(getCtx(), MInvoice.Table_Name, whereClause, null)
//				.setClient_ID()
//				.setParameters(adOrg_ID, dateFrom, dateTo)
//				.setOnlyActiveRecords(true)
//				.setOrderBy("isSOTrx, C_BPartner_ID, DateInvoiced")
//				.list();
//		if(listInvoice.size()<=0)
//			return "No invoices....";
		
		String ad_language = Env.getAD_Language(getCtx());
		String strLog = "";
		MOrg org = new MOrg(getCtx(), adOrg_ID, null);
		MOrgInfo orgInfo = MOrgInfo.get(getCtx(), adOrg_ID, null);
		
		
		if(orgInfo != null && orgInfo.get_ValueAsString("LIT_CodeUA").trim().length()>0){
			
			LocalDate localDate = LocalDate.now();//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd");
			String formattedString = localDate.format(formatter);
			
			String strNameFile = orgInfo.get_ValueAsString("LIT_CodeUA").trim()+formattedString;
			
			//check di tipo mensile o trimestrale
			LocalDate from = dateFrom.toLocalDateTime().toLocalDate();
			LocalDate to   = dateTo.toLocalDateTime().toLocalDate();
			
			if(from.getDayOfMonth()!= 1){
				if(ad_language.equals("it_IT"))
					strLog = "Impostare il 1° del mese come data di inizio";
				else
					strLog = "Set the 1st of the month as the start date";
				//addLog(Msg.getMsg(getCtx(), "LIT_InvDataVat_FileIntraDateFrom"));
				addLog(Msg.getMsg(getCtx(), strLog));
				return "@Error@";
			}
			if(to.getDayOfMonth()!= to.lengthOfMonth()){
				if(ad_language.equals("it_IT"))
					strLog = "Impostare l'ultimo del mese come data fine";
				else
					strLog = "Set the last of the month as the end date";
				//addLog(Msg.getMsg(getCtx(), "LIT_InvDataVat_FileIntraDateTo"));
				addLog(Msg.getMsg(getCtx(), strLog));
				return "@Error@";
			}
			
			String periodicita = "";
			long days = from.until(to.plusDays(1), ChronoUnit.DAYS);
			if(days==from.lengthOfMonth())
				periodicita = Type_Enum.PERIODICITA_Mensile.stm();
			else
			{
				long months = from.until(to.plusDays(1), ChronoUnit.MONTHS);
				if(months==3)
					periodicita = Type_Enum.PERIODICITA_Trimestrale.stm();
				else{
					if(ad_language.equals("it_IT"))
						strLog = "Impostare range di un mese o di 3 mesi";
					else
						strLog = "Set ranges of one month or 3 months";
					//addLog(Msg.getMsg(getCtx(), "LIT_InvDataVat_FileIntraDateRange"));
					addLog(Msg.getMsg(getCtx(), strLog));
					return "@Error@";
				}
			}
			progress = String.valueOf(dateFrom.toLocalDateTime().getMonthValue());
			progress = (progress.length()==1)?("0"+progress):progress;
			File v_FileName =  new File(System.getProperty("java.io.tmpdir")+File.separator+strNameFile+".I"+progress);

			String sql = "select "
					+ "i.ad_client_id, i.ad_org_id, oi.taxid, i.issotrx, " // 0,  1,  2,  3
					+ "i.c_bpartner_id, i.c_currency_id, i.paymentrule, bp.value AS bpvalue, " // 4,  5,  6,  7
					+ "bp.lit_taxid AS bptaxid, bp.name, c.countrycode, " // 8,  9,  10
					+ "int.actualamt, int.weight, " // 11,  12
					+ "'1' as naturaTrans, intra.value, " // 13,  14
					+ "sum(il.qtyinvoiced) as qta " // 15
					+ "FROM c_invoice i " 
					+ "JOIN ad_orginfo oi ON i.ad_org_id = oi.ad_org_id " 
					+ "JOIN c_invoiceline il ON i.c_invoice_id = il.c_invoice_id " 
					+ "JOIN lit_invoiceintrastat int on i.c_invoice_id=int.c_invoice_id "
					+ "LEFT JOIN lit_intrastat intra on int.lit_intrastat_id= intra.lit_intrastat_id " 
					+ "LEFT JOIN LIT_VATJournal vatj on i.LIT_VATJournal_ID = vatj.LIT_VATJournal_ID "
					+ "JOIN c_bpartner bp ON i.c_bpartner_id = bp.c_bpartner_id " 
					+ "JOIN c_bpartner_location bpl ON bp.c_bpartner_id = bpl.c_bpartner_id " 
					+ "JOIN c_location l ON bpl.c_location_id = l.c_location_id " 
					+ "JOIN c_country c ON l.c_country_id=c.c_country_id " 
					+ "where i.ad_org_id=? and i.issotrx=? " 
					+ "and intra.IsManufactured=? and  i.dateacct >= ? and i.dateacct <= ? " //and intra.IsManufactured=? "(Y/N) 
					+ "and c.name!='Italy' and bpl.isbillto='Y' and i.LIT_VATJournal_ID=?" 
					+ "group by i.ad_client_id, i.ad_org_id, i.issotrx, i.c_bpartner_id, i.c_currency_id,i.paymentrule, bp.value, bp.lit_taxid," 
					+ "bp.name,oi.taxid, c.countrycode, int.actualamt,int.weight,int.LIT_Intrastat_ID, intra.value";
			
			/*
			   =========== OLD ===============

			String sql = "SELECT i.ad_client_id, i.ad_org_id, oi.taxid, i.issotrx, i.c_bpartner_id, i.c_currency_id, i.paymentrule, bp.value AS bpvalue, "
					+ "bp.lit_taxid AS bptaxid, bp.name, c.countrycode, sum(il.linenetamt) as amt, sum(il.qtyinvoiced*p.Weight) as weight, intra.value, "
					+ "CASE "
					+ " WHEN p.producttype ='I' THEN 'I' "
					+ " ELSE 'S' "
					+ "END as producttype,"
					+ "'1' as naturaTrans, "
					+ "'E' as codConsegna, "
					+ "c1.countrycode as countryCodeDest, "
					+ "sum(il.qtyinvoiced) as qta "
					+ "FROM c_invoice i "
					+ "JOIN c_invoiceline il ON i.c_invoice_id = il.c_invoice_id "
					//+ "LEFT OUTER JOIN c_order ord ON i.c_order_id = ord.c_order_id "
					+ "JOIN c_bpartner bp ON i.c_bpartner_id = bp.c_bpartner_id "
					+ "JOIN c_bpartner_location bpl ON bp.c_bpartner_id = bpl.c_bpartner_id "
					+ "JOIN c_location l ON bpl.c_location_id = l.c_location_id "
					+ "JOIN c_country c ON l.c_country_id=c.c_country_id "
					+ "JOIN c_bpartner_location bpl1 ON i.c_bpartner_id = bpl1.c_bpartner_id AND bpl1.c_bpartner_location_id=bpl.c_bpartner_location_id "
					+ "JOIN c_location l1 ON bpl.c_location_id = l1.c_location_id "
					+ "JOIN c_country c1 ON l1.c_country_id=c1.c_country_id "
					+ "JOIN ad_orginfo oi ON i.ad_org_id = oi.ad_org_id "
					+ "JOIN m_product p ON il.m_product_id = p.m_product_id "
					+ "left join LIT_INTRASTAT Intra ON P.LIT_INTRASTAT_ID=intra.lit_intrastat_id "
					+ "where i.ad_org_id=? and i.issotrx=? and producttype=? "
					+ "and i.dateacct >= ? and i.dateacct <= ? and c.name!='Italy' and bpl.isbillto='Y' "
					+ "and il.c_tax_id IN (SELECT C_Tax_ID FROM C_tax WHERE LOWER(Name) LIKE '%art%' and LOWER(Name) LIKE ?) "
					+ "group by i.ad_client_id, i.ad_org_id, i.issotrx, i.c_bpartner_id, i.c_currency_id,i.paymentrule, bp.value, bp.lit_taxid, bp.name,intra.value ,oi.taxid, c.countrycode, countryCodeDest, producttype";
			
			*/
			FixedLength_gen intrast = new Gen_Intrastat(this,getCtx(),sql, orgInfo, periodicita, dateFrom, dateTo, vatJournal_ID);
			
			try {
				intrast.writeHeader(v_FileName.getAbsolutePath(), dateFrom.toLocalDateTime().getMonthValue());
				intrast.writeRecord();
				
//				intrast.createHeadRecord(v_FileName.getAbsolutePath());
				
				
			} catch (Exception e) {
				throw new AdempiereException(e);
			}
			
			
			if (processUI != null)
				processUI.download(v_FileName);
			
		}
		else {
			if(ad_language.equals("it_IT"))
				strLog = "Nessun CODICE UA valorizzato nella maschera Informazioni Organizzazione. Verificare";
			else
				strLog = "No UA CODE entered in the Organization Information form. To verify";
			return strLog;
		}
		
		return "OK";
	}

}
