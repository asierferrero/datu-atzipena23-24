package dambi.business;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Countries" )
public class Countries
{
    List<Country> countries;

    public List<Country> getCountries()
    {
        return countries;
    }

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement( name = "Country" )
    public void setCountries( List<Country> countries )
    {
        this.countries = countries;
    }

    /**
     * This method is not used by jaxb, just used for business reasons. In the case that this class
     * would be generated using xml schemas definitions, this method has to be added to the
     * generated class or to some helper or util one
     * 
     * @param country
     */
    public void add( Country country )
    {
        if( this.countries == null )
        {
            this.countries = new ArrayList<Country>();
        }
        this.countries.add( country );

    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        for( Country museum : this.countries )
        {
            str.append( museum.toString() );
        }
        return str.toString();
    }

}
