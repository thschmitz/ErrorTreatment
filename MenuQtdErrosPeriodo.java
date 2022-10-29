import java.io.*;
import java.util.*;
import java.util.function.*; 

public class MenuQtdErrosPeriodo{
  ArrayList<Integer> listaNova = new ArrayList<Integer>();
	ArrayList<String> listaNovaErros = new ArrayList<String>();
	ArrayList<Float> newPorcentagem = new ArrayList<Float>();
	
	public void menu(TituloSecoes titulo, String[] lista ){
    Scanner entrada = new Scanner(System.in);

		String[] listaPerguntas = {"Digite o dia inicial desejado: ", "Digite o mês inicial desejado: ", "Digite o ano inicial desejado: ", "Digite o dia final desejado: ", "Digite o mês final desejado: ", "Digite o ano final desejado: " };
		String[] listaRespostas = {"", "", "", "", "", ""};
		int resposta = 0;
		Cores colorir = new Cores();
		LeituraArquivo leituraArquivo = new LeituraArquivo();
		List<String> nomesFinais = new ArrayList<>();
    int dataInicial, dataFinal;
		ComparaData comparaData = new ComparaData(lista);
    Filtragem filtragem = new Filtragem();
    List<String> linhas = new ArrayList<>();
    LerData lerData = new LerData();
    ArrayList<String> listaFrases = new ArrayList<String>();


    titulo.tituloPrincipal("Menu quantidade erros período");

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
    System.out.println("Data Inicial: " + dataInicial);

    dataFinal = Integer.parseInt(listaRespostas[5] + listaRespostas[4] + listaRespostas[3]);

    System.out.println("Data Inicial: " + dataFinal);

    comparaData.comparar(dataInicial, dataFinal);

    nomesFinais = comparaData.getNomeFinais();

    for(int i = 0; i < nomesFinais.size(); i++){
      
      linhas = lerData.ler(nomesFinais.get(i));
      filtragem.filtrar(linhas);
      
    }


		ArrayList<Integer> arrayQtdRepetidos = filtragem.getListaRepeticoesNumeros();

		ArrayList<String> arrayQtdErros = filtragem.getListaRepeticoesErros();

		// metodo para realizar a mesma coisa do outro lado!!!!!
		dadosOcorrencias(arrayQtdRepetidos, arrayQtdErros);


    String leftAlignFormat = "| %-70s | %-15s | %-10s | %n";

		System.out.format("+------------------------------------------------------------------------+------------------------------+%n");
		System.out.format("|"+ "\u001B[31m"+ "                                   Erros                                "+"\u001B[0m"+ "| "+ "\u001B[33m" +"  Ocorrencias   " + "\u001B[0m" + "|" + "\u001B[32m" + "      %%     "+"\u001B[0m" + "|%n");
		System.out.format("+------------------------------------------------------------------------+------------------------------+%n");

		for (int i = 0; i < listaNova.size(); i++) {
			String palavraErro = listaNovaErros.get(i);
			String numeroErros = Integer.toString(listaNova.get(i));
			String porcentagemErros = Float.toString(newPorcentagem.get(i));

			System.out.format(leftAlignFormat, palavraErro, numeroErros, porcentagemErros);
		}
		System.out.format("+------------------------------------------------------------------------+------------------------------+%n");
					
		


		
	}

	public void dadosOcorrencias(ArrayList<Integer> arrayQtdRepetidos, ArrayList<String> arrayQtdErros) {
		Set<String> distinct = new HashSet<>(arrayQtdErros);
		this.listaNova = new ArrayList<Integer>();
		this.listaNovaErros = new ArrayList<String>();
		float soma = 0f;

		for (String s : distinct) {
			int repeticoes = Collections.frequency(arrayQtdErros, s);

			this.listaNova.add(repeticoes);
			soma += (float) repeticoes;
			this.listaNovaErros.add(s);
		}

		for(int i = 0; i < listaNova.size(); i++) {
			this.newPorcentagem.add(listaNova.get(i).floatValue() / (soma) * 100f);
		}
	}

}