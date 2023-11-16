package dambi.mainklaseak;

import java.io.IOException;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.Xmla;

import dambi.pojoak.Mendiak;
import jakarta.xml.bind.JAXBException;

public class Irakurketak {
    public static void main(String[] args) throws IOException, JAXBException {
        Mendiak mendiak = new Mendiak();
        Csva csva = new Csva("./Mendiak.csv");
        mendiak = csva.irakurri();
        if (mendiak != null) {
            System.out.println(csva.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
        Xmla xmla = new Xmla("./Mendiak.xml");
        mendiak = xmla.irakurri();
        if (mendiak != null) {
            System.out.println(xmla.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
        Jsona jsona = new Jsona("./Mendiak.json");
        mendiak = jsona.irakurri();
        if (mendiak != null) {
            System.out.println(jsona.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
    }
}