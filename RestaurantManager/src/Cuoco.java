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
    
    public void cancellaOrdine(Ordine ordine){
        ordini.remove(ordine);    
    }

 
}