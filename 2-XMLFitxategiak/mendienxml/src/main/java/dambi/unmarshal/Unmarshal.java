package dambi.unmarshal;

import java.io.File;
import java.util.List;

import dambi.model.Mendia;
import dambi.model.Mendiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Unmarshal {
    public static void main(String[] args) {
        try {
            File file = new File("./hirumendi.xml");
            JAXBContext jaxbcontext = JAXBContext.newInstance(Mendiak.class);
            Unmarshaller jaxbUnmarshaller = jaxbcontext.createUnmarshaller();
            Mendiak mendiak = (Mendiak) jaxbUnmarshaller.unmarshal(file);

            for (int i = 0; i < mendiak.getMendiak().size(); i++) {
                Mendia mendia = mendiak.getMendiak().get(i);
                double altuera_oinetan = Double.parseDouble(mendia.getAltuera()) * 3.28084;
                mendia.setAltuera(String.valueOf(altuera_oinetan));
            }
            // Create the xml file with the changes
            Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(mendiak, new File("mendiakaltueraoinatan.xml"));
            jaxbMarshaller.marshal(mendiak, System.out);

            Mendiak gipuzkoa = new Mendiak();
            List<Mendia> lista = mendiak.getMendiak();
            int size = lista.size();

            for (int i = 0; i < size; i++) {
                Mendia mendia = lista.get(i);
                if ("Gipuzkoa".equals(mendia.getProbintzia())) {
                    gipuzkoa.add(mendia);
                }
            }

            // Create the xml file with the filtered changes
            JAXBContext outputContext = JAXBContext.newInstance(Mendiak.class);
            Marshaller outputMarshaller = outputContext.createMarshaller();
            outputMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            outputMarshaller.marshal(gipuzkoa, new File("gipuzkoakomendiak.xml"));
            outputMarshaller.marshal(gipuzkoa, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
