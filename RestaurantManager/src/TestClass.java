
public class TestClass {
		
		private static int counter = 1;
		
		public static void main(String[] args) {
			System.out.println(TestClass.creaFileName());
			System.out.println(TestClass.creaFileName());
			System.out.println(TestClass.creaFileName());
			System.out.println(TestClass.creaFileName());
			System.out.println(TestClass.creaFileName());
		}
		
		
		
		public static String creaFileName() {
			String nome = "Scontrino #"+String.valueOf(TestClass.counter)+".txt";
			counter++;
			return nome;
		}
}
