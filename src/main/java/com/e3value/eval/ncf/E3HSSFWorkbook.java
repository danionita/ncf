package com.e3value.eval.ncf;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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

public class E3HSSFWorkbook {

    static Logger log = Logger.getLogger(E3HSSFWorkbook.class.getName());

    private HSSFWorkbook wb = null;
    private HSSFFont b = null;
    private HSSFFont d = null;
    private HSSFCellStyle w = null;
    private HSSFCellStyle h = null;

    public E3HSSFWorkbook() {

        wb = new HSSFWorkbook();

        b = wb.createFont();
        d = wb.createFont();
        w = wb.createCellStyle();
        h = wb.createCellStyle();

        b.setFontHeightInPoints((short) 10);
        b.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        w.setWrapText(true);
        w.setFont(d);

        h.setFont(b);
    }

    public void formatE3Sheet(HSSFSheet S) {

        // set cellpadding on all cells
        HSSFCellStyle wrap = getWrapStyle();

        for (int r = 0; r < S.getPhysicalNumberOfRows(); r++) {
            HSSFRow R = S.getRow(r);
            if (R != null) {

                for (int c = R.getFirstCellNum(); c <= R
                        .getLastCellNum(); c++) {
                    HSSFCell C = R.getCell(c);
                    if (C != null) {
                    }
                }
            }
        }

        try {
            S.setColumnWidth((short) 0, (short) 6000);
            S.setColumnWidth((short) 1, (short) 4500);
            S.setColumnWidth((short) 2, (short) 4500);
            S.setColumnWidth((short) 3, (short) 4500);
            S.setColumnWidth((short) 4, (short) 4500);
            S.setColumnWidth((short) 5, (short) 4500);

            // make font of top row bold
            HSSFRow R = S.getRow(0);
            if (R != null) {
                R.setHeight((short) 0x349);
                for (int c = R.getFirstCellNum(); c <= R
                        .getLastCellNum(); c++) {
                    HSSFCell C = R.getCell(c);
                    if (C != null) {
                        C.setCellStyle(getHeaderStyle());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HSSFCellStyle getHeaderStyle() {
        return h;
    }

    public HSSFCellStyle getWrapStyle() {
        w.setWrapText(true);
        return w;
    }

    public HSSFFont getDefaultFont() {
        return d;
    }

    public HSSFFont getBoldFont() {
        return b;
    }

    public HSSFSheet getSheet(String name) {
        if (wb != null) {
            return wb.getSheet(name);
        }
        return null;
    }

    public HSSFWorkbook getWorkbook() {
        return wb;
    }

    public HSSFSheet createSheet(String name) {
        if (wb != null) {
            return wb.createSheet(name);
        }
        return null;
    }

    public void write(FileOutputStream out) {
        if (wb != null) {
            try {
                wb.write(out);
            } catch (IOException e) {
            }
        }
        return;
    }

}
