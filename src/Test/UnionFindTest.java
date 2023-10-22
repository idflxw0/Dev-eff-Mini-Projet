package Test;

import java.util.HashMap;
import java.util.Map;
import UnionFind.UnionFind;
import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {
    private static UnionFind<Integer> uf = new UnionFind<Integer>();
    private static void addUf() {
        for (int i = 0; i<=5; i++) uf.add(i);
    }

    @org.junit.jupiter.api.Test
    void add() {
        addUf();
        Map<Integer,Integer> expectedParent = new HashMap<>();
        expectedParent.put(0,0);
        expectedParent.put(1,1);
        expectedParent.put(2,2);
        expectedParent.put(3,3);
        expectedParent.put(4,4);
        expectedParent.put(5,5);

        assertEquals(uf.getParent(), expectedParent);
    }

    @org.junit.jupiter.api.Test
    void find() {
        addUf();
        uf.mergeSet(0,2);
        uf.mergeSet(0,3);
        assertEquals(0,uf.find(0));
        assertEquals(1,uf.find(1));
        assertEquals(0,uf.find(2));
        assertEquals(0,uf.find(3));
        assertEquals(4,uf.find(4));
        assertEquals(5,uf.find(5));
    }

    @org.junit.jupiter.api.Test
    void merge(){
        uf.add(0);
        uf.add(1);
        uf.add(2);
        uf.add(3);
        uf.add(5);
        uf.mergeSet(0,2);
        uf.mergeSet(3,5);
        uf.mergeSet(0,3);
        Map<Integer,Integer> expectedRank = new HashMap<>();
        expectedRank.put(0,2);
        expectedRank.put(1,0);
        expectedRank.put(2,0);
        expectedRank.put(3,1);
        expectedRank.put(5,0);

        System.out.println(uf.getRank());
        assertEquals(uf.getRank(),expectedRank);
    }


}