import java.util.ArrayList;

public class Cameriere {

	private ArrayList<Ordine> listaOrdini;
	
	public Cameriere() {
		listaOrdini = new ArrayList<>();
	}
	
	public void creaOrdine(Ordine cOrdine) {
		listaOrdini.add(cOrdine);
	}
	
	public void aggiungiNellOrdine(int numeroOrdine, Piatto cPiatto) {
		listaOrdini.get(numeroOrdine).addPiattoOrdinato(cPiatto);
	}
	
	public void rimuoviNellOrdine(int numeroOrdine, int numeroPiatto) {
		listaOrdini.get(numeroOrdine).removePiattoOrdinato(numeroPiatto);
	}
	
}
