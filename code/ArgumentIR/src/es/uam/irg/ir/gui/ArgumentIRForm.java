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

import es.uam.irg.io.IOManager;
import es.uam.irg.utils.FileUtils;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.BadLocationException;

/**
 * Argument IR form class.
 */
public class ArgumentIRForm extends javax.swing.JFrame {

    // GUI constants
    public static final String HTML_CONTENT_TYPE = "text/html";
    public static final String DECIMAL_FORMAT = "0.000";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String USERS_FILEPATH = "Resources/config/annotators.txt";

    private boolean doEvents;
    private final DataModel model;
    private final String userName;

    /**
     * Creates new form ArgumentIRForm.
     *
     * @param language
     * @param dataPath
     */
    public ArgumentIRForm(String language, String dataPath) {
        initComponents();
        this.doEvents = false;
        this.model = new DataModel(language, dataPath, DECIMAL_FORMAT, DATE_FORMAT);
        this.setVisible(true);
        this.userName = getAnnotatorName();
        this.lblAnnotator.setText("Annotator: " + userName);
    }

    /**
     * Closes winform.
     */
    private void closeForm() {
        if (model.isDirty()) {
            if (JOptionPane.showConfirmDialog(this, "Arguments have been annotated. Do you want to save the new labels?", "Confirm Dialog", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                model.saveLabelsToFile(userName);
            }
        }
        this.setVisible(false);
        this.dispose();
        System.exit(0);
    }

    /**
     *
     * @param type
     */
    private void exportReportToFile(String type) {
        try {
            String filepath = selectFileToExport(type);
            String header = getReportHeader(type);
            String text = header + (type.equals("html") ? this.txtResult.getText() : this.txtResult.getDocument().getText(0, this.txtResult.getDocument().getLength()));
            FileUtils.saveFile(filepath, text);

        } catch (BadLocationException ex) {
            Logger.getLogger(ArgumentIRForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    private String[] getAnnotatorList() {
        List<String> annotators = IOManager.readUsers(USERS_FILEPATH);
        return annotators.toArray(new String[0]);
    }

    /**
     *
     * @return
     */
    private String getAnnotatorName() {
        String user = "admin";
        String[] annotators = getAnnotatorList();
        String result = (String) JOptionPane.showInputDialog(this, "Please, enter annotator name:", "Annotator Name", JOptionPane.PLAIN_MESSAGE, null, annotators, "");

        if (result != null && result.length() > 0) {
            user = result;
        }

        return user;
    }

    /**
     *
     * @param type
     * @return
     */
    private String getReportHeader(String type) {
        String header = "";

        String query = this.txtQuery.getText().trim();
        String reRankBy = this.cmbReranks.getSelectedItem().toString();
        int nPage = Integer.parseInt(this.cmbPage.getSelectedItem().toString());

        header = String.format("Query: %s | Reranked by: %s | Page number: %d", query, reRankBy, nPage);
        if (type.equals("html")) {
            header = String.format("<div>" + header + "</div>");
        }

        return header;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        lblQuery = new javax.swing.JLabel();
        txtQuery = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JEditorPane();
        lblPage = new javax.swing.JLabel();
        cmbPage = new javax.swing.JComboBox<>();
        lblRerankBy = new javax.swing.JLabel();
        cmbReranks = new javax.swing.JComboBox<>();
        lblOfN = new javax.swing.JLabel();
        lblSimilarity = new javax.swing.JLabel();
        cmbSimilarity = new javax.swing.JComboBox<>();
        lblAnnotator = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        mItemExportHtml = new javax.swing.JMenuItem();
        mItemExportText = new javax.swing.JMenuItem();
        menuSeparator = new javax.swing.JPopupMenu.Separator();
        mItemClose = new javax.swing.JMenuItem();
        menuLabel = new javax.swing.JMenu();
        mItemSaveLabels = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        mItemAbout = new javax.swing.JMenuItem();

        fileChooser.setDialogTitle("Export report");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Argument-enhanced Information Retrieval Tool");
        setMinimumSize(new java.awt.Dimension(800, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblQuery.setText("Query:");

        txtQuery.setToolTipText("Query");

        btnSearch.setText("Search");
        btnSearch.setToolTipText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtResult.setEditable(false);
        txtResult.setContentType(HTML_CONTENT_TYPE);
        txtResult.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                txtResultHyperlinkUpdate(evt);
            }
        });
        scrollPane.setViewportView(txtResult);

        lblPage.setText("Page:");

        cmbPage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        cmbPage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPageItemStateChanged(evt);
            }
        });

        lblRerankBy.setText("Rerank by:");

        cmbReranks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nothing", "Controversy", "Arguments" }));

        lblOfN.setText("of N");

        lblSimilarity.setText("Similarity:");

        cmbSimilarity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BM25", "Cosine", "Dirichlet" }));

        lblAnnotator.setText("Annotator: ");
        lblAnnotator.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        menuFile.setText("File");

        mItemExportHtml.setText("Export to Html");
        mItemExportHtml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemExportHtmlActionPerformed(evt);
            }
        });
        menuFile.add(mItemExportHtml);

        mItemExportText.setText("Export to Text");
        mItemExportText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemExportTextActionPerformed(evt);
            }
        });
        menuFile.add(mItemExportText);
        menuFile.add(menuSeparator);

        mItemClose.setText("Close");
        mItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemCloseActionPerformed(evt);
            }
        });
        menuFile.add(mItemClose);

        menuBar.add(menuFile);

        menuLabel.setText("Label");

        mItemSaveLabels.setText("Save Labels");
        mItemSaveLabels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSaveLabelsActionPerformed(evt);
            }
        });
        menuLabel.add(mItemSaveLabels);

        menuBar.add(menuLabel);

        menuHelp.setText("Help");

        mItemAbout.setText("About");
        mItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemAboutActionPerformed(evt);
            }
        });
        menuHelp.add(mItemAbout);

        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRerankBy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbReranks, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSimilarity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSimilarity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOfN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAnnotator))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQuery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuery, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addComponent(scrollPane))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuery)
                    .addComponent(txtQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPage)
                    .addComponent(cmbPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRerankBy)
                    .addComponent(cmbReranks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOfN)
                    .addComponent(lblSimilarity)
                    .addComponent(cmbSimilarity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnnotator))
                .addGap(20, 20, 20)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Event: search and display results.
     *
     * @param evt
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String query = this.txtQuery.getText().trim();
        String reRankBy = this.cmbReranks.getSelectedItem().toString();
        String similarity = this.cmbSimilarity.getSelectedItem().toString();

        // Query data
        String result = this.model.getQueryResult(query, reRankBy, similarity, 1);
        updatePagesComboBox();

        // Display report
        this.txtResult.setText(result);
        this.txtResult.setCaretPosition(0);
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * Event: close form.
     *
     * @param evt
     */
    private void mItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemCloseActionPerformed
        // TODO add your handling code here:
        closeForm();
    }//GEN-LAST:event_mItemCloseActionPerformed

    /**
     * Event: export report to html.
     *
     * @param evt
     */
    private void mItemExportHtmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemExportHtmlActionPerformed
        // TODO add your handling code here:
        exportReportToFile("html");
    }//GEN-LAST:event_mItemExportHtmlActionPerformed

    /**
     * Event: export report to raw text.
     *
     * @param evt
     */
    private void mItemExportTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemExportTextActionPerformed
        // TODO add your handling code here:
        exportReportToFile("txt");
    }//GEN-LAST:event_mItemExportTextActionPerformed

    /**
     * Event: Catch events of hyperlinks.
     *
     * @param evt
     */
    private void txtResultHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_txtResultHyperlinkUpdate
        // TODO add your handling code here:
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                String evtValue = evt.getURL().toURI().toString();

                if (evtValue.startsWith(ReportFormatter.APP_URL)) {
                    String[] tokens = evtValue.replace(ReportFormatter.APP_URL, "").split("/");
                    String action = tokens[0];

                    if (action.equals(ReportFormatter.MODE_ANNOTATE)) {
                        String mode = tokens[1];
                        int id = Integer.parseInt(tokens[2]);
                        System.out.println(" - Action: " + action + ", mode: " + mode + ", id: " + id);

                        AnnotationForm form = new AnnotationForm(model);
                        if (mode.equals("PROPOSAL")) {
                            form.showProposal(id);

                        } else if (mode.equals("COMMENT")) {
                            form.showComment(id);
                        }

                        // Refresh current report
                        if (form.getStatus()) {
                            cmbPageItemStateChanged(null);
                        }
                    }

                } else {
                    // Open a regular URL
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().browse(new URI(evtValue));
                    }
                }

            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(ArgumentIRForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtResultHyperlinkUpdate

    /**
     * Event: save labels to file.
     *
     * @param evt
     */
    private void mItemSaveLabelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSaveLabelsActionPerformed
        // TODO add your handling code here:
        if (model.isDirty()) {
            model.saveLabelsToFile(userName);
        }
    }//GEN-LAST:event_mItemSaveLabelsActionPerformed

    /**
     *
     * @param evt
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        closeForm();
    }//GEN-LAST:event_formWindowClosing

    private void cmbPageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPageItemStateChanged
        // TODO add your handling code here:
        if (this.doEvents) {
            String query = this.txtQuery.getText().trim();
            String reRankBy = this.cmbReranks.getSelectedItem().toString();
            String similarity = this.cmbSimilarity.getSelectedItem().toString();
            int nPage = Integer.parseInt(this.cmbPage.getSelectedItem().toString());

            // Query data
            String result = this.model.getQueryResult(query, reRankBy, similarity, nPage);

            // Display report
            this.txtResult.setText(result);
            this.txtResult.setCaretPosition(0);
        }
    }//GEN-LAST:event_cmbPageItemStateChanged

    /**
     *
     * @param evt
     */
    private void mItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemAboutActionPerformed
        // TODO add your handling code here:
        String aboutMsg = """
                          Argument-enhanced Information Retrieval Tool
                          
                          Version: 1.1.0
                          Date: 08/17/2022
                          Created by: Andr\u00e9s Segura-Tinoco & Iv\u00e1n Cantador
                          License: Apache License 2.0
                          Web site: https://argrecsys.github.io/arg-enhanced-ir 
                          """;

        JOptionPane.showMessageDialog(this, aboutMsg, "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mItemAboutActionPerformed

    /**
     *
     * @return
     */
    private String selectFileToExport(String ext) {
        String filepath = fileChooser.getCurrentDirectory() + "\\report N." + ext;
        fileChooser.setSelectedFile(new java.io.File(filepath));
        if (fileChooser.showDialog(this, "Save") == JFileChooser.APPROVE_OPTION) {
            filepath = fileChooser.getSelectedFile().toString();
            return filepath;
        }
        return "";
    }

    /**
     * Updates the items of the combobox Pages.
     */
    private void updatePagesComboBox() {
        this.doEvents = false;
        int nPages = this.model.getNPages();
        this.lblOfN.setText("of " + nPages);
        this.cmbPage.removeAllItems();
        for (int i = 1; i <= nPages; i++) {
            this.cmbPage.addItem("" + i);
        }
        this.doEvents = true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbPage;
    private javax.swing.JComboBox<String> cmbReranks;
    private javax.swing.JComboBox<String> cmbSimilarity;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel lblAnnotator;
    private javax.swing.JLabel lblOfN;
    private javax.swing.JLabel lblPage;
    private javax.swing.JLabel lblQuery;
    private javax.swing.JLabel lblRerankBy;
    private javax.swing.JLabel lblSimilarity;
    private javax.swing.JMenuItem mItemAbout;
    private javax.swing.JMenuItem mItemClose;
    private javax.swing.JMenuItem mItemExportHtml;
    private javax.swing.JMenuItem mItemExportText;
    private javax.swing.JMenuItem mItemSaveLabels;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuLabel;
    private javax.swing.JPopupMenu.Separator menuSeparator;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField txtQuery;
    private javax.swing.JEditorPane txtResult;
    // End of variables declaration//GEN-END:variables

}
