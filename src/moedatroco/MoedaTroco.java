
package moedatroco;

import java.util.Scanner;

/**
 * [PROJETO E ANÁLISE DE ALGOTITIMO T1 - CET084]
 * @author José Carlos Adão - Albert Paixão - Ricardo Neves
 */


public class MoedaTroco {

    public static void main(String[] args) {
        int troco;
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o valor do troco: ");
        troco = ler.nextInt();
        int moedas[] = {1, 5, 10, 25, 50};
        int tam = (moedas.length) / (moedas[0]);

        trocoOtimo(moedas, troco, tam);

    }

    public static void trocoOtimo(int moedas[], int troco, int tam) {
        int c = 0, j = 0, i = 0, x = 0;
        int quantidade[] = new int[troco + 1];
        quantidade[0] = 0;
        int ultima[] = new int[troco + 1];
        ultima[0] = 0;
        int teste[] = new int[20];

        for (c = 1; c <= troco; c++) { // percorre cada centavo do troco
            int quantidade_provisoria = c;
            int ultima_provisoria = 1;

            for (j = 0; j < tam; j++) { // percorre todas as moedas
                if (moedas[j] > c) {
                    continue; // a moeda é grande demais
                }
                if (quantidade[c - moedas[j]] + 1 < quantidade_provisoria) {
                    quantidade_provisoria = quantidade[c - moedas[j]] + 1;
                    ultima_provisoria = moedas[j];
                }
            }

            quantidade[c] = quantidade_provisoria;
            ultima[c] = ultima_provisoria;

        }
        while (quantidade[troco] >= 1) {
            //printf("%d + ", ultima[troco]);
            teste[x] = ultima[troco];
            troco = troco - ultima[troco];
            x++;
        }
        System.out.println("\n");
        arrayFrequencia(teste, x);

    }

    public static void arrayFrequencia(int teste[], int x) {
        int i = 0;
        int j = 0;
        int count;
        int freq[] = new int[x];

        for (i = 0; i < x; i++) {
            count = 0;
            for (j = 0; j < x; j++) {
                if (teste[i] == teste[j]) {
                    count++;
                }
            }
            freq[i] = count;
        }
        
        System.out.println("Qtd\tMoeda");
        for (i = 0; i < x; i++) {
            if(i+1 < freq.length){
                if ((freq[i] != freq[i + 1] || teste[i] != teste[i + 1]) ) {//Verifica se as moedas sao repetidas
                    System.out.println(freq[i] + "\t" + teste[i]);
                }
            }else{// Imprimi a ultima moeda do array
                System.out.println(freq[i] + "\t" + teste[i]);
            }
        }
    }
}


