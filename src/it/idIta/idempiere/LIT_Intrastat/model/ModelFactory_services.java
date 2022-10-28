package it.idIta.idempiere.LIT_Intrastat.model;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

public class ModelFactory_services implements IModelFactory {
	@Override
	public Class<?> getClass(String tableName) {

		if (X_LIT_InvoiceIntrastat.Table_Name.equals(tableName))
			return MInvoiceIntrastat.class;
		else if(X_LIT_Intrastat.Table_Name.equals(tableName))
			return X_LIT_Intrastat.class;
		
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		
		if (X_LIT_InvoiceIntrastat.Table_Name.equals(tableName))
			return new MInvoiceIntrastat(Env.getCtx(), Record_ID, trxName);
		else if(X_LIT_Intrastat.Table_Name.equals(tableName))
			return new X_LIT_Intrastat(Env.getCtx(), Record_ID, trxName);

		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {

		if (X_LIT_InvoiceIntrastat.Table_Name.equals(tableName))
			return new MInvoiceIntrastat(Env.getCtx(), rs, trxName);
		else if(X_LIT_Intrastat.Table_Name.equals(tableName))
			return new X_LIT_Intrastat(Env.getCtx(), rs, trxName);
		
		return null;
	}
}
