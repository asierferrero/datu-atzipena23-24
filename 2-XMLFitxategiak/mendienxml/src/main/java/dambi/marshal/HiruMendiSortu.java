package dambi.marshal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dambi.model.Mendia;
import dambi.model.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class HiruMendiSortu {
    public static void main(String[] args) throws JAXBException {
        List<Mendia> mendiak = new ArrayList<>();

        Mendia mendia1 = new Mendia();
        mendia1.setIzena("Karakate");
        mendia1.setAltuera("749");
        mendia1.setProbintzia("Gipuzkoa");

        Mendia mendia2 = new Mendia();
        mendia2.setIzena("Aketegi");
        mendia2.setAltuera("1548");
        mendia2.setProbintzia("Gipuzkoa");

        Mendia mendia3 = new Mendia();
        mendia3.setIzena("Hernio");
        mendia3.setAltuera("1075");
        mendia3.setProbintzia("Gipuzkoa");

        mendiak.add(mendia1);
        mendiak.add(mendia2);
        mendiak.add(mendia3);

        Mendiak mendiakWrapper = new Mendiak();
        mendiakWrapper.setMendiak(mendiak);

        /* init jaxb marshaler */
        JAXBContext jaxbcontext = JAXBContext.newInstance(Mendiak.class);
        Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();

        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal(mendiakWrapper, new File("hirumendi.xml"));
        jaxbMarshaller.marshal(mendiakWrapper, System.out);
    }
}
