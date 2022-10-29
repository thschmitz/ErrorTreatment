import java.util.*;
import java.io.*;

public class ComparaData{

  String[] listaArquivoNomes;
  List <String> nomesFinais = new ArrayList<String>();
  
  ComparaData(String[] listaNomes){
    this.listaArquivoNomes = listaNomes;
  }
  
  public void comparar(int dataInicial, int dataFinal){
    Scanner entrada = new Scanner(System.in);

    
    for(int i = 0; i < listaArquivoNomes.length; i++){
          if(Integer.parseInt(listaArquivoNomes[i]) >= dataInicial && Integer.parseInt(listaArquivoNomes[i]) <= dataFinal){
            nomesFinais.add(listaArquivoNomes[i].substring(0 , 4) + "-" + listaArquivoNomes[i].substring(4 , 6) + "-" + listaArquivoNomes[i].substring(6 , 8));
          }
        }    
  }

  public List<String> getNomeFinais(){
    return this.nomesFinais;
  }
}