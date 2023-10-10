package dambi.unmarshal;

import java.io.File;

import dambi.business.Countries;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class UnMarshalJAXVBCompleteExample {
    public static void main(String[] args) {

        try {

            File file = new File("countries.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);

            /**
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Countries countries = (Countries) jaxbUnmarshaller.unmarshal(file);
            System.out.println(countries);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
