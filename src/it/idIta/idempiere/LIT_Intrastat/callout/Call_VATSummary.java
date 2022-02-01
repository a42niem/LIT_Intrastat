package it.idIta.idempiere.LIT_Intrastat.callout;

import java.math.BigDecimal;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;

import it.idIta.idempiere.LIT_Intrastat.model.X_LIT_VAT_Summary;

public class Call_VATSummary implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if(mTab.getTableName().equals(X_LIT_VAT_Summary.Table_Name) && mField.getColumnName().equals("DepositAmt"))
			return VATDebitTot_change(ctx, WindowNo, mTab, mField, value, oldValue);
		return null;
	}

	private String VATDebitTot_change(Properties ctx, int windowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		BigDecimal depositAmt = ((BigDecimal)value);
		if (depositAmt == null || depositAmt.compareTo(BigDecimal.ZERO) == 0) {
			//Ripristino importo se si imposta a '0' o lo si cancella 
			if(mTab.getValue("LIT_VAT_Debit_Total")!= null && ((BigDecimal)mTab.getValue("LIT_VAT_Debit_Total")).compareTo(BigDecimal.ZERO)==1) {
				BigDecimal vatDebitTotal = (BigDecimal)mTab.getValue("LIT_VAT_Debit_Total");
				BigDecimal addValue = (BigDecimal)oldValue;
				vatDebitTotal = vatDebitTotal.add(addValue);
				mTab.setValue("LIT_VAT_Debit_Total", vatDebitTotal);
			}
			return "";
		}
		//calcolo (Differenza (IVA Dovuta) - [Importo o Acconto]) -----> set TOTALE IVA Debito
		// DueAmt-DepositAmt-LIT_VAT_Used = importo ----> setLIT_VAT_Debit_Total(importo).....
		if(mTab.getValue("DueAmt")!=null && mTab.getValue("LIT_VAT_Used")!=null) {
			BigDecimal dueAmt = (BigDecimal)mTab.getValue("DueAmt");
			BigDecimal vatUsed = (BigDecimal)mTab.getValue("LIT_VAT_Used");
			if(dueAmt.compareTo(BigDecimal.ZERO)==1) {
				BigDecimal vatDebitTotal = (dueAmt.subtract(depositAmt)).subtract(vatUsed);
				mTab.setValue("LIT_VAT_Debit_Total", vatDebitTotal);
			}
		}
		return "";
	}

}
