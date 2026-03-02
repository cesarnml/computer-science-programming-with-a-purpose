/*
 * Compilation:  javac RandomWalkers.java
 * Execution:    java RandomWalkers r trials
 *
 * Takes two integer command-line arguments r and trials. Runs trials independent
 * experiments of a random walk until the walker reaches Manhattan distance r from
 * the origin. Computes and prints the average number of steps required across all
 * trials.
 *
 * % java RandomWalkers 5 1000000
 * average number of steps = 14.96188
 */
public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double average = 0.0;

        for (int i = 0; i < trials; i++) {
            int position_x = 0;
            int position_y = 0;
            int distance = 0;

            int steps = 0;
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
            }
            average += steps;
        }
        average = average / (double) trials;
        System.out.println("average number of steps = " + average);
    }
}
