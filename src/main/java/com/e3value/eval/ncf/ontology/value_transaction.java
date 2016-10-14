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
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.e3value.eval.ncf.E3ParseException;
import com.e3value.eval.ncf.ProfGenerator;

// RDFS2Class: end of imports

/**
 * RDFS2Class: class value_transaction
 * <p>
 */
public class value_transaction extends model_concept {

    static Logger log = Logger.getLogger(value_transaction.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vt_has_fraction **/
    protected de.dfki.rdf.util.PropertyInfo m_vt_has_fraction = de.dfki.rdf.util.PropertyInfo
            .createStringProperty("vt_has_fraction", false);

    /** RDFS2Class: putter for slot vt_has_fraction **/
    public void putVt_has_fraction(String p_vt_has_fraction) {
        m_vt_has_fraction.putValue(p_vt_has_fraction);
    }
    // RDFS2Class: end of putter for slot vt_has_fraction

    /** RDFS2Class: getter for slot vt_has_fraction **/
    public String getVt_has_fraction() {
        return (String) m_vt_has_fraction.getValue();
    }
    // RDFS2Class: end of getter for slot vt_has_fraction

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot vt_consists_of_ve **/
    protected de.dfki.rdf.util.PropertyInfo m_vt_consists_of_ve = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("vt_consists_of_ve",
                    new Class[] { value_exchange.class }, true);

    /** RDFS2Class: putter for slot vt_consists_of_ve **/
    public void putVt_consists_of_ve(value_exchange p_vt_consists_of_ve) {
        m_vt_consists_of_ve.putValue(p_vt_consists_of_ve);
    }

    public void putVt_consists_of_ve(
            de.dfki.rdf.util.RDFResource p_vt_consists_of_ve) {
        m_vt_consists_of_ve.putValue(p_vt_consists_of_ve);
    }

    public void putVt_consists_of_ve(java.util.Collection p_vt_consists_of_ve) {
        m_vt_consists_of_ve.setValues(p_vt_consists_of_ve);
    }

    public void clearVt_consists_of_ve() {
        m_vt_consists_of_ve.clearValue();
    }
    // RDFS2Class: end of putter for slot vt_consists_of_ve

    /** RDFS2Class: getter for slot vt_consists_of_ve **/
    public java.util.Collection getVt_consists_of_ve() {
        return (java.util.Collection) m_vt_consists_of_ve.getValue();
    }
    // RDFS2Class: end of getter for slot vt_consists_of_ve

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (m_vt_has_fraction.getValue() != null) {
            sb.append(sIndent + "-> vt_has_fraction: "
                    + m_vt_has_fraction.getValue() + "\n");
        }
        if (!m_vt_consists_of_ve.isEmpty()) {
            sb.append(sIndent + "-> vt_consists_of_ve:\n");
            for (Iterator it_vt_consists_of_ve = ((java.util.Collection) m_vt_consists_of_ve
                    .getValue()).iterator(); it_vt_consists_of_ve.hasNext();) {
                sb.append(sIndent + "       "
                        + ((de.dfki.rdf.util.RDFResource) it_vt_consists_of_ve
                                .next()).toStringShort()
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
    public value_transaction() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_vt_has_fraction);
        ps.addProperty(m_vt_consists_of_ve);
    }
    // RDFS2Class: end of PropertyStore-stuff

    public boolean verifyConnections() throws E3ParseException {
        boolean result = true;
        Collection unique_vis = ProfGenerator.vt_involves_unique_vis(this);
        Collection vps = ProfGenerator.vt_involves_vps(this);
        Collection spotted_vps = new Vector();
        Iterator i_unique_vis = unique_vis.iterator();

        while (i_unique_vis.hasNext()) {
            value_interface vi = (value_interface) i_unique_vis.next();
            Collection vi_has_ports = ProfGenerator.vi_has_ports(vi);
            Iterator i_vi_has_ports = vi_has_ports.iterator();

            while (i_vi_has_ports.hasNext()) {
                value_port vp = (value_port) i_vi_has_ports.next();
                Iterator i = vps.iterator();
                boolean found = false;
                while (i.hasNext()) {
                    value_port testvp = (value_port) i.next();
                    if (vp.equals(testvp)) {
                        found = true;
                        if (spotted_vps.contains(vp)) {
                            throw new E3ParseException("value port '"
                                    + vp.getE3_has_name()
                                    + "' involved in value transaction "
                                    + getE3_has_name() + " (more than once)");
                        }
                        spotted_vps.add(vp);
                        i.remove();

                    }
                }
                if (!found) {
                    throw new E3ParseException(
                            "value port '" + vp.getE3_has_name()
                                    + "' not involved in value transaction"
                                    + getE3_has_name());
                }
            }
        }
        return result;
    }

    /*
     * Administration of the interface that may set the occurrences for this
     * transaction Set during spreadsheet generation
     */
    private value_interface responsible_for_update_occcurences = null;
    // This variable contains the only interface responsible for updating the
    // transaction.
    // Set by ProfitGenerator

    public void setResponsibleForUpdateOccurrences(
            value_interface responsible_for_update_occcurences) {
        if (this.responsible_for_update_occcurences != null) {
            log.info("Warning: overriding reponsible interface with "
                    + responsible_for_update_occcurences.getE3_has_name()
                    + " for updating value transaction " + getE3_has_name());
        }
        this.responsible_for_update_occcurences = responsible_for_update_occcurences;
    }

    public value_interface getResponsibleForUpdateOccurrences() {
        return responsible_for_update_occcurences;
    }

}

// RDFS2Class: end of class value_transaction
// EOF
