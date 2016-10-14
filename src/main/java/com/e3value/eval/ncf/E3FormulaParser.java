package com.e3value.eval.ncf;

import java.io.BufferedReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.e3value.eval.ncf.ontology.actor;
import com.e3value.eval.ncf.ontology.composite_actor;
import com.e3value.eval.ncf.ontology.connection_element;
import com.e3value.eval.ncf.ontology.dependency_element;
import com.e3value.eval.ncf.ontology.e3value_object;
import com.e3value.eval.ncf.ontology.elementary_actor;
import com.e3value.eval.ncf.ontology.market_segment;
import com.e3value.eval.ncf.ontology.model;
import com.e3value.eval.ncf.ontology.value_activity;
import com.e3value.eval.ncf.ontology.value_exchange;
import com.e3value.eval.ncf.ontology.value_interface;
import com.e3value.eval.ncf.ontology.value_object;
import com.e3value.eval.ncf.ontology.value_offering;
import com.e3value.eval.ncf.ontology.value_port;
import com.e3value.eval.ncf.ontology.value_transaction;

/*
 *
 * E3FormulaParser.java
 *
 * Created on September 16, 2003, 5:46 PM
 */

/**
 *
 * @author  gordijn
 */

import goldengine.RuleConstants;
import goldengine.java.GOLDParser;
import goldengine.java.ParserException;
import goldengine.java.Reduction;
import goldengine.java.Token;

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
/*
 * Licensed Material - Property of Matthew Hawkins (hawkini@myrealbox.com)
 *
 * GOLDParser - code ported from VB - Author Devin Cook. All rights reserved.
 *
 * Modifications to this code are allowed as it is a helper class to use the engine.
 */

/**
 * ---------------------------------------------------------------------------------------<br>
 *
 * Source File: AppleSample.java<br>
 *
 * Author: Matthew Hawkins<br>
 *
 * Description: A Sample class, takes in a set of files and runs the GOLDParser
 * engine on them.<br>
 *
 *
 * ---------------------------------------------------------------------------------------<br>
 *
 * Revision List<br>
 *
 * <pre>
 *      Author          Version         Description
 *      ------          -------         -----------
 *      MPH             1.0             First Issue
 * </pre>
 *
 * <br>
 *
 * ---------------------------------------------------------------------------------------<br>
 *
 * IMPORT: java.io <br>
 * Gold.goldengine.java <br>
 *
 * ---------------------------------------------------------------------------------------<br>
 */
public class E3FormulaParser implements goldengine.java.GPMessageConstants {

    static Logger log = Logger.getLogger(E3FormulaParser.class.getName());

    Map goldRDF;
    String toplevelNav = "";
    String toplevelNavU = "";
    String sublevelNav = "";
    String sublevelNavU = "";
    private BufferedReader buffR;
    private model model;
    private e3value_object mc;

    public String getE3Property() {
        return e3Property;
    }

    public void setE3Property(String e3Property) {
        this.e3Property = e3Property;
    }

    private String e3Property = "";
    GOLDParser parser;

    public E3FormulaParser(GOLDParser parser, model model) {
        this.parser = parser;
        this.model = model;
        goldRDF = new HashMap();
        goldRDF.put("VALUEPORT", Globals.E3_ONTOLOGY_PACKAGE + ".value_port");
        goldRDF.put("VALUEOFFERING",
                Globals.E3_ONTOLOGY_PACKAGE + ".value_offering");
        goldRDF.put("ELEMENTARYACTOR",
                Globals.E3_ONTOLOGY_PACKAGE + ".elementary_actor");
        goldRDF.put("VALUEINTERFACE",
                Globals.E3_ONTOLOGY_PACKAGE + ".value_interface");
        goldRDF.put("OR", Globals.E3_ONTOLOGY_PACKAGE + ".e3value_OR");
        goldRDF.put("AND", Globals.E3_ONTOLOGY_PACKAGE + ".e3value_AND");
        goldRDF.put("VALUETRANSACTION",
                Globals.E3_ONTOLOGY_PACKAGE + ".value_transaction");
        goldRDF.put("VALUEOBJECT",
                Globals.E3_ONTOLOGY_PACKAGE + ".value_object");
        goldRDF.put("COMPOSITEACTOR",
                Globals.E3_ONTOLOGY_PACKAGE + ".composite_actor");
        goldRDF.put("VALUEACTIVITY",
                Globals.E3_ONTOLOGY_PACKAGE + ".value_activity");
        goldRDF.put("VALUEEXCHANGE",
                Globals.E3_ONTOLOGY_PACKAGE + ".value_exchange");
        goldRDF.put("MARKETSEGMENT",
                Globals.E3_ONTOLOGY_PACKAGE + ".market_segment");
        goldRDF.put("SS", Globals.E3_ONTOLOGY_PACKAGE + ".start_stimulus");
        goldRDF.put("ES", Globals.E3_ONTOLOGY_PACKAGE + ".end_stimulus");
        goldRDF.put("DEPENDENCYELEMENT",
                Globals.E3_ONTOLOGY_PACKAGE + ".dependency_element");
        goldRDF.put("CONNECTIONELEMENT",
                Globals.E3_ONTOLOGY_PACKAGE + ".connection_element");
    }

    String rdfName(String goldName) {
        return (String) goldRDF.get(goldName.toUpperCase());
    }

    public Class rdfClass(String goldName) throws ClassNotFoundException {
        return Class.forName(rdfName(goldName));
    }

    public e3value_object getMc() {
        return mc;
    }

    public void parse(String textToParse, e3value_object the_mc, String head,
            int sub) throws E3ParseException {
        String message = "A parsing error occurred in the " + sub
                + "th e3subexpression of the formula for " + head + ":"
                + textToParse + "of the "
                + Globals.shortName(the_mc.getClass().getName()) + " named "
                + the_mc.getE3_has_name();

        mc = the_mc;
        log.debug("Taking model concept as base: " + mc.getE3_has_name());

        log.debug("Begin parse");

        try {
            parser.openFile(textToParse);
        } catch (ParserException e) {
            e.printStackTrace();
            message += "\n" + e.getMessage();
            throw new E3ParseException(message, e);
        }

        boolean done = false;
        int response = -1;

        toplevelNav = "";
        toplevelNavU = "";
        sublevelNav = "";
        sublevelNavU = "";

        while (!done) {
            try {
                response = parser.parse();
            } catch (ParserException parse) {
                log.error("Parse error for " + "\"" + parse.toString() + ".\"");
                throw new E3ParseException(
                        parse.getMessage() + "\nParse error for " + "\""
                                + parse.toString() + ".\"",
                        parse);
            }

            switch (response) {
            case gpMsgTokenRead:
                /*
                 * A token was read by the parser. The Token Object can be
                 * accessed through the CurrentToken() e3Property:
                 * Parser.CurrentToken
                 */

                break;

            case gpMsgAccept:
                /* The program was accepted by the parsing engine */

                log.debug("OK.");

                done = true;

                break;

            case gpMsgLexicalError:
                /*
                 * Place code here to handle a illegal or unrecognized token To
                 * recover, pop the token from the stack: Parser.PopInputToken
                 */

                // ************************************** log file
                message += ("Lexical error: " + "\""
                        + (String) parser.currentToken().getData() + "\""
                        + " is not allowed here.");
                log.error(message);

                done = true;
                throw new E3ParseException(message);

            case gpMsgNotLoadedError:
                /* Load the Compiled Grammar Table file first. */

                // ************************************** log file
                message = "Grammar not loaded, can  not continue.";
                log.error(message);
                // ************************************** end log
                throw new E3ParseException(message);

            case gpMsgSyntaxError:
                /*
                 * This is a syntax error: the source has produced a token that
                 * was not expected by the LALR State Machine. The expected
                 * tokens are stored into the Tokens() list. To recover, push
                 * one of the expected tokens onto the parser's input queue (the
                 * first in this case): You should limit the number of times
                 * this type of recovery can take place.
                 */

                Token theTok = parser.currentToken();
                message += "Token " + "\"" + (String) theTok.getData() + "\""
                        + " not expected.";
                log.error(message);
                throw new E3ParseException(message);

            case gpMsgCommentError:
                /*
                 * The end of the input was reached while reading a comment.
                 * This is caused by a comment that was not terminated
                 */

                message += "gpMsgCommentError";
                log.error(message);

                throw new E3ParseException(message);

            case gpMsgInternalError:
                /*
                 * Something horrid happened inside the parser. You cannot
                 * recover
                 */
                message += "Internal parser error, can not continue.";

                log.error(message);

                throw new E3ParseException(message);

            case gpMsgReduction:
                reduce(parser.currentReduction(), message);

                break;

            }
        }
        try {
            parser.closeFile();
        } catch (ParserException parse) {
            message += "**PARSER ERROR**\n" + parse.toString();
            log.error(message);
            throw new E3ParseException(message);
        }

        log.debug("\n--> End parse");

    }

    Class cl = null;
    Method method = null;
    String methodName = null;
    String sourceClass = null;
    String source = null;

    public void reduce(Reduction reduction, String message)
            throws E3ParseException {
        int case_nr = -1;

        switch (reduction.getParentRule().getTableIndex()) {

        // E3{iden}
        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_IDENTIFIER_RBRACE:
            e3Property = (String) reduction.getToken(2).getData();
            log.debug("00: Property found; e3Property " + e3Property);
            break;

        // E3{uid.iden}
        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_NUM_OBJECTID_DOT_IDENTIFIER_RBRACE:
            String uid = (String) reduction.getToken(3).getData();
            mc = findMcWithUID(uid);
            e3Property = (String) reduction.getToken(5).getData();
            log.debug("01: ObjectId found; Id " + uid + ", Identifier "
                    + e3Property);
            if (mc == null) {
                throw (new E3ParseException(
                        message + "no e3value_object with uid " + uid
                                + " found in model."));
            } else {
                log.debug("\t Model concept: " + mc.getE3_has_name() + "\n");
            }
            break;

        // E3{uid}
        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_NUM_OBJECTID_DOT_RBRACE:
            uid = (String) reduction.getToken(3).getData();
            mc = findMcWithUID(uid);
            log.debug("02: ObjectId found; Id " + uid + " Ontology e3Property "
                    + e3Property);
            if (mc == null) {
                throw (new E3ParseException("no e3value_object with uid " + uid
                        + " found in model. " + message));
            } else {
                log.debug("\t Model concept: " + mc.getE3_has_name() + "\n");
            }
            break;

        // E3{..iden}
        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_DOT_IDENTIFIER_RBRACE:
            log.debug("03: Identifier found; identifier "
                    + reduction.getToken(6).getData());

            e3Property = (String) reduction.getToken(6).getData();

            break;

        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIER_MODEL:
            toplevelNav = (String) reduction.getToken(0).getData();
            mc = model; // return the current model
            log.debug("04: " + toplevelNav);

            break;

        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTION_LPARAN_RPARAN:
            log.debug("05: Toplevel function found; function " + toplevelNav);
            break;

        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTION_LPARAN_OBJECTNAME_RPARAN:
            log.debug("06: Toplevel function found; function " + toplevelNavU
                    + ", argument = " + reduction.getToken(2).getData());
            String name = Globals.shrink(reduction.getToken(2).getData());
            String cl_name = Globals.shortName(cl.getName());

            mc = findMcWithName(cl, name, model.getMo_has_mc().iterator());
            cl = null;
            if (mc == null) {
                throw new E3ParseException("not found globally : a " + cl_name
                        + " named: " + name + ". " + message);
            } else {
                log.debug("\t Model concept: " + mc.getE3_has_name() + "\n");
            }
            break;

        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTION_LPARAN_RPARAN:
            case_nr = 7;
            break;

        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTION_LPARAN_OBJECTNAME_RPARAN:
            case_nr = 8;
            break;

        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_IDENTIFIER_RBRACE:
        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_IDENTIFIER_RBRACE2:
            e3Property = (String) reduction.getToken(4).getData();

            log.debug("09: Identifier found; identifier " + e3Property);

            break;

        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_RBRACE:
        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_RBRACE:
        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_RBRACE2:
        case RuleConstants.RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_DOT_RBRACE:
            log.debug(
                    "10: Ontology e3Property found; e3Property " + e3Property);
            break;

        case RuleConstants.RULE_ONTOLOGYPROPERTY_FORMULA:
        case RuleConstants.RULE_ONTOLOGYPROPERTY_NAME:
        case RuleConstants.RULE_ONTOLOGYPROPERTY_UID:
        case RuleConstants.RULE_ONTOLOGYPROPERTY_UPFRACTION:
        case RuleConstants.RULE_ONTOLOGYPROPERTY_DOWNFRACTION:
        case RuleConstants.RULE_ONTOLOGYPROPERTY_FRACTION:
        case RuleConstants.RULE_ONTOLOGYPROPERTY_DIRECTION:
        case RuleConstants.RULE_ONTOLOGYPROPERTY_VALUATION:
            e3Property = (String) reduction.getToken(0).getData();
            log.debug("11: " + e3Property);
            break;

        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_MARKETSEGMENT:
            cl = market_segment.class;
            case_nr = 12;
            break;
        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_ELEMENTARYACTOR:
            cl = elementary_actor.class;
            case_nr = 12;
            break;
        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_COMPOSITEACTOR:
            cl = composite_actor.class;
            case_nr = 12;
            break;
        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEOBJECT:
            cl = value_object.class;
            case_nr = 12;
            break;
        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_CONNECTIONELEMENT:
            cl = connection_element.class;
            case_nr = 12;
            break;

        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_DEPENDENCYELEMENT:
            cl = dependency_element.class;
            case_nr = 12;
            break;
        case RuleConstants.RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEINTERFACE:
            cl = value_interface.class;
            case_nr = 12;
            break;

        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEINTERFACEASSIGNEDTOACTOR:
            // cl = value_interface.class;
            cl = value_interface.class;
            methodName = "GetVi_assigned_to_ac";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEINTERFACEASSIGNEDTOMARKETSEGMENT:
            // cl = value_interface.class;
            cl = value_interface.class;
            methodName = "GetVi_assigned_to_ms";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEINTERFACEASSIGNEDTOVALUEACTIVITY:
            // cl = value_interface.class;
            cl = value_interface.class;
            methodName = "GetVi_assigned_to_va";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEPORTINVALUEOFFERING:
            // cl = value_port.class;
            cl = value_port.class;
            methodName = "GetVp_in_vo";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEPORTREQUESTSOROFFERSVALUEOBJECT:
            // cl = value_port.class;
            cl = value_port.class;
            methodName = "GetVp_requests_offers_vo";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEOFFERINGINVALUEINTERFACE:
            // cl = value_offering.class;
            cl = value_offering.class;
            methodName = "GetVo_in_vi";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEACTIVITYPERFORMEDBYELEMENTARYACTOR:
            // cl = value_activity.class;
            cl = value_activity.class;
            methodName = "GetVa_performed_by_el";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUETRANSFERHASFIRSTVALUEPORT:
            // cl = value_exchange.class;
            cl = value_exchange.class;
            methodName = "GetVe_has_first_vp";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUETRANSFERHASSECONDVALUEPORT:
            // cl = value_exchange.class;
            cl = value_exchange.class;
            methodName = "GetVe_has_second_vp";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUETRANSFERHASINPORT:
            // cl = value_exchange.class;
            cl = value_exchange.class;
            methodName = "GetVe_has_in_vp";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUETRANSFERHASOUTPORT:
            cl = value_exchange.class;
            methodName = "GetVe_has_out_vp";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_CONNECTIONELEMENTHASDOWNDEPENDENCYELEMENT:
            // cl = connection_element.class;
            cl = connection_element.class;
            methodName = "GetCe_with_down_de";
            case_nr = 13;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_CONNECTIONELEMENTHASUPDEPENDENCYELEMENT:
            // cl = connection_element.class;
            cl = connection_element.class;
            methodName = "GetCe_with_up_de";
            case_nr = 13;
            break;

        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_ACTORHASVALUEINTERFACE:
            cl = actor.class;
            methodName = "getAc_has_vi";
            // cl = value_interface.class;
            case_nr = 14;
            break;

        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEINTERFACECONSISTSOFOFFERING:
            cl = value_interface.class;
            methodName = "getVi_consists_of_of";
            // cl = value_offering.class;
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEOFFERINGCONSISTSOFVALUEPORT:
            cl = value_offering.class;
            methodName = "getVo_consists_of_vp";
            // cl = value_port.class;
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEPORTOUTCONNECTSTOVALUETRANSFER:
            cl = value_port.class;
            methodName = "getVp_out_connects_ve";
            // cl = value_exchange.class;
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEPORTFIRSTCONNECTSTOVALUETRANSFER:
            cl = value_port.class;
            methodName = "getVp_first_connects_ve";
            // cl = value_exchange.class;
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEPORTSECONDCONNECTSTOVALUETRANSFER:
            cl = value_port.class;
            methodName = "getVp_second_connects_ve";
            // cl = value_exchange.class;
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEPORTINCONNECTSTOVALUETRANSFER:
            cl = value_port.class;
            methodName = "getVp_in_connects_ve";
            // cl = value_exchange.class;
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUETRANSFERINVALUETRANSACTION:
            cl = value_exchange.class;
            methodName = "getVe_in_vt";
            // cl = value_transaction.class;
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUETRANSACTIONCONSISTSOFVALUETRANSFER:
            cl = value_transaction.class;
            methodName = "getVt_consists_of_ve";
            case_nr = 14;
            break;

        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_ACTORINMARKETSEGMENT:
            cl = actor.class;
            methodName = "getAc_in_ms";
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_ELEMENTARYACTORPERFORMSVALUEACTIVITY:
            cl = elementary_actor.class;
            methodName = "getEl_performs_va";
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_COMPOSITEACTORCONSISTSOFVALUEINTERFACE:
            cl = composite_actor.class;
            methodName = "getCa_consists_of_vi";
            case_nr = 14;
            break;

        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEACTIVITYHASVALUEINTERFACE:
            cl = value_activity.class;
            methodName = "getVa_has_vi";
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_MARKETSEGMENTCONSISTSOFACTOR:
            cl = market_segment.class;
            methodName = "getMs_consists_of_ac";
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_MARKETSEGMENTHASVALUEINTERFACE:
            cl = market_segment.class;
            methodName = "getMs_has_vi";
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_DEPENDENCYELEMENTWITHDOWNCONNECTIONELEMENT:
            cl = dependency_element.class;
            methodName = "getDe_down_ce";
            case_nr = 14;
            break;
        case RuleConstants.RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_DEPENDENCYELEMENTWITHUPCONNECTIONELEMENT:
            cl = dependency_element.class;
            methodName = "getDe_up_ce";
            case_nr = 14;
            break;
        }

        switch (case_nr) {
        case 7:
            log.debug("07: Sublevel function found; function " + sublevelNav);
            sourceClass = Globals.shortName(mc.getClass().getName());
            source = mc.getE3_has_name();
            log.debug("Source object: " + source);
            try {
                mc = (e3value_object) method.invoke(mc, new Object[] {});
                if (mc == null) {
                    throw new E3ParseException(message + "\nmethod named "
                            + method.getName() + " returns null applied to "
                            + sourceClass + " named " + source);
                } else {
                    log.debug(
                            "\t Model concept: " + mc.getE3_has_name() + "\n");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message
                        + "\nIllegalAccessException in" + case_nr + " "
                        + sourceClass + " " + source + " " + sublevelNav);
            } catch (IllegalArgumentException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message
                        + "\nIllegalArgumentException in" + case_nr + " "
                        + sourceClass + " " + source + " " + sublevelNav);
            } catch (InvocationTargetException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message
                        + "\nInvocationTargetException " + case_nr + " "
                        + sourceClass + " " + source + " " + sublevelNav);
            }
            break;

        case 8:
            log.debug("08: Sublevel function found; function " + sublevelNavU
                    + ", argument = "
                    + Globals.shrink(reduction.getToken(2).getData()));
            String[] args = new String[0];
            // args[0] = (String)reduction.getToken(3).getData();
            try {
                Collection coll = (Collection) method.invoke(mc, args);
                sourceClass = Globals.shortName(mc.getClass().getName());
                source = mc.getE3_has_name();
                String target = Globals.shrink(reduction.getToken(2).getData());
                mc = findMcWithName(target, coll.iterator());
                if (mc == null) {
                    throw new E3ParseException(message + "\nnot found in "
                            + sourceClass + " named " + source
                            + " an e3value_object " + " named: " + target);
                } else {
                    log.debug(
                            "\t Model concept: " + mc.getE3_has_name() + "\n");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message
                        + "\nIllegalAccessException in" + case_nr + " "
                        + sourceClass + " " + source + " " + sublevelNavU);
            } catch (IllegalArgumentException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message
                        + "\nIllegalArgumentException " + case_nr + " "
                        + sourceClass + " " + source + " " + sublevelNavU);
            } catch (InvocationTargetException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message
                        + "\nInvocationTargetException " + case_nr + " "
                        + sourceClass + " " + source + " " + sublevelNavU);
            }
            break;

        case 12:
            toplevelNavU = (String) reduction.getToken(0).getData();
            log.debug("12: " + toplevelNavU);
            break;
        case 13:
            try {
                sublevelNav = (String) reduction.getToken(0).getData();
                log.debug("13: " + sublevelNav + ", methodname " + methodName);
                method = cl.getMethod(methodName, new Class[] {});
            } catch (NoSuchMethodException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message + "\nNoSuchMethodException "
                        + e.getMessage() + " " + case_nr + "\nin"
                        + Globals.shortName(cl.getName()) + " " + methodName
                        + " " + sublevelNav, e);
            } catch (SecurityException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message + "\nSecurityException "
                        + e.getMessage() + " " + case_nr + "\nin"
                        + Globals.shortName(cl.getName()) + " " + methodName
                        + " " + sublevelNav, e);
            }
            break;
        case 14:
            try {
                sublevelNavU = (String) reduction.getToken(0).getData();
                log.debug("14: " + sublevelNavU);
                method = cl.getMethod(methodName, new Class[] {});
            } catch (NoSuchMethodException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message + "\nNoSuchMethodException "
                        + e.getMessage() + " " + case_nr + "\nin"
                        + Globals.shortName(cl.getName()) + " " + methodName
                        + " " + sublevelNavU, e);
            } catch (SecurityException e) {
                e.printStackTrace(); // To change body of catch statement use
                                     // Options | File Templates.
                throw new E3ParseException(message + "\nSecurityException "
                        + e.getMessage() + " " + case_nr + "\nin"
                        + Globals.shortName(cl.getName()) + " " + methodName
                        + " " + sublevelNavU, e);
            }
            break;
        }

    }

    private e3value_object findMcWithName(String name, Iterator it) {
        while (it.hasNext()) {
            e3value_object mc = (e3value_object) it.next();
            if (name.equals(mc.getE3_has_name())) {
                return mc;
            }
        }
        return null;
    }

    private e3value_object findMcWithName(Class cl, String name, Iterator it) {
        if (cl == null) {
            return findMcWithName(name, it);
        }
        while (it.hasNext()) {
            e3value_object mc = (e3value_object) it.next();
            if (cl.isInstance(mc) && name.equals(mc.getE3_has_name())) {
                return mc;
            }
        }
        return null;
    }

    private e3value_object findMcWithUID(String uid) {
        for (Iterator it = model.getMo_has_mc().iterator(); it.hasNext();) {
            e3value_object mc = (e3value_object) it.next();
            if (uid.equals(mc.getE3_has_uid())) {
                return mc;
            }
        }
        return null;
    }

}
