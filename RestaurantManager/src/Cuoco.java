import java.util.ArrayList;
//Cuoco --> Visualizza Ordini + Elimina un Ordine scelto.
public class Cuoco {

    static ArrayList<Ordine> ordini;

    public Cuoco(Cameriere cameriere){
        ordini = new ArrayList();
    }
    
    public static void addOrdine(Ordine ord) {
    	ordini.add(ord);
    }

    public void rimuoviPiattoOrdinato(Ordine ordine, Piatto piatto){
        String nomepiatto = piatto.getNome();
        ordine.removePiattoOrdinato(piatto); 
        if (ordine.getPiattiOrdinati().size() == 0){
            ordini.remove(ordine);
        }       
    }

    public void cancellaOrdine(Ordine ordine){
        ordini.remove(ordine);    
    }

}