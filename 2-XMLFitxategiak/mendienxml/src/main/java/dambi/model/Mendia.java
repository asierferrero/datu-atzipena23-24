package dambi.model;

import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlType(propOrder = { "izena", "altuera", "probintzia" })
@XmlRootElement(name = "Mendia")
public class Mendia {
    String izena;
    String altuera;
    String probintzia;

    public Mendia() {
    }

    public Mendia(String izena, String altuera, String probintzia) {
        this.izena = izena;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    @XmlElement(name = "Mendia_izena")
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    @XmlElement(name = "Mendia_altuera")
    public String getAltuera() {
        return altuera;
    }

    public void setAltuera(String string) {
        this.altuera = string;
    }

    @XmlElement(name = "Mendia_probintzia")
    public String getProbintzia() {
        return probintzia;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }
}
