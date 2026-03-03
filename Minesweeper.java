/*
 * Compilation:  javac Minesweeper.java
 * Execution:    java Minesweeper m n k
 *
 * Takes three integer command-line arguments m, n, and k. Generates an
 * m-by-n grid with exactly k mines placed uniformly at random. For each
 * non-mine cell, counts the number of neighboring mines (in all 8 adjacent
 * cells). Prints the grid with '*' for mines and the count of neighboring
 * mines for other cells, separated by two spaces.
 *
 * % java Minesweeper 9 9 10
 * 0  1  *  1  0  0  0  1  *
 * 1  3  2  2  0  0  1  1
 */
public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        char[][] maze = new char[m][n];

        // Place the mines
        int placed = 0;
        while (placed < k) {
            int randomIndex = (int) (Math.random() * m * n);
            int row = randomIndex / n;
            int col = randomIndex % n;
            if (maze[row][col] != '*') {
                maze[row][col] = '*';
                placed++;
            }
        }

        // Print out
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if this location is a mine
                if (maze[i][j] == '*') {
                    System.out.print("*");
                } else {
                    int mineCount = 0;
                    // top neighbors
                    int checkRow = i - 1;
                    for (int a = -1; a < 2; a++) {
                        int checkCol = j + a;
                        // Check if neighbor in maze
                        if (checkRow >= 0 && checkRow < m && checkCol >= 0 && checkCol < n) {
                            // Check if neighbor is a bomb, if so increment count
                            if (maze[checkRow][checkCol] == '*') {
                                mineCount++;
                            }
                        }
                    }
                    // middle neighbors
                    checkRow = i;
                    for (int a = -1; a < 2; a += 2) {
                        int checkCol = j + a;
                        // Check if neighbor in maze
                        if (checkRow >= 0 && checkRow < m && checkCol >= 0 && checkCol < n) {
                            // Check if neighbor is a bomb, if so increment count
                            if (maze[checkRow][checkCol] == '*') {
                                mineCount++;
                            }
                        }
                    }
                    // bottom neighbors
                    checkRow = i + 1;
                    for (int a = -1; a < 2; a++) {
                        int checkCol = j + a;
                        // Check if neighbor in maze
                        if (checkRow >= 0 && checkRow < m && checkCol >= 0 && checkCol < n) {
                            // Check if neighbor is a bomb, if so increment count
                            if (maze[checkRow][checkCol] == '*') {
                                mineCount++;
                            }
                        }
                    }
                    System.out.print(mineCount);
                }
                if (j != n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

}
