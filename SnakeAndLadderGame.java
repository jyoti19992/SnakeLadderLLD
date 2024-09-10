import java.util.*;

class Dice {
    private final int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int roll() {
        Random rand = new Random();
        int min = numberOfDice * 1;      
        int max = numberOfDice * 6;      

        return rand.nextInt(max - min + 1) + min;
    }
}

class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0; 
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}


class Entity {
    private final int start;
    private final int end;

    public Entity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class Board {
    private final int size;
    private final List<Entity> entities; // Single list will hold both snakes and ladders

    public Board(int size, List<Entity> entities) {
        this.size = size;
        this.entities = entities;
    }

    public int getSize() {
        return size;
    }

    public int getNewPosition(int position) {
        // Check for any entity (snake or ladder) at the current position
        for (Entity entity : entities) {
            if (entity.getStart() == position) {
                return entity.getEnd();
            }
        }
        return position; // No entity (snake or ladder) at this position
    }
}

class GameManager {
    private final Board board;
    private final Queue<Player> playersQueue;
    private final Dice dice;
    private Player winner;

    public GameManager(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.playersQueue = new LinkedList<>(players); // Initialize queue with players
        this.dice = dice;
    }

    public void playGame() {
        boolean isGameOver = false;
        while (!isGameOver) {
            // Get the next player from the queue
            Player currentPlayer = playersQueue.poll();

            // Roll the dice
            int diceRoll = dice.roll();
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll);

            // Calculate new position
            int newPosition = currentPlayer.getPosition() + diceRoll;
            if (newPosition > board.getSize()) {
                newPosition = currentPlayer.getPosition(); // If overboard, stay at current position
            } else {
                newPosition = board.getNewPosition(newPosition); // Check for snake or ladder
            }

            // Update player position
            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " moved to " + newPosition);

            // Check if the player has won
            if (newPosition == board.getSize()) {
                System.out.println(currentPlayer.getName() + " wins the game!");
                isGameOver = true;
            } else {
                // If the game is not over, put the player back at the end of the queue
                playersQueue.offer(currentPlayer);
            }
        }
    }
}

// Example usage:
public class SnakeAndLadderGame {
    public static void main(String[] args) {
        // Create entities (snakes and ladders)
        List<Entity> entities = Arrays.asList(
            new Entity(16, 6),  // Snake
            new Entity(47, 26), // Snake
            new Entity(49, 11), // Snake
            new Entity(2, 38),  // Ladder
            new Entity(15, 45), // Ladder
            new Entity(22, 57)  // Ladder
        );

        // Create board
        Board board = new Board(100, entities);

        // Create players
        List<Player> players = Arrays.asList(new Player("Alice"), new Player("Bob"));

        // Create dice (2 dice in this case)
        Dice dice = new Dice(2);

        // Create game manager and start game
        GameManager gameManager = new GameManager(board, players, dice);
        gameManager.playGame();
    }
}
