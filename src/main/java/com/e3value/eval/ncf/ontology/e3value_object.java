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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.e3value.eval.ncf.CellTracker;
import com.e3value.eval.ncf.E3ParseException;
import com.e3value.eval.ncf.FormulaConstants;
import com.e3value.eval.ncf.Globals;
import com.e3value.eval.ncf.ProfGenerator;
import com.e3value.eval.ncf.ScenarioUsage;

import de.dfki.rdf.util.THING;

// RDFS2Class: end of imports

/**
 * RDFS2Class: class e3value_object
 * <p>
 */
public class e3value_object extends THING {

    static Logger log = Logger.getLogger(e3value_object.class.getName());

    private Map trackXLSPosition = new HashMap();

    public ScenarioUsage fetchScenarioUsage() {
        return myScenarioUsage;
    }

    public void appendScenarioUsage(start_stimulus start, double value)
            throws E3ParseException {
        myScenarioUsage.appendScenarioUsage(start, value);
    }

    public boolean hasScenarioUsage(start_stimulus start)
            throws E3ParseException {
        Set stimuli = myScenarioUsage.getStartStimuli();
        if (stimuli.contains(start)) {
            return true;
        }
        return false;
    }

    private ScenarioUsage myScenarioUsage = new ScenarioUsage(this);

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot e3_has_formula **/
    protected de.dfki.rdf.util.PropertyInfo m_e3_has_formula = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("e3_has_formula", true);

    /** RDFS2Class: putter for slot e3_has_formula **/
    public void putE3_has_formula(String p_e3_has_formula) {
        m_e3_has_formula.putValue(p_e3_has_formula);
    }

    public void putE3_has_formula(
            de.dfki.rdf.util.RDFResource p_e3_has_formula) {
        m_e3_has_formula.putValue(p_e3_has_formula);
    }

    public void putE3_has_formula(java.util.Collection p_e3_has_formula) {
        m_e3_has_formula.setValues(p_e3_has_formula);
    }

    public void clearE3_has_formula() {
        m_e3_has_formula.clearValue();
    }
    // RDFS2Class: end of putter for slot e3_has_formula

    /** RDFS2Class: getter for slot e3_has_formula **/
    public java.util.Collection getE3_has_formula() {
        return (java.util.Collection) m_e3_has_formula.getValue();
    }
    // RDFS2Class: end of getter for slot e3_has_formula

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot e3_has_uid **/
    protected de.dfki.rdf.util.PropertyInfo m_e3_has_uid = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("e3_has_uid", false);

    /** RDFS2Class: putter for slot e3_has_uid **/
    public void putE3_has_uid(String p_e3_has_uid) {
        m_e3_has_uid.putValue(p_e3_has_uid);
    }
    // RDFS2Class: end of putter for slot e3_has_uid

    /** RDFS2Class: getter for slot e3_has_uid **/
    public String getE3_has_uid() {
        return (String) m_e3_has_uid.getValue();
    }
    // RDFS2Class: end of getter for slot e3_has_uid

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot e3_has_name **/
    protected de.dfki.rdf.util.PropertyInfo m_e3_has_name = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("e3_has_name", false);

    /** RDFS2Class: putter for slot e3_has_name **/
    public void putE3_has_name(String p_e3_has_name) {
        p_e3_has_name = p_e3_has_name.replaceAll("\n", "");
        m_e3_has_name.putValue(p_e3_has_name);
    }
    // RDFS2Class: end of putter for slot e3_has_name

    /** RDFS2Class: getter for slot e3_has_name **/
    public String getE3_has_name() {
        return (String) m_e3_has_name.getValue();
    }
    // RDFS2Class: end of getter for slot e3_has_name

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (!m_e3_has_formula.isEmpty()) {
            sb.append(sIndent + "-> e3_has_formula:\n");
            for (Iterator it_e3_has_formula = ((java.util.Collection) m_e3_has_formula
                    .getValue()).iterator(); it_e3_has_formula.hasNext();) {
                sb.append((String) it_e3_has_formula.next() + "\n");
            }
        }
        if (m_e3_has_uid.getValue() != null) {
            sb.append(sIndent + "-> e3_has_uid: " + m_e3_has_uid.getValue()
                    + "\n");
        }
        if (m_e3_has_name.getValue() != null) {
            sb.append(sIndent + "-> e3_has_name: " + m_e3_has_name.getValue()
                    + "\n");
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = { model_concept.class,
            diagram.class, business_case.class, model.class };

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public e3value_object() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_e3_has_formula);
        ps.addProperty(m_e3_has_uid);
        ps.addProperty(m_e3_has_name);
    }
    // RDFS2Class: end of PropertyStore-stuff

    public String fetchFormula(String a) throws E3ParseException {
        String return_value = null;
        Collection c = getE3_has_formula();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            String f = (String) i.next();
            f = f.replaceAll("\\s", "");
            f = f.replaceAll("\t", "");
            f = f.replaceAll("\n", "");
            if (f.startsWith(a)) {
                return Globals.trimFormula(f, Globals.FORMULA_BODY);
            }
        }
        return null;
    }

    public Map fetchCellTrackerMap() {
        return trackXLSPosition;
    }

    public CellTracker fetchCellTracker(String attributeName) {
        // attributeName = attributeName.toUpperCase();
        return (CellTracker) trackXLSPosition.get(attributeName);
    }

    public String CellTrackerInventory() {
        String s = "";
        Collection c = trackXLSPosition.keySet();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            CellTracker ct = ((CellTracker) trackXLSPosition.get(o));
            s = s + o + "-->" + ct.getSheetName() + "!" + ct.getXLSRow()
                    + ct.getXLSCol() + "\n";
        }
        return s;
    }

    public void appendCellTracker(String attributeName, CellTracker c) {
        trackXLSPosition.put(attributeName, c);
    }

    public void clearCellTrackers() {
        trackXLSPosition.clear();
    }

    private Map e3Expression = new HashMap();

    public void removeExpression(String leftHand) {
        e3Expression.remove(leftHand);

    }

    public void addExpression(String leftHand, String rightHand) {

        rightHand = ProfGenerator.Numberstring2Doublestring(rightHand);

        if (e3Expression.get(leftHand) == null) {
            if ("Name".equals(leftHand)) {
                e3Expression.put(leftHand, rightHand = getE3_has_name());
                return;
            } else if ("UID".equals(leftHand)) {
                e3Expression.put(leftHand, rightHand = getE3_has_uid());
                return;
            } else if (this instanceof value_transaction
                    && "FRACTION".equalsIgnoreCase(leftHand)) {
                e3Expression.put(leftHand,
                        rightHand = ((value_transaction) this)
                                .getVt_has_fraction());
                return;
            } else if (this instanceof connection_element) {
                if ("DOWN_FRACTION".equalsIgnoreCase(leftHand)) {
                    e3Expression.put(leftHand,
                            rightHand = ((connection_element) this)
                                    .getDown_fraction());
                    return;
                } else if ("UP_FRACTION".equalsIgnoreCase(leftHand)) {
                    e3Expression.put(leftHand,
                            rightHand = ((connection_element) this)
                                    .getUp_fraction());
                    return;
                }
            }
            e3Expression.put(leftHand, rightHand);
        } else if (Globals.DEBUG && rightHand != null) {
            log.debug(
                    "e3value_object.addExpression: trying to add second expression for "
                            + leftHand + " of the" + getClassNameShort()
                            + " named " + getE3_has_name());
        }
    }

    public String fetchExpression(String left) {
        return (String) e3Expression.get(left);
    }

    public boolean complete() throws E3ParseException {
        for (Iterator it = e3Expression.keySet().iterator(); it.hasNext();) {
            String current = (String) it.next();
            if (e3Expression.get(current) == null
                    && !FormulaConstants.isSystemFormula(current)) {
                String message = "A valid formula for '" + current
                        + "' is found missing in the\n" + getClass().getName()
                        + " named " + getE3_has_name();
                log.error(message);
                throw (new E3ParseException(message));
            }
        }
        return true;
    }

}

// RDFS2Class: end of class e3value_object
// EOF
