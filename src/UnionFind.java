import java.util.HashMap;
import java.util.Map;

public class UnionFind<T>{
    private Map<T,Integer> parent;

    public UnionFind() {
        parent = new HashMap<>();
    }

    public void mergeSet(UnionFind<T> element1, UnionFind<T> element2) {
        Map<T,Integer> root1 = findParent(element1);
        Map<T,Integer> root2 = findParent(element2);
        if (root1 != root2) {
            if (root1. < root2.) {
                parent.put(root1,root2);
                root2. += 1;
            }
            else {
                parent.put(root2,root1);
                root1. += 1;
            }
        }
    }

    private Map<T,Integer> findParent(UnionFind<T> element2) {

    }
}
