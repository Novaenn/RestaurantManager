import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Menu {
	
	private ArrayList<Piatto> listaPiatti;
	
	private String fileNameMenu = "MenuCartaceo.txt";
	
	public Menu() {
		listaPiatti = new ArrayList<>();
	}
	
	
	public ArrayList<Piatto> getListaPiatti() {
		return listaPiatti;
	}

	public void setListaPiatti(ArrayList<Piatto> listaPiatti) {
		this.listaPiatti = listaPiatti;
	} 
	
	public void addPiatto(Piatto mPiatto) {
		listaPiatti.add(mPiatto);
		creaMenuCartaceo();
	}
	
	public void removePiatto(String nomePiatto) {
		for (int i = 0; i < listaPiatti.size(); i++) {
			if (listaPiatti.get(i).getNome() == nomePiatto) {
				listaPiatti.remove(i);
			}
		}
		creaMenuCartaceo();
	}
	
	public void modificaNome(String newNome, String nomePiatto) {
		for (int i = 0; i < listaPiatti.size(); i++) {
			if (listaPiatti.get(i).getNome() == nomePiatto) {
				listaPiatti.get(i).setNome(newNome);
			}
		}
		creaMenuCartaceo();
	}

	public void modificaPrezzo(float newPrezzo, String nomePiatto) {
		for (int i = 0; i < listaPiatti.size(); i++) {
			if (listaPiatti.get(i).getNome() == nomePiatto) {
				listaPiatti.get(i).setPrezzo(newPrezzo);
			}
		}
		creaMenuCartaceo();
	}
	
	public String formattaMenu() {
		String stringaMenu = "";
		for (int i = 0; i < listaPiatti.size(); i++) {
			stringaMenu +=String.format("%-25s %5.2f", listaPiatti.get(i).getNome(), listaPiatti.get(i).getPrezzo());	
			stringaMenu += " €";
			stringaMenu += "\n";
		}
		stringaMenu += "\n";
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
