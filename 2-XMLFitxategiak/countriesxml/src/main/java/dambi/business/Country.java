package dambi.business;

import java.time.LocalDate;

import dambi.adapter.DateAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = { "name", "capital", "foundation", "continent", "population" })
@XmlRootElement(name = "Country")
public class Country {
    String name;
    String capital;
    LocalDate foundation;
    String continent;
    int population;

    @XmlElement(name = "Country_Population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @XmlElement(name = "Country_Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    @XmlElement(name = "Country_Capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    @XmlElement(name = "Country_Foundation_Date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public LocalDate getFoundation() {
        return foundation;
    }

    public void setFoundation(LocalDate foundation) {
        this.foundation = foundation;
    }

    @XmlElement(name = "Country_Continent")
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
