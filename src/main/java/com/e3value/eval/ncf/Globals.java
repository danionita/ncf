package com.e3value.eval.ncf;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

public final class Globals {

    static Logger log = Logger.getLogger(Globals.class.getName());

    static final public String DEBUG_STORAGE_PATH = "H:/java/e3-output.rdf",
            E3_NAMESPACE = "http://www.cs.vu.nl/~gordijn/e3value#",
            E3_ONTOLOGY_PACKAGE = "com.e3value.eval.ncf.ontology";

    static final public int FORMULA_BODY = 1, FORMULA_PREFIX = 0;

    static public boolean DEBUG = false, NoSave = false;

    public static final String prefix = "E3tor_";
    public static boolean XSVG = false;
    public static final String defaultFormula = "default = e3{ElementaryActor(\"actor1\").Name}";

    public static final boolean LOGFP = true;

    static public String trunc(final String s, final char c) {
        return s.substring(s.lastIndexOf(c) + 1);
    }

    public static void center(Component c) {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        c.setLocation(((screen.width - c.getWidth()) / 2),
                (screen.height - c.getHeight()) / 2);
    }

    static public String trimFormula(String f, final int whichpartofformula)
            throws E3ParseException {

        f = f.replaceAll("\\s", "");
        final String[] s = f.split("=");

        if (s.length < 2) {
            return null;
        }
        if (s.length > 2) {
            throw new E3ParseException(
                    "Syntax error (multiple\"=\" symbols in formula \"" + f
                            + "\")");
        }

        if (whichpartofformula == Globals.FORMULA_PREFIX) {
            return s[0];
        } else {
            return s[1];
        }
    }

    static public String fTail(final String formula) {
        String result;
        if (formula == null) {
            return null;
        }
        final int pos = formula.indexOf('=');
        if (pos < 0 || pos >= formula.length() - 1) {
            return null;
        }
        result = formula.substring(pos + 1);
        if (result == null) {
            return null;
        }
        result.trim();
        if (result.length() > 0) {
            return result;
        }
        return null;
    }

    static public String fHead(final String formula) {
        String result;
        if (formula == null) {
            return null;
        }
        final int pos = formula.indexOf('=');
        if (pos < 0) {
            return null;
        }
        result = formula.substring(0, pos);
        if (result == null) {
            return null;
        }
        result.trim();
        if (result.length() > 0) {
            return result;
        }
        return null;
    }

    public static String shrink(final Object data) {
        final String input = (String) data;
        return input.substring(1, input.length() - 1);
    }

    static public String trunc0(final String s, final String prefix) {
        String result = s;
        if (result.startsWith(prefix)) {
            result = s.substring(prefix.length());
        }
        return result;
    }

    static public String trunc1(String name) {
        name = Globals.trunc(name, '.');
        name = Globals.trunc0(name, Globals.prefix);
        return name;
    }

    private static Map shortName;
    private static Map mediumName;

    public static String shortName(String longName) {
        if (shortName == null) {
            initShortNameMaps();
        }
        longName = trunc1(longName);
        final Object obj = shortName.get(longName.toLowerCase());
        return obj == null ? longName : (String) obj;
    }

    public static String mediumName(String longName) {
        if (mediumName == null) {
            initMediumNameMaps();
        }
        longName = trunc1(longName);
        final Object obj = mediumName.get(longName.toLowerCase());
        return obj == null ? longName : (String) obj;
    }

    public static void initMediumNameMaps() {
        Globals.mediumName = new HashMap();
        Globals.mediumName.put("actor", "actor");
        Globals.mediumName.put("business_case", "business case");
        Globals.mediumName.put("composite_actor", "composite actor");
        Globals.mediumName.put("connection_element", "connection element");
        Globals.mediumName.put("dependency_element", "dependency element");
        Globals.mediumName.put("diagram", "diagram");
        Globals.mediumName.put("elementary_actor", "elementary actor");
        Globals.mediumName.put("end_stimulus", "end stimulus");
        Globals.mediumName.put("e3value_or", "or-fork");
        Globals.mediumName.put("e3value_and", "and-fork");
        Globals.mediumName.put("e3value_object", "value object");
        Globals.mediumName.put("market_segment", "marketsegment");
        Globals.mediumName.put("model_concept", "model concept");
        Globals.mediumName.put("scenarioport", "scenarioport");
        Globals.mediumName.put("start_stimulus", "start stimulus");
        Globals.mediumName.put("value_activity", "value activity");
        Globals.mediumName.put("value_exchange", "value exchange");
        Globals.mediumName.put("value_interface", "value interface");
        Globals.mediumName.put("value_object", "value object");
        Globals.mediumName.put("value_offering", "value offering");
        Globals.mediumName.put("value_port", "value port");
        Globals.mediumName.put("value_transaction", "value transaction");

    }

    public static void initShortNameMaps() {
        Globals.shortName = new HashMap();
        Globals.shortName.put("actor", "ac");
        Globals.shortName.put("business_case", "bc");
        Globals.shortName.put("composite_actor", "ca");
        Globals.shortName.put("connection_element", "ce");
        Globals.shortName.put("dependency_element", "de");
        Globals.shortName.put("diagram", "di");
        Globals.shortName.put("elementary_actor", "ea");
        Globals.shortName.put("end_stimulus", "es");
        Globals.shortName.put("e3value_or", "or");
        Globals.shortName.put("e3value_and", "and");
        Globals.shortName.put("e3value_object", "e3vo");
        Globals.shortName.put("market_segment", "ms");
        Globals.shortName.put("model_concept", "mc");
        Globals.shortName.put("scenarioport", "sp");
        Globals.shortName.put("start_stimulus", "ss");
        Globals.shortName.put("value_activity", "va");
        Globals.shortName.put("value_exchange", "ve");
        Globals.shortName.put("value_interface", "vi");
        Globals.shortName.put("value_object", "ob");
        Globals.shortName.put("value_offering", "of");
        Globals.shortName.put("value_port", "vp");
        Globals.shortName.put("value_transaction", "vt");

    }

    public static String tabs(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "\t";
        }
        return s;
    }

    private static Random rn = new Random();

    public static String randomstring(int lo, int hi) {
        int n = rand(lo, hi);
        byte b[] = new byte[n];
        for (int i = 0; i < n; i++) {
            b[i] = (byte) rand('a', 'z');
        }
        return new String(b.toString());
    }

    public static int rand(int lo, int hi) {
        int n = hi - lo + 1;
        int i = rn.nextInt() % n;
        if (i < 0) {
            i = -i;
        }
        return lo + i;
    }

}
