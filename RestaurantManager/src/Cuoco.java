import java.util.ArrayList;

/**
 * Classe rappresentante il lavoro di un cuoco
 * @author Samuele Bella & Francesco De Persio
 *
 */
public class Cuoco {

	/**
	 * ArrayList di ordini finalizzati
	 */
    private ArrayList<Ordine> ordini;

    public Cuoco(){
        ordini = new ArrayList();
    }
    
    /**
     * Aggiunge un'istanza della classe Ordine all'ArrayList "ordini"
     * @param ord Ordine finalizzato da aggiungere
     */
    public void addOrdine(Ordine ord) {
    	ordini.add(ord);
    }

    /**
     * Ritorna l'ArrayList di ordini
     * @return Lista di ordini
     */
    public ArrayList<Ordine> getOrdini() {
    	return ordini;
    }
    
    /**
     * Cancella un'istanza della classe Ordine dall'ArrayList "ordini"
     * @param ordine Ordine da cancellare
     */
    public void cancellaOrdine(Ordine ordine){
        ordini.remove(ordine);    
    }

 
}