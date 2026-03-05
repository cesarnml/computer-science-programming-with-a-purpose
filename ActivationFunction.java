/*
 * Compilation:  javac ActivationFunction.java
 * Execution:    java ActivationFunction x
 *
 * Takes one double command-line argument x and computes five activation
 * functions: heaviside, sigmoid, tanh, softsign, and sqnl. Prints each value
 * in the required order and format.
 *
 * % java ActivationFunction 0.0
 * heaviside(0.0) = 0.5
 *   sigmoid(0.0) = 0.5
 *      tanh(0.0) = 0.0
 *  softsign(0.0) = 0.0
 *      sqnl(0.0) = 0.0
 */
public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        if (x < 0.0) {
            return 0.0;
        } else if (x > 0.0) {
            return 1.0;
        } else {
            return 0.5;
        }
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        return 1.0 / (1.0 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        double a = Math.exp(x);
        double b = Math.exp(-x);
        return (a - b) / (a + b);
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        return x / (1.0 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        if (x <= -2.0) {
            return -1.0;
        } else if (x > -2.0 && x < 0.0) {
            return x + (x * x) / 4.0;
        } else if (x >= 0.0 && x < 2.0) {
            return x - (x * x) / 4.0;
        } else {
            return 1.0;
        }
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.printf("%9s(%s) = %s%n", "heaviside", x, heaviside(x));
        StdOut.printf("%9s(%s) = %s%n", "sigmoid", x, sigmoid(x));
        StdOut.printf("%9s(%s) = %s%n", "tanh", x, tanh(x));
        StdOut.printf("%9s(%s) = %s%n", "softsign", x, softsign(x));
        StdOut.printf("%9s(%s) = %s%n", "sqnl", x, sqnl(x));
    }
}
