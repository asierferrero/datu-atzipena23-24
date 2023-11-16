package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class Csva {
    public String strFileIn;
    private String strFileOut;

    public Csva(String fileIn) {
        this.strFileIn = fileIn;
    }

    public Csva(String fileIn, String fileOut) {
        this.strFileIn = fileIn;
        this.strFileOut = fileOut;
    }

    public Mendiak irakurri() throws IOException {
        Mendiak mendiak = new Mendiak();

        try (BufferedReader br = new BufferedReader(new FileReader(strFileIn))) {
            String line;
            int id = 0;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length == 3 && id >= 1) {
                    Mendia mendia = new Mendia();
                    mendia.setId(id);
                    mendia.setMendia(values[0]);
                    mendia.setAltuera(values[1]);
                    mendia.setProbintzia(values[2]);

                    mendiak.add(mendia);
                    id++;
                } else {
                    id++;
                }
            }
        } catch (Exception e) {
            System.out.println("Ezin izan da " + strFileIn + "fitxategia irakurri.");
        }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak) {
        int mendiKop = 0;

        try (PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut))) {
            for (Mendia mendia : mendiak.getMendiak()) {
                mendiKop++;
                outputStream.println(mendia.getMendia() + ";" + mendia.getAltuera() + ";" + mendia.getProbintzia());
            }
        } catch (Exception e) {
            System.out.println("Arazoa egon da " + strFileIn + " fitxategiarekin.");
        }
        return mendiKop;
    }

}
