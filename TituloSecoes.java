public class TituloSecoes{
	Cores colorir = new Cores();
	
  public void tituloPrincipal(String texto){
		System.out.println();
    colorir.imprimirAzul("-------------- " + texto + " --------------");
		System.out.println();
  }

	public void tituloVoltar(){
		colorir.imprimirAmarelo("Voltando ao menu inicial...");
	}
}