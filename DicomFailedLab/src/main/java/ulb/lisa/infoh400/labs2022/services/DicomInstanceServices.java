/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.infoh400.labs2022.services;

import com.pixelmed.dicom.AttributeList;
import com.pixelmed.dicom.AttributeTag;
import com.pixelmed.dicom.DicomException;
import com.pixelmed.dicom.TagFromName;
import com.pixelmed.display.SourceImage;
import com.pixelmed.network.DicomNetworkException;
import com.pixelmed.network.StorageSOPClassSCU;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.LogManager;
import ulb.lisa.infoh400.labs2022.controller.ImageJpaController;

/**
 *
 * @author Adrien Foucart
 */
public class DicomInstanceServices {
    private static final org.apache.log4j.Logger LOGGER = LogManager.getLogger(DicomInstanceServices.class.getName());
    
    private File instanceFile;
    
    public DicomInstanceServices(File instanceFile){
        this.instanceFile = instanceFile;
    }
    
    public DicomInstanceServices(ulb.lisa.infoh400.labs2022.model.Image image){
        String instanceUID = image.getInstanceuid();
        System.out.println(instanceUID);
        String pathname = "C:\\Users\\renau\\Desktop\\LAB_info_h_400\\PACS\\" + instanceUID;
        System.out.println(pathname);
        this.instanceFile = new File(pathname); 
    }
    
        
    public String getAttributesAsString(){        
        AttributeList al = new AttributeList();
        try {
            al.read(instanceFile);
        } catch (IOException | DicomException ex) {
            Logger.getLogger(DicomInstanceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        String out = "";

        for( AttributeTag tag: al.keySet() ){
            out += tag + " : " + al.get(tag).getDelimitedStringValuesOrEmptyString() + "\n";
        }

        return out;
    }

    public Image getImage() {
        try {
            SourceImage dicomImg = new SourceImage(instanceFile.toString());
            return dicomImg.getBufferedImage();
        } catch (IOException | DicomException ex) {
            System.out.print("Image VIDEEEEEEEEEEEE");
            LOGGER.error("Couldn't get Image from instance file.", ex);
        }
        
        return null;
    }

    public void saveInstanceToDatabase() {
        try {
            AttributeList al = new AttributeList();
            al.read(instanceFile);
            
            EntityManagerFactory emfac = Persistence.createEntityManagerFactory("infoh400_PU");
            ImageJpaController imageCtrl = new ImageJpaController(emfac);
            
            String instanceUID = al.get(TagFromName.SOPInstanceUID).getSingleStringValueOrEmptyString();
            String studyUID = al.get(TagFromName.StudyInstanceUID).getSingleStringValueOrEmptyString();
            String seriesUID = al.get(TagFromName.SeriesInstanceUID).getSingleStringValueOrEmptyString();
            String patientID = al.get(TagFromName.PatientID).getSingleStringValueOrEmptyString();
            
            ulb.lisa.infoh400.labs2022.model.Image image = new ulb.lisa.infoh400.labs2022.model.Image();
            image.setInstanceuid(instanceUID);
            image.setStudyuid(studyUID);
            image.setSeriesuid(seriesUID);
            image.setPatientDicomIdentifier(patientID);
            
            imageCtrl.create(image);
            LOGGER.info("Saved instance to the database (instanceUID=" + instanceUID + ").");
        } catch (IOException | DicomException ex) {
            LOGGER.error("Couldn't save DICOM instance to the database.", ex);
        }
    }

    public void saveToStoreSCP() {
        String host = "localhost";
        int port = 11112;
        String calledAETitle = "PACS";
        String callingAETitle = "HIS";
        String fileName = instanceFile.getAbsolutePath();
        
        AttributeList al = new AttributeList();
        try {
            al.read(instanceFile);
        } catch (IOException | DicomException ex) {
            Logger.getLogger(DicomInstanceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String affectedSOPClass = al.get(TagFromName.SOPClassUID).getSingleStringValueOrEmptyString();
        String affectedSOPInstance =al.get(TagFromName.SOPInstanceUID).getSingleStringValueOrEmptyString();
        
        int compressionLevel = 0;
        
        try {
            new StorageSOPClassSCU(host, port, calledAETitle, callingAETitle, fileName, affectedSOPClass, affectedSOPInstance, compressionLevel);
            /*
            Host == lieu d'envoit
            port == 11112 ici (port du pacs)
            */
        } catch (DicomNetworkException | DicomException | IOException ex) {
            Logger.getLogger(DicomInstanceServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
