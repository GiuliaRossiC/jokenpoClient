package cliente;

import java.rmi.Naming;
import java.util.Random;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        System.out.println("Carregando o cliente.");

        try {
            InterJokenpo objRemoto
                    = (InterJokenpo) Naming.lookup("rmi://LOCALHOST:1099/calcula");

            Scanner read = new Scanner(System.in);

            System.out.println("Nome Jogador 1");
            String player1 = read.nextLine();

            System.out.println("=========================== /// ============================");
            System.out.println("=========================== /// ============================");

//            System.out.println("Nome jogador 2");
//            String player2 = read.nextLine();

            System.out.println("Faça sua jogada " + player1 + " Pedra | Papel | Tesoura");
            String jogadaPlayer1 = read.nextLine();

            System.out.println("=========================== /// ============================");
            System.out.println("=========================== /// ============================");
            System.out.println("=========================== /// ============================");

//            System.out.println("Faça sua jogada " + player2 + " Pedra | Papel | Tesoura");
//            String jogadaPlayer2 = read.nextLine();

            Random r = new Random(); 
            String jogadasCPU[] = {"pedra", "papel", "tesoura"};
            int randomNumber=r.nextInt(jogadasCPU.length); 
            System.out.println("CPU Jogou " + jogadasCPU[randomNumber].toUpperCase()); 

            while (!objRemoto.validarJogada(jogadaPlayer1)) {
                System.out.println("Jogada Invalida por favor faça novamente");

                System.out.println("Faça sua jogada novamente " + player1 + " Pedra | Papel | Tesoura");
                jogadaPlayer1 = read.nextLine();
            }
              
            String vencedor = objRemoto.retornarVencedor(player1, "CPU", jogadaPlayer1, jogadasCPU[randomNumber]);
            Thread.sleep(2000);
            System.out.println("=========================== /// ============================");
            if (!vencedor.equals("empate")) {
                System.out.println("Parabéns " + vencedor + " você ganhou o jogo");
            } else {
                System.out.println("Deu empate !!");
            }
//            
//            Scanner entrada = new Scanner(System.in);
//            
//            System.out.println("Opção 1 - Soma");
//            System.out.println("Opção 2 - Subtração");
//            System.out.println("Opção 3 - Multiplicação");
//            System.out.println("Opção 4 - Divisão");
//            
//            int opcao = entrada.nextInt();
//            
//            switch(opcao){
//                case 1: 
//                    double resp = objRemoto.soma(50, 45);
//                    System.out.println("Soma = " + resp);
//                case 2:
//                    double resp1 = objRemoto.subtracao(50, 45);
//                    System.out.println("Subtracao" + resp1);
//                case 3:
//                    double resp2 = objRemoto.multiplicacao(50,45);
//                    System.out.println("Multiplicação" + resp2);
//                case 4:
//                    double resp3 = objRemoto.divisao(50,45);
//                    System.out.println("Divisão" + resp3);  
//            }       
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
