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

/** Generated Model for LIT_InvoiceIntrastat
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_LIT_InvoiceIntrastat extends PO implements I_LIT_InvoiceIntrastat, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210322L;

    /** Standard Constructor */
    public X_LIT_InvoiceIntrastat (Properties ctx, int LIT_InvoiceIntrastat_ID, String trxName)
    {
      super (ctx, LIT_InvoiceIntrastat_ID, trxName);
      /** if (LIT_InvoiceIntrastat_ID == 0)
        {
			setLIT_InvoiceIntrastat_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LIT_InvoiceIntrastat (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_LIT_InvoiceIntrastat[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Actual Amount.
		@param ActualAmt 
		The actual amount
	  */
	public void setActualAmt (BigDecimal ActualAmt)
	{
		set_Value (COLUMNNAME_ActualAmt, ActualAmt);
	}

	/** Get Actual Amount.
		@return The actual amount
	  */
	public BigDecimal getActualAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ActualAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Source Amount.
		@param AmtSource 
		Amount Balance in Source Currency
	  */
	public void setAmtSource (BigDecimal AmtSource)
	{
		set_ValueNoCheck (COLUMNNAME_AmtSource, AmtSource);
	}

	/** Get Source Amount.
		@return Amount Balance in Source Currency
	  */
	public BigDecimal getAmtSource () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtSource);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (org.compiere.model.I_C_Invoice)MTable.get(getCtx(), org.compiere.model.I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	public I_LIT_Intrastat getLIT_Intrastat() throws RuntimeException
    {
		return (I_LIT_Intrastat)MTable.get(getCtx(), I_LIT_Intrastat.Table_Name)
			.getPO(getLIT_Intrastat_ID(), get_TrxName());	}

	/** Set Intrastat.
		@param LIT_Intrastat_ID Intrastat	  */
	public void setLIT_Intrastat_ID (int LIT_Intrastat_ID)
	{
		if (LIT_Intrastat_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LIT_Intrastat_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LIT_Intrastat_ID, Integer.valueOf(LIT_Intrastat_ID));
	}

	/** Get Intrastat.
		@return Intrastat	  */
	public int getLIT_Intrastat_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_Intrastat_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Intra summary.
		@param LIT_InvoiceIntrastat_ID Intra summary	  */
	public void setLIT_InvoiceIntrastat_ID (int LIT_InvoiceIntrastat_ID)
	{
		if (LIT_InvoiceIntrastat_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LIT_InvoiceIntrastat_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LIT_InvoiceIntrastat_ID, Integer.valueOf(LIT_InvoiceIntrastat_ID));
	}

	/** Get Intra summary.
		@return Intra summary	  */
	public int getLIT_InvoiceIntrastat_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LIT_InvoiceIntrastat_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LIT_InvoiceIntrastat_UU.
		@param LIT_InvoiceIntrastat_UU LIT_InvoiceIntrastat_UU	  */
	public void setLIT_InvoiceIntrastat_UU (String LIT_InvoiceIntrastat_UU)
	{
		set_Value (COLUMNNAME_LIT_InvoiceIntrastat_UU, LIT_InvoiceIntrastat_UU);
	}

	/** Get LIT_InvoiceIntrastat_UU.
		@return LIT_InvoiceIntrastat_UU	  */
	public String getLIT_InvoiceIntrastat_UU () 
	{
		return (String)get_Value(COLUMNNAME_LIT_InvoiceIntrastat_UU);
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

	/** Set Weight.
		@param Weight 
		Weight of a product
	  */
	public void setWeight (BigDecimal Weight)
	{
		set_Value (COLUMNNAME_Weight, Weight);
	}

	/** Get Weight.
		@return Weight of a product
	  */
	public BigDecimal getWeight () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Weight);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}