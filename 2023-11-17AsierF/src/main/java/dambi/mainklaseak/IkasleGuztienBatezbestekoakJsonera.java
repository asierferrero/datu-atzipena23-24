package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.JsonIkasleak;
import dambi.pojoak.Notak;

public class IkasleGuztienBatezbestekoakJsonera {
    public static void main(String[] args) {

        Notak notak = null;
        Csva csva = new Csva("datuak/Notak.csv");
        JsonIkasleak jsona = new JsonIkasleak("", "datuak/IkasleGuztienBatezbestekoak.json");
        notak = csva.irakurri();
        if (notak != null) {

            System.out.println(jsona.idatzi(notak) + " nota idatzi dira json fitxategian.");
        }

    }
}
