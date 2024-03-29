package UnionFind;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class UnionFindBenchMark {
    private final static int MIN = 100_000, MAX = 1_000_000, PAS = 1000;
    private static Random rand = new Random();
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
                            uf.find(rand.nextInt(MAX)); // Random find
                        }
                    },
                    uf -> {
                        for (int i = 1; i < MAX; i++) {
                            int randomElement1 = rand.nextInt(MAX);
                            int randomElement2 = rand.nextInt(MAX);
                            uf.mergeSet(randomElement1, randomElement2); // Random merge
                        }
                    },
                    uf -> {
                        for (int i = 0; i < MAX; i++) {
                            uf.remove(i,rand.nextInt(MAX)); // Random remove
                        }
                    }
            );

            System.out.print("Friends;Add time;Find time;Merge time;Remove time\n");
//            long startTime = System.nanoTime();
            for (int n = MIN; n <= MAX; n += PAS) {
                System.out.print(n);
                UnionFind<Integer> unionFind = new UnionFind<Integer>();
                for (int i = 0; i < functions.size(); i++) {
                    Consumer<UnionFind<Integer>> f = functions.get(i);
                    double time = getTime(f, unionFind);
                    System.out.print(";" + time);
                }
                System.out.println();
            }
//            Ne sera pas utilisé pour le csv
//            double totalTime = (System.nanoTime() - startTime) / 1E6;
//            System.out.print("\nTemps total pour terminer le programme : " + totalTime + " ms");

            out.close(); // On arrête la redirection vers le fichier
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}