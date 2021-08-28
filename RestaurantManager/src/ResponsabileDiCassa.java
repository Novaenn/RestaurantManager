import java.util.ArrayList;

public class ResponsabileDiCassa {
	
	private int counter = 1;
	
	public ResponsabileDiCassa() {
		
	}
	
	public String creaFileName() {
		String nome = "Scontrino #"+String.valueOf(counter)+".txt";
		counter++;
		return nome;
	}
	
    public void creaScontrino(Ordine ordine){
        String testo = ordine.formattaOrdine();
        Scontrino scontry = new Scontrino(testo);
        scontry.stampa(creaFileName());
    }

}
