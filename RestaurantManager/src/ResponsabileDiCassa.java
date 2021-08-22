public class ResponsabileDiCassa {
	
	private static int nScontrino = 1;
	
	public static String creaFileName() {
		String nome = "Scontrino #"+String.valueOf(nScontrino)+".txt";
		nScontrino++;
		return nome;
	}
	
    public static void creaScontrino(Ordine ordine){
        String testo = ordine.formattaOrdine();
        Scontrino scontry = new Scontrino(testo);
        scontry.stampa(creaFileName());
    }

}
