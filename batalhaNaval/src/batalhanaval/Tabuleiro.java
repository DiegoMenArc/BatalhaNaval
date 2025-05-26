package batalhanaval;


import java.util.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class Tabuleiro {

    public static char letra = 65;         //Letra Superior do tabuleiro
    private static int numero = 1, W;    //Determina o tamanho do tabuleiiro
    private final Scanner leitor = new Scanner(System.in);
    private Random gerador = new Random();
    
    private int escolha;
    String[] opcoes = {"Jogar Novamente", "Sair"};
 
    private ArrayList<Integer>
            tabuleiro = new ArrayList<Integer>(); //quando o array estiver 0 = agua, 1 = navio, 2 = bomba 
    private ArrayList<Boolean> tabselec  = new ArrayList<Boolean>(); //Determina se a posição já foi selecionada ou não;
    

    // Gerar Tabuleiro 
    
    public void gerarTabuleiro() {
        boolean tem = true;
        int pos = 0;
        
        W = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de linhas e colunas. \n se você colocar 26, serão 26 linhas e 26 colunas."));
        while (W > 26) {
            //como as letras só vão até o 26, eu escolhi atribuir este limite
            W = Integer.parseInt(JOptionPane.showInputDialog("O limite é 26!, Digite novamente"));
        }
        
        //Adicionando os valores iniciais nos arrays ================================================================================
        for(int i = 1; i <= W*W; i++){
            this.tabuleiro.add(0);
            this.tabselec.add (false);
        }
        
        //Gerando os Navios =========================================================================================================
        
        int vezes = 0;
        while(vezes != W){  
            
            while(true){
                pos = this.gerador.nextInt(W*W);
                if(this.tabuleiro.get(pos)==0){
                    this.tabuleiro.set(pos, 1);
                    break;
                }
            }    
            while(true){
                pos = this.gerador.nextInt(W*W);
                if(this.tabuleiro.get(pos)==0){
                    this.tabuleiro.set(pos, 2);
                    break;
                }
            }           
            vezes++;
        }  
    }

    // Renderizar tabuleiro ==========================================================================================

    public void renderizar(){
        numero = 1;
        letra = 65;
        System.out.print("  ");
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
    
    public void menuFinal(String texto){
        this.escolha = JOptionPane.showOptionDialog(null,texto,"Select one:", 
                                                      0, 3, null, this.opcoes, this.opcoes[0]);           
            switch (escolha) {
            case 0:
                BatalhaNaval.modosJogo();
                break;
            case 1:
                System.exit(0);
            default:
                BatalhaNaval.modosJogo();
            }
    }
    
    public void Validacao(){
        int acertados=0;
        int erros=0;
        
        int pos = 0;
        for(int valor: this.tabuleiro){
            if(valor==1 && this.tabselec.get(pos)){
                acertados++;
            }else if(valor==2 && this.tabselec.get(pos)){
                erros++;
            }
            pos++;
        }
        
        System.out.printf("\nNavios restantes: %d\nVidas: %d\n\n",W-acertados,W-erros);
        
        if(acertados==W){
            menuFinal("Parabens afundou todas as embarcações!!");
                
        }else if(erros==W){
            menuFinal("Você perdeu todas as suas vidas\nGame Over");
            
        }
    }
    
    
    //Jogada do usuario ======================================================================================================== 
    
    public void Jogar(){
        Pattern pattern = Pattern.compile("^[a-zA-Z]{1}+[0-9]{1,2}$");
        int pos=0;
        
        System.out.println("\n\nDigite a posição");
        String posicao = leitor.nextLine();
        Matcher matcher = pattern.matcher(posicao);
        
        if("SAIR".equals(posicao.toUpperCase())){
            BatalhaNaval.exibirMenu();
        }
        
        while(!matcher.find()){
            System.out.println("Valor invalido, digite novamente!");
            posicao = leitor.nextLine();
            matcher = pattern.matcher(posicao);
            if("SAIR".equals(posicao.toUpperCase())){
                BatalhaNaval.exibirMenu();
            }
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
            Validacao();
            renderizar();
        }
    }
    
    public void Troca(int pos,char letraa){
        int posdf = (pos + (letraa-65)*W)-1;
        
        this.tabselec.set(posdf, true);
    }
}
