package dambi.accessingmongoumeak.model;

import java.util.List;

import org.bson.types.ObjectId;

public class Umea {

	private ObjectId id; // Berdin ei da id zein _id jarri (Eta eremu hau ez erabiltzea be aukera bat da)
	private String izena;
	private List<String> opariak;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public List<String> getOpariak() {
		return opariak;
	}

	public void setOpariak(List<String> opariak) {
		this.opariak = opariak;
	}

	@Override
	public String toString() {
		return "Umea [izena=" + izena + ", opariak=" + opariak + "]";
	}

}
