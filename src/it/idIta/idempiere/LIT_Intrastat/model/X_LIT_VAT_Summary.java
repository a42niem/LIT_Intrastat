/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package it.idIta.idempiere.LIT_Intrastat.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for LIT_VAT_Summary
 *  @author iDempiere (generated) 
 *  @version Release 6.2 - $Id$ */
public class X_LIT_VAT_Summary extends PO implements I_LIT_VAT_Summary, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200303L;

    /** Standard Constructor */
    public X_LIT_VAT_Summary (Properties ctx, int LIT_VAT_Summary_ID, String trxName)
    {
      super (ctx, LIT_VAT_Summary_ID, trxName);
      /** if (LIT_VAT_Summary_ID == 0)
        {
			setLIT_VAT_Summary_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_LIT_VAT_Summary (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_LIT_VAT_Summary[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Deposit Amount.
		@param DepositAmt Deposit Amount	  */
	public void setDepositAmt (BigDecimal DepositAmt)
	{
		set_Value (COLUMNNAME_DepositAmt, DepositAmt);
	}

	/** Get Deposit Amount.
		@return Deposit Amount	  */
	public BigDecimal getDepositAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DepositAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Difference.
		@param DifferenceAmt 
		Difference Amount
	  */
	public void setDifferenceAmt (BigDecimal DifferenceAmt)
	{
		set_Value (COLUMNNAME_DifferenceAmt, DifferenceAmt);
	}

	/** Get Difference.
		@return Difference Amount
	  */
	public BigDecimal getDifferenceAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DifferenceAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Amount due.
		@param DueAmt 
		Amount of the payment due
	  */
	public void setDueAmt (BigDecimal DueAmt)
	{
		set_Value (COLUMNNAME_DueAmt, DueAmt);
	}

	/** Get Amount due.
		@return Amount of the payment due
	  */
	public BigDecimal getDueAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DueAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_GL_Journal getGL_Journal() throws RuntimeException
    {
		return (org.compiere.model.I_GL_Journal)MTable.get(getCtx(), org.compiere.model.I_GL_Journal.Table_Name)
			.getPO(getGL_Journal_ID(), get_TrxName());	}

	/** Set Journal.
		@param GL_Journal_ID 
		General Ledger Journal
	  */
	public void setGL_Journal_ID (int GL_Journal_ID)
	{
		if (GL_Journal_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_GL_Journal_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_GL_Journal_ID, Integer.valueOf(GL_Journal_ID));
	}

	/** Get Journal.
		@return General Ledger Journal
	  */
	public int getGL_Journal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_Journal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Complete.
		@param IsComplete 
		It is complete
	  */
	public void setIsComplete (boolean IsComplete)
	{
		set_Value (COLUMNNAME_IsComplete, Boolean.valueOf(IsComplete));
	}

	/** Get Complete.
		@return It is complete
	  */
	public boolean isComplete () 
	{
		Object oo = get_Value(COLUMNNAME_IsComplete);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Tax base Amount PO.
		@param LIT_TaxBaseAmt_PO 
		Base for calculating the tax amount
	  */
	public void setLIT_TaxBaseAmt_PO (BigDecimal LIT_TaxBaseAmt_PO)
	{
		set_Value (COLUMNNAME_LIT_TaxBaseAmt_PO, LIT_TaxBaseAmt_PO);
	}

	/** Get Tax base Amount PO.
		@return Base for calculating the tax amount
	  */
	public BigDecimal getLIT_TaxBaseAmt_PO () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_TaxBaseAmt_PO);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tax base Amount SO.
		@param LIT_TaxBaseAmt_SO 
		Base for calculating the tax amount
	  */
	public void setLIT_TaxBaseAmt_SO (BigDecimal LIT_TaxBaseAmt_SO)
	{
		set_Value (COLUMNNAME_LIT_TaxBaseAmt_SO, LIT_TaxBaseAmt_SO);
	}

	/** Get Tax base Amount SO.
		@return Base for calculating the tax amount
	  */
	public BigDecimal getLIT_TaxBaseAmt_SO () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_TaxBaseAmt_SO);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Metodo Storico = 1 */
	public static final String LIT_TYPEDEPOSIT_MetodoStorico = "1";
	/** Metodo Previsionale = 2 */
	public static final String LIT_TYPEDEPOSIT_MetodoPrevisionale = "2";
	/** Metodo Analitico Effettivo = 3 */
	public static final String LIT_TYPEDEPOSIT_MetodoAnaliticoEffettivo = "3";
	/** Soggetti Operanti in settori diversi = 4 */
	public static final String LIT_TYPEDEPOSIT_SoggettiOperantiInSettoriDiversi = "4";
	/** Set Type Deposit.
		@param LIT_TypeDeposit Type Deposit	  */
	public void setLIT_TypeDeposit (String LIT_TypeDeposit)
	{

		set_Value (COLUMNNAME_LIT_TypeDeposit, LIT_TypeDeposit);
	}

	/** Get Type Deposit.
		@return Type Deposit	  */
	public String getLIT_TypeDeposit () 
	{
		return (String)get_Value(COLUMNNAME_LIT_TypeDeposit);
	}

	/** Set VAT Credit.
		@param LIT_VAT_Credit VAT Credit	  */
	public void setLIT_VAT_Credit (BigDecimal LIT_VAT_Credit)
	{
		set_Value (COLUMNNAME_LIT_VAT_Credit, LIT_VAT_Credit);
	}

	/** Get VAT Credit.
		@return VAT Credit	  */
	public BigDecimal getLIT_VAT_Credit () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_VAT_Credit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set VAT Credit Total.
		@param LIT_VAT_Credit_Total VAT Credit Total	  */
	public void setLIT_VAT_Credit_Total (BigDecimal LIT_VAT_Credit_Total)
	{
		set_Value (COLUMNNAME_LIT_VAT_Credit_Total, LIT_VAT_Credit_Total);
	}

	/** Get VAT Credit Total.
		@return VAT Credit Total	  */
	public BigDecimal getLIT_VAT_Credit_Total () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_VAT_Credit_Total);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set VAT Debit.
		@param LIT_VAT_Debit VAT Debit	  */
	public void setLIT_VAT_Debit (BigDecimal LIT_VAT_Debit)
	{
		set_Value (COLUMNNAME_LIT_VAT_Debit, LIT_VAT_Debit);
	}

	/** Get VAT Debit.
		@return VAT Debit	  */
	public BigDecimal getLIT_VAT_Debit () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_VAT_Debit);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set VAT Debit Compensation.
		@param LIT_VAT_DebitCorr VAT Debit Compensation	  */
	public void setLIT_VAT_DebitCorr (BigDecimal LIT_VAT_DebitCorr)
	{
		set_Value (COLUMNNAME_LIT_VAT_DebitCorr, LIT_VAT_DebitCorr);
	}

	/** Get VAT Debit Compensation.
		@return VAT Debit Compensation	  */
	public BigDecimal getLIT_VAT_DebitCorr () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_VAT_DebitCorr);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set VAT Debit Total.
		@param LIT_VAT_Debit_Total VAT Debit Total	  */
	public void setLIT_VAT_Debit_Total (BigDecimal LIT_VAT_Debit_Total)
	{
		set_Value (COLUMNNAME_LIT_VAT_Debit_Total, LIT_VAT_Debit_Total);
	}

	/** Get VAT Debit Total.
		@return VAT Debit Total	  */
	public BigDecimal getLIT_VAT_Debit_Total () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_VAT_Debit_Total);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set LIT_VAT_Summary.
		@param LIT_VAT_Summary_ID LIT_VAT_Summary	  */
	public void setLIT_VAT_Summary_ID (int LIT_VAT_Summary_ID)
	{
		if (LIT_VAT_Summary_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LIT_VAT_Summary_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LIT_VAT_Summary_ID, Integer.valueOf(LIT_VAT_Summary_ID));
	}

	/** Get LIT_VAT_Summary.
		@return LIT_VAT_Summary	  */
	public int getLIT_VAT_Summary_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_VAT_Summary_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LIT_VAT_Summary_UU.
		@param LIT_VAT_Summary_UU LIT_VAT_Summary_UU	  */
	public void setLIT_VAT_Summary_UU (String LIT_VAT_Summary_UU)
	{
		set_Value (COLUMNNAME_LIT_VAT_Summary_UU, LIT_VAT_Summary_UU);
	}

	/** Get LIT_VAT_Summary_UU.
		@return LIT_VAT_Summary_UU	  */
	public String getLIT_VAT_Summary_UU () 
	{
		return (String)get_Value(COLUMNNAME_LIT_VAT_Summary_UU);
	}

	/** Set VAT Used.
		@param LIT_VAT_Used VAT Used	  */
	public void setLIT_VAT_Used (BigDecimal LIT_VAT_Used)
	{
		set_Value (COLUMNNAME_LIT_VAT_Used, LIT_VAT_Used);
	}

	/** Get VAT Used.
		@return VAT Used	  */
	public BigDecimal getLIT_VAT_Used () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_VAT_Used);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set VAT Used Other.
		@param LIT_VAT_UsedOther VAT Used Other	  */
	public void setLIT_VAT_UsedOther (BigDecimal LIT_VAT_UsedOther)
	{
		set_Value (COLUMNNAME_LIT_VAT_UsedOther, LIT_VAT_UsedOther);
	}

	/** Get VAT Used Other.
		@return VAT Used Other	  */
	public BigDecimal getLIT_VAT_UsedOther () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LIT_VAT_UsedOther);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Payment amount.
		@param PayAmt 
		Amount being paid
	  */
	public void setPayAmt (BigDecimal PayAmt)
	{
		set_Value (COLUMNNAME_PayAmt, PayAmt);
	}

	/** Get Payment amount.
		@return Amount being paid
	  */
	public BigDecimal getPayAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PayAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}