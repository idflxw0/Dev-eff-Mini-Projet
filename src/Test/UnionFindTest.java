package Test;
import UnionFind.UnionFind;
public class UnionFindTest {
    final static int MAX_DATA_SIZE = 10000000;
    private static UnionFind<Integer> uf = new UnionFind<Integer>();
    @org.junit.jupiter.api.Test
    void create_data() {
        for (int i = 0; i < MAX_DATA_SIZE; i++) {
            uf.add(i);
        }
    }

    @org.junit.jupiter.api.Test
    void add_data() {

    }

    @org.junit.jupiter.api.Test
    public long getTime() {
        long start = System.currentTimeMillis();
        //function_to_launch();
        long end = System.currentTimeMillis();
        return (end-start)/1000;
    }

    @org.junit.jupiter.api.Test
    void compareTime() {
    }
}