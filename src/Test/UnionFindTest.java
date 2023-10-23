package Test;
import java.util.HashMap;
import java.util.Map;
import UnionFind.UnionFind;
import static org.junit.jupiter.api.Assertions.*;
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
    void add_data() {return;}

    @org.junit.jupiter.api.Test
    void getTime() {}

    @org.junit.jupiter.api.Test
    void compareTime() {
    }


}
