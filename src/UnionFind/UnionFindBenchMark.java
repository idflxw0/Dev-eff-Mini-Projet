package UnionFind;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.Random;

public class UnionFindBenchMark {
    /*
        * Function <Integer,String> il prend un Integer et return un String
        * Consumer <Integer> il prend un Integer et retourne rien
        * C'est mieux qu'on utitilise consumer car toutes les methodes qu'on a fait sont void à part find
        * Mais ici on s'en fout de la valeur de retour de find car on a deja testé find dans UnionFindTest.java
    */
    private final static int MIN = 100_000, MAX = 1_000_000, PAS = 1000;
    private static Random rand = new Random();

    public static double getTime(Consumer<UnionFind<Integer>> function, UnionFind<Integer> uf) {
        long d = System.nanoTime();
        function.accept(uf);
        return (System.nanoTime() - d) / 1E6;
    }
    public static void main(String[] args) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(out);
            List<Consumer<UnionFind<Integer>>> functions = Arrays.asList(
                    uf -> {
                        for (int i = 0; i < MAX; i++) {
                            uf.add(i);
                        }
                    },
                    uf -> {
                        for (int i = 0; i < MAX; i++) {
                            uf.find(rand.nextInt(MAX)); // Random find
                        }
                    },
                    uf -> {
                        for (int i = 1; i < MAX; i++) {
                            int randomElement1 = rand.nextInt(MAX);
                            int randomElement2 = rand.nextInt(MAX);
                            uf.mergeSet(randomElement1, randomElement2); // Random merge
                        }
                    }
            );

            List<String> descriptions = Arrays.asList("add time: ", "find time: ", "merge time: ");
            long startTime = System.nanoTime();
            for (int n = MIN; n <= MAX; n += PAS) {
                System.out.print(n + "\t");
                UnionFind<Integer> unionFind = new UnionFind<Integer>();
                for (int i = 0; i < functions.size(); i++) {
                    Consumer<UnionFind<Integer>> f = functions.get(i);
                    double time = getTime(f, unionFind);
                    System.out.print(descriptions.get(i) + time + "\t");
                }
                System.out.println();
            }
            double totalTime = (System.nanoTime() - startTime) / 1E6;
            System.out.println("Temps total pour terminer le programme: " + totalTime + " ms");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}