/*package game;

import java.util.Scanner;

import game.core.board.Board;
import game.core.pieces.robots.Robot;

public class Game {

    private Scanner input;
    private String player;
    private Board board;
    private Robot walker, pawn, rook, bishop, knight, king, queen;
    
    public Game() {
        this.input = new Scanner(System.in);
        board = null;        
    }

    private void start() {

        clear();
        System.out.println((char)27 + "[32m" + "Olá, obrigado por jogar O Regaste dos Alunos de Técnicas de Programação na Ilha de Java \n\nQual o seu nome?" +(char)27+ "[39m");
        this.player = (char)27 +"[32m"+input.nextLine()+ (char)27  +"[39m";

        clear();
        System.out.println("Olá, "+player+" essas são as regras:");

        System.out.println((char)27 + "[31m"+"\n\nLEIA COM ATENÇÃO\n\n" + (char)27 + "[39m");

        System.out.println("1º - Você terá liberdade de escolher 7 peças para contolar");
        System.out.println("2º - Ao controlar uma peça você poderá fazer 2 tipos de movimento, para frente e para traz");
        System.out.println("3º - O objetivo do jogo é resgatar todos os "+ (char)27 +"[32m"+"ALUNOS"+ (char)27 + "[39m"+" que estão podem ser identificados pelo simbolo " + (char)27 +"[32m"+"■"+ (char)27 +"[39m");
        System.out.println("4º - Mas cuidado com os "+ (char)27 +"[31m"+"BUGS"+ (char)27 + "[39m"+" pelo caminho! Eles são identificados pelo simbolo " + (char)27 +"[31m"+"X"+ (char)27 + "[39m");
        System.out.println("Para sair do jogo basta digitar \"sair\" ");

        System.out.println("\nPRESSIONE ENTER CASO TENHA ENTENDIDO.");
        input.nextLine();

        clear();

        createBoard();
        createReferences();
    }

    private void endGame() {
        clear();

        System.out.println("Adeus! \n\n Aqui está um relatório de seu progresso no jogo: \n");
        //board.relatory();
        System.out.println("Volte para jogar novamente!");
    }

    private void actions() {
        String op;

        if(!board.getSituation())  {
            return;
        }

        do {
            System.out.println("\nQual peça deseja movimentar?");
            op = input.nextLine();
            
        
            switch (op.toLowerCase()) {
                case "andador":
                case "1":
                    walk(walker);
                    break;
                case "peão":
                case "2":
                    walk(pawn);
                    break;
                case "torre":
                case "3":
                    walk(rook);
                    break;
                case "bispo":
                case "4":
                    walk(bishop);
                    break;
                case "cavalo":
                case "5":
                    walk(knight);
                    break;
                case "rei":
                case "6":
                    walk(king);
                    break;
                case "rainha":
                case "7":
                    walk(queen);
                    break;
                case "sair":
                    
                    return;
                default:
                    System.out.println("\nPeça inválida!");
                    break;
            }
        
        } while (!op.equalsIgnoreCase("sair"));
    }

    private void walk(Robot piece) {

        System.out.println("\n Quantas casas deseja mover a peça?\n");
        int moves = input.nextInt();
        
        

        board.walk(piece, board, moves);

    }

    private void createReferences() {
        walker = board.getWalker();
        pawn = board.getPawn();
        rook = board.getRook();
        bishop = board.getBishop();
        knight = board.getKnight();
        king = board.getKing();
        queen = board.getQueen();
    }

    private void createBoard() {
        boolean ok = false;

        int X = 0;
        int Y = 0;
        

        int students = 0;
        int bugs = 0;

        System.out.print("Insira o valor desejado de linhas e colunas: - Ex.: 7 X 8 = 7 8");
        System.out.println("\nValor minimo: 5\n");

        do {

            Y = input.nextInt();
            X = input.nextInt();
            

            if(X < 5 && Y < 5) {
                clear();
                System.out.println("Invalid X and Y values, please try again.");
            } else if (X < 5) {
                clear();
                System.out.println("Invalid X value, please try again.");
            } else if (Y < 5) {
                clear();
                System.out.println("Invalid Y value, please try again.");
            } else {
                ok = true;
            }


        } while (!ok);

        clear();

        ok = false;

        System.out.print("Insira o valor desejado de alunos e bugs, respectivamente: - Ex.: 4 alunos e 7 bugs = 4 7");
        System.out.println("\nValor minimo: Os dois somados tem que ser menos de "+((X*Y)/2)+"\n");

        do {

            students = input.nextInt();
            bugs = input.nextInt();

            if((bugs + students) >= ((X*Y)/2) || bugs < 0 || students < 0) {
                clear();
                System.out.println("Número de estudantes e bugs inválido");
            } else {
                ok = true;
            }

        }while(!ok);

        board = new Board(X, Y, students, bugs);

        
    }

    private void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

}
*/
