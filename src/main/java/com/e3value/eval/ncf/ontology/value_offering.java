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
 * RDFS2Class: class value_offering
 * <p>
 */
public class value_offering extends model_concept {

    static Logger log = Logger.getLogger(value_offering.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vo_consists_of_vp **/
    protected de.dfki.rdf.util.PropertyInfo m_vo_consists_of_vp = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vo_consists_of_vp",
                    new Class[] { value_port.class }, true);

    /** RDFS2Class: putter for slot vo_consists_of_vp **/
    public void putVo_consists_of_vp(value_port p_vo_consists_of_vp) {
        m_vo_consists_of_vp.putValue(p_vo_consists_of_vp);
    }

    public void putVo_consists_of_vp(
            de.dfki.rdf.util.RDFResource p_vo_consists_of_vp) {
        m_vo_consists_of_vp.putValue(p_vo_consists_of_vp);
    }

    public void putVo_consists_of_vp(java.util.Collection p_vo_consists_of_vp) {
        m_vo_consists_of_vp.setValues(p_vo_consists_of_vp);
    }

    public void clearVo_consists_of_vp() {
        m_vo_consists_of_vp.clearValue();
    }
    // RDFS2Class: end of putter for slot vo_consists_of_vp

    /** RDFS2Class: getter for slot vo_consists_of_vp **/
    public java.util.Collection getVo_consists_of_vp() {
        return (java.util.Collection) m_vo_consists_of_vp.getValue();
    }
    // RDFS2Class: end of getter for slot vo_consists_of_vp

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vo_in_vi **/
    protected de.dfki.rdf.util.PropertyInfo m_vo_in_vi = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vo_in_vi",
                    new Class[] { value_interface.class }, false);

    /** RDFS2Class: putter for slot vo_in_vi **/
    public void putVo_in_vi(value_interface p_vo_in_vi) {
        m_vo_in_vi.putValue(p_vo_in_vi);
    }

    public void putVo_in_vi(de.dfki.rdf.util.RDFResource p_vo_in_vi) {
        m_vo_in_vi.putValue(p_vo_in_vi);
    }
    // RDFS2Class: end of putter for slot vo_in_vi

    /** RDFS2Class: getter for slot vo_in_vi **/
    public value_interface GetVo_in_vi() {
        return (value_interface) m_vo_in_vi.getValue();
    }

    public de.dfki.rdf.util.RDFResource getVo_in_vi() {
        return (de.dfki.rdf.util.RDFResource) m_vo_in_vi.getValue();
    }
    // RDFS2Class: end of getter for slot vo_in_vi

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (!m_vo_consists_of_vp.isEmpty()) {
            sb.append(sIndent + "-> vo_consists_of_vp:\n");
            for (Iterator it_vo_consists_of_vp = ((java.util.Collection) m_vo_consists_of_vp
                    .getValue()).iterator(); it_vo_consists_of_vp.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_vo_consists_of_vp
                                .next()).toStringShort()
                        + "\n");
            }
        }
        if (m_vo_in_vi.getValue() != null) {
            sb.append(sIndent + "-> vo_in_vi:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_vo_in_vi.getValue())
                            .toStringShort()
                    + "\n");
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = {};

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public value_offering() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_vo_consists_of_vp);
        ps.addProperty(m_vo_in_vi);
    }

    // RDFS2Class: end of PropertyStore-stuff
    public void appendValuePort(value_port p) {
        getVo_consists_of_vp().add(p);
    }
}

// RDFS2Class: end of class value_offering
// EOF
