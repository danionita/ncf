package com.e3value.eval.ncf;

import org.apache.log4j.Logger;

import com.e3value.eval.ncf.ontology.start_stimulus;
import com.e3value.eval.ncf.ontology.value_interface;
import com.e3value.eval.ncf.ontology.value_transaction;

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

public class TraverseItem {

    static Logger log = Logger.getLogger(TraverseItem.class.getName());

    value_interface value_interface, source_value_interface;
    value_transaction source_value_transaction;
    start_stimulus source_start_stimulus;
    double f;

    public value_interface getValue_interface() {
        return value_interface;
    }

    public void setValue_interface(value_interface value_interface) {
        this.value_interface = value_interface;
    }

    public value_interface getSource_value_interface() {
        return source_value_interface;
    }

    public void setSource_value_interface(
            value_interface source_value_interface) {
        this.source_value_interface = source_value_interface;
    }

    public value_transaction getSource_value_transaction() {
        return source_value_transaction;
    }

    public void setSource_value_transaction(
            value_transaction source_value_transaction) {
        this.source_value_transaction = source_value_transaction;
    }

    public start_stimulus getSource_start_stimulus() {
        return source_start_stimulus;
    }

    public void setSource_start_stimulus(start_stimulus source_start_stimulus) {
        this.source_start_stimulus = source_start_stimulus;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    public boolean isDoSearchinward() {
        return doSearchinward;
    }

    public void setDoSearchinward(boolean doSearchinward) {
        this.doSearchinward = doSearchinward;
    }

    public boolean isUpdateTransaction() {
        return updateTransaction;
    }

    public void setUpdateTransaction(boolean updateTransaction) {
        this.updateTransaction = updateTransaction;
    }

    double fraction;
    boolean doSearchinward, updateTransaction;

    public TraverseItem(value_interface value_interface,
            value_interface source_value_interface,
            value_transaction source_value_transaction,
            start_stimulus source_start_stimulus, double f, double fraction,
            boolean doSearchinward, boolean updateTransaction) {
        this.value_interface = value_interface;
        this.source_value_interface = source_value_interface;
        this.source_value_transaction = source_value_transaction;
        this.source_start_stimulus = source_start_stimulus;
        this.f = f;
        this.fraction = fraction;
        this.doSearchinward = doSearchinward;
        this.updateTransaction = updateTransaction;
    }

}
