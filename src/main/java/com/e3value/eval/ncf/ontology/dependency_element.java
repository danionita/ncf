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
 * RDFS2Class: class dependency_element
 * <p>
 */
public class dependency_element extends model_concept {

    static Logger log = Logger.getLogger(dependency_element.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot de_down_ce **/
    protected de.dfki.rdf.util.PropertyInfo m_de_down_ce = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("de_down_ce",
                    new Class[] { connection_element.class }, true);

    /** RDFS2Class: putter for slot de_down_ce **/
    public void putDe_down_ce(connection_element p_de_down_ce) {
        m_de_down_ce.putValue(p_de_down_ce);
    }

    public void putDe_down_ce(de.dfki.rdf.util.RDFResource p_de_down_ce) {
        m_de_down_ce.putValue(p_de_down_ce);
    }

    public void putDe_down_ce(java.util.Collection p_de_down_ce) {
        m_de_down_ce.setValues(p_de_down_ce);
    }

    public void clearDe_down_ce() {
        m_de_down_ce.clearValue();
    }
    // RDFS2Class: end of putter for slot de_down_ce

    /** RDFS2Class: getter for slot de_down_ce **/
    public java.util.Collection getDe_down_ce() {
        return (java.util.Collection) m_de_down_ce.getValue();
    }
    // RDFS2Class: end of getter for slot de_down_ce

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot de_up_ce **/
    protected de.dfki.rdf.util.PropertyInfo m_de_up_ce = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("de_up_ce",
                    new Class[] { connection_element.class }, true);

    /** RDFS2Class: putter for slot de_up_ce **/
    public void putDe_up_ce(connection_element p_de_up_ce) {
        m_de_up_ce.putValue(p_de_up_ce);
    }

    public void putDe_up_ce(de.dfki.rdf.util.RDFResource p_de_up_ce) {
        m_de_up_ce.putValue(p_de_up_ce);
    }

    public void putDe_up_ce(java.util.Collection p_de_up_ce) {
        m_de_up_ce.setValues(p_de_up_ce);
    }

    public void clearDe_up_ce() {
        m_de_up_ce.clearValue();
    }
    // RDFS2Class: end of putter for slot de_up_ce

    /** RDFS2Class: getter for slot de_up_ce **/
    public java.util.Collection getDe_up_ce() {
        return (java.util.Collection) m_de_up_ce.getValue();
    }
    // RDFS2Class: end of getter for slot de_up_ce

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (!m_de_down_ce.isEmpty()) {
            sb.append(sIndent + "-> de_down_ce:\n");
            for (Iterator it_de_down_ce = ((java.util.Collection) m_de_down_ce
                    .getValue()).iterator(); it_de_down_ce.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_de_down_ce.next())
                                .toStringShort()
                        + "\n");
            }
        }
        if (!m_de_up_ce.isEmpty()) {
            sb.append(sIndent + "-> de_up_ce:\n");
            for (Iterator it_de_up_ce = ((java.util.Collection) m_de_up_ce
                    .getValue()).iterator(); it_de_up_ce.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_de_up_ce.next())
                                .toStringShort()
                        + "\n");
            }
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = { value_interface.class,
            end_stimulus.class, e3value_AND.class, start_stimulus.class,
            e3value_OR.class };

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public dependency_element() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_de_down_ce);
        ps.addProperty(m_de_up_ce);
    }

}

// RDFS2Class: end of class dependency_element
// EOF
