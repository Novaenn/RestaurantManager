import java.util.ArrayList;

public class Ordine {

	private int num = 0;
	
	protected Scontrino paper;
		
	private float tot = 0;
	
	private int prezzoTot;
	
	private ArrayList<Piatto> piattiOrdinati;
	
	public Ordine() {
		paper = new Scontrino("");
		num++;
		prezzoTot = 0;
		piattiOrdinati = new ArrayList<>();
	}
	
	//public void creaScontrino() {
	//	paper.generaScontrino(piattiOrdinati);
	//		
	//}
	
	public void addPiattoOrdinato(Piatto nPiatto) {
		piattiOrdinati.add(nPiatto);
		prezzoTot += nPiatto.getPrezzo();
	}
	
	public void addPiattoScontrino(Piatto nPiatto) {
		
		paper.aggiungiRiga(paper.formattaRiga(nPiatto));
		tot += nPiatto.getPrezzo();
		if (piattiOrdinati.size() == 1) {
			String stringa = "--------------------------------------\n"
	    			+ String.format("Totale:%24.2f ", tot);
			paper.aggiungiRiga(stringa);
		}
	}
	
	public void removePiattoOrdinato(Piatto nPiatto) {
		piattiOrdinati.remove(nPiatto);
		prezzoTot -= nPiatto.getPrezzo();
	}
	
	public float getPrezzoTot() {
		return prezzoTot;
	}

	public int getNum() {
		return num;
	}
	
	public void setNum(int numero) {
		num = numero;
	}

	public ArrayList<Piatto> getPiattiOrdinati() {
		return piattiOrdinati;
	}
	
	public void clear() {
		num++;
		prezzoTot = 0;
		piattiOrdinati = new ArrayList<>();
	}

	public String toString() {
		return "Ordine #"+String.valueOf(num);
		
	}
	
}
