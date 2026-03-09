public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (Math.abs(k) > n) {
            return 0;
        }

        int width = 2 * n + 1;
        int offset = n;

        long[] prev = new long[width];
        prev[offset] = 1;

        for (int i = 1; i <= n; i++) {
            long[] curr = new long[width];
            for (int j = -i; j <= i; j++) {
                int idx = j + offset;

                long left = (idx - 1 >= 0) ? prev[idx - 1] : 0;
                long mid = prev[idx];
                long right = (idx + 1 < width) ? prev[idx + 1] : 0;

                curr[idx] = left + mid + right;
            }
            prev = curr;
        }

        return prev[k + offset];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
