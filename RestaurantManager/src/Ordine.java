import java.util.ArrayList;

public class Ordine {

	private int prezzoTot;
	
	private ArrayList<Piatto> piattiOrdinati;
	
	public Ordine() {
		prezzoTot = 0;
		piattiOrdinati = new ArrayList<>();
	}

	public void addPiattoOrdinato(Piatto nPiatto) {
		piattiOrdinati.add(nPiatto);
		prezzoTot += nPiatto.getPrezzo();
	}
	
	public void removePiattoOrdinato(int numero) {
		piattiOrdinati.remove(numero);
		prezzoTot -= piattiOrdinati.get(numero).getPrezzo();
	}
	
	public int getPrezzoTot() {
		return prezzoTot;
	}

	public void setPrezzoTot(int prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	public ArrayList<Piatto> getPiattiOrdinati() {
		return piattiOrdinati;
	}

	public void setPiattiOrdinati(ArrayList<Piatto> piattiOrdinati) {
		this.piattiOrdinati = piattiOrdinati;
	}
	
}
