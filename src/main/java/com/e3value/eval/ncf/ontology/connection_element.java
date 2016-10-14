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
import java.util.Vector;

import org.apache.log4j.Logger;

// RDFS2Class: end of imports

/**
 * RDFS2Class: class connection_element
 * <p>
 */
public class connection_element extends model_concept {

    static Logger log = Logger.getLogger(connection_element.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ce_with_up_de **/
    protected de.dfki.rdf.util.PropertyInfo m_ce_with_up_de = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ce_with_up_de",
                    new Class[] { dependency_element.class }, false);

    /** RDFS2Class: putter for slot ce_with_up_de **/
    public void putCe_with_up_de(dependency_element p_ce_with_up_de) {
        m_ce_with_up_de.putValue(p_ce_with_up_de);
    }

    public void putCe_with_up_de(de.dfki.rdf.util.RDFResource p_ce_with_up_de) {
        m_ce_with_up_de.putValue(p_ce_with_up_de);
    }
    // RDFS2Class: end of putter for slot ce_with_up_de

    /** RDFS2Class: getter for slot ce_with_up_de **/
    public dependency_element GetCe_with_up_de() {
        return (dependency_element) m_ce_with_up_de.getValue();
    }

    public de.dfki.rdf.util.RDFResource getCe_with_up_de() {
        return (de.dfki.rdf.util.RDFResource) m_ce_with_up_de.getValue();
    }
    // RDFS2Class: end of getter for slot ce_with_up_de

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot ce_with_down_de **/
    protected de.dfki.rdf.util.PropertyInfo m_ce_with_down_de = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("ce_with_down_de",
                    new Class[] { dependency_element.class }, false);

    /** RDFS2Class: putter for slot ce_with_down_de **/
    public void putCe_with_down_de(dependency_element p_ce_with_down_de) {
        m_ce_with_down_de.putValue(p_ce_with_down_de);
    }

    public void putCe_with_down_de(
            de.dfki.rdf.util.RDFResource p_ce_with_down_de) {
        m_ce_with_down_de.putValue(p_ce_with_down_de);
    }
    // RDFS2Class: end of putter for slot ce_with_down_de

    /** RDFS2Class: getter for slot ce_with_down_de **/
    public dependency_element GetCe_with_down_de() {
        return (dependency_element) m_ce_with_down_de.getValue();
    }

    public de.dfki.rdf.util.RDFResource getCe_with_down_de() {
        return (de.dfki.rdf.util.RDFResource) m_ce_with_down_de.getValue();
    }
    // RDFS2Class: end of getter for slot ce_with_down_de

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot up_fraction **/
    protected de.dfki.rdf.util.PropertyInfo m_up_fraction = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("up_fraction", false);

    /** RDFS2Class: putter for slot up_fraction **/
    public void putUp_fraction(String p_up_fraction) {
        m_up_fraction.putValue(p_up_fraction);
    }
    // RDFS2Class: end of putter for slot up_fraction

    /** RDFS2Class: getter for slot up_fraction **/
    public String getUp_fraction() {
        return (String) m_up_fraction.getValue();
    }
    // RDFS2Class: end of getter for slot up_fraction

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot down_fraction **/
    protected de.dfki.rdf.util.PropertyInfo m_down_fraction = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("down_fraction", false);

    /** RDFS2Class: putter for slot down_fraction **/
    public void putDown_fraction(String p_down_fraction) {
        m_down_fraction.putValue(p_down_fraction);
    }
    // RDFS2Class: end of putter for slot down_fraction

    /** RDFS2Class: getter for slot down_fraction **/
    public String getDown_fraction() {
        return (String) m_down_fraction.getValue();
    }
    // RDFS2Class: end of getter for slot down_fraction

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (m_ce_with_up_de.getValue() != null) {
            sb.append(sIndent + "-> ce_with_up_de:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_ce_with_up_de
                            .getValue()).toStringShort()
                    + "\n");
            // sb.append(sIndent+"->
            // ce_with_up_de:\n"+((de.dfki.rdf.util.RDFResource)m_ce_with_up_de.getValue()).toString(sIndent+"
            // "));
        }
        if (m_ce_with_down_de.getValue() != null) {
            sb.append(sIndent + "-> ce_with_down_de:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_ce_with_down_de
                            .getValue()).toStringShort()
                    + "\n");
            // sb.append(sIndent+"->
            // ce_with_down_de:\n"+((de.dfki.rdf.util.RDFResource)m_ce_with_down_de.getValue()).toString(sIndent+"
            // "));
        }
        if (m_up_fraction.getValue() != null) {
            sb.append(sIndent + "-> up_fraction: " + m_up_fraction.getValue()
                    + "\n");
        }
        if (m_down_fraction.getValue() != null) {
            sb.append(sIndent + "-> down_fraction: "
                    + m_down_fraction.getValue() + "\n");
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = {};

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public connection_element() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_ce_with_up_de);
        ps.addProperty(m_ce_with_down_de);
        ps.addProperty(m_up_fraction);
        ps.addProperty(m_down_fraction);
    }
    // RDFS2Class: end of PropertyStore-stuff

    private Vector history = new Vector();
    private Vector jumphistory = new Vector();

    public void addTraverseHistoryElement(dependency_element src) {
        if (!history.contains(src)) {
            history.add(src);
        }
    }

    public boolean hasNextDEbeenTraversed(dependency_element src) {

        if (history.contains(src)) {
            return true;
        }

        return false;
    }

}

// RDFS2Class: end of class connection_element
// EOF
