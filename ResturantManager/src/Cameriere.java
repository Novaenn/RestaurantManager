
public class Cameriere {

	Ordine ordine;
	
	public Cameriere() {
		ordine = new Ordine();
	}

	public void aggiungiNellOrdine(Piatto cPiatto) {
		ordine.addPiattoOrdinato(cPiatto);
	}
	
	public void rimuoviNellOrdine(Piatto cPiatto) {
		ordine.removePiattoOrdinato(cPiatto);
	}
	
	public void finalizzaOrdine() {
		//System.out.println(ordine.toString());
		ordine.clear();
	}
	
	public void annullaOrdine() {
		ordine = new Ordine();
	}
}
