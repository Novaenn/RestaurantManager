import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe dedicata alla gestione di un menu
 * @author Samuele Bella & Francesco De Persio
 *
 */
public class Menu {
	
	/**
	 * Lista di piatti presenti nel menu
	 */
	private ArrayList<Piatto> listaPiatti;
	
	/**
	 * Nome del file .txt contenente il menu
	 */
	private String fileNameMenu = "MenuCartaceo.txt";
	
	/**
	 * 
	 */
	public Menu() {
		listaPiatti = new ArrayList<>();
		String riga = "";
		try {
			Scanner fileIn = new Scanner(new File(fileNameMenu));
		    while (fileIn.hasNextLine()) {
		        riga = fileIn.nextLine();
		        int k = 0;
		        String nome = "";
		        String prezzo = "";
		        while (!Character.isDigit(riga.charAt(k))) {
		        	k++;
		        }
		        nome = riga.substring(0, k-1);
		        
		        while (Character.isDigit(riga.charAt(k))) {
		        	prezzo += String.valueOf(riga.charAt(k));
		        	k++;
		    	}
		        k++;
		        prezzo += ".";
		        while (Character.isDigit(riga.charAt(k))) {
		        	prezzo += String.valueOf(riga.charAt(k));
		        	k++;
		    	}
		        this.addPiattoDalMenu(new Piatto(nome, Float.valueOf(prezzo)));
		        
		    }
		    fileIn.close();
		}
		
        catch (IOException e) {
        	e.getMessage();		
		}
	}
	
	/**
	 * Ritorna la lista di piatti presenti nel menu
	 * @return Lista di piatti
	 */
	public ArrayList<Piatto> getListaPiatti() {
		return listaPiatti;
	}

	/**
	 * Aggiunge un'istanza della classe Piatto all'ArrayList "listaPiatti"
	 * @param mPiatto Piatto da aggiungere
	 */
	public void addPiattoDalMenu(Piatto mPiatto) {
		listaPiatti.add(mPiatto);
	}
	
	/**
	 * Aggiunge un'istanza della classe Piatto all'ArrayList "listaPiatti" ricreando il file .txt del menu
	 * @param mPiatto Piatto da aggiungere
	 */
	public void addPiatto(Piatto mPiatto) {
		listaPiatti.add(mPiatto);
		creaMenuCartaceo();
	}
	
	/**
	 * Rimuove un'istanza della classe Piatto dall'ArrayList "listaPiatti" ricreando il file .txt del menu
	 * @param nomePiatto Nome del piatto da eliminare
	 */
	public void removePiatto(String nomePiatto) {
		boolean done = false;
		for (int i = 0; i < listaPiatti.size(); i++) {
			if (listaPiatti.get(i).getNome().equals(nomePiatto)) {
				listaPiatti.remove(i);
				creaMenuCartaceo();
				done = true;
			}	
		}
		if (done == false) {
			ErrorGUI.main(new String[0]);
		}
		
	}
	
	/**
	 * Modifica l'attributo nome di un'istanza della classe Piatto contenuta nell'ArrayList "listaPiatti"
	 * @param newNome Nuovo nome del piatto
	 * @param nomePiatto Vecchio nome del piatto
	 */
	public void modificaNome(String newNome, String nomePiatto) {
		boolean done = false;
		for (int i = 0; i < listaPiatti.size(); i++) {
			if (listaPiatti.get(i).getNome().equals(nomePiatto)) {
				listaPiatti.get(i).setNome(newNome);
				creaMenuCartaceo();
				done = true;
			}
		}
		if (done == false) {
			ErrorGUI.main(new String[0]);
		}
	}

	/**
	 * Modifica l'attributo prezzo di un'istanza della classe Piatto contenuta nell'ArrayList "listaPiatti"
	 * @param newPrezzo Valore del nuovo prezzo
	 * @param nomePiatto Nome del piatto
	 */
	public void modificaPrezzo(float newPrezzo, String nomePiatto) {
		boolean done = false;
		for (int i = 0; i < listaPiatti.size(); i++) {
			if (listaPiatti.get(i).getNome().equals(nomePiatto)) {
				listaPiatti.get(i).setPrezzo(newPrezzo);
				creaMenuCartaceo();
				done = true;
			}
		}
		if (done == false) {
			ErrorGUI.main(new String[0]);
		}
	}
	
	/**
	 * Crea la stringa da scrivere nel file .txt del menu
	 * @return Contenuto del file .txt del menu
	 */
	public String formattaMenu() {
		String stringaMenu = "";
		for (int i = 0; i < listaPiatti.size(); i++) {
			stringaMenu += listaPiatti.get(i).getNome() + " " + listaPiatti.get(i).getPrezzo() + " �";
			if (i!= listaPiatti.size()-1) {
				stringaMenu += "\n";
			}
		}
		return stringaMenu;
		}
	
	/**
	 * Crea il file .txt del menu
	 */
	public void creaMenuCartaceo() {
		String fileName = fileNameMenu;
		try {
    		File file = new File(fileName);
    		PrintWriter fileOutput = new PrintWriter(fileName);
    		fileOutput.println(formattaMenu());
    		fileOutput.close();
    	}
    	catch(IOException e) {
    		System.out.println("Errore di Sistema.");
    	}
	}
	
}
