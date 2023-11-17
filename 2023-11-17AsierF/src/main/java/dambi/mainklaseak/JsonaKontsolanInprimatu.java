package dambi.mainklaseak;

import dambi.atzipenekoak.JsonNotak;
import dambi.pojoak.Notak;

/**
 * Programa hau ez aldatu!!!
 * Exekutatzerakoan zera inprimatu behar du kontsolatik:
 *   Nota[1, agirrezabala.peru, 2022-02-28, program, 5]
 *   Nota[2, arceredillo.adrian, 2022-02-28, program, 6]
 *   Nota[3, arginzoniz.joseba, 2022-02-28, program, 7]
 *   ...
 * 
 * Aldatu beharko duzuna, zera da JsonaIrakurri metodoa.
 */
public class JsonaKontsolanInprimatu {
    public static void main(String[] args) {
        JsonNotak jsona= new JsonNotak("datuak/Notak.json");
        Notak notak = jsona.irakurri();
        System.out.println(notak);
    }
}
