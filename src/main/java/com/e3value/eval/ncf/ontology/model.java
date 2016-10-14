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

// RDFS2Class: imports

import java.util.Iterator;

import org.apache.log4j.Logger;

// RDFS2Class: end of imports

/**
 * RDFS2Class: class model
 * <p>
 */
public class model extends e3value_object {

    static Logger log = Logger.getLogger(model.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot mo_has_mc **/
    protected de.dfki.rdf.util.PropertyInfo m_mo_has_mc = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("mo_has_mc",
                    new Class[] { model_concept.class }, true);

    /** RDFS2Class: putter for slot mo_has_mc **/
    public void putMo_has_mc(model_concept p_mo_has_mc) {
        m_mo_has_mc.putValue(p_mo_has_mc);
    }

    public void putMo_has_mc(de.dfki.rdf.util.RDFResource p_mo_has_mc) {
        m_mo_has_mc.putValue(p_mo_has_mc);
    }

    public void putMo_has_mc(java.util.Collection p_mo_has_mc) {
        m_mo_has_mc.setValues(p_mo_has_mc);
    }

    public void clearMo_has_mc() {
        m_mo_has_mc.clearValue();
    }
    // RDFS2Class: end of putter for slot mo_has_mc

    /** RDFS2Class: getter for slot mo_has_mc **/
    public java.util.Collection getMo_has_mc() {
        return (java.util.Collection) m_mo_has_mc.getValue();
    }
    // RDFS2Class: end of getter for slot mo_has_mc

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot mo_has_end_period **/
    protected de.dfki.rdf.util.PropertyInfo m_mo_has_end_period = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("mo_has_end_period", false);

    /** RDFS2Class: putter for slot mo_has_end_period **/
    public void putMo_has_end_period(String p_mo_has_end_period) {
        m_mo_has_end_period.putValue(p_mo_has_end_period);
    }
    // RDFS2Class: end of putter for slot mo_has_end_period

    /** RDFS2Class: getter for slot mo_has_end_period **/
    public String getMo_has_end_period() {
        return (String) m_mo_has_end_period.getValue();
    }
    // RDFS2Class: end of getter for slot mo_has_end_period

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot mo_has_start_period **/
    protected de.dfki.rdf.util.PropertyInfo m_mo_has_start_period = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("mo_has_start_period", false);

    /** RDFS2Class: putter for slot mo_has_start_period **/
    public void putMo_has_start_period(String p_mo_has_start_period) {
        m_mo_has_start_period.putValue(p_mo_has_start_period);
    }
    // RDFS2Class: end of putter for slot mo_has_start_period

    /** RDFS2Class: getter for slot mo_has_start_period **/
    public String getMo_has_start_period() {
        return (String) m_mo_has_start_period.getValue();
    }
    // RDFS2Class: end of getter for slot mo_has_start_period

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot mo_in_bc **/
    protected de.dfki.rdf.util.PropertyInfo m_mo_in_bc = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("mo_in_bc",
                    new Class[] { business_case.class }, true);

    /** RDFS2Class: putter for slot mo_in_bc **/
    public void putMo_in_bc(business_case p_mo_in_bc) {
        m_mo_in_bc.putValue(p_mo_in_bc);
    }

    public void putMo_in_bc(de.dfki.rdf.util.RDFResource p_mo_in_bc) {
        m_mo_in_bc.putValue(p_mo_in_bc);
    }

    public void putMo_in_bc(java.util.Collection p_mo_in_bc) {
        m_mo_in_bc.setValues(p_mo_in_bc);
    }

    public void clearMo_in_bc() {
        m_mo_in_bc.clearValue();
    }
    // RDFS2Class: end of putter for slot mo_in_bc

    /** RDFS2Class: getter for slot mo_in_bc **/
    public java.util.Collection getMo_in_bc() {
        return (java.util.Collection) m_mo_in_bc.getValue();
    }
    // RDFS2Class: end of getter for slot mo_in_bc

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (!m_mo_has_mc.isEmpty()) {
            sb.append(sIndent + "-> mo_has_mc:\n");
            for (Iterator it_mo_has_mc = ((java.util.Collection) m_mo_has_mc
                    .getValue()).iterator(); it_mo_has_mc.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_mo_has_mc.next())
                                .toStringShort()
                        + "\n");
                // sb.append(
                // ((de.dfki.rdf.util.RDFResource)it_mo_has_mc.next()).toString(sIndent+"
                // ") );
            }
        }
        if (m_mo_has_end_period.getValue() != null) {
            sb.append(sIndent + "-> mo_has_end_period: "
                    + m_mo_has_end_period.getValue() + "\n");
        }
        if (m_mo_has_start_period.getValue() != null) {
            sb.append(sIndent + "-> mo_has_start_period: "
                    + m_mo_has_start_period.getValue() + "\n");
        }
        if (!m_mo_in_bc.isEmpty()) {
            sb.append(sIndent + "-> mo_in_bc:\n");
            for (Iterator it_mo_in_bc = ((java.util.Collection) m_mo_in_bc
                    .getValue()).iterator(); it_mo_in_bc.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_mo_in_bc.next())
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
    public model() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_mo_has_mc);
        ps.addProperty(m_mo_has_end_period);
        ps.addProperty(m_mo_has_start_period);
        ps.addProperty(m_mo_in_bc);
    }
    // RDFS2Class: end of PropertyStore-stuff

}

// RDFS2Class: end of class model
// EOF
