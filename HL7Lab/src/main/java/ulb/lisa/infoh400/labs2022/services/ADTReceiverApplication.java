/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.lisa.infoh400.labs2022.services;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ADT_A01;
import ca.uhn.hl7v2.model.v23.segment.PID;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import java.io.IOException;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ulb.lisa.infoh400.labs2022.controller.PatientJpaController;
import ulb.lisa.infoh400.labs2022.controller.PersonJpaController;
import ulb.lisa.infoh400.labs2022.model.Patient;
import ulb.lisa.infoh400.labs2022.model.Person;

/**
 *
 * @author renau
 */
public class ADTReceiverApplication implements ReceivingApplication<Message> {

    public ADTReceiverApplication() {
    }

    @Override
    public Message processMessage(Message t, Map<String, Object> map) throws ReceivingApplicationException, HL7Exception {
        System.out.println("Hello Received msg");
        /*ADT_A01 msg = (ADT_A01) t; ///marche pas snif mais affiche aucune erreur wtf
        System.out.println("Buggin ADT");
        PID pid = msg.getPID();
        System.out.println("Buggin Here");
        Person adtP = new Person();
        
        System.out.println("Bfr set");
        
        adtP.setFamilyname(pid.getPatientName(0).getFamilyName().getValue());
        adtP.setFirstname(pid.getPatientName(0).getGivenName().getValue());
        adtP.setDateofbirth(pid.getDateOfBirth().getTimeOfAnEvent().getValueAsDate());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("infoh400_PU");
        PersonJpaController personCtrl = new PersonJpaController(emf);
        
        System.out.println("DUplic");
        
        Person duplicate = personCtrl.findDuplicate(adtP);
        
        System.out.println("Before IF");
        
        if (duplicate == null){
           PatientJpaController patientCtrl = new PatientJpaController(emf);
           
           personCtrl.create(adtP);
           Patient pat = new Patient();
           pat.setIdperson(adtP);
           pat.setStatus("Active");
           patientCtrl.create(pat);
           System.out.println("ADDED");
        }
        else {
            System.out.println("Already ADDED");
        }*/
        
        String encodedMessage = new DefaultHapiContext().getPipeParser().encode(t);
        System.out.println("Received message:\n" + encodedMessage + "\n\n");
          // Now generate a simple acknowledgment message and return it
        try {
            return t.generateACK();
        } catch (IOException e) {
            throw new HL7Exception(e);
        }
    }

    @Override
    public boolean canProcess(Message t) {
        return true;
    }
    
}
