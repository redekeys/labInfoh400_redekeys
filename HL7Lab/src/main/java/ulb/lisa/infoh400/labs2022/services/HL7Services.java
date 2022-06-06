/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.lisa.infoh400.labs2022.services;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ADT_A01;
import ca.uhn.hl7v2.model.v23.segment.MSH;
import ca.uhn.hl7v2.model.v23.segment.PID;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ulb.lisa.infoh400.labs2022.model.Patient;

/**
 *
 * @author renau
 */
public class HL7Services {
    
    public ADT_A01 create_ADT_A01 (Patient patient){
        ADT_A01 adt = null;
        try {
            adt = new ADT_A01();
            adt.initQuickstart("ADT", "A01", "P");
            
            MSH mshSegment = adt.getMSH();
            mshSegment.getSendingApplication().getNamespaceID().setValue("HIS");
            mshSegment.getSequenceNumber().setValue("123");
            
            // Populate the PID Segment
            PID pid = adt.getPID();
            pid.getPatientName(0).getFamilyName().setValue(patient.getIdperson().getFamilyname());
            pid.getPatientName(0).getGivenName().setValue(patient.getIdperson().getFirstname());
            pid.getPatientIDInternalID(0).getID().setValue(String.valueOf(patient.getIdpatient()));
          
            
        } catch (HL7Exception | IOException ex) {
            Logger.getLogger(HL7Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adt;
    }
    
    public void send_ADT_01(ADT_A01 msg, String host, int port){
        //Créer la connection comme dans l'app Hapi test Panel
        HapiContext context = new DefaultHapiContext();
        Connection connection;
        try {
            connection = context.newClient(host, port, false);
            Initiator initiator = connection.getInitiator();
            Message response = initiator.sendAndReceive(msg);
            
            Parser p = context.getPipeParser();
            String responseString = p.encode(response);
            System.out.println("Received response:\n" + responseString);
            
        } catch (HL7Exception | LLPException | IOException ex) {
            Logger.getLogger(HL7Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startServer() {
        int port = 61657; //cf Hapi Tesnt Panel
        
        HapiContext context = new DefaultHapiContext();
        HL7Service server = context.newServer(port, false);
        
        ReceivingApplication<Message> handler = new ADTReceiverApplication();
        
        server.registerApplication("ADT", "A01", handler);
        
        try {
            server.startAndWait();
        } catch (InterruptedException ex) {
            Logger.getLogger(HL7Services.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
