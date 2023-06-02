package game;

import java.util.Scanner;

import game.pieces.robots.Robot;
import game.board.Board;

public class Game {

    private Scanner input;
    private Board board;
    private Robot walker, pawn, rook, bishop, knight, king, queen;
    
    public Game() {
        this.input = new Scanner(System.in);
        board = null;

        createBoard();
        createReferences();
        start();
    }

    private void start() {

        System.out.println((char)27 + "[32m" + "Olá, obrigado por jogar O Regaste dos Alunos de Técnicas de Programação na Ilha de Java \n" +(char)27+ "[39m");

        board.draw();

        while(true) {
            int move = input.nextInt();

            board.walk(queen, board, move);
        }
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
        do {
            int X = input.nextInt();
            int Y = input.nextInt();
            int student = 5;
            int bugs = 5;

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
                board = new Board(X, Y, student, bugs);
                clear();
            }

        } while (board == null);
    }

    private void delay(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}

