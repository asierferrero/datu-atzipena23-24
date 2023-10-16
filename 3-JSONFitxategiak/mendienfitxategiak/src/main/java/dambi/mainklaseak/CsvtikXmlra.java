package dambi.mainklaseak;
import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;
import jakarta.xml.bind.JAXBException;

public class CsvtikXmlra {
    public static void main(String[] args) throws IOException, JAXBException {
        Mendiak mendiak = new Mendiak();
        Mendiak mendi = new Mendiak();

        Csva csva = new Csva("./Mendiak.csv");
        Xmla xmla = new Xmla("", "./Mendiak.xml");

        mendiak = csva.irakurri();
        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                mendi.add(m);
            }
            System.out.println(xmla.idatzi(mendi) + " mendi ondo idatzi dira xml fitxategian.");
        }
    }
}
