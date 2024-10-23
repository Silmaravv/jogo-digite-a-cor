import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;
// por algum motivo que nao descobri ainda só esta rodando com main
public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
      Random gerador = new Random();

      boolean acertou = true;

      Scanner tempo = new Scanner(System.in);
      ExecutorService executor = Executors.newSingleThreadExecutor();
      System.out.println("*JOGO DAS CORES* \nSerá que você consegue bater o record?");

      while (acertou) {
        Scanner ler = new Scanner(System.in);

        System.out.println();
        System.out.println("Digite a cor da palavra o mais rápido possível.");
        System.out.println();

        String[] cores = {"azul", "vermelho", "amarelo", "verde", "roxo", "ciano", "branco"};
        String[] coresSorteio = {ANSI_BLUE, ANSI_RED, ANSI_YELLOW, ANSI_GREEN, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE};
        int posicaoCorPintada = gerador.nextInt(0, coresSorteio.length);
        String corSorteadaPintada = coresSorteio[posicaoCorPintada];
        String corSorteadaEscrita = cores[gerador.nextInt(0, cores.length)];

        System.out.println(corSorteadaPintada + corSorteadaEscrita);
        System.out.println(ANSI_RESET);
       Future <String> future = executor.submit(() -> ler.next());
        ExecutorService contadorExecutor = Executors.newSingleThreadExecutor();
        contadorExecutor.submit(() ->{
          for(int i = 10; i>0;i--){System.out.print("\r tempo restante: " + i+ " ");
        try{
          Thread.sleep(1000);
        } catch (InterruptedException e){
          Thread.currentThread().interrupt();
        }
        }
          //System.out.println(" Tempo esgotado!!! ");
        });

        try {
          String cor = future.get(10, TimeUnit.SECONDS);
          acertou = 
            cor.equals(cores[posicaoCorPintada]);
        
        
        

        

        //        roxo é igual a roxo?
        acertou = cor.equals(cores[posicaoCorPintada]);

        if(acertou) {
          System.out.println("Acertou miseravi");
        }

        else {System.out.println("ruim demais, tente novamente" );
             }
          

        } catch (TimeoutException e){
          System.out.println("Tempo esgotado! voçê perdeu.");
            acertou = false;
          future.cancel(true);
        }catch (Exception e){
          System.out.println("Erro!" + e.getMessage());
          acertou = false;
        }
      contadorExecutor.shutdown();
      }

  
executor.shutdown();
}
}    
      
    
