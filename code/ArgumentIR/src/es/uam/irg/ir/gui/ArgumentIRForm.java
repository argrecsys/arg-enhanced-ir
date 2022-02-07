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

import es.uam.irg.ir.DocumentResult;
import es.uam.irg.ir.InfoRetriever;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 */
public class ArgumentIRForm extends javax.swing.JFrame {

    public static final String HTML_CONTENT_TYPE = "text/html";

    private final InfoRetriever retriever;
    private final ReportFormatter formatter;
    private final DecimalFormat df;
    private final DateTimeFormatter dtf;

    /**
     * Creates new form ArgumentIRForm
     */
    public ArgumentIRForm() {
        initComponents();

        this.txtResult.setContentType(HTML_CONTENT_TYPE);
        this.retriever = new InfoRetriever();
        this.formatter = new ReportFormatter();
        this.df = new DecimalFormat("0.000");
        this.dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }

    /**
     * Create index wrapper.
     */
    public void createIndex() {
        this.retriever.createIndex();
    }

    /**
     * Load data wrapper.
     */
    public void loadData() {
        this.retriever.loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQuery = new javax.swing.JLabel();
        txtQuery = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextPane();
        lblTop = new javax.swing.JLabel();
        cmbTop = new javax.swing.JComboBox<>();
        lblRerankBy = new javax.swing.JLabel();
        cmbReranks = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Argument-enhanced Information Retrieval");
        setMinimumSize(new java.awt.Dimension(800, 400));
        setPreferredSize(new java.awt.Dimension(1200, 600));

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
        jScrollPane2.setViewportView(txtResult);

        lblTop.setText("Top:");

        cmbTop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "25", "50", "100", "All" }));

        lblRerankBy.setText("Rerank by:");

        cmbReranks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nothing", "Arguments", "Controversy" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuery)
                            .addComponent(lblTop))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbTop, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblRerankBy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbReranks, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(200, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQuery)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addGap(20, 20, 20))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(20, 20, 20))))
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
                    .addComponent(lblTop)
                    .addComponent(cmbTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRerankBy)
                    .addComponent(cmbReranks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String query = this.txtQuery.getText();
        String nTopOption = this.cmbTop.getSelectedItem().toString();
        int nTop = (nTopOption.equals("All") ? Integer.MAX_VALUE : Integer.parseInt(nTopOption));
        String reRankBy = this.cmbReranks.getSelectedItem().toString();

        // Query data
        String result = queryData(query, nTop, reRankBy);

        // Display report
        this.txtResult.setText(result);
        this.txtResult.setCaretPosition(0);
    }//GEN-LAST:event_btnSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbReranks;
    private javax.swing.JComboBox<String> cmbTop;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblQuery;
    private javax.swing.JLabel lblRerankBy;
    private javax.swing.JLabel lblTop;
    private javax.swing.JTextField txtQuery;
    private javax.swing.JTextPane txtResult;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param query
     * @param nTop
     * @param reRankBy
     * @return
     */
    private String queryData(String query, int nTop, String reRankBy) {
        String result = "";

        if (query.isEmpty()) {
            result = this.formatter.getNoValidQueryReport();

        } else {
            int nReports = 0;
            double timeElapsed = 0.0;
            StringBuilder body = new StringBuilder();

            // Query data
            long start = System.nanoTime();
            List<DocumentResult> docList = this.retriever.queryData(query, nTop, reRankBy);
            long finish = System.nanoTime();
            timeElapsed = (finish - start) / 1000000000;
            nReports = docList.size();

            // Format data
            for (DocumentResult doc : docList) {
                body.append(this.formatter.getProposalInfoReport(doc));
            }

            result = this.formatter.getProposalListReport();
            result = result.replace("$N_REPORTS$", "" + nReports);
            result = result.replace("$TIME_ELAPSED$", df.format(timeElapsed));
            result = result.replace("$CURRENT_TIME$", dtf.format(LocalDateTime.now()));
            result = result.replace("$CONTENT$", body.toString());
        }

        return result;
    }

}
