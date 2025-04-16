package batalhanaval;

import javax.swing.JOptionPane;


public class Tabuleiro {
    private static char letra = 65;
    private static int numero = 1, W, H;
    private int[][] tabuleiro = new int[W][H];
    
    public void gerarTabuleiro() {
        W = Integer.parseInt(JOptionPane.showInputDialog("Innforme a largura(linhas verticias ---) do tabuleiro:"));
        H = Integer.parseInt(JOptionPane.showInputDialog("Innforme a altura do tabuleiro:"));
        
        int[][] tab = new int[W][H];
        this.tabuleiro = tab;
        
        int b = 0;
        
        System.out.print("   ");
            for (int l = 0; l < W; l++) {

                    System.out.print(" " + letra + " ");

                    letra++;

                }
                System.out.print("\n");
        for (int i = 0; i < W; i++) {
                System.out.print(numero);
                numero++;
                for (int f = 1; f <= H; f++) {
                    if (f == 1 && numero <= 10) {
                        System.out.print("  | ");
                    } else {
                        System.out.print(" | ");
                    }
                    b++;
                }
                System.out.print(" |\n");

        }
    }
    
    //Gerar Navios ==========================================================================================
    
    public static void gerarNavios() {
        //dependendo do tamanho do tabuleiro, gera mais navios        
        int qtdNavios;
        int area = W*H;
        
        if( area % 2 == 0) {
            
        }else if(area % 3 == 0 || area % 5 == 0 || area % 7 == 0 || area % 13 == 0 ){
            
        }
    }
}
