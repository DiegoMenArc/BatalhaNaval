package batalhanaval;

import java.lang.reflect.Array;
import javax.swing.JOptionPane;

public class Tabuleiro {

    private static char letra = 65;         //Letra Superior do tabuleiro
    private static int numero = 1, W, H;    //Determina o tamanho do tabuleiiro
    private int[][] tabuleiro;              //quando o array estiver 0 = agua, 1 = navio, 2 = bomba 
    private boolean[][] tabselec;           //Determina se a posição já foi selecionada ou não;

    public void gerarTabuleiro() {
        W = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de linhas e colunas. \n se você colocar 26, serão 26 linhas e 26 colunas."));
        while (W > 26) {
            //como as letras só vão até o 26, eu escolhi atribuir este limite
            W = Integer.parseInt(JOptionPane.showInputDialog("O limite é 26!, Digite novamente"));
        }
        H = W;
        
        this.tabuleiro = new int[W][H];
        this.tabselec = new boolean[W][H];

        int b = 0;

        System.out.print("  ");
        for (int l = 1; l <= W; l++) {
            System.out.printf(" %c ", letra);

            letra++;

        }
        System.out.print("\n\n");
        for (int i = 0; i < W; i++) {
            System.out.printf((i < 9) ? "%d  " : "%d ", numero);
            numero++;
            this.tabuleiro[2][2] = 1;
            for (int f = 0; f < H; f++) {
                System.out.print(" * ");
//                    System.out.print(   (this.tabselec[W][H])       ?" * ":;
//                                        (this.tabuleiro[W][H]==0)   ?" ~ ":
//                                        (this.tabuleiro[W][H]==1)   ?" O ": " X "
//                    );
                b++;
            }
            System.out.print("\n");

        }
    }

    //Gerar Navios ==========================================================================================
    public static void gerarNavios() {
        //dependendo do tamanho do tabuleiro, gera mais navios        
        int qtdN, areaT;
        areaT = W*H;
        if (areaT <= 36) {
            qtdN = 5;
        } else if(areaT <= 81){
            qtdN = 8;
        }
    }
}
