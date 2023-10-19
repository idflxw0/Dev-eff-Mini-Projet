import java.util.HashMap;
import java.util.Map;

public class UnionFind<T>{
    private Map<T,T> parent;

    public UnionFind() {
        parent = new HashMap<>();
    }
}
