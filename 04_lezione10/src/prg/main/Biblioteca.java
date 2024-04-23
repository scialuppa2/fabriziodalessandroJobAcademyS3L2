package prg.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Biblioteca {
	private HashMap<Integer, Book> catalogo;
	private String fileTesto;

	public Biblioteca(String fileTesto) {

		this.catalogo = new HashMap<>();
		this.fileTesto = fileTesto;
	}

	public void aggiungiLibro(int ID, String titolo, String autore) {
		Book libro = new Book(ID, titolo, autore);
		catalogo.put(ID, libro);
		scriviCatalogo();
	}

	public void rimuoviLibro(int ID) {
		catalogo.remove(ID);
		scriviCatalogo();
	}

	public void aggiungiAudioLibro(int ID, String titolo, String autore, double durataMinuti) {
		Audiolibro audiolibro = new Audiolibro(ID, titolo, autore, durataMinuti);
		catalogo.put(ID, audiolibro);
		scriviCatalogo();
	}

	public Book ricercaPerTitolo(String titolo) {
		for (Book libro : catalogo.values()) {
			if (libro.getTitolo().equalsIgnoreCase(titolo)) {
				System.out.println("Libro trovato:");
				System.out.println("Titolo libro: " + libro.getTitolo());
				System.out.println("Autore libro: " + libro.getAutore());
				return libro;
			}
		}
		System.out.println("Nessun libro trovato per il titolo " + titolo);
		return null;
	}

	public Book ricercaPerAutore(String autore) {
		for (Book libro : catalogo.values()) {
			if (libro.getAutore().equals(autore)) {
				System.out.println("Libro trovato:");
				System.out.println("Titolo libro: " + libro.getTitolo());
				System.out.println("Autore libro: " + libro.getAutore());
				return libro;
			}
		}
		System.out.println("Nessun libro trovato per questo autore " + autore);
		return null;
	}

	public void scriviCatalogo() {
		try {

			BufferedWriter br = new BufferedWriter(new FileWriter(fileTesto));
			for (Book libro : catalogo.values()) {
				if(libro instanceof Audiolibro) {
					Audiolibro bookCast = (Audiolibro) libro;
					br.write(bookCast.getID() + "," + bookCast.getAutore() + "," + bookCast.getTitolo() + ","+ bookCast.getDurataMinuti());
					br.newLine();
				} else {
					br.write(libro.getID() + "," + libro.getAutore() + "," + libro.getTitolo());
					br.newLine();
				}
				
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public void leggiCatalogo() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileTesto));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] dati = linea.split(",");
				int ID = Integer.parseInt(dati[0]);
				String titolo = dati[1];
				String autore = dati[2];
				if (dati.length == 4) {
					double durataMinuti = Double.parseDouble(dati[3]);
					catalogo.put(ID, new Audiolibro(ID, titolo, autore, durataMinuti));
					System.out.println(linea);
				} else {
					catalogo.put(ID, new Book(ID, titolo, autore));
					System.out.println(linea);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
