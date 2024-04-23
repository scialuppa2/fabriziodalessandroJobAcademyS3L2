package prg.main;

public class Audiolibro extends Book {
	public double durataMinuti;

	public Audiolibro(int ID, String titolo, String autore, double durataMinuti) {
		super(ID, titolo, autore);
		this.durataMinuti = durataMinuti;
	}

	public double getDurataMinuti() {
		return durataMinuti;
	}

	public void setDurataMinuti(double durataMinuti) {
		this.durataMinuti = durataMinuti;
	}
	
	

}
