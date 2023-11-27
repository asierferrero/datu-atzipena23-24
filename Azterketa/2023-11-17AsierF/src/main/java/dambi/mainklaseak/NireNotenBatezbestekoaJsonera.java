package dambi.mainklaseak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dambi.atzipenekoak.JsonIkasleak;
import dambi.pojoak.Ikaslea;
import dambi.pojoak.Ikasleak;

public class NireNotenBatezbestekoaJsonera {
    public static void main(String[] args) {
        String strOut = "datuak/NireBatezbestekoa.json";
        JsonIkasleak jsonIkasleak = new JsonIkasleak("", strOut);
        Scanner in = new Scanner(System.in);

        List<Ikaslea> ikZerrenda = new ArrayList<Ikaslea>();
        System.out.print("Nor zara zu? ");
        String ikasleKontua = in.nextLine();
        System.out.print("Zein da zure batezbestekoa? ");
        double bb = in.nextDouble();
        in.close();
        Ikaslea ik1 = new Ikaslea(ikasleKontua, bb);
        ikZerrenda.add(ik1);
        Ikasleak ikasleakObjektua = new Ikasleak();
        ikasleakObjektua.setIkasleak(ikZerrenda);
        int kop = jsonIkasleak.idatzi(ikasleakObjektua);
        if (kop == 1) {
            System.out.println("Zure batezbestekoa " + strOut + " fitxategian aurkituko duzu.");
        }

    }
}
