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

import org.apache.log4j.Logger;

import com.e3value.eval.ncf.CellTracker;
import com.e3value.eval.ncf.E3ParseException;
import com.e3value.eval.ncf.Globals;
import com.e3value.eval.ncf.ProfGenerator;

// RDFS2Class: end of imports

/**
 * RDFS2Class: class value_exchange
 * <p>
 */
public class value_exchange extends model_concept {

    static Logger log = Logger.getLogger(value_exchange.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ve_has_in_po **/
    protected de.dfki.rdf.util.PropertyInfo m_ve_has_in_po = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ve_has_in_po",
                    new Class[] { value_port.class }, false);

    /** RDFS2Class: putter for slot ve_has_in_po **/
    public void putVe_has_in_po(value_port p_ve_has_in_po) {
        m_ve_has_in_po.putValue(p_ve_has_in_po);
    }

    public void putVe_has_in_po(de.dfki.rdf.util.RDFResource p_ve_has_in_po) {
        m_ve_has_in_po.putValue(p_ve_has_in_po);
    }
    // RDFS2Class: end of putter for slot ve_has_in_po

    /** RDFS2Class: getter for slot ve_has_in_po **/
    public value_port GetVe_has_in_po() {
        return (value_port) m_ve_has_in_po.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVe_has_in_po() {
        return (de.dfki.rdf.util.RDFResource) m_ve_has_in_po.getValue();
    }
    // RDFS2Class: end of getter for slot ve_has_in_po

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ve_has_second_vp **/
    protected de.dfki.rdf.util.PropertyInfo m_ve_has_second_vp = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ve_has_second_vp",
                    new Class[] { value_port.class }, false);

    /** RDFS2Class: putter for slot ve_has_second_vp **/
    public void putVe_has_second_vp(value_port p_ve_has_second_vp) {
        m_ve_has_second_vp.putValue(p_ve_has_second_vp);
    }

    public void putVe_has_second_vp(
            de.dfki.rdf.util.RDFResource p_ve_has_second_vp) {
        m_ve_has_second_vp.putValue(p_ve_has_second_vp);
    }
    // RDFS2Class: end of putter for slot ve_has_second_vp

    /** RDFS2Class: getter for slot ve_has_second_vp **/
    public value_port GetVe_has_second_vp() {
        return (value_port) m_ve_has_second_vp.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVe_has_second_vp() {
        return (de.dfki.rdf.util.RDFResource) m_ve_has_second_vp.getValue();
    }
    // RDFS2Class: end of getter for slot ve_has_second_vp

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ve_has_out_po **/
    protected de.dfki.rdf.util.PropertyInfo m_ve_has_out_po = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ve_has_out_po",
                    new Class[] { value_port.class }, false);

    /** RDFS2Class: putter for slot ve_has_out_po **/
    public void putVe_has_out_po(value_port p_ve_has_out_po) {
        m_ve_has_out_po.putValue(p_ve_has_out_po);
    }

    public void putVe_has_out_po(de.dfki.rdf.util.RDFResource p_ve_has_out_po) {
        m_ve_has_out_po.putValue(p_ve_has_out_po);
    }
    // RDFS2Class: end of putter for slot ve_has_out_po

    /** RDFS2Class: getter for slot ve_has_out_po **/
    public value_port GetVe_has_out_po() {
        return (value_port) m_ve_has_out_po.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVe_has_out_po() {
        return (de.dfki.rdf.util.RDFResource) m_ve_has_out_po.getValue();
    }
    // RDFS2Class: end of getter for slot ve_has_out_po

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ve_has_first_vp **/
    protected de.dfki.rdf.util.PropertyInfo m_ve_has_first_vp = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ve_has_first_vp",
                    new Class[] { value_port.class }, false);

    /** RDFS2Class: putter for slot ve_has_first_vp **/
    public void putVe_has_first_vp(value_port p_ve_has_first_vp) {
        m_ve_has_first_vp.putValue(p_ve_has_first_vp);
    }

    public void putVe_has_first_vp(
            de.dfki.rdf.util.RDFResource p_ve_has_first_vp) {
        m_ve_has_first_vp.putValue(p_ve_has_first_vp);
    }
    // RDFS2Class: end of putter for slot ve_has_first_vp

    /** RDFS2Class: getter for slot ve_has_first_vp **/
    public value_port GetVe_has_first_vp() {
        return (value_port) m_ve_has_first_vp.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVe_has_first_vp() {
        return (de.dfki.rdf.util.RDFResource) m_ve_has_first_vp.getValue();
    }
    // RDFS2Class: end of getter for slot ve_has_first_vp

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ve_valuation **/
    protected de.dfki.rdf.util.PropertyInfo m_ve_valuation = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("ve_valuation", false);

    /** RDFS2Class: putter for slot ve_valuation **/
    public void putVe_valuation(String p_ve_valuation) {
        m_ve_valuation.putValue(p_ve_valuation);
    }
    // RDFS2Class: end of putter for slot ve_valuation

    /** RDFS2Class: getter for slot ve_valuation **/
    public String getVe_valuation() {
        return (String) m_ve_valuation.getValue();
    }
    // RDFS2Class: end of getter for slot ve_valuation

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ve_in_vt **/
    protected de.dfki.rdf.util.PropertyInfo m_ve_in_vt = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ve_in_vt",
                    new Class[] { value_transaction.class }, true);

    /** RDFS2Class: putter for slot ve_in_vt **/
    public void putVe_in_vt(value_transaction p_ve_in_vt) {
        m_ve_in_vt.putValue(p_ve_in_vt);
    }

    public void putVe_in_vt(de.dfki.rdf.util.RDFResource p_ve_in_vt) {
        m_ve_in_vt.putValue(p_ve_in_vt);
    }

    public void putVe_in_vt(java.util.Collection p_ve_in_vt) {
        m_ve_in_vt.setValues(p_ve_in_vt);
    }

    public void clearVe_in_vt() {
        m_ve_in_vt.clearValue();
    }
    // RDFS2Class: end of putter for slot ve_in_vt

    /** RDFS2Class: getter for slot ve_in_vt **/
    public java.util.Collection getVe_in_vt() {
        return (java.util.Collection) m_ve_in_vt.getValue();
    }
    // RDFS2Class: end of getter for slot ve_in_vt

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (m_ve_has_in_po.getValue() != null) {
            sb.append(sIndent + "-> ve_has_in_po:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_ve_has_in_po.getValue())
                            .toStringShort()
                    + "\n");
        }
        if (m_ve_has_second_vp.getValue() != null) {
            sb.append(sIndent + "-> ve_has_second_vp:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_ve_has_second_vp
                            .getValue()).toStringShort()
                    + "\n");
        }
        if (m_ve_has_out_po.getValue() != null) {
            sb.append(sIndent + "-> ve_has_out_po:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_ve_has_out_po
                            .getValue()).toStringShort()
                    + "\n");
        }
        if (m_ve_has_first_vp.getValue() != null) {
            sb.append(sIndent + "-> ve_has_first_vp:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_ve_has_first_vp
                            .getValue()).toStringShort()
                    + "\n");
        }
        if (m_ve_valuation.getValue() != null) {
            sb.append(sIndent + "-> ve_valuation: " + m_ve_valuation.getValue()
                    + "\n");
        }
        if (!m_ve_in_vt.isEmpty()) {
            sb.append(sIndent + "-> ve_in_vt:\n");
            for (Iterator it_ve_in_vt = ((java.util.Collection) m_ve_in_vt
                    .getValue()).iterator(); it_ve_in_vt.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_ve_in_vt.next())
                                .toStringShort()
                        + "\n");
            }
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = {};

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public value_exchange() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_ve_has_in_po);
        ps.addProperty(m_ve_has_second_vp);
        ps.addProperty(m_ve_has_out_po);
        ps.addProperty(m_ve_has_first_vp);
        ps.addProperty(m_ve_valuation);
        ps.addProperty(m_ve_in_vt);
    }

    // RDFS2Class: end of PropertyStore-stuff

    public Double fetchOccurrences() throws Exception {
        double d = 0.0;
        boolean returnvalue = false;
        Collection inTransactions = getVe_in_vt();
        Iterator iter_inTransactions = inTransactions.iterator();

        if (getVe_in_vt().size() == 0) {
            throw new E3ParseException("value exchange '" + getE3_has_name()
                    + "' is not involved in any value transactions");
        }

        while (iter_inTransactions.hasNext()) {
            value_transaction t = (value_transaction) iter_inTransactions
                    .next();
            if (t != null) {
                try {
                    double value = (t.fetchScenarioUsage().getTotalOccurences())
                            .doubleValue();
                    d = d + value;
                    returnvalue = true;
                } catch (NullPointerException nul) {
                    throw new E3ParseException(
                            "No occurrences could be calculated for '"
                                    + t.getE3_has_name() + "' ("
                                    + Globals
                                            .mediumName(t.getClass().toString())
                                    + ")\nThis indicates an incomplete path. Please check your model.",
                            nul);
                }
            }
        }
        if (returnvalue) {
            return new Double(d);
        } else {
            return null;
        }
    }

    /**
     * will be replaced by the function below
     *
     * @return
     */
    public String findValuationFunction() {
        try {
            String f = fetchExpression("VALUATION");
            if (f != null) {
                if (f.equals("")) {
                    return null;
                } else {
                    return f;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * Finds a formula
     *
     * @param formula
     * @return the body of the formula
     */
    public String findFormula(String formula) {
        try {
            String f = fetchExpression(formula);
            if (f != null) {
                if (f.equals("")) {
                    return null;
                } else {
                    return f;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * will be replaced by the function below
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
     * Finds the Excel coordinates of a formula
     *
     * @param formula
     * @return the coordinates
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

    public boolean fetchFirstSecondType() {
        if (GetVe_has_first_vp() != null && GetVe_has_second_vp() != null) {
            return true;
        }
        return false;
    }

    public boolean fetchInOutType() {
        if (GetVe_has_in_po() != null && GetVe_has_out_po() != null) {
            return true;
        }
        return false;
    }

    public boolean connectsPortsWithEqualValueObject()
            throws E3ParseException, NullPointerException {
        value_object vo1 = null;
        value_object vo2 = null;
        value_port vp1 = null;
        value_port vp2 = null;

        vp1 = GetVe_has_in_po();
        vp2 = GetVe_has_out_po();
        if (vp1 == null || vp2 == null) {
            vp1 = GetVe_has_first_vp();
            vp2 = GetVe_has_second_vp();
        }
        if (vp1 == null || vp2 == null) {
            throw new E3ParseException("value_exchange '" + getE3_has_name()
                    + "' does not have a valid set of connected ports");
        }

        vo1 = vp1.GetVp_requests_offers_vo();
        vo2 = vp2.GetVp_requests_offers_vo();

        if (vo1 == null && vo2 != null) {
            return false;
        }
        if (vo1 != null && vo2 == null) {
            return false;
        }

        if (vo1 == null && vo2 == null) {
            return true;
        }
        if (vo1.equals(vo2)) {
            return true;
        }

        return false;
    }
}

// RDFS2Class: end of class value_exchange
// EOF
