package UnionFind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind<T>{
    private Map<T,T> parent;
    private Map<T,Integer> rank;

    public UnionFind() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }
    public Map<T,T> getParent() {
        return this.parent;
    }
    public Map<T,Integer> getRank() {
        return this.rank;
    }

    /**
     * Permet de créer un Set
     * @param element : l'élément à ajouter
     */
    public void add(T element) {
        if (!parent.containsKey(element)) {
            parent.put(element,element);
            rank.put(element,0);
        }
    }

    /**
     * Permet de trouver le représentant d'un groupe d'amis
     * @param element : la personne dont on souhaite trouver le représentant
     */
    public T find(T element) {
        if (!parent.get(element).equals(element)) { // Si c'est pas le représentant
            parent.put(element,find(parent.get(element)));
        }
        return parent.get(element);
    }

    /**
     * Permet de fusionner deux sets
     * @param element1 : le premier set
     * @param element2 : le deuxième set
     */
    public void mergeSet(T element1, T element2) {
        T parent = find(element1);
        T parent2 = find(element2);
        if (!parent.equals(parent2)) {
            if (rank.get(parent) < rank.get(parent2)) {
                this.parent.put(parent,parent2);
            }
            else if (rank.get(parent) > rank.get(parent2)) {
                this.parent.put(parent2,parent);
            }
            else {
                this.parent.put(parent2,parent);
                this.rank.put(parent,rank.get(parent)+1);
            }
        }
    }
}
