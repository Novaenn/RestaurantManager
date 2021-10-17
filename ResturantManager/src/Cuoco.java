import java.util.ArrayList;
//Cuoco --> Visualizza Ordini + Elimina un Ordine scelto.
public class Cuoco {

    private ArrayList<Ordine> ordini;

    public Cuoco(){
        ordini = new ArrayList();
    }
    
    public void addOrdine(Ordine ord) {
    	ordini.add(ord);
    }

    public ArrayList<Ordine> getOrdini() {
    	return ordini;
    }
    
    public void rimuoviPiattoOrdinato(Ordine ordine, Piatto piatto){
        ordine.removePiattoOrdinato(piatto); 
        if (ordine.getPiattiOrdinati().size() == 0){
            ordini.remove(ordine);
        }       
    }

    public void cancellaOrdine(Ordine ordine){
        ordini.remove(ordine);    
    }

 
}