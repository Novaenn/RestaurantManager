import java.util.ArrayList;

public class ResponsabileDiCassa {
	
	private static int counter = 1;
	
	public static String creaFileName() {
		String nome = "Scontrino #"+String.valueOf(counter)+".txt";
		counter++;
		return nome;
	}
	
    public static void creaScontrino(Ordine ordine){
        String testo = ordine.formattaOrdine();
        Scontrino scontry = new Scontrino(testo);
        scontry.stampa(creaFileName());
    }

}
