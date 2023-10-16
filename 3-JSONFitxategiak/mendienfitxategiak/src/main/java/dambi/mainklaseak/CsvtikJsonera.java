package dambi.mainklaseak;

import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class CsvtikJsonera {
    public static void main(String[] args) throws IOException {
        Mendiak mendiak = new Mendiak();
        Mendiak mendi = new Mendiak();

        Csva csva = new Csva("./Mendiak.csv");
        new Jsona("", "./Mendiak.json");

        mendiak = csva.irakurri();
        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                mendi.add(m);
            }
            System.out.println("Mendiak ondo idatzi dira Json fitxategian.");
        }
    }
}