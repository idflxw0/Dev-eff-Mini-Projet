import java.util.HashMap;
import java.util.Map;

public class UnionFind<T>{
    private Map<T,T> parent;
    private Map<T,Integer> rank;

    public UnionFind() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

}
