package dambi.marshal;

import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlType(propOrder = { "izena", "altuera", "probintzia" })
@XmlRootElement(name = "Mendia")
public class Mendia {
    String izena;
    String altuera;
    String probintzia;

    @XmlElement(name = "Mendia_izena")
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    @XmlElement (name = "Mendia_altuera")
    public String getAltuera() {
        return altuera;
    }

    public void setAltuera(String altuera) {
        this.altuera = altuera;
    }

    @XmlElement (name = "Mendia_probintzia")
    public String getProbintzia() {
        return probintzia;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

}
