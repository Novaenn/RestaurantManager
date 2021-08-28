import java.util.ArrayList;

//AGGIUNGI ORDINE FINALIZZATO
public class Cameriere {

	ArrayList<Ordine> listaOrdini;
	
	public Cameriere() {
		listaOrdini = new ArrayList<>();
	}
	
	public void creaOrdine(Ordine cOrdine) {
		listaOrdini.add(cOrdine);
	}

	public void rimuoviOrdine(Ordine cOrdine) {
		listaOrdini.remove(cOrdine);
	}
	
	public void aggiungiNellOrdine(int numeroOrdine, Piatto cPiatto, int quantita) {
		while (quantita != 0){
			listaOrdini.get(numeroOrdine).addPiattoOrdinato(cPiatto);
			quantita--;
		}
	}
	
	public void rimuoviNellOrdine(int numeroOrdine, int numeroPiatto) {
		listaOrdini.get(numeroOrdine).removePiattoOrdinato(numeroPiatto);
	}
	
	public ArrayList<Ordine> visualizzaOrdini(){
		return listaOrdini;
	}

}
