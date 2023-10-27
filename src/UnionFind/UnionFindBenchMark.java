package UnionFind;
import UnionFind.UnionFind;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UnionFindBenchMark {
    /*
        * Function <Integer, String> : prend un Integer et return un String
        * Consumer <Integer> : prend un Integer et return rien
        * C'est mieux qu'on utilise consumer, car toutes les méthodes qu'on a faites sont void, à part find
        * Mais ici, on s'en fout de la valeur de retour de find parce qu'on a deja testé find dans UnionFindTest.java
    */
    private final static int MIN = 100_000, MAX = 1_000_000, PAS = 1000;

    public static double getTime(Consumer<UnionFind<Integer>> function, UnionFind<Integer> uf) {
        long d = System.nanoTime();
        function.accept(uf);
        return (System.nanoTime() - d) / 1E6;
    }
    public static void main(String[] args) {
        try {
            // On redirige la sortie standard vers un fichier
            PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(out);

            List<Consumer<UnionFind<Integer>>> functions = Arrays.asList (
                    uf -> {
                        for (int i = 0; i < MAX; i++) {
                            uf.add(i);
                        }
                    },
                    uf -> {
                        for (int i = 0; i < MAX; i++) {
                            uf.find(i);
                        }
                    },
                    uf -> {
                        for (int i = 1; i < MAX; i++) {
                            uf.mergeSet(i, i - 1);
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

            out.close(); // Close the output stream
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}