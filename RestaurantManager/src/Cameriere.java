/**
 * Classe rappresentante il lavoro di un cameriere
 * @author Samuele Bella & Francesco De Persio
 *
 */
public class Cameriere {

	/**
	 * Ordine gestito dal cameriere
	 */
	Ordine ordine;
	
	public Cameriere() {
		ordine = new Ordine();
	}

	/**
	 * Aggiunge un'istanza della classe Piatto all'ordine
	 * @param cPiatto Piatto da inserire
	 */
	public void aggiungiNellOrdine(Piatto cPiatto) {
		ordine.addPiattoOrdinato(cPiatto);
	}
	
	/**
	 * Rimuove un'istanza della classe Piatto all'ordine
	 * @param cPiatto Piatto da eliminare 
	 */
	public void rimuoviNellOrdine(Piatto cPiatto) {
		ordine.removePiattoOrdinato(cPiatto);
	}
	
	/**
	 * Conferma l'ordine e prepara una nuova istanza per il prossimo
	 */
	public void finalizzaOrdine() {
		//System.out.println(ordine.toString());
		ordine.clear();
	}
	
	/**
	 * Annulla l'ordine e prepara una nuova istanza per il prossimo
	 */
	public void annullaOrdine() {
		ordine = new Ordine();
	}
}
