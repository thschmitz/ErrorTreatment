import java.io.*;
import java.util.*;

public class MenuQtdErrosDiario{
	public void menu(TituloSecoes titulo){
    Scanner entrada = new Scanner(System.in);

		String[] listaPerguntas = {"Digite o dia desejado: ", "Digite o mês desejado: ", "Digite o ano desejado: "};
		String[] listaRespostas = {"", "", ""};
		int resposta = 0;
		Cores colorir = new Cores();
		LerData lerData = new LerData();
		LeituraArquivo leituraArquivo = new LeituraArquivo();
		List<String> linhas = new ArrayList<String>();
		Filtragem filtragem = new Filtragem();
		ArrayList<String> listaFrases = new ArrayList<String>();
		
		titulo.tituloPrincipal("Menu erros diários");
		// Fazer classe disso daqui com o do MenuErroDiario.java
    // Talvez mudar pergunta
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

		String value = listaRespostas[2] + "-" + listaRespostas[1] + "-" + listaRespostas[0];

		linhas = lerData.ler(value);


		listaFrases = filtragem.filtrar(linhas);
		
		String leftAlignFormat = "| %-70s | %-15s | %-10s | %n";

		System.out.format("+------------------------------------------------------------------------+------------------------------+%n");
		System.out.format("|"+ "\u001B[31m"+ "                                   Erros                                 "+"\u001B[0m"+ "| "+ "\u001B[33m" +"  Ocorrencias   " + "\u001B[0m" + "|" + "\u001B[32m" + "      %%     "+"\u001B[0m" + "|%n");
		System.out.format("+------------------------------------------------------------------------+------------------------------+%n");

		for (int i = 0; i < listaFrases.size(); i++) {
			String palavraErro = listaFrases.get(i).split(" --- ")[0];
			String numeroErros = listaFrases.get(i).split(" --- ")[1];
			String porcentagemErros = listaFrases.get(i).split(" --- ")[2];

			System.out.format(leftAlignFormat, palavraErro, numeroErros, porcentagemErros);
		}
		System.out.format("+------------------------------------------------------------------------+------------------------------+%n");
					
  }
}