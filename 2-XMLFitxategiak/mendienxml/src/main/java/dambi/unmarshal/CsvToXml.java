package dambi.unmarshal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dambi.model.Mendia;
import dambi.model.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class CsvToXml {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStream = null;
        Mendiak mendiak = new Mendiak();

        try {
            inputStream = new BufferedReader(new FileReader("./Mendiak.csv"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length == 3) {
                    Mendia mendia = new Mendia(fields[0], fields[1], fields[2]);
                    mendiak.add(mendia);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fitxategia ez da aurkitu.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshal to an XML file
            File xmlFile = new File("./mendiak.xml");
            jaxbMarshaller.marshal(mendiak, xmlFile);

            // Print the XML content to the console
            jaxbMarshaller.marshal(mendiak, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}