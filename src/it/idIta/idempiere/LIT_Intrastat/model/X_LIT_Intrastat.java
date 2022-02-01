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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for LIT_Intrastat
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_LIT_Intrastat extends PO implements I_LIT_Intrastat, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210322L;

    /** Standard Constructor */
    public X_LIT_Intrastat (Properties ctx, int LIT_Intrastat_ID, String trxName)
    {
      super (ctx, LIT_Intrastat_ID, trxName);
      /** if (LIT_Intrastat_ID == 0)
        {
			setLIT_Intrastat_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_LIT_Intrastat (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org 
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
      StringBuilder sb = new StringBuilder ("X_LIT_Intrastat[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
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

	/** Set Manufactured.
		@param IsManufactured 
		This product is manufactured
	  */
	public void setIsManufactured (boolean IsManufactured)
	{
		set_Value (COLUMNNAME_IsManufactured, Boolean.valueOf(IsManufactured));
	}

	/** Get Manufactured.
		@return This product is manufactured
	  */
	public boolean isManufactured () 
	{
		Object oo = get_Value(COLUMNNAME_IsManufactured);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

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

	/** Set LIT_Intrastat_UU.
		@param LIT_Intrastat_UU LIT_Intrastat_UU	  */
	public void setLIT_Intrastat_UU (String LIT_Intrastat_UU)
	{
		set_Value (COLUMNNAME_LIT_Intrastat_UU, LIT_Intrastat_UU);
	}

	/** Get LIT_Intrastat_UU.
		@return LIT_Intrastat_UU	  */
	public String getLIT_Intrastat_UU () 
	{
		return (String)get_Value(COLUMNNAME_LIT_Intrastat_UU);
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

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getValue());
    }
}