/**
 * Copyright 2022
 * Andrés Segura-Tinoco
 * Information Retrieval Group at Universidad Autonoma de Madrid
 *
 * This is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * the current software. If not, see <http://www.gnu.org/licenses/>.
 */
package es.uam.irg.ir.gui;

import es.uam.irg.decidemadrid.entities.DMComment;
import es.uam.irg.decidemadrid.entities.DMProposal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 */
public class AnnotationForm extends javax.swing.JDialog {

    private final DataModel model;
    private String sentText;
    private String sentClaim;
    private String sentPremise;
    private Map<String, List<String>> categories;

    /**
     * Creates new form ArgumentForm
     *
     * @param model
     */
    public AnnotationForm(DataModel model) {
        initComponents();
        this.model = model;
        this.sentText = "";
        this.sentClaim = "";
        this.sentPremise = "";

        categories = new HashMap<>();
        categories.put("Cause", Arrays.asList(new String[]{"Condition", "Reason"}));
        categories.put("Clarification", Arrays.asList(new String[]{"Conclusion", "Exemplification", "Restatement", "Summary"}));
        categories.put("Consequence", Arrays.asList(new String[]{"Explanation", "Goal", "Result"}));
        categories.put("Contrast", Arrays.asList(new String[]{"Alternative", "Comparison", "Concession", "Opposition"}));
        categories.put("Elaboration", Arrays.asList(new String[]{"Addition", "Precision", "Similarity"}));
    }

    /**
     *
     * @param proposalId
     */
    public void showProposal(int proposalId) {
        DMProposal proposal = model.getProposal(proposalId);
        if (proposal != null) {
            this.sentText = proposal.getSummary();
            this.cmbType.setSelectedItem("Proposal");
            this.txtDate.setText(proposal.getDate());
            this.txtMessage.setText(sentText);
            this.setVisible(true);
        }
    }

    /**
     *
     * @param commentId
     */
    public void showComment(int commentId) {
        DMComment comment = model.getComment(commentId);
        if (comment != null) {
            this.sentText = comment.getText();
            this.cmbType.setSelectedItem("Comment");
            this.txtDate.setText(comment.getDate());
            this.txtMessage.setText(sentText);
            this.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblType = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextPane();
        btnClear = new javax.swing.JButton();
        btnClaim = new javax.swing.JButton();
        btnPremise = new javax.swing.JButton();
        lblRelation = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        cmbSubCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Arguments Configuration Form");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblType.setText("Type:");

        lblDate.setText("Date:");

        txtDate.setEditable(false);

        lblMessage.setText("Message:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Proposal", "Comment" }));
        cmbType.setEnabled(false);

        txtMessage.setEditable(false);
        txtMessage.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(txtMessage);

        btnClear.setText("Clear");
        btnClear.setMaximumSize(new java.awt.Dimension(70, 23));
        btnClear.setMinimumSize(new java.awt.Dimension(70, 23));
        btnClear.setPreferredSize(new java.awt.Dimension(70, 23));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClaim.setText("Claim");
        btnClaim.setMaximumSize(new java.awt.Dimension(70, 23));
        btnClaim.setMinimumSize(new java.awt.Dimension(70, 23));
        btnClaim.setPreferredSize(new java.awt.Dimension(70, 23));
        btnClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaimActionPerformed(evt);
            }
        });

        btnPremise.setText("Premise");
        btnPremise.setMaximumSize(new java.awt.Dimension(70, 23));
        btnPremise.setMinimumSize(new java.awt.Dimension(70, 23));
        btnPremise.setPreferredSize(new java.awt.Dimension(70, 23));
        btnPremise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPremiseActionPerformed(evt);
            }
        });

        lblRelation.setText("Relation:");

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(None)", "Cause", "Clarification", "Consequence", "Contrast", "Elaboration" }));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });

        cmbSubCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(None)" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMessage)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClaim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPremise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(lblRelation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbSubCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSave)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnClose))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblType)
                                .addComponent(lblDate))
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbType, 0, 150, Short.MAX_VALUE)
                                .addComponent(txtDate))
                            .addGap(449, 449, 449))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClaim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPremise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRelation)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSubCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMessage)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClose))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        this.sentClaim = "";
        this.sentPremise = "";
        this.txtMessage.setText(sentText);
        this.btnClaim.setEnabled(true);
        this.btnPremise.setEnabled(true);
        this.cmbCategory.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimActionPerformed
        // TODO add your handling code here:
        this.sentClaim = this.txtMessage.getSelectedText();
        this.btnClaim.setEnabled(false);
        System.out.println(this.sentClaim);
    }//GEN-LAST:event_btnClaimActionPerformed

    private void btnPremiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPremiseActionPerformed
        // TODO add your handling code here:
        this.sentPremise = this.txtMessage.getSelectedText();
        this.btnPremise.setEnabled(false);
        System.out.println(this.sentPremise);
    }//GEN-LAST:event_btnPremiseActionPerformed

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        // TODO add your handling code here:
        this.cmbSubCategory.removeAllItems();
        String currCategory = this.cmbCategory.getSelectedItem().toString();

        if (categories.containsKey(currCategory)) {
            List<String> items = categories.get(currCategory);
            items.forEach(item -> {
                this.cmbSubCategory.addItem(item);
            });
        }
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (validation()) {
            String category = this.cmbCategory.getSelectedItem().toString();
            String subCategory = this.cmbSubCategory.getSelectedItem().toString();
            System.out.println("Claim: " + this.sentClaim);
            System.out.println("Premise: " + this.sentPremise);
            System.out.println("Category: " + category);
            System.out.println("Sub Category: " + subCategory);
        }
        else {
            JOptionPane.showMessageDialog(this, "Error! You must enter all the elements of the argument.", "Error dialog", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClaim;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPremise;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbSubCategory;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblRelation;
    private javax.swing.JLabel lblType;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextPane txtMessage;
    // End of variables declaration//GEN-END:variables

    private boolean validation() {
        if (this.sentClaim.isEmpty() || this.sentPremise.isEmpty() || this.cmbCategory.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

}
