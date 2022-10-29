public class Cores{
  public void imprimirAzul(String texto){
    System.out.println("\u001B[34m" + " " + texto + " " + "\u001B[0m");
  }

	public void imprimirVerde(String texto) {
    System.out.println("\u001B[32m" + " " + texto + " " + "\u001B[0m");
	}

	public void imprimirVermelho(String texto) {
    System.out.println("\u001B[31m" + " " + texto + " " + "\u001B[0m");
	}

	public void imprimirCiano(String texto) {
    System.out.println("\u001B[36m" + " " + texto + " " + "\u001B[0m");
	}

	public void imprimirAmarelo(String texto) {
		System.out.println("\u001B[33m" + " " + texto + " " + "\u001B[0m");
	}
	
}