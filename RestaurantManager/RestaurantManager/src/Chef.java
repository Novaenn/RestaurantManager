
public class Chef {
	
	private Menu cMenu;
	
	public Chef() {
		Menu cMenu = new Menu();
	}
	
	public void aggiungiPiatto(String nomePiatto, float prezzoPiatto) {
		cMenu.addPiatto(new Piatto(nomePiatto, prezzoPiatto));
	}

	public void eliminaPiatto(int numeroPiatto) {
		cMenu.removePiatto(numeroPiatto);
	}
	
	public void modificaNome(String nomePiatto, int numeroPiatto) {
		cMenu.modificaNome(nomePiatto, numeroPiatto);
	}
	
	public void modificaPrezzo(float prezzoPiatto, int numeroPiatto) {
		cMenu.modificaPrezzo(prezzoPiatto, numeroPiatto);
	}
	
}
