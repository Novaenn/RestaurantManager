
public class TestClass {		
		public static void main(String[] args) {
			Menu Laurea = new Menu();
			Chef Borghese = new Chef(Laurea);
			Cameriere Beppe = new Cameriere();
			Cuoco Gualtiero = new Cuoco();
			ResponsabileDiCassa Jean = new ResponsabileDiCassa();
			Piatto Massaman = new Piatto("Massaman", 69420);
			Ordine Mondiale = new Ordine();
			Scontrino Papiro = new Scontrino("Test Scontrino");

			testaMenu(Laurea, Massaman);
			System.out.println("\n");
			testaChef(Borghese);
			System.out.println("\n");
			testaCuoco(Gualtiero, Mondiale);
			System.out.println("\n");
			testaRespCassa(Jean, Mondiale, Papiro);
		}
		
		public static void testaMenu(Menu Laurea, Piatto Massaman){
			System.out.println("Contenuto menu");
			System.out.println(Laurea.getListaPiatti().toString());
			System.out.println("Aggiunta Piatto Massaman");
			Laurea.addPiatto(Massaman);
			System.out.println(Laurea.getListaPiatti().toString());
			System.out.println("Modifica Piatto Massaman a MassaMan");
			Laurea.modificaNome("MassaMan", "Massaman");
			System.out.println(Laurea.getListaPiatti().toString());
			System.out.println("Rimozione Piatto MassaMan");
			Laurea.removePiatto("MassaMan");
			System.out.println(Laurea.getListaPiatti().toString());
			System.out.println("Modifica Prezzo Carbonara a 12.0€");
			Laurea.modificaPrezzo(12, "Carbonara");
			System.out.println(Laurea.getListaPiatti().toString());
		}

		public static void testaChef(Chef Borghese){
			System.out.println("Contenuto menu");
			System.out.println(Borghese.getMenu().getListaPiatti().toString());
			System.out.println("Aggiungi Piatto Massaman");
			Borghese.aggiungiPiatto("Massaman", 69420);
			System.out.println(Borghese.getMenu().getListaPiatti().toString());
			System.out.println("Modifica Prezzo Massaman in 6942069");
			Borghese.modificaPrezzo(6942069, "Massaman");
			System.out.println(Borghese.getMenu().getListaPiatti().toString());
			System.out.println("Modifica Piatto Massaman a MassaMan");
			Borghese.modificaNome("MassaMan", "Massaman");
			System.out.println("Rimozione Piatto Massaman");
			Borghese.eliminaPiatto("MassaMan");
			System.out.println(Borghese.getMenu().getListaPiatti().toString());
		}

		public static void testaCuoco(Cuoco Gualtiero, Ordine Mondiale){
			System.out.println("Lista Ordini");
			System.out.println(Gualtiero.getOrdini());
			System.out.println("Aggiunta Ordine alla lista");
			Gualtiero.addOrdine(Mondiale);
			System.out.println(Gualtiero.getOrdini());
			System.out.println("Rimozione Ordine dalla lista");
			Gualtiero.cancellaOrdine(Mondiale);
			System.out.println(Gualtiero.getOrdini());
		}

		public static void testaRespCassa(ResponsabileDiCassa Jean, Ordine Mondiale, Scontrino Papiro){
			System.out.println("Lista Ordini da pagare");
			System.out.println(Jean.getOrdiniDaPagare());
			System.out.println("Aggiunta Ordine");
			Jean.addOrdineDaPagare(Mondiale);
			System.out.println(Jean.getOrdiniDaPagare());
			System.out.println("Creazione Scontrino");
			Papiro.stampa("ScontrinoTest.txt");
		}

	}
