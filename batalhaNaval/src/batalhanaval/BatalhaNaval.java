package batalhanaval;

import java.util.Scanner;

//import java.util.Random;
//commit teste do rapha haha

//comentario talvez de certo 1çldçldçldç

import javax.swing.JOptionPane;

public class BatalhaNaval {
    public static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) {
        exibirMenu();
    }

    private static int escolha;

    public static void exibirMenu() {
        String[] opcoes = {"Jogar", "Como Jogar", "Sair"};
//        JOptionPane.showMessageDialog(null, ("""        
//            Bem-vindo ao Batalha Naval
//            1. Jogar
//            2. Como Jogar
//            3. Sair
//        """));
        
        escolha = JOptionPane.showOptionDialog(null, "Bem-vindo ao Batalha Naval", "Select one:", 
                                                      0, 3, null, opcoes, opcoes[0]);
        while (escolha != 1 && escolha != 2 && escolha != 3) {
           System.out.print("1. Sim  \n 2. Como Jogar \n 3. Sair");
           escolha = leitor.nextInt(); 
        }
        switch (escolha) {
            case 1:
                menuInicial();
                break;
            case 2:
                exibirTutorial();
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }
    }
    
    public static void exibirTutorial() {
        int escolhaT;
        System.out.print(""" 
                         As regras para jogar s\u00e3o:  
                         1. Escolha se vai jogar contra um jogador ou contra uma m\u00e1quina.  
                         2. Determinare o tamnho do tabuleiro.  
                         3. O n\u00famero de navios vai ser definido com base no tamanho do tabuleiro.  
                         -3.1. Caso o jogador escolha o modo contra m\u00e1quina, ter\u00e1 um limite de erros.  
                         4. Ao come\u00e7ar o jogo, o jogador precisa lan\u00e7ar ataques em coordenadas at\u00e9 afundar todos os navios ou gastar todas as chances.  
                         -4.1. Ao acertar um navio inimigo, aparecer\u00e1 uma bola no lugar. EXEMPLO: |O|.  
                         -4.2 .Ao errar o ataque, aparecer\u00e1 um X no lugar. EXEMPLO: |X|.  
                         5. Fim do jogo:  
                         -5.1. Caso afunde todos os navios, ganha o jogo. 
                         -5.2. Caso gaste todas as tentativas, o njogador perde.  
                         """);
        
        System.out.print("Pronto pra continuar? \n 1. Sim \n 2. Sair");
        escolhaT = leitor.nextInt();
        while(escolhaT != 1 && escolhaT != 2){
            System.out.print("Escolha uma função válida: \n 1. Sim \n 2. Sair");
            escolhaT = leitor.nextInt();
        }
        
        switch(escolhaT) {
            case 1 -> exibirMenu();
            case 2 -> System.exit(0);
        }
    }
    
    public static void menuInicial() {
        int escolhaMenu;
        System.out.print("1. Jogar \n 2. Sair");
        escolhaMenu = leitor.nextInt();
        while (escolhaMenu != 1 && escolhaMenu != 2) {
            escolhaMenu = leitor.nextInt();
        }
        switch (escolhaMenu) {
            case 1: modosJogo();break;
            case 2: exibirTutorial(); break;
            case 3: System.exit(0); break;
        }
    }

    public static void modosJogo() {
        System.out.print("Escolha o modo de jogo: \n 1. Contra máquina \n 2. Contra um jogador.");
        escolha = leitor.nextInt();
        while(escolha != 1 && escolha != 2 && escolha !=3) {
           System.out.print("Escolha o modo de jogo: \n 1. Contra máquina \n 2. Contra um jogador \n 3. Sair");
        escolha = leitor.nextInt(); 
        }
        switch(escolha) {
        }
    }

    
    
    //Gerar Tabuleiro =======================================================================
    
    private static char letra = 65;
    private static int numero = 1, W, H;
    public static int[][] tabuleiro = new int[W][H];
    
    public static void gerarTabuleiro() {
         W = Integer.parseInt(JOptionPane.showInputDialog("Informe a largura do tabuleiro \n os valores disponíveis são de 3 até 20:"));
            while(W <3 || W >= 36) {
                W = Integer.parseInt(JOptionPane.showInputDialog("Informe a largura do tabuleiro \n os valores disponíveis são de 3 até 20:"));
            }
        H = Integer.parseInt(JOptionPane.showInputDialog("Informe a altura do tabuleiro. \n   O número não pode ter mais de 5 pontos de diferença da largura"));
            while(H < W-5 || H >20 || H > W+5) {
                H = Integer.parseInt(JOptionPane.showInputDialog("Informe a altura do tabuleiro. \n   O número não pode ter mais de 5 pontos de diferença da largura"));
            }
        int b = 0;
        
        for (int i = 0; i <= W; i++) {
            if (i == 0) {
                System.out.print("   ");
                for (int l = 0; l < W; l++) {

                    System.out.print(" " + letra + " ");

                    letra++;

                }
                System.out.print("\n");
            } else {
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
    }
    public static void gerarNavios() {
        //dependendo do tamanho do tabuleiro, gera mais navios        
        int qtdNavios;
        int area = W*H;
        
        if( area % 2 == 0) {
            
        }else if(area % 3 == 0 || area % 5 == 0 || area % 7 == 0 || area % 13 == 0 ){
            
        }
    }
}
