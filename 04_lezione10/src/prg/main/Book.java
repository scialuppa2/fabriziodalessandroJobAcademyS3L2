package prg.main;

public class Book {

	private int ID;
	private String titolo;
	private String autore;
	
	public Book (int ID, String titolo, String autore) {
		this.ID = ID;
		this.titolo = titolo;
		this.autore = autore;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	
}
