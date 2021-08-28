public class ResponsabileDiCassa {
	
	private int nScontrino = 1;
	
	public ResponsabileDiCassa(){
		
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
    }

}
