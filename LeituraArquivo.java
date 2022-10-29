import java.util.*;
import java.io.*;
import java.io.File;
import java.nio.file.Files;

public class LeituraArquivo{
	public void ler(String tituloProcurar){
		List<String> linhas = new ArrayList<>();

		Cores colorir = new Cores();
		
			
			try{
			
			InputStream arquivo = new FileInputStream(tituloProcurar);

      
      Scanner entradaArquivo = new Scanner(arquivo);
      BufferedReader reader;
      reader = new BufferedReader(new FileReader(tituloProcurar));


      entradaArquivo.nextLine();
	
			String line = reader.readLine();			

			while (entradaArquivo.hasNextLine() && line != null) {
        line = reader.readLine();
        linhas.add(line);
      }
      
        
      }catch (Exception e) {
	      colorir.imprimirVermelho("Arquivo não encontrado!");
			}
    

			
	}
}