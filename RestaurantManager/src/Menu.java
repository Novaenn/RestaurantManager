import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	private ArrayList<Piatto> listaPiatti;
	
	private String fileNameMenu = "MenuCartaceo.txt";
	
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
	
	
	public ArrayList<Piatto> getListaPiatti() {
		return listaPiatti;
	}

	public void addPiattoDalMenu(Piatto mPiatto) {
		listaPiatti.add(mPiatto);
	}
	
	public void addPiatto(Piatto mPiatto) {
		listaPiatti.add(mPiatto);
		creaMenuCartaceo();
	}
	
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
