
public class Cameriere extends Menu {

	Ordine ordine;
	
	public Cameriere() {
		Ordine ordine = new Ordine();
	}

	
	public void aggiungiNellOrdine(Piatto cPiatto) {
		ordine.addPiattoOrdinato(cPiatto);
	}
	
	public void rimuoviNellOrdine(Piatto cPiatto) {
		ordine.removePiattoOrdinato(cPiatto);
	}
	
	public void finalizzaOrdine() {
		Cuoco.addOrdine(ordine);
		ResponsabileDiCassa.addOrdine(ordine);
		ordine.clear();
	}
	
	public void annullaOrdine() {
		ordine = new Ordine();
	}
}
