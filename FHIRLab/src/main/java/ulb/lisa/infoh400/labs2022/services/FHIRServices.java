/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.lisa.infoh400.labs2022.services;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import java.util.ArrayList;
import java.util.List;
import org.hl7.fhir.r4.model.Bundle;
import ulb.lisa.infoh400.labs2022.model.Patient;
import ulb.lisa.infoh400.labs2022.model.Person;

/**
 *
 * @author renau
 */
public class FHIRServices {
    
    public Patient getPatient (org.hl7.fhir.r4.model.Patient fhirPatient){
        Patient patient = new Patient();
        Person person = new Person();
        person.setDateofbirth(fhirPatient.getBirthDate());
        person.setFamilyname(fhirPatient.getNameFirstRep().getFamily());
        person.setFirstname(fhirPatient.getNameFirstRep().getGivenAsSingleString());
        patient.setIdperson(person);
        patient.setStatus("Active");
        
        return patient;   
    }
    
    
    public List <Patient> searchPatients(String host, String familyName){
        ArrayList <Patient> patients = new ArrayList();
        
        FhirContext ctx = FhirContext.forR4();
        
        IGenericClient client = ctx.newRestfulGenericClient(host);
        
        Bundle results = client
            .search()
            .forResource(org.hl7.fhir.r4.model.Patient.class)
            .where(org.hl7.fhir.r4.model.Patient.FAMILY.matches().value(familyName))
            .returnBundle(Bundle.class)
            .execute();
        
        System.out.println("Found " + results.getEntry().size() + " patients named 'duck'");
        
        for (Bundle.BundleEntryComponent entry : results.getEntry()){
            patients.add(getPatient((org.hl7.fhir.r4.model.Patient) entry.getResource()));
        }
        
        
        return patients;
    }
}
