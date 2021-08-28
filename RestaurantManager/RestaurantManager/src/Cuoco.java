import java.util.ArrayList;
//Cuoco --> Visualizza Ordini + Elimina un Ordine scelto.
public class Cuoco {

    ArrayList<Ordine> ordini;

    public Cuoco(Cameriere cameriere){
        ordini = cameriere.visualizzaOrdini();
    }

    public void rimuoviPiattoDaOrdinare(Ordine ordine, Piatto piatto){
        String nomepiatto = piatto.getNome();
        ordine.removePiattoOrdinato(nomepiatto); 
        if (ordine.getPiattiOrdinati().size() == 0){
            ordini.remove(ordine);
        }       
    }

    public void cancellaOrdine(Ordine ordine){
        ordini.remove(ordine);    
    }

}
