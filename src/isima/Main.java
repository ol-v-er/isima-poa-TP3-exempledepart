package isima;

import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
    interface PrintTest {
        public boolean test(MetroStop s);
    }

    private static void print(PrintStream out, ArrayList<MetroStop> l, PrintTest test) {
        for (MetroStop it: l) {
            if (test.test(it))
                out.println(it);
        }
    }

    private static void print(PrintStream out, ArrayList<MetroStop> l) {
        print(out, l, (s) -> true);
    }

    public static void main(String[] argv) {
        try {
            Parser parser = new Parser("/tmp/ratp_arret.csv");
            parser.parse();
            for (MetroStop m : parser.listMetroStop){
                System.out.println(m);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
