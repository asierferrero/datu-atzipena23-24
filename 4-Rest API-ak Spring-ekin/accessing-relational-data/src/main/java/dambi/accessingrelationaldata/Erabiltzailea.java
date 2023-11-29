package dambi.accessingrelationaldata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Erabiltzailea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    public String izena;

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }
}
