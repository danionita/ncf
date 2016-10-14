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
// RDFS2Class: imports
import java.util.Iterator;

import org.apache.log4j.Logger;

/**
 * RDFS2Class: class market_segment
 * <p>
 */
public class market_segment extends model_concept implements Serializable {

    static Logger log = Logger.getLogger(market_segment.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ms_consists_of_ac **/
    protected de.dfki.rdf.util.PropertyInfo m_ms_consists_of_ac = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ms_consists_of_ac",
                    new Class[] { actor.class }, true);

    /** RDFS2Class: putter for slot ms_consists_of_ac **/
    public void putMs_consists_of_ac(actor p_ms_consists_of_ac) {
        m_ms_consists_of_ac.putValue(p_ms_consists_of_ac);
    }

    public void putMs_consists_of_ac(
            de.dfki.rdf.util.RDFResource p_ms_consists_of_ac) {
        m_ms_consists_of_ac.putValue(p_ms_consists_of_ac);
    }

    public void putMs_consists_of_ac(java.util.Collection p_ms_consists_of_ac) {
        m_ms_consists_of_ac.setValues(p_ms_consists_of_ac);
    }

    public void clearMs_consists_of_ac() {
        m_ms_consists_of_ac.clearValue();
    }
    // RDFS2Class: end of putter for slot ms_consists_of_ac

    /** RDFS2Class: getter for slot ms_consists_of_ac **/
    public java.util.Collection getMs_consists_of_ac() {
        return (java.util.Collection) m_ms_consists_of_ac.getValue();
    }
    // RDFS2Class: end of getter for slot ms_consists_of_ac

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ms_performs_va **/
    protected de.dfki.rdf.util.PropertyInfo m_ms_performs_va = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ms_performs_va",
                    new Class[] { value_activity.class }, true);

    /** RDFS2Class: putter for slot ms_performs_va **/
    public void putMs_performs_va(value_activity p_ms_performs_va) {
        m_ms_performs_va.putValue(p_ms_performs_va);
    }

    public void putMs_performs_va(
            de.dfki.rdf.util.RDFResource p_ms_performs_va) {
        m_ms_performs_va.putValue(p_ms_performs_va);
    }

    public void putMs_performs_va(java.util.Collection p_ms_performs_va) {
        m_ms_performs_va.setValues(p_ms_performs_va);
    }

    public void clearMs_performs_va() {
        m_ms_performs_va.clearValue();
    }
    // RDFS2Class: end of putter for slot ms_performs_va

    /** RDFS2Class: getter for slot ms_performs_va **/
    public java.util.Collection getMs_performs_va() {
        return (java.util.Collection) m_ms_performs_va.getValue();
    }
    // RDFS2Class: end of getter for slot ms_performs_va

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ms_has_vi **/
    protected de.dfki.rdf.util.PropertyInfo m_ms_has_vi = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ms_has_vi",
                    new Class[] { value_interface.class }, true);

    /** RDFS2Class: putter for slot ms_has_vi **/
    public void putMs_has_vi(value_interface p_ms_has_vi) {
        m_ms_has_vi.putValue(p_ms_has_vi);
    }

    public void putMs_has_vi(de.dfki.rdf.util.RDFResource p_ms_has_vi) {
        m_ms_has_vi.putValue(p_ms_has_vi);
    }

    public void putMs_has_vi(java.util.Collection p_ms_has_vi) {
        m_ms_has_vi.setValues(p_ms_has_vi);
    }

    public void clearMs_has_vi() {
        m_ms_has_vi.clearValue();
    }
    // RDFS2Class: end of putter for slot ms_has_vi

    /** RDFS2Class: getter for slot ms_has_vi **/
    public java.util.Collection getMs_has_vi() {
        return (java.util.Collection) m_ms_has_vi.getValue();
    }
    // RDFS2Class: end of getter for slot ms_has_vi

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (!m_ms_consists_of_ac.isEmpty()) {
            sb.append(sIndent + "-> ms_consists_of_ac:\n");
            for (Iterator it_ms_consists_of_ac = ((java.util.Collection) m_ms_consists_of_ac
                    .getValue()).iterator(); it_ms_consists_of_ac.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_ms_consists_of_ac
                                .next()).toStringShort()
                        + "\n");
                // sb.append(
                // ((de.dfki.rdf.util.RDFResource)it_ms_consists_of_ac.next()).toString(sIndent+"
                // ") );
            }
        }
        if (!m_ms_performs_va.isEmpty()) {
            sb.append(sIndent + "-> ms_performs_va:\n");
            for (Iterator it_ms_performs_va = ((java.util.Collection) m_ms_performs_va
                    .getValue()).iterator(); it_ms_performs_va.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_ms_performs_va
                                .next()).toStringShort()
                        + "\n");
                // sb.append(
                // ((de.dfki.rdf.util.RDFResource)it_ms_performs_va.next()).toString(sIndent+"
                // ") );
            }
        }
        if (!m_ms_has_vi.isEmpty()) {
            sb.append(sIndent + "-> ms_has_vi:\n");
            for (Iterator it_ms_has_vi = ((java.util.Collection) m_ms_has_vi
                    .getValue()).iterator(); it_ms_has_vi.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_ms_has_vi.next())
                                .toStringShort()
                        + "\n");
                // sb.append(
                // ((de.dfki.rdf.util.RDFResource)it_ms_has_vi.next()).toString(sIndent+"
                // ") );
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
    public market_segment() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_ms_consists_of_ac);
        ps.addProperty(m_ms_performs_va);
        ps.addProperty(m_ms_has_vi);
    }
    // RDFS2Class: end of PropertyStore-stuff

}

// RDFS2Class: end of class market_segment
// EOF
