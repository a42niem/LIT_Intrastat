package it.idIta.idempiere.LIT_Intrastat.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.Env;

public class MInvoiceIntrastat extends X_LIT_InvoiceIntrastat {

	/**
	 * 
	 */
	private static final long serialVersionUID = 577524997893199946L;

	public MInvoiceIntrastat(Properties ctx, int LIT_InvoiceIntrastat_ID, String trxName) {
		super(ctx, LIT_InvoiceIntrastat_ID, trxName);
	}

	public MInvoiceIntrastat(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public static MInvoiceIntrastat[] getListInvoiceIntrastat(int C_Invoice_ID) {
		String whereClause = "C_Invoice_ID=?";
		
		List<MInvoiceIntrastat> list = new Query(Env.getCtx(), Table_Name, whereClause, null)
				.setParameters(C_Invoice_ID)
				.setOnlyActiveRecords(true)
				.list();
		return list.toArray(new MInvoiceIntrastat[list.size()]);
	}
	
	public static BigDecimal getTotIntrastat(int C_Invoice_ID) {
		BigDecimal sum = BigDecimal.ZERO;
		
		MInvoiceIntrastat[] tmp = getListInvoiceIntrastat(C_Invoice_ID);
		if(tmp!= null && tmp.length>0)
			sum = Arrays.asList(tmp).stream()
					.map(x -> x.getAmtSource())
					.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return sum;
	}

}
