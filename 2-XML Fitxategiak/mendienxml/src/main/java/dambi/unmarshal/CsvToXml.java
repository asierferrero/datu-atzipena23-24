package dambi.unmarshal;

import java.io.File;

import dambi.model.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class CsvToXml {
    public static void main(String[] args) {
        Mendiak mendiak = new Mendiak();

        try {
            /* init jaxb marshaler */
            JAXBContext jaxbcontext = JAXBContext.newInstance(Mendiak.class);
            Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(mendiak, new File("hirumendi.xml"));
            jaxbMarshaller.marshal(mendiak, System.out);

        } catch (Exception e) {

        }
    }
}