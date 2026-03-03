/*
 * Compilation:  javac ThueMorse.java
 * Execution:    java ThueMorse n
 *
 * Takes an integer command-line argument n and prints an n-by-n pattern.
 * Creates a Thue-Morse sequence by starting with 0 and successively
 * appending the bitwise negation of the existing sequence. Prints + if
 * bits i and j in the sequence are equal, and - if they are different.
 * Includes two space characters between each + and - character.
 *
 * % java ThueMorse 4
 * +  -  -  +
 * -  +  +  -
 * -  +  +  -
 * +  -  -  +
 */
public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] thueMorse = { 0 };
        int length = 1;

        while (length < n) {
            // Double the array size
            int[] newThueMorse = new int[length * 2];
            // Copy existing sequence
            for (int i = 0; i < length; i++) {
                newThueMorse[i] = thueMorse[i];
            }
            // Append flipped sequence
            for (int i = 0; i < length; i++) {
                newThueMorse[length + i] = 1 - thueMorse[i];
            }
            thueMorse = newThueMorse;
            length *= 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thueMorse[i] == thueMorse[j]) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }
                if (j != n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
