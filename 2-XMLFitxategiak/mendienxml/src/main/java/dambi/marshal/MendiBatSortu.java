package dambi.marshal;

import java.io.File;

import dambi.model.Mendia;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MendiBatSortu {
    public static void main(String[] args) throws JAXBException {
        Mendia mendia = new Mendia();

        mendia.setIzena("Karakate");
        mendia.setAltuera("749");
        mendia.setProbintzia("Gipuzkoa");

        /* init jaxb marshaler */
        JAXBContext jaxbcontext = JAXBContext.newInstance(Mendia.class);
        Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();

        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal(mendia, new File("mendibat.xml"));
        jaxbMarshaller.marshal(mendia, System.out);
    }
}
