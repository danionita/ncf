package goldengine;

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

public interface RuleConstants {

    static Logger log = Logger.getLogger(RuleConstants.class.getName());

    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_IDENTIFIER_RBRACE = 0; // <AttributeReference>
                                                                       // ::=
                                                                       // 'e3'
                                                                       // '{'
                                                                       // Identifier
                                                                       // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_NUM_OBJECTID_DOT_IDENTIFIER_RBRACE = 1; // <AttributeReference>
                                                                                        // ::=
                                                                                        // 'e3'
                                                                                        // '{'
                                                                                        // '#'
                                                                                        // ObjectId
                                                                                        // '.'
                                                                                        // Identifier
                                                                                        // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_IDENTIFIER_RBRACE = 2; // <AttributeReference>
                                                                           // ::=
                                                                           // 'e3'
                                                                           // '{'
                                                                           // <SubLevelNavigation>
                                                                           // '.'
                                                                           // Identifier
                                                                           // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_IDENTIFIER_RBRACE2 = 3; // <AttributeReference>
                                                                            // ::=
                                                                            // 'e3'
                                                                            // '{'
                                                                            // <TopLevelNavigation>
                                                                            // '.'
                                                                            // Identifier
                                                                            // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_DOT_IDENTIFIER_RBRACE = 4; // <AttributeReference>
                                                                               // ::=
                                                                               // 'e3'
                                                                               // '{'
                                                                               // <TopLevelNavigation>
                                                                               // '.'
                                                                               // <SubLevelNavigation>
                                                                               // '.'
                                                                               // Identifier
                                                                               // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_RBRACE = 5; // <AttributeReference>
                                                            // ::= 'e3' '{'
                                                            // <OntologyProperty>
                                                            // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_NUM_OBJECTID_DOT_RBRACE = 6; // <AttributeReference>
                                                                             // ::=
                                                                             // 'e3'
                                                                             // '{'
                                                                             // '#'
                                                                             // ObjectId
                                                                             // '.'
                                                                             // <OntologyProperty>
                                                                             // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_RBRACE = 7; // <AttributeReference>
                                                                // ::= 'e3' '{'
                                                                // <SubLevelNavigation>
                                                                // '.'
                                                                // <OntologyProperty>
                                                                // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_RBRACE2 = 8; // <AttributeReference>
                                                                 // ::= 'e3' '{'
                                                                 // <TopLevelNavigation>
                                                                 // '.'
                                                                 // <OntologyProperty>
                                                                 // '}'
    final int RULE_ATTRIBUTEREFERENCE_E3_LBRACE_DOT_DOT_RBRACE = 9; // <AttributeReference>
                                                                    // ::= 'e3'
                                                                    // '{'
                                                                    // <TopLevelNavigation>
                                                                    // '.'
                                                                    // <SubLevelNavigation>
                                                                    // '.'
                                                                    // <OntologyProperty>
                                                                    // '}'
    final int RULE_TOPLEVELNAVIGATION = 10; // <TopLevelNavigation> ::=
                                            // <TopLevelNavigationFunction>
    final int RULE_TOPLEVELNAVIGATIONFUNCTION_LPARAN_RPARAN = 11; // <TopLevelNavigationFunction>
                                                                  // ::=
                                                                  // <TopLevelNavigationFunctionIdentifier>
                                                                  // '(' ')'
    final int RULE_TOPLEVELNAVIGATIONFUNCTION_LPARAN_OBJECTNAME_RPARAN = 12; // <TopLevelNavigationFunction>
                                                                             // ::=
                                                                             // <TopLevelNavigationFunctionIdentifierU>
                                                                             // '('
                                                                             // ObjectName
                                                                             // ')'
    final int RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIER_MODEL = 13; // <TopLevelNavigationFunctionIdentifier>
                                                                    // ::= Model
    final int RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_MARKETSEGMENT = 14; // <TopLevelNavigationFunctionIdentifierU>
                                                                             // ::=
                                                                             // MarketSegment
    final int RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_ELEMENTARYACTOR = 15; // <TopLevelNavigationFunctionIdentifierU>
                                                                               // ::=
                                                                               // ElementaryActor
    final int RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_COMPOSITEACTOR = 16; // <TopLevelNavigationFunctionIdentifierU>
                                                                              // ::=
                                                                              // CompositeActor
    final int RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEOBJECT = 17; // <TopLevelNavigationFunctionIdentifierU>
                                                                           // ::=
                                                                           // ValueObject
    final int RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_CONNECTIONELEMENT = 18; // <TopLevelNavigationFunctionIdentifierU>
                                                                                 // ::=
                                                                                 // ConnectionElement
    final int RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_DEPENDENCYELEMENT = 19; // <TopLevelNavigationFunctionIdentifierU>
                                                                                 // ::=
                                                                                 // DependencyElement
    final int RULE_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEINTERFACE = 20; // <TopLevelNavigationFunctionIdentifierU>
                                                                              // ::=
                                                                              // ValueInterface
    final int RULE_SUBLEVELNAVIGATION = 21; // <SubLevelNavigation> ::=
                                            // <SubLevelNavigationFunction>
    final int RULE_SUBLEVELNAVIGATION_DOT = 22; // <SubLevelNavigation> ::=
                                                // <SubLevelNavigation> '.'
                                                // <SubLevelNavigationFunction>
    final int RULE_SUBLEVELNAVIGATIONFUNCTION_LPARAN_RPARAN = 23; // <SubLevelNavigationFunction>
                                                                  // ::=
                                                                  // <SubLevelNavigationFunctionIdentifier>
                                                                  // '(' ')'
    final int RULE_SUBLEVELNAVIGATIONFUNCTION_LPARAN_OBJECTNAME_RPARAN = 24; // <SubLevelNavigationFunction>
                                                                             // ::=
                                                                             // <SubLevelNavigationFunctionIdentifierU>
                                                                             // '('
                                                                             // ObjectName
                                                                             // ')'
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEINTERFACEASSIGNEDTOACTOR = 25; // <SubLevelNavigationFunctionIdentifier>
                                                                                            // ::=
                                                                                            // ValueInterfaceAssignedToActor
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEINTERFACEASSIGNEDTOMARKETSEGMENT = 26; // <SubLevelNavigationFunctionIdentifier>
                                                                                                    // ::=
                                                                                                    // ValueInterfaceAssignedToMarketSegment
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEINTERFACEASSIGNEDTOVALUEACTIVITY = 27; // <SubLevelNavigationFunctionIdentifier>
                                                                                                    // ::=
                                                                                                    // ValueInterfaceAssignedToValueActivity
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEPORTINVALUEOFFERING = 28; // <SubLevelNavigationFunctionIdentifier>
                                                                                       // ::=
                                                                                       // ValuePortInValueOffering
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEPORTREQUESTSOROFFERSVALUEOBJECT = 29; // <SubLevelNavigationFunctionIdentifier>
                                                                                                   // ::=
                                                                                                   // ValuePortRequestsOrOffersValueObject
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEOFFERINGINVALUEINTERFACE = 30; // <SubLevelNavigationFunctionIdentifier>
                                                                                            // ::=
                                                                                            // ValueOfferingInValueInterface
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUEACTIVITYPERFORMEDBYELEMENTARYACTOR = 31; // <SubLevelNavigationFunctionIdentifier>
                                                                                                      // ::=
                                                                                                      // ValueActivityPerformedByElementaryActor
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUETRANSFERHASFIRSTVALUEPORT = 32; // <SubLevelNavigationFunctionIdentifier>
                                                                                             // ::=
                                                                                             // ValueTransferHasFirstValuePort
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUETRANSFERHASSECONDVALUEPORT = 33; // <SubLevelNavigationFunctionIdentifier>
                                                                                              // ::=
                                                                                              // ValueTransferHasSecondValuePort
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUETRANSFERHASINPORT = 34; // <SubLevelNavigationFunctionIdentifier>
                                                                                     // ::=
                                                                                     // ValueTransferHasInPort
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_VALUETRANSFERHASOUTPORT = 35; // <SubLevelNavigationFunctionIdentifier>
                                                                                      // ::=
                                                                                      // ValueTransferHasOutPort
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_CONNECTIONELEMENTHASDOWNDEPENDENCYELEMENT = 36; // <SubLevelNavigationFunctionIdentifier>
                                                                                                        // ::=
                                                                                                        // ConnectionElementHasDownDependencyElement
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER_CONNECTIONELEMENTHASUPDEPENDENCYELEMENT = 37; // <SubLevelNavigationFunctionIdentifier>
                                                                                                      // ::=
                                                                                                      // ConnectionElementHasUpDependencyElement
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_ACTORHASVALUEINTERFACE = 38; // <SubLevelNavigationFunctionIdentifierU>
                                                                                      // ::=
                                                                                      // ActorHasValueInterface
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_ACTORINMARKETSEGMENT = 39; // <SubLevelNavigationFunctionIdentifierU>
                                                                                    // ::=
                                                                                    // ActorInMarketSegment
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_ELEMENTARYACTORPERFORMSVALUEACTIVITY = 40; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                    // ::=
                                                                                                    // ElementaryActorPerformsValueActivity
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_COMPOSITEACTORCONSISTSOFVALUEINTERFACE = 41; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                      // ::=
                                                                                                      // CompositeActorConsistsOfValueInterface
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEINTERFACECONSISTSOFOFFERING = 42; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                // ::=
                                                                                                // ValueInterfaceConsistsOfOffering
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEPORTFIRSTCONNECTSTOVALUETRANSFER = 43; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                     // ::=
                                                                                                     // ValuePortFirstConnectsToValueTransfer
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEPORTSECONDCONNECTSTOVALUETRANSFER = 44; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                      // ::=
                                                                                                      // ValuePortSecondConnectsToValueTransfer
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEPORTINCONNECTSTOVALUETRANSFER = 45; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                  // ::=
                                                                                                  // ValuePortInConnectsToValueTransfer
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEPORTOUTCONNECTSTOVALUETRANSFER = 46; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                   // ::=
                                                                                                   // ValuePortOutConnectsToValueTransfer
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEOFFERINGCONSISTSOFVALUEPORT = 47; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                // ::=
                                                                                                // ValueOfferingConsistsOfValuePort
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUEACTIVITYHASVALUEINTERFACE = 48; // <SubLevelNavigationFunctionIdentifierU>
                                                                                              // ::=
                                                                                              // ValueActivityHasValueInterface
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_MARKETSEGMENTCONSISTSOFACTOR = 49; // <SubLevelNavigationFunctionIdentifierU>
                                                                                            // ::=
                                                                                            // MarketSegmentConsistsOfActor
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_MARKETSEGMENTHASVALUEINTERFACE = 50; // <SubLevelNavigationFunctionIdentifierU>
                                                                                              // ::=
                                                                                              // MarketSegmentHasValueInterface
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_DEPENDENCYELEMENTWITHDOWNCONNECTIONELEMENT = 51; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                          // ::=
                                                                                                          // DependencyElementWithDownConnectionElement
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_DEPENDENCYELEMENTWITHUPCONNECTIONELEMENT = 52; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                        // ::=
                                                                                                        // DependencyElementWithUpConnectionElement
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUETRANSACTIONCONSISTSOFVALUETRANSFER = 53; // <SubLevelNavigationFunctionIdentifierU>
                                                                                                       // ::=
                                                                                                       // ValueTransactionConsistsOfValueTransfer
    final int RULE_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU_VALUETRANSFERINVALUETRANSACTION = 54; // <SubLevelNavigationFunctionIdentifierU>
                                                                                               // ::=
                                                                                               // ValueTransferInValueTransaction
    final int RULE_ONTOLOGYPROPERTY_FORMULA = 55; // <OntologyProperty> ::=
                                                  // Formula
    final int RULE_ONTOLOGYPROPERTY_NAME = 56; // <OntologyProperty> ::= Name
    final int RULE_ONTOLOGYPROPERTY_UID = 57; // <OntologyProperty> ::= UID
    final int RULE_ONTOLOGYPROPERTY_UPFRACTION = 58; // <OntologyProperty> ::=
                                                     // UpFraction
    final int RULE_ONTOLOGYPROPERTY_DOWNFRACTION = 59; // <OntologyProperty> ::=
                                                       // DownFraction
    final int RULE_ONTOLOGYPROPERTY_DIRECTION = 60; // <OntologyProperty> ::=
                                                    // Direction
    final int RULE_ONTOLOGYPROPERTY_VALUATION = 61; // <OntologyProperty> ::=
                                                    // Valuation
    final int RULE_ONTOLOGYPROPERTY_FRACTION = 62; // <OntologyProperty> ::=
                                                   // Fraction

}