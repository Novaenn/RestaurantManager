import java.util.ArrayList;

/**
 * Classe rappresentate un ordine
 * @author Samuele Bella & Francesco De Persio
 *
 */
public class Ordine {

	/**
	 * Numero intero identifictivo dell'ordine
	 */
	private int num = 0;
	
	/**
	 * Istanza della classe Scontrino relativo all'ordine
	 */
	protected Scontrino paper;
		
	/**
	 * Numero float per il totale del prezzo dei piatti ordinati
	 */
	private float tot = 0;
	
	/**
	 * Numero intero per il totale del prezzo dei piatti ordinati
	 */
	private int prezzoTot;
	
	/**
	 * ArrayList dei piatti ordinati
	 */
	private ArrayList<Piatto> piattiOrdinati;
	
	public Ordine() {
		paper = new Scontrino("");
		num++;
		prezzoTot = 0;
		piattiOrdinati = new ArrayList<>();
	}
	
	/**
	 * Aggiunge un'istanza della classe Piatto ordinato all'ArrayList "piattiOrdinati"
	 * @param nPiatto Piatto ordinato da aggiungere
	 */
	public void addPiattoOrdinato(Piatto nPiatto) {
		piattiOrdinati.add(nPiatto);
		prezzoTot += nPiatto.getPrezzo();
	}
	
	/**
	 * Aggiunge un piatto ordinato sullo scontrino
	 * @param nPiatto Piatto ordinato da aggiungere
	 */
	public void addPiattoScontrino(Piatto nPiatto) {
		paper.aggiungiRiga(paper.formattaRiga(nPiatto));
		tot += nPiatto.getPrezzo();
		if (piattiOrdinati.size() == 1) {
			String stringa = "--------------------------------------\n"
	    			+ String.format("Totale:%24.2f ", tot);
			paper.aggiungiRiga(stringa);
		}
	}
	
	/**
	 * Rimuove un'istanza della classe Piatto dall'ArrayList "piattiOrdinati"
	 * @param nPiatto Piatto da rimuovere
	 */
	public void removePiattoOrdinato(Piatto nPiatto) {
		piattiOrdinati.remove(nPiatto);
		prezzoTot -= nPiatto.getPrezzo();
	}
	
	/**
	 * Ritorna il valore finale del prezzo dell'ordine intero
	 * @return Prezzo finale dell'ordine intero
	 */
	public float getPrezzoTot() {
		return prezzoTot;
	}

	/**
	 * Ritorna il numero identificativo dell'ordine
	 * @return Numero identificativo dell'ordine
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * Setta il numero identificativo dell'ordine
	 * @param numero
	 */
	public void setNum(int numero) {
		num = numero;
	}

	/**
	 * Ritorna l'ArrayList di piatti ordinati
	 * @return ArrayList di piatti ordinati
	 */
	public ArrayList<Piatto> getPiattiOrdinati() {
		return piattiOrdinati;
	}
	
	/**
	 * Resetta totalmente l'ordine
	 */
	public void clear() {
		num++;
		prezzoTot = 0;
		piattiOrdinati = new ArrayList<>();
	}

	public String toString() {
		return "Ordine #"+String.valueOf(num);
		
	}
	
}
