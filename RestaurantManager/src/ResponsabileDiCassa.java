import java.util.ArrayList;

/**
 *  Classe rappresentante il lavoro di un Responsabile di cassa
 * @author Samuele Bella & Francesco De Persio
 *
 */
public class ResponsabileDiCassa {
	
	/**
	 * ArrayList di ordini da pagare
	 */
	 private ArrayList<Ordine> ordiniDaPagare;
	
	public ResponsabileDiCassa() {
		ordiniDaPagare = new ArrayList<>();
	}
	
	/**
	 * Ritorna l'ArrayList di ordini da pagare
	 * @return Ordini da pagare
	 */
	public ArrayList<Ordine> getOrdiniDaPagare() {
		return ordiniDaPagare;
	}
	
	/**
	 * Aggiunge un'istanza della classe Ordine all'ArrayList "ordiniDaPagare"
	 * @param ord Ordine da pagare
	 */
	public void addOrdineDaPagare(Ordine ord) {
		ordiniDaPagare.add(ord);
    }
	
	/**
	 * Ritorna il nome da dare al file .txt dello scontrino relativo ad un ordine
	 * @param ord Ordine di cui vogliamo lo scontrino
	 * @return Nome del file
	 */
	public String creaFileName(Ordine ord) {
		String nome = "Scontrino #"+String.valueOf(ord.getNum())+".txt";
		return nome;
	}
	
	/**
	 * Crea il file .txt dello scontrino relativo ad un ordine
	 * @param ordine Ordine di cui vogliamo lo scontrino
	 */
    public void creaScontrino(Ordine ordine){
        ordine.paper.stampa(creaFileName(ordine));
        ordiniDaPagare.remove(ordine);
    }

}
