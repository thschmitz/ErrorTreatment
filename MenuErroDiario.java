import java.io.*;
import java.util.*;

public class MenuErroDiario{
	public void menu(TituloSecoes titulo, String[] lista){
    Scanner entrada = new Scanner(System.in);

		String[] listaPerguntas = {"Digite o dia inicial desejado: ", "Digite o mês inicial desejado: ", "Digite o ano inicial desejado: ", "Digite o dia final desejado: ", "Digite o mês final desejado: ", "Digite o ano final desejado: " };
		String[] listaRespostas = {"", "", "", "", "", ""};
		int resposta = 0;
		Cores colorir = new Cores();
		LerData lerData = new LerData();
		LeituraArquivo leituraArquivo = new LeituraArquivo();
		List<String> linhas = new ArrayList<>();
		int erros = 0;
		int dataInicial, dataFinal;
		ComparaData comparaData = new ComparaData(lista);
		ArrayList<Integer> listaErros = new ArrayList<Integer>();
		List<String> nomesFinais = new ArrayList<String>();
		titulo.tituloPrincipal("Menu quantidade erros por dia");

		for(int i = 0; i < listaPerguntas.length; i++){
			System.out.println(listaPerguntas[i]);
			System.out.print("-> ");
			resposta = entrada.nextInt();
      if(resposta < 10){
        listaRespostas[i] = ("0" + Integer.toString(resposta));
			  System.out.println(" ");
      }else{
        listaRespostas[i] = (Integer.toString(resposta));
      }      
		}

    dataInicial = Integer.parseInt(listaRespostas[2] + listaRespostas[1] + listaRespostas[0]);

    dataFinal = Integer.parseInt(listaRespostas[5] + listaRespostas[4] + listaRespostas[3]);


    comparaData.comparar(dataInicial, dataFinal);


    nomesFinais = comparaData.getNomeFinais();

		for(int i = 0; i < nomesFinais.size(); i++){
      erros =0;
      
      linhas = lerData.ler(nomesFinais.get(i));
			
			for(int j = 0; j < linhas.size(); j++){
				if(!linhas.get(j).contains(" 	at ")) {
					if(linhas.get(j).contains(" ERROR ")){
						erros += 1;	
					}
				}
			}
			
       listaErros.add(erros);	    
    }


		Boolean continuar = true;
		int opcaoUsuario;
    while(continuar==true) {
			System.out.println("Deseja modificar a ordem?");
			System.out.println("1) Valor crescente: ");
			System.out.println("2) Valor descrescente: ");
			System.out.println("3) Data crescente: ");
			System.out.println("4) Data decrescente: ");
			System.out.println("5) Desconectar: ");
			System.out.print("-> ");
      opcaoUsuario = entrada.nextInt();

			switch(opcaoUsuario) {
				case 1:
          valorCrescente(nomesFinais, listaErros);
					break;
				case 2:
					valorDecrescente(nomesFinais, listaErros);
					break;
				case 3:
          imprimirDataCrescente(nomesFinais, listaErros);
					break;
				case 4:
          imprimirDataDescrescente(nomesFinais, listaErros);
					break;
				case 5:
					continuar = false;
					break;
				default:
					colorir.imprimirVermelho("Digite um valor valido!");
			}
			
		}
  }

	public void valorDecrescente(List<String> nomesFinais, ArrayList<Integer> listaErros){
		TreeMap<Integer, List<String>> mapValores = new TreeMap<Integer, List<String>>();


		for(int i = 0; i < listaErros.size(); i++) {
			mapValores.computeIfAbsent(listaErros.get(i), o -> new ArrayList<String>()).add(nomesFinais.get(i));
		}

		String leftAlignFormat = "| %-15s | %-8d | %n";

		System.out.format("+-----------------+--------------+%n");
		System.out.format("|"+ "\u001B[31m"+ "     Data    "+"\u001B[0m"+ "   | "+ "\u001B[33m" +" Erros " + "\u001B[0m" + " |%n");
		System.out.format("+-----------------+--------------+%n");

		for(Integer key : mapValores.descendingKeySet()){
			System.out.format(leftAlignFormat, mapValores.get(key).get(0), key);

			
		}
		System.out.format("+-----------------+--------------+%n");

	}

	public void valorCrescente(List<String> nomesFinais, ArrayList<Integer> listaErros) {
			TreeMap<Integer, List<String>> mapValores = new TreeMap<Integer, List<String>>();


		for(int i = 0; i < listaErros.size(); i++) {
			mapValores.computeIfAbsent(listaErros.get(i), o -> new ArrayList<String>()).add(nomesFinais.get(i));
		}
		String leftAlignFormat = "| %-15s | %-8d | %n";

		System.out.format("+-----------------+--------------+%n");
		System.out.format("|"+ "\u001B[31m"+ "     Data    "+"\u001B[0m"+ "   | "+ "\u001B[33m" +" Erros " + "\u001B[0m" + " |%n");
		System.out.format("+-----------------+--------------+%n");
		
		for(Integer key : mapValores.keySet()){
			System.out.format(leftAlignFormat, mapValores.get(key).get(0), key);
		}
		


		System.out.format("+-----------------+--------------+%n");
	}


	public void imprimirDataCrescente(List<String> nomesFinais, ArrayList<Integer> listaErros) {
		  String leftAlignFormat = "| %-15s | %-8d | %n";
		
			System.out.format("+-----------------+--------------+%n");
			System.out.format("|"+ "\u001B[31m"+ "     Erros    "+"\u001B[0m"+ "   | "+ "\u001B[33m" +" Ocorrencias" + "\u001B[0m" + " |%n");
			System.out.format("+-----------------+--------------+%n");
			for(int i = 0; i < listaErros.size(); i++) {
				System.out.format(leftAlignFormat, nomesFinais.get(i), listaErros.get(i));
				
			}
			System.out.format("+-----------------+--------------+%n");
	}


		public void imprimirDataDescrescente(List<String> nomesFinais, ArrayList<Integer> listaErros) {
		  String leftAlignFormat = "| %-15s | %-8d | %n";
		
			System.out.format("+-----------------+--------------+%n");
			System.out.format("|"+ "\u001B[31m"+ "     Erros    "+"\u001B[0m"+ "   | "+ "\u001B[33m" +" Ocorrencias" + "\u001B[0m" + " |%n");
			System.out.format("+-----------------+--------------+%n");
			for(int i = listaErros.size() - 1; i >= 0 ; i--) {
				System.out.format(leftAlignFormat, nomesFinais.get(i), listaErros.get(i));
			}
			System.out.format("+-----------------+--------------+%n");
	}
  
}
