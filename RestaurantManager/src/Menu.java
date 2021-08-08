import java.util.ArrayList;

public class Menu {
	
	private ArrayList<Piatto> listaPiatti;
	
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
	}
	
	public void removePiatto(int numero) {
		listaPiatti.remove(numero);
	}
	
	public void modificaNome(String newNome, int pNumero) {
		listaPiatti.get(pNumero).setNome(newNome);
	}

	public void modificaPrezzo(float newPrezzo, int pNumero) {
		listaPiatti.get(pNumero).setPrezzo(newPrezzo);
	}
	
}
