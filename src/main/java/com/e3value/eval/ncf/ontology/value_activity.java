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

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
// RDFS2Class: end of imports
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.e3value.eval.ncf.CellTracker;
import com.e3value.eval.ncf.E3HSSFWorkbook;
import com.e3value.eval.ncf.E3ParseException;
import com.e3value.eval.ncf.ProfGenerator;

/**
 * RDFS2Class: class value_activity
 * <p>
 */
public class value_activity extends model_concept implements Serializable {

    static Logger log = Logger.getLogger(value_activity.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot va_has_vi **/
    protected de.dfki.rdf.util.PropertyInfo m_va_has_vi = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("va_has_vi",
                    new Class[] { value_interface.class }, true);

    /** RDFS2Class: putter for slot va_has_vi **/
    public void putVa_has_vi(value_interface p_va_has_vi) {
        m_va_has_vi.putValue(p_va_has_vi);
    }

    public void putVa_has_vi(de.dfki.rdf.util.RDFResource p_va_has_vi) {
        m_va_has_vi.putValue(p_va_has_vi);
    }

    public void putVa_has_vi(java.util.Collection p_va_has_vi) {
        m_va_has_vi.setValues(p_va_has_vi);
    }

    public void clearVa_has_vi() {
        m_va_has_vi.clearValue();
    }
    // RDFS2Class: end of putter for slot va_has_vi

    /** RDFS2Class: getter for slot va_has_vi **/
    public java.util.Collection getVa_has_vi() {
        return (java.util.Collection) m_va_has_vi.getValue();
    }
    // RDFS2Class: end of getter for slot va_has_vi

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot va_performed_by_ms **/
    protected de.dfki.rdf.util.PropertyInfo m_va_performed_by_ms = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("va_performed_by_ms",
                    new Class[] { market_segment.class }, false);

    /** RDFS2Class: putter for slot va_performed_by_ms **/
    public void putVa_performed_by_ms(market_segment p_va_performed_by_ms) {
        m_va_performed_by_ms.putValue(p_va_performed_by_ms);
    }

    public void putVa_performed_by_ms(
            de.dfki.rdf.util.RDFResource p_va_performed_by_ms) {
        m_va_performed_by_ms.putValue(p_va_performed_by_ms);
    }
    // RDFS2Class: end of putter for slot va_performed_by_ms

    /** RDFS2Class: getter for slot va_performed_by_ms **/
    public market_segment GetVa_performed_by_ms() {
        return (market_segment) m_va_performed_by_ms.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVa_performed_by_ms() {
        return (de.dfki.rdf.util.RDFResource) m_va_performed_by_ms.getValue();
    }
    // RDFS2Class: end of getter for slot va_performed_by_ms

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot va_performed_by_el **/
    protected de.dfki.rdf.util.PropertyInfo m_va_performed_by_el = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("va_performed_by_el",
                    new Class[] { elementary_actor.class }, false);

    /** RDFS2Class: putter for slot va_performed_by_el **/
    public void putVa_performed_by_el(elementary_actor p_va_performed_by_el) {
        m_va_performed_by_el.putValue(p_va_performed_by_el);
    }

    public void putVa_performed_by_el(
            de.dfki.rdf.util.RDFResource p_va_performed_by_el) {
        m_va_performed_by_el.putValue(p_va_performed_by_el);
    }
    // RDFS2Class: end of putter for slot va_performed_by_el

    /** RDFS2Class: getter for slot va_performed_by_el **/
    public elementary_actor GetVa_performed_by_el() {
        return (elementary_actor) m_va_performed_by_el.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVa_performed_by_el() {
        return (de.dfki.rdf.util.RDFResource) m_va_performed_by_el.getValue();
    }
    // RDFS2Class: end of getter for slot va_performed_by_el

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (!m_va_has_vi.isEmpty()) {
            sb.append(sIndent + "-> va_has_vi:\n");
            for (Iterator it_va_has_vi = ((java.util.Collection) m_va_has_vi
                    .getValue()).iterator(); it_va_has_vi.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_va_has_vi.next())
                                .toStringShort()
                        + "\n");
                // sb.append(
                // ((de.dfki.rdf.util.RDFResource)it_va_has_vi.next()).toString(sIndent+"
                // ") );
            }
        }
        if (m_va_performed_by_ms.getValue() != null) {
            sb.append(sIndent + "-> va_performed_by_ms:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_va_performed_by_ms
                            .getValue()).toStringShort()
                    + "\n");
            // sb.append(sIndent+"->
            // va_performed_by_ms:\n"+((de.dfki.rdf.util.RDFResource)m_va_performed_by_ms.getValue()).toString(sIndent+"
            // "));
        }
        if (m_va_performed_by_el.getValue() != null) {
            sb.append(sIndent + "-> va_performed_by_el:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_va_performed_by_el
                            .getValue()).toStringShort()
                    + "\n");
            // sb.append(sIndent+"->
            // va_performed_by_el:\n"+((de.dfki.rdf.util.RDFResource)m_va_performed_by_el.getValue()).toString(sIndent+"
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
    public value_activity() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_va_has_vi);
        ps.addProperty(m_va_performed_by_ms);
        ps.addProperty(m_va_performed_by_el);
    }
    // RDFS2Class: end of PropertyStore-stuff

    public void generateExpCells(String name, E3HSSFWorkbook wb,
            String instances_namespace, Map mapObjects) {
        String EXP_VALUE = null;
        EXP_VALUE = fetchExpression(name);

        if (EXP_VALUE != null && !(EXP_VALUE.equals(""))
                && !(EXP_VALUE.equals("null"))) {

            EXP_VALUE = ProfGenerator.populateParsedFormula(EXP_VALUE,
                    instances_namespace, mapObjects);

            CellTracker ct = fetchCellTracker(name);

            // begin timeseries
            // disabled: HSSFSheet formulasheet = wb.getSheet("Formulasheet");
            HSSFSheet formulasheet = wb.getSheet("Formulasheet");
            // end timeseries
            int cellnum = (short) ct.getCol();
            int rownum = ct.getRow();
            HSSFRow row = formulasheet.getRow(rownum);
            HSSFCell cell = row.getCell(cellnum);
            cell.setCellFormula(EXP_VALUE);

            cell = row.createCell(cellnum + 1);
            cell.setCellFormula(EXP_VALUE);

        }
    }

    /**
     * Calculate the total variable expenses as assigned to the ports of this
     * activity
     *
     * @param formulaName
     *            name of the total expenses formula
     * @throws Exception
     */

    public void assignTotalVariableExpenses(String formulaName)
            throws Exception {
        // Preambule - do the logging
        log.debug("\t Assigning " + formulaName);
        log.debug("\t considering activity: " + getE3_has_name());

        // The formula to be used for the formalaName
        String formula = "";

        // Calculate formula
        formula = findTotalVariableExpenses();

        log.debug("\t Calculated formula: " + formula);

        // Set the formula
        if (formula.length() == 0) {
            formula = "0" + formula;
        }
        putE3_has_formula(formulaName + "=" + formula);

        removeExpression(formulaName);
    }

    /**
     * Find a formula string that expresses total variable expenses for this
     * value activity
     *
     * @return
     * @throws Exception
     */
    private String findTotalVariableExpenses() throws Exception {

        String formula = "";

        // Iterate over all ports of the activity
        Iterator iter_value_interfaces = null;

        Collection value_interfaces = getVa_has_vi();
        iter_value_interfaces = value_interfaces.iterator();
        while (iter_value_interfaces.hasNext()) {
            value_interface vi = (value_interface) iter_value_interfaces.next();
            Collection vOs = vi.getVi_consists_of_of();
            Iterator iter_value_offerings = vOs.iterator();
            while (iter_value_offerings.hasNext()) {
                value_offering vO = (value_offering) iter_value_offerings
                        .next();
                Collection vPs = vO.getVo_consists_of_vp();
                Iterator iter_value_ports = vPs.iterator();
                while (iter_value_ports.hasNext()) {
                    value_port vP = (value_port) iter_value_ports.next();
                    // does this port have a formula
                    String EXPENSESFUNCTION = vP.findFormula("EXPENSES");
                    if (!ProfGenerator.StringIsNUL(EXPENSESFUNCTION)) {
                        String EXPENSESFUNCTION_COORDINATES = vP
                                .findFormulaCoordinates("EXPENSES");

                        // Find other functions - CARDINALITY and OCCURRENCES
                        String CARDFUNCTION = vP.findFormula("NORM_CARD");
                        String CARDFUNCTION_COORDINATES = vP
                                .findFormulaCoordinates("NORM_CARD");
                        if (ProfGenerator.StringIsNUL(CARDFUNCTION)) {
                            throw new E3ParseException("No " + "NORM_CARD"
                                    + " function found for value port "
                                    + vP.getE3_has_name());
                        }
                        // Ports have variable expenses, so we need to know the
                        // occurrences to multiply with
                        Double TOTALOCCURRENCES = vP.fetchTotalOccurrences();

                        if (formula == "") {
                            formula = EXPENSESFUNCTION_COORDINATES + "*"
                                    + CARDFUNCTION_COORDINATES + "*"
                                    + TOTALOCCURRENCES;
                        } else {
                            formula += "+" + EXPENSESFUNCTION_COORDINATES + "*"
                                    + CARDFUNCTION_COORDINATES + "*"
                                    + TOTALOCCURRENCES;
                        }

                    }
                }
            }
        }

        return formula;
    }

}
// RDFS2Class: end of class value_activity
// EOF
