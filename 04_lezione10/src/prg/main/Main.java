package prg.main;

import java.util.Scanner;

// createmi un sistema per gestire una biblioteca. 
// Ogni libro è identificato da un ID univoco e ha un titolo e un autore

// Obiettivi:
// 1) leggere i dati dei libri contenuti in un file di testo(id, nome e autore) separati da virgola
// 2) salvare i dati in un hashmap(ID sarà chiave e dovrete creare un oggetto book che sarà il valore)
// 3) implementare metodi per aggiunger e rimuovere i libri dal file e dall'hashmap
// quindi al termine di ogni modifica bisognerà modificare il file di testo con i nuovi dati
// quindi sono da implementare la classe Book, la classe Biblioteca e il main che gestisce le operazioni

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biblioteca catalogoLibri = new Biblioteca("catalogo.txt");
		Scanner scanner = new Scanner(System.in);
		int scelta;

		System.out.println("\r\n"
				+ " /$$$$$$$  /$$$$$$ /$$$$$$$  /$$       /$$$$$$  /$$$$$$  /$$$$$$$$ /$$$$$$$$  /$$$$$$   /$$$$$$ \r\n"
				+ "| $$__  $$|_  $$_/| $$__  $$| $$      |_  $$_/ /$$__  $$|__  $$__/| $$_____/ /$$__  $$ /$$__  $$\r\n"
				+ "| $$  \\ $$  | $$  | $$  \\ $$| $$        | $$  | $$  \\ $$   | $$   | $$      | $$  \\__/| $$  \\ $$\r\n"
				+ "| $$$$$$$   | $$  | $$$$$$$ | $$        | $$  | $$  | $$   | $$   | $$$$$   | $$      | $$$$$$$$\r\n"
				+ "| $$__  $$  | $$  | $$__  $$| $$        | $$  | $$  | $$   | $$   | $$__/   | $$      | $$__  $$\r\n"
				+ "| $$  \\ $$  | $$  | $$  \\ $$| $$        | $$  | $$  | $$   | $$   | $$      | $$    $$| $$  | $$\r\n"
				+ "| $$$$$$$/ /$$$$$$| $$$$$$$/| $$$$$$$$ /$$$$$$|  $$$$$$/   | $$   | $$$$$$$$|  $$$$$$/| $$  | $$\r\n"
				+ "|_______/ |______/|_______/ |________/|______/ \\______/    |__/   |________/ \\______/ |__/  |__/\r\n"
				+ "                                                                                                \r\n"
				+ "                                                                                                \r\n"
				+ "                                                                                                \r\n"
				+ "");
    do {
    System.out.println("=================");
    System.out.println("M  E  N  U");
    System.out.println("=================");
    System.out.println("Seleziona: \n");
    System.out.println(" 1  Per stampare la lista");
    System.out.println(" 2  Per aggiungere un libro");
    System.out.println(" 3  Per eliminare un libro");
    System.out.println(" 0  Per uscire");
    
    
		
    	scelta = scanner.nextInt();
    	
		switch(scelta) {
		case 1: System.out.println("Catalogo dei libri");
		        catalogoLibri.leggiCatalogo();
		        break;
			
		case 2: System.out.println("=============================");
			    System.out.println("Aggiungi un libro al catalogo");
		        System.out.println("=============================");

		        System.out.println("Inserisci il numero chiave: ");
		        int chiaveIdAdd = scanner.nextInt();
		        scanner.nextLine();
		        
		        System.out.println("Inserisci il titolo: ");
		        String titoloLibro = scanner.nextLine();
		        
		        System.out.println("Inserisci l'autore: ");
		        String autoreLibro = scanner.nextLine();
		        
		        catalogoLibri.aggiungiLibro(chiaveIdAdd, titoloLibro, autoreLibro);
			    break;
			    
		case 3: System.out.println("Elimina un libro nel catalogo");
		        System.out.println("Inserisci il titolo del libro che vuoi eliminare: ");
		        String eliminaLibro = scanner.nextLine();
		        catalogoLibri.ricercaPerTitolo(eliminaLibro);
		        System.out.println("Sei sicuro di volerlo eliminare?");
		        break;
			
		case 0: System.out.println("Grazie e arrivederci");
		        break;
		        
		default:	
			System.out.println("Opzione non valida, riprova!");
			scanner.close();
			return;
		}
    }while(scelta !=0) ;
		
	
    }

    
   

	}


