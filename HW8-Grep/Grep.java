//I worked on the homework assignment alone, using only course materials.

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class represents the Grep search.
 * @author Jade Law (jlaw39)
 * @version 1.0
 */
public class Grep {
    private static String result = "";
    private static Scanner scan;
    private static String r = "";
    private static String newline = System.getProperty("line.separator");
    private static IOException ioe = new IOException();
    /**
     * This is the main method
     * @param args is a list of strings
     */
    public static void main(String[] args) {
        String s;
        try {
            if (args[0].equals("-i") && args.length == 3) {
                File f = new File(args[2]);
                s = args[1].toLowerCase();
                result += grep(f, s, true); //true = -i exists NOT CASE SENSITIVE
            } else if (!(args[0].equals("-i")) && args.length == 2) {
                File f = new File(args[1]);
                s = args[0];
                result += grep(f, s, false); //false = -i CASE SENSITIVE
            } else {
                IllegalArgumentException iae = new IllegalArgumentException();
                throw iae;
            }
            System.out.println(result.trim());
        } catch (IOException io) {
            System.out.println("IOException");
        } catch (IllegalArgumentException iae) {
            System.out.println("IllegalArgumentException");
        } catch (InvalidSearchStringException isse) {
            System.out.println("InvalidSearchStringException");
        }
    }

    /**
     * Performs the actual search for the Strings within the files
     * @param file is the directory to be searched
     * @param str is the string that user is looking for
     * @param i if true then is case sensitive, if false then not case sensitive
     * @return String containing all matches in the given directory and its subdirectories
     */
    public static String grep(File file, String str, boolean i) throws IOException {
        String line = "";
        String linelower = "";
        if (str.contains("\\n")) {
            InvalidSearchStringException isse = new InvalidSearchStringException();
            throw isse;
        }
        if (i) { //NOT CASE SENSITIVE
            if (file.isFile() && file.exists()) {
                int count = 1;
                scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    line = scan.nextLine();
                    linelower = line.toLowerCase();
                    if (linelower.contains(str)) {
                        r += file + ":" + count + ":" + line + "\n";
                    }
                    count++;
                }
            } else if (file.isDirectory() && file.exists()) {
                recursion(file, str, i);
            } else {
                throw ioe;
            }
            return r;
        } else { //CASE SENSITIVE
            if (file.isFile() && file.exists()) {
                int count = 1;
                scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    line = scan.nextLine();
                    if (line.contains(str)) {
                        r += file + ":" + count + ":" + line + "\n";
                    }
                    count++;
                }
            } else if (file.isDirectory() && file.exists()) {
                recursion(file, str, i);
            } else {
                throw ioe;
            }
        }
        return r;
    }

    /**
     * recursive method for if subdirectories exists
     * @param f is the directory to be searched
     * @param s is the string that user is looking for
     * @param b if true then is case sensitive, if false then not case sensitive
     */
    public static void recursion(File f, String s, boolean b) throws IOException {
        if (f.exists()) {
            File[] files = f.listFiles();
            for (File file : files) {
                grep(file, s, b);
            }
        } else {
            throw ioe;
        }
    }
}
