/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.lisa.infoh400.labs2022.view;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ulb.lisa.infoh400.labs2022.services.DicomDirectoryServices;
import ulb.lisa.infoh400.labs2022.services.DicomInstanceServices;

/**
 *
 * @author Adrien Foucart
 */
public class DicomDirectoryWindow extends javax.swing.JFrame {
    
    private static final Logger LOGGER = LogManager.getLogger(DicomDirectoryWindow.class.getName());
    private final String defaultDirectory = "C:\\Users\\renau\\Desktop\\LAB_info_h_400\\LIBSUPP\\DICOMDIR";
    
    private String selectedDirectory = null;
    private DicomDirectoryServices dds = null;
    //private DicomDirectory dicomDirectory = null;
    //private DicomDirectoryRecord selectedDdr = null;
            
    /**
     * Creates new form DicomDirectoryWindow
     */
    public DicomDirectoryWindow() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        dicomdirJTree = new javax.swing.JTree();
        openDicomdirButton = new javax.swing.JButton();
        saveImageToDatabaseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dicomAttributesTextArea = new javax.swing.JTextArea();
        dicomImageLabel = new javax.swing.JLabel();
        saveImageResultLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DICOM Directory Browser");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        dicomdirJTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        dicomdirJTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                dicomdirJTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(dicomdirJTree);

        openDicomdirButton.setText("Open DICOMDIR");
        openDicomdirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDicomdirButtonActionPerformed(evt);
            }
        });

        saveImageToDatabaseButton.setText("Save Image to Database");
        saveImageToDatabaseButton.setEnabled(false);
        saveImageToDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageToDatabaseButtonActionPerformed(evt);
            }
        });

        dicomAttributesTextArea.setEditable(false);
        dicomAttributesTextArea.setColumns(20);
        dicomAttributesTextArea.setRows(5);
        jScrollPane2.setViewportView(dicomAttributesTextArea);

        dicomImageLabel.setBackground(new java.awt.Color(20, 20, 20));
        dicomImageLabel.setForeground(new java.awt.Color(255, 255, 255));
        dicomImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dicomImageLabel.setText("Image");
        dicomImageLabel.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(openDicomdirButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveImageResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveImageToDatabaseButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                            .addComponent(dicomImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveImageResultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(openDicomdirButton)
                        .addComponent(saveImageToDatabaseButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dicomImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openDicomdirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDicomdirButtonActionPerformed
        JFileChooser fc = new JFileChooser(defaultDirectory);
        
        if( fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ){
            File selectedFile = fc.getSelectedFile();
            selectedDirectory = selectedFile.getParent();
            dds = new DicomDirectoryServices(selectedFile);
            dicomdirJTree.setModel(dds.getModel());
        }
    }//GEN-LAST:event_openDicomdirButtonActionPerformed

    private void dicomdirJTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_dicomdirJTreeValueChanged
        if( dds != null ){
            dds.setSelectedRecord(dicomdirJTree.getLastSelectedPathComponent());
            dicomAttributesTextArea.setText(dds.getSelectedRecordAttributes());
        }
        
        if( dds.selectedRecordIsImage() ){
            saveImageToDatabaseButton.setEnabled(true);
            displayImage();
        }
    }//GEN-LAST:event_dicomdirJTreeValueChanged

    private void saveImageToDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageToDatabaseButtonActionPerformed
        if( dds.selectedRecordIsImage() ){
            DicomInstanceServices dis = new DicomInstanceServices(dds.getSelectedRecordFile(selectedDirectory));
            if( dis.sendInstanceToSCP() ){
                if( dis.saveInstanceToDatabase() ){
                    saveImageResultLabel.setText("Saved to DB");
                }
                else{
                    saveImageResultLabel.setText("Error: couldn't save to DB.");                    
                }
            }
            else{
                saveImageResultLabel.setText("Error: couldn't send to SCP");                
            }
        }
    }//GEN-LAST:event_saveImageToDatabaseButtonActionPerformed
        
    public void displayImage(){
        File dicomFile = dds.getSelectedRecordFile(selectedDirectory);
        DicomInstanceServices dis = new DicomInstanceServices(dicomFile);
        Image img = dis.getDisplayableImage();
        ImageIcon icon = new ImageIcon(img);
        dicomImageLabel.setIcon(icon);
        dicomImageLabel.setText("");
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea dicomAttributesTextArea;
    private javax.swing.JLabel dicomImageLabel;
    private javax.swing.JTree dicomdirJTree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton openDicomdirButton;
    private javax.swing.JLabel saveImageResultLabel;
    private javax.swing.JButton saveImageToDatabaseButton;
    // End of variables declaration//GEN-END:variables
}