import java.util.ArrayList;

public class ResponsabileDiCassa {
	
	 private ArrayList<Ordine> ordiniDaPagare;
	
	public ResponsabileDiCassa() {
		ordiniDaPagare = new ArrayList<>();
	}
	
	public ArrayList<Ordine> getOrdiniDaPagare() {
		return ordiniDaPagare;
	}
	
	public void addOrdineDaPagare(Ordine ord) {
		ordiniDaPagare.add(ord);
    }
	
	public String creaFileName(Ordine ord) {
		String nome = "Scontrino #"+String.valueOf(ord.getNum())+".txt";
		return nome;
	}
	
    public void creaScontrino(Ordine ordine){
        ordine.paper.stampa(creaFileName(ordine));
        ordiniDaPagare.remove(ordine);
    }

}
