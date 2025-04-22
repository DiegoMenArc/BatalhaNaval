package batalhanaval;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tabuleiro {

    private static char letra = 65;         //Letra Superior do tabuleiro
    private static int numero = 1, W, H;    //Determina o tamanho do tabuleiiro
 
    private ArrayList<Integer> tabuleiro = new ArrayList<Integer>(); //quando o array estiver 0 = agua, 1 = navio, 2 = bomba 
    private ArrayList<Boolean> tabselec  = new ArrayList<Boolean>(); //Determina se a posição já foi selecionada ou não;
    

    // Gerar Tabuleiro 
    
    public void gerarTabuleiro() {
        W = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de linhas e colunas. \n se você colocar 26, serão 26 linhas e 26 colunas."));
        while (W > 26) {
            //como as letras só vão até o 26, eu escolhi atribuir este limite
            W = Integer.parseInt(JOptionPane.showInputDialog("O limite é 26!, Digite novamente"));
        }
        
        //Adicionando os valores iniciais nos arrays
        for(int i = 1; i <= W*W; i++){
            this.tabuleiro.add(0);
            this.tabselec.add (false);
        }
        
        this.tabuleiro.set(5, 1);
        this.tabselec.set(5, true);
        System.out.println(tabselec.get(1));
        renderizar();
    }

    // Renderizar tabuleiro

    public void renderizar(){
        System.out.println(this.tabselec.get(1));
        System.out.print("   ");
        for (int l = 1; l <= W; l++) {
            System.out.printf(" %c ", letra);

            letra++;

        }
        System.out.print("\n\n");
        int soma=1;
        for (int i = 1; i <= W; i++) {    
            int a = 0;
            for (int f = 1; f <= W; f++) {
                if(a==0){
                    System.out.printf((i <= 9) ? "%d  " : "%d ", numero);
                    numero++;
                    a++;
                }
                System.out.print(   (!this.tabselec.get(soma-1))    ? " * ":
                                    (this.tabuleiro.get(soma-1)==0) ? " ~ ":
                                    (this.tabuleiro.get(soma-1)==1) ? " O ":" X ");
                if(soma%W==0){
                  System.out.print("\n");  
                }
                soma++;
            }
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
    
    //Verificar se ainda pode jogar ============================================================================================
    
    public void Validacao(){
        int cont = 0;
        for (int i = 0; i < W; i++) {
            for (int f = 0; f < H; f++) {
                //System.out.println(this.tabselec[i][f]);
            }
            
        }
        
    }
    
    //Jogada do usuario ======================================================================================================== 
    
    public void Jogar(String posicao){
        String letra;
    }
}
