# Snake and Ladder Game

This is a simple implementation of the classic **Snake and Ladder** game in Java. The game involves multiple players, a board containing snakes and ladders, and dice rolls to determine player movement.

## Features

- **Multiple players** can participate.
- A **board** with customizable snakes and ladders.
- Players **roll dice**, move across the board, and encounter **snakes** (which bring them down) or **ladders** (which take them up).
- The **first player to reach the last position** on the board wins the game.

## Game Flow

1. **Players take turns** rolling a pair of dice.
2. Based on the dice roll, the player's position is updated.
3. If a player lands on the starting point of a **snake**, they move down to the snake's tail.
4. If a player lands on the starting point of a **ladder**, they move up to the ladder's top.
5. The **first player to reach the last position** on the board wins the game.

## Classes

### Dice

This class is responsible for simulating a roll of dice.

- **Attributes**:
  - `numberOfDice`: The number of dice used.
- **Methods**:
  - `roll()`: Returns a random number based on the dice roll.

### Player

This class represents a player in the game.

- **Attributes**:
  - `name`: The player's name.
  - `position`: The player's current position on the board.
- **Methods**:
  - `getName()`: Returns the player's name.
  - `getPosition()`: Returns the player's current position.
  - `setPosition()`: Updates the player's position.

### Entity

This class represents a snake or ladder on the board.

- **Attributes**:
  - `start`: The starting position of the snake/ladder.
  - `end`: The ending position of the snake/ladder.

### Board

This class represents the game board.

- **Attributes**:
  - `size`: The total number of cells on the board.
  - `entities`: A list of all snakes and ladders.
- **Methods**:
  - `getSize()`: Returns the size of the board.
  - `getNewPosition()`: Returns the new position after checking for any snakes or ladders.

### GameManager

This class manages the overall game.

- **Attributes**:
  - `board`: The game board.
  - `playersQueue`: A queue to keep track of the player's turns.
  - `dice`: The dice used in the game.
  - `winner`: The player who wins the game.
- **Methods**:
  - `playGame()`: Manages the flow of the game, rolling dice, moving players, and checking for a winner.

## How to Run

1. Clone or download the project files.
2. Compile and run the `SnakeAndLadderGame` class to start the game.
3. The game will automatically play out, with each player's turn displayed, showing dice rolls and movements on the board.

## Example

Here is an example of how the game progresses:

