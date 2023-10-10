package dambi.adapter;

import java.time.LocalDate;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    /**
     * Overrides the unmarshal method of the class XmlAdapter in order to parse a
     * date of the type
     * LocalDate
     * 
     * @param date String
     * @return LocalDate
     * @throws Exception
     */
    public LocalDate unmarshal(String date) throws Exception {
        return LocalDate.parse(date);
    }

    /**
     * Overrides the marshal method of the class XmlAdapter in order to convert the
     * passed date to
     * an String
     *
     * @param date LocalDate
     * @return String
     * @throws Exception
     */
    public String marshal(LocalDate date) throws Exception {
        return date.toString();
    }

}
