package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teste3 {

    public static void main(String[] args) {
        
        List<Integer> dias = new ArrayList<>();
        List<Double> valores = new ArrayList<>();
     // OPTEI POR NAO UTILIZAR BIBLIOTECAS EXTERNAS
        try (BufferedReader br = new BufferedReader(new FileReader("dados.json"))){ // ABRIR O ARQUIVO
            String line;
            while ((line = br.readLine()) != null) { // CONFIRMAR SE EXISTE CONTEUDO
                line = line.trim();
                
                if (line.startsWith("\"dia\"")) { // IDENTIFICA INICIO DA LINHA
                    String[] parts = line.split(":"); // DIVIDE EM PARTES SEPARADOS POR " : "
                    int dia = Integer.parseInt(parts[1].trim().replace(",", "")); 
                    dias.add(dia); // ADICIONA NA LISTA O DIA
                } else if (line.startsWith("\"valor\"")) { // IDENTIFICA O INICIO DA LINHA DO VALOR
                    String[] parts = line.split(":"); // DIVIDE EM PARTES SEPARADOS POR " : "
                    double valor = Double.parseDouble(parts[1].trim().replace(",", "")); 
                    valores.add(valor);// ADICIONA NA LISTA O DIA
                }
            } 
        } catch(IOException e){
            System.out.println("Error : " + e.getMessage());
        }
        
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double somaValores = 0;
        int diasComFaturamento = 0;
        
        for (double valor : valores) {
            if (valor > 0) {  //VERIFICA E IGNORA OS DIAS SEM FATURAMENTO
                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
                somaValores += valor;
                diasComFaturamento++;
            }
        }
        
        double media = somaValores / diasComFaturamento; // CALCULA MEDIA DOS VALORES
        
        int diasAcimaDaMedia = 0;
        for (double valor : valores) {
            if (valor > media) {
                diasAcimaDaMedia++;
            }
        }
        
        System.out.println("Menor valor de faturamento: R$" + menorValor);
        System.out.println("Maior valor de faturamento: R$" + maiorValor);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
