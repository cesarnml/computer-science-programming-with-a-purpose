public class RevesPuzzle {
    private static void move(int disc, char from, char to) {
        StdOut.println("Move disc " + disc + " from " + from + " to " + to);
    }

    private static void hanoi(int n, int offset, char from, char to, char temp) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, offset, from, temp, to);
        move(offset + n, from, to);
        hanoi(n - 1, offset, temp, to, from);
    }

    private static void reves(int n, int offset, char from, char to, char temp1, char temp2) {
        if (n == 0) {
            return;
        }

        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        reves(k, offset, from, temp1, to, temp2);
        hanoi(n - k, offset + k, from, to, temp2);
        reves(k, offset, temp1, to, from, temp2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, 0, 'A', 'D', 'B', 'C');
    }
}
