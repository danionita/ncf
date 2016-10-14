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
// RDFS2Class: end of imports
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.e3value.eval.ncf.E3ParseException;

/**
 * RDFS2Class: class value_interface
 * <p>
 */
public class value_interface extends dependency_element
        implements Serializable {

    static Logger log = Logger.getLogger(value_interface.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vi_assigned_to_ac **/
    protected de.dfki.rdf.util.PropertyInfo m_vi_assigned_to_ac = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vi_assigned_to_ac",
                    new Class[] { actor.class }, false);

    /** RDFS2Class: putter for slot vi_assigned_to_ac **/
    public void putVi_assigned_to_ac(actor p_vi_assigned_to_ac) {
        m_vi_assigned_to_ac.putValue(p_vi_assigned_to_ac);
    }

    public void putVi_assigned_to_ac(
            de.dfki.rdf.util.RDFResource p_vi_assigned_to_ac) {
        m_vi_assigned_to_ac.putValue(p_vi_assigned_to_ac);
    }
    // RDFS2Class: end of putter for slot vi_assigned_to_ac

    /** RDFS2Class: getter for slot vi_assigned_to_ac **/
    public actor GetVi_assigned_to_ac() {
        return (actor) m_vi_assigned_to_ac.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVi_assigned_to_ac() {
        return (de.dfki.rdf.util.RDFResource) m_vi_assigned_to_ac.getValue();
    }
    // RDFS2Class: end of getter for slot vi_assigned_to_ac

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vi_consists_of_of **/
    protected de.dfki.rdf.util.PropertyInfo m_vi_consists_of_of = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vi_consists_of_of",
                    new Class[] { value_offering.class }, true);

    /** RDFS2Class: putter for slot vi_consists_of_of **/
    public void putVi_consists_of_of(value_offering p_vi_consists_of_of) {
        m_vi_consists_of_of.putValue(p_vi_consists_of_of);
    }

    public void putVi_consists_of_of(
            de.dfki.rdf.util.RDFResource p_vi_consists_of_of) {
        m_vi_consists_of_of.putValue(p_vi_consists_of_of);
    }

    public void putVi_consists_of_of(java.util.Collection p_vi_consists_of_of) {
        m_vi_consists_of_of.setValues(p_vi_consists_of_of);
    }

    public void clearVi_consists_of_of() {
        m_vi_consists_of_of.clearValue();
    }
    // RDFS2Class: end of putter for slot vi_consists_of_of

    /** RDFS2Class: getter for slot vi_consists_of_of **/
    public java.util.Collection getVi_consists_of_of() {
        return (java.util.Collection) m_vi_consists_of_of.getValue();
    }
    // RDFS2Class: end of getter for slot vi_consists_of_of

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vi_in_ca **/
    protected de.dfki.rdf.util.PropertyInfo m_vi_in_ca = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vi_in_ca",
                    new Class[] { composite_actor.class }, true);

    /** RDFS2Class: putter for slot vi_in_ca **/
    public void putVi_in_ca(composite_actor p_vi_in_ca) {
        m_vi_in_ca.putValue(p_vi_in_ca);
    }

    public void putVi_in_ca(de.dfki.rdf.util.RDFResource p_vi_in_ca) {
        m_vi_in_ca.putValue(p_vi_in_ca);
    }

    public void putVi_in_ca(java.util.Collection p_vi_in_ca) {
        m_vi_in_ca.setValues(p_vi_in_ca);
    }

    public void clearVi_in_ca() {
        m_vi_in_ca.clearValue();
    }
    // RDFS2Class: end of putter for slot vi_in_ca

    /** RDFS2Class: getter for slot vi_in_ca **/
    public java.util.Collection getVi_in_ca() {
        return (java.util.Collection) m_vi_in_ca.getValue();
    }
    // RDFS2Class: end of getter for slot vi_in_ca

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vi_assigned_to_ms **/
    protected de.dfki.rdf.util.PropertyInfo m_vi_assigned_to_ms = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vi_assigned_to_ms",
                    new Class[] { market_segment.class }, false);

    /** RDFS2Class: putter for slot vi_assigned_to_ms **/
    public void putVi_assigned_to_ms(market_segment p_vi_assigned_to_ms) {
        m_vi_assigned_to_ms.putValue(p_vi_assigned_to_ms);
    }

    public void putVi_assigned_to_ms(
            de.dfki.rdf.util.RDFResource p_vi_assigned_to_ms) {
        m_vi_assigned_to_ms.putValue(p_vi_assigned_to_ms);
    }
    // RDFS2Class: end of putter for slot vi_assigned_to_ms

    /** RDFS2Class: getter for slot vi_assigned_to_ms **/
    public market_segment GetVi_assigned_to_ms() {
        return (market_segment) m_vi_assigned_to_ms.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVi_assigned_to_ms() {
        return (de.dfki.rdf.util.RDFResource) m_vi_assigned_to_ms.getValue();
    }
    // RDFS2Class: end of getter for slot vi_assigned_to_ms

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vi_assigned_to_va **/
    protected de.dfki.rdf.util.PropertyInfo m_vi_assigned_to_va = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vi_assigned_to_va",
                    new Class[] { value_activity.class }, false);

    /** RDFS2Class: putter for slot vi_assigned_to_va **/
    public void putVi_assigned_to_va(value_activity p_vi_assigned_to_va) {
        m_vi_assigned_to_va.putValue(p_vi_assigned_to_va);
    }

    public void putVi_assigned_to_va(
            de.dfki.rdf.util.RDFResource p_vi_assigned_to_va) {
        m_vi_assigned_to_va.putValue(p_vi_assigned_to_va);
    }
    // RDFS2Class: end of putter for slot vi_assigned_to_va

    /** RDFS2Class: getter for slot vi_assigned_to_va **/
    public value_activity GetVi_assigned_to_va() {
        return (value_activity) m_vi_assigned_to_va.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVi_assigned_to_va() {
        return (de.dfki.rdf.util.RDFResource) m_vi_assigned_to_va.getValue();
    }
    // RDFS2Class: end of getter for slot vi_assigned_to_va

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (m_vi_assigned_to_ac.getValue() != null) {
            sb.append(sIndent + "-> vi_assigned_to_ac:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_vi_assigned_to_ac
                            .getValue()).toStringShort()
                    + "\n");
        }
        if (!m_vi_consists_of_of.isEmpty()) {
            sb.append(sIndent + "-> vi_consists_of_of:\n");
            for (Iterator it_vi_consists_of_of = ((java.util.Collection) m_vi_consists_of_of
                    .getValue()).iterator(); it_vi_consists_of_of.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_vi_consists_of_of
                                .next()).toStringShort()
                        + "\n");
            }
        }
        if (!m_vi_in_ca.isEmpty()) {
            sb.append(sIndent + "-> vi_in_ca:\n");
            for (Iterator it_vi_in_ca = ((java.util.Collection) m_vi_in_ca
                    .getValue()).iterator(); it_vi_in_ca.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_vi_in_ca.next())
                                .toStringShort()
                        + "\n");
            }
        }
        if (m_vi_assigned_to_ms.getValue() != null) {
            sb.append(sIndent + "-> vi_assigned_to_ms:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_vi_assigned_to_ms
                            .getValue()).toStringShort()
                    + "\n");
        }
        if (m_vi_assigned_to_va.getValue() != null) {
            sb.append(sIndent + "-> vi_assigned_to_va:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_vi_assigned_to_va
                            .getValue()).toStringShort()
                    + "\n");
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = {};

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public value_interface() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_vi_assigned_to_ac);
        ps.addProperty(m_vi_consists_of_of);
        ps.addProperty(m_vi_in_ca);
        ps.addProperty(m_vi_assigned_to_ms);
        ps.addProperty(m_vi_assigned_to_va);
    }
    // RDFS2Class: end of PropertyStore-stuff

    HashMap TRANSACTIONSFIRST = new HashMap();
    HashMap VISIT_ADMINISTRATION = new HashMap();

    public boolean verifyAdministration(Map mapObjects)
            throws E3ParseException {
        final double allowed_deviation = 0.01;
        Collection values = VISIT_ADMINISTRATION.values();
        Iterator i = values.iterator();
        Vector visitedtransactions = new Vector();

        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            Iterator v_i = v.iterator();
            while (v_i.hasNext()) {
                Vector v2 = (Vector) v_i.next();
                value_transaction vt = (value_transaction) v2.get(2);
                if (!visitedtransactions.contains(vt) && vt != null) {
                    visitedtransactions.add(vt);
                }
            }
        }
        Map has_unique_subtransactions = new HashMap();
        Iterator trans_i = visitedtransactions.iterator();
        while (trans_i.hasNext()) {
            has_unique_subtransactions.clear();
            value_transaction vt = (value_transaction) trans_i.next();
            i = values.iterator();
            while (i.hasNext()) {
                Vector v = (Vector) i.next();
                Iterator v_i = v.iterator();
                while (v_i.hasNext()) {
                    Vector v2 = (Vector) v_i.next();
                    value_transaction vtkey = (value_transaction) v2.get(2);
                    if (vt.equals(vtkey)) {
                        // sub transaction
                        value_interface vi = (value_interface) v2.get(0);
                        Double d = (Double) v2.get(1);

                        if (!has_unique_subtransactions.keySet().contains(vi)) {
                            has_unique_subtransactions.put(vi, d);
                        } else {
                            Double existing_d = (Double) has_unique_subtransactions
                                    .get(vi);
                            has_unique_subtransactions.remove(vi);
                            has_unique_subtransactions.put(vi,
                                    new Double(d.doubleValue()
                                            + existing_d.doubleValue()));
                        }
                    }
                }
            }
            // all information gathered for this individual value transactions.
            // begin checking sub transactions
            Iterator subtransacations_i = has_unique_subtransactions.keySet()
                    .iterator();
            double hits = 0.0;
            double previous = 0.0;
            boolean firsttime = true;
            while (subtransacations_i.hasNext()) {
                value_interface key = (value_interface) subtransacations_i
                        .next();
                hits = ((Double) has_unique_subtransactions.get(key))
                        .doubleValue();
                if (!firsttime) {
                    if (!((hits <= previous * (allowed_deviation + 1))
                            && (hits >= previous * (1 - allowed_deviation)))) {
                        return false;
                    }
                }
                previous = hits;
                firsttime = false;
            }
            // end of this transaction, check next transaction. //
        }
        return true;
    }

    public String fetchAdministrationString() {
        StringBuffer b = new StringBuffer();
        b.append("(");
        Collection values = VISIT_ADMINISTRATION.values();
        Iterator i = values.iterator();
        while (i.hasNext()) {
            Vector v = (Vector) i.next();
            if (v.get(0) != null) {
                Iterator i2 = v.iterator();
                while (i2.hasNext()) {
                    Vector v2 = (Vector) i2.next();
                    if (v2.get(0) != null) {
                        b.append("" + ((value_interface) v2.get(0))
                                .getE3_has_name());
                    } else {
                        b.append("via CE ");
                    }

                    b.append(":" + v2.get(1) + ",");
                }

            }
        }
        b.replace(0, b.length(), b.substring(0, b.length() - 1));
        b.append(")");
        return b.toString();
    }

    public void printAdministration() {
        log.debug("\t value interface" + fetchAdministrationString());
    }

    public model_concept fetchContainer() {

        model_concept aContainer = null;

        aContainer = GetVi_assigned_to_ac();
        if (aContainer != null) {
            return aContainer;
        }

        aContainer = GetVi_assigned_to_ms();
        if (aContainer != null) {
            return aContainer;
        }

        aContainer = GetVi_assigned_to_va();
        if (aContainer != null) {
            return aContainer;
        }

        return null;
    }

    public void appendAdministration(value_interface value_interface,
            value_transaction value_transaction, double f) {
        Vector v = (Vector) VISIT_ADMINISTRATION.get(value_interface);
        if (v == null) {
            v = new Vector();
        }
        Vector v2 = new Vector();
        v2.add(value_interface);
        v2.add(new Double(f));
        v2.add(value_transaction);
        v.add(v2);
        VISIT_ADMINISTRATION.put(value_interface, v);
    }

    public int fetchTransactionVisitCount() {
        return VISIT_ADMINISTRATION.size();
    }

    public Vector fetchAdministration(value_transaction value_transaction) {
        Vector administration = (Vector) VISIT_ADMINISTRATION
                .get(value_transaction);
        Iterator i = administration.iterator();
        return administration;
    }

    public void placeFirst_source(value_interface source,
            value_transaction value_transaction) {
        TRANSACTIONSFIRST.put(value_transaction, source);
    }

    public value_interface fetchFirst_source(
            value_transaction value_transaction) {
        return (value_interface) TRANSACTIONSFIRST.get(value_transaction);
    }

    public int countPorts() {
        int ports = 0;
        Collection MyOfferings = getVi_consists_of_of();
        Iterator i = MyOfferings.iterator();
        while (i.hasNext()) {
            value_offering offering = (value_offering) i.next();
            Collection offeringHasPorts = offering.getVo_consists_of_vp();
            ports = ports + offeringHasPorts.size();
        }
        return ports;
    }

}

// RDFS2Class: end of class value_interface
// EOF
