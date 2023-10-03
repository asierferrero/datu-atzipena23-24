package dambi.marshal;

import java.io.File;
import java.time.LocalDate;
import dambi.business.Country;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class JaxBExampleSimple {

    public static void main(String[] args) {
        try {

            /* init very simple data to marshal */
            Country spain = new Country();
            spain.setName("Spain");
            spain.setCapital("Madrid");
            spain.setContinent("Europe");
            spain.setFoundation( LocalDate.of( 1469, 10, 19 ) );

            spain.setPopulation(45000000);

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(spain, new File("country.xml"));
            jaxbMarshaller.marshal(spain, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
