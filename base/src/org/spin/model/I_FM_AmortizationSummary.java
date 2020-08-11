/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.										*
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net or http://www.adempiere.net/license.html         *
 *****************************************************************************/
package org.spin.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for FM_AmortizationSummary
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3
 */
public interface I_FM_AmortizationSummary 
{

    /** TableName=FM_AmortizationSummary */
    public static final String Table_Name = "FM_AmortizationSummary";

    /** AD_Table_ID=54757 */
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

    /** Column name CurrentCapitalAmt */
    public static final String COLUMNNAME_CurrentCapitalAmt = "CurrentCapitalAmt";

	/** Set Current Capital Amount	  */
	public void setCurrentCapitalAmt (BigDecimal CurrentCapitalAmt);

	/** Get Current Capital Amount	  */
	public BigDecimal getCurrentCapitalAmt();

    /** Column name CurrentDunningAmt */
    public static final String COLUMNNAME_CurrentDunningAmt = "CurrentDunningAmt";

	/** Set Current Dunning Amount	  */
	public void setCurrentDunningAmt (BigDecimal CurrentDunningAmt);

	/** Get Current Dunning Amount	  */
	public BigDecimal getCurrentDunningAmt();

    /** Column name CurrentDunningTaxAmt */
    public static final String COLUMNNAME_CurrentDunningTaxAmt = "CurrentDunningTaxAmt";

	/** Set Current Dunning Tax Amount	  */
	public void setCurrentDunningTaxAmt (BigDecimal CurrentDunningTaxAmt);

	/** Get Current Dunning Tax Amount	  */
	public BigDecimal getCurrentDunningTaxAmt();

    /** Column name CurrentFeeAmt */
    public static final String COLUMNNAME_CurrentFeeAmt = "CurrentFeeAmt";

	/** Set Current Fee Amount	  */
	public void setCurrentFeeAmt (BigDecimal CurrentFeeAmt);

	/** Get Current Fee Amount	  */
	public BigDecimal getCurrentFeeAmt();

    /** Column name CurrentInterestAmt */
    public static final String COLUMNNAME_CurrentInterestAmt = "CurrentInterestAmt";

	/** Set Current Interest Amount	  */
	public void setCurrentInterestAmt (BigDecimal CurrentInterestAmt);

	/** Get Current Interest Amount	  */
	public BigDecimal getCurrentInterestAmt();

    /** Column name CurrentTaxAmt */
    public static final String COLUMNNAME_CurrentTaxAmt = "CurrentTaxAmt";

	/** Set Current Tax Amount	  */
	public void setCurrentTaxAmt (BigDecimal CurrentTaxAmt);

	/** Get Current Tax Amount	  */
	public BigDecimal getCurrentTaxAmt();

    /** Column name DateDoc */
    public static final String COLUMNNAME_DateDoc = "DateDoc";

	/** Set Document Date.
	  * Date of the Document
	  */
	public void setDateDoc (Timestamp DateDoc);

	/** Get Document Date.
	  * Date of the Document
	  */
	public Timestamp getDateDoc();

    /** Column name FM_Account_ID */
    public static final String COLUMNNAME_FM_Account_ID = "FM_Account_ID";

	/** Set Financial Account	  */
	public void setFM_Account_ID (int FM_Account_ID);

	/** Get Financial Account	  */
	public int getFM_Account_ID();

	public org.spin.model.I_FM_Account getFM_Account() throws RuntimeException;

    /** Column name FM_AmortizationSummary_ID */
    public static final String COLUMNNAME_FM_AmortizationSummary_ID = "FM_AmortizationSummary_ID";

	/** Set Loan Amortization Summary	  */
	public void setFM_AmortizationSummary_ID (int FM_AmortizationSummary_ID);

	/** Get Loan Amortization Summary	  */
	public int getFM_AmortizationSummary_ID();

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

    /** Column name UUID */
    public static final String COLUMNNAME_UUID = "UUID";

	/** Set Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID);

	/** Get Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public String getUUID();
}
