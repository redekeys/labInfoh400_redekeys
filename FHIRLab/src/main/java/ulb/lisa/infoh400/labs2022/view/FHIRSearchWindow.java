/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ulb.lisa.infoh400.labs2022.view;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ulb.lisa.infoh400.labs2022.controller.PatientJpaController;
import ulb.lisa.infoh400.labs2022.controller.PersonJpaController;
import ulb.lisa.infoh400.labs2022.model.Patient;
import ulb.lisa.infoh400.labs2022.services.FHIRServices;

/**
 *
 * @author renau
 */
public class FHIRSearchWindow extends javax.swing.JFrame {
    
    private final EntityManagerFactory emfac = Persistence.createEntityManagerFactory("infoh400_PU");
    private final PatientJpaController patientCtrl = new PatientJpaController(emfac);
    private final PersonJpaController personCtrl = new PersonJpaController(emfac);
    
    public FHIRSearchWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        familyNameTextField = new javax.swing.JTextField();
        serverTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JToggleButton();
        saveButton = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FHIR Searching");

        jLabel2.setText("Family Name");

        jLabel3.setText("FHIR Server");

        familyNameTextField.setText("Smith");
        familyNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                familyNameTextFieldActionPerformed(evt);
            }
        });

        serverTextField.setText("http://hapi.fhir.org/baseR4");
        serverTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverTextFieldActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save to DB");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(resultList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(familyNameTextField)
                            .addComponent(serverTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(familyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(serverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void familyNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familyNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_familyNameTextFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        FHIRServices fhir = new FHIRServices();
        List<Patient> patients = fhir.searchPatients(serverTextField.getText(), familyNameTextField.getText());
        
        System.out.println(patients.size());
        
        EntityListModel<Patient> model = new EntityListModel(patients);
        
        resultList.setModel(model);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void serverTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
         if( resultList.getSelectedIndex() < 0 ){
            return;
        }
        EntityListModel<Patient> model = (EntityListModel) resultList.getModel();
        Patient selected = model.getList().get(resultList.getSelectedIndex());
        
        // rem : on devrait check qu'il existe pas déjà.
        personCtrl.create(selected.getIdperson());
        patientCtrl.create(selected);
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField familyNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> resultList;
    private javax.swing.JToggleButton saveButton;
    private javax.swing.JToggleButton searchButton;
    private javax.swing.JTextField serverTextField;
    // End of variables declaration//GEN-END:variables
}