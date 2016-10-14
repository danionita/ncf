package com.e3value.eval.ncf;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.e3value.eval.ncf.ontology.start_stimulus;

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

public class ScenarioUsage {

    static Logger log = Logger.getLogger(ScenarioUsage.class.getName());

    private HashMap map = new HashMap();
    private com.e3value.eval.ncf.ontology.e3value_object owner = null;

    public ScenarioUsage(com.e3value.eval.ncf.ontology.e3value_object o) {
        owner = o;
    }

    public void appendScenarioUsage(start_stimulus start, double value) {
        if (!map.containsKey(start)) {
            map.put(start, new Double(value));
        } else {
            Double d = (Double) map.get(start);
            map.remove(start);
            map.put(start, new Double(value + d.doubleValue()));
        }

    }

    public Double getTotalOccurences() {
        double t = 0.0;
        boolean returnvalue = false;
        Collection v = map.values();
        Iterator i = v.iterator();
        while (i.hasNext()) {
            Double o = (Double) i.next();
            if (o != null) {
                t = Double.parseDouble((t + o.doubleValue()) + "");
                returnvalue = true;
            }
        }
        if (returnvalue) {
            return new Double(t);
        } else {
            return null;
        }
    }

    public void printout() {
        Collection c = map.keySet();
        if (c.size() > 0 && !(owner instanceof start_stimulus)) {
            log.debug("- ScenarioUsage:" + owner.getClass().getName() + " for "
                    + owner.getE3_has_uid() + " " + owner.getE3_has_name());
            Iterator i = c.iterator();
            double sum = 0;
            while (i.hasNext()) {
                start_stimulus key = (start_stimulus) i.next();
                String key_ID = key.getE3_has_uid();
                Double value = (Double) map.get(key);
                sum = sum + value.doubleValue();
                log.debug("\t start stimulus " + key_ID + "\t" + value);
            }
            log.debug("\t total: \t" + sum);
        }
    }

    public Set getStartStimuli() {
        return map.keySet();
    }
}
