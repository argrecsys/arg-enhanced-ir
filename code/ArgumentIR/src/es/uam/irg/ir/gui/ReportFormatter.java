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
import es.uam.irg.decidemadrid.entities.DMCommentTree;
import es.uam.irg.decidemadrid.entities.DMProposal;
import es.uam.irg.decidemadrid.entities.DMProposalSummary;
import es.uam.irg.io.IOManager;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * HTML report formatter class.
 */
public class ReportFormatter {

    private static final String REPORTS_PATH = "Resources/views/";

    private final DecimalFormat df;
    private final DateTimeFormatter dtf;
    private Map<String, String> reports;

    /**
     *
     * @param decimalFormat
     * @param dateFormat
     */
    public ReportFormatter(String decimalFormat, String dateFormat) {
        this.df = new DecimalFormat(decimalFormat);
        this.dtf = DateTimeFormatter.ofPattern(dateFormat);
        loadReports();
    }

    /**
     * Creates comment HTML report.
     *
     * @param tree
     * @param comments
     * @return
     */
    public String getCommentsInfoReport(DMCommentTree tree, Map<Integer, DMComment> comments) {
        String report = "";

        if (tree != null) {
            report = reports.get("COMMENT_INFO");
            int nodeId = tree.getId();
            DMComment currNode = comments.get(nodeId);
            int leftPadding = tree.getLevel() * 15;

            report = report.replace("PADDING-LEFTpx", (leftPadding + "px"));
            report = report.replace("$ID$", "" + nodeId);
            report = report.replace("$DATE$", currNode.getDate());
            report = report.replace("$VOTES$", "" + currNode.getNumVotes());
            report = report.replace("$NUM_POSITIVE$", "" + currNode.getNumVotesUp());
            report = report.replace("$NUM_NEGATIVE$", "" + currNode.getNumVotesDown());
            report = report.replace("$TEXT$", currNode.getText());

            for (DMCommentTree node : tree.getChildren()) {
                report += getCommentsInfoReport(node, comments);
            }
        }

        return report;
    }

    public String getNoValidQueryReport() {
        return reports.get("NO_VALID_QUERY");
    }

    /**
     * Creates proposal HTML report.
     *
     * @param proposal
     * @param summary
     * @param commentTrees
     * @param comments
     * @return
     */
    public String getProposalInfoReport(DMProposal proposal, DMProposalSummary summary, List<DMCommentTree> commentTrees, Map<Integer, DMComment> comments) {
        String report = reports.get("PROPOSAL_INFO");
        StringBuilder body = new StringBuilder();

        report = report.replace("$TITLE$", proposal.getTitle());
        report = report.replace("$DATE$", proposal.getDate());
        report = report.replace("$NUM_COMMENTS$", "" + proposal.getNumComments());
        report = report.replace("$NUM_SUPPORTS$", "" + proposal.getNumSupports());
        report = report.replace("$CODE$", proposal.getCode());
        report = report.replace("$CATEGORIES$", summary.getCategories());
        report = report.replace("$DISTRICTS$", summary.getDistricts());
        report = report.replace("$TOPICS$", summary.getTopics());
        report = report.replace("$URL$", proposal.getUrl());
        report = report.replace("$SUMMARY$", proposal.getSummary());

        if (commentTrees != null) {
            String commentReport;
            for (DMCommentTree tree : commentTrees) {
                commentReport = getCommentsInfoReport(tree, comments);
                body.append(commentReport);
            }
        }
        report = report.replace("$COMMENTS$", body.toString());

        return report;
    }

    /**
     *
     * @param nReports
     * @param timeElapsed
     * @param body
     * @return
     */
    public String getProposalsReport(int nReports, double timeElapsed, String body) {
        String result = reports.get("PROPOSAL_LIST");
        result = result.replace("$N_REPORTS$", "" + nReports);
        result = result.replace("$TIME_ELAPSED$", df.format(timeElapsed));
        result = result.replace("$CURRENT_TIME$", dtf.format(LocalDateTime.now()));
        result = result.replace("$CONTENT$", body);
        return result;
    }

    /**
     * Loads all available reports into memory from disk.
     */
    private void loadReports() {
        reports = IOManager.readHtmlReports(REPORTS_PATH);
    }

}
