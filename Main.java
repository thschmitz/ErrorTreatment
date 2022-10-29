import java.util.*;
import java.io.File;

class Main {

	public static String[] listaFiles() {
		File f = null;
		f = new File("./logs");
		String[] listaArquivoNomes;
		
		listaArquivoNomes = f.list();

		for(int i = 0; i < listaArquivoNomes.length; i++) {
			listaArquivoNomes[i] = listaArquivoNomes[i].split("\\.")[2];
			listaArquivoNomes[i] = listaArquivoNomes[i].replace("-", "");
		}
		return listaArquivoNomes;
	}
	
  public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcaoUsuario;
		MenuErroDiario menuErroDiario = new MenuErroDiario();
		MenuQtdErrosDiario menuQtdErrosDiario = new MenuQtdErrosDiario();
		MenuQtdErrosPeriodo menuQtdErrosPeriodo = new MenuQtdErrosPeriodo();
		TituloSecoes titulo = new TituloSecoes();
		LerData lerData = new LerData();
		Boolean continuar = true;

		// Leitura de todos os nomes
		String[] lista = listaFiles();

		while(continuar=true){
			titulo.tituloPrincipal("Menu Principal");

			System.out.println("Selecione o modo de leitura: ");
	
			System.out.println("1) Buscar quantos erros acontecem em um dia: ");
			System.out.println("2) Erros com mais ocorrencia em um determinado dia: ");
			System.out.println("3) Erros com mais ocorrencia em um periodo: ");

			System.out.println("4) Desconectar do sistema");

			System.out.print("-> ");
			opcaoUsuario = entrada.nextInt();
			
			switch(opcaoUsuario){
				case 1:
					//todo
					menuErroDiario.menu(titulo, lista);
					break;
				case 2:
					//todo
					menuQtdErrosDiario.menu(titulo);
					break;
				case 3:
					//todo
					menuQtdErrosPeriodo.menu(titulo, lista);
					break;
				case 4:
					//todo
					continuar = false;
					break;
				default:
					System.out.println("Digite um valor valido ao sistema.");
					break;
			}

			if(opcaoUsuario != 4) {			
				titulo.tituloVoltar();
			}
		}
  }
}