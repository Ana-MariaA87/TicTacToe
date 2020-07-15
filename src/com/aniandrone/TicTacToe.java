package com.aniandrone;

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

    public static void main (String[] args) {

        char[][] gameBoard = {{' ','|',' ', '|', ' '},
                {'-','+','-', '+', '-'},
                {' ','|',' ', '|', ' '},
                {'-','+','-', '+', '-'},
                {' ','|',' ', '|', ' '}};

        PrintGameBoard(gameBoard);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your placement(1-9): ");
            int playerPos = scanner.nextInt();
            while(playerPosition.contains(playerPos) || cpuPosition.contains(playerPosition)) {
                System.out.println("Position taken! Enter a correct Position");
                playerPos--;
                playerPos = scanner.nextInt();

            }


            placePiece(gameBoard, playerPos, "player");
            String result = checkWinner();
            if (result.length() > 0 ) {
                System.out.println(result);
                break;
            }

            Random random = new Random();
            int cpuPosition = random.nextInt(9) + 1;
            while(playerPosition.contains(cpuPosition) || TicTacToe.cpuPosition.contains(cpuPosition)) {
                System.out.println("Position taken! Enter a correct Position");
                cpuPosition--;
                int cpuPos = random.nextInt(9) + 1;

            }
            placePiece(gameBoard, cpuPosition, "cpu");
            PrintGameBoard(gameBoard);

             result = checkWinner();
            if (result.length() > 0 ) {
                System.out.println(result);
                break;
            }

        }

    }

    private static void placePiece(char[][] gameBoard, int position, String user) {
        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPosition.add(position);
        }else if(user.equals("cpu")) {
            symbol = 'O';
            cpuPosition.add(position);
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);

        List leftColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftColumn);
        winning.add(middleColumn);
        winning.add(rightColumn);
        winning.add(cross1);
        winning.add(cross2);

        for (List list : winning) {
            if (playerPosition.containsAll(list)) {
                return "Congratulation you won! ";
            } else if (cpuPosition.containsAll(list)) {
                return "CPU wins! Sorry...";
            } else if (playerPosition.size() + cpuPosition.size() == 9) {
                return "CAT!";
            }
        }
        return "";
    }

    private static void PrintGameBoard(char[][] gameBoard) {
          for (char[] row : gameBoard) {
              for(char c : row) {
                  System.out.print(c);
              }
              System.out.println();
          }
      }
  }