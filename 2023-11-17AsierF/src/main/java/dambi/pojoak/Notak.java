package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import dambi.atzipenekoak.Csva;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Notak")
public class Notak {
    List<Nota> notak;

    public List<Nota> getNotak() {
        return notak;
    }

    @XmlElement(name = "Nota")
    public void setNotak(List<Nota> notak) {
        this.notak = notak;
    }

    public void add(Nota nota) {
        if (this.notak == null) {
            this.notak = new ArrayList<Nota>();
        }
        this.notak.add(nota);

    }

    /**
     * Hau da erabili dezakezun algoritmoetako bat:
     * Zera errepikatu noten zerrenda hutsik egon arte:
     * - Noten zerrendako "lehen" ikaslea hartu, bere datuak hasieratuz (batura,
     * countadorea)
     * eta zerrenda errebisatu atzenerarte bere noten bila.
     * - Bere nota bat aurkitutakoan batu, zenbatu eta aurkitutako nota ezabatu
     * egingo dugu traba egin ez dezan
     * - Azken notara heltzerakoan, ikasleen zerrendan gehitu eta berriz hasi.
     * 
     */
    public Ikasleak getIkasleenBB() {
        Ikasleak ikasleak = new Ikasleak();

        Csva csva = new Csva("datuak/Notak.csv");
        Notak notak = new Notak();
        ArrayList<String> ikasleKalk = new ArrayList<String>();

        Boolean ikasleaExists = false;
        int count = 0;
        String izena;
        Double bbnota = 0.0;
        Double notaSum = 0.0;

        notak = csva.irakurri();

        for (int i = 0; i < notak.getNotak().size(); i++) {
            izena = notak.getNotak().get(i).getIkaslea();
            for (int j = 0; j < ikasleKalk.size(); j++) {
                if (ikasleKalk.get(j).equals(izena)) {
                    ikasleaExists = true;
                    break;
                }
            }
            if (!ikasleaExists) {
                ikasleKalk.add(izena);
                for (Nota m : notak.getNotak()) {
                    if (m.getIkaslea().equals(izena)) {
                        notaSum = notaSum + m.getNota();
                        count++;
                    }
                }
                if (count != 0) {
                    bbnota = notaSum / count;
                    ikasleak.add(new Ikaslea(izena, bbnota));
                }
            }
        }
        return ikasleak;
    }

    /**
     * Ikasle baten nota guztien batezbestekoa kalkulatzen du.
     * 
     * @param ikaslea Adibidez, madariaga.idoia
     * @return Ikaslea motako objektu bat, atributo bezala batezbestekoa kalkulatuta
     *         daukana.
     */
    public Ikaslea getIkaslearenBB(String strIkaslea) {
        int guztira = 0;// ikasleari dagozkion noten batura joango gara gehitzen hemen
        int notaKopurua = 0;// ikasle honi dagazkion nota kopurua joango gara countatzen hemen
        for (Nota n : notak) {
            if (n.getIkaslea().equals(strIkaslea)) {
                guztira += n.getNota();
                notaKopurua++;
            }
        }
        return new Ikaslea(strIkaslea, guztira / notaKopurua);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Nota n : this.notak) {
            str.append(n.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
