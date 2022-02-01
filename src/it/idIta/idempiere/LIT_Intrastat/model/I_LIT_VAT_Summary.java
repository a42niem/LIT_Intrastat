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
package it.idIta.idempiere.LIT_Intrastat.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for LIT_VAT_Summary
 *  @author iDempiere (generated) 
 *  @version Release 6.2
 */
@SuppressWarnings("all")
public interface I_LIT_VAT_Summary 
{

    /** TableName=LIT_VAT_Summary */
    public static final String Table_Name = "LIT_VAT_Summary";

    /** AD_Table_ID=1000035 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DepositAmt */
    public static final String COLUMNNAME_DepositAmt = "DepositAmt";

	/** Set Deposit Amount	  */
	public void setDepositAmt (BigDecimal DepositAmt);

	/** Get Deposit Amount	  */
	public BigDecimal getDepositAmt();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DifferenceAmt */
    public static final String COLUMNNAME_DifferenceAmt = "DifferenceAmt";

	/** Set Difference.
	  * Difference Amount
	  */
	public void setDifferenceAmt (BigDecimal DifferenceAmt);

	/** Get Difference.
	  * Difference Amount
	  */
	public BigDecimal getDifferenceAmt();

    /** Column name DueAmt */
    public static final String COLUMNNAME_DueAmt = "DueAmt";

	/** Set Amount due.
	  * Amount of the payment due
	  */
	public void setDueAmt (BigDecimal DueAmt);

	/** Get Amount due.
	  * Amount of the payment due
	  */
	public BigDecimal getDueAmt();

    /** Column name GL_Journal_ID */
    public static final String COLUMNNAME_GL_Journal_ID = "GL_Journal_ID";

	/** Set Journal.
	  * General Ledger Journal
	  */
	public void setGL_Journal_ID (int GL_Journal_ID);

	/** Get Journal.
	  * General Ledger Journal
	  */
	public int getGL_Journal_ID();

	public org.compiere.model.I_GL_Journal getGL_Journal() throws RuntimeException;

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsComplete */
    public static final String COLUMNNAME_IsComplete = "IsComplete";

	/** Set Complete.
	  * It is complete
	  */
	public void setIsComplete (boolean IsComplete);

	/** Get Complete.
	  * It is complete
	  */
	public boolean isComplete();

    /** Column name LIT_TaxBaseAmt_PO */
    public static final String COLUMNNAME_LIT_TaxBaseAmt_PO = "LIT_TaxBaseAmt_PO";

	/** Set Tax base Amount PO.
	  * Base for calculating the tax amount
	  */
	public void setLIT_TaxBaseAmt_PO (BigDecimal LIT_TaxBaseAmt_PO);

	/** Get Tax base Amount PO.
	  * Base for calculating the tax amount
	  */
	public BigDecimal getLIT_TaxBaseAmt_PO();

    /** Column name LIT_TaxBaseAmt_SO */
    public static final String COLUMNNAME_LIT_TaxBaseAmt_SO = "LIT_TaxBaseAmt_SO";

	/** Set Tax base Amount SO.
	  * Base for calculating the tax amount
	  */
	public void setLIT_TaxBaseAmt_SO (BigDecimal LIT_TaxBaseAmt_SO);

	/** Get Tax base Amount SO.
	  * Base for calculating the tax amount
	  */
	public BigDecimal getLIT_TaxBaseAmt_SO();

    /** Column name LIT_TypeDeposit */
    public static final String COLUMNNAME_LIT_TypeDeposit = "LIT_TypeDeposit";

	/** Set Type Deposit	  */
	public void setLIT_TypeDeposit (String LIT_TypeDeposit);

	/** Get Type Deposit	  */
	public String getLIT_TypeDeposit();

    /** Column name LIT_VAT_Credit */
    public static final String COLUMNNAME_LIT_VAT_Credit = "LIT_VAT_Credit";

	/** Set VAT Credit	  */
	public void setLIT_VAT_Credit (BigDecimal LIT_VAT_Credit);

	/** Get VAT Credit	  */
	public BigDecimal getLIT_VAT_Credit();

    /** Column name LIT_VAT_Credit_Total */
    public static final String COLUMNNAME_LIT_VAT_Credit_Total = "LIT_VAT_Credit_Total";

	/** Set VAT Credit Total	  */
	public void setLIT_VAT_Credit_Total (BigDecimal LIT_VAT_Credit_Total);

	/** Get VAT Credit Total	  */
	public BigDecimal getLIT_VAT_Credit_Total();

    /** Column name LIT_VAT_Debit */
    public static final String COLUMNNAME_LIT_VAT_Debit = "LIT_VAT_Debit";

	/** Set VAT Debit	  */
	public void setLIT_VAT_Debit (BigDecimal LIT_VAT_Debit);

	/** Get VAT Debit	  */
	public BigDecimal getLIT_VAT_Debit();

    /** Column name LIT_VAT_DebitCorr */
    public static final String COLUMNNAME_LIT_VAT_DebitCorr = "LIT_VAT_DebitCorr";

	/** Set VAT Debit Compensation	  */
	public void setLIT_VAT_DebitCorr (BigDecimal LIT_VAT_DebitCorr);

	/** Get VAT Debit Compensation	  */
	public BigDecimal getLIT_VAT_DebitCorr();

    /** Column name LIT_VAT_Debit_Total */
    public static final String COLUMNNAME_LIT_VAT_Debit_Total = "LIT_VAT_Debit_Total";

	/** Set VAT Debit Total	  */
	public void setLIT_VAT_Debit_Total (BigDecimal LIT_VAT_Debit_Total);

	/** Get VAT Debit Total	  */
	public BigDecimal getLIT_VAT_Debit_Total();

    /** Column name LIT_VAT_Summary_ID */
    public static final String COLUMNNAME_LIT_VAT_Summary_ID = "LIT_VAT_Summary_ID";

	/** Set LIT_VAT_Summary	  */
	public void setLIT_VAT_Summary_ID (int LIT_VAT_Summary_ID);

	/** Get LIT_VAT_Summary	  */
	public int getLIT_VAT_Summary_ID();

    /** Column name LIT_VAT_Summary_UU */
    public static final String COLUMNNAME_LIT_VAT_Summary_UU = "LIT_VAT_Summary_UU";

	/** Set LIT_VAT_Summary_UU	  */
	public void setLIT_VAT_Summary_UU (String LIT_VAT_Summary_UU);

	/** Get LIT_VAT_Summary_UU	  */
	public String getLIT_VAT_Summary_UU();

    /** Column name LIT_VAT_Used */
    public static final String COLUMNNAME_LIT_VAT_Used = "LIT_VAT_Used";

	/** Set VAT Used	  */
	public void setLIT_VAT_Used (BigDecimal LIT_VAT_Used);

	/** Get VAT Used	  */
	public BigDecimal getLIT_VAT_Used();

    /** Column name LIT_VAT_UsedOther */
    public static final String COLUMNNAME_LIT_VAT_UsedOther = "LIT_VAT_UsedOther";

	/** Set VAT Used Other	  */
	public void setLIT_VAT_UsedOther (BigDecimal LIT_VAT_UsedOther);

	/** Get VAT Used Other	  */
	public BigDecimal getLIT_VAT_UsedOther();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name PayAmt */
    public static final String COLUMNNAME_PayAmt = "PayAmt";

	/** Set Payment amount.
	  * Amount being paid
	  */
	public void setPayAmt (BigDecimal PayAmt);

	/** Get Payment amount.
	  * Amount being paid
	  */
	public BigDecimal getPayAmt();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
