package com.e3value.eval.ncf.ontology;

import java.util.Iterator;

import org.apache.log4j.Logger;

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

// RDFS2Class: end of imports

/**
 * RDFS2Class: class business_case
 * <p>
 */
public class business_case extends e3value_object {

    static Logger log = Logger.getLogger(business_case.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot bc_has_mo **/
    protected de.dfki.rdf.util.PropertyInfo m_bc_has_mo = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("bc_has_mo", new Class[] { model.class },
                    true);

    /** RDFS2Class: putter for slot bc_has_mo **/
    public void putBc_has_mo(model p_bc_has_mo) {
        m_bc_has_mo.putValue(p_bc_has_mo);
    }

    public void putBc_has_mo(de.dfki.rdf.util.RDFResource p_bc_has_mo) {
        m_bc_has_mo.putValue(p_bc_has_mo);
    }

    public void putBc_has_mo(java.util.Collection p_bc_has_mo) {
        m_bc_has_mo.setValues(p_bc_has_mo);
    }

    public void clearBc_has_mo() {
        m_bc_has_mo.clearValue();
    }
    // RDFS2Class: end of putter for slot bc_has_mo

    /** RDFS2Class: getter for slot bc_has_mo **/
    public java.util.Collection getBc_has_mo() {
        return (java.util.Collection) m_bc_has_mo.getValue();
    }
    // RDFS2Class: end of getter for slot bc_has_mo

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (!m_bc_has_mo.isEmpty()) {
            sb.append(sIndent + "-> bc_has_mo:\n");
            for (Iterator it_bc_has_mo = ((java.util.Collection) m_bc_has_mo
                    .getValue()).iterator(); it_bc_has_mo.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_bc_has_mo.next())
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
    public business_case() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_bc_has_mo);
    }
    // RDFS2Class: end of PropertyStore-stuff

}

// RDFS2Class: end of class business_case
// EOF
