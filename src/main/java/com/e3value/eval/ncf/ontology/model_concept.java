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
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

// RDFS2Class: end of imports

/**
 * RDFS2Class: class model_concept
 * <p>
 */
public class model_concept extends e3value_object {

    static Logger log = Logger.getLogger(model_concept.class.getName());

    private Vector TraverseCalculated = new Vector();

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot mc_in_mo **/
    protected de.dfki.rdf.util.PropertyInfo m_mc_in_mo = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("mc_in_mo", new Class[] { model.class },
                    false);

    /** RDFS2Class: putter for slot mc_in_mo **/
    public void putMc_in_mo(model p_mc_in_mo) {
        m_mc_in_mo.putValue(p_mc_in_mo);
    }

    public void putMc_in_mo(de.dfki.rdf.util.RDFResource p_mc_in_mo) {
        m_mc_in_mo.putValue(p_mc_in_mo);
    }
    // RDFS2Class: end of putter for slot mc_in_mo

    /** RDFS2Class: getter for slot mc_in_mo **/
    public model GetMc_in_mo() {
        return (model) m_mc_in_mo.getValue();
    }

    public de.dfki.rdf.util.RDFResource getMc_in_mo() {
        return (de.dfki.rdf.util.RDFResource) m_mc_in_mo.getValue();
    }
    // RDFS2Class: end of getter for slot mc_in_mo

    // ------------------------------------------------------------------------------
    /** RDFS2Class: slot mc_in_di **/
    protected de.dfki.rdf.util.PropertyInfo m_mc_in_di = de.dfki.rdf.util.PropertyInfo
            .createInstanceProperty("mc_in_di", new Class[] { diagram.class },
                    true);

    /** RDFS2Class: putter for slot mc_in_di **/
    public void putMc_in_di(diagram p_mc_in_di) {
        m_mc_in_di.putValue(p_mc_in_di);
    }

    public void putMc_in_di(de.dfki.rdf.util.RDFResource p_mc_in_di) {
        m_mc_in_di.putValue(p_mc_in_di);
    }

    public void putMc_in_di(java.util.Collection p_mc_in_di) {
        m_mc_in_di.setValues(p_mc_in_di);
    }

    public void clearMc_in_di() {
        m_mc_in_di.clearValue();
    }
    // RDFS2Class: end of putter for slot mc_in_di

    /** RDFS2Class: getter for slot mc_in_di **/
    public java.util.Collection getMc_in_di() {
        return (java.util.Collection) m_mc_in_di.getValue();
    }
    // RDFS2Class: end of getter for slot mc_in_di

    // ------------------------------------------------------------------------------
    /** RDFS2Class: toString()-stuff **/
    @Override
    public void toString(StringBuffer sb, String sIndent) {
        super.toString(sb, sIndent);
        if (m_mc_in_mo.getValue() != null) {
            sb.append(sIndent + "-> mc_in_mo:\n" + sIndent + "       "
                    + ((de.dfki.rdf.util.RDFResource) m_mc_in_mo.getValue())
                            .toStringShort()
                    + "\n");
            // sb.append(sIndent+"->
            // mc_in_mo:\n"+((de.dfki.rdf.util.RDFResource)m_mc_in_mo.getValue()).toString(sIndent+"
            // "));
        }
        if (!m_mc_in_di.isEmpty()) {
            sb.append(sIndent + "-> mc_in_di:\n");
            for (Iterator it_mc_in_di = ((java.util.Collection) m_mc_in_di
                    .getValue()).iterator(); it_mc_in_di.hasNext();) {
                Object o = it_mc_in_di.next();
                if (o != null) {
                    sb.append(sIndent + "       "
                            + ((de.dfki.rdf.util.RDFResource) o).toStringShort()
                            + "\n");
                }
                // sb.append(
                // ((de.dfki.rdf.util.RDFResource)it_mc_in_di.next()).toString(sIndent+"
                // ") );
            }
        }
    }
    // RDFS2Class: end of toString()-stuff

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = { value_activity.class,
            value_exchange.class, market_segment.class, value_offering.class,
            dependency_element.class, actor.class, connection_element.class,
            value_transaction.class, value_object.class, value_port.class };

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public model_concept() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
        ps.addProperty(m_mc_in_mo);
        ps.addProperty(m_mc_in_di);
    }
    // RDFS2Class: end of PropertyStore-stuff

    private boolean hasBeenTraversed = false;

    public boolean hasBeenTraversed() {
        return hasBeenTraversed;
    }

    public void setHasBeenTraversed(boolean hasBeenTraversed) {
        this.hasBeenTraversed = hasBeenTraversed;
    }

    public boolean hasBeenSeen() {
        return seen;
    }

    public void toggleSeen(boolean seen, Map mapObjects) {
        this.seen = seen;

        Collection c = new Vector();
        if (this instanceof value_interface) {
            value_interface vi = (value_interface) this;
            c.addAll(vi.getVi_consists_of_of());
            c.add(vi.GetVi_assigned_to_va());
            c.add(vi.GetVi_assigned_to_ac());
            c.add(vi.GetVi_assigned_to_ms());
        }

        if (this instanceof value_offering) {
            value_offering vo = (value_offering) this;
            c.addAll(vo.getVo_consists_of_vp());
            c.add(vo.GetVo_in_vi());
        }

        if (this instanceof value_port) {
            value_port vp = (value_port) this;
            c.addAll(vp.getVp_in_connects_ve());
            c.addAll(vp.getVp_out_connects_ve());
            c.addAll(vp.getVp_second_connects_ve());
            c.addAll(vp.getVp_first_connects_ve());
            c.add(vp.GetVp_requests_offers_vo());
        }

        if (this instanceof dependency_element) {
            dependency_element de = (dependency_element) this;
            c.addAll(de.getDe_down_ce());
        }

        // related elements
        Iterator i = c.iterator();
        while (i.hasNext()) {
            model_concept mc = (model_concept) i.next();
            if (mc != null && !mc.hasBeenSeen()) {
                mc.toggleSeen(seen, mapObjects);
            }
        }
    }
    // RDFS2Class: end of PropertyStore-stuff

    private boolean seen = false;

}

// RDFS2Class: end of class model_concept
// EOF
