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

public interface SymbolConstants {
    static Logger log = Logger.getLogger(SymbolConstants.class.getName());

    final int SYMBOL_EOF = 0; // (EOF)
    final int SYMBOL_ERROR = 1; // (Error)
    final int SYMBOL_WHITESPACE = 2; // (Whitespace)
    final int SYMBOL_NUM = 3; // '#'
    final int SYMBOL_LPARAN = 4; // '('
    final int SYMBOL_RPARAN = 5; // ')'
    final int SYMBOL_DOT = 6; // '.'
    final int SYMBOL_LBRACE = 7; // '{'
    final int SYMBOL_RBRACE = 8; // '}'
    final int SYMBOL_ACTORHASVALUEINTERFACE = 9; // ActorHasValueInterface
    final int SYMBOL_ACTORINMARKETSEGMENT = 10; // ActorInMarketSegment
    final int SYMBOL_COMPOSITEACTOR = 11; // CompositeActor
    final int SYMBOL_COMPOSITEACTORCONSISTSOFVALUEINTERFACE = 12; // CompositeActorConsistsOfValueInterface
    final int SYMBOL_CONNECTIONELEMENT = 13; // ConnectionElement
    final int SYMBOL_CONNECTIONELEMENTHASDOWNDEPENDENCYELEMENT = 14; // ConnectionElementHasDownDependencyElement
    final int SYMBOL_CONNECTIONELEMENTHASUPDEPENDENCYELEMENT = 15; // ConnectionElementHasUpDependencyElement
    final int SYMBOL_DEPENDENCYELEMENT = 16; // DependencyElement
    final int SYMBOL_DEPENDENCYELEMENTWITHDOWNCONNECTIONELEMENT = 17; // DependencyElementWithDownConnectionElement
    final int SYMBOL_DEPENDENCYELEMENTWITHUPCONNECTIONELEMENT = 18; // DependencyElementWithUpConnectionElement
    final int SYMBOL_DIRECTION = 19; // Direction
    final int SYMBOL_DOWNFRACTION = 20; // DownFraction
    final int SYMBOL_E3 = 21; // 'e3'
    final int SYMBOL_ELEMENTARYACTOR = 22; // ElementaryActor
    final int SYMBOL_ELEMENTARYACTORPERFORMSVALUEACTIVITY = 23; // ElementaryActorPerformsValueActivity
    final int SYMBOL_FORMULA = 24; // Formula
    final int SYMBOL_FRACTION = 25; // Fraction
    final int SYMBOL_IDENTIFIER = 26; // Identifier
    final int SYMBOL_MARKETSEGMENT = 27; // MarketSegment
    final int SYMBOL_MARKETSEGMENTCONSISTSOFACTOR = 28; // MarketSegmentConsistsOfActor
    final int SYMBOL_MARKETSEGMENTHASVALUEINTERFACE = 29; // MarketSegmentHasValueInterface
    final int SYMBOL_MODEL = 30; // Model
    final int SYMBOL_NAME = 31; // Name
    final int SYMBOL_OBJECTID = 32; // ObjectId
    final int SYMBOL_OBJECTNAME = 33; // ObjectName
    final int SYMBOL_UID = 34; // UID
    final int SYMBOL_UPFRACTION = 35; // UpFraction
    final int SYMBOL_VALUATION = 36; // Valuation
    final int SYMBOL_VALUEACTIVITYHASVALUEINTERFACE = 37; // ValueActivityHasValueInterface
    final int SYMBOL_VALUEACTIVITYPERFORMEDBYELEMENTARYACTOR = 38; // ValueActivityPerformedByElementaryActor
    final int SYMBOL_VALUEINTERFACE = 39; // ValueInterface
    final int SYMBOL_VALUEINTERFACEASSIGNEDTOACTOR = 40; // ValueInterfaceAssignedToActor
    final int SYMBOL_VALUEINTERFACEASSIGNEDTOMARKETSEGMENT = 41; // ValueInterfaceAssignedToMarketSegment
    final int SYMBOL_VALUEINTERFACEASSIGNEDTOVALUEACTIVITY = 42; // ValueInterfaceAssignedToValueActivity
    final int SYMBOL_VALUEINTERFACECONSISTSOFOFFERING = 43; // ValueInterfaceConsistsOfOffering
    final int SYMBOL_VALUEOBJECT = 44; // ValueObject
    final int SYMBOL_VALUEOFFERINGCONSISTSOFVALUEPORT = 45; // ValueOfferingConsistsOfValuePort
    final int SYMBOL_VALUEOFFERINGINVALUEINTERFACE = 46; // ValueOfferingInValueInterface
    final int SYMBOL_VALUEPORTFIRSTCONNECTSTOVALUETRANSFER = 47; // ValuePortFirstConnectsToValueTransfer
    final int SYMBOL_VALUEPORTINCONNECTSTOVALUETRANSFER = 48; // ValuePortInConnectsToValueTransfer
    final int SYMBOL_VALUEPORTINVALUEOFFERING = 49; // ValuePortInValueOffering
    final int SYMBOL_VALUEPORTOUTCONNECTSTOVALUETRANSFER = 50; // ValuePortOutConnectsToValueTransfer
    final int SYMBOL_VALUEPORTREQUESTSOROFFERSVALUEOBJECT = 51; // ValuePortRequestsOrOffersValueObject
    final int SYMBOL_VALUEPORTSECONDCONNECTSTOVALUETRANSFER = 52; // ValuePortSecondConnectsToValueTransfer
    final int SYMBOL_VALUETRANSACTIONCONSISTSOFVALUETRANSFER = 53; // ValueTransactionConsistsOfValueTransfer
    final int SYMBOL_VALUETRANSFERHASFIRSTVALUEPORT = 54; // ValueTransferHasFirstValuePort
    final int SYMBOL_VALUETRANSFERHASINPORT = 55; // ValueTransferHasInPort
    final int SYMBOL_VALUETRANSFERHASOUTPORT = 56; // ValueTransferHasOutPort
    final int SYMBOL_VALUETRANSFERHASSECONDVALUEPORT = 57; // ValueTransferHasSecondValuePort
    final int SYMBOL_VALUETRANSFERINVALUETRANSACTION = 58; // ValueTransferInValueTransaction
    final int SYMBOL_ATTRIBUTEREFERENCE = 59; // <AttributeReference>
    final int SYMBOL_ONTOLOGYPROPERTY = 60; // <OntologyProperty>
    final int SYMBOL_SUBLEVELNAVIGATION = 61; // <SubLevelNavigation>
    final int SYMBOL_SUBLEVELNAVIGATIONFUNCTION = 62; // <SubLevelNavigationFunction>
    final int SYMBOL_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIER = 63; // <SubLevelNavigationFunctionIdentifier>
    final int SYMBOL_SUBLEVELNAVIGATIONFUNCTIONIDENTIFIERU = 64; // <SubLevelNavigationFunctionIdentifierU>
    final int SYMBOL_TOPLEVELNAVIGATION = 65; // <TopLevelNavigation>
    final int SYMBOL_TOPLEVELNAVIGATIONFUNCTION = 66; // <TopLevelNavigationFunction>
    final int SYMBOL_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIER = 67; // <TopLevelNavigationFunctionIdentifier>
    final int SYMBOL_TOPLEVELNAVIGATIONFUNCTIONIDENTIFIERU = 68; // <TopLevelNavigationFunctionIdentifierU>
}