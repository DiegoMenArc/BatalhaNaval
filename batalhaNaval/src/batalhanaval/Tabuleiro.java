package batalhanaval;


import java.util.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class Tabuleiro {

    public static char letra = 65;         //Letra Superior do tabuleiro
    private static int numero = 1, W;    //Determina o tamanho do tabuleiiro
    private final Scanner leitor = new Scanner(System.in);
 
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
        
        Random gerador = new Random();
        int vezes = 0;
        while(vezes != W){            
            int pos = gerador.nextInt(W*W);
            boolean tem = false;
            
            if(this.tabuleiro.get(pos)==1){
                tem = true;
            }
            while(tem){
                pos = gerador.nextInt(W*W);
                    if(this.tabuleiro.get(pos)==1){
                    tem = true;
                }
            }
            
            this.tabuleiro.set(pos, 1);
            vezes++;
        }
        
        // Gerar bombas
        vezes = 0;
        while(vezes != W){            
            int pos = gerador.nextInt(W*W);
            boolean tem = true;
            
//            if(this.tabuleiro.get(pos)==1||this.tabuleiro.get(pos)==2){
//                tem = true;
//            }
//            while(tem){
//                pos = gerador.nextInt(W*W);
//                    if(this.tabuleiro.get(pos)==1||this.tabuleiro.get(pos)==2){
//                    tem = true;
//                }
//            }
            
            this.tabuleiro.set(pos, 2);
            vezes++;
        }
        
        
    }

    // Renderizar tabuleiro

    public void renderizar(){
        System.out.println(this.tabselec.get(1));
        numero = 1;
        letra = 65;
        System.out.print("   ");
        for (int l = 1; l <= W; l++) {
            System.out.printf((l <= 9) ? " %d ":" %d", numero);

            numero++;

        }
        System.out.print("\n\n");
        int soma=1;
        for (int i = 1; i <= W; i++) {    
            int a = 0;
            for (int f = 1; f <= W; f++) {
                if(a==0){
                    System.out.printf("%c  ", letra);
                    letra++;
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
        Jogar();
    }
    
    //Verificar se ainda pode jogar ============================================================================================
    
    public void Validacao(){
        int cont = 0;
        for (int i = 0; i < W; i++) {
            for (int f = 0; f < W; f++) {
                //System.out.println(this.tabselec[i][f]);
            }
            
        }
        
    }
    
    //Jogada do usuario ======================================================================================================== 
    
    public void Jogar(){
        Pattern pattern = Pattern.compile("^[a-zA-Z]{1}+[0-9]{1,2}$");
        int pos=0;
        
        System.out.println("\n\nDigite a posição");
        String posicao = leitor.nextLine();
        Matcher matcher = pattern.matcher(posicao);
        
        while(!matcher.find()){
            System.out.println("Valor invalido, digite novamente!");
            posicao = leitor.nextLine();
            matcher = pattern.matcher(posicao);
        }
        pattern = Pattern.compile("[0-9]{1,2}");
        matcher = pattern.matcher(posicao);

        if (matcher.find()) {
            pos = Integer.parseInt(matcher.group());
        }
        char letraa = posicao.toUpperCase().charAt(0);
        
        if(letraa > letra || pos > W){
            System.out.println("Valor Invalido!");
            Jogar();    
        }
        else{
            Troca(pos, letraa);
            renderizar();
        }
    }
    
    public void Troca(int pos,char letraa){
        int posdf = (pos + (letraa-65)*W)-1;
        
        this.tabselec.set(posdf, true);
    }
}
