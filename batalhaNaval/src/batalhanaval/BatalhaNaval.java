package batalhanaval;

import java.util.Scanner;

//import java.util.Random;
//commit teste do rapha haha

//comentario talvez de certo 1çldçldçldç 0

import javax.swing.JOptionPane;

public class BatalhaNaval {
    public static Scanner leitor = new Scanner(System.in);
    public static Tabuleiro tab = new Tabuleiro();
    public static Tabuleiro tab2 = new Tabuleiro();
    public static void main(String[] args) {
        exibirMenu();
    }

    private static int escolha;

    public static void exibirMenu() {
        String[] opcoes = {"Novo Jogo", "Como Jogar", "Sair"};

        escolha = JOptionPane.showOptionDialog(null, "Bem-vindo ao Batalha Naval", "Select one:", 
                                                      0, 3, null, opcoes, opcoes[0]);
        
        System.out.print(escolha);
        switch (escolha) {
            case 0:
                modosJogo();
                break;
            case 1:
                exibirTutorial();
                break;
            case 2:
                System.exit(0);
            default:
                exibirMenu();
                break;
        }
    }
    
    //Menu Tutorial ========================================================================================
    
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
    
    //Modo de Jogo ==========================================================================================

    public static void modosJogo() {
        String[] opcoes = {"Contra máquina", "Contra um jogador"};

        escolha = JOptionPane.showOptionDialog(null, "Escolha o modo de jogo:", "Select one:", 
                                                      0, 3, null, opcoes, opcoes[0]);
        
        Tabuleiro tab = new Tabuleiro();
        switch(escolha) {
            case 0 -> jogar();
            case 1 -> System.exit(0);
            default -> System.exit(0);
        }
    }
    
    // Jogar 
    
    public static void jogar(){
        tab.gerarTabuleiro();
        tab.renderizar();
    }
}
