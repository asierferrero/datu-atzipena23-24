package dambi.atzipenekoak;

import java.io.File;

import dambi.pojoak.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {
    public String strFileIn;
    private String strFileOut;

    public Xmla(String fileIn) {
        this.strFileIn = fileIn;
    }

    public Xmla(String fileIn, String fileOut) {
        this.strFileIn = fileIn;
        this.strFileOut = fileOut;
    }

    public Mendiak irakurri() throws JAXBException {
        Mendiak mendiak = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            mendiak = (Mendiak) jaxbUnmarshaller.unmarshal(new File(strFileIn));
        } catch (Exception e) {
            System.out.println("Ezin izan da " + strFileIn + "fitxategia irakurri.");
        }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak) throws JAXBException {
        int mendiKop = 0;
        try {
            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(mendiak, new File(strFileOut));

            mendiKop = mendiak.getMendiak().size();
        } catch (Exception e) {
            System.out.println("Arazoa egon da " + strFileIn + " fitxategiarekin.");
        }
        return mendiKop;
    }
}
