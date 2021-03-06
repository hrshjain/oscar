package org.oscarehr.integration.fhir.api;
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

import java.util.List;

import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.MessageHeader;
import org.oscarehr.integration.fhir.builder.FhirBundleBuilder;
import org.oscarehr.integration.fhir.manager.OscarFhirConfigurationManager;
import org.oscarehr.integration.fhir.manager.OscarFhirResourceManager;
import org.oscarehr.integration.fhir.model.OscarFhirResource;
import org.oscarehr.integration.fhir.resources.constants.FhirDestination;
import org.oscarehr.integration.fhir.resources.constants.Region;
import org.oscarehr.util.LoggedInInfo;


public class DHIR {
	
	private static final FhirDestination destination = FhirDestination.DHIR;
	private static final Region region = Region.ON;

	/**
	 * Get the FhirBundleBuilder Object.
	 * Useful for adding additional resources or adjusting the message structure.
	 */
	public static synchronized FhirBundleBuilder getFhirBundleBuilder( LoggedInInfo loggedInInfo, int demographicNo ) {
		OscarFhirConfigurationManager configurationManager = new OscarFhirConfigurationManager( loggedInInfo, destination, region );
		org.oscarehr.integration.fhir.model.Patient patient = OscarFhirResourceManager.getPatientByDemographicNumber( configurationManager, demographicNo );
		
		// the patient is the focus resource for this type of bundle
		// A referrence link will be inserted into the MessageHeader.focus
		patient.setFocusResource( Boolean.TRUE );
		
		// intercept the default clinic PHU with the PHU from the Patient resource.
		String phu = patient.getOscarResource().getPHU();
		if( phu != null && ! phu.isEmpty()) {
			configurationManager.getSender().setClinicPHU( phu );
		}
		
		List<OscarFhirResource<?,?>> resourceList = OscarFhirResourceManager.getImmunizationResourceBundle( configurationManager, patient );	
		FhirBundleBuilder fhirBundleBuilder = new FhirBundleBuilder( configurationManager );
		fhirBundleBuilder.addResources(resourceList);
		return fhirBundleBuilder;
	}
	
	/**
	 * Get the FHIR Resource Bundle.
	 * Useful if needing to extract and send specific resources separately from the bundle. 
	 * ie: send the MessageHeader as a reference back to this bundle resource.
	 */
	public static Bundle getBundleResource( LoggedInInfo loggedInInfo, int demographicNo ) {
		return DHIR.getFhirBundleBuilder( loggedInInfo, demographicNo ).getBundle();
	}
	
	/**
	 * Get the raw JSON string of the entire Bundle message.
	 * For a single transmission payload.
	 */
	public static String getMessageJSON( LoggedInInfo loggedInInfo, int demographicNo ) {
		return DHIR.getFhirBundleBuilder( loggedInInfo, demographicNo ).getMessageJson();
	}
	
	/**
	 * The Message Header from this bundle message. 
	 * This is useful for retrieving the destination endpoint, etc...
	 */
	public static MessageHeader getMessageHeader( LoggedInInfo loggedInInfo, int demographicNo ) {
		return DHIR.getFhirBundleBuilder( loggedInInfo, demographicNo ).getMessageHeader();
	}
	

}
