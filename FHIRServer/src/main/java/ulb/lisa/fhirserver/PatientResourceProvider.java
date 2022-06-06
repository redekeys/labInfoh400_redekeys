package ulb.lisa.fhirserver;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.IResourceProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import ulb.lisa.infoh400.labs2022.controller.PatientJpaController;


public class PatientResourceProvider implements IResourceProvider {
    
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("infoh400_PU");
    private final PatientJpaController patientCtrl = new PatientJpaController(emfac);

    @Override
    public Class<Patient> getResourceType() {
        return Patient.class;
    }
    
    // Read method will be accessed by:
    // /FHIRServer/Patient/{id}    
    @Read()
    public Patient getResourceById(@IdParam IIdType pid){        
        Patient p = new Patient();
        p.addName().setFamily("Test");
        p.getNameFirstRep().addGiven("Test");
        p.setBirthDate(new Date());
        p.addTelecom().setValue("0123456789");
        p.setId(new IdType("Patient", "1234"));
        
        return p;
    }
    
    // Search method will be accessed by:
    // /FHIRServer/Patient?family={name}
    @Search()
    public List<Patient> getPatient(@RequiredParam(name = Patient.SP_FAMILY) StringParam name) { 
        Patient p = new Patient();
        p.addName().setFamily("Test");
        p.getNameFirstRep().addGiven("Test");
        p.setBirthDate(new Date());
        p.addTelecom().setValue("0123456789");
        p.setId(new IdType("Patient", "1234"));
        
        List<Patient> searchResults = new ArrayList();
        searchResults.add(p);

        return searchResults;
    }
}
