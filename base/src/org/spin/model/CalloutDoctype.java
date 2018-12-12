/*************************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                              *
 * This program is free software; you can redistribute it and/or modify it    		 *
 * under the terms version 2 or later of the GNU General Public License as published *
 * by the Free Software Foundation. This program is distributed in the hope   		 *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied 		 *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           		 *
 * See the GNU General Public License for more details.                       		 *
 * You should have received a copy of the GNU General Public License along    		 *
 * with this program; if not, write to the Free Software Foundation, Inc.,    		 *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     		 *
 * For the text or an alternative of this public license, you may reach us    		 *
 * Copyright (C) 2012-2018 E.R.P. Consultores y Asociados, S.A. All Rights Reserved. *
 * Contributor(s): German Anzola www.erpya.com				  		                 *
 *************************************************************************************/
package org.spin.model;

import java.util.Properties;

import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MDocType;
import org.compiere.util.Env;

public class CalloutDoctype extends CalloutEngine {

	public String ApprovedRequired(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {
		int doctypeID =0 ;
		String aproved = "";
		if(mField.getValue() != null)
			doctypeID=(int)mField.getValue();
		
		MDocType  doctype = new MDocType(ctx,doctypeID, null);
		aproved = doctype.get_ValueAsString("IsCanApprovedRequired");

		Env.setContext(ctx, WindowNo, "IsCanApprovedRequired", aproved);
		return "";
	}

}
