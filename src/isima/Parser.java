package isima;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
        public List<MetroStop> listMetroStop;
        private String path;

        public Parser(String filePath){
            this.path = filePath;
            listMetroStop=new ArrayList<MetroStop>();
        }
        public void parse() throws Exception {
            Reader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine())!= null){
                MetroStop metroStop = new MetroStop();

                String[] parts = line.split("#");

                metroStop.id = Integer.parseInt(parts[0]);
                metroStop.longitude = Double.parseDouble(parts[1]);
                metroStop.latitude = Double.parseDouble(parts[2]);
                metroStop.nom = parts[3];
                metroStop.arrondissement = parts[4];
                metroStop.type = parts[5];

                listMetroStop.add(metroStop);
            }
            br.close();
        }
}
