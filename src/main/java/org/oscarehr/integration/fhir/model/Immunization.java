package org.oscarehr.integration.fhir.model;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.DateType;
import org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus;
import org.hl7.fhir.dstu3.model.Reference;
import org.oscarehr.common.model.Prevention;
import org.oscarehr.integration.fhir.interfaces.ImmunizationInterface;
import org.oscarehr.integration.fhir.manager.OscarFhirConfigurationManager;


/*
  {doco
  "resourceType" : "Immunization",
  // from Resource: id, meta, implicitRules, and language
  // from DomainResource: text, contained, extension, and modifierExtension
  "identifier" : [{ Identifier }], // Business identifier
  "status" : "<code>", // R!  completed | entered-in-error
  "notGiven" : <boolean>, // R!  Flag for whether immunization was given
  "vaccineCode" : { CodeableConcept }, // R!  Vaccine product administered
  "patient" : { Reference(Patient) }, // R!  Who was immunized
  "encounter" : { Reference(Encounter) }, // Encounter administered as part of
  "date" : "<dateTime>", // Vaccination administration date
  "primarySource" : <boolean>, // R!  Indicates context the data was recorded in
  "reportOrigin" : { CodeableConcept }, // Indicates the source of a secondarily reported record
  "location" : { Reference(Location) }, // Where vaccination occurred
  "manufacturer" : { Reference(Organization) }, // Vaccine manufacturer
  "lotNumber" : "<string>", // Vaccine lot number
  "expirationDate" : "<date>", // Vaccine expiration date
  "site" : { CodeableConcept }, // Body site vaccine  was administered
  "route" : { CodeableConcept }, // How vaccine entered body
  "doseQuantity" : { Quantity(SimpleQuantity) }, // Amount of vaccine administered
  "practitioner" : [{ // Who performed event
    "role" : { CodeableConcept }, // What type of performance was done
    "actor" : { Reference(Practitioner) } // R!  Individual who was performing
  }],
  "note" : [{ Annotation }], // Vaccination notes
  "explanation" : { // Administration/non-administration reasons
    "reason" : [{ CodeableConcept }], // Why immunization occurred
    "reasonNotGiven" : [{ CodeableConcept }] // Why immunization did not occur
  },
  "reaction" : [{ // Details of a reaction that follows immunization
    "date" : "<dateTime>", // When reaction started
    "detail" : { Reference(Observation) }, // Additional information on reaction
    "reported" : <boolean> // Indicates self-reported reaction
  }],
  "vaccinationProtocol" : [{ // What protocol was followed
    "doseSequence" : "<positiveInt>", // Dose number within series
    "description" : "<string>", // Details of vaccine protocol
    "authority" : { Reference(Organization) }, // Who is responsible for protocol
    "series" : "<string>", // Name of vaccine series
    "seriesDoses" : "<positiveInt>", // Recommended number of doses for immunity
    "targetDisease" : [{ CodeableConcept }], // R!  Disease immunized against
    "doseStatus" : { CodeableConcept }, // R!  Indicates if dose counts towards immunity
    "doseStatusReason" : { CodeableConcept } // Why dose does (not) count
  }]
}
 */

/**
 * 
 * constraint: Prevention must implement the ImmunizationInterface.
 *
 */
public class Immunization 
extends OscarFhirResource< org.hl7.fhir.dstu3.model.Immunization, org.oscarehr.common.model.Prevention >  {

	private static final Pattern measurementValuePattern = Pattern.compile("^([0-9])*(\\.)*([0-9])*");

	public Immunization( ImmunizationInterface<Prevention> from ){
		super( new org.hl7.fhir.dstu3.model.Immunization(), (Prevention) from );
	}
	
	public Immunization( ImmunizationInterface<Prevention> from,  OscarFhirConfigurationManager configurationManager ){
		super( new org.hl7.fhir.dstu3.model.Immunization(), (Prevention) from, configurationManager );
	}

	public Immunization( org.hl7.fhir.dstu3.model.Immunization from ) {
		super( new Prevention(), from );
	}

	@Override
	protected void mapAttributes( org.oscarehr.common.model.Prevention prevention ) {
		setAdministrationDate( prevention );
		setVaccineCode( prevention );
		setRefused( prevention );
		setLotNumber( prevention );
		setExpirationDate( prevention );
		setSite( prevention );
		setDose( prevention );
		setRoute( prevention );
		setAnnotation( prevention );
	}

	@Override
	protected final void mapAttributes(org.hl7.fhir.dstu3.model.Immunization immunization ) {
		
		//mandatory
		setStatus( immunization );
		setAdministrationDate( immunization );
		setVaccineCode( immunization );
		setRefused( immunization );
		setLotNumber( immunization );
		setExpirationDate( immunization );
		setSite( immunization );
		setDose( immunization );
		setRoute( immunization );
		setReason( immunization );
		setIsPrimarySource( immunization );
		
		// optional
		if( include( OptionalFHIRAttribute.annotation ) ) {
			setAnnotation( immunization );
		}

		if( ! getOscarResource().isPrimarySource() ) {
			setReportOrigin( immunization );
		}
	}
	
	/**
	 * Returns the Oscar patient Id for whom this immunization was for.
	 */
	public int getDemographicNo() {
		return getOscarResource().getDemographicId();
	}

	@Override
	protected final void setId( org.hl7.fhir.dstu3.model.Immunization fhirResource ) {
		if( getOscarResource() != null && getOscarResource().getId() != null ) {
			fhirResource.setId( getOscarResource().getId() + "" );
		} else {
			super.setId(fhirResource);
		}
	}

	/**
	 * Status of the immunization. Options are Completed or NULL
	 * When this status is coded as NULL it is assumed that the immunization was refused or 
	 * omitted.
	 * It is assumed that this method will never consume Preventions coded as deleted.
	 */
	private void setStatus( org.hl7.fhir.dstu3.model.Immunization immunization  ) {

		ImmunizationStatus immunizationStatus = ImmunizationStatus.NULL;

		if( ! getOscarResource().isNever() && ! getOscarResource().isRefused() ) {
			immunizationStatus = ImmunizationStatus.COMPLETED;
		}
		immunization.setStatus( immunizationStatus );
	}

	/**
	 * The extension URI for the administration date indicates if the immunization date was 
	 * estimated.
	 * It is assumed that the date is estimated if the vaccine was done externally.
	 */
	private void setAdministrationDate( org.hl7.fhir.dstu3.model.Immunization immunization ){

		// immunization.setDate( getOscarResource().getPreventionDate() );	
		BooleanType estimated = new BooleanType();
		estimated.setValue( getOscarResource().isCompletedExternally() );

		DateType dateType = new DateType();
		dateType.setValue(getOscarResource().getPreventionDate());
		dateType.addExtension().setUrl("https://ehealthontario.ca/API/FHIR/StructureDefinition/ca-on-extension-estimated-date").setValue( estimated );
		
		immunization.setDate( dateType.getValue() );
		
		immunization.addExtension( dateType.getExtensionFirstRep() );

	}

	private void setAdministrationDate( ImmunizationInterface<Prevention> prevention ){
		prevention.setImmunizationDate( getFhirResource().getDate() );
	}

	/**
	 * SNOMED is a fixed (static) system in Oscar.
	 */
	private void setVaccineCode( org.hl7.fhir.dstu3.model.Immunization immunization ){
		immunization.getVaccineCode().addCoding()
		.setSystem("http://snomed.info/sct")
		.setCode( getOscarResource().getVaccineCode() )
		.setDisplay( getOscarResource().getManufacture() + " " + getOscarResource().getName() );
	}

	private void setVaccineCode( ImmunizationInterface<Prevention> prevention ){
		prevention.setVaccineCode( getFhirResource().getVaccineCode().getCodingFirstRep().getCode() );
	}

	private void setRefused( org.hl7.fhir.dstu3.model.Immunization immunization ){
		immunization.setNotGiven( getOscarResource().getImmunizationRefused() );
	}

	private void setRefused(  ImmunizationInterface<Prevention> prevention ){
		prevention.setImmunizationRefused( getFhirResource().getNotGiven() );
	}

	private void setLotNumber( org.hl7.fhir.dstu3.model.Immunization immunization ){
		immunization.setLotNumber( getOscarResource().getLotNo() );
	}

	private void setLotNumber(  ImmunizationInterface<Prevention> prevention ){
		prevention.setLotNo( getFhirResource().getLotNumber() );
	}

	private void setExpirationDate( org.hl7.fhir.dstu3.model.Immunization immunization ){
		immunization.setExpirationDate(  getOscarResource().getExpiryDate() );
	}

	private void setExpirationDate(  ImmunizationInterface<Prevention> prevention ){
		prevention.setExpiryDate( getFhirResource().getExpirationDate() );
	}

	/**
	 * This is the body part - or location - the immunization was given.
	 */
	private void setSite( org.hl7.fhir.dstu3.model.Immunization immunization ){
		immunization.getSite().setText( getOscarResource().getSite() );
	}

	private void setSite(  ImmunizationInterface<Prevention> prevention ){
		prevention.setSite( getFhirResource().getSite().getText() );
	}

	private void setDose( org.hl7.fhir.dstu3.model.Immunization immunization ){
		String dose = getOscarResource().getDose();
		Matcher matcher = measurementValuePattern.matcher(dose);
		String number = "";
		Double value = 0.0;
		if( matcher.find() ) {
			number = matcher.group(0);
			if( ! number.isEmpty() ) {
				value = Double.parseDouble( number );
			}
		}
		String unit = dose.replace(number, "").trim();
		immunization.getDoseQuantity().setValue(value).setUnit(unit);
	}

	private void setDose(  ImmunizationInterface<Prevention> prevention ){
		prevention.setDose( getFhirResource().getDoseQuantity().getValue().toString() + " " + getFhirResource().getDoseQuantity().getUnit() );
	}

	private void setRoute( org.hl7.fhir.dstu3.model.Immunization immunization ){
		immunization.getRoute().addCoding()
		.setSystem("http://snomed.info/sct")
		.setCode( getOscarResource().getRoute() )
		.setDisplay( getOscarResource().getRoute() );		
	}

	private void setRoute( ImmunizationInterface<Prevention> prevention ){
		prevention.setSite( getFhirResource().getRoute().getText() );
	}

	private void setAnnotation( org.hl7.fhir.dstu3.model.Immunization immunization ){
		immunization.addNote().setText( getOscarResource().getImmunizationRefusedReason() );
		immunization.addNote().setText( getOscarResource().getComment() );
	}

	private void setAnnotation(  ImmunizationInterface<Prevention> prevention ){
		StringBuilder note = new StringBuilder("");
		note.append( getFhirResource().getLocation() );

		for( org.hl7.fhir.dstu3.model.Annotation annotation : getFhirResource().getNote() ) {
			note.append( annotation.getText() );
		}

		prevention.setComment( note.toString() );
	}
	
	/**
	 * For now the immunization reason is hard coded to routine.
	 */
	private void setReason( org.hl7.fhir.dstu3.model.Immunization immunization ) {
		immunization.getExplanation().addReason().addCoding()
			.setSystem("https://ehealthontario.ca/API/FHIR/NamingSystem/ca-on-immunizations-reason")
			.setCode( "routine" )
			.setDisplay( "Routine" );
	}
	
	private void setIsPrimarySource( org.hl7.fhir.dstu3.model.Immunization immunization ) {	
		immunization.setPrimarySource( getOscarResource().isPrimarySource() );
	}
	
	/**
	 * Where was the immunization given if this is not the primary source. 
	 * Not very detailed in Oscar, so for now, unknown is given.
	 */
	private void setReportOrigin( org.hl7.fhir.dstu3.model.Immunization immunization ) {		
		immunization.getReportOrigin().addCoding()
			.setSystem("http://hl7.org/fhir/immunization-origin")
			.setCode("provider")
			.setDisplay("other provider");		
	}
	
	/**
	 * All practitioners added here are ALWAYS the administering provider.
	 * This is the provider that gave the immunization.
	 */
	public void addPerformingPractitioner( Reference reference ) {
		getFhirResource().addPractitioner()
			.setActor( reference )
			.getRole().addCoding()
				.setSystem("http://hl7.org/fhir/v2/0443")
				.setCode("AP")
				.setDisplay("AdministeringProvider");
	}
	
	/**
	 * This will add a reference link to any involved practitioner. 
	 * Not to be confused with administering provider.
	 */
	public void addPractitioner( Reference reference ) {
		getFhirResource().addPractitioner().setActor( reference );
	}
	
	/**
	 * This is a reference link to whom the immunization was given to. 
	 */
	public void setPatientReference( Reference reference ) {
		getFhirResource().setPatient( reference );
	}

}
