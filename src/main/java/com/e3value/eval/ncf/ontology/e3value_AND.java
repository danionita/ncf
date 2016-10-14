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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

// RDFS2Class: end of imports

/**
 * RDFS2Class: class e3value_AND
 * <p>
 */
public class e3value_AND extends dependency_element {

    static Logger log = Logger.getLogger(e3value_AND.class.getName());

    // ------------------------------------------------------------------------------
    /** RDFS2Class: sub class information **/
    public final static Class[] KNOWN_SUBCLASSES = {};

    // RDFS2Class: end of sub class information

    // ------------------------------------------------------------------------------
    /** RDFS2Class: default constructor **/
    public e3value_AND() {
        super();
        initPropertyStore();
    }
    // RDFS2Class: end of default constructor

    // ------------------------------------------------------------------------------
    /** RDFS2Class: PropertyStore-stuff **/
    private void initPropertyStore() {
        de.dfki.rdf.util.PropertyStore ps = getPropertyStore();
    }
    // RDFS2Class: end of PropertyStore-stuff

    HashMap VISIT_ADMINISTRATION = new HashMap();
    connection_element FIRSTSOURCE = null;

    public String fetchAdministationString() {
        String s = "";
        Collection values = VISIT_ADMINISTRATION.keySet();
        Iterator i = values.iterator();

        s += "[";

        while (i.hasNext()) {
            connection_element c = (connection_element) i.next();
            s += c.getE3_has_name();
            s += ":" + VISIT_ADMINISTRATION.get(c) + ",";
        }
        s += "]\n";

        return s;
    }

    public void printAdministration() {
        log.debug("\t AND: " + fetchAdministationString());
    }

    public void appendAdministration(connection_element connection_element,
            double f) {
        if (VISIT_ADMINISTRATION.get(connection_element) != null) {
            double previous_f = ((Double) VISIT_ADMINISTRATION
                    .get(connection_element)).doubleValue();
            VISIT_ADMINISTRATION.remove(connection_element);
            VISIT_ADMINISTRATION.put(connection_element,
                    new Double(f + previous_f));

        } else {
            VISIT_ADMINISTRATION.put(connection_element, new Double(f));
        }
    }

    public int fetchTransactionVisitCount() {
        return VISIT_ADMINISTRATION.size();
    }

    public HashMap fetchAdministration() {
        return VISIT_ADMINISTRATION;
    }

    public void placeFirst_source(connection_element connection_element) {
        FIRSTSOURCE = connection_element;
    }

    public connection_element fetchFirst_source() {
        return FIRSTSOURCE;
    }

    public boolean verifyAdministration() {
        Collection values = VISIT_ADMINISTRATION.values();
        Iterator i = values.iterator();
        double previous = 0.0;
        double allowed_deviation = 0.01;
        boolean firsttime = true;

        while (i.hasNext()) {
            double hits = ((Double) i.next()).doubleValue();

            if (!firsttime) {
                // test
                log.debug("hits " + hits + " previuos " + previous);
                if (!((hits <= previous * (allowed_deviation + 1))
                        && (hits >= previous * (1 - allowed_deviation)))) {
                    return false;
                }
            }
            previous = hits;
            firsttime = false;
        }
        return true;
    }

}

// RDFS2Class: end of class e3value_AND
// EOF
