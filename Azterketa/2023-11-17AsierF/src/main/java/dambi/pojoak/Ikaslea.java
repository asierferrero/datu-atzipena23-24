package dambi.pojoak;

public class Ikaslea {
    String ikaslea;    
    double batezbestekoa;
    
    public Ikaslea() {
    }
    public Ikaslea(String ikaslea, double batezbestekoa) {
        this.ikaslea = ikaslea;
        this.batezbestekoa = batezbestekoa;
    }
    public String getIkaslea() {
        return ikaslea;
    }
    public void setIkaslea(String ikaslea) {
        this.ikaslea = ikaslea;
    }
    
    public double getBatezbestekoa() {
        return batezbestekoa;
    }
    public void setBatezbestekoa(double batezbestekoa) {
        this.batezbestekoa = batezbestekoa;
    }
}
