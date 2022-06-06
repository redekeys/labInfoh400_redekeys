/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.infoh400.labs2022.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ulb.lisa.infoh400.labs2022.auth.Authentication;
import ulb.lisa.infoh400.labs2022.controller.DoctorJpaController;
import ulb.lisa.infoh400.labs2022.controller.ImageJpaController;
import ulb.lisa.infoh400.labs2022.controller.PatientJpaController;
import ulb.lisa.infoh400.labs2022.controller.exceptions.IllegalOrphanException;
import ulb.lisa.infoh400.labs2022.controller.exceptions.NonexistentEntityException;
import ulb.lisa.infoh400.labs2022.model.Doctor;
import ulb.lisa.infoh400.labs2022.model.Image;
import ulb.lisa.infoh400.labs2022.model.Patient;
import ulb.lisa.infoh400.labs2022.services.DicomProviderServices;
import ulb.lisa.infoh400.labs2022.services.HL7Services;

/**
 *
 * @author Adrien Foucart
 */
public class MainWindow extends javax.swing.JFrame {
    
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("infoh400_PU");
    private final PatientJpaController patientCtrl = new PatientJpaController(emfac);
    private final DoctorJpaController doctorCtrl = new DoctorJpaController(emfac);
    private final ImageJpaController imageCtrl = new ImageJpaController(emfac);
    
    DicomProviderServices dps;
    HL7Services hl7s;
    
    private static final Logger LOGGER = LogManager.getLogger(MainWindow.class.getName());
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        LOGGER.info("Displaying main window");
        initComponents();
        
        usercoLabel.setText("Connected: " + Authentication.getUser().getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doctorTextLabel1 = new javax.swing.JLabel();
        doctorImageLabel1 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        patientImageLabel = new javax.swing.JLabel();
        patientTextLabel = new javax.swing.JLabel();
        doctorTextLabel = new javax.swing.JLabel();
        doctorImageLabel = new javax.swing.JLabel();
        AppointmentImageLabel = new javax.swing.JLabel();
        appointmentTextLabel = new javax.swing.JLabel();
        ImageImageLabel = new javax.swing.JLabel();
        ImageTextLabel = new javax.swing.JLabel();
        listPatientsButton = new javax.swing.JButton();
        listDoctorsButton = new javax.swing.JButton();
        listAppointmentsButton = new javax.swing.JButton();
        listImagesButton = new javax.swing.JButton();
        addPatientButton = new javax.swing.JButton();
        addDoctorButton = new javax.swing.JButton();
        addAppointmentButton = new javax.swing.JButton();
        addImageButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsList = new javax.swing.JList<>();
        editPatientButton = new javax.swing.JButton();
        editDoctorButton = new javax.swing.JButton();
        editAppointmentButton = new javax.swing.JButton();
        editImageButton = new javax.swing.JButton();
        deletePatientButton = new javax.swing.JButton();
        deleteAppointmentButton = new javax.swing.JButton();
        deleteDoctorButton = new javax.swing.JButton();
        deleteImageButton = new javax.swing.JButton();
        startSCPButton = new javax.swing.JButton();
        startHL7Button = new javax.swing.JButton();
        usercoLabel = new javax.swing.JLabel();

        doctorTextLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doctorTextLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doctorTextLabel1.setText("Doctors");

        doctorImageLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_Doctor_575955.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);

        titleLabel.setBackground(new java.awt.Color(0, 0, 153));
        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("    Health Information System");
        titleLabel.setOpaque(true);

        patientImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_Patient_287071.png"))); // NOI18N

        patientTextLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        patientTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientTextLabel.setText("Patients");

        doctorTextLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doctorTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doctorTextLabel.setText("Doctors");

        doctorImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_Doctor_575955.png"))); // NOI18N

        AppointmentImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_appointment_1701843.png"))); // NOI18N

        appointmentTextLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        appointmentTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentTextLabel.setText("Appointments");

        ImageImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_X-Ray_968744.png"))); // NOI18N

        ImageTextLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ImageTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageTextLabel.setText("Images");

        listPatientsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_List_103471.png"))); // NOI18N
        listPatientsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPatientsButtonActionPerformed(evt);
            }
        });

        listDoctorsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_List_103471.png"))); // NOI18N
        listDoctorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listDoctorsButtonActionPerformed(evt);
            }
        });

        listAppointmentsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_List_103471.png"))); // NOI18N
        listAppointmentsButton.setEnabled(false);

        listImagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_List_103471.png"))); // NOI18N
        listImagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listImagesButtonActionPerformed(evt);
            }
        });

        addPatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_add_3029252.png"))); // NOI18N
        addPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientButtonActionPerformed(evt);
            }
        });

        addDoctorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_add_3029252.png"))); // NOI18N
        addDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoctorButtonActionPerformed(evt);
            }
        });

        addAppointmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_add_3029252.png"))); // NOI18N
        addAppointmentButton.setEnabled(false);
        addAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAppointmentButtonActionPerformed(evt);
            }
        });

        addImageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_add_3029252.png"))); // NOI18N
        addImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImageButtonActionPerformed(evt);
            }
        });

        itemsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemsList);

        editPatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_edit_3029255.png"))); // NOI18N
        editPatientButton.setEnabled(false);
        editPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPatientButtonActionPerformed(evt);
            }
        });

        editDoctorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_edit_3029255.png"))); // NOI18N
        editDoctorButton.setEnabled(false);
        editDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDoctorButtonActionPerformed(evt);
            }
        });

        editAppointmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_edit_3029255.png"))); // NOI18N
        editAppointmentButton.setEnabled(false);

        editImageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_edit_3029255.png"))); // NOI18N
        editImageButton.setEnabled(false);

        deletePatientButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_Delete_756859.png"))); // NOI18N
        deletePatientButton.setEnabled(false);
        deletePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePatientButtonActionPerformed(evt);
            }
        });

        deleteAppointmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_Delete_756859.png"))); // NOI18N
        deleteAppointmentButton.setEnabled(false);

        deleteDoctorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_Delete_756859.png"))); // NOI18N
        deleteDoctorButton.setEnabled(false);
        deleteDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDoctorButtonActionPerformed(evt);
            }
        });

        deleteImageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/noun_Delete_756859.png"))); // NOI18N
        deleteImageButton.setEnabled(false);

        startSCPButton.setText("Start SCP");
        startSCPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSCPButtonActionPerformed(evt);
            }
        });

        startHL7Button.setText("Start HL7");
        startHL7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startHL7ButtonActionPerformed(evt);
            }
        });

        usercoLabel.setForeground(new java.awt.Color(51, 51, 255));
        usercoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addComponent(usercoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(patientImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(patientTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(doctorImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doctorTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AppointmentImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(appointmentTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ImageImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ImageTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(170, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(listPatientsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deletePatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(listDoctorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(listAppointmentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editAppointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addAppointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteAppointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(listImagesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startSCPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startHL7Button))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usercoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(patientTextLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(appointmentTextLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AppointmentImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ImageTextLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ImageImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doctorTextLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doctorImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(listPatientsButton)
                                .addComponent(addPatientButton))
                            .addComponent(listDoctorsButton)
                            .addComponent(addDoctorButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deletePatientButton)
                            .addComponent(editPatientButton)
                            .addComponent(editDoctorButton)
                            .addComponent(deleteDoctorButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listAppointmentsButton)
                            .addComponent(addAppointmentButton)
                            .addComponent(listImagesButton)
                            .addComponent(addImageButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editAppointmentButton)
                            .addComponent(deleteAppointmentButton)
                            .addComponent(editImageButton, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteImageButton, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startSCPButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(startHL7Button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientButtonActionPerformed
        AddPatientWindow patientAddPopup = new AddPatientWindow();
        patientAddPopup.setVisible(true);
    }//GEN-LAST:event_addPatientButtonActionPerformed

    private void addDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoctorButtonActionPerformed
        AddDoctorWindow doctorAddPopup = new AddDoctorWindow();
        doctorAddPopup.setVisible(true);
    }//GEN-LAST:event_addDoctorButtonActionPerformed

    private void addAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAppointmentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAppointmentButtonActionPerformed

    private void addImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImageButtonActionPerformed
        DicomDirectoryWindow ddirWindow = new DicomDirectoryWindow();
        ddirWindow.setVisible(true);
    }//GEN-LAST:event_addImageButtonActionPerformed
    
    private void disableButtons(){
        editPatientButton.setEnabled(false);
        editDoctorButton.setEnabled(false);
        editAppointmentButton.setEnabled(false);
        editImageButton.setEnabled(false);
        
        deletePatientButton.setEnabled(false);
        deleteDoctorButton.setEnabled(false);
        deleteAppointmentButton.setEnabled(false);
        deleteImageButton.setEnabled(false);
    }
    
    private void refreshPatientList(){
        List patients = patientCtrl.findPatientEntities();
        EntityListModel<Patient> model = new EntityListModel(patients);
        
        itemsList.setModel(model);
    }
    
    private void listPatientsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPatientsButtonActionPerformed
        refreshPatientList();
        
        disableButtons();
        editPatientButton.setEnabled(true);
        deletePatientButton.setEnabled(true);
    }//GEN-LAST:event_listPatientsButtonActionPerformed

    private void refreshDoctorList(){
        List doctors = doctorCtrl.findDoctorEntities();
        EntityListModel<Doctor> model = new EntityListModel(doctors);
        
        itemsList.setModel(model);
    }
    
    private void refreshImageList() {
        List images = imageCtrl.findImageEntities();
        EntityListModel<Image> model = new EntityListModel(images);
        
        itemsList.setModel(model);
    }
    
    private void listDoctorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listDoctorsButtonActionPerformed
        refreshDoctorList();
        
        disableButtons();
        editDoctorButton.setEnabled(true);
        deleteDoctorButton.setEnabled(true);
    }//GEN-LAST:event_listDoctorsButtonActionPerformed

    private void editPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPatientButtonActionPerformed
        if( itemsList.getSelectedIndex() < 0 ){
            return;
        }
        EntityListModel<Patient> model = (EntityListModel) itemsList.getModel();
        Patient selected = model.getList().get(itemsList.getSelectedIndex());
        
        AddPatientWindow patientAddPopup = new AddPatientWindow();
        patientAddPopup.setPatient(selected);
        patientAddPopup.setVisible(true);
        
        patientAddPopup.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent evt){
                refreshPatientList();
            }
        });
    }//GEN-LAST:event_editPatientButtonActionPerformed

    private void deletePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePatientButtonActionPerformed
        if( itemsList.getSelectedIndex() < 0 ){
            return;
        }
        EntityListModel<Patient> model = (EntityListModel) itemsList.getModel();
        Patient selected = model.getList().get(itemsList.getSelectedIndex());
        
        try {
            LOGGER.debug("Deleting patient with id: " + selected.getIdpatient());
            patientCtrl.destroy(selected.getIdpatient());
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            LOGGER.error("Failed to delete patient with id: " + selected.getIdpatient(), ex);
        }
        
        refreshPatientList();
    }//GEN-LAST:event_deletePatientButtonActionPerformed

    private void editDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDoctorButtonActionPerformed
        if( itemsList.getSelectedIndex() < 0 ){
            return;
        }
        EntityListModel<Doctor> model = (EntityListModel) itemsList.getModel();
        Doctor selected = model.getList().get(itemsList.getSelectedIndex());
        
        AddDoctorWindow doctorAddPopup = new AddDoctorWindow();
        doctorAddPopup.setDoctor(selected);
        doctorAddPopup.setVisible(true);
        
        doctorAddPopup.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent evt){
                refreshDoctorList();
            }
        });
    }//GEN-LAST:event_editDoctorButtonActionPerformed

    private void deleteDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDoctorButtonActionPerformed
        if( itemsList.getSelectedIndex() < 0 ){
            return;
        }
        EntityListModel<Doctor> model = (EntityListModel) itemsList.getModel();
        Doctor selected = model.getList().get(itemsList.getSelectedIndex());
        
        try {
            LOGGER.debug("Deleting doctor with id: " + selected.getIddoctor());
            doctorCtrl.destroy(selected.getIddoctor());
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            LOGGER.error("Failed to delete doctor with id: " + selected.getIddoctor(), ex);
        }
        
        refreshDoctorList();
    }//GEN-LAST:event_deleteDoctorButtonActionPerformed

    private void listImagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listImagesButtonActionPerformed
        refreshImageList();
        
        disableButtons();
    }//GEN-LAST:event_listImagesButtonActionPerformed

    private void itemsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsListMouseClicked
        if( itemsList.getSelectedIndex() < 0 ){
            return;
        }
        
        EntityListModel model = (EntityListModel) itemsList.getModel();
        Object selected = model.getList().get(itemsList.getSelectedIndex());
        
        if(evt.getClickCount() == 2 && selected.getClass().getSimpleName().equals("Image")){
            DicomInstanceWindow imagePopup = new DicomInstanceWindow((Image) selected);
            imagePopup.setVisible(true);
        }
        else if(evt.getClickCount() == 2 && selected.getClass().getSimpleName().equals("Patient")){
            HL7SendWindow hl7Popup = new HL7SendWindow((Patient) selected);
            hl7Popup.setVisible(true);
        }
    }//GEN-LAST:event_itemsListMouseClicked

    private void startSCPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSCPButtonActionPerformed
        if( dps == null )
            dps = new DicomProviderServices("HISSCP", 11113, new File("e:/data/localpacs"));
        
        if( dps.isReceiverThreadRunning() ){
            dps.stopSCPService();
            startSCPButton.setText("Start SCP");
        }
        else{
            dps.startSCPService();
            startSCPButton.setText("Stop SCP");
        }
    }//GEN-LAST:event_startSCPButtonActionPerformed

    private void startHL7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startHL7ButtonActionPerformed
        if( hl7s == null ){
            hl7s = new HL7Services();
        }
        
        if( hl7s.isListeningToHL7() ){
            hl7s.stopHL7Listener();
            startHL7Button.setText("Start HL7");
        }
        else{
            startHL7Button.setText("Starting");
            hl7s.startHL7Listener(54321);
            startHL7Button.setText("Stop HL7");
        }
    }//GEN-LAST:event_startHL7ButtonActionPerformed
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        LOGGER.info("Displaying main window");
        
        if (Authentication.hasUser()){
            LoginWindow loginPopup = new LoginWindow();
            loginPopup.setVisible(true);
            loginPopup.addWindowListener(new WindowAdapter() {
            @Override
                public void windowClosed(WindowEvent evt){
                    if(Authentication.getUser()!= null){
                        new MainWindow().setVisible(true);
                    }
                }
            });   
        }
        else {
            Authentication.createUser("TestsamePassword", "1234".toCharArray());
        }
        
        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppointmentImageLabel;
    private javax.swing.JLabel ImageImageLabel;
    private javax.swing.JLabel ImageTextLabel;
    private javax.swing.JButton addAppointmentButton;
    private javax.swing.JButton addDoctorButton;
    private javax.swing.JButton addImageButton;
    private javax.swing.JButton addPatientButton;
    private javax.swing.JLabel appointmentTextLabel;
    private javax.swing.JButton deleteAppointmentButton;
    private javax.swing.JButton deleteDoctorButton;
    private javax.swing.JButton deleteImageButton;
    private javax.swing.JButton deletePatientButton;
    private javax.swing.JLabel doctorImageLabel;
    private javax.swing.JLabel doctorImageLabel1;
    private javax.swing.JLabel doctorTextLabel;
    private javax.swing.JLabel doctorTextLabel1;
    private javax.swing.JButton editAppointmentButton;
    private javax.swing.JButton editDoctorButton;
    private javax.swing.JButton editImageButton;
    private javax.swing.JButton editPatientButton;
    private javax.swing.JList<String> itemsList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listAppointmentsButton;
    private javax.swing.JButton listDoctorsButton;
    private javax.swing.JButton listImagesButton;
    private javax.swing.JButton listPatientsButton;
    private javax.swing.JLabel patientImageLabel;
    private javax.swing.JLabel patientTextLabel;
    private javax.swing.JButton startHL7Button;
    private javax.swing.JButton startSCPButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usercoLabel;
    // End of variables declaration//GEN-END:variables
}
