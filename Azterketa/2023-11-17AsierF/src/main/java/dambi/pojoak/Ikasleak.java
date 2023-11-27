package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

public class Ikasleak {
    List<Ikaslea> ikasleak;

    public List<Ikaslea> getIkasleak() {
        return ikasleak;
    }

    public void setIkasleak(List<Ikaslea> ikasleak) {
        this.ikasleak = ikasleak;
    }

    public void add(Ikaslea ikaslea) {
        if (this.ikasleak == null) {
            this.ikasleak = new ArrayList<Ikaslea>();
        }
        this.ikasleak.add(ikaslea);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Ikaslea i : this.ikasleak) {
            str.append(i.toString());
            str.append("\n");
        }
        return str.toString();
    }
}
