/*
 * Compilation:  javac Divisors.java
 * Execution:    java Divisors a b
 *
 * Takes two integer command-line arguments a and b and computes gcd(a, b),
 * lcm(a, b), whether a and b are relatively prime, and totient values for a
 * and b. Prints results in the required order and format.
 *
 * % java Divisors 1440 408
 * gcd(1440, 408) = 24
 * lcm(1440, 408) = 24480
 * areRelativelyPrime(1440, 408) = false
 * totient(1440) = 384
 * totient(408) = 128
 */
public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        while (absB != 0) {
            int remainder = absA % absB;
            absA = absB;
            absB = remainder;
        }
        return absA;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        int gcd = gcd(a, b);
        return absA / gcd * absB;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(i, n)) {
                count++;
            }
        }
        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.print("gcd(" + a + ", " + b + ") = " + gcd(a, b) + "\n");
        StdOut.print("lcm(" + a + ", " + b + ") = " + lcm(a, b) + "\n");
        StdOut.print("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b) + "\n");
        StdOut.print("totient(" + a + ") = " + totient(a) + "\n");
        StdOut.print("totient(" + b + ") = " + totient(b) + "\n");
    }
}
