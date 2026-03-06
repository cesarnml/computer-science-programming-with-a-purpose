public class RulerRecursive {
    public static String subdivide(int n) {
        if (n == 0)
            return " ";
        return subdivide(n - 1) + n + subdivide(n - 1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String ruler = subdivide(n);
        StdOut.println(ruler);
    }
}
