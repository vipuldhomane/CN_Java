package OOPs.Othello;

import java.util.*;

public class Othello {

    public static void main(String[] args) {
        // Create a new OthelloBoard object
        OthelloBoard b = new OthelloBoard();
        // Create a Scanner object to read input
        Scanner s = new Scanner(System.in);
        // Read the number of moves
        int n = s.nextInt();
        // Initialize a boolean variable to indicate whose turn it is
        boolean p1Turn = true;
        // Loop until all moves are done
        while (n > 0) {
            // Read the coordinates of the move
            int x = s.nextInt();
            int y = s.nextInt();
            // Initialize a boolean variable to store the result of the move
            boolean ans = false;
            // Check if it is player 1's turn
            if (p1Turn) {
                // Call the move method with player 1's symbol and coordinates
                ans = b.move(OthelloBoard.player1Symbol, x, y);
            } else {
                // Call the move method with player 2's symbol and coordinates
                ans = b.move(OthelloBoard.player2Symbol, x, y);
            }
            // Check if the move was valid
            if (ans) {
                // Print the board after the move
                b.print();
                // Switch the turn
                p1Turn = !p1Turn;
                // Decrease the number of moves left
                n--;
            } else {
                // Print false if the move was invalid
                System.out.println(ans);
            }
        }
        // Close the scanner object
        s.close();
    }
}

// final static int player1Symbol = 1;
// final static int player2Symbol = 2;

// public static void main(String[] args) {
// Scanner s = new Scanner(System.in);
// OthelloBoard b = new OthelloBoard();
// int n = s.nextInt();
// boolean p1Turn = true;
// while (n > 0) {
// int x = s.nextInt();
// int y = s.nextInt();
// boolean ans = false;
// if (p1Turn) {
// ans = b.move(player1Symbol, x, y);
// } else {
// ans = b.move(player2Symbol, x, y);
// }
// if (ans) {
// b.print();
// p1Turn = !p1Turn;
// n--;
// } else {
// System.out.println(ans);
// }
// }
// }
// }
// private Player player1, player2;
// private OthelloBoard board;
// private int numPlayers;

// public static void main(String[] args) {
// Othello newGame = new Othello();
// newGame.startGame();
// }

// private void startGame() {
// Scanner s = new Scanner(System.in);
// player1 = takePlayerInput(++numPlayers);
// player2 = takePlayerInput(++numPlayers);

// }

// private Player takePlayerInput(int i) {
// Scanner s = new Scanner(System.in);
// System.out.println("Enter player" + i + " Name");
// String name = s.nextLine();
// System.out.println("Enter player " + i + " Symbol");
// char symbol = s.next().charAt(0);
// Player p = new Player(name, symbol);
// return p;
// }
