
public class Chef {
	
	private Menu mMenu;
	
	public Chef(Menu cMenu) {
		mMenu =  cMenu;
	}
	
	public Menu getMenu() {
		return this.mMenu;
	}
	
	public void aggiungiPiatto(String nomePiatto, float prezzoPiatto) {
		mMenu.addPiatto(new Piatto(nomePiatto, prezzoPiatto));
	}

	public void eliminaPiatto(String nomePiatto) {
		mMenu.removePiatto(nomePiatto);
	}
	
	public void modificaNome(String newName, String nomePiatto) {
		mMenu.modificaNome(newName, nomePiatto);
	}
	
	public void modificaPrezzo(float prezzoPiatto, String nomePiatto) {
		mMenu.modificaPrezzo(prezzoPiatto, nomePiatto);
	}
	
	public String stampa() {
		return mMenu.formattaMenu();
	}
}
