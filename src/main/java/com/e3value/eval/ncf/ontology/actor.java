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
 * RDFS2Class: class actor
 * <p>
 */
public class actor extends model_concept {

    static Logger log = Logger.getLogger(actor.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ac_in_ms **/
    protected de.dfki.rdf.util.PropertyInfo m_ac_in_ms = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ac_in_ms",
                    new Class[] { market_segment.class }, true);

    /** RDFS2Class: putter for slot ac_in_ms **/
    public void putAc_in_ms(market_segment p_ac_in_ms) {
        m_ac_in_ms.putValue(p_ac_in_ms);
    }

    public void putAc_in_ms(de.dfki.rdf.util.RDFResource p_ac_in_ms) {
        m_ac_in_ms.putValue(p_ac_in_ms);
    }

    public void putAc_in_ms(java.util.Collection p_ac_in_ms) {
        m_ac_in_ms.setValues(p_ac_in_ms);
    }

    public void clearAc_in_ms() {
        m_ac_in_ms.clearValue();
    }
    // RDFS2Class: end of putter for slot ac_in_ms

    /** RDFS2Class: getter for slot ac_in_ms **/
    public java.util.Collection getAc_in_ms() {
        return (java.util.Collection) m_ac_in_ms.getValue();
    }
    // RDFS2Class: end of getter for slot ac_in_ms

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ac_has_vi **/
    protected de.dfki.rdf.util.PropertyInfo m_ac_has_vi = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ac_has_vi",
                    new Class[] { value_interface.class }, true);

    /** RDFS2Class: putter for slot ac_has_vi **/
    public void putAc_has_vi(value_interface p_ac_has_vi) {
        m_ac_has_vi.putValue(p_ac_has_vi);
    }

    public void putAc_has_vi(de.dfki.rdf.util.RDFResource p_ac_has_vi) {
        m_ac_has_vi.putValue(p_ac_has_vi);
    }

    public void putAc_has_vi(java.util.Collection p_ac_has_vi) {
        m_ac_has_vi.setValues(p_ac_has_vi);
    }

    public void clearAc_has_vi() {
        m_ac_has_vi.clearValue();
    }
    // RDFS2Class: end of putter for slot ac_has_vi

    /** RDFS2Class: getter for slot ac_has_vi **/
    public java.util.Collection getAc_has_vi() {
        return (java.util.Collection) m_ac_has_vi.getValue();
    }
    // RDFS2Class: end of getter for slot ac_has_vi

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (!m_ac_in_ms.isEmpty()) {
            sb.append(sIndent + "-> ac_in_ms:\n");
            for (Iterator it_ac_in_ms = ((java.util.Collection) m_ac_in_ms
                    .getValue()).iterator(); it_ac_in_ms.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_ac_in_ms.next())
                                .toStringShort()
                        + "\n");
            }
        }
        if (!m_ac_has_vi.isEmpty()) {
            sb.append(sIndent + "-> ac_has_vi:\n");
            for (Iterator it_ac_has_vi = ((java.util.Collection) m_ac_has_vi
                    .getValue()).iterator(); it_ac_has_vi.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_ac_has_vi.next())
                                .toStringShort()
                        + "\n");
            }
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = { composite_actor.class,
            elementary_actor.class };

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public actor() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_ac_in_ms);
        ps.addProperty(m_ac_has_vi);
    }
    // RDFS2Class: end of PropertyStore-stuff
}

// RDFS2Class: end of class actor
// EOF
