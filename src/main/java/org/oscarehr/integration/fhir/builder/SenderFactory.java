package org.oscarehr.integration.fhir.builder;
/**
 * Copyright (c) 2001-2002. Department of Family Medicine, McMaster University. All Rights Reserved.
 * This software is published under the GPL GNU General Public License.
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * This software was written for the
 * Department of Family Medicine
 * McMaster University
 * Hamilton
 * Ontario, Canada
 */

import org.oscarehr.common.dao.ClinicDAO;
import org.oscarehr.common.model.Clinic;
import org.oscarehr.integration.fhir.model.Sender;
import org.oscarehr.util.SpringUtils;
import oscar.OscarProperties;


public final class SenderFactory {

	// PHU = Public Health Unit. Used in Ontario to identify regional health units.
	private static String clinicPHU = OscarProperties.getInstance().getProperty("default_phu", "0" );
	private static String buildName = OscarProperties.getInstance().getProperty("buildtag", "[OSCAR BUILD]");
	private static String senderEndpoint = OscarProperties.getInstance().getProperty("ws_endpoint_url_base", "[OSCAR ENDPOINT]");
	private static ClinicDAO clinicDao = SpringUtils.getBean( ClinicDAO.class );
	private static String vendorName = "Oscar EMR";
	private static String softwareName = "Oscar";

	
	public static final Sender getSender() {
		Sender sender = new Sender( vendorName, softwareName, buildName, senderEndpoint );
		Clinic clinic = clinicDao.getClinic();
		sender.setClinic( clinic );
		sender.setClinicPHU( clinicPHU );
		return sender;
	}
	
}
