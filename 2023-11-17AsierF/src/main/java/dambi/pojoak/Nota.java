package dambi.pojoak;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Nota")
@XmlType(propOrder={"id", "data" , "ikaslea", "ikasgaia", "nota" })
public class Nota {
    int id = 0;
    String ikaslea;
    LocalDate data;
    String ikasgaia;
    double nota;

    public int getId(){
       return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getIkaslea() {
        return ikaslea;
    }

    @XmlElement(name = "Ikaslea")
    public void setIkaslea(String ikaslea) {
        this.ikaslea = ikaslea;
    }

    public String getData() {
        return data.toString();
    }

    @XmlElement(name = "Data")
    public void setData(String data) {
        this.data = LocalDate.parse(data);
    }

    public String getIkasgaia() {
        return ikasgaia;
    }

    @XmlElement(name = "Ikasgaia")
    public void setIkasgaia(String ikasgaia) {
        this.ikasgaia = ikasgaia;
    }
    
    public double getNota() {
        return nota;
    }

    @XmlElement(name = "Emaitza")
    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota["+ id+", "+ikaslea+", "+data+", "+ikasgaia+", "+nota+"]";
    }

}
