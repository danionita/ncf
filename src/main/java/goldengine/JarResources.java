package goldengine;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

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

/**
 * JarResources: JarResources maps all resources included in a Zip or Jar file.
 * Additionaly, it provides a method to extract one as a blob.
 */
public final class JarResources {

    static Logger log = Logger.getLogger(JarResources.class.getName());

    // external debug flag
    public boolean debugOn = false;

    // jar resource mapping tables
    private Hashtable htSizes = new Hashtable();
    private Hashtable htJarContents = new Hashtable();

    // a jar file
    private String jarFileName;

    /**
     * creates a JarResources. It extracts all resources from a Jar into an
     * internal hashtable, keyed by resource names.
     *
     * @param jarFileName
     *            a jar or zip file
     */
    public JarResources(String jarFileName) {
        this.jarFileName = jarFileName;
        init();
    }

    /**
     * Extracts a jar resource as a blob.
     *
     * @param name
     *            a resource name.
     */
    public byte[] getResource(String name) {
        return (byte[]) htJarContents.get(name);
    }

    /**
     * initializes internal hash tables with Jar file resources.
     */
    private void init() {
        try {
            // extracts just sizes only.
            ZipFile zf = new ZipFile(jarFileName);
            Enumeration e = zf.entries();
            while (e.hasMoreElements()) {
                ZipEntry ze = (ZipEntry) e.nextElement();
                if (debugOn) {
                    log.debug(dumpZipEntry(ze));
                }
                htSizes.put(ze.getName(), new Integer((int) ze.getSize()));
            }
            zf.close();

            // extract resources and put them into the hashtable.
            FileInputStream fis = new FileInputStream(jarFileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ZipInputStream zis = new ZipInputStream(bis);
            ZipEntry ze = null;
            while ((ze = zis.getNextEntry()) != null) {
                if (ze.isDirectory()) {
                    continue;
                }
                if (debugOn) {
                    log.debug("ze.getName()=" + ze.getName() + ","
                            + "getSize()=" + ze.getSize());
                }
                int size = (int) ze.getSize();
                // -1 means unknown size.
                if (size == -1) {
                    size = ((Integer) htSizes.get(ze.getName())).intValue();
                }
                byte[] b = new byte[size];
                int rb = 0;
                int chunk = 0;
                while ((size - rb) > 0) {
                    chunk = zis.read(b, rb, size - rb);
                    if (chunk == -1) {
                        break;
                    }
                    rb += chunk;
                }
                // add to internal resource hashtable
                htJarContents.put(ze.getName(), b);
                if (debugOn) {
                    System.out.println(ze.getName() + "  rb=" + rb + ",size="
                            + size + ",csize=" + ze.getCompressedSize());
                }
            }
        } catch (NullPointerException e) {
            log.debug("done.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dumps a zip entry into a string.
     *
     * @param ze
     *            a ZipEntry
     */
    private String dumpZipEntry(ZipEntry ze) {
        StringBuffer sb = new StringBuffer();
        if (ze.isDirectory()) {
            sb.append("d ");
        } else {
            sb.append("f ");
        }
        if (ze.getMethod() == ZipEntry.STORED) {
            sb.append("stored   ");
        } else {
            sb.append("defalted ");
        }
        sb.append(ze.getName());
        sb.append("\t");
        sb.append("" + ze.getSize());
        if (ze.getMethod() == ZipEntry.DEFLATED) {
            sb.append("/" + ze.getCompressedSize());
        }
        return (sb.toString());
    }

    /**
     * Is a test driver. Given a jar file and a resource name, it trys to
     * extract the resource and then tells us whether it could or not.
     *
     * <strong>Example</strong> Let's say you have a JAR file which jarred up a
     * bunch of gif image files. Now, by using JarResources, you could extract,
     * create, and display those images on-the-fly.
     *
     * <pre>
     *     ...
     *     JarResources JR=new JarResources("GifBundle.jar");
     *     Image image=Toolkit.createImage(JR.getResource("logo.gif");
     *     Image logo=Toolkit.getDefaultToolkit().createImage(
     *                   JR.getResources("logo.gif")
     *                   );
     *     ...
     * </pre>
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println(
                    "usage: java JarResources <jar file name> <resource name>");
            System.exit(1);
        }
        JarResources jr = new JarResources(args[0]);
        byte[] buff = jr.getResource(args[1]);
        if (buff == null) {
            log.error("Could not find " + args[1] + ".");
        } else {
            log.info("Found " + args[1] + " (length=" + buff.length + ").");
        }
    }

} // End of JarResources class.
