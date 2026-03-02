/**
 * Compilation: javac HelloGoodbye.java
 * Execution: java HelloGoodbye [name1] [name2]
 *
 * Prints hello and goodbye messages using two names provided as command-line
 * arguments. The hello message uses the names in the given order, while the
 * goodbye message uses them in reverse order.
 *
 * % java HelloGoodbye Kevin Bob
 * Hello Kevin and Bob.
 * Goodbye Bob and Kevin.
 *
 * % java HelloGoodbye Alejandra Bahati
 * Hello Alejandra and Bahati.
 * Goodbye Bahati and Alejandra.
 */
public class HelloGoodbye {
    public static void main(String[] args) {
        String name1 = args[0];
        String name2 = args[1];
        System.out.println("Hello " + name1 + " and " + name2 + ".");
        System.out.println("Goodbye " + name2 + " and " + name1 + ".");
    }
}
