package com.e3value.eval.ncf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.e3value.eval.ncf.ontology.actor;
import com.e3value.eval.ncf.ontology.composite_actor;
import com.e3value.eval.ncf.ontology.connection_element;
import com.e3value.eval.ncf.ontology.dependency_element;
import com.e3value.eval.ncf.ontology.e3value_AND;
import com.e3value.eval.ncf.ontology.e3value_OR;
import com.e3value.eval.ncf.ontology.e3value_object;
import com.e3value.eval.ncf.ontology.elementary_actor;
import com.e3value.eval.ncf.ontology.end_stimulus;
import com.e3value.eval.ncf.ontology.market_segment;
import com.e3value.eval.ncf.ontology.model;
import com.e3value.eval.ncf.ontology.model_concept;
import com.e3value.eval.ncf.ontology.start_stimulus;
import com.e3value.eval.ncf.ontology.value_activity;
import com.e3value.eval.ncf.ontology.value_exchange;
import com.e3value.eval.ncf.ontology.value_interface;
import com.e3value.eval.ncf.ontology.value_object;
import com.e3value.eval.ncf.ontology.value_offering;
import com.e3value.eval.ncf.ontology.value_port;
import com.e3value.eval.ncf.ontology.value_transaction;

import de.dfki.rdf.util.RDFImport;
import goldengine.java.GOLDParser;

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

/**
 * Offers functionalites required to export objects from the GUI (E3Diagram and
 * it's content) to <br />
 * <br />
 * - an RDF representation (using RDF2JAVA API)<br />
 * - profitability sheets (MS Excel '98 format), using the Jakarta POI HSSF
 * API<br />
 * <br />
 * An new instance of this class is created upon each export, It is disposed of
 * after the process is completed.
 *
 * @author Stephan Hoekstra
 */

public class ProfGenerator {

    static Logger log = Logger.getLogger(ProfGenerator.class.getName());

    public int indent = 0;
    public static final int EXIT_INOUT = 0;
    public static final int EXIT_1st2nd = 1;
    public static final int EXIT_DOWNCE = 2;
    public static final int EXIT_UNKNOWN = 3;
    public static final int FirstSecondConnected = -1;
    public static final int InOutConnected = 1;
    public static final int any = 0;
    // for timeseries
    private Vector lastindex;
    private int exists;
    // end for timeseries

    private HashSet<String> sheetnames = null; // contains the issued sheet
                                               // names

    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(ProfGenerator.class.getClassLoader().getResourceAsStream("log4j.properties"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PropertyConfigurator.configure(props);

        CommandLineParser parser = new DefaultParser();

        String filename = null;

        try {

            Options options = new Options();
            options.addOption("i", "interactive", false, "interactive mode");
            options.addOption("f", "file", true, "input rdf file");
            options.addOption("h", "help", false, "show help");
            options.addOption("l", "log", false, "extensive logging");
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);

            if (line.hasOption("interactive") && !line.hasOption("file")) {
                if (line.hasOption("log")) {
                    RDF2Excel(true, "", true);
                } else {
                    RDF2Excel(true, "", false);
                }
            } else {

                if (line.hasOption("file") && !line.hasOption("interactive")) {
                    // initialise the member variable
                    filename = line.getOptionValue("file");
                    if (line.hasOption("log")) {
                        RDF2Excel(false, filename, true);
                    } else {
                        RDF2Excel(false, filename, false);
                    }

                } else {
                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp("rdf2excel", options);
                }
            }

        } catch (ParseException exp) {
            // oops, something went wrong
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
            System.exit(1);
        }

        System.exit(0);
    }

    public static void RDF2Excel(Boolean ui, String filename, Boolean logging) {

        String destinationFileName = "";

        try {

            String fn = null;

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            if (ui) {
                ;
                JFileChooser fc = new JFileChooser();
                FileFilter rdfFilter = new RDFSFilter();
                fc.setFileFilter(rdfFilter);
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    fn = file.getAbsolutePath();
                } else {
                    System.out.println("Aborted by user");
                    System.exit(0);
                }
            } else {
                fn = filename;
            }

            ProfGenerator p = new ProfGenerator();
            p.loadRDFFile(fn);

            // assign main 'mymodel' - used to fetch object references from
            Iterator i = p.getMapObjects().values().iterator();
            int found_models = 0;
            while (i.hasNext()) {
                Object o = i.next();
                if (o instanceof model) {
                    found_models++;
                    if (found_models > 1) {
                        throw new E3ParseException(
                                "RDF file should contain exactly one 'model'");
                    }
                    p.setMymodel((model) o);
                }

            }

            destinationFileName = fn.substring(0, fn.length() - 4) + ".xls";
            p.storeXLS(destinationFileName, true, true, true, true, true, true,
                    true, true, true, true, logging);

        } catch (Throwable t) {
            if (ui) {
                JOptionPane.showMessageDialog(null, "", t.getMessage(),
                        JOptionPane.ERROR_MESSAGE);
            }
            System.err.println(t);
            t.printStackTrace();
            System.exit(1);
        }
        if (ui) {
            JOptionPane.showMessageDialog(null, "",
                    "profitability sheets successfully created:\n"
                            + destinationFileName,
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        System.out.println("Profitability sheets successfully created: "
                + destinationFileName);
    }

    public void setMapObjects(Map mapObjects) {
        mapObjects = mapObjects;
    }

    public Map getMapObjects() {
        return mapObjects;
    }

    private Map mapObjects;
    private Vector jumphistory = new Vector();
    private Vector traversecalculatehistory = new Vector();

    public void setMymodel(model mymodel) {
        this.mymodel = mymodel;
    }

    private model mymodel = null;
    StringBuffer userlog = new StringBuffer();
    StringBuffer valuationlog = new StringBuffer();

    /**
     * Creates a new instance of the ProfGenerator class for exporting a given
     * E3tor_diagram instance and it's content.
     *
     */

    public ProfGenerator() {
    }

    public void loadRDFFile(String fileName) throws E3ParseException {
        loadRDFFile(fileName, Globals.E3_NAMESPACE);
    }

    /**
     * initialises the OntologyExport class - creates instances of 'ontology'
     * classes and assigns attributes and references for each instances. <br />
     * This process includes recursively traversing connection elements and
     * dependency elements in order to detect scenario paths and connect theses
     * elements through references. //@exception
     * cs.vu.nl.gordijn.e3value.editor.export.E3ParseException throws an
     * E3ParseException in the event exceptions occur or errors are detected
     * during initialisation.
     */
    public void loadRDFFile(String fileName, String nameSpace)
            throws E3ParseException {
        try {
            Map mapPackage2Namespace = new HashMap();
            mapPackage2Namespace.put(nameSpace, Globals.E3_ONTOLOGY_PACKAGE);
            RDFImport rdfImport = new RDFImport(mapPackage2Namespace);
            mapObjects = rdfImport.importObjects(fileName);

            // find model
            Iterator i = mapObjects.values().iterator();
            while (i.hasNext()) {
                Object o = i.next();
                if (o instanceof com.e3value.eval.ncf.ontology.model) {
                    setMymodel((com.e3value.eval.ncf.ontology.model) o);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadRDFStream(InputStream stream) throws E3ParseException {
        loadRDFStream(stream, Globals.E3_NAMESPACE);
    }

    public void loadRDFStream(InputStream stream, String nameSpace)
            throws E3ParseException {
        try {
            InputStreamReader r = new InputStreamReader(stream);
            Map mapPackage2Namespace = new HashMap();
            mapPackage2Namespace.put(nameSpace, Globals.E3_ONTOLOGY_PACKAGE);
            RDFImport rdfImport = new RDFImport(mapPackage2Namespace);
            mapObjects = rdfImport.importObjects(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * initialises the OntologyExport class - creates instances of 'ontology'
     * classes and assigns attributes and references for each instances. <br />
     * This process includes recursively traversing connection elements and
     * dependency elements in order to detect scenario paths and connect theses
     * elements through references. // * @exception
     * cs.vu.nl.gordijn.e3value.editor.export.E3ParseException throws an
     * E3ParseException in the event exceptions occur or errors are detected
     * during initialisation.
     *
     * @return Map returns a Map containing all 'ontology' class (to which
     *         corresponding attributes have already been assigned) instances
     */

    // begin timeseries
    public void merge(Vector xlsVector) throws Exception {
        try {

            for (int i = 0; i < xlsVector.size(); i++) {
                System.out.println(xlsVector.get(i).toString());

            }

        } catch (Exception e) {
        }
    }
    // end timeseries

    /**
     * starts process of generating a profitability sheet, and when this process
     * is finished outputs to an Excel file.<br />
     * includes recursive scenariopath traversation and propagation of
     * occurences aswell as creation of the profitability sheet. //@throws
     * cs.vu.nl.gordijn.e3value.editor.export.E3ParseException an exception is
     * thrown when errors are detected or the mymodel does not confim to certain
     * modeling requirements //@throws goldengine.Java.ParserException an
     * exception is thrown when errors occur during formula parsing.
     */

    // begin timeseries
    E3HSSFWorkbook wb1;
    // end timeseries
    E3HSSFWorkbook wb;

    public void storeXLS(String filename, boolean viValueObjects,
            boolean viName, boolean vpValueObject, boolean vpDirection,
            boolean vpName,

            boolean vtName, boolean vtValueObject,

            boolean GenActor, boolean GenValueActivity, boolean GenPerConstruct,
            boolean batch) throws Exception {

        log.info("----> Begin exporting model to Excel");

        sheetnames = new HashSet();

        indent = 0;
        StringBuffer xlslog = new StringBuffer();
        wb = new E3HSSFWorkbook();
        // begin timeseries
        wb1 = new E3HSSFWorkbook();
        // end timeseries

        /*
         * WORKSHEET PER CONSTRUCT - collect items
         * ********************************************************** Dus per
         * value object, port, exchange, etc. These worksheets contain per
         * instance the formulas
         ***************************************************************************************************/

        try {

            if (mapObjects != null) {

                Collection c = new HashSet();
                c.addAll(mapObjects.values());
                Iterator i = c.iterator();

                // find namespace of instances inside the model

                String instances_namespace = "";
                i = c.iterator();
                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    if (object instanceof model) {
                        String s = object.getNamespace();
                        instances_namespace = s;
                    }
                }
                if (instances_namespace.equals("")) {
                    throw new E3ParseException("No model found in " + filename);
                }

                // check integrity of formulas
                log.info("----> Begin checking integrity formulas");
                ProfGenerator.validateNumbers(mapObjects);

                // first parse all formulas
                GOLDParser parser = new GOLDParser();

                URL url = null;
                try {
                    url = ProfGenerator.class.getResource("formula.cgt");

                    InputStream is = url.openStream();
                    File tempFile = File.createTempFile("formula", "cgt");
                    FileOutputStream fis = new FileOutputStream(tempFile);

                    int b;
                    while ((b = is.read()) != -1) {
                        fis.write(b);
                    }
                    fis.flush();
                    fis.close();
                    is.close();
                    parser.loadCompiledGrammar(tempFile.getAbsolutePath());

                } catch (Exception e) {
                    e.printStackTrace();
                    throw new E3ParseException("formula.cgt not found " + url);
                }

                parseFormulas(filename, parser);

                log.info("----> End checking integrity formulas");

                log.info(
                        "----> Begin checking if connected ports have the same value object and value transactions have transfers of the same type (in/out or first/second)");
                i = mapObjects.values().iterator();
                while (i.hasNext()) {
                    Object object = i.next();
                    if (object instanceof value_exchange) {
                        value_exchange ve = (value_exchange) object;
                        if (!ve.connectsPortsWithEqualValueObject()) {
                            throw new E3ParseException("Error: value exchange "
                                    + ve.getE3_has_name()
                                    + " should have the same value object on each end");
                        }
                    }
                    if (object instanceof value_transaction) {
                        value_transaction value_transaction = (value_transaction) object;

                        Collection exchanges = value_transaction
                                .getVt_consists_of_ve();
                        i = exchanges.iterator();
                        int type = 0; // 0 = undecided, 1 = inout, -1
                                      // =firstsecond
                        while (i.hasNext()) {
                            value_exchange ve = (value_exchange) i.next();
                            if (ve.fetchFirstSecondType()) {
                                if (type == 0) {
                                    type = -1;
                                } else if (type == 1) {
                                    throw new E3ParseException(
                                            "Value transaction"
                                                    + value_transaction
                                                            .getE3_has_name()
                                                    + "should contain either \"First / Second\"-connected exchanges, or \"in /out\"-connected ones.");
                                }
                            } else if (ve.fetchInOutType()) {
                                if (type == 0) {
                                    type = 1;
                                } else if (type == -1) {
                                    throw new E3ParseException(
                                            "Value transaction"
                                                    + value_transaction
                                                            .getE3_has_name()
                                                    + "should contain either \"First / Second\"-connected exchanges, or \"in /out\"-connected ones.");
                                }
                            }
                        }
                    }
                }

                log.info(
                        "----> End checking if connected ports have the same value object and value transactions have transfers of the same type (in/out or first/second)");

                log.info(
                        "----> Begin travering scenario paths to calculate occurrences for each element");

                i = c.iterator();
                int countstartstimuli = 0;

                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    if (object instanceof start_stimulus) {
                        start_stimulus start_stimulus = (start_stimulus) object;
                        indent = 0;
                        if (!traversecalculatehistory
                                .contains(start_stimulus)) {
                            try {
                                int int_occurrence = Integer
                                        .parseInt(start_stimulus
                                                .fetchFormula("OCCURRENCES"));
                                double occurences = 0.0 + int_occurrence;
                                log.debug("Start at start_stimulus ("
                                        + start_stimulus.getE3_has_uid() + ") "
                                        + start_stimulus.getE3_has_name());
                                if (!traverseCalculateDE(start_stimulus,
                                        start_stimulus, null,
                                        0.0 + occurences)) {
                                    throw new E3ParseException(
                                            "cannot find end-stimulus when calculating path (starting at "
                                                    + start_stimulus
                                                            .getE3_has_name()
                                                    + ")");
                                } else {
                                    countstartstimuli++;
                                }
                            } catch (NumberFormatException e) {
                                throw new E3ParseException(
                                        "the 'OCCURRENCES' formula of '"
                                                + start_stimulus
                                                        .getE3_has_name()
                                                + "' is not a valid Integer");
                            }
                        } else {
                            throw new E3ParseException(
                                    start_stimulus.getClass().getName() + " "
                                            + start_stimulus.getE3_has_uid()
                                            + " is involved in a loop!");
                        }
                    }
                }
                log.info(
                        "----> End travering scenario paths to calculate occurrences for each element");

                log.info(
                        "----> Begin testing if ports are involved in transactions");

                i = c.iterator();
                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    if (object instanceof value_transaction) {
                        value_transaction vt = (value_transaction) object;
                        vt.verifyConnections();
                    }
                }
                log.info(
                        "----> End testing if ports are involved in transactions");

                log.info("----> Begin setting build-in formulas");
                i = c.iterator();
                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    if (object instanceof value_port) {
                        value_port vp = (value_port) object;
                        if (vp.fetchExpression("NORM_VALUE") != null) {
                            throw new E3ParseException(
                                    "The formula \"NORM_VALUE\" on value port \""
                                            + vp.getE3_has_name()
                                            + "\" is not allowed because it is a reserved formula name.");
                        }
                        vp.putE3_has_formula("NORM_VALUE=0");
                        if (vp.fetchExpression("NORM_CARD") != null) {
                            throw new E3ParseException(
                                    "The formula \"NORM_CARD\" on value port \""
                                            + vp.getE3_has_name()
                                            + "\" is not allowed because it is a reserved formula name.");
                        }
                        vp.putE3_has_formula("NORM_CARD=0");
                    }
                    if (object instanceof value_activity) {
                        value_activity va = (value_activity) object;
                        if (va.fetchExpression(
                                "TOTAL_VARIABLE_EXPENSES") != null) {
                            throw new E3ParseException(
                                    "The formula \"TOTAL_VARIABLE_EXPENSES\" on value activity \""
                                            + va.getE3_has_name()
                                            + "\" is not allowed because it is a reserved formula name.");
                        }
                        va.putE3_has_formula("TOTAL_VARIABLE_EXPENSES=0");
                    }
                }
                log.info("----> End setting build-in formulas");

                log.info(
                        "----> Begin checking if a transfer connects two ports");
                // test if all each exchange is connected
                // to two ports that have the same value object
                i = c.iterator();
                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    if (object instanceof value_exchange) {
                        value_exchange ve = (value_exchange) object;
                        if (!ve.connectsPortsWithEqualValueObject()) {
                            throw new E3ParseException(
                                    "both ports connected by value exchange '"
                                            + ve.getE3_has_name()
                                            + "' should have the same value object");
                        }
                    }
                }
                log.info("----> End checking if a transfer connects two ports");

                // test and-merges
                log.info(
                        "----> Reporting on the number of occurrences for element and check for merge errors at interfaces and AND-joins");
                i = c.iterator();
                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    object.fetchScenarioUsage().printout();
                    if (object instanceof value_interface) {
                        ((value_interface) object).printAdministration();
                        if (!((value_interface) object)
                                .verifyAdministration(mapObjects)) {
                            throw new E3ParseException("Value interface "
                                    + object.getE3_has_uid()
                                    + " OCCURRENCES-Merge error "
                                    + ((value_interface) object)
                                            .fetchAdministrationString());
                        }
                    } else if (object instanceof e3value_AND) {
                        ((e3value_AND) object).printAdministration();
                        if (!((e3value_AND) object).verifyAdministration()) {
                            throw new E3ParseException("AND "
                                    + object.getE3_has_uid()
                                    + " OCCURRENCES-Merge error "
                                    + ((e3value_AND) object)
                                            .fetchAdministationString());
                        }
                    }
                }
                log.info(
                        "---> End reporting on the number of occurrences for each element and check for merge errors at interfaces and AND-joins");

                log.info(
                        "---> Reporting on value interfaces with one port or less");
                // Raise a warning for interfaces having one port or less
                i = c.iterator();
                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    if (object instanceof value_interface) {
                        value_interface vi = (value_interface) object;
                        // check if this value interface has an in and out
                        // offering

                        Collection offerings = vi.getVi_consists_of_of();
                        Iterator i_off = offerings.iterator();
                        int reciprocal = 0;
                        while (i_off.hasNext()) {
                            value_offering off = (value_offering) i_off.next();
                            if (off.getVo_consists_of_vp().size() >= 1) {
                                reciprocal++;
                            }
                        }

                        if (reciprocal < 2) {
                            log.error("Missing offering(s): "
                                    + "Value interface " + vi.getE3_has_uid()
                                    + ", " + vi.getE3_has_name()
                                    + " has no reciprocal value offering or no offerings at all");
                        }
                    }
                }

                log.info(
                        "----> End reporting on value interfaces with one port or less");

                // ArrayList sheet_l = new ArrayList();
                HashMap constructs_map = new HashMap();

                i = c.iterator();
                int countsheets = 0;

                log.info("----> Start writing formula sheets");

                // begin timeseries
                makeFormulaSheet(wb1, mapObjects, instances_namespace,
                        countsheets, xlslog);
                // end timeseries

                countsheets++;

                log.debug("STEP 2: Assign normalised functions");
                assignNormalisedFunctionsValuation();
                assignNormalisedFunctionsCardinality();

                // re-parse to include newly added VALUE formulas
                log.debug("STEP 3: Reparse newly added normalized functions");
                parseFormulas(filename, parser);

                // update the formulasheet
                log.debug("STEP 4: Writing updated formula sheets");
                i = c.iterator();
                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    if (object instanceof value_port) {
                        value_port vp = (value_port) object;
                        vp.generateNormCells("NORM_VALUE", wb1,
                                instances_namespace, mapObjects);
                        vp.generateNormCells("NORM_CARD", wb1,
                                instances_namespace, mapObjects);

                    }
                }

                log.debug(
                        "STEP 5: Assign total variable expense functions for value activities");
                assignTotalVariableExpensesValueActivity();

                // re-parse to include newly added VALUE formulas
                log.debug(
                        "STEP 6: Reparse newly added variable expense functions");
                parseFormulas(filename, parser);

                log.debug("STEP 7: Writing updated formula sheets");
                i = c.iterator();
                while (i.hasNext()) {
                    e3value_object object = (e3value_object) i.next();
                    if (object instanceof value_activity) {
                        value_activity va = (value_activity) object;
                        va.generateExpCells("TOTAL_VARIABLE_EXPENSES", wb1,
                                instances_namespace, mapObjects);
                    }
                }

                log.debug(
                        "STEP 8: Writing worksheets for each ontology construct");

                i = c.iterator();

                while (i.hasNext()) {
                    e3value_object o = (e3value_object) i.next();

                    String o_naam = o.getE3_has_name();
                    String o_class = o.getClass().getName().substring(
                            o.getClass().getPackage().getName().length() + 1,
                            o.getClass().getName().length());

                    ArrayList construct_instances_c = (ArrayList) constructs_map
                            .get(o_class);
                    if (construct_instances_c == null) {
                        // make new construct_sheet_instances_c and put it in
                        // the collection. put the collection in the map
                        ArrayList new_construct_instances_c = new ArrayList();
                        new_construct_instances_c.add(o);
                        constructs_map.put(o_class, new_construct_instances_c);
                    } else {
                        construct_instances_c.add(o);
                    }
                }

                /*
                 * WORKSHEET PER CONSTRUCT - convert collected items to
                 * worksheets and add them to the workbook
                 */

                Set keys = constructs_map.keySet();
                Iterator keys_i = keys.iterator();

                if (GenPerConstruct) {
                    while (keys_i.hasNext()) {
                        String key = keys_i.next() + "";
                        Collection instances = (Collection) constructs_map
                                .get(key);

                        HSSFSheet newSheet = createSheet(wb1, key);

                        xlslog.append("\n-- Worksheet \"" + key
                                + "\"--------------\n");
                        Collection labels = new Vector();

                        int rows = 0;
                        int cell = 0;

                        HSSFRow R = newSheet.createRow(rows);
                        HSSFCell C = null;

                        C = R.createCell(cell);

                        C.setCellValue(key);
                        xlslog.append(key + " (" + cell + "," + rows + ") ");
                        cell++;

                        rows++;
                        cell = 0;

                        Iterator i_i = instances.iterator();

                        while (i_i.hasNext()) {
                            // add tracking information

                            e3value_object o = (e3value_object) i_i.next();
                            Collection attributes = new Vector();
                            Map CellTrackerMap = o.fetchCellTrackerMap();
                            Collection keySet = CellTrackerMap.keySet();

                            Iterator iter_keySet = keySet.iterator();
                            while (iter_keySet.hasNext()) {
                                String mapkey = iter_keySet.next().toString();
                                String left_hand = mapkey;
                                CellTracker ct = (CellTracker) CellTrackerMap
                                        .get(mapkey);
                                String ref_xpos = convertToXLSCol(ct.getCol());
                                String ref_ypos = convertToXLSRow(ct.getRow());
                                String ref_sheetname = ct.getSheetName();

                                R = newSheet.createRow(rows);
                                C = R.createCell(cell);
                                C.setCellValue(left_hand);
                                xlslog.append(
                                        key + " (" + cell + "," + rows + ") ");
                                cell++;

                                String reference = ref_sheetname + "!"
                                        + ref_xpos + ref_ypos;
                                C = R.createCell(cell);
                                C.setCellFormula(reference);
                                xlslog.append("'" + left_hand + "'" + " ("
                                        + cell + "," + rows + ") ");
                                rows++;
                                cell = 0;

                            }
                            rows++;

                        }

                        // new timeseries
                        wb1.formatE3Sheet(newSheet);
                        // end timeseries

                    }
                }

                ////////////////////////
                // sheets per actor //
                //////////////////////

                // prevent duplicate sheet names
                Map usedsheetnames = new HashMap();

                // begin timeseries
                String sheetname = null;
                // end timeseries

                keys_i = keys.iterator();
                while (keys_i.hasNext()) {
                    String key = keys_i.next() + "";
                    if (key.equals("elementary_actor")
                            || key.equals("composite_actor")
                            || key.equals("market_segment")
                            || key.equals("value_activity")) {
                        Collection instances = (Collection) constructs_map
                                .get(key);
                        Iterator i_i = instances.iterator();

                        // begin timeseries
                        String z = "actor_";
                        String x = "activity_";
                        String w = "ms_";
                        // end timeseries

                        while (i_i.hasNext()) {
                            Iterator iter_value_interfaces = null;

                            // begin timeseries
                            Iterator iter_value_activity = null;
                            // end timeseries

                            Vector vi_totals_rownumbers = null;

                            // begin timeseries
                            CellTracker value_inves = null;
                            CellTracker value_exp = null;
                            // end timeseries

                            market_segment m = null;
                            boolean createsheet = false;

                            // begin timeseries
                            boolean elementary_actor_found = false;
                            boolean market_segment_found = false;
                            // end timeseries

                            if (key.equals("elementary_actor")
                                    || key.equals("composite_actor")) {
                                actor a = (actor) i_i.next();
                                sheetname = z + a.getE3_has_name();
                                // end timeseries

                                xlslog.append("\n-- Worksheet \"" + key + " "
                                        + a.getE3_has_name()
                                        + "\"--------------\n");
                                Collection value_interfaces = a.getAc_has_vi();

                                // begin timeseries
                                value_inves = a.fetchCellTracker("INVESTMENT");
                                value_exp = a.fetchCellTracker("EXPENSES");
                                // end timeseries

                                iter_value_interfaces = value_interfaces
                                        .iterator();
                                vi_totals_rownumbers = new Vector();
                                createsheet = GenActor;

                                // begin timeseries
                                if (key.equals("elementary_actor")) {
                                    elementary_actor_found = true;

                                    elementary_actor ea = (elementary_actor) a;
                                    Collection v_a = ea.getEl_performs_va();
                                    iter_value_activity = v_a.iterator();

                                }

                                // end timeseries

                                // createsheet = false;
                            } else if (key.equals("value_activity")) {
                                value_activity a = (value_activity) i_i.next();
                                String performer;
                                if (a.GetVa_performed_by_ms() != null) {
                                    performer = a.GetVa_performed_by_ms()
                                            .getE3_has_name();
                                } else {
                                    if (a.GetVa_performed_by_el() != null) {
                                        performer = a.GetVa_performed_by_el()
                                                .getE3_has_name();
                                    } else {
                                        performer = new String("unknown");
                                    }
                                }

                                sheetname = x + a.getE3_has_name() + "_"
                                        + performer;

                                xlslog.append("\n-- Worksheet \"" + key + " "
                                        + a.getE3_has_name()
                                        + "\"--------------\n");
                                Collection value_interfaces = a.getVa_has_vi();

                                // begin time series
                                value_inves = a.fetchCellTracker("INVESTMENT");
                                value_exp = a.fetchCellTracker("EXPENSES");
                                // end timeseries

                                iter_value_interfaces = value_interfaces
                                        .iterator();
                                vi_totals_rownumbers = new Vector();

                                createsheet = GenValueActivity;

                            } else if (key.equals("market_segment")) {
                                m = (market_segment) i_i.next();

                                // begin timeseries
                                sheetname = w + m.getE3_has_name();
                                Collection v_a = m.getMs_performs_va();
                                iter_value_activity = v_a.iterator();
                                // end timeseries

                                xlslog.append("\n-- Worksheet \"" + key + " "
                                        + m.getE3_has_name()
                                        + "\"--------------\n");
                                Collection value_interfaces = m.getMs_has_vi();

                                // begin timeseries
                                value_inves = m.fetchCellTracker("INVESTMENT");
                                value_exp = m.fetchCellTracker("EXPENSES");
                                // end timeseries

                                iter_value_interfaces = value_interfaces
                                        .iterator();
                                vi_totals_rownumbers = new Vector();
                                createsheet = GenActor;

                                // begin timeseries
                                market_segment_found = true;
                                // end timeseries
                            }

                            if (createsheet) {
                                if (sheetname.length() >= 31) {
                                    sheetname = sheetname.substring(0, 27)
                                            + "...";
                                }
                                String original_sheetname = sheetname;

                                // prevent duplicate sheet names
                                Integer sheet_I = ((Integer) usedsheetnames
                                        .get(sheetname));
                                int sheet_i = 1;
                                if (sheet_I != null) {
                                    sheet_i = sheet_I.intValue() + 1;
                                }
                                if (sheet_i != 1) {
                                    sheetname = sheetname.substring(0,
                                            sheetname.length() - 3) + "("
                                            + sheet_i + ")";
                                }
                                usedsheetnames.remove(original_sheetname);
                                usedsheetnames.put(original_sheetname,
                                        new Integer(sheet_i));

                                // begin timeseries
                                HSSFSheet newSheetMerge = createSheet(wb1,
                                        sheetname);
                                // end timeseries

                                int rows = 0;
                                int cell = 0;

                                // begin timeseries
                                HSSFRow R = newSheetMerge.createRow(rows);
                                // end timeseries

                                HSSFCell C = R.createCell(cell);

                                C.setCellValue("Value Interface");

                                cell++;

                                C = R.createCell(cell);
                                C.setCellValue("Value Port");

                                cell++;
                                C = R.createCell(cell);
                                C.setCellValue("Value Transfer");

                                cell++;
                                C = R.createCell(cell);
                                C.setCellValue("Occurrences");

                                cell++;
                                C = R.createCell(cell);
                                C.setCellValue("Valuation");

                                cell++;
                                C = R.createCell(cell);
                                C.setCellValue("Economic Value");

                                // begin timeseries

                                cell++;
                                C = R.createCell(cell);
                                C.setCellValue("Total");

                                // end timeseries

                                rows++;
                                cell = 0;

                                while (iter_value_interfaces.hasNext()) {
                                    int vi_total_row = rows;
                                    vi_totals_rownumbers
                                            .add(new Integer(vi_total_row));

                                    value_interface vi = (value_interface) iter_value_interfaces
                                            .next();

                                    // skip value interfaces without occurrences
                                    // / connections...
                                    boolean treat_value_interface = true;
                                    try {
                                        ScenarioUsage u = vi
                                                .fetchScenarioUsage();
                                        Double d = u.getTotalOccurences();
                                        if (d == null) {
                                            treat_value_interface = false;
                                        }
                                    } catch (Exception e) {
                                        treat_value_interface = false;
                                    }

                                    if (treat_value_interface) {

                                        // begin timeseries
                                        R = newSheetMerge.createRow(rows);
                                        // end timeseries

                                        C = R.createCell(cell);
                                        String viNameString = "";
                                        if (viName) {
                                            if (vi.getE3_has_name() != null
                                                    && !vi.getE3_has_name()
                                                            .equals("")) {
                                                viNameString = vi
                                                        .getE3_has_name();
                                            } else {
                                                viNameString = "unknown";
                                            }
                                        }

                                        if (viValueObjects) {
                                            String viValueObjectsString = "{";
                                            Boolean first = true;

                                            Collection vOs = vi
                                                    .getVi_consists_of_of();
                                            Iterator iter_value_offerings = vOs
                                                    .iterator();
                                            while (iter_value_offerings
                                                    .hasNext()) {
                                                value_offering vO = (value_offering) iter_value_offerings
                                                        .next();
                                                Collection vPs = vO
                                                        .getVo_consists_of_vp();
                                                Iterator iter_value_ports = vPs
                                                        .iterator();
                                                while (iter_value_ports
                                                        .hasNext()) {
                                                    value_port vP = (value_port) iter_value_ports
                                                            .next();
                                                    value_object vOb = vP
                                                            .GetVp_requests_offers_vo();
                                                    if (!first) {
                                                        viValueObjectsString += ",";
                                                    }
                                                    if (vOb != null && !vOb
                                                            .getE3_has_name()
                                                            .equals("")) {
                                                        viValueObjectsString += vOb
                                                                .getE3_has_name();
                                                    } else {
                                                        viValueObjectsString += "unknown";
                                                    }
                                                    first = false;
                                                }
                                            }
                                            viValueObjectsString += "}";
                                            if (viNameString.equals("")) {
                                                viNameString = viValueObjectsString;
                                            } else {
                                                viNameString += ":"
                                                        + viValueObjectsString;
                                            }
                                        }

                                        if (viNameString.equals("")) {
                                            viNameString = "unknown";
                                        }

                                        C.setCellValue(viNameString);

                                        xlslog.append("'" + vi.getE3_has_name()
                                                + "' (" + (cell) + "," + rows
                                                + ") ");

                                        rows++;
                                        cell++;

                                        Collection value_offerings = vi
                                                .getVi_consists_of_of();
                                        Iterator iter_value_offerings = value_offerings
                                                .iterator();
                                        int vp_rowswritten = 0;
                                        int exp_rowswritten = 0;
                                        int total_exp_rowswritten = 0;
                                        while (iter_value_offerings.hasNext()) {
                                            value_offering vo = (value_offering) iter_value_offerings
                                                    .next();
                                            Collection value_ports = vo
                                                    .getVo_consists_of_vp();
                                            Iterator iter_value_ports = value_ports
                                                    .iterator();
                                            while (iter_value_ports.hasNext()) {
                                                value_port vp = (value_port) iter_value_ports
                                                        .next();

                                                // begin timeseries
                                                vp_rowswritten = vp
                                                        .writeValuationToWorkSheet(
                                                                newSheetMerge,
                                                                vpValueObject,
                                                                vpDirection,
                                                                vpName, vtName,
                                                                vtValueObject,
                                                                cell, rows,
                                                                xlslog);
                                                // end timeseries

                                                rows = (rows + vp_rowswritten);

                                                // addition to have expenses for
                                                // ports
                                                exp_rowswritten = vp
                                                        .writeExpensesToWorkSheet(
                                                                newSheetMerge,
                                                                vpValueObject,
                                                                vpDirection,
                                                                vpName, vtName,
                                                                vtValueObject,
                                                                cell, rows,
                                                                xlslog);
                                                total_exp_rowswritten += exp_rowswritten;
                                                rows = rows + exp_rowswritten;

                                            }
                                        }
                                        cell--;

                                        // totals

                                        // begin timeseries
                                        R = newSheetMerge
                                                .createRow(vi_total_row);
                                        // end timeseries

                                        C = R.createCell(1);
                                        C.setCellValue("");

                                        C = R.createCell(3);

                                        int myPorts = vi.countPorts();
                                        if (rows - vi_total_row != 0) {
                                            C.setCellFormula("SUM("
                                                    + convertToXLSCol(3)
                                                    + convertToXLSRow(
                                                            vi_total_row + 1)
                                                    + ":" + convertToXLSCol(3)
                                                    + convertToXLSRow(rows - 1)
                                                    + ")/" + (myPorts
                                                            + total_exp_rowswritten));
                                        }

                                        C = R.createCell(5);

                                        C.setCellFormula("SUM("
                                                + convertToXLSCol(5)
                                                + convertToXLSRow(
                                                        vi_total_row + 1)
                                                + ":" + convertToXLSCol(5)
                                                + convertToXLSRow(rows - 1)
                                                + ")");

                                    }
                                }
                                rows++;

                                // set up multiplication for MS
                                HSSFRow R2 = null;

                                // begin timeseries
                                HSSFRow R3 = null;
                                HSSFRow R4 = null;
                                // end timeseries

                                String countreference = null;
                                if (key.equals("market_segment")) {

                                    // begin timeseries
                                    R = newSheetMerge.createRow(rows);
                                    // end timeseries

                                    C = R.createCell(0);

                                    C.setCellValue("COUNT");
                                    C = R.createCell(1);
                                    CellTracker ct = m
                                            .fetchCellTracker("COUNT");
                                    countreference = "Formulasheet!"
                                            + convertToXLSCol(ct.getCol())
                                            + convertToXLSRow(ct.getRow());
                                    C.setCellFormula(countreference);

                                    rows++;

                                    // begin timeseries
                                    R2 = newSheetMerge.createRow(rows + 1);
                                    // end timeseries

                                    C = R2.createCell(0);

                                    C.setCellValue(
                                            "total for market segment (*COUNT)");
                                }

                                // begin timesersies

                                // investment rule
                                String invest_reference;
                                String invest = "";
                                String exp_reference;
                                String exp = "";

                                String min = "-";

                                R3 = newSheetMerge.createRow(rows++);
                                R4 = newSheetMerge.createRow(rows++);

                                C = R3.createCell(0);

                                C.setCellValue("INVESTMENT");
                                C = R4.createCell(0);

                                C.setCellValue("EXPENSES");

                                if (value_inves != null) {
                                    C = R3.createCell(5);

                                    invest_reference = "Formulasheet!"
                                            + convertToXLSCol(
                                                    value_inves.getCol())
                                            + convertToXLSRow(
                                                    value_inves.getRow());
                                    C.setCellFormula(invest_reference);
                                } else {
                                    invest_reference = "0";
                                    C = R3.createCell(5);

                                    C.setCellFormula(invest_reference);
                                }

                                if (value_exp != null) {
                                    C = R4.createCell(5);

                                    exp_reference = "Formulasheet!"
                                            + convertToXLSCol(
                                                    value_exp.getCol())
                                            + convertToXLSRow(
                                                    value_exp.getRow());
                                    C.setCellFormula(exp_reference);
                                } else {
                                    exp_reference = "0";
                                    C = R4.createCell(5);

                                    C.setCellFormula(exp_reference);
                                }

                                // set up the formula for actor or
                                // market_segment which contain several
                                // activities

                                String sign = "";

                                String invest_rf = invest_reference;
                                String exp_rf = exp_reference;

                                if ((elementary_actor_found)
                                        || (market_segment_found)) {

                                    // Consolidation of investments and expenses
                                    // takes only place for value activities
                                    while (iter_value_activity.hasNext()) {

                                        value_activity va = (value_activity) iter_value_activity
                                                .next();

                                        CellTracker value_inves_act = null;
                                        CellTracker value_exp_act = null;
                                        CellTracker value_total_var_exp_act = null;

                                        value_inves_act = va
                                                .fetchCellTracker("INVESTMENT");
                                        value_exp_act = va
                                                .fetchCellTracker("EXPENSES");
                                        value_total_var_exp_act = va
                                                .fetchCellTracker(
                                                        "TOTAL_VARIABLE_EXPENSES");

                                        if (value_inves_act != null) {
                                            if (invest_rf.length() != 0) {
                                                sign = "+";
                                            }
                                            invest_rf += sign + "Formulasheet!"
                                                    + convertToXLSCol(
                                                            value_inves_act
                                                                    .getCol())
                                                    + convertToXLSRow(
                                                            value_inves_act
                                                                    .getRow());
                                            C = R3.createCell(5);

                                            C.setCellFormula(invest_rf);
                                        }

                                        if (value_exp_act != null) {
                                            if (exp_rf.length() != 0) {
                                                sign = "+";
                                            }
                                            exp_rf += sign + "Formulasheet!"
                                                    + convertToXLSCol(
                                                            value_exp_act
                                                                    .getCol())
                                                    + convertToXLSRow(
                                                            value_exp_act
                                                                    .getRow());
                                        }

                                        if (value_total_var_exp_act != null) {
                                            if (exp_rf.length() != 0) {
                                                sign = "+";
                                            }
                                            exp_rf += sign + "Formulasheet!"
                                                    + convertToXLSCol(
                                                            value_total_var_exp_act
                                                                    .getCol())
                                                    + convertToXLSRow(
                                                            value_total_var_exp_act
                                                                    .getRow());

                                        }
                                        // now create the investment cell
                                        if (value_exp_act != null
                                                || value_total_var_exp_act != null) {
                                            C = R4.createCell(5);
                                            C.setCellFormula(exp_rf);
                                        }
                                    }
                                }

                                R = newSheetMerge.createRow(rows);

                                // end timeseries
                                // **********************************

                                C = R.createCell(0);

                                C.setCellValue("total for actor");
                                Iterator iter_vi_totals_rownumbers = vi_totals_rownumbers
                                        .iterator();
                                String total_occ = "";
                                String total_vfunct = "";
                                String total_ec = "";
                                String plus = "";

                                while (iter_vi_totals_rownumbers.hasNext()) {
                                    int rownumber = (Integer) iter_vi_totals_rownumbers
                                            .next();
                                    if (total_occ.length() != 0) {
                                        plus = "+";
                                    }
                                    total_occ += plus + convertToXLSCol(3)
                                            + convertToXLSRow(rownumber);

                                    total_ec += plus + convertToXLSCol(5)
                                            + convertToXLSRow(rownumber);
                                }

                                // begin timeseries
                                // total for the actor after it is subtracted
                                // with investment
                                total_ec += min + convertToXLSCol(5)
                                        + convertToXLSRow(rows - 1); // expenses
                                total_ec += min + convertToXLSCol(5)
                                        + convertToXLSRow(rows - 2); // investment
                                // end timeseries

                                if (total_ec.equals("")) {
                                    total_ec = "0";
                                }

                                C = R.createCell(6);

                                C.setCellFormula(total_ec);

                                wb1.formatE3Sheet(newSheetMerge);

                            }
                        }
                    }
                }

                /////////////////////////////
                // eind sheets per actor //
                ///////////////////////////

                // write file
                try {
                    try {
                        // format all sheets
                        FileOutputStream out = new FileOutputStream(filename);

                        // begin timeseries
                        wb1.write(out);
                        // end timeseries

                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (e.getMessage().endsWith(
                                "The requested operation cannot be performed on a file with a user-mapped section open)")) {
                            throw new E3ParseException("\"" + filename
                                    + "\" is locked for Editing.\n"
                                    + "(Check if " + "Excel is still open)");
                        } else {
                            throw new E3ParseException(e.getMessage());
                        }
                    }

                    String userreport = "";
                    String unseenobjects = getUnseenModelConceptsString(
                            mapObjects);

                    if (unseenobjects.length() > 0) {
                        userreport = userreport
                                + "\nUnseen mymodel-concepts after sheet generation:\n"
                                + unseenobjects + "\n";
                        xlslog.append(userreport);
                    }

                    // logging of xls output to a textfile (DEBUG FEATURE)
                    if (batch) {
                        storeLogFile(xlslog, filename + ".write" + ".log");

                        StringBuffer log = new StringBuffer();
                        log.append(userlog);
                        log.append(valuationlog);
                        storeLogFile(log, filename + ".userlog.txt");

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    throw new E3ParseException(e.getMessage());
                }

                log.info("----> End writing formula sheets\n");

            }

        } catch (E3ParseException e) {
            throw e;
        }
        log.info("----> End exporting model to Excel\n");
    }

    private void storeLogFile(StringBuffer s, String filename)
            throws IOException {
        if (!s.equals("")) {
            File logFile = new File(filename);
            Writer output = null;
            try {
                // use buffering
                output = new BufferedWriter(new FileWriter(logFile));
                output.write(s.toString());
            } finally {
                // flush and close both "output" and its underlying FileWriter
                if (output != null) {
                    output.close();
                }
            }
        }
    }

    private boolean traverseCalculateDE(e3value_object o,
            start_stimulus source_stimulus, connection_element lasttraveled_ce,
            double f) throws E3ParseException {

        if (o instanceof start_stimulus) {
            indent = 0;
        }
        // debug info
        indent++;
        log.debug(Globals.tabs(indent) + "> traverse "
                + Globals.mediumName(o.getClass().getName()) + " "
                + o.getE3_has_uid() + " [" + f + "]");

        ((model_concept) o).toggleSeen(true, mapObjects);

        traversecalculatehistory.add(o);
        boolean returnvalue = true;
        try {

            if (o instanceof start_stimulus && o.equals(source_stimulus)) {

                // collect infos
                start_stimulus start = (start_stimulus) o;

                // put
                start.appendScenarioUsage(source_stimulus, f);
                Collection c = start.getDe_down_ce();
                if (!(c.size() > 0)) {
                    log.error("Start stimulus not connected");
                    return false;
                }
                Iterator i = c.iterator();
                while (i.hasNext()) {
                    connection_element down_ce = (connection_element) i.next();
                    dependency_element down_de = (dependency_element) down_ce
                            .getCe_with_down_de();
                    if (!traversecalculatehistory.contains(down_de)) {

                        if (down_de instanceof value_interface) {

                            returnvalue = traverseCalculateVI(
                                    (value_interface) down_de, null, null,
                                    start, f, false, false) && returnvalue;
                        } else {
                            if (down_de instanceof e3value_AND) {
                                returnvalue = traverseCalculateAND(
                                        (e3value_AND) down_de, start, down_ce,
                                        down_ce, f) && returnvalue;
                            } else {
                                returnvalue = traverseCalculateDE(down_de,
                                        start, down_ce, f) && returnvalue;
                            }
                        }
                    } else {
                        throw new E3ParseException(down_de.getClass().getName()
                                + " " + down_de.getE3_has_uid()
                                + " is involved in a loop!");
                    }
                }

            }
            if (o instanceof e3value_OR) {
                e3value_OR or = (e3value_OR) o;
                Collection c = or.getDe_down_ce();
                Collection c_up = or.getDe_up_ce();
                Iterator i = c.iterator();
                boolean primaryUP = false;
                boolean primaryDOWN = false;

                // do check
                if (c.size() > 0 && c_up.size() == 1) {
                    primaryUP = true;
                } else if (c.size() == 1 && c_up.size() > 0) {
                    primaryDOWN = true;
                } else {
                    throw new E3ParseException("OR port " + or.getE3_has_uid()
                            + " has not been connected correctly (possible loop)");
                }

                if (primaryUP || primaryDOWN) {

                    // collect infos
                    double fraction_totals = 0.0;
                    i = c.iterator();

                    while (i.hasNext()) {
                        connection_element down_ce = (connection_element) i
                                .next();
                        try {
                            fraction_totals = fraction_totals + Integer
                                    .parseInt(down_ce.getUp_fraction());
                        } catch (Exception e) {
                            throw new E3ParseException(
                                    "Invalid down attribute for " + down_ce);
                        }
                    }

                    // put
                    or.appendScenarioUsage(source_stimulus, f);
                    i = c.iterator();
                    while (i.hasNext()) {
                        connection_element down_ce = (connection_element) i
                                .next();
                        double relative_fraction = (Double.parseDouble(
                                down_ce.getUp_fraction()) / fraction_totals);
                        dependency_element down_de = (dependency_element) down_ce
                                .getCe_with_down_de();
                        if (!traversecalculatehistory.contains(down_de)) {

                            if (down_de instanceof value_interface) {
                                log.debug(f + "*" + relative_fraction + " = ");
                                returnvalue = traverseCalculateVI(
                                        (value_interface) down_de, null, null,
                                        source_stimulus, f * relative_fraction,
                                        false, false) && returnvalue;
                            } else {
                                if (down_de instanceof e3value_AND) {
                                    returnvalue = traverseCalculateAND(
                                            (e3value_AND) down_de,
                                            source_stimulus, down_ce, down_ce,
                                            f * relative_fraction)
                                            && returnvalue;
                                } else {
                                    returnvalue = traverseCalculateDE(down_de,
                                            source_stimulus, down_ce,
                                            f * relative_fraction)
                                            && returnvalue;
                                }
                            }
                        } else {
                            throw new E3ParseException(
                                    down_de.getClass().getName() + " "
                                            + down_de.getE3_has_uid()
                                            + " is involved in a loop!");
                        }

                    }

                } else if (primaryDOWN) {

                }
            }

            if (o instanceof end_stimulus) {
                // collect infos
                end_stimulus end = (end_stimulus) o;
                end.appendScenarioUsage(source_stimulus, f);
                returnvalue = true;
                log.debug(Globals.tabs(indent + 1) + "end stimulus reached");
                indent--;

            }
        } catch (E3ParseException p) {
            log.error(p.getE3Message());
            throw p;
        } catch (Exception e) {
            e.printStackTrace();
            throw new E3ParseException(
                    "Undocumented Error during scenariopath/value calculation");
        }

        traversecalculatehistory.remove(o);
        return returnvalue;

    }

    private boolean traverseCalculateAND(e3value_AND and,
            start_stimulus source_stimulus,
            connection_element source_connection_element,
            connection_element lasttraveled_ce, double f)
            throws E3ParseException {

        // debug info
        indent++;
        log.debug(Globals.tabs(indent) + "> traverse "
                + Globals.mediumName(and.getClass().getName()) + " "
                + and.getE3_has_uid() + " [" + f + "], ");

        and.toggleSeen(true, mapObjects);
        traversecalculatehistory.add(and);
        boolean returnvalue = true;

        boolean traverse_through = false;
        and.appendAdministration(source_connection_element, f);
        if (and.fetchFirst_source() == null) {
            and.placeFirst_source(source_connection_element);
        }
        if (source_connection_element.equals(and.fetchFirst_source())) {
            traverse_through = true;
        }

        if (traverse_through) {
            Collection c = and.getDe_down_ce();
            Collection c_up = and.getDe_up_ce();
            Iterator i = c.iterator();
            boolean primaryUP = false;
            boolean primaryDOWN = false;

            // do check
            if (c.size() > 0 && c_up.size() == 1) {
                primaryUP = true;
            } else if (c.size() == 1 && c_up.size() > 0) {
                primaryDOWN = true;
                primaryUP = false;
            } else {
                throw new E3ParseException("AND port " + and.getE3_has_uid()
                        + " has not been connected correctly (possible loop)");
            }

            if (primaryUP) {

                // collect infos
                // double fraction_totals = 0.0;
                i = c.iterator();

                while (i.hasNext()) {
                    connection_element down_ce = (connection_element) i.next();
                    try {
                        Integer.parseInt(down_ce.getUp_fraction());
                    } catch (Exception e) {
                        throw new E3ParseException(
                                "Invalid down attribute for " + down_ce);
                    }
                }

                // put
                and.appendScenarioUsage(source_stimulus, f);
                i = c.iterator();
                double upfraction = Double
                        .parseDouble(((connection_element) (and.getDe_up_ce()
                                .iterator().next())).getDown_fraction());
                while (i.hasNext()) {
                    connection_element down_ce = (connection_element) i.next();
                    dependency_element down_de = (dependency_element) down_ce
                            .getCe_with_down_de();
                    double downfraction = Double
                            .parseDouble(down_ce.getUp_fraction());
                    if (!traversecalculatehistory.contains(down_de)) {

                        if (down_de instanceof value_interface) {
                            returnvalue = traverseCalculateVI(
                                    (value_interface) down_de, null, null,
                                    source_stimulus,
                                    f * (downfraction / upfraction), false,
                                    false) && returnvalue;
                        } else {
                            if (down_de instanceof e3value_AND) {
                                returnvalue = traverseCalculateAND(
                                        (e3value_AND) down_de, source_stimulus,
                                        down_ce, down_ce,
                                        f * (downfraction / upfraction))
                                        && returnvalue;
                            } else {
                                returnvalue = traverseCalculateDE(down_de,
                                        source_stimulus, down_ce,
                                        f * (downfraction / upfraction))
                                        && returnvalue;
                            }
                        }
                    } else {
                        throw new E3ParseException(down_de.getClass().getName()
                                + " " + down_de.getE3_has_uid()
                                + " is involved in a loop!");
                    }
                }

            } else if (primaryDOWN) {

                // collect infos
                // double fraction_totals = 0.0;
                i = c.iterator();

                while (i.hasNext()) {
                    connection_element down_ce = (connection_element) i.next();
                    try {
                        Integer.parseInt(down_ce.getUp_fraction());
                    } catch (Exception e) {
                        throw new E3ParseException(
                                "Invalid down attribute for " + down_ce);
                    }
                }

                // put
                and.appendScenarioUsage(source_stimulus, f);

                i = c.iterator();
                if (i.hasNext()) {
                    connection_element down_ce = (connection_element) i.next();
                    dependency_element down_de = (dependency_element) down_ce
                            .getCe_with_down_de();
                    double downfraction = Double
                            .parseDouble(down_ce.getUp_fraction());
                    double upfraction = Double
                            .parseDouble(lasttraveled_ce.getDown_fraction());
                    if (!traversecalculatehistory.contains(down_de)) {

                        if (down_de instanceof e3value_AND) {
                            returnvalue = traverseCalculateAND(
                                    (e3value_AND) down_de, source_stimulus,
                                    down_ce, down_ce, f) && returnvalue;
                        } else if (down_de instanceof value_interface) {
                            returnvalue = traverseCalculateVI(
                                    (value_interface) down_de, null, null,
                                    source_stimulus, f, false, false)
                                    && returnvalue;
                        } else {
                            returnvalue = traverseCalculateDE(down_de,
                                    source_stimulus, down_ce,
                                    f * (upfraction / downfraction))
                                    && returnvalue;
                        }
                    } else {
                        throw new E3ParseException(down_de.getClass().getName()
                                + " " + down_de.getE3_has_uid()
                                + " is involved in a loop!");
                    }
                }
            }
        }

        traversecalculatehistory.remove(and);
        return returnvalue;
    }

    private boolean traverseCalculateVI(value_interface value_interface,
            value_interface source_value_interface,
            value_transaction source_value_transaction,
            start_stimulus source_stimulus, double f, boolean searchInward,
            boolean updatetransaction) throws E3ParseException {

        // debug info
        indent++;

        log.debug(Globals.tabs(indent) + "> traverse "
                + Globals.mediumName(value_interface.getClass().getName())
                + value_interface.getE3_has_uid() + " [" + f
                + "], search inwards =" + searchInward);
        if (source_value_interface != null) {
            log.debug(Globals.tabs(indent) + "- source value interface: "
                    + source_value_interface.getE3_has_name());
        } else {
            log.debug(Globals.tabs(indent) + "- source value interface: "
                    + "null");
        }
        if (source_value_transaction != null) {
            log.debug(Globals.tabs(indent) + "- source value transaction: "
                    + source_value_transaction.getE3_has_name());
        } else {
            log.debug(Globals.tabs(indent) + "- source value transaction: "
                    + "null");
        }

        value_interface.toggleSeen(true, mapObjects);
        ArrayList scheduledJumps = new ArrayList();
        if (source_value_transaction != null) {
            source_value_transaction.toggleSeen(true, mapObjects);
        }

        traversecalculatehistory.add(value_interface);
        boolean returnvalue = true;

        // multiply if MS
        // ****************************************************************
        double f_transaction = f; // FIX two_ms
        if (source_value_interface != null) {

            market_segment source_parent_ms = source_value_interface
                    .GetVi_assigned_to_ms();
            market_segment dest_parent_ms = value_interface
                    .GetVi_assigned_to_ms();
            boolean inout = false;
            if (source_value_interface != null
                    && source_value_transaction != null
                    && vi_determine_exitmethod(source_value_interface,
                            value_interface,
                            source_value_transaction) == ProfGenerator.EXIT_INOUT) {
                inout = true;
            }

            if ((source_parent_ms != null) && (((!searchInward)
                    && (source_parent_ms != dest_parent_ms)) || (inout)))

            {
                int count;
                String count_formula = source_parent_ms.fetchFormula("COUNT");
                try {
                    if (count_formula == null || "".equals(count_formula)) {
                        throw new E3ParseException("'COUNT' formula of '"
                                + source_parent_ms.getE3_has_name()
                                + "' is not a valid integer");
                    }
                    count = Integer.parseInt(count_formula);

                    f_transaction = f_transaction * count;
                    log.debug(Globals.tabs(indent)
                            + "Market segment, multiply (for transaction occurrences): "
                            + count + " x " + f);

                    log.debug(Globals.tabs(indent)
                            + "Market segment, multiply (for value interface occurrences): "
                            + count + " x " + f);
                    f = f * count;
                } catch (Exception e) {
                    throw new E3ParseException("'COUNT' formula of '"
                            + source_parent_ms.getE3_has_name()
                            + "' is not a valid integer");
                }

            }

            // divide if MS
            // ****************************************************************
            market_segment parent_ms = value_interface.GetVi_assigned_to_ms();

            if (parent_ms != null && searchInward) {

                int count;
                String count_formula = parent_ms.fetchFormula("COUNT");
                try {
                    if (count_formula == null || "".equals(count_formula)) {
                        throw new E3ParseException("'COUNT' formula of '"
                                + parent_ms.getE3_has_name()
                                + "' is not a valid integer");
                    }
                    count = Integer.parseInt(count_formula);
                    log.debug(Globals.tabs(indent)
                            + "Market segment, divide (for value interface occurrences): "
                            + f + " / " + count);
                    f = f / count;
                } catch (Exception e) {
                    throw new E3ParseException(
                            "'COUNT' formula of '" + parent_ms.getE3_has_name()
                                    + "' is not a valid integer");
                }

            }

            log.debug(Globals.tabs(indent)
                    + "Total for value interface occurrences: " + f);
        }

        value_interface.appendAdministration(source_value_interface,
                source_value_transaction, f);

        // We continue if:
        // - we are considering this exchange for the first time
        // - we are coming through one of the already visited exchanges

        boolean traverse_through = false;

        if (value_interface
                .fetchFirst_source(source_value_transaction) == null) {
            value_interface.placeFirst_source(source_value_interface,
                    source_value_transaction);
            traverse_through = true;
        }

        if (value_interface.fetchTransactionVisitCount() == 0) {
            traverse_through = true;
        }

        if (source_value_interface != null) {

            if (source_value_interface.equals(value_interface
                    .fetchFirst_source(source_value_transaction))) {
                traverse_through = true;
            }
        }

        if (!traverse_through) {
            log.debug(Globals.tabs(indent)
                    + "Do not traverse further - stop, and-merge for [");
            if (!(source_value_interface == null)) {
                log.debug("value interface: "
                        + source_value_interface.getE3_has_uid() + ");");
            }
            if (!(source_value_transaction == null)) {
                log.debug(",value transaction: "
                        + source_value_transaction.getE3_has_uid() + "]");
            }
        } else {
            // is value_interface responsible for source_value_transaction?
            // yes: then update the transaction
            if (source_value_transaction != null && source_value_transaction
                    .getResponsibleForUpdateOccurrences() == value_interface) {

                source_value_transaction.appendScenarioUsage(source_stimulus,
                        f_transaction);
                log.debug(Globals.tabs(indent)
                        + "Appending occurrences for transaction "
                        + source_value_transaction.getE3_has_name()
                        + " scenario usage " + f_transaction + ", so now "
                        + (source_value_transaction.fetchScenarioUsage())
                                .getTotalOccurences());

            }
            boolean doSearchInward = searchInward;
            value_interface.appendScenarioUsage(source_stimulus, f);

            Collection myTransactions = new ArrayList();

            int filter = ProfGenerator.any;
            if (searchInward) {

            }

            myTransactions = vi_has_transactions(value_interface, mapObjects,
                    filter);
            Iterator myTransactions_i = myTransactions.iterator();

            Iterator iterTransactions = myTransactions.iterator();
            iterTransactions = myTransactions.iterator();
            double totalTransactionFractions = 0.0;
            while (iterTransactions.hasNext()) {
                Object obj = iterTransactions.next();
                value_transaction v = (value_transaction) obj;
                totalTransactionFractions = totalTransactionFractions
                        + Double.parseDouble(v.getVt_has_fraction());
            }

            iterTransactions = myTransactions.iterator();
            ArrayList traversableTransactions = new ArrayList();

            while (iterTransactions.hasNext()) {
                value_transaction value_transaction = (value_transaction) iterTransactions
                        .next();
                log.debug(Globals.tabs(indent)
                        + "* consider (next) vi's in value_transaction"
                        + value_transaction.getE3_has_uid());
                Vector VIs_to_traverse = new Vector();

                // Find all interfaces in the transaction we are considering
                Collection VI_candidates = vt_involves_unique_vis(
                        value_transaction);
                // Do not consider the value interface we used to find this
                // transaction
                VI_candidates.remove(value_interface);

                Iterator j = VI_candidates.iterator();
                value_interface notDirectlyConnected = null;
                Vector toRemove = new Vector();
                while (j.hasNext()) {
                    notDirectlyConnected = (value_interface) j.next();
                    // is this directly connected to value_interface?
                    if (isVisConnected(value_interface,
                            notDirectlyConnected) == false) {
                        toRemove.add(notDirectlyConnected);
                    }

                }
                Iterator it = toRemove.iterator();
                while (it.hasNext()) {
                    VI_candidates.remove((it.next()));
                }

                Collection outconnectingValueInterfaces = new ArrayList();

                boolean next_vi_updatetransaction = true;
                double fraction = Double
                        .parseDouble(value_transaction.getVt_has_fraction());

                Iterator i = VI_candidates.iterator();
                value_interface candidate = null;

                while (i.hasNext()) {
                    boolean acceptcandidate = false;
                    boolean entered_through_ce = false;
                    boolean entered_through_1st2nd = false;
                    boolean entered_through_inout = false;
                    boolean exit_through_inout = false;
                    boolean opposite_vi_has_upconnection = false;
                    boolean exit_through_1st2nd = false;
                    boolean exit_through_downce = false;
                    boolean next_value_interface_nested_as_parent = false;
                    boolean next_value_interface_nested_as_child = false;
                    candidate = (value_interface) i.next();
                    log.debug(Globals.tabs(indent)
                            + "\tconsidering value interface: "
                            + candidate.getE3_has_uid());

                    // entered_through_ce
                    if (source_value_interface == null
                            && source_value_transaction == null) {
                        entered_through_ce = true;
                    }

                    // entered_through_1st2nd?
                    if (source_value_interface != null
                            && source_value_transaction != null &&
                            // searchInward &&
                            vi_determine_exitmethod(source_value_interface,
                                    value_interface,
                                    source_value_transaction) == ProfGenerator.EXIT_1st2nd) {
                        entered_through_1st2nd = true;
                    }

                    // next_value_interface_nested_as_parent
                    model_concept this_attached_container = value_interface
                            .fetchContainer();
                    model_concept candidate_attached_container = candidate
                            .fetchContainer();
                    next_value_interface_nested_as_parent = (container_is_parent(
                            this_attached_container,
                            candidate_attached_container));

                    // next_value_interface_nested_as_child
                    next_value_interface_nested_as_child = (container_is_parent(
                            candidate_attached_container,
                            this_attached_container));

                    // entered_through_inout?
                    if (source_value_interface != null
                            && source_value_transaction != null
                            && vi_determine_exitmethod(source_value_interface,
                                    value_interface,
                                    source_value_transaction) == ProfGenerator.EXIT_INOUT) {
                        entered_through_inout = true;
                    }

                    // exit_through_inout?
                    if (vi_determine_exitmethod(value_interface, candidate,
                            value_transaction) == ProfGenerator.EXIT_INOUT) {
                        exit_through_inout = true;
                    }

                    // exit_through_1st2nd?
                    if (vi_determine_exitmethod(value_interface, candidate,
                            value_transaction) == ProfGenerator.EXIT_1st2nd) {
                        exit_through_1st2nd = true;
                    }

                    // exit_through_ce?
                    if (vi_determine_exitmethod(value_interface, candidate,
                            value_transaction) == ProfGenerator.EXIT_DOWNCE) {
                        exit_through_downce = true;
                    }

                    // opposite_vi_has_downconnection
                    if (candidate.getDe_up_ce().size() > 0) {
                        opposite_vi_has_upconnection = true;
                    } else {
                        opposite_vi_has_upconnection = false;
                    }

                    if (entered_through_ce || entered_through_1st2nd) {
                        if (exit_through_inout) {
                            acceptcandidate = true;
                        }
                        if (exit_through_1st2nd) {
                            if (next_value_interface_nested_as_child
                                    && searchInward) {
                                acceptcandidate = true;
                            }
                            if (next_value_interface_nested_as_parent
                                    && !searchInward && (entered_through_ce
                                            || entered_through_1st2nd)) {
                                acceptcandidate = true;
                            }

                            if (next_value_interface_nested_as_child
                                    && searchInward) {
                                acceptcandidate = true;
                            }

                        }
                    }

                    if (entered_through_inout) {
                        if (exit_through_1st2nd) {
                            acceptcandidate = true;
                        }
                    }

                    if (opposite_vi_has_upconnection) {
                        acceptcandidate = false;
                    }

                    // We don't want to jump back
                    if (traversecalculatehistory.contains(candidate)) {
                        acceptcandidate = false;
                    }

                    if (acceptcandidate) {
                        VIs_to_traverse.add(candidate);
                        log.debug(Globals.tabs(indent + 1) + "> accept\n");
                        if (false) {
                            outconnectingValueInterfaces.add(candidate);
                        }
                    } else {
                        log.debug(Globals.tabs(indent + 1) + "> deny\n");
                    }

                    if (exit_through_inout) {
                        doSearchInward = true;
                    }
                }

                // filter
                VIs_to_traverse.remove(null);
                VIs_to_traverse.remove(value_interface); // remove self

                Iterator VIs_to_traverse_i = VIs_to_traverse.iterator();
                VIs_to_traverse_i = VIs_to_traverse.iterator();

                log.debug(Globals.tabs(indent)
                        + "Value interfaces to traverse (attached to value transaction '"
                        + value_transaction.getE3_has_name() + "') :");
                while (VIs_to_traverse_i.hasNext()) {
                    value_interface traverse_vi = (value_interface) VIs_to_traverse_i
                            .next();
                    log.debug(traverse_vi.getE3_has_uid() + ",");
                }
                log.debug("(" + VIs_to_traverse.size() + " in total)\n");

                VIs_to_traverse_i = VIs_to_traverse.iterator();
                while (VIs_to_traverse_i.hasNext()) {

                    value_interface traverse_vi = (value_interface) VIs_to_traverse_i
                            .next();
                    if (traversecalculatehistory.contains(traverse_vi)) {
                        throw new E3ParseException(
                                traverse_vi.getClass().getName() + " "
                                        + traverse_vi.getE3_has_uid()
                                        + " is involved in a loop!");
                    }

                    // select a value interface that may update
                    // value_transaction,
                    // if such a value interface was not yet selected.
                    if (value_transaction
                            .getResponsibleForUpdateOccurrences() == null) {
                        value_transaction.setResponsibleForUpdateOccurrences(
                                traverse_vi);
                    }

                    TraverseItem jump = new TraverseItem(traverse_vi,
                            value_interface, value_transaction, source_stimulus,
                            f, fraction, doSearchInward,
                            next_vi_updatetransaction);
                    scheduledJumps.add(jump);

                    if (!traversableTransactions.contains(value_transaction)) {
                        traversableTransactions.add(value_transaction);
                    }

                    next_vi_updatetransaction = false;

                }

                log.debug(Globals.tabs(indent)
                        + "* no more value interfaces to consider for "
                        + Globals.mediumName(
                                value_interface.getClass().getName())
                        + " " + value_interface.getE3_has_uid());
            }

            Iterator i = traversableTransactions.iterator();
            double totalFractions = 0.0;
            while (i.hasNext()) {
                value_transaction vt = (value_transaction) i.next();
                totalFractions = totalFractions
                        + Double.parseDouble(vt.getVt_has_fraction());
            }

            i = scheduledJumps.iterator();
            while (i.hasNext()) {
                TraverseItem jump = (TraverseItem) i.next();
                returnvalue = traverseCalculateVI(jump.getValue_interface(),
                        jump.getSource_value_interface(),
                        jump.getSource_value_transaction(),
                        jump.getSource_start_stimulus(),
                        jump.getF() * (jump.getFraction() / totalFractions),
                        jump.doSearchinward, jump.updateTransaction)
                        && returnvalue;
            }

            Collection next_ce_c = value_interface.getDe_down_ce();
            Iterator next_ce_i = next_ce_c.iterator();

            while (next_ce_i.hasNext()) {
                connection_element next_ce = (connection_element) next_ce_i
                        .next();
                log.debug(Globals.tabs(indent) + "- handling "
                        + Globals.mediumName(next_ce.getClass().getName()) + " "
                        + next_ce.getE3_has_uid());

                dependency_element target = next_ce.GetCe_with_down_de();

                if (target != null && !target.equals(value_interface)) {
                    if (!traversecalculatehistory.contains(target)) {
                        if (target instanceof e3value_AND) {
                            returnvalue = traverseCalculateAND(
                                    (e3value_AND) target, source_stimulus,
                                    next_ce, next_ce, f) && returnvalue;
                        } else if (target instanceof value_interface) {
                            returnvalue = traverseCalculateVI(
                                    (value_interface) target, null, null,
                                    source_stimulus, f, false, false)
                                    && returnvalue;
                        } else {
                            returnvalue = traverseCalculateDE(target,
                                    source_stimulus, next_ce, f) && returnvalue;
                        }
                    } else {
                        throw new E3ParseException(target.getClass().getName()
                                + " " + target.getE3_has_uid()
                                + " is involved in a loop!");
                    }
                }
            }
            if (!(scheduledJumps.size() > 0 || next_ce_c.size() > 0)) {
                returnvalue = false;
            }
        }

        traversecalculatehistory.remove(value_interface);

        log.debug(Globals.tabs(indent) + ">> handled traverse "
                + Globals.mediumName(value_interface.getClass().getName()) + " "
                + value_interface.getE3_has_uid() + " [" + f
                + "], search inwards = " + searchInward);

        return returnvalue;
    }

    /**
     * Return the ports in value_interface
     *
     * @param value_interface
     * @return
     */
    public static Vector vi_has_ports(value_interface value_interface) {
        Vector myPorts = new Vector();
        Collection myOfferings = value_interface.getVi_consists_of_of();
        Iterator iterOfferings = myOfferings.iterator();
        while (iterOfferings.hasNext()) {
            value_offering value_offerings = (value_offering) iterOfferings
                    .next();
            myPorts.addAll(value_offerings.getVo_consists_of_vp());
        }
        return myPorts;
    }

    public boolean container_is_parent(model_concept supposed_child,
            model_concept supposed_parent) {

        if (supposed_parent instanceof elementary_actor) {
            elementary_actor supposed_parent_ea = (elementary_actor) supposed_parent;
            if (supposed_parent_ea.getEl_performs_va()
                    .contains(supposed_child)) {
                return true;
            }

        }
        if (supposed_parent instanceof composite_actor) {
            composite_actor supposed_parent_ca = (composite_actor) supposed_parent;
            Collection bundlesInterfaces = supposed_parent_ca
                    .getCa_consists_of_vi();
            if (supposed_child instanceof actor) {
                actor supposed_child_a = (actor) supposed_child;
                Collection childsInterfaces = supposed_child_a.getAc_has_vi();
                Iterator childsInterfaces_i = childsInterfaces.iterator();
                while (childsInterfaces_i.hasNext()) {
                    value_interface vi = (value_interface) childsInterfaces_i
                            .next();
                    if (bundlesInterfaces.contains(vi)) {
                        return true;
                    }
                }
            }

            if (supposed_child instanceof market_segment) {
                market_segment supposed_child_a = (market_segment) supposed_child;
                Collection childsInterfaces = supposed_child_a.getMs_has_vi();
                Iterator childsInterfaces_i = childsInterfaces.iterator();
                while (childsInterfaces_i.hasNext()) {
                    value_interface vi = (value_interface) childsInterfaces_i
                            .next();
                    if (bundlesInterfaces.contains(vi)) {
                        return true;
                    }
                }
            }
        }
        if (supposed_parent instanceof market_segment) {
            market_segment supposed_parent_ms = (market_segment) supposed_parent;
            if (supposed_parent_ms.getMs_performs_va()
                    .contains(supposed_child)) {
                return true;
            }
            if (supposed_parent_ms.getMs_consists_of_ac()
                    .contains(supposed_child)) {
                return true;
            }
        }
        if (supposed_parent instanceof value_activity) {
            value_activity supposed_parent_va = (value_activity) supposed_parent;
        }
        return false;
    }

    public static value_interface vp_belongs_to_value_interface(value_port p) {
        try {
            value_offering vo = p.GetVp_in_vo();
            return vo.GetVo_in_vi();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static Vector vi_has_transactions(value_interface value_interface,
            Map mapObjects, int filter) {

        Vector myTransactions = new Vector();
        Vector tempTransactions = new Vector();
        Collection allitems = mapObjects.values();
        Iterator all_iter = allitems.iterator();
        Collection myValuePorts = vi_has_ports(value_interface);

        while (all_iter.hasNext()) {
            e3value_object item = (e3value_object) all_iter.next();
            if (item instanceof value_transaction) {
                boolean blocktransaction = false;
                value_transaction value_transaction = (value_transaction) item;
                if (vt_involves_unique_vis(value_transaction)
                        .contains(value_interface)) {

                    boolean transaction_is_firstsecond = true;
                    // filter
                    if (filter == ProfGenerator.any) {
                        myTransactions.add(value_transaction);
                    } else if (filter == ProfGenerator.InOutConnected
                            || filter == ProfGenerator.FirstSecondConnected) {
                        Collection value_transactionHasExchanges = value_transaction
                                .getVt_consists_of_ve();
                        Iterator i = value_transactionHasExchanges.iterator();

                        while (i.hasNext()) {

                            value_exchange value_exchange = (value_exchange) i
                                    .next();
                            if (value_exchange.GetVe_has_first_vp() == null
                                    && value_exchange
                                            .GetVe_has_second_vp() == null
                                    && value_exchange.GetVe_has_in_po() != null
                                    && value_exchange
                                            .GetVe_has_out_po() != null) {
                                transaction_is_firstsecond = false;
                            }

                        }

                        if (filter == ProfGenerator.InOutConnected
                                && !transaction_is_firstsecond) {
                            myTransactions.add(value_transaction);
                        }
                        if (filter == ProfGenerator.FirstSecondConnected
                                && transaction_is_firstsecond) {
                            myTransactions.add(value_transaction);
                        }
                    }

                }
            }
        }
        return myTransactions;
    }

    public static Vector vi_has_transactions(value_interface value_interface,
            Vector myValueExchanges, Map mapObjects, int filter) {
        Vector myTransactions = new Vector();
        Vector tempTransactions = new Vector();
        Collection allitems = mapObjects.values();
        Iterator all_iter = allitems.iterator();
        Collection myValuePorts = vi_has_ports(value_interface);

        while (all_iter.hasNext()) {
            e3value_object item = (e3value_object) all_iter.next();
            if (item instanceof value_transaction) {
                value_transaction value_transaction = (value_transaction) item;
                Collection value_exchanges = value_transaction
                        .getVt_consists_of_ve();
                Iterator value_exchanges_iter = value_exchanges.iterator();

                while (value_exchanges_iter.hasNext()) {
                    value_exchange value_exchange = (value_exchange) value_exchanges_iter
                            .next();
                    if (myValueExchanges.contains(value_exchange)) {
                        Vector value_ports = new Vector();
                        value_ports.add(value_exchange.GetVe_has_first_vp());
                        value_ports.add(value_exchange.GetVe_has_second_vp());
                        value_ports.add(value_exchange.GetVe_has_in_po());
                        value_ports.add(value_exchange.GetVe_has_out_po());
                        Iterator value_ports_iter = value_ports.iterator();
                        while (value_ports_iter.hasNext()) {
                            value_port vp = (value_port) value_ports_iter
                                    .next();
                            if (vp != null) {
                                value_offering value_offering = vp
                                        .GetVp_in_vo();
                                value_interface target_value_interface = value_offering
                                        .GetVo_in_vi();

                                if (!target_value_interface
                                        .equals(value_interface)
                                        && !myTransactions.contains(item)) {
                                    // check: for this VT ALL ve's must be
                                    // connected to value_interface;
                                    boolean passedcheck = true;
                                    Collection value_transaction_has_ves = value_transaction
                                            .getVt_consists_of_ve();
                                    Iterator i_value_transaction_has_ves = value_transaction_has_ves
                                            .iterator();
                                    while (i_value_transaction_has_ves
                                            .hasNext()) {
                                        value_exchange ve = (value_exchange) i_value_transaction_has_ves
                                                .next();
                                        if (!(myValuePorts.contains(
                                                ve.GetVe_has_first_vp())
                                                || myValuePorts.contains(
                                                        ve.GetVe_has_second_vp())
                                                || myValuePorts.contains(
                                                        ve.GetVe_has_in_po())
                                                || myValuePorts.contains(ve
                                                        .GetVe_has_out_po()))) {
                                            passedcheck = false;
                                        }
                                    }
                                    tempTransactions.add(value_transaction);
                                    if (passedcheck) {
                                        myTransactions.add(value_transaction);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return myTransactions;
    }

    /**
     * Return all interfaces connected to value_interface via firstsecond
     * transfers
     *
     * @param value_interface
     * @return collection of value interfaces
     */
    public static Vector value_interfaces_firstsecond_connects_exchanges(
            value_interface value_interface) {
        Vector myValueInterfaces = new Vector();
        Vector myValueExchanges = vi_firstsecond_connects_exchanges(
                value_interface);
        Iterator iterValueExchanges = myValueExchanges.iterator();
        while (iterValueExchanges.hasNext()) {
            value_exchange myValue_exchange = (value_exchange) iterValueExchanges
                    .next();
            value_port inport = myValue_exchange.GetVe_has_first_vp();
            value_port outport = myValue_exchange.GetVe_has_second_vp();
            value_interface in_vi = vp_belongs_to_value_interface(inport);
            value_interface out_vi = vp_belongs_to_value_interface(outport);
            ;

            if (!in_vi.equals(value_interface)
                    && !myValueInterfaces.contains(in_vi)) {
                myValueInterfaces.add(in_vi);
            }
            if (!out_vi.equals(value_interface)
                    && !myValueInterfaces.contains(out_vi)) {
                myValueInterfaces.add(out_vi);
            }

        }

        return myValueInterfaces;

    }

    /**
     * Are two value interfaces directly connected by means of a value transfer
     *
     * @param vi1
     * @param vi2
     * @return
     */
    public static boolean isVisConnected(value_interface vi1,
            value_interface vi2) {
        Vector peerInterfaces = valueInterfacesConnectedTo(vi1);
        if (peerInterfaces.contains(vi2)) {
            return true;
        }
        return false;
    }

    /**
     * return all value interfaces connected to value interface
     *
     * @return
     */
    public static Vector valueInterfacesConnectedTo(value_interface vi) {
        Vector myValueInterfaces = new Vector();

        Vector firstSecond = value_interfaces_firstsecond_connects_exchanges(
                vi);
        Iterator iterValueInterfaces = firstSecond.iterator();
        while (iterValueInterfaces.hasNext()) {
            value_interface myValue_interface = (value_interface) iterValueInterfaces
                    .next();
            if (!myValueInterfaces.contains(myValue_interface)) {
                myValueInterfaces.add(myValue_interface);
            }
        }

        Vector inOut = value_interfaces_inout_connects_exchanges(vi);
        iterValueInterfaces = inOut.iterator();
        while (iterValueInterfaces.hasNext()) {
            value_interface myValue_interface = (value_interface) iterValueInterfaces
                    .next();
            if (!myValueInterfaces.contains(myValue_interface)) {
                myValueInterfaces.add(myValue_interface);
            }
        }

        return myValueInterfaces;

    }

    /**
     * Return all interfaces connected to value_interface via inout transfers
     *
     * @param value_interface
     * @return collection of value interfaces
     */
    public static Vector value_interfaces_inout_connects_exchanges(
            value_interface value_interface) {
        Vector myValueInterfaces = new Vector();
        Vector myValueExchanges = vi_inout_connects_exchanges(value_interface);
        Iterator iterValueExchanges = myValueExchanges.iterator();
        while (iterValueExchanges.hasNext()) {
            value_exchange myValue_exchange = (value_exchange) iterValueExchanges
                    .next();
            value_port inport = myValue_exchange.GetVe_has_in_po();
            value_port outport = myValue_exchange.GetVe_has_out_po();
            value_interface in_vi = vp_belongs_to_value_interface(inport);
            value_interface out_vi = vp_belongs_to_value_interface(outport);
            ;

            if (!in_vi.equals(value_interface)
                    && !myValueInterfaces.contains(in_vi)) {
                myValueInterfaces.add(in_vi);
            }
            if (!out_vi.equals(value_interface)
                    && !myValueInterfaces.contains(out_vi)) {
                myValueInterfaces.add(out_vi);
            }

        }

        return myValueInterfaces;

    }

    private static int vi_determine_exitmethod(
            value_interface source_value_interface,
            value_interface dest_value_interface,
            value_transaction value_transaction) {

        if (source_value_interface.getDe_down_ce().size() > 0) {
            return ProfGenerator.EXIT_DOWNCE;
        }

        // search for a direct link (value exchange)
        Collection possible_ves = value_transaction.getVt_consists_of_ve();
        Collection possible_sourceports = vi_has_ports(source_value_interface);
        Collection possible_1st2nd_destinationports = vi_has_ports(
                dest_value_interface);
        Collection possible_inout_destinationports = vi_has_ports(
                dest_value_interface);
        Iterator iter_possible_ves = possible_ves.iterator();
        while (iter_possible_ves.hasNext()) {
            value_exchange ve = (value_exchange) iter_possible_ves.next();
            value_port ve_out_port = ve.GetVe_has_out_po();
            value_port ve_in_port = ve.GetVe_has_in_po();
            value_port ve_1_port = ve.GetVe_has_first_vp();
            value_port ve_2_port = ve.GetVe_has_second_vp();
            if (possible_1st2nd_destinationports.contains(ve_2_port)) {
                return ProfGenerator.EXIT_1st2nd;
            }
            if (possible_inout_destinationports.contains(ve_out_port)) {
                return ProfGenerator.EXIT_INOUT;
            }

        }

        return ProfGenerator.EXIT_UNKNOWN;
    }

    private static Vector vi_firstsecond_connects_exchanges(
            value_interface value_interface) {
        Vector myValueExchanges = new Vector();
        Collection temp_c = value_interface.getVi_consists_of_of();
        Iterator temp_i = temp_c.iterator();
        while (temp_i.hasNext()) {
            Collection temp_c2 = ((value_offering) temp_i.next())
                    .getVo_consists_of_vp();
            Iterator temp_i2 = temp_c2.iterator();
            while (temp_i2.hasNext()) {
                value_port temp3 = (value_port) temp_i2.next();
                if (null != temp3.getVp_first_connects_ve()) {
                    myValueExchanges.addAll(temp3.getVp_first_connects_ve());
                }
                if (null != temp3.getVp_second_connects_ve()) {
                    myValueExchanges.addAll(temp3.getVp_second_connects_ve());
                }
            }
        }
        return myValueExchanges;
    }

    private static Vector vi_inout_connects_exchanges(
            value_interface value_interface) {
        Vector myValueExchanges = new Vector();
        Collection temp_c = value_interface.getVi_consists_of_of();
        Iterator temp_i = temp_c.iterator();
        while (temp_i.hasNext()) {
            Collection temp_c2 = ((value_offering) temp_i.next())
                    .getVo_consists_of_vp();
            Iterator temp_i2 = temp_c2.iterator();
            while (temp_i2.hasNext()) {
                value_port temp3 = (value_port) temp_i2.next();
                if (null != temp3.getVp_in_connects_ve()) {
                    myValueExchanges.addAll(temp3.getVp_in_connects_ve());
                }
                if (null != temp3.getVp_out_connects_ve()) {
                    myValueExchanges.addAll(temp3.getVp_out_connects_ve());
                }
            }
        }
        return myValueExchanges;
    }

    public void addTraverseJumpHistoryElement(dependency_element src) {
        if (!jumphistory.contains(src)) {
            jumphistory.add(src);
        }
    }

    public boolean hasNextDEbeenJumped(dependency_element src) {
        if (jumphistory.contains(src)) {
            return true;
        }
        return false;
    }

    public boolean parseFormulas(String diagramName, GOLDParser parser)
            throws E3ParseException {
        StringBuffer fparselog = new StringBuffer();

        boolean succes = false;
        try {
            E3FormulaParser fp = new E3FormulaParser(parser, mymodel);
            succes = true;
            String message;

            Vector concepts = new Vector();
            concepts.add(mymodel);
            for (Iterator it = mymodel.getMo_has_mc().iterator(); it
                    .hasNext();) {
                model_concept mc = (model_concept) it.next();
                concepts.add(mc);
            }

            for (Iterator it = concepts.iterator(); it.hasNext();) {
                e3value_object mc = (e3value_object) it.next();
                String shortCN = Globals.shortName(mc.getClass().getName());
                String name = mc.getE3_has_name();

                for (Iterator it2 = mc.getE3_has_formula().iterator(); it2
                        .hasNext();) {

                    String formula = (String) it2.next();
                    String tail = Globals.fTail(formula);
                    String head = Globals.fHead(formula);
                    String result = "";

                    int index0 = 0;
                    for (int sub = 0, index1 = tail
                            .indexOf("e3{"); index1 >= 0; ++sub, index1 = tail
                                    .indexOf("e3{", index0)) {
                        result += tail.substring(index0, index1);
                        String substring = null;
                        boolean partialSucces = false;
                        try {
                            substring = tail.substring(index1,
                                    tail.indexOf("}", index1) + 1);
                            index0 = tail.indexOf("}", index1) + 1;

                            fp.parse(substring + '\n', mc, head, sub);
                            e3value_object target = fp.getMc();
                            String uid = target.getE3_has_uid();
                            String property = fp.getE3Property();
                            target.addExpression(property, null);
                            result += "e3{#" + uid + "." + property + "}";
                            partialSucces = true;
                        } catch (StringIndexOutOfBoundsException exc) {
                            message = "missing \"}\" after \"e3{\" in "
                                    + formula + "\nof the "
                                    + Globals.shortName(mc.getClass().getName())
                                    + " named " + mc.getE3_has_name();
                            throw new E3ParseException(
                                    exc.getMessage() + "\n" + message, exc);
                        }
                        succes &= partialSucces;

                    }
                    result += tail.substring(index0);
                    result.trim();
                    if (result.length() == 0) {
                        mc.addExpression(head, null);
                    } else {
                        mc.addExpression(head, result);
                    }

                }
            }
            return true;

        } catch (E3ParseException e) {
            fparselog.append("\n\n" + e.getE3Message()
                    + "\n\n\nFORMULA PARSING OR CHECKING DISCONTINUED\n");
            try {
                if (Globals.LOGFP) {
                    storeLogFile(fparselog, diagramName + ".fplog");
                }
            } catch (IOException e1) {
            }
            throw (e);
        }

    }

    public static String convertToXLSRow(int y) {
        int n = y + 1;
        String s = String.valueOf(n);
        return s;
    }

    public static String convertToXLSCol(int x)
            throws IndexOutOfBoundsException {

        int n = x + 1;
        if (n > 255) {
            throw new IndexOutOfBoundsException(
                    "Index out of bounds: 255 columns (or less) required");
        }
        char[] c = new char[] { 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z' };
        int rest;
        String s = "";

        do {
            rest = n % 27;
            n = n / 27;
            s = c[rest] + s;
        } while (n != 0);

        return s;
    }

    public static boolean StringIsNUL(String s) {
        if (s == null) {
            return true;
        }
        if (s.equals("")) {
            return true;
        }
        if (s.equals("null")) {
            return true;
        }
        if (s.equals("NULL")) {
            return true;
        }
        return false;
    }

    public boolean formulasAreComplete() throws E3ParseException {
        Vector concepts = new Vector();
        concepts.add(mymodel);
        for (Iterator it = mymodel.getMo_has_mc().iterator(); it.hasNext();) {
            model_concept mc = (model_concept) it.next();
            concepts.add(mc);
        }

        for (Iterator it = concepts.iterator(); it.hasNext();) {
            e3value_object mc = (e3value_object) it.next();
            boolean complete = mc.complete();
            if (!complete) {
                return false;
            }
        }
        return true;
    }

    public static String populateParsedFormula(String parsedformula,
            String instances_namespace, Map mapObjects) {

        String in = parsedformula;
        String result = "";
        try {

            String tail = in;
            int index0 = 0;

            StringTokenizer Tzer = new StringTokenizer(in, "{}", true);
            String previoustoken = null;
            while (Tzer.hasMoreTokens()) {

                String token = Tzer.nextToken();
                if (token.equals("{")) {
                    if (previoustoken != null && previoustoken.endsWith("e3")) {
                        result = result.substring(0, result.length() - 2);

                        // replace token with reference
                        token = Tzer.nextToken();
                        StringTokenizer localTzer = new StringTokenizer(token,
                                "#.", false);
                        String objectID = localTzer.nextToken();
                        String attrib = localTzer.nextToken();
                        if (objectID == null || attrib == null
                                || localTzer.hasMoreTokens()) {
                            throw new E3ParseException("Error parsing formula '"
                                    + in + "' - syntax error");
                        }

                        String mc_key = instances_namespace + objectID;
                        e3value_object mc = (e3value_object) mapObjects
                                .get(mc_key);
                        String col = "C";

                        if (mc.fetchCellTracker(attrib) == null) {
                            ;
                        }

                        String row = ProfGenerator.convertToXLSRow(
                                mc.fetchCellTracker(attrib).getRow());
                        String str_reference = "Formulasheet!" + col + row;
                        result = result + str_reference;
                    }
                } else if (token.equals("}")) {
                    // do nothing
                } else {
                    result = result + token;
                }
                ;

                previoustoken = token;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    // begin timeseries
    // *****************************************************************************
    public int checkExist(String sheetName, HSSFWorkbook destWB) { // checking
                                                                   // for the
                                                                   // sheet name
                                                                   // to
                                                                   // differentiate
        for (int n = 0; n < destWB.getNumberOfSheets(); n++) { // which one it
                                                               // does have the
                                                               // same name and
                                                               // which one
            if (sheetName.equals(destWB.getSheetName(n))) {
                return n;
            }
        }
        return -1;
    }

    /**
     * Merge various sheets in time into one using the DCF method
     *
     * @param srcFiles
     *            the individual net value flow sheets in time
     * @param destFile
     *            the destination net value flow sheet
     * @param Interest
     *            the default interest rate
     * @throws Exception
     */
    public void mergeSheet(Vector srcFiles, String destFile, double Interest)
            throws Exception { // merge xls files and copy them in one xls file

        Interest = Interest / 100;
        Vector total_ref = new Vector();
        try {
            ProfGenerator PG = new ProfGenerator();
            E3HSSFWorkbook destWb = new E3HSSFWorkbook();

            HSSFFont font = wb.getWorkbook().createFont();
            font.setFontHeightInPoints((short) 12);
            font.setFontName("Arial Black");
            HSSFCellStyle style = wb.getWorkbook().createCellStyle();
            style.setFont(font);

            HSSFSheet destSheet;
            short row = 0;
            short cell = 0;

            int rowIndexModifier = 0;
            lastindex = new Vector(0);

            log.info("----> Begin creating consolidated sheets");
            sheetnames = new HashSet();

            // creating Formulasheet sheets
            log.info("----> Begin creating sheets for formulas");
            for (int i = 0; i < srcFiles.size(); i++) {
                POIFSFileSystem fs = new POIFSFileSystem(
                        new FileInputStream(srcFiles.get(i).toString()));
                HSSFWorkbook srcWB = new HSSFWorkbook(fs);

                log.debug("- Creating a sheet for formulas in source sheet "
                        + srcWB.getSheetName(0) + " in source workbook "
                        + srcFiles.get(i).toString());

                destSheet = createSheet(destWb, srcWB.getSheetName(0) + i);
                lastindex.add("0");

                PG.copySheet(srcWB.getSheetAt(0), destSheet, srcWB, true,
                        destWb.getWorkbook().getNumberOfSheets() - 1, lastindex,
                        i, srcWB.getSheetName(0) + i);
            }
            log.info("----> End creating sheets for formulas");

            log.info(
                    "----> Begin creating sheets for actors and market segments");
            // creating actor and market segment sheets
            for (int i = 0; i < srcFiles.size(); i++) {
                POIFSFileSystem fs = new POIFSFileSystem(
                        new FileInputStream(srcFiles.get(i).toString()));
                HSSFWorkbook srcWB = new HSSFWorkbook(fs);
                for (int n = 1; n < srcWB.getNumberOfSheets(); n++) {
                    exists = checkExist(srcWB.getSheetName(n),
                            destWb.getWorkbook());
                    // if source sheet doesn't have same name with destination
                    // sheet
                    // create new sheet in destination workbook and copy the
                    // data
                    if (exists == -1) {
                        lastindex.add("0");
                        destSheet = createSheet(destWb, srcWB.getSheetName(n));
                        PG.copySheet(srcWB.getSheetAt(n), destSheet, srcWB,
                                true,
                                destWb.getWorkbook().getNumberOfSheets() - 1,
                                lastindex, i, srcWB.getSheetName(n));

                    } else {
                        // if source sheet does have same name with the
                        // destination sheet, then open the destination sheet
                        // and copy the new data afterward
                        destSheet = destWb.getWorkbook().getSheetAt(exists);
                        PG.copySheet(srcWB.getSheetAt(n), destSheet, srcWB,
                                false, exists, lastindex, i,
                                srcWB.getSheetName(n));
                    }

                }

            }

            lastindex.removeAllElements();

            for (int m = srcFiles.size(); m < destWb.getWorkbook()
                    .getNumberOfSheets(); m++) {

                HSSFSheet dsheet = destWb.getWorkbook().getSheetAt(m);
                String actor = (destWb.getWorkbook().getSheetName(m))
                        .replaceAll("actor_", "");

                HSSFRow drow = dsheet.getRow(1);
                int periodInterest = 0;
                String formula = "";

                // Iterate over the cells in this row, and find the the cells
                // "Total" is in
                for (Iterator n = drow.cellIterator(); n.hasNext();) {
                    HSSFCell dcell = (HSSFCell) n.next();

                    if (dcell.getStringCellValue().equals("Total")) {
                        int cellnum = dcell.getColumnIndex();

                        total_ref = new Vector(0);

                        // start with cell in the first row and the column in
                        // which we found "Total"
                        for (int t = 0; t < dsheet.getLastRowNum() + 1; t++) {
                            try {

                                drow = dsheet.getRow(t);
                                dcell = drow.getCell(cellnum);
                                if (dcell
                                        .getCellType() == HSSFCell.CELL_TYPE_STRING) {

                                    drow = dsheet.getRow(t - 1);

                                    dcell = drow.getCell(0);
                                    String temp = dcell.getStringCellValue();

                                    temp = temp.substring(7);

                                    // this is the period (0, 1,2,3, ...)
                                    periodInterest = Integer.parseInt(temp);
                                } else if (dcell
                                        .getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
                                    // this is a cell that contains a formula to
                                    // calculate the total

                                    // find the interest to be used
                                    double fInterest = 0.0;

                                    fInterest = getInterest(periodInterest,
                                            actor,
                                            destWb.getWorkbook().getSheetAt(
                                                    periodInterest));
                                    if (fInterest == 0) {
                                        fInterest = Interest;
                                    } else {
                                        log.debug("> For actor/market segment "
                                                + actor
                                                + " overriding the default interest rate with "
                                                + fInterest + " for period "
                                                + periodInterest);
                                    }

                                    String tempFormula = dcell.getCellFormula();
                                    if (periodInterest == 0) {
                                        formula = formula + "(" + tempFormula
                                                + ")";
                                    } else {
                                        int finalPeriod = periodInterest;
                                        if (formula.equals("")) {
                                            formula = formula + "(("
                                                    + tempFormula + ")"
                                                    + "/((1+" + fInterest + ")^"
                                                    + finalPeriod + "))";
                                        } else {
                                            formula = formula + "+(("
                                                    + tempFormula + ")"
                                                    + "/((1+" + fInterest + ")^"
                                                    + finalPeriod + "))";
                                        }
                                    }

                                }

                            } catch (Exception e) {
                            }

                        }

                        // formula for subtotal
                        drow = dsheet.createRow(dsheet.getLastRowNum() + 2);

                        dcell = drow.createCell(cellnum);

                        if (!formula.equals("")) { // POI 3.0
                            dcell.setCellFormula(formula);
                        }
                        dcell = drow.createCell(0);
                        dcell.setCellValue("Discounted Net Present Value");
                        dcell.setCellStyle(style);

                    }
                }

            }

            log.info(
                    "----> End creating sheets for actors and market segments");

            FileOutputStream out = new FileOutputStream(destFile);
            destWb.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("----> End creating consolidated sheets");
    }

    /**
     * Return the interest rate for an actor for a given period by consulting
     * the formula sheet for that period If no interest can be found, 0 is
     * returned
     *
     * @param period
     * @param actor
     * @param formulaSheet
     * @return the interest
     */
    double getInterest(int period, String actor, HSSFSheet formulaSheet) {

        Boolean actorFound = false;
        for (Iterator m = formulaSheet.rowIterator(); m.hasNext();) {
            // while we have not found and interest rate and we are not at the
            // end of the sheet
            HSSFRow row = (HSSFRow) m.next();
            HSSFCell cellName = row.getCell(0);
            HSSFCell cellValue = row.getCell(1);

            if (cellName.getCellType() == HSSFCell.CELL_TYPE_STRING
                    && cellName.getStringCellValue().equals("NAME")
                    && cellValue.getCellType() == HSSFCell.CELL_TYPE_STRING
                    && cellValue.getStringCellValue().equals(actor)) {
                actorFound = true;
            }

            if (actorFound) {
                // If found look for an interest attribute
                // consider each attribute until we find an empty one (or we
                // found the interest attribute)
                if (cellName.getCellType() == HSSFCell.CELL_TYPE_STRING
                        && cellName.getStringCellValue().equals("INTEREST")) {
                    return Double.parseDouble(cellValue.getStringCellValue())
                            / 100;
                } else if (cellName.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
                    actorFound = false;
                }
            }

        }
        return 0;
    }

    // copying all the data inside sheet
    public void copySheet(HSSFSheet srcSheet, HSSFSheet destSheet,
            HSSFWorkbook wb, boolean isNew, int sheetIndex, Vector lastindex,
            int period, String sheetName) {
        int rowIndexModifier;
        String total_ref = "";
        String plus = "";
        if (isNew) {
            rowIndexModifier = 0;
        } else {
            rowIndexModifier = Integer
                    .parseInt(lastindex.get(sheetIndex).toString());
        }

        if (sheetName.lastIndexOf("Formulasheet") < 0) {

            HSSFRow destRow = destSheet.createRow(rowIndexModifier);
            HSSFCell destCell = destRow.createCell(0);
            destCell.setCellValue("Period " + period);
        }

        if (!sheetName.startsWith("Formulasheet")) {
            rowIndexModifier += 1;
        }

        for (Iterator m = srcSheet.rowIterator(); m.hasNext();) {

            HSSFRow srcRow = (HSSFRow) m.next();
            HSSFRow destRow = destSheet
                    .createRow(srcRow.getRowNum() + rowIndexModifier);

            for (Iterator n = srcRow.cellIterator(); n.hasNext();) {
                HSSFCell srcCell = (HSSFCell) n.next();
                HSSFCell destCell = destRow
                        .createCell(srcCell.getColumnIndex());
                destCell.setCellStyle(srcCell.getCellStyle());

                switch (srcCell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                    destCell.setCellValue(srcCell.getNumericCellValue());
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    destCell.setCellValue(srcCell.getStringCellValue());
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    destCell.setCellValue(srcCell.getBooleanCellValue());
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: {
                    String formula = getNewFormula(srcCell, period,
                            rowIndexModifier);
                    destCell.setCellFormula(formula);
                }
                    break;
                case HSSFCell.CELL_TYPE_ERROR:
                    destCell.setCellValue(srcCell.getErrorCellValue());
                    break;

                }
            }

        }

        lastindex.get(sheetIndex);
        int test = Integer.parseInt(lastindex.get(sheetIndex).toString())
                + srcSheet.getLastRowNum() + 3;

        String test2 = "";
        test2 = test2 + test;
        lastindex.set(sheetIndex, test2);

    }

    /**
     * This is a hack to filter out scientific notation out an Excel formula
     * since Poi cannot deal with it
     *
     * @param formula
     * @return formula with no numbers in scientfic notation
     */
    private String getFormulaNoScientificNotation(String formula) {

        DecimalFormat nF = new DecimalFormat();
        DecimalFormat nF2 = new DecimalFormat(
                "######################################.##");

        // always the UK locale for separators
        // HSSF does not switch locales
        DecimalFormatSymbols dFS = nF.getDecimalFormatSymbols();
        dFS.setDecimalSeparator('.');
        dFS.setGroupingSeparator(',');
        nF.setDecimalFormatSymbols(dFS);
        nF2.setDecimalFormatSymbols(dFS);

        Number n;
        String result = new String();

        ParsePosition pP = new ParsePosition(0);
        while (pP.getIndex() < formula.length()) {
            log.debug("Result: " + result);
            n = nF.parse(formula, pP);
            if (n == null) {
                // no number, just copy the char
                result += formula.substring(pP.getIndex(), pP.getIndex() + 1);
                // consider next char
                pP.setIndex(pP.getIndex() + 1);
            } else {
                // it is a number
                // short fit but others not, so do only something for non-shorts
                // cell references do use shorts; we do not want to replace
                // these by longs
                if (n.longValue() > 32767 || n.longValue() < -32768) {
                    // really enforce a long by adding .00
                    result += nF2.format(n) + ".00";
                    // pP is already updated to the next char
                } else {
                    result += n.intValue();
                }
            }
        }
        return result;
    }

    // formula calculation handling for workbook of merged files
    private String getNewFormula(HSSFCell srcCell, int period, int newLine) {

        String Formula = srcCell.getCellFormula();
        log.debug("Source formula " + Formula);

        int Firstpos = 0, Lastpos = 0;

        Formula = Formula.replaceAll("Formulasheet", "Formulasheet" + period);

        // HSSF return formulas with arguments. separated with comma's.
        Formula = Formula.replaceAll(",", ";");

        while (Firstpos < Formula.length()) {
            if (Formula.charAt(Firstpos) >= 65 && Formula.charAt(Firstpos) <= 90
                    && Formula.lastIndexOf("Formulasheet") < 0) {
                if (Formula.charAt(Firstpos + 1) >= 48
                        && Formula.charAt(Firstpos + 1) <= 57) {
                    Lastpos = Firstpos + 1;
                    while (Formula.charAt(Lastpos) >= 48
                            && Formula.charAt(Lastpos) <= 57) {
                        Lastpos++;
                        if (Lastpos == Formula.length()) {
                            break;
                        }
                    }
                    int newIndex = Integer.parseInt(
                            Formula.substring(Firstpos + 1, Lastpos)) + newLine;
                    String newPlace = "" + Formula.charAt(Firstpos) + newIndex;
                    Formula = Formula.substring(0, Firstpos) + newPlace
                            + Formula.substring(Lastpos, Formula.length());
                    Firstpos = Lastpos;
                }
            }
            Firstpos++;
        }

        return Formula;
    }

    // end timeseries

    private int makeFormulaSheet(E3HSSFWorkbook wb, Map m,
            String instances_namespace, int countsheets, StringBuffer xlslog)
            throws Exception {

        log.debug("STEP 1: Creating a formula worksheet");
        HSSFSheet s = createSheet(wb, "Formulasheet");
        int rows = 0;
        int cell = 0;
        HSSFRow r = null;
        r = s.createRow(rows);
        HSSFCell c = null;
        c = r.createCell(cell);
        c.setCellValue("Attribute");
        cell++;
        c = r.createCell(cell);
        cell++;
        c.setCellValue("Value");
        c = r.createCell(cell);
        cell++;
        c.setCellValue("Parsed Value");

        Collection seenobjects = new Vector();
        Collection objects = m.values();
        Iterator i = objects.iterator();
        while (i.hasNext()) {
            e3value_object o = (e3value_object) i.next();
            if (!seenobjects.contains(o)) {
                seenobjects.add(o);
                cell = 0;
                rows++;
                rows++;
                String oName = o.getE3_has_name();
                String oID = o.getE3_has_uid();

                r = s.createRow(rows);
                c = null;

                c = r.createCell(cell);
                c.setCellValue("NAME");
                xlslog.append("'NAME'" + " (" + cell + "," + rows + ") ");
                cell++;
                c = r.createCell(cell);
                c.setCellValue(oName);
                cell++;
                c = r.createCell(cell);
                c.setCellValue(oName);

                xlslog.append(
                        "'" + oName + "' (" + (cell) + "," + rows + ")\n");
                o.appendCellTracker("NAME",
                        new CellTracker(cell, rows, ("Formulasheet")));

                cell = 0;
                rows++;
                r = s.createRow(rows);

                c = r.createCell(cell);
                c.setCellValue("UID");
                xlslog.append("'UID'" + " (" + cell + "," + rows + ") ");
                cell++;
                c = r.createCell(cell);
                c.setCellValue(oID);
                cell++;
                c = r.createCell(cell);
                c.setCellValue(oID);

                xlslog.append("'" + oID + "' (" + (rows) + "," + cell + ")\n");
                o.appendCellTracker("UID",
                        new CellTracker(cell, rows, ("Formulasheet")));

                Collection formulas = o.getE3_has_formula();
                Collection attributes = new Vector(formulas);

                try {
                    if (o instanceof start_stimulus) {
                        start_stimulus temp_start = (start_stimulus) o;
                        String occurrences = temp_start
                                .fetchFormula("OCCURRENCES");

                        // test occurences
                        if (occurrences == null) {
                            throw new E3ParseException(
                                    "No OCCURRENCES defined for "
                                            + temp_start.getE3_has_name());
                        }
                        try {
                            Integer.parseInt(occurrences);
                        } catch (Exception e) {
                            throw new E3ParseException("invalid OCCURRENCES '"
                                    + occurrences + "' defined on "
                                    + temp_start.getE3_has_name()
                                    + " (Integer value expected)");
                        }
                    }
                    if (o instanceof market_segment) {
                        market_segment temp_segment = (market_segment) o;
                        String count = temp_segment.fetchFormula("COUNT");

                        // test count
                        if (count == null) {
                            throw new E3ParseException("No COUNT defined for "
                                    + temp_segment.getE3_has_name());
                        }
                        try {
                            Integer.parseInt(count);
                        } catch (Exception e) {
                            throw new E3ParseException(
                                    "invalid COUNT '" + count + "' defined on "
                                            + temp_segment.getE3_has_name()
                                            + " (Integer value expected)");
                        }
                    }
                    if (o instanceof connection_element) {
                        connection_element temp_c = (connection_element) o;
                        if (temp_c.getDown_fraction() != null) {

                            rows++;
                            cell = 0;
                            r = s.createRow(rows);
                            temp_c.addExpression("DOWN_ATTRIBUTE=",
                                    "" + temp_c.getDown_fraction());
                            c = r.createCell(cell);
                            c.setCellValue("DOWN_ATTRIBUTE");
                            xlslog.append("'DOWN_ATTRIBUTE'" + " (" + cell + ","
                                    + rows + ") ");
                            cell++;
                            c = r.createCell(cell);
                            c.setCellValue(temp_c.getDown_fraction());
                            cell++;
                            c = r.createCell(cell);
                            c.setCellValue(temp_c.getDown_fraction());

                            xlslog.append("'" + temp_c.getDown_fraction()
                                    + "' (" + (rows) + "," + cell + ")\n");
                            o.appendCellTracker("DOWN_ATTRIBUTE",
                                    new CellTracker(cell, rows,
                                            ("Formulasheet")));

                        }
                        if (temp_c.getUp_fraction() != null) {
                            rows++;
                            cell = 0;
                            r = s.createRow(rows);
                            temp_c.addExpression("UP_ATTRIBUTE=",
                                    "" + temp_c.getUp_fraction());
                            c = r.createCell(cell);
                            c.setCellValue("UP_ATTRIBUTE");
                            xlslog.append("'UP_ATTRIBUTE'" + " (" + cell + ","
                                    + rows + ") ");
                            cell++;
                            c = r.createCell(cell);
                            c.setCellValue(temp_c.getUp_fraction());
                            cell++;
                            c = r.createCell(cell);
                            c.setCellValue(temp_c.getUp_fraction());

                            xlslog.append("'" + temp_c.getUp_fraction() + "' ("
                                    + (rows) + "," + cell + ")\n");
                            o.appendCellTracker("UP_ATTRIBUTE", new CellTracker(
                                    cell, rows, ("Formulasheet")));

                        }
                        temp_c = null;

                    }
                    if (o instanceof value_interface
                            || o instanceof value_transaction
                            || o instanceof value_exchange
                            || o instanceof value_port) {

                        double total = 0;

                        if (o instanceof value_interface
                                || o instanceof value_transaction) {
                            ScenarioUsage sU = o.fetchScenarioUsage();
                            if (sU != null) {
                                Double tO = sU.getTotalOccurences();
                                if (tO != null) {
                                    total = tO.doubleValue();
                                }
                            }
                        } else if (o instanceof value_port) {
                            Double tO = ((value_port) o)
                                    .fetchTotalOccurrences();
                            if (tO != null) {
                                total = tO.doubleValue();
                            }
                        } else if (o instanceof value_exchange) {
                            Double tO = ((value_exchange) o).fetchOccurrences();
                            if (tO != null) {
                                total = tO.doubleValue();
                            }
                        }
                        o.addExpression("OCCURRENCES", "" + total);
                        rows++;
                        cell = 0;
                        r = s.createRow(rows);
                        c = r.createCell(cell);
                        c.setCellValue("OCCURRENCES");
                        xlslog.append("'OCCURRENCES'" + " (" + cell + "," + rows
                                + ") ");
                        cell++;

                        c = r.createCell(cell);
                        c.setCellValue(total);

                        cell++;
                        c = r.createCell(cell);
                        c.setCellValue(total);

                        xlslog.append("'" + total + "' (" + (rows) + "," + cell
                                + ")\n");
                        o.appendCellTracker("OCCURRENCES",
                                new CellTracker(cell, rows, ("Formulasheet")));
                    }

                    if (o instanceof value_transaction) {

                        String fraction;

                        fraction = ((value_transaction) o).getVt_has_fraction();
                        if (fraction == null) {
                            throw new E3ParseException(
                                    "No FRACTION defined for "
                                            + o.getE3_has_name());
                        }
                        try {
                            Integer.parseInt(fraction);
                        } catch (Exception e) {
                            throw new E3ParseException("invalid FRACTION '"
                                    + fraction + "' defined on "
                                    + o.getE3_has_name()
                                    + " (Integer value expected)");
                        }
                        o.addExpression("FRACTION", fraction);
                        rows++;
                        cell = 0;
                        r = s.createRow(rows);
                        c = r.createCell(cell);
                        c.setCellValue("FRACTION");
                        xlslog.append(
                                "'FRACTION'" + " (" + cell + "," + rows + ") ");
                        cell++;

                        c = r.createCell(cell);
                        c.setCellValue(fraction);

                        cell++;
                        c = r.createCell(cell);
                        c.setCellValue(fraction);

                        xlslog.append("'" + fraction + "' (" + (rows) + ","
                                + cell + ")\n");
                        o.appendCellTracker("FRACTION",
                                new CellTracker(cell, rows, ("Formulasheet")));

                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

                Iterator f_i = attributes.iterator();
                while (f_i.hasNext()) {
                    String f = (String) f_i.next();
                    String prefix = Globals.trimFormula(f,
                            Globals.FORMULA_PREFIX);

                    // make exception for dummy values
                    if (!("OCCURRENCES".equals(prefix)
                            && (o instanceof value_interface
                                    || o instanceof value_port
                                    || o instanceof value_exchange
                                    || o instanceof value_transaction))) {
                        cell = 0;
                        rows++;
                        r = s.createRow(rows);
                        c = r.createCell(cell);
                        c.setCellValue(prefix);
                        xlslog.append("'" + prefix + "'" + " (" + cell + ","
                                + rows + ") ");
                        cell++;

                        String body = Globals.trimFormula(f,
                                Globals.FORMULA_BODY);
                        if (body != null) {
                            String parsedformula = o.fetchExpression(prefix);
                            c = r.createCell(cell);

                            c.setCellValue(parsedformula);
                            xlslog.append(parsedformula + "' (" + (rows) + ","
                                    + cell + ")\n");
                            o.appendCellTracker(prefix, new CellTracker(cell,
                                    rows, ("Formulasheet")));
                            cell++;
                        }
                    } else {
                        o.removeExpression("OCCURRENCES");
                    }
                }
            }
        }

        i = objects.iterator();
        while (i.hasNext()) {
            e3value_object o = (e3value_object) i.next();
            Map celltrackers = o.fetchCellTrackerMap();
            Collection keys = celltrackers.keySet();
            Iterator iter_keys = keys.iterator();
            while (iter_keys.hasNext()) {
                String key = (String) iter_keys.next();
                CellTracker ct = (CellTracker) celltrackers.get(key);
                int col = (ct.getCol());
                int row = (ct.getRow());
                String parsedbody = o.fetchExpression(key);

                String populatedbody = parsedbody;
                if (parsedbody != null && !parsedbody.equals("null")
                        && !parsedbody.equals("")) {
                    populatedbody = populateParsedFormula(parsedbody,
                            instances_namespace, mapObjects);
                    r = s.getRow(row);
                    HSSFCell newcell = r.createCell(2);// col + 1));
                    try {
                        newcell.setCellFormula(populatedbody);
                    } catch (EmptyStackException err) {
                        err.printStackTrace();
                        throw new E3ParseException(
                                "Syntax error in formula of "
                                        + Globals.shortName(
                                                o.getClass().getName())
                                        + " " + o.getE3_has_name() + ":\n" + key
                                        + "=" + populatedbody
                                        + "\n unary operator used- please see user documentation for guidelines on writing formulas",
                                err);
                    } catch (Exception err) {
                        err.printStackTrace();
                        throw new E3ParseException("Syntax error in formula of "
                                + Globals.shortName(o.getClass().getName())
                                + " " + o.getE3_has_name() + ":\n" + key + "="
                                + populatedbody + "\n", err);
                    }

                    ct.setCol(2);
                }
            }
        }
        wb.formatE3Sheet(s);
        return countsheets++;
    }

    public static boolean compareNames(String n1, String n2) {
        if (n1 == null || n2 == null) {
            return false;
        } else if (n1.equals("") || n2.equals("")) {
            return false;
        } else if (n1.equals(n2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Build a collection of value interfaces in the transaction
     *
     * @param vt
     *            the transaction
     * @return collection of value interfaces
     */

    public static Collection vt_involves_unique_vis(value_transaction vt) {
        Collection c = new Vector();
        Collection ves = vt.getVt_consists_of_ve();
        Vector connectedPorts = new Vector();
        Iterator i_ves = ves.iterator();
        while (i_ves.hasNext()) {
            value_exchange ve = (value_exchange) i_ves.next();
            connectedPorts.add(ve.GetVe_has_first_vp());
            connectedPorts.add(ve.GetVe_has_second_vp());
            connectedPorts.add(ve.GetVe_has_in_po());
            connectedPorts.add(ve.GetVe_has_out_po());
        }

        Iterator i_connectedPorts = connectedPorts.iterator();
        while (i_connectedPorts.hasNext()) {
            value_port vp = (value_port) i_connectedPorts.next();
            value_interface vi = vp_belongs_to_value_interface(vp);
            if (!c.contains(vi)) {
                c.add(vi);
            }
        }

        // clear null values
        Iterator i = c.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            if (o == null) {
                i.remove();
            }
        }

        return c;
    }

    public static Collection vt_involves_vps(value_transaction vt) {
        Collection c = new Vector();
        Collection ves = vt.getVt_consists_of_ve();
        Iterator i_ves = ves.iterator();
        while (i_ves.hasNext()) {
            value_exchange ve = (value_exchange) i_ves.next();
            value_port vpa = ve.GetVe_has_first_vp();
            value_port vpb = ve.GetVe_has_second_vp();
            value_port vpc = ve.GetVe_has_in_po();
            value_port vpd = ve.GetVe_has_out_po();
            c.add(vpa);
            c.add(vpb);
            c.add(vpc);
            c.add(vpd);

        }
        // clear null values
        Iterator i = c.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            if (o == null) {
                i.remove();
            }
        }

        return c;
    }

    private String getUnseenModelConceptsString(Map mapObjects) {
        StringBuffer s = new StringBuffer("");
        Collection c = getUnseenModelConcepts(mapObjects);
        Iterator i = c.iterator();
        while (i.hasNext()) {
            model_concept mc = (model_concept) i.next();
            s.append(Globals.mediumName(mc.getClass().getName()) + " "
                    + mc.getE3_has_name() + "\n");
        }
        return s.toString();
    }

    private Collection getUnseenModelConcepts(Map mapObjects) {

        Collection u = new Vector();

        Collection c = mapObjects.values();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            if (o instanceof model_concept) {
                model_concept mc = (model_concept) o;

                if (!mc.hasBeenSeen() && !(u.contains(mc))) {
                    u.add(mc);
                }
            }
        }

        return u;
    }

    /**
     * Normalized function driver for the valuation functiom
     *
     * @throws Exception
     */
    public void assignNormalisedFunctionsValuation() throws Exception {
        final String normFormula = "NORM_VALUE";
        final String baseFormula = "VALUATION";

        // check if "VALUE" formulas already exist
        Collection c = mapObjects.values();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            e3value_object object = (e3value_object) i.next();
            String f = null;
            f = object.fetchFormula(normFormula);
            if (f != null && !(f.equals("0")) && !(f.equals(""))) {
                throw new E3ParseException("Object " + object.getE3_has_name()
                        + " has a formula named \"" + normFormula
                        + "\" - this name has been reserved. please use a different name for your formula");
            }

            object.removeExpression(normFormula);
            Iterator formulas = object.getE3_has_formula().iterator();
            while (formulas.hasNext()) {
                String temp_f = formulas.next().toString();
                if (temp_f.startsWith(normFormula)) {
                    formulas.remove();
                }
            }
        }

        // assign VALUE to each valueport
        // 'first degree' valueports are value ports that have one or more
        // in-out connections
        // note: currently only implemented for vp's with money object
        Collection first_degree = new Vector();
        i = c.iterator();
        while (i.hasNext()) {
            e3value_object object = (e3value_object) i.next();
            if (object instanceof value_port) {
                value_port vp = (value_port) object;
                if (vp.hasInOutConnections()) {
                    // if (vp.hasMoneyObject() && vp.hasInOutConnections()){
                    first_degree.add(vp);
                }
            }
        }

        Iterator first_degree_i = first_degree.iterator();
        while (first_degree_i.hasNext()) {
            value_port vp = (value_port) first_degree_i.next();

            log.debug("Considering port: " + vp.getE3_has_name()
                    + " for normalised valuation functions");

            if (vp.hasMoneyObject()) {
                // Calculate formula for money object
                log.debug("\t This is a port with a MONEY object");
                vp.assignNormalisedFunction2(true, normFormula, baseFormula, "",
                        null, null, mapObjects, true, valuationlog);
            } else {
                // Calculate formula for non-money object
                log.debug("\t This is a port with a non MONEY object");
                vp.assignNormalisedFunction2(false, normFormula, baseFormula,
                        "", null, null, mapObjects, true, valuationlog);
            }

        }

    }

    /**
     * A value activity has a system formula called TOTAL_VARIABLE_EXPENSES This
     * formula sums up all expenses on ports (times the occurrences on the
     * ports) so that the formula can be used for consolidation of the total
     * expenses in the the sheet of the performing actor
     */
    public void assignTotalVariableExpensesValueActivity() throws Exception {

        final String formula = "TOTAL_VARIABLE_EXPENSES";

        // check if formula already exist
        Collection c = mapObjects.values();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            e3value_object object = (e3value_object) i.next();
            String f = null;
            f = object.fetchFormula(formula);
            if (f != null && !(f.equals("0")) && !(f.equals(""))) {
                throw new E3ParseException("Object " + object.getE3_has_name()
                        + " has a formula named \"" + formula
                        + "\" - this name has been reserved. please use a different name for your formula");
            }

            object.removeExpression(formula);
            Iterator formulas = object.getE3_has_formula().iterator();
            while (formulas.hasNext()) {
                String temp_f = formulas.next().toString();
                if (temp_f.startsWith(formula)) {
                    formulas.remove();
                }
            }
        }
        //
        // deal with the value activities
        Collection vas = new Vector();
        i = c.iterator();
        while (i.hasNext()) {
            e3value_object object = (e3value_object) i.next();
            if (object instanceof value_activity) {
                value_activity va = (value_activity) object;
                va.assignTotalVariableExpenses(formula);
            }
        }
    }

    /**
     * Normalized function driver for the valuation functiom
     *
     * @throws Exception
     */
    public void assignNormalisedFunctionsCardinality() throws Exception {
        final String normFormula = "NORM_CARD";
        final String baseFormula = "CARDINALITY";

        // check if "VALUE" formulas already exist
        Collection c = mapObjects.values();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            e3value_object object = (e3value_object) i.next();
            String f = null;
            f = object.fetchFormula(normFormula);
            if (f != null && !(f.equals("0")) && !(f.equals(""))) {
                throw new E3ParseException("Object " + object.getE3_has_name()
                        + " has a formula named \"" + normFormula
                        + "\" - this name has been reserved. please use a different name for your formula");
            }

            object.removeExpression(normFormula);
            Iterator formulas = object.getE3_has_formula().iterator();
            while (formulas.hasNext()) {
                String temp_f = formulas.next().toString();
                if (temp_f.startsWith(normFormula)) {
                    formulas.remove();
                }
            }
        }

        // assign VALUE to each valueport
        // 'first degree' valueports are value ports that have one or more
        // in-out connections
        // note: currently only implemented for vp's with money object
        Collection first_degree = new Vector();
        i = c.iterator();
        while (i.hasNext()) {
            e3value_object object = (e3value_object) i.next();
            if (object instanceof value_port) {
                value_port vp = (value_port) object;
                if (vp.hasInOutConnections()) {
                    first_degree.add(vp);
                }
            }
        }

        Iterator first_degree_i = first_degree.iterator();
        while (first_degree_i.hasNext()) {
            value_port vp = (value_port) first_degree_i.next();
            log.debug("Considering port: " + vp.getE3_has_name()
                    + " for normalised cardinality functions");

            vp.assignNormalisedFunction2(true, normFormula, baseFormula, "",
                    null, null, mapObjects, true, valuationlog);

        }

    }

    public static String double2String(double d) {
        String s = d + "";
        return ProfGenerator.Numberstring2Doublestring(s);
    }

    public static String Double2String(Double d) {
        String s = d + "";
        return ProfGenerator.Numberstring2Doublestring(s);
    }

    public static String Numberstring2Doublestring(String s) {
        java.text.DecimalFormat format = new java.text.DecimalFormat(
                "#0.0000000000");
        try {
            double double_s = Double.parseDouble(s);
            s = format.format(double_s);
            // workaround for locales that use , in decimals instead of .
            s = s.replace(',', '.');
        } catch (Exception e) {
            // do nothing
        }
        return s;
    }

    public static value_port ve_getPeerPort(value_exchange ve, value_port vp)
            throws E3ParseException {
        Collection c = new ArrayList();
        value_port temp_p = null;
        temp_p = ve.GetVe_has_first_vp();
        if (temp_p != null) {
            c.add(temp_p);
        }
        temp_p = null;
        temp_p = ve.GetVe_has_second_vp();
        if (temp_p != null) {
            c.add(temp_p);
        }
        temp_p = null;
        temp_p = ve.GetVe_has_in_po();
        if (temp_p != null) {
            c.add(temp_p);
        }
        temp_p = null;
        temp_p = ve.GetVe_has_out_po();
        if (temp_p != null) {
            c.add(temp_p);
        }
        temp_p = null;

        if (c.size() > 2) {
            throw new E3ParseException("Value exchange " + vp.getE3_has_name()
                    + "connects more than 2 value ports");
        }
        log.debug(c.size());
        value_port peerport = null;

        Iterator i = c.iterator();
        while (i.hasNext()) {
            peerport = (value_port) i.next();
            if (peerport == null) {
                ; // do nothing
            } else if (!peerport.equals(vp)) {
                return peerport;
            }
        }

        return null;

    }

    // check if there are no illegal formula values such as count = 0, etc.
    public static void validateNumbers(Map map) throws E3ParseException {
        Collection c = map.values();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            e3value_object owner = (e3value_object) o;
            Collection formulas = owner.getE3_has_formula();
            Iterator formulas_i = formulas.iterator();
            while (formulas_i.hasNext()) {
                String f = (formulas_i.next().toString());
                String left = Globals.fHead(f);
                String right = Globals.fTail(f);
                if (owner instanceof market_segment) {
                    if (left.equals("COUNT")) {
                        double righthand_double = Double.parseDouble(right);
                        if (righthand_double <= 0) {
                            throw new E3ParseException("invalid value ('"
                                    + right + "')of the formula '" + left
                                    + "' for "
                                    + Globals.mediumName(
                                            owner.getClass().toString())
                                    + " '" + owner.getE3_has_name() + "'");
                        }
                    }
                }
            }

        }

    }

    public static void validateDouble(String left, String right,
            e3value_object owner) throws E3ParseException {
        try {
            double d = Double.parseDouble(right);
        } catch (Exception e) {
            throw new E3ParseException("invalid value ('" + right
                    + "')of the formula '" + left + "' for "
                    + Globals.mediumName(owner.getClass().toString()) + " '"
                    + owner.getE3_has_name() + "'");
        }
    }

    /**
     * Create a sheet with valid names
     *
     * @param wb
     *            the workbook
     * @param str
     *            the interended name of the sheet
     * @return the sheet created
     */
    HSSFSheet createSheet(E3HSSFWorkbook wb, String str) {
        // check name validaty:
        // - <= 31 chars; otherwise truncate
        // - no : \ / ? * [ ]: remove this characters
        // - no blank name : append number, and check uniqueness
        // - no same name: append number, at char 30/31 and check uniqueness

        // no blank name
        String tentativeSheetname;
        if (str == null || str.equals("")) {
            tentativeSheetname = new String("unknown");
        } else {
            tentativeSheetname = str;
        }

        // remove invalid chars
        tentativeSheetname.replace(':', '_');
        tentativeSheetname.replace('\\', '_');
        tentativeSheetname.replace('/', '_');
        tentativeSheetname.replace('?', '_');
        tentativeSheetname.replace('*', '_');
        tentativeSheetname.replace('[', '_');
        tentativeSheetname.replace(']', '_');

        // adjust length
        if (tentativeSheetname.length() > 31) {
            // truncate
            tentativeSheetname = tentativeSheetname.substring(0, 30);
        }

        int i = 0;
        // ensure uniqueness
        if (!isUniqueSheetname(tentativeSheetname)) {
            // we have a problem, make it unique
            if (tentativeSheetname.length() == 31) {
                // make room
                tentativeSheetname = tentativeSheetname.substring(0, 28);
            }
            while (!isUniqueSheetname(tentativeSheetname + i)) {
                i++;
                if (i == 100) {
                    break;
                }
            }

            if (i == 100) {
                tentativeSheetname = Globals.randomstring(10, 31);
            } else {
                tentativeSheetname += i;
            }
        }

        sheetnames.add(tentativeSheetname);

        return wb.createSheet(tentativeSheetname);
    }

    /**
     * Is the sheetname unique over the already issued sheetnames
     *
     * @param name
     *            the sheetname
     * @return true: unique
     */
    private boolean isUniqueSheetname(String name) {
        Iterator i = sheetnames.iterator();

        while (i.hasNext()) {
            String n_i = (String) i.next();
            if (name.equals(n_i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sum up all occurrences in the transaction set and return the result
     *
     * @param transactions
     * @return
     */
    private double vt_has_total_occurrences(Collection transactions) {
        double occurrences = 0.0;

        Iterator i = transactions.iterator();

        value_transaction tr = null;

        while (i.hasNext()) {
            tr = (value_transaction) i.next();
            occurrences += (tr.fetchScenarioUsage()).getTotalOccurences();
            log.debug("Transaction " + tr.getE3_has_uid() + " "
                    + tr.getE3_has_name() + ", Occurrences = " + occurrences
                    + "\n");
        }

        return occurrences;

    }
}