package dambi.model;

import lombok.Data;

@Data  //Atributuak bakarrik definitu ditugu eta ... automatikoki, ikus Outlinean: konst.get/sett, etab. 
public class User {
    private int idJokalari;
    private String email;
    private double soldata;
    
}
