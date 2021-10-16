import java.util.ArrayList;

public class ResponsabileDiCassa {
	
	private int nScontrino = 1;
	
	 private ArrayList<Ordine> ordiniDaPagare;
	
	public ResponsabileDiCassa() {
		ordiniDaPagare = new ArrayList<>();
	}
	
	public void addOrdine(Ordine ord) {
		ordiniDaPagare.add(ord);
    }
	
	public String creaFileName() {
		String nome = "Scontrino #"+String.valueOf(nScontrino)+".txt";
		nScontrino++;
		return nome;
	}
	
    public void creaScontrino(Ordine ordine){
        String testo = ordine.formattaOrdine();
        Scontrino scontry = new Scontrino(testo);
        scontry.stampa(creaFileName());
        ordiniDaPagare.remove(ordine);
    }

}
