import java.util.*;
import java.io.*;

public class LerData{
  
  public List<String> ler(String value){
		String arquivoProcurar = "server.log." + value;
		List<String> linhas = new ArrayList<>();
		try{
			InputStream arquivo = new FileInputStream("./logs/" + arquivoProcurar);

			Scanner entradaArquivo = new Scanner(arquivo);

			while(entradaArquivo.hasNextLine()) {
				linhas.add(entradaArquivo.nextLine());
			}

		}catch(Exception e) {
			System.out.println("Arquivo nao existe!");
		}
		
		return linhas;

  }
}