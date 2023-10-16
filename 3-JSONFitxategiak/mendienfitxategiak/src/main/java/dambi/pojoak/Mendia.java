package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "mendia", "altuera", "probintzia" })
@XmlRootElement(name = "Mendia")
public class Mendia {
    private int id;
    private String mendia;
    private String altuera;
    private String probintzia;

    public Mendia(int id, String mendia, String altuera, String probintzia) {
        this.id = id;
        this.mendia = mendia;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    public Mendia() {

    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "Mendia_izena")
    public String getMendia() {
        return mendia;
    }

    public void setMendia(String mendia) {
        this.mendia = mendia;
    }

    @XmlElement(name = "Mendia_altuera")
    public String getAltuera() {
        return altuera;
    }

    public void setAltuera(String altuera) {
        this.altuera = altuera;
    }

    @XmlElement(name = "Mendia_probintzia")
    public String getProbintzia() {
        return probintzia;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Mendia: " + mendia + ", Altuera: " + altuera + ", Probintzia: " + probintzia + "\n";
    }

}
