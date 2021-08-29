
public class Chef {
	
	private Menu cMenu;
	
	public Chef() {
		Menu cMenu = new Menu();
	}
	
	public void aggiungiPiatto(String nomePiatto, float prezzoPiatto) {
		cMenu.addPiatto(new Piatto(nomePiatto, prezzoPiatto));
	}

	public void eliminaPiatto(String nomePiatto) {
		cMenu.removePiatto(nomePiatto);
	}
	
	public void modificaNome(String newName, String nomePiatto) {
		cMenu.modificaNome(newName, nomePiatto);
	}
	
	public void modificaPrezzo(float prezzoPiatto, String nomePiatto) {
		cMenu.modificaPrezzo(prezzoPiatto, nomePiatto);
	}
	
}
