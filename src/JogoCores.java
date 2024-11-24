import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JogoCores {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Jogador> ranking = new ArrayList<>();
		ranking.add(new Jogador("Sil", 44));
  		ranking.add(new Jogador("FluFF", 30));
  		ranking.add(new Jogador("Fer", 10));
		boolean continuar = true;
		while (continuar) {
			System.out.println("");
			System.out.println("");
			System.out.println("BEM VINDO(A) AO JOGO \u001B[33m⚡c̶͛͢h̶͛͢o̶͛͢q̶͛͢u̶͛͢e̶͛͢\u001B[36m ̶͛͢d̶͛͢e̶͛͢ \u001B[37mc̶͛͢\u001B[35mo̶͛͢\u001B[32mr̶͛͢\u001B[37me̶͛͢\u001B[36ms̶̶̶͛͛͛͢͢͢ \u001B[33m⚡\u001B[0m");
			System.out.println("");
			System.out.println("Escolha a opção desejada:\n" );
			System.out.println("\u001B[36m1- INICIAR 🏁\u001B[0m");
			System.out.println("\u001B[33m2- RANKING 🎯 \u001B[0m");
			System.out.println("\u001B[32m3- INSTRUÇÕES 🕹️\u001B[0m");
			System.out.println("\u001B[31m4- SAIR 🚪\u001B[0m");
			System.out.println("");
			
			
			Scanner ler = new Scanner(System.in);
			byte escolha = ler.nextByte();
			
			if (escolha == 1) {
				ExecutorService executor = Executors.newSingleThreadExecutor();
				System.out.println("JOGO INICIADO!");
				System.out.println("");
				System.out.println(" \nSerá que você consegue bater o record?");
				Random gerador = new Random();
	  		
				boolean acertou = true;
	  		
				int pontoSoma = 0;
				
				int tempoLimite = 10000;
			
				
				while (acertou) {
					System.out.println();
					System.out.println("Digite a cor da palavra o mais rápido possível.");
					System.out.println();
	  		
					String[] palavras = {"azul", "vermelho", "amarelo", "verde", "roxo", "ciano", "branco"};
					String[] coresSorteio = {ANSI_BLUE, ANSI_RED, ANSI_YELLOW, ANSI_GREEN, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE};
	  			
					int posicaoCorPintada = gerador.nextInt(0, coresSorteio.length);
					String corSorteadaPintada = coresSorteio[posicaoCorPintada];
					String palavraSorteada = palavras[gerador.nextInt(0, palavras.length)];
	  			
					System.out.println(corSorteadaPintada + palavraSorteada);
					System.out.println(ANSI_RESET);
					
					ConsoleInput consoleInput = new ConsoleInput(1,tempoLimite, TimeUnit.MILLISECONDS);
					String cor = consoleInput.readLine();
					
					//        roxo é igual a roxo?
					acertou = cor != null && cor.equals(palavras[posicaoCorPintada]);
	  			
					if (acertou) {
						System.out.println("Acertou miseravi");
						pontoSoma = pontoSoma + 1;
	  				
						
						if (tempoLimite >= 2650) {
							tempoLimite = tempoLimite-500;
							System.out.println("Nível "+ pontoSoma);
								
						}
						
						
					}
					else {
						System.out.println("⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⡴⠋⠉⡊⢁⠀⠀⢬⠀⠉⠋⠈⠥⠤⢍⡛⠒⠶⣄⡀⠀⠀⠀\r\n"
								+ "⠀⠀⠀⠀⣾⠥⠀⠀⠊⢭⣾⣿⣷⡤⠀⣠⡀⡅⢠⣶⣮⣄⠉⠢⠙⡆⠀⠀\r\n"
								+ "⠀⠀⣠⡾⣁⡨⠴⠢⡤⣿⣿⣿⣿⣿⠸⡷⠙⣟⠻⣯⣿⣟⣃⣠⡁⢷⣄⠀\r\n"
								+ "⠀⡼⡙⣜⡕⠻⣷⣦⡀⢙⠝⠛⡫⢵⠒⣀⡀⠳⡲⢄⣀⢰⣫⣶⡇⡂⠙⡇\r\n"
								+ "⢸⡅⡇⠈⠀⠀⠹⣿⣿⣷⣷⣾⣄⣀⣬⣩⣷⠶⠧⣶⣾⣿⣿⣿⡷⠁⣇⡇\r\n"
								+ "⠀⠳⣅⢀⢢⠡⠀⡜⢿⣿⣿⡏⠑⡴⠙⣤⠊⠑⡴⠁⢻⣿⣿⣿⠇⢀⡞⠀\r\n"
								+ "⠀⠀⠘⢯⠀⡆⠀⠐⡨⡻⣿⣧⣤⣇⣀⣧⣀⣀⣷⣠⣼⣿⣿⣿⠀⢿⠀⠀\r\n"
								+ "⠀⠀⠀⠈⢧⡐⡄⠀⠐⢌⠪⡻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⢸⠀⠀\r\n"
								+ "⠀⠀⠀⠀⠀⠙⢾⣆⠠⠀⡁⠘⢌⠻⣿⣿⠻⠹⠁⢃⢹⣿⣿⣿⡇⡘⡇⠀\r\n"
								+ "⠀⠀⠀⠀⠀⠀⠀⠈⠛⠷⢴⣄⠀⢭⡊⠛⠿⠿⠵⠯⡭⠽⣛⠟⢡⠃⡇⠀\r\n"
								+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠲⠬⣥⣀⡀⠀⢀⠀⠀⣠⡲⢄⡼⠃⠀\r\n"
								+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠓⠒⠒⠒⠋⠉⠀⠀⠀");
						System.out.println("Ruim demais, tente novamente. \n você fez " + pontoSoma + " pontos");
						
						
					}
				
				}
				// colocar no rank
				System.out.println("Parça, informe seu nome e veja o ranking:");
				String nome = ler.next();
				
				
				ranking.add(new Jogador(nome,pontoSoma));
				mostrarRanking(ranking);
				System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\r\n"
						+ "░░░░░░░░░░░░░▄▄▄▄▄▄▄░░░░░░░░░\r\n"
						+ "░░░░░░░░░▄▀▀▀░░░░░░░▀▄░░░░░░░\r\n"
						+ "░░░░░░░▄▀░░░░░░░░░░░░▀▄░░░░░░\r\n"
						+ "░░░░░░▄▀░░░░░░░░░░▄▀▀▄▀▄░░░░░\r\n"
						+ "░░░░▄▀░░░░░░░░░░▄▀░░██▄▀▄░░░░\r\n"
						+ "░░░▄▀░░▄▀▀▀▄░░░░█░░░▀▀░█▀▄░░░\r\n"
						+ "░░░█░░█▄▄░░░█░░░▀▄░░░░░▐░█░░░\r\n"
						+ "░░▐▌░░█▀▀░░▄▀░░░░░▀▄▄▄▄▀░░█░░\r\n"
						+ "░░▐▌░░█░░░▄▀░░░░░░░░░░░░░░█░░\r\n"
						+ "░░▐▌░░░▀▀▀░░░░░░░░░░░░░░░░▐▌░\r\n"
						+ "░░▐▌░░░░░░░░░░░░░░░▄░░░░░░▐▌░\r\n"
						+ "░░▐▌░░░░░░░░░▄░░░░░█░░░░░░▐▌░\r\n"
						+ "░░░█░░░░░░░░░▀█▄░░▄█░░░░░░▐▌░\r\n"
						+ "░░░▐▌░░░░░░░░░░▀▀▀▀░░░░░░░▐▌░\r\n"
						+ "░░░░█░░░░░░░░░░░░░░░░░░░░░█░░\r\n"
						+ "░░░░▐▌▀▄░░░░░░░░░░░░░░░░░▐▌░░\r\n"
						+ "░░░░░█░░▀░░░░░░░░░░░░░░░░▀░░░\r\n"
						+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
				
				
          	} else if(escolha ==2) { 
          		System.out.println("Acompanhe as últimas pontuações, e supere a cada jogo:"
          				+"RANKING ATUAL"
          				);
          		
          		
          		mostrarRanking(ranking);
          		
          	} else if (escolha ==3) {
          		System.out.println("\u001B[33m🅸\u001B[34m🅽\u001B[35m🆂\u001B[36m🆃\u001B[31m🆁\u001B[33m🆄\u001B[34m🅲\u001B[31m🅾\u001B[36m🅴\u001B[33m🆂\u001B[32m 🅳\u001B[35m🅾\u001B[36m 🅹\u001B[31m🅾\u001B[33m🅶\u001B[35m🅾\u001B[0m\n");
          		System.out.println("1 - Ao iniciar o jogo irá apresentar o nome de uma cor\n2- Digite a cor da palavra\n\n Obs:\n *A cada acerto, o desafio aumenta com a diminuição de 2 segundos a cada rodada\n *Ao final registre o seu nome e veja sua pontuação no ranking");
          	} else if(escolha ==4){
          		System.exit(0);
          	}
	    }
	
	}
	
	public static void mostrarRanking(ArrayList<Jogador> ranking) {
		
		
		for (int posicao = 0;ranking.size() > posicao; ++posicao){
  			Jogador jogador = ranking.get(posicao);
  			String nome = jogador.nome;
  			int pontos = jogador.pontuacao;
  			System.out.println(nome + " " + pontos);
  		}
	}
	
	public static class Jogador {
		
		String nome;
		int pontuacao;
		
		public Jogador(String nome, int pontuacao) {
			this.nome = nome;
			this.pontuacao = pontuacao;
		}
		
	}
	
	public static class ConsoleInputReadTask implements Callable<String> {
		
		public String call() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    // System.out.println("ConsoleInputReadTask run() called.");
		    String input;
		    do {
			    // System.out.println("Please type something: ");
			    try {
			    	// wait until we have data to complete a readLine()
			        while (!br.ready()) {
			            Thread.sleep(200);
			        }
			        input = br.readLine();
			    } catch (InterruptedException e) {
			        // System.out.println("ConsoleInputReadTask() cancelled");
			        return null;
			    }
		    } while ("".equals(input));
		    // System.out.println("Thank You for providing input!");
		    return input;
		}
	}

	public static class ConsoleInput {
		
	    private final int tries;
	    private final int timeout;
	    private final TimeUnit unit;

	    public ConsoleInput(int tries, int timeout, TimeUnit unit) {
	    	this.tries = tries;
	    	this.timeout = timeout;
	    	this.unit = unit;
	    }

	    public String readLine() throws InterruptedException {
	    	ExecutorService ex = Executors.newSingleThreadExecutor();
	    	String input = null;
	    	try {
		        // start working
		        for (int i = 0; i < tries; i++) {
		        	// System.out.println(String.valueOf(i + 1) + ". loop");
		        	Future<String> result = ex.submit(new ConsoleInputReadTask());
		        	try {
		        		input = result.get(timeout, unit);
		        		break;
			        } catch (ExecutionException e) {
			        	e.getCause().printStackTrace();
			        } catch (TimeoutException e) {
				        // System.out.println("Cancelling reading task");
				        result.cancel(true);
				        // System.out.println("\nThread cancelled. input is null");
			        }
			    }
		    } finally {
		    	ex.shutdownNow();
		    }
		    return input;
		}
	}

}
