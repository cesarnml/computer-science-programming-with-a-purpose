/*
 * Compilation:  javac RandomWalker.java
 * Execution:    java RandomWalker r
 *
 * Takes a single command-line argument r and performs a random walk until
 * the walker is at Manhattan distance r from the origin. At each step, the
 * walker moves one unit north, south, east, or west with equal probability.
 * Prints the coordinates after each step and the total number of steps taken.
 *
 * % java RandomWalker 5
 * (0, 1)
 * (1, 1)
 * (1, 0)
 * (1, -1)
 * (1, -2)
 * (0, -2)
 * steps 6
 */
public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int position_x = 0;
        int position_y = 0;
        int distance = 0;
        int steps = 0;

        System.out.println("(" + position_x + ", " + position_y + ")");
        while (distance < r) {
            int direction = (int) (Math.random() * 4); // 0 -> up, 1 -> right, 2 -> down, 3 -> left
            if (direction == 0) {
                position_y += 1;
            } else if (direction == 1) {
                position_x += 1;
            } else if (direction == 2) {
                position_y -= 1;
            } else if (direction == 3) {
                position_x -= 1;
            }
            steps += 1;
            distance = Math.abs(position_x) + Math.abs(position_y);
            System.out.println("(" + position_x + ", " + position_y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
