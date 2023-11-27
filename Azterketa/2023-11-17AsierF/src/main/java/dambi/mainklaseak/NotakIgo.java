package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

/**
 * Datu-iturria: Notak.csv
 * Sortutako fitxategia: NotaHobetuak.xml
 * Programa honek nota guztiak puntu bat igoko ditu,
 * kontutan izanik notarik altuena 10 dela.
 * 
 */
public class NotakIgo {
  public static void main(String[] args) {
    Notak notak = new Notak();
    Notak notakIgota = new Notak();

    Csva csv = new Csva("datuak/Notak.csv", "");
    Xmla xml = new Xmla("", "datuak/NotaHobetuak.xml");

    notak = csv.irakurri();
    if (notak != null) {
      for (Nota n : notak.getNotak()) {
        if (n.getNota() <= 9) {
          n.setNota(n.getNota() + 1);
          notakIgota.add(n);
        } else if (n.getNota() >= 9) {
          n.setNota(n.getNota() + (10 - n.getNota()));
          notakIgota.add(n);
        }
      }
    }
    xml.idatzi(notakIgota);
    int kopurua = notak.getNotak().size();
    System.out.println(kopurua + " nota idatzi dira xml fitxategian.");

  }
}