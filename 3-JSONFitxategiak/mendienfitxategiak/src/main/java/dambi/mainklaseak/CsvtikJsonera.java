package dambi.mainklaseak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dambi.pojoak.Mendia;

public class CsvtikJsonera {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStream = null;
        List<Mendia> mendiakList = new ArrayList<>();

        try {
            inputStream = new BufferedReader(new FileReader("./Mendiak.csv"));
            String line;
            int id = 1;

            while ((line = inputStream.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length == 3) {
                    Mendia mendia = new Mendia(id, fields[0], fields[1], fields[2]);
                    mendiakList.add(mendia);
                    id++; // Increment the id for each Mendia object
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fitxategia ez da aurkitu.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        // Write the data to a JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("./Mendiak.json");
        objectMapper.writeValue(jsonFile, mendiakList);

        // Print JSON content to the console
        String jsonContent = objectMapper.writeValueAsString(mendiakList);
        System.out.println(jsonContent);
    }
}
