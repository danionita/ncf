package com.e3value.eval.ncf.ontology;

/*
Copyright (C) 2016 vu.nl, e3value.com


Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    (1) Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.

    (2) Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in
    the documentation and/or other materials provided with the
    distribution.

    (3)The name of the author may not be used to
    endorse or promote products derived from this software without
    specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
OF SUCH DAMAGE.

This code contains third-party software, as in mentioned in the included
licenses.txt file.The third-party software is redistributed under their own
intellectual property rights. Other third-party software components may need
to be downloaded separately under their own intellectual property rights.
Please check and follow applicable third party intellectual
property conditions.
*/

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.e3value.eval.ncf.CellTracker;
import com.e3value.eval.ncf.E3HSSFWorkbook;
import com.e3value.eval.ncf.E3ParseException;
import com.e3value.eval.ncf.ProfGenerator;
import com.e3value.eval.ncf.ScenarioUsage;

// RDFS2Class: end of imports

/**
 * RDFS2Class: class value_port
 * <p>
 */
public class value_port extends model_concept {

    static Logger log = Logger.getLogger(value_port.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vp_valuation **/
    protected de.dfki.rdf.util.PropertyInfo m_vp_valuation = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("vp_valuation", false);

    /** RDFS2Class: putter for slot vp_valuation **/
    public void putVp_valuation(String p_vp_valuation) {
        m_vp_valuation.putValue(p_vp_valuation);
    }
    // RDFS2Class: end of putter for slot vp_valuation

    /** RDFS2Class: getter for slot vp_valuation **/
    public String getVp_valuation() {
        return (String) m_vp_valuation.getValue();
    }
    // RDFS2Class: end of getter for slot vp_valuation

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vp_has_dir **/
    protected de.dfki.rdf.util.PropertyInfo m_vp_has_dir = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("vp_has_dir", false);

    /** RDFS2Class: putter for slot vp_has_dir **/
    public void putVp_has_dir(String p_vp_has_dir) {
        m_vp_has_dir.putValue(p_vp_has_dir);
    }
    // RDFS2Class: end of putter for slot vp_has_dir

    /** RDFS2Class: getter for slot vp_has_dir **/
    public String getVp_has_dir() {
        return (String) m_vp_has_dir.getValue();
    }
    // RDFS2Class: end of getter for slot vp_has_dir

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vp_in_connects_ve **/
    protected de.dfki.rdf.util.PropertyInfo m_vp_in_connects_ve = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vp_in_connects_ve",
                    new Class[] { value_exchange.class }, true);

    /** RDFS2Class: putter for slot vp_in_connects_ve **/
    public void putVp_in_connects_ve(value_exchange p_vp_in_connects_ve) {
        m_vp_in_connects_ve.putValue(p_vp_in_connects_ve);
    }

    public void putVp_in_connects_ve(
            de.dfki.rdf.util.RDFResource p_vp_in_connects_ve) {
        m_vp_in_connects_ve.putValue(p_vp_in_connects_ve);
    }

    public void putVp_in_connects_ve(java.util.Collection p_vp_in_connects_ve) {
        m_vp_in_connects_ve.setValues(p_vp_in_connects_ve);
    }

    public void clearVp_in_connects_ve() {
        m_vp_in_connects_ve.clearValue();
    }
    // RDFS2Class: end of putter for slot vp_in_connects_ve

    /** RDFS2Class: getter for slot vp_in_connects_ve **/
    public java.util.Collection getVp_in_connects_ve() {
        return (java.util.Collection) m_vp_in_connects_ve.getValue();
    }
    // RDFS2Class: end of getter for slot vp_in_connects_ve

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vp_out_connects_ve **/
    protected de.dfki.rdf.util.PropertyInfo m_vp_out_connects_ve = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vp_out_connects_ve",
                    new Class[] { value_exchange.class }, true);

    /** RDFS2Class: putter for slot vp_out_connects_ve **/
    public void putVp_out_connects_ve(value_exchange p_vp_out_connects_ve) {
        m_vp_out_connects_ve.putValue(p_vp_out_connects_ve);
    }

    public void putVp_out_connects_ve(
            de.dfki.rdf.util.RDFResource p_vp_out_connects_ve) {
        m_vp_out_connects_ve.putValue(p_vp_out_connects_ve);
    }

    public void putVp_out_connects_ve(
            java.util.Collection p_vp_out_connects_ve) {
        m_vp_out_connects_ve.setValues(p_vp_out_connects_ve);
    }

    public void clearVp_out_connects_ve() {
        m_vp_out_connects_ve.clearValue();
    }
    // RDFS2Class: end of putter for slot vp_out_connects_ve

    /** RDFS2Class: getter for slot vp_out_connects_ve **/
    public java.util.Collection getVp_out_connects_ve() {
        return (java.util.Collection) m_vp_out_connects_ve.getValue();
    }
    // RDFS2Class: end of getter for slot vp_out_connects_ve

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vp_first_connects_ve **/
    protected de.dfki.rdf.util.PropertyInfo m_vp_first_connects_ve = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vp_first_connects_ve",
                    new Class[] { value_exchange.class }, true);

    /** RDFS2Class: putter for slot vp_first_connects_ve **/
    public void putVp_first_connects_ve(value_exchange p_vp_first_connects_ve) {
        m_vp_first_connects_ve.putValue(p_vp_first_connects_ve);
    }

    public void putVp_first_connects_ve(
            de.dfki.rdf.util.RDFResource p_vp_first_connects_ve) {
        m_vp_first_connects_ve.putValue(p_vp_first_connects_ve);
    }

    public void putVp_first_connects_ve(
            java.util.Collection p_vp_first_connects_ve) {
        m_vp_first_connects_ve.setValues(p_vp_first_connects_ve);
    }

    public void clearVp_first_connects_ve() {
        m_vp_first_connects_ve.clearValue();
    }
    // RDFS2Class: end of putter for slot vp_first_connects_ve

    /** RDFS2Class: getter for slot vp_first_connects_ve **/
    public java.util.Collection getVp_first_connects_ve() {
        return (java.util.Collection) m_vp_first_connects_ve.getValue();
    }
    // RDFS2Class: end of getter for slot vp_first_connects_ve

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vp_in_vo **/
    protected de.dfki.rdf.util.PropertyInfo m_vp_in_vo = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vp_in_vo",
                    new Class[] { value_offering.class }, false);

    /** RDFS2Class: putter for slot vp_in_vo **/
    public void putVp_in_vo(value_offering p_vp_in_vo) {
        m_vp_in_vo.putValue(p_vp_in_vo);
    }

    public void putVp_in_vo(de.dfki.rdf.util.RDFResource p_vp_in_vo) {
        m_vp_in_vo.putValue(p_vp_in_vo);
    }
    // RDFS2Class: end of putter for slot vp_in_vo

    /** RDFS2Class: getter for slot vp_in_vo **/
    public value_offering GetVp_in_vo() {
        return (value_offering) m_vp_in_vo.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVp_in_vo() {
        return (de.dfki.rdf.util.RDFResource) m_vp_in_vo.getValue();
    }
    // RDFS2Class: end of getter for slot vp_in_vo

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vp_second_connects_ve **/
    protected de.dfki.rdf.util.PropertyInfo m_vp_second_connects_ve = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vp_second_connects_ve",
                    new Class[] { value_exchange.class }, true);

    /** RDFS2Class: putter for slot vp_second_connects_ve **/
    public void putVp_second_connects_ve(
            value_exchange p_vp_second_connects_ve) {
        m_vp_second_connects_ve.putValue(p_vp_second_connects_ve);
    }

    public void putVp_second_connects_ve(
            de.dfki.rdf.util.RDFResource p_vp_second_connects_ve) {
        m_vp_second_connects_ve.putValue(p_vp_second_connects_ve);
    }

    public void putVp_second_connects_ve(
            java.util.Collection p_vp_second_connects_ve) {
        m_vp_second_connects_ve.setValues(p_vp_second_connects_ve);
    }

    public void clearVp_second_connects_ve() {
        m_vp_second_connects_ve.clearValue();
    }
    // RDFS2Class: end of putter for slot vp_second_connects_ve

    /** RDFS2Class: getter for slot vp_second_connects_ve **/
    public java.util.Collection getVp_second_connects_ve() {
        return (java.util.Collection) m_vp_second_connects_ve.getValue();
    }
    // RDFS2Class: end of getter for slot vp_second_connects_ve

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vp_requests_offers_vo **/
    protected de.dfki.rdf.util.PropertyInfo m_vp_requests_offers_vo = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vp_requests_offers_vo",
                    new Class[] { value_object.class }, false);

    /** RDFS2Class: putter for slot vp_requests_offers_vo **/
    public void putVp_requests_offers_vo(value_object p_vp_requests_offers_vo) {
        m_vp_requests_offers_vo.putValue(p_vp_requests_offers_vo);
    }

    public void putVp_requests_offers_vo(
            de.dfki.rdf.util.RDFResource p_vp_requests_offers_vo) {
        m_vp_requests_offers_vo.putValue(p_vp_requests_offers_vo);
    }
    // RDFS2Class: end of putter for slot vp_requests_offers_vo

    /** RDFS2Class: getter for slot vp_requests_offers_vo **/
    public value_object GetVp_requests_offers_vo() {
        return (value_object) m_vp_requests_offers_vo.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVp_requests_offers_vo() {
        return (de.dfki.rdf.util.RDFResource) m_vp_requests_offers_vo
                .getValue();
    }
    // RDFS2Class: end of getter for slot vp_requests_offers_vo

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (m_vp_valuation.getValue() != null) {
            sb.append(sIndent + "-> vp_valuation: " + m_vp_valuation.getValue()
                    + "\n");
        }
        if (m_vp_has_dir.getValue() != null) {
            sb.append(sIndent + "-> vp_has_dir: " + m_vp_has_dir.getValue()
                    + "\n");
        }
        if (!m_vp_in_connects_ve.isEmpty()) {
            sb.append(sIndent + "-> vp_in_connects_ve:\n");
            for (Iterator it_vp_in_connects_ve = ((java.util.Collection) m_vp_in_connects_ve
                    .getValue()).iterator(); it_vp_in_connects_ve.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_vp_in_connects_ve
                                .next()).toStringShort()
                        + "\n");
            }
        }
        if (!m_vp_out_connects_ve.isEmpty()) {
            sb.append(sIndent + "-> vp_out_connects_ve:\n");
            for (Iterator it_vp_out_connects_ve = ((java.util.Collection) m_vp_out_connects_ve
                    .getValue()).iterator(); it_vp_out_connects_ve.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_vp_out_connects_ve
                                .next()).toStringShort()
                        + "\n");
            }
        }
        if (!m_vp_first_connects_ve.isEmpty()) {
            sb.append(sIndent + "-> vp_first_connects_ve:\n");
            for (Iterator it_vp_first_connects_ve = ((java.util.Collection) m_vp_first_connects_ve
                    .getValue()).iterator(); it_vp_first_connects_ve
                            .hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_vp_first_connects_ve
                                .next()).toStringShort()
                        + "\n");
            }
        }
        if (m_vp_in_vo.getValue() != null) {
            sb.append(sIndent + "-> vp_in_vo:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_vp_in_vo.getValue())
                            .toStringShort()
                    + "\n");
        }
        if (!m_vp_second_connects_ve.isEmpty()) {
            sb.append(sIndent + "-> vp_second_connects_ve:\n");
            for (Iterator it_vp_second_connects_ve = ((java.util.Collection) m_vp_second_connects_ve
                    .getValue()).iterator(); it_vp_second_connects_ve
                            .hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_vp_second_connects_ve
                                .next()).toStringShort()
                        + "\n");
            }
        }
        if (m_vp_requests_offers_vo.getValue() != null) {
            sb.append(sIndent + "-> vp_requests_offers_vo:\n" + sIndent
                    + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_vp_requests_offers_vo
                            .getValue()).toStringShort()
                    + "\n");
            // sb.append(sIndent+"->
            // vp_requests_offers_vo:\n"+((de.dfki.rdf.util.RDFResource)m_vp_requests_offers_vo.getValue()).toString(sIndent+"
            // "));
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = {};

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public value_port() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_vp_valuation);
        ps.addProperty(m_vp_has_dir);
        ps.addProperty(m_vp_in_connects_ve);
        ps.addProperty(m_vp_out_connects_ve);
        ps.addProperty(m_vp_first_connects_ve);
        ps.addProperty(m_vp_in_vo);
        ps.addProperty(m_vp_second_connects_ve);
        ps.addProperty(m_vp_requests_offers_vo);
    }

    // RDFS2Class: end of PropertyStore-stuff

    public boolean hasMoneyObject() {
        try {
            value_object o = GetVp_requests_offers_vo();
            if (o.getE3_has_name().equals("MONEY")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasNonMoneyObject() {
        try {
            value_object o = GetVp_requests_offers_vo();
            if (o == null) {
                return false;
            }
            if (!o.getE3_has_name().equals("MONEY")
                    && !o.getE3_has_name().equals("")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean directionIsInward() {
        if (getVp_has_dir() == null) {
            return false;
        }
        if (getVp_has_dir().equalsIgnoreCase("true")) {
            return true;
        }
        return false;
    }

    public Double fetchTotalOccurrences() {
        value_interface vi = GetVp_in_vo().GetVo_in_vi();
        ScenarioUsage u = vi.fetchScenarioUsage();
        Double d = u.getTotalOccurences();
        return d;
    }

    /**
     * Will be replaced by the one below
     *
     * @return
     * @throws E3ParseException
     */
    public String findValuationFunction() throws E3ParseException {
        String f = fetchExpression("VALUATION");
        if (f != null) {
            if (f.equals("")) {
                return null;
            } else {
                return f;
            }
        }
        return null;
    }

    /**
     * Find a formula
     *
     * @param formula
     * @return
     * @throws E3ParseException
     */
    public String findFormula(String formula) throws E3ParseException {
        String f = fetchExpression(formula);
        if (f != null) {
            if (f.equals("")) {
                return null;
            } else {
                return f;
            }
        }
        return null;
    }

    /**
     * Will be replaced the one below
     *
     * @return
     */
    public String findValuationCoordinates() {
        try {
            String coords = "";
            CellTracker ct = fetchCellTracker("VALUATION");
            coords = "Formulasheet!"
                    + ProfGenerator.convertToXLSCol(ct.getCol())
                    + ProfGenerator.convertToXLSRow(ct.getRow());
            return coords;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Find the Excel coordinates for the formula
     *
     * @param formula
     * @return
     */
    public String findFormulaCoordinates(String formula) {
        try {
            String coords = "";
            CellTracker ct = fetchCellTracker(formula);
            coords = "Formulasheet!"
                    + ProfGenerator.convertToXLSCol(ct.getCol())
                    + ProfGenerator.convertToXLSRow(ct.getRow());
            return coords;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Find the normFormula for a port based on baseFormulas using the
     * 'subjective' method --- The 'subjective' method implies that for finding
     * the NORM_VALUE formula a formula for that port have to be found, and then
     * the weighted average has to be calculated based on all exchanges (and
     * thus occurrences) connected to that port.
     *
     * @param normFormula
     * @param baseFormula
     * @param source
     * @param port_is_tree_root
     * @return
     * @throws Exception
     */
    private String findSubjectiveObjectiveFormula(String normFormula,
            String baseFormula, value_port source, boolean port_is_tree_root,
            StringBuffer userlog) throws Exception {
        log.debug(
                "\t This is a port with a value object with subjective formulas");

        String f = ""; // The NORM_VALUE function that to be build up
        String THIS_FUNCTION = null;
        String THIS_FUNCTION_COORDINATES = null;
        double SUM_OCCURRENCES = 0;
        Double THIS_OCCURRENCES = null;

        // case 1: assume port has valuation function
        boolean proceed = false;
        THIS_FUNCTION = findFormula(baseFormula);
        THIS_FUNCTION_COORDINATES = findFormulaCoordinates(baseFormula);

        SUM_OCCURRENCES = fetchTotalOccurrences();

        if (!ProfGenerator.StringIsNUL(THIS_FUNCTION)) {
            log.debug("\t Found a " + baseFormula
                    + " function for this port on this port");
            f = THIS_FUNCTION_COORDINATES;
            if (!port_is_tree_root) {
                String msg = baseFormula + " function override on valueport \""
                        + getE3_has_name() + "\"\n";
                String templog = userlog.toString();
                if (!(templog.length() > templog.replaceAll(msg, "")
                        .length())) {
                    userlog.append(
                            baseFormula + " function override on valueport \""
                                    + getE3_has_name() + "\"\n");
                }
            }
        } else
        // There is on root port level no reason to borrow valuation functions
        // from peer ports
        // or value exchanges - as is the case for money-based value objects.
        // Valuation is subjective and can not be borrowed from root actors
        // (having in-out ports)
        if (!port_is_tree_root) {
            // case 2: calculate a combined valuation function from peer ports
            // and propagate it (NORM_VALUE)
            // Find ports to derive valuation functions from, to calculate a
            // NORM_VALUE function
            // We did not find a valuation function at the port itself so search
            // at connected exchanges
            // or root ports.
            Collection myExchanges = new Vector();
            if (directionIsInward()) {
                myExchanges.addAll(getVp_first_connects_ve());
                myExchanges.addAll(getVp_out_connects_ve());
            } else {
                myExchanges.addAll(getVp_in_connects_ve());
                myExchanges.addAll(getVp_second_connects_ve());
            }
            Iterator iter_myExchanges = myExchanges.iterator();

            SUM_OCCURRENCES = 0.0;
            f = "";
            while (iter_myExchanges.hasNext()) {
                value_exchange value_exchange = (value_exchange) iter_myExchanges
                        .next();

                // Find the outward directed peer port (we have to pop up in the
                // tree to the root port
                // to find a valuation function
                value_port peer = null;
                value_port potential_peer_i = value_exchange.GetVe_has_in_po();
                value_port potential_peer_o = value_exchange.GetVe_has_out_po();
                value_port potential_peer_1 = value_exchange
                        .GetVe_has_first_vp();
                value_port potential_peer_2 = value_exchange
                        .GetVe_has_second_vp();

                if (potential_peer_i != null && potential_peer_o != null) {
                    if (potential_peer_i.equals(this)) {
                        peer = potential_peer_o;
                    }
                    if (potential_peer_o.equals(this)) {
                        peer = potential_peer_i;
                    }
                } else if (potential_peer_1 != null
                        && potential_peer_2 != null) {
                    if (potential_peer_1.equals(this)) {
                        peer = potential_peer_2;
                    }
                    if (potential_peer_2.equals(this)) {
                        peer = potential_peer_1;
                    }
                }

                log.debug("\t Using the " + normFormula + " of peer port "
                        + peer.getE3_has_name() + " as " + baseFormula
                        + " function");
                THIS_OCCURRENCES = peer.fetchTotalOccurrences();
                CellTracker ct = peer.fetchCellTracker(normFormula);
                String DEFAULT = "Formulasheet!" + ct.getXLSCol()
                        + ct.getXLSRow();
                String sub_f = "(" + DEFAULT + "*"
                        + ProfGenerator.Double2String(THIS_OCCURRENCES) + ")";
                SUM_OCCURRENCES = SUM_OCCURRENCES
                        + THIS_OCCURRENCES.doubleValue();

                if (f.length() > 0) {
                    f = f + "+";
                }
                f = f + sub_f;

            }

            if (ProfGenerator.StringIsNUL(f)) {
                f = "0";
            } else {
                f = "(" + f + ")/"
                        + ProfGenerator.double2String(SUM_OCCURRENCES); // divide
            }

        }

        if (SUM_OCCURRENCES == 0) {
            f = "0";
        }

        return f;

    }

    private String findNormalisedObjectiveFormula(String normFormula,
            String baseFormula, value_port source, boolean port_is_tree_root)
            throws Exception {
        log.debug(
                "\t This is a port with a value object with objective formulas");

        String f = ""; // The NORM_VALUE function that to be build up
        String THIS_FUNCTION = null;
        String THIS_FUNCTION_COORDINATES = null;
        double SUM_OCCURRENCES = 0;
        Double THIS_OCCURRENCES = null;
        // Build the list of exchanges connected to this value port
        // These exchanges may have all valuation functions
        // Which exchanges to consider depends on the direction of the port
        // Why first and out both? Moreover: are valuation functions normalized
        // and summed up
        // if they are expressed on both the first and out exchange?
        // Answer: What happens (at least in case of a root port) is that only
        // valuations functions at
        // in-out exchanges are normalized. First-second exchanges are not taken
        // into account
        // (see
        // normalisation-peer-ports-valuation-function-on-inout-and-firstsecond-exchanges.xsvg)

        // If we have found an objective function for a port, we check if this
        // port is a root port
        // Root ports (with money objects associated) are the only ports for
        // which objective functions should be found
        //
        // We only decide on a ports rootness in the context of a particular
        // value transfer
        // A same port can be a root port (if it has in-out transfers) and a
        // non-root port (if it has first second transfers).
        //
        // If objective functions are found for other ports than root ports, an
        // error exception should be raised.
        // The basic position is that only root ports can have objective
        // formulas.
        // To put it differently; while reasoning on objective formulas from a
        // root port inwards a composite,
        // we cannot disagree about these values.
        //
        // We test if we have found a objective function, and not upfront. The
        // reason for this is that this way
        // we can check if objective functions have been assigned to non-root
        // ports, which indicates an error

        Collection myExchanges = new Vector();
        if (directionIsInward()) {
            log.debug("\t This is an outward port");
            myExchanges.addAll(getVp_first_connects_ve());
            myExchanges.addAll(getVp_out_connects_ve());
        } else {
            log.debug("\t This is an inward port");
            myExchanges.addAll(getVp_in_connects_ve());
            myExchanges.addAll(getVp_second_connects_ve());
        }

        // Consider all exchanges for a valuation function
        Iterator iter_myExchanges = myExchanges.iterator();
        while (iter_myExchanges.hasNext()) {

            // 'proceed' checks if we have a valuation function
            boolean proceed = false;
            value_exchange value_exchange = (value_exchange) iter_myExchanges
                    .next();
            log.debug("\t Find for this port a function following transfer "
                    + value_exchange.getE3_has_name());

            // Find the valuation, if it exists
            THIS_FUNCTION = value_exchange.findFormula(baseFormula);
            THIS_FUNCTION_COORDINATES = value_exchange
                    .findFormulaCoordinates(baseFormula);

            // Consider the peer as the port we are coming from
            // In case we are considering a root port, this is null
            // In case we are traversing down from a root port, this is the port
            // we are coming from
            value_port peer = source;

            // Fetch the occurrences for the value exchange we consider
            // This is necessary to calcaluate a normalized (average) valuation
            // function
            // if the port under consideration has many value exchanges or peer
            // ports with each a separate valuation
            // function (see e.g. normalisation-peer-ports.xsvg)
            THIS_OCCURRENCES = value_exchange.fetchOccurrences();

            // Do we have a valuation function on the transfer if this port is
            // non-root only?
            // That is allowed, because the other port connected to the transfer
            // may
            // have root capabilities
            if (!ProfGenerator.StringIsNUL(THIS_FUNCTION)
                    && isRootPortInContext(value_exchange)) {
                // We do have a valuation on this port from an exchange
                // Consider other exchanges connected to this port
                proceed = true;
                log.debug("\t Found a " + baseFormula
                        + " function on value transfer "
                        + value_exchange.getE3_has_name() + " for this port");
                // We are not allowed to find a function in the context of this
                // value exchange
            } else {
                // case 2: assume that this port has a valuation function
                proceed = false;

                // Try to find a valuation function, but now at the port under
                // consideration
                log.debug("\t Find at this port a function");

                THIS_FUNCTION = findFormula(baseFormula);
                THIS_FUNCTION_COORDINATES = findFormulaCoordinates(baseFormula);

                // Do we have a valuation function on this port and this port is
                // non-root only?
                // That is not allowed
                if (!ProfGenerator.StringIsNUL(THIS_FUNCTION)
                        && isNonRootPortOnly()) {
                    throw new E3ParseException("Non root value port "
                            + getE3_has_name() + " is not allowed to have a "
                            + baseFormula + " function");

                }
                if (!ProfGenerator.StringIsNUL(THIS_FUNCTION)
                        && isRootPortInContext(value_exchange)) {
                    log.debug("\t Found a " + baseFormula
                            + " function on this value port");
                    // We have found a valuation function for the port
                    boolean override = false;

                    // Put all ports of the exchange under consideration in a
                    // set.
                    // On the peer ports, no valuation function should be found
                    // "two different numbers on money is meaningless"
                    Vector connectedports = new Vector();
                    connectedports.add(value_exchange.GetVe_has_first_vp());
                    connectedports.add(value_exchange.GetVe_has_second_vp());
                    connectedports.add(value_exchange.GetVe_has_in_po());
                    connectedports.add(value_exchange.GetVe_has_out_po());

                    // Check all connected exchanges for valuation functions
                    // This is not allowed.
                    // Two actors can not disagree on the valuation function to
                    // be used in case of money
                    // If so, raise an exception
                    Iterator iter_connectedports = connectedports.iterator();
                    while (iter_connectedports.hasNext()) {
                        peer = (value_port) iter_connectedports.next();
                        if (!equals(peer) && peer != null) {
                            String PEER_FUNCTION = peer
                                    .findFormula(baseFormula);
                            if (!ProfGenerator.StringIsNUL(PEER_FUNCTION)
                                    && !(PEER_FUNCTION.equals(THIS_FUNCTION))) {
                                throw new E3ParseException(
                                        "For port " + getE3_has_name()
                                                + " having a value object and a "
                                                + baseFormula
                                                + " function, a peer port "
                                                + peer.getE3_has_name()
                                                + " has been found with another "
                                                + baseFormula + " function");
                            }
                        }
                    }
                    proceed = true;
                } else {
                    // case 3: peer port has valuation function
                    // Here we build up the valuation function of the port under
                    // consideration
                    // based on the valuation functions of the peer ports
                    proceed = false;

                    // Look for peer ports. Are there any valuation functions
                    // defined here?
                    // If so, we use this function
                    Vector connectedports = new Vector();
                    connectedports.add(value_exchange.GetVe_has_first_vp());
                    connectedports.add(value_exchange.GetVe_has_second_vp());
                    connectedports.add(value_exchange.GetVe_has_in_po());
                    connectedports.add(value_exchange.GetVe_has_out_po());

                    Iterator iter_connectedports = connectedports.iterator();
                    while (iter_connectedports.hasNext()) {
                        peer = (value_port) iter_connectedports.next();
                        if (!equals(peer) && peer != null) {
                            log.debug(
                                    "\t Find for this port a function at peer port "
                                            + peer.getE3_has_name());
                            THIS_FUNCTION = peer.findFormula(baseFormula);
                            THIS_FUNCTION_COORDINATES = peer
                                    .findFormulaCoordinates(baseFormula);

                            // The peer port may have a valuation function, even
                            // if this port
                            // is non-root only
                            if (!ProfGenerator.StringIsNUL(THIS_FUNCTION)
                                    && isRootPortInContext(value_exchange)) {
                                // if (!port_is_tree_root) throw new
                                // E3ParseException(override_error_msg);
                                proceed = true;
                                log.debug("\t Found a " + baseFormula
                                        + " function on peer port "
                                        + peer.getE3_has_name());
                                break;
                            }
                        }
                    }
                    if (!proceed) {
                        // We have not found a valuation function yet
                        // In case of a port that is a root port ONLY, this is
                        // not allowed. Raise an exception
                        // In cardinality-test-2, port 74 is a root-port, but
                        // also a non-root-port
                        // In that specific case (and for all other non-root
                        // port cases) we have to derive a
                        // valuation function, at least in the context of the
                        // exchange under consideration

                        // We know already if we are a root port
                        // So, additionally check if we are for this specific
                        // exchange also a non-root port

                        if (isRootPortInContext(value_exchange)) {
                            throw new E3ParseException("No " + baseFormula
                                    + " function found for root value port "
                                    + getE3_has_name());
                        }

                        // We are a non-root port
                        // Now, try to derive a valuation function from some
                        // parent - its NORM_VALUE
                        // We assume that each port has always a correct
                        // NORM_VALUE function that can be used as a valuation
                        // function. This function should (ultimately) refer to
                        // root ports having a real function,
                        // either from their own, a peer port, or an exchange

                        log.debug("\t No " + baseFormula
                                + " function found for non root port, deriving one");

                        // Find all possible peers for this port connected to
                        // the exchange under consideration
                        peer = null;
                        value_port potential_peer_i = value_exchange
                                .GetVe_has_in_po();
                        value_port potential_peer_o = value_exchange
                                .GetVe_has_out_po();
                        value_port potential_peer_1 = value_exchange
                                .GetVe_has_first_vp();
                        value_port potential_peer_2 = value_exchange
                                .GetVe_has_second_vp();

                        THIS_OCCURRENCES = value_exchange.fetchOccurrences();
                        log.debug("\t Using OCCURRENCES " + THIS_OCCURRENCES
                                + " for " + normFormula + " function");

                        // Find the peer port that we use to derive a valuation
                        // function from
                        if (potential_peer_i != null
                                && potential_peer_o != null) {
                            // do we need the in or out port? Decide on what we
                            // are ourselves, in or out
                            if (potential_peer_i.equals(this)) {
                                peer = potential_peer_o;
                            }
                            if (potential_peer_o.equals(this)) {
                                peer = potential_peer_i;
                            }
                        } else if (potential_peer_1 != null
                                && potential_peer_2 != null) {
                            // do we need the 1 or 2 port? Decide on what we are
                            // ourselves, 1 or 2
                            if (potential_peer_1.equals(this)) {
                                peer = potential_peer_2;
                            }
                            if (potential_peer_2.equals(this)) {
                                peer = potential_peer_1;
                            }
                        }

                        // We have now found the peer port for this port
                        log.debug("\t Found a peer port: "
                                + peer.getE3_has_name());

                        // Fetch the NORM_VALUE of the peer port to refer to
                        CellTracker ct = peer.fetchCellTracker(normFormula);
                        if (ct != null) {
                            String DEFAULT = "Formulasheet!" + ct.getXLSCol()
                                    + ct.getXLSRow();
                            if (!ProfGenerator.StringIsNUL(DEFAULT)) {
                                THIS_FUNCTION = "(" + DEFAULT + ")";
                                log.debug("\t Using the " + normFormula
                                        + " of peer port "
                                        + peer.getE3_has_name() + " as "
                                        + baseFormula + " function");
                                proceed = true;
                            }
                        }

                        if (!proceed) {
                            throw new E3ParseException("No " + normFormula
                                    + " function found for value_port "
                                    + getE3_has_name());

                        }
                    }
                }
            }

            // Build up the elements for the valuation function
            if (f.length() > 0) {
                f = f + "+";
            }
            f = f + "(" + ProfGenerator.Double2String(THIS_OCCURRENCES) + "*"
                    + ProfGenerator.Numberstring2Doublestring(THIS_FUNCTION)
                    + ")";
            SUM_OCCURRENCES = SUM_OCCURRENCES + THIS_OCCURRENCES.doubleValue();
        }

        // All exchanges dealt with; now build the valuation function

        f = "(" + f + ")/" + ProfGenerator.double2String(SUM_OCCURRENCES);

        if (SUM_OCCURRENCES == 0) {
            f = "0";
        }

        // Check if there is a valuation function finally
        if (ProfGenerator.StringIsNUL(f)) {
            throw new E3ParseException("No " + normFormula
                    + " function found for value_port " + getE3_has_name());
        }

        return f;
    }

    /**
     * Calculate normalised valuation functions to this port, and its port
     * (in)directly related via first-second relations This function is first
     * called if a port is a 'root' port (that is: an in/out port) and
     * thereafter recursively called for all first-second ports related to his
     * port
     *
     * @param objective
     *            is this an objective formula (true) or not (false)
     * @param value
     * @param source
     *            From which value port are we coming. In case of a root port
     *            this is null
     * @param connecting_ve
     * @param mapObjects
     * @param port_is_tree_root
     * @param userlog
     * @throws Exception
     */

    public void assignNormalisedFunction2(Boolean objective, String normFormula,
            String baseFormula, String value, value_port source,
            value_exchange connecting_ve, Map mapObjects,
            boolean port_is_tree_root, StringBuffer userlog) throws Exception {
        // Preambule - do the logging
        log.debug("\t Assigning normalised " + normFormula + " function");
        log.debug("\t (still considering port: " + getE3_has_name() + ")");
        if (port_is_tree_root) {
            log.debug("\t This is a root port");
        } else {
            log.debug("\t This is a non-root port");
        }

        // The formula to be used for the NORM_VALUE
        String formula = "";

        if (objective) {
            // Calculate formula for objective formula
            log.debug("\t This is a object with an objective formula");
            formula = findNormalisedObjectiveFormula(normFormula, baseFormula,
                    source, port_is_tree_root);
        } else {
            // Calculate formula for subjective formula
            log.debug("\t This is an object with a subjective formula");
            formula = findSubjectiveObjectiveFormula(normFormula, baseFormula,
                    source, port_is_tree_root, userlog);
        }

        log.debug("\t Calculated normalized value: " + formula);

        // Set the NORM_VALUE
        if (formula.length() == 0) {
            formula = "0" + formula;
        }
        putE3_has_formula(normFormula + "=" + formula); // Not complete clear

        removeExpression(normFormula);

        // Now consider the exchanges related to this port; walk away from the
        // root port
        log.debug("\t Considering exchanges connected to the root port "
                + getE3_has_name() + " now, traversing away from this port");

        Collection traverse_ve = new Vector();
        if (directionIsInward()) {
            traverse_ve.addAll(getVp_second_connects_ve());
        } else {
            traverse_ve.addAll(getVp_first_connects_ve());
        }

        Iterator traverse_ve_i = traverse_ve.iterator();
        while (traverse_ve_i.hasNext()) {
            value_exchange ve = (value_exchange) traverse_ve_i.next();

            if (directionIsInward()) {
                log.debug("Considering port "
                        + ve.GetVe_has_first_vp().getE3_has_name() + " for "
                        + normFormula + " functions");

                ve.GetVe_has_first_vp().assignNormalisedFunction2(objective,
                        normFormula, baseFormula, "0" + formula, this, ve,
                        mapObjects, false, userlog);
            } else {
                log.debug("Considering port "
                        + ve.GetVe_has_second_vp().getE3_has_name() + " for "
                        + normFormula + " functions");

                ve.GetVe_has_second_vp().assignNormalisedFunction2(objective,
                        normFormula, baseFormula, "0" + formula, this, ve,
                        mapObjects, false, userlog);
            }
        }

        log.debug("\t Considered exchanges connected to the root port "
                + getE3_has_name());

    }

    /**
     * Calculate normalised valuation functions to this port, and its port
     * (in)directly related via first-second relations This function is first
     * called if a port is a 'root' port (that is: an in/out port) and
     * thereafter recursively called for all first-second ports related to his
     * port This code has to be replaced by assignNormalisedValuationFunction2
     *
     * @param value
     * @param source
     *            From which value port are we coming. In case of a root port
     *            this is null
     * @param connecting_ve
     * @param mapObjects
     * @param port_is_tree_root
     * @param userlog
     * @throws Exception
     */

    public void assignNormalisedValuationFunction(String value,
            value_port source, value_exchange connecting_ve, Map mapObjects,
            boolean port_is_tree_root, StringBuffer userlog) throws Exception {

        log.debug("\t Assigning Normalised Valuation Function");
        log.debug("Considering port: " + getE3_has_name());
        if (port_is_tree_root) {
            log.debug("\t This is a root port");
        } else {
            log.debug("\t This is a non-root port");
        }

        String f = ""; // The NORM_VALUE function that to be build up
        String THIS_VALUATIONFUNCTION = null;
        String THIS_VALUATIONFUNCTION_COORDINATES = null;
        double SUM_OCCURRENCES = 0;
        Double THIS_OCCURRENCES = null;

        if (hasMoneyObject()) {
            // Treat as money
            log.debug("\t This is a port with a money value object");
            // Build the list of exchanges connected to this value port
            // These exchanges may have all valuation functions

            Collection myExchanges = new Vector();
            if (directionIsInward()) {
                log.debug("\t This is an outward port");
                myExchanges.addAll(getVp_first_connects_ve());
                myExchanges.addAll(getVp_out_connects_ve());
            } else {
                log.debug("\t This is an inward port");
                myExchanges.addAll(getVp_in_connects_ve());
                myExchanges.addAll(getVp_second_connects_ve());
            }

            // Consider all exchanges for a valuation function
            Iterator iter_myExchanges = myExchanges.iterator();
            while (iter_myExchanges.hasNext()) {
                // 'proceed' checks if we have a valuation function
                boolean proceed = false;
                value_exchange value_exchange = (value_exchange) iter_myExchanges
                        .next();

                // Find the valuation, if it exists
                THIS_VALUATIONFUNCTION = value_exchange.findValuationFunction();
                THIS_VALUATIONFUNCTION_COORDINATES = value_exchange
                        .findValuationCoordinates();

                // Consider the peer as the port we are coming from
                // In case we are considering a root port, this is null
                // In case we are traversing down from a root port, this is the
                // port we are coming from
                value_port peer = source;

                // Fetch the occurrences for the value exchange we consider
                // This is necessary to calcaluate a normalized (average)
                // valuation function
                // if the port under consideration has many value exchanges or
                // peer ports with each a separate valuation
                // function (see e.g. normalisation-peer-ports.xsvg)
                THIS_OCCURRENCES = value_exchange.fetchOccurrences();

                // Do we have a valuation function on this port?
                if (!ProfGenerator.StringIsNUL(THIS_VALUATIONFUNCTION)
                        && isRootPortInContext(value_exchange)) {
                    // We do have a valuation on this port from an exchange
                    // Consider other exchanges connected to this port
                    proceed = true;
                    log.debug("\t Found a valuation function on value transfer "
                            + value_exchange.getE3_has_name()
                            + " for this port");

                } else {
                    // case 2: assume that this port has a valuation function
                    proceed = false;

                    // Try to find a valuation function, but now at the port
                    // under consideration
                    THIS_VALUATIONFUNCTION = findValuationFunction();
                    THIS_VALUATIONFUNCTION_COORDINATES = findValuationCoordinates();

                    if (!ProfGenerator.StringIsNUL(THIS_VALUATIONFUNCTION)
                            && isNonRootPortOnly()) {
                        throw new E3ParseException(
                                "Non root value port " + getE3_has_name()
                                        + " is not allowed to have a "
                                        + "VALUATION" + " function");

                    }

                    if (!ProfGenerator.StringIsNUL(THIS_VALUATIONFUNCTION)
                            && isRootPortInContext(value_exchange)) {
                        log.debug(
                                "\t Found a valuation function on this value port");
                        // We have found a valuation function for the port
                        // It should be taken for all exchanges that do not have
                        // a valuation function
                        boolean override = false;

                        // Put all ports of the exchange under consideration in
                        // a set.
                        // On the peer ports, no valuation function should be
                        // found
                        // "two different numbers on money is meaningless"
                        Vector connectedports = new Vector();
                        connectedports.add(value_exchange.GetVe_has_first_vp());
                        connectedports
                                .add(value_exchange.GetVe_has_second_vp());
                        connectedports.add(value_exchange.GetVe_has_in_po());
                        connectedports.add(value_exchange.GetVe_has_out_po());

                        // Check all connected exchanges for valuation functions
                        // This is not allowed.
                        // Two actors can not disagree on the valuation function
                        // to be used in case of money
                        // If so, raise an exception
                        Iterator iter_connectedports = connectedports
                                .iterator();
                        while (iter_connectedports.hasNext()) {
                            peer = (value_port) iter_connectedports.next();
                            if (!equals(peer) && peer != null) {
                                String PEER_VALUATIONFUNCTION = peer
                                        .findValuationFunction();
                                if (!ProfGenerator
                                        .StringIsNUL(PEER_VALUATIONFUNCTION)
                                        && !(PEER_VALUATIONFUNCTION.equals(
                                                THIS_VALUATIONFUNCTION))) {
                                    throw new E3ParseException("For port "
                                            + getE3_has_name()
                                            + " having a value object and a valution function, a peer port "
                                            + peer.getE3_has_name()
                                            + " has been found with another valuation function");
                                }
                            }
                        }
                        proceed = true;
                    } else {
                        // case 3: peer port has valuation function
                        // Here we build up the valution function of the port
                        // under consideration
                        // based on the valuation functions of the peer ports
                        proceed = false;

                        // Look for peer ports. Are there any valuation
                        // functions defined here?
                        // If so, we use this function
                        Vector connectedports = new Vector();
                        connectedports.add(value_exchange.GetVe_has_first_vp());
                        connectedports
                                .add(value_exchange.GetVe_has_second_vp());
                        connectedports.add(value_exchange.GetVe_has_in_po());
                        connectedports.add(value_exchange.GetVe_has_out_po());

                        Iterator iter_connectedports = connectedports
                                .iterator();
                        while (iter_connectedports.hasNext()) {
                            peer = (value_port) iter_connectedports.next();
                            if (!equals(peer) && peer != null) {
                                THIS_VALUATIONFUNCTION = peer
                                        .findValuationFunction();
                                THIS_VALUATIONFUNCTION_COORDINATES = peer
                                        .findValuationCoordinates();

                                if (!ProfGenerator
                                        .StringIsNUL(THIS_VALUATIONFUNCTION)
                                        && isRootPortInContext(
                                                value_exchange)) {
                                    proceed = true;
                                    log.debug(
                                            "\t Found a valuation function on peer port "
                                                    + peer.getE3_has_name());
                                    break;
                                }
                            }
                        }
                        if (!proceed) {
                            // We have not found a valuation function yet
                            // In case of a root port, this is not allowed.
                            // Raise an exception
                            if (isRootPortInContext(value_exchange)
                            // port_is_tree_root
                            ) {
                                throw new E3ParseException(
                                        "No valuation function found for root value port "
                                                + getE3_has_name());
                            }

                            // We are a non-root port
                            // Now, try to derive a valuation function from some
                            // parent - its NORM_VALUE
                            // We assume that each port has always a correct
                            // NORM_VALUE function that can be used as a
                            // valuation
                            // function. This function should (ultimately) refer
                            // to root ports having a real function,
                            // either from their own, a peer port, or an
                            // exchange

                            log.debug(
                                    "\t No valuation function found for non root port, deriving one");

                            // Find all possible peers for this port connected
                            // to the exchange under consideration
                            peer = null;
                            value_port potential_peer_i = value_exchange
                                    .GetVe_has_in_po();
                            value_port potential_peer_o = value_exchange
                                    .GetVe_has_out_po();
                            value_port potential_peer_1 = value_exchange
                                    .GetVe_has_first_vp();
                            value_port potential_peer_2 = value_exchange
                                    .GetVe_has_second_vp();

                            THIS_OCCURRENCES = value_exchange
                                    .fetchOccurrences();
                            log.debug("\t Using OCCURRENCES " + THIS_OCCURRENCES
                                    + " for normalized valuation function");

                            // Find the peer port that we use to derive a
                            // valuation function from
                            // This code seems to be overdone, (e.g. peer ports
                            // of in and out ports are not relevant
                            // since these root ports are required to have a
                            // valuation anyway (or borrow one from their peers
                            // which has been covered already by the code above
                            if (potential_peer_i != null
                                    && potential_peer_o != null) {
                                // do we need the in or out port? Decide on what
                                // we are ourselves, in or out
                                if (potential_peer_i.equals(this)) {
                                    peer = potential_peer_o;
                                }
                                if (potential_peer_o.equals(this)) {
                                    peer = potential_peer_i;
                                }
                            } else if (potential_peer_1 != null
                                    && potential_peer_2 != null) {
                                // do we need the 1 or 2 port? Decide on what we
                                // are ourselves, 1 or 2
                                if (potential_peer_1.equals(this)) {
                                    peer = potential_peer_2;
                                }
                                if (potential_peer_2.equals(this)) {
                                    peer = potential_peer_1;
                                }
                            }

                            // We have now found the peer port for this port
                            log.debug("\t Found a peer port: "
                                    + peer.getE3_has_name());

                            // Fetch the NORM_VALUE of the peer port to refer to
                            CellTracker ct = peer
                                    .fetchCellTracker("NORM_VALUE");
                            if (ct != null) {
                                String DEFAULT = "Formulasheet!"
                                        + ct.getXLSCol() + ct.getXLSRow();
                                if (!ProfGenerator.StringIsNUL(DEFAULT)) {
                                    THIS_VALUATIONFUNCTION = "(" + DEFAULT
                                            + ")";
                                    log.debug(
                                            "\t Using the NORM_VALUE of peer port "
                                                    + peer.getE3_has_name()
                                                    + " as valuation function");
                                    proceed = true;
                                }
                            }

                            if (!proceed) {
                                throw new E3ParseException(
                                        "No valuation function found for value_port "
                                                + getE3_has_name());

                            }
                        }
                    }
                }

                // Build up the elements for the valuation function
                if (f.length() > 0) {
                    f = f + "+";
                }
                f = f + "(" + ProfGenerator.Double2String(THIS_OCCURRENCES)
                        + "*" + ProfGenerator.Numberstring2Doublestring(
                                THIS_VALUATIONFUNCTION)
                        + ")";
                SUM_OCCURRENCES = SUM_OCCURRENCES
                        + THIS_OCCURRENCES.doubleValue();

                // Consider the next value exchange for this port
            }

            // All exchanges dealt with; now build the valuation function
            f = "(" + f + ")/" + ProfGenerator.double2String(SUM_OCCURRENCES);

            // Check if there is a valuation function finally
            if (ProfGenerator.StringIsNUL(f)) {
                throw new E3ParseException(
                        "No valuation function found for value_port "
                                + getE3_has_name());
            }

        } else { // NON MONEY
            log.debug("\t This is a port with a non money value object");
            // case 1: assume port has valuation function
            boolean proceed = false;
            THIS_VALUATIONFUNCTION = findValuationFunction();
            THIS_VALUATIONFUNCTION_COORDINATES = findValuationCoordinates();

            SUM_OCCURRENCES = fetchTotalOccurrences();

            if (!ProfGenerator.StringIsNUL(THIS_VALUATIONFUNCTION)) {
                log.debug(
                        "\t Found a valuation function for this port on this port");
                f = THIS_VALUATIONFUNCTION_COORDINATES;
                if (!port_is_tree_root) {
                    String msg = "Valuation function override on valueport \""
                            + getE3_has_name() + "\"\n";
                    String templog = userlog.toString();
                    if (!(templog.length() > templog.replaceAll(msg, "")
                            .length())) {
                        userlog.append(
                                "Valuation function override on valueport \""
                                        + getE3_has_name() + "\"\n");
                    }
                }
            } else
            // There is on root port level no reason to borrow valuation
            // functions from peer ports
            // or value exchanges - as is the case for money-based value
            // objects.
            // Valuation is subjective and can not be borrowed from root actors
            // (having in-out ports)
            if (!port_is_tree_root) {
                // case 2: calculate a combined valuation function from peer
                // ports and propagate it (NORM_VALUE)
                // Find ports to derive valuation functions from, to calculate a
                // NORM_VALUE function
                // We did not find a valuation function at the port itself so
                // search at connected exchanges
                // or root ports.
                Collection myExchanges = new Vector();
                if (directionIsInward()) {
                    myExchanges.addAll(getVp_first_connects_ve());
                    myExchanges.addAll(getVp_out_connects_ve());
                } else {
                    myExchanges.addAll(getVp_in_connects_ve());
                    myExchanges.addAll(getVp_second_connects_ve());
                }
                Iterator iter_myExchanges = myExchanges.iterator();

                SUM_OCCURRENCES = 0.0;
                f = "";
                while (iter_myExchanges.hasNext()) {
                    value_exchange value_exchange = (value_exchange) iter_myExchanges
                            .next();

                    // Find the outward directed peer port (we have to pop up in
                    // the tree to the root port
                    // to find a valuation function
                    value_port peer = null;
                    value_port potential_peer_i = value_exchange
                            .GetVe_has_in_po();
                    value_port potential_peer_o = value_exchange
                            .GetVe_has_out_po();
                    value_port potential_peer_1 = value_exchange
                            .GetVe_has_first_vp();
                    value_port potential_peer_2 = value_exchange
                            .GetVe_has_second_vp();

                    if (potential_peer_i != null && potential_peer_o != null) {
                        if (potential_peer_i.equals(this)) {
                            peer = potential_peer_o;
                        }
                        if (potential_peer_o.equals(this)) {
                            peer = potential_peer_i;
                        }
                    } else if (potential_peer_1 != null
                            && potential_peer_2 != null) {
                        if (potential_peer_1.equals(this)) {
                            peer = potential_peer_2;
                        }
                        if (potential_peer_2.equals(this)) {
                            peer = potential_peer_1;
                        }
                    }

                    log.debug("\t Using the NORM_VALUE of peer port "
                            + peer.getE3_has_name() + " as valuation function");
                    THIS_OCCURRENCES = peer.fetchTotalOccurrences();
                    CellTracker ct = peer.fetchCellTracker("NORM_VALUE");
                    String DEFAULT = "Formulasheet!" + ct.getXLSCol()
                            + ct.getXLSRow();
                    String sub_f = "(" + DEFAULT + "*"
                            + ProfGenerator.Double2String(THIS_OCCURRENCES)
                            + ")";
                    SUM_OCCURRENCES = SUM_OCCURRENCES
                            + THIS_OCCURRENCES.doubleValue();

                    if (f.length() > 0) {
                        f = f + "+";
                    }
                    f = f + sub_f;

                }

                if (ProfGenerator.StringIsNUL(f)) {
                    f = "0";
                } else {
                    f = "(" + f + ")/"
                            + ProfGenerator.double2String(SUM_OCCURRENCES); // divide
                }

            }
        }

        log.debug("\t Calculated normalized value: " + f);

        if (SUM_OCCURRENCES == 0) {
            f = "0";
        }

        // Set the NORM_VALUE
        if (f.length() == 0) {
            f = "0" + f;
        }
        putE3_has_formula("NORM_VALUE=" + f); // Not complete clear

        removeExpression("NORM_VALUE");

        // Now consider the exchanges related to this port; walk away from the
        // root port
        Collection traverse_ve = new Vector();
        if (directionIsInward()) {
            traverse_ve.addAll(getVp_second_connects_ve());
        } else {
            traverse_ve.addAll(getVp_first_connects_ve());
        }

        Iterator traverse_ve_i = traverse_ve.iterator();
        while (traverse_ve_i.hasNext()) {
            value_exchange ve = (value_exchange) traverse_ve_i.next();
            if (directionIsInward()) {
                ve.GetVe_has_first_vp().assignNormalisedValuationFunction(
                        "0" + f, this, ve, mapObjects, false, userlog);
            } else {
                ve.GetVe_has_second_vp().assignNormalisedValuationFunction(
                        "0" + f, this, ve, mapObjects, false, userlog);
            }
        }

    }

    /**
     * Write for a port its valuation to a spreadsheet
     *
     * @param sheet
     *            the Excel sheet to which we write
     * @param vpValueObject
     *            print ValueObject for a port
     * @param vpDirection
     *            print direction for a port
     * @param vpName
     *            print name for port
     * @param vtName
     *            print name for transfer
     * @param vtValueObject
     *            print object for transfer
     * @param initialcell
     *            with which cell do we start
     * @param initialrows
     *            with with cell do we start
     * @param xlslog
     *            file that logs activity to excel
     * @return
     * @throws Exception
     *             errors
     */
    public int writeValuationToWorkSheet(HSSFSheet sheet, boolean vpValueObject,
            boolean vpDirection, boolean vpName, boolean vtName,
            boolean vtValueObject, int initialcell, int initialrows,
            StringBuffer xlslog) throws Exception {
        log.debug("- Writing valuation characteristics to Excel");
        log.debug("\t Starting with cell: " + "(" + initialcell + ","
                + initialrows + ")");
        log.debug("\t Considering port " + getE3_has_name());

        initialcell = 1;
        int rows = 0;
        int cell = 0;

        try {
            if (hasMoneyObject()) {
                // treat as money
                log.debug("\t This is a port with a money value object");

                String THIS_VALUATIONFUNCTION = null;
                String THIS_VALUATION_STRING = null;
                Double THIS_OCCURRENCES = null;

                // Build the list of exchanges connected to this value port
                // These exchanges may have all valuation functions
                Collection myExchanges = new Vector();
                if (directionIsInward()) {
                    log.debug("\t This is an outward port");
                    myExchanges.addAll(getVp_first_connects_ve());
                    myExchanges.addAll(getVp_out_connects_ve());
                } else {
                    log.debug("\t This is an inward port");
                    myExchanges.addAll(getVp_in_connects_ve());
                    myExchanges.addAll(getVp_second_connects_ve());
                }

                Iterator iter_myExchanges = myExchanges.iterator();
                while (iter_myExchanges.hasNext()) {
                    boolean proceed = false;
                    // First look at the value exchange for valuation function
                    // (and occurrences)
                    value_exchange value_exchange = (value_exchange) iter_myExchanges
                            .next();

                    THIS_VALUATIONFUNCTION = value_exchange
                            .findValuationFunction();
                    THIS_VALUATION_STRING = value_exchange
                            .findValuationCoordinates();
                    THIS_OCCURRENCES = value_exchange.fetchOccurrences();

                    // divide if on a ms
                    double factor = 1.0;

                    market_segment parent_ms = null;
                    try {
                        value_interface parent_vi = ProfGenerator
                                .vp_belongs_to_value_interface(this);
                        parent_ms = parent_vi.GetVi_assigned_to_ms();
                        if (parent_ms != null) {
                            // We are indeed on a market segment
                            factor = factor / Double.parseDouble(
                                    parent_ms.fetchFormula("COUNT"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } // do nothing }

                    THIS_OCCURRENCES = new Double(
                            factor * THIS_OCCURRENCES.doubleValue());

                    // end divide if on a ms

                    if (!ProfGenerator.StringIsNUL(THIS_VALUATIONFUNCTION)
                            && isRootPortInContext(value_exchange)) {
                        log.debug(
                                "\t Found a valuation function on value exchange "
                                        + value_exchange.getE3_has_name()
                                        + " for this port");
                        proceed = true;
                    } else {
                        // case 2: assume port has valuation function
                        proceed = false;
                        THIS_VALUATIONFUNCTION = findValuationFunction();
                        THIS_VALUATION_STRING = findValuationCoordinates();
                        if (!ProfGenerator.StringIsNUL(THIS_VALUATIONFUNCTION)
                                && isRootPortInContext(value_exchange)) {
                            // The peer port is not allowed to have a valuation
                            // function
                            Vector peerports = new Vector();
                            peerports.add(value_exchange.GetVe_has_first_vp());
                            peerports.add(value_exchange.GetVe_has_second_vp());
                            peerports.add(value_exchange.GetVe_has_in_po());
                            peerports.add(value_exchange.GetVe_has_out_po());
                            Iterator iter_connectedpeerports = peerports
                                    .iterator();
                            while (iter_connectedpeerports.hasNext()) {
                                value_port p = (value_port) iter_connectedpeerports
                                        .next();
                                if (!equals(p) && p != null) {
                                    String PEER_VALUATIONFUNCTION = p
                                            .findValuationFunction();
                                    String PEER_VALUATION_STRING = p
                                            .findValuationCoordinates();

                                    // No valuation function on the peer port
                                    // may found,
                                    // - except if the port has in out and first
                                    // second connections

                                    if (!ProfGenerator
                                            .StringIsNUL(PEER_VALUATIONFUNCTION)
                                            && !(hasInOutConnections()
                                                    && hasFirstSecondConnections())) {
                                        throw new E3ParseException("For "
                                                + getE3_has_name()
                                                + " the peer port "
                                                + p.getE3_has_name()
                                                + " already has a valution function");
                                    }
                                }
                            }
                            proceed = true;
                            log.debug(
                                    "\t Found a valuation function on this value port");
                        } else {
                            // case 3: peer port has valuation function
                            proceed = false;
                            Vector connectedports = new Vector();
                            connectedports
                                    .add(value_exchange.GetVe_has_first_vp());
                            connectedports
                                    .add(value_exchange.GetVe_has_second_vp());
                            connectedports
                                    .add(value_exchange.GetVe_has_in_po());
                            connectedports
                                    .add(value_exchange.GetVe_has_out_po());
                            Iterator iter_connectedports = connectedports
                                    .iterator();
                            while (iter_connectedports.hasNext()) {
                                value_port peer = (value_port) iter_connectedports
                                        .next();
                                if (!equals(peer) && peer != null) {
                                    THIS_VALUATIONFUNCTION = peer
                                            .findValuationFunction();
                                    THIS_VALUATION_STRING = peer
                                            .findValuationCoordinates();
                                    if (!ProfGenerator
                                            .StringIsNUL(THIS_VALUATIONFUNCTION)
                                            && isRootPortInContext(
                                                    value_exchange)) {
                                        proceed = true;
                                        log.debug(
                                                "\t Found a valuation function on peer port "
                                                        + peer.getE3_has_name());
                                    } else {
                                        // We should use the peer as the
                                        // NORM_VALUE forms the last resort for
                                        // the
                                        // port as it forms a replacement for a
                                        // valuation function on the peer port
                                        CellTracker ct = peer
                                                .fetchCellTracker("NORM_VALUE");
                                        String VALUE = "Formulasheet!"
                                                + ct.getXLSCol()
                                                + ct.getXLSRow();
                                        if (!ProfGenerator.StringIsNUL(VALUE)) {
                                            THIS_VALUATIONFUNCTION = VALUE;
                                            THIS_VALUATION_STRING = VALUE;
                                            proceed = true;
                                            log.debug(
                                                    "\t Using the NORM_VALUE of peer port "
                                                            + peer.getE3_has_name()
                                                            + " as valuation function");
                                        }
                                        break;
                                    }
                                }
                            }
                            if (!proceed) {
                                throw new E3ParseException(
                                        "No valuation function found for value_port "
                                                + getE3_has_name());
                            }
                        }
                    }

                    // write to the excel sheet

                    if (proceed) {
                        log.debug("\t Using " + "[" + THIS_VALUATIONFUNCTION
                                + "]" + " as a valuation function for "
                                + getE3_has_name());

                        HSSFRow r = sheet.createRow(initialrows + rows);
                        HSSFCell c = r.createCell((initialcell + cell));
                        cell = 1;

                        String portDescription = findPortDescription(vpName,
                                vpDirection, vpValueObject);

                        c.setCellValue(portDescription);
                        xlslog.append(portDescription + "' ("
                                + (initialrows + rows) + "," + cell + ")\n");

                        cell = 2;
                        c = r.createCell((cell));

                        // Here the value transfer

                        String vtString = "";
                        if (vtName) {
                            vtString = value_exchange.getE3_has_name();
                        }

                        if (vtValueObject) {
                            String vtVOString = "";
                            value_port vp = value_exchange.GetVe_has_first_vp();
                            if (vp == null) {
                                vp = value_exchange.GetVe_has_second_vp();
                            }
                            if (vp == null) {
                                vp = value_exchange.GetVe_has_in_po();
                            }
                            if (vp == null) {
                                vp = value_exchange.GetVe_has_out_po();
                            }
                            if (vp != null) {
                                if (vp.GetVp_requests_offers_vo() != null
                                        && !vp.GetVp_requests_offers_vo()
                                                .getE3_has_name().equals("")) {
                                    vtVOString = vp.GetVp_requests_offers_vo()
                                            .getE3_has_name();
                                }
                            }
                            if (vtString.equals("")) {
                                vtString = vtVOString;
                            } else {
                                vtString += ":" + vtVOString;
                            }
                        }

                        if (vtString.equals("")) {
                            vtString = "unknown";
                        }
                        c.setCellValue(vtString);

                        cell = 3;
                        r = sheet.getRow(initialrows + rows);
                        c = r.createCell(cell);

                        c.setCellFormula(ProfGenerator
                                .double2String(THIS_OCCURRENCES.doubleValue()));
                        xlslog.append("'" + THIS_OCCURRENCES + "' ("
                                + (initialrows + rows) + "," + cell + ")\n");
                        String XLSCOL0 = ProfGenerator.convertToXLSCol(cell);
                        String XLSROW0 = ProfGenerator
                                .convertToXLSRow(initialrows + rows);

                        cell = 4;
                        r = sheet.getRow(initialrows + rows);
                        c = r.createCell(cell);
                        c.setCellFormula(THIS_VALUATION_STRING);
                        xlslog.append("'" + THIS_VALUATION_STRING + "' ("
                                + (initialrows + rows) + "," + cell + ")\n");
                        String XLSCOL1 = ProfGenerator.convertToXLSCol(cell);
                        String XLSROW1 = ProfGenerator
                                .convertToXLSRow(initialrows + rows);
                        cell++;

                        String ecfunction = XLSCOL0 + XLSROW0 + "*" + XLSCOL1
                                + XLSROW1;
                        if (getVp_has_dir().equals("true")) {
                            ecfunction = "0-(" + ecfunction + ")";
                        }
                        placeEconomicValueFunction(ecfunction); // Why is this
                                                                // needed?
                        r = sheet.getRow(initialrows + rows);
                        c = r.createCell(cell);
                        c.setCellFormula(ecfunction);
                        xlslog.append("'" + ecfunction + "' ("
                                + (initialrows + rows) + "," + cell + ")\n");
                        cell = 0;
                        rows++;
                    }
                }
            } else {
                // all other objects

                // Here the FormulaConstants.CARDINALITY should be considered
                // Since we do not consider each exchange for a port (as we do
                // for MONEY objects)
                // we can use the NORM_CARD function for this port
                String CARDFUNCTION = findFormula("NORM_CARD");
                String CARDFUNCTION_COORDINATES = findFormulaCoordinates(
                        "NORM_CARD");
                if (ProfGenerator.StringIsNUL(CARDFUNCTION)) {
                    throw new E3ParseException("No " + "NORM_CARD"
                            + " function found for value port "
                            + getE3_has_name());
                }

                Double TOTALOCCURRENCES = fetchTotalOccurrences();

                String VALUATIONFUNCTION = findValuationFunction();
                String VALUATIONFUNCTION_COORDINATES = findValuationCoordinates();

                // write
                cell = 1;
                HSSFRow r = sheet.createRow(initialrows + rows);
                HSSFCell c = r.createCell((cell));

                CellTracker ct = fetchCellTracker("NAME");

                String portDescription = findPortDescription(vpName,
                        vpDirection, vpValueObject);

                c.setCellValue(portDescription);
                xlslog.append(portDescription + "' (" + (initialrows + rows)
                        + "," + cell + ")\n");

                cell++;

                c = r.createCell((cell));
                c.setCellValue("(all transfers)");
                xlslog.append("'(all transfers)' (" + (initialrows + rows) + ","
                        + initialcell + cell + cell + ")\n");
                cell++;

                c = r.createCell((cell));

                c.setCellFormula(ProfGenerator.Double2String(TOTALOCCURRENCES));

                xlslog.append("'" + TOTALOCCURRENCES + "' ("
                        + (initialrows + rows) + "," + cell + ")\n");
                String XLSCOL0 = ProfGenerator.convertToXLSCol(cell);
                String XLSROW0 = ProfGenerator
                        .convertToXLSRow(initialrows + rows);
                cell++;

                c = r.createCell((cell));
                if (!ProfGenerator.StringIsNUL(VALUATIONFUNCTION)) {
                    c.setCellFormula(VALUATIONFUNCTION_COORDINATES + "*"
                            + CARDFUNCTION_COORDINATES);
                } else {
                    ct = fetchCellTracker("NORM_VALUE");
                    String DEFAULT = "Formulasheet!" + ct.getXLSCol()
                            + ct.getXLSRow();
                    c.setCellFormula(DEFAULT + "*" + CARDFUNCTION_COORDINATES);
                }
                xlslog.append("'" + VALUATIONFUNCTION_COORDINATES + "' ("
                        + (initialrows + rows) + "," + cell + ")\n");

                String XLSCOL1 = ProfGenerator.convertToXLSCol(cell);
                String XLSROW1 = ProfGenerator
                        .convertToXLSRow(initialrows + rows);
                cell++;

                String ecfunction = XLSCOL0 + XLSROW0 + "*" + XLSCOL1 + XLSROW1;

                if (getVp_has_dir().equals("true")) {
                    ecfunction = "0-(" + ecfunction + ")";
                }
                placeEconomicValueFunction(ecfunction);

                c = r.createCell((cell));
                c.setCellFormula(ecfunction);

                xlslog.append("'" + ecfunction + "' (" + (initialrows + rows)
                        + "," + cell + ")\n");
                cell++;
                rows++;
            }
        } catch (NullPointerException e) {
        }

        return rows;
    }

    public String fetchEconomicValueFunction() {
        return economicValueFunction;
    }

    public void placeEconomicValueFunction(String economicValueFunction) {
        this.economicValueFunction = economicValueFunction;
    }

    private String economicValueFunction = null;

    public double getHits(Map mapObjects) throws Exception {

        double hits = 0;
        Collection value_exchanges = getVp_in_connects_ve();
        value_exchanges.addAll(getVp_out_connects_ve());
        value_exchanges.addAll(getVp_first_connects_ve());
        value_exchanges.addAll(getVp_second_connects_ve());

        Iterator i = value_exchanges.iterator();
        while (i.hasNext()) {
            value_exchange value_exchange = (value_exchange) i.next();
            value_port vpa = null;
            value_port vpb = null;
            vpa = value_exchange.GetVe_has_first_vp();
            vpb = value_exchange.GetVe_has_second_vp();
            if (vpa == null || vpb == null) {
                vpa = value_exchange.GetVe_has_in_po();
                vpb = value_exchange.GetVe_has_out_po();
            }
            Double hit = value_exchange.fetchOccurrences();
            if (hit != null) {
                hits += hit.doubleValue();
            }
        }

        return hits;
    }

    /**
     * Do we have in - out connections
     *
     * @return true if there any in - out connections
     */
    public boolean hasInOutConnections() {
        return (getVp_in_connects_ve().size() > 0
                || getVp_out_connects_ve().size() > 0);
    }

    /**
     * Do we have first - second connections
     *
     * @return true if there any first - second connections
     */
    public boolean hasFirstSecondConnections() {
        return (getVp_first_connects_ve().size() > 0
                || getVp_second_connects_ve().size() > 0);
    }

    public void generateNormCells(String name, E3HSSFWorkbook wb,
            String instances_namespace, Map mapObjects) {
        String NORM_VALUE = null;
        NORM_VALUE = fetchExpression(name);

        if (NORM_VALUE != null && !(NORM_VALUE.equals(""))
                && !(NORM_VALUE.equals("null"))) {

            NORM_VALUE = ProfGenerator.populateParsedFormula(NORM_VALUE,
                    instances_namespace, mapObjects);
            CellTracker ct = fetchCellTracker(name);

            HSSFSheet formulasheet = wb.getSheet("Formulasheet");

            int cellnum = (short) ct.getCol();
            int rownum = ct.getRow();
            HSSFRow row = formulasheet.getRow(rownum);
            HSSFCell cell = row.getCell(cellnum);

            cell.setCellFormula(NORM_VALUE);

            cell = row.createCell((cellnum + 1));
            cell.setCellFormula(NORM_VALUE);

        }
    }

    /**
     * Determine if we are a root port only. This is the case if there are not
     * first/second transers.
     *
     * @return true if we are a root port only; otherwise false.
     */
    boolean isRootPortOnly() {
        if (!hasFirstSecondConnections()) {
            log.debug("\t\t This is a root port only");
            return true;
        }

        return (false);
    }

    /**
     * Determine if we are a non-root port only. This is the case if there are
     * only first/second transers.
     *
     * @return true if we are a non-root port only; otherwise false.
     */
    boolean isNonRootPortOnly() {
        if (!hasInOutConnections()) {
            log.debug("\t\t This is a non-root port only");
            return true;
        }

        return (false);
    }

    /**
     * Determine if we are a root port in the context of a value exchange A
     * value port is a root port if it has in/out exchanges connected. It is so
     * in the context of the given value exchange if that value exchange is an
     * in/out exchange
     *
     * @param ve
     *            value_exchange serving as context in which we have to decide
     *            whether we are a root port or not
     * @return true if we are a root port in the given context, otherwise return
     *         false
     */
    boolean isRootPortInContext(value_exchange ve) {
        // first check if we are a root object in the first place
        if (!hasInOutConnections()) {
            log.debug("\t\t No in/out connections at all. So no root port");
            return false;
        }

        // we have at least on in/out connection
        // now check if the value exchange providing the context is connected to
        // such an in/out connection
        Collection exs = null;
        if (directionIsInward()) {
            exs = getVp_out_connects_ve();
        } else {
            exs = getVp_in_connects_ve();
        }

        if (exs == null) {
            log.debug(
                    "\t\t No in/out connect exchanges at all. So no root port");
            return false;
        }

        for (Iterator iter = exs.iterator(); iter.hasNext();) {
            final value_exchange cv = (value_exchange) iter.next();

            if (cv.equals(ve)) {
                log.debug(
                        "\t\t Found exchange for this port. So a root port in the context of "
                                + ve.getE3_has_name());
                return true;
            }
        }

        log.debug(
                "\t\t Not found exchange for this port. So not a root port in the context of "
                        + ve.getE3_has_name());
        return false;
    }

    // ********************************
    /**
     * Write for a port its expenses to a spreadsheet
     *
     * @param sheet
     *            the Excel sheet to which we write
     * @param vpValueObject
     *            print ValueObject for a port
     * @param vpDirection
     *            print direction for a port
     * @param vpName
     *            print name for port
     * @param vtName
     *            print name for transfer
     * @param vtValueObject
     *            print object for transfer
     * @param initialcell
     *            with which cell do we start
     * @param initialrows
     *            with with cell do we start
     * @param xlslog
     *            file that logs activity to excel
     * @return
     * @throws Exception
     *             errors
     */
    public int writeExpensesToWorkSheet(HSSFSheet sheet, boolean vpValueObject,
            boolean vpDirection, boolean vpName, boolean vtName,
            boolean vtValueObject, int initialcell, int initialrows,
            StringBuffer xlslog) throws Exception {
        log.debug("- Writing expenses characteristics to Excel");
        log.debug("\t Starting with cell: " + "(" + initialcell + ","
                + initialrows + ")");
        log.debug("\t Considering port " + getE3_has_name());

        initialcell = 1;
        int rows = 0;
        int cell = 0;

        // Expenses are per value object transfered.
        // So, here the cardinality should be considered
        // Since we do not consider each exchange for a port
        // (as we do e.g. for MONEY objects while calculating valuation
        // functions)
        // we can use the NORM_CARD function for this port
        String CARDFUNCTION = findFormula("NORM_CARD");
        String CARDFUNCTION_COORDINATES = findFormulaCoordinates("NORM_CARD");
        if (ProfGenerator.StringIsNUL(CARDFUNCTION)) {
            throw new E3ParseException("No " + "NORM_CARD"
                    + " function found for value port " + getE3_has_name());
        }

        // Ports have variable expenses, so we need to know the occurrences to
        // multiply with
        Double TOTALOCCURRENCES = fetchTotalOccurrences();

        // Fetch expenses function
        String EXPENSESFUNCTION = findFormula("EXPENSES");
        if (!ProfGenerator.StringIsNUL(EXPENSESFUNCTION)) {
            String EXPENSESFUNCTION_COORDINATES = findFormulaCoordinates(
                    "EXPENSES");

            cell = 1;
            HSSFRow r = sheet.createRow(initialrows + rows);
            HSSFCell c = r.createCell((cell));

            String portDescription = findPortDescription(vpName, vpDirection,
                    vpValueObject);

            c.setCellValue(portDescription);
            xlslog.append(portDescription + "' (" + (initialrows + rows) + ","
                    + cell + ")\n");

            cell++;

            c = r.createCell((cell));
            c.setCellValue("(EXPENSES)");
            xlslog.append("'(EXPENSES)' (" + (initialrows + rows) + ","
                    + initialcell + cell + cell + ")\n");
            cell++;

            c = r.createCell((cell));
            c.setCellFormula(ProfGenerator.Double2String(TOTALOCCURRENCES));

            xlslog.append("'" + TOTALOCCURRENCES + "' (" + (initialrows + rows)
                    + "," + cell + ")\n");
            String XLSCOL0 = ProfGenerator.convertToXLSCol(cell);
            String XLSROW0 = ProfGenerator.convertToXLSRow(initialrows + rows);
            cell++;

            c = r.createCell((cell));

            c.setCellFormula(EXPENSESFUNCTION_COORDINATES + "*"
                    + CARDFUNCTION_COORDINATES);
            xlslog.append("'" + EXPENSESFUNCTION_COORDINATES + "' ("
                    + (initialrows + rows) + "," + cell + ")\n");

            String XLSCOL1 = ProfGenerator.convertToXLSCol(cell);
            String XLSROW1 = ProfGenerator.convertToXLSRow(initialrows + rows);
            cell++;

            String ecfunction = XLSCOL0 + XLSROW0 + "*" + XLSCOL1 + XLSROW1;
            // Make it a negative number - an expense is always a cash out flow
            ecfunction = "0-(" + ecfunction + ")";
            c = r.createCell((cell));
            c.setCellFormula(ecfunction);
            xlslog.append("'" + ecfunction + "' (" + (initialrows + rows) + ","
                    + cell + ")\n");
            cell++;
            rows++;
        }
        return rows;
    }

    /**
     * Generate a string that describes the port
     *
     * @param vpName
     * @param vpDirection
     * @param vpValueObject
     * @return
     */
    String findPortDescription(boolean vpName, boolean vpDirection,
            boolean vpValueObject) {

        String portDescription = "";

        if (vpName) {
            if (!portDescription.equals("")) {
                portDescription += ": " + getE3_has_name();
            } else {
                portDescription = getE3_has_name();
            }
        }

        if (vpDirection) {
            String dir = "in";
            if (Boolean.parseBoolean(getVp_has_dir()) == true) {
                dir = "out";
            }
            if (!portDescription.equals("")) {
                portDescription += ": " + dir;
            } else {
                portDescription = dir;
            }
        }

        if (vpValueObject) {
            if (GetVp_requests_offers_vo() != null) {
                if (!portDescription.equals("")) {
                    portDescription += ": "
                            + GetVp_requests_offers_vo().getE3_has_name();
                } else {
                    portDescription = GetVp_requests_offers_vo()
                            .getE3_has_name();
                }
            }
        }

        // finally;
        if (portDescription.equals("")) {
            portDescription = "unknown";
        }

        return portDescription;
    }

}

// RDFS2Class: end of class value_port
// EOF
