import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static long getTime(Object p1) throws IllegalArgumentException {
        if (p1 instanceof HashMap<?,?>) {
            HashMap<Integer,String> dict = (HashMap<Integer, String>) p1;
            useDict(dict);
        }
        else if (p1 instanceof ArrayList<?>) {
            ArrayList<Integer> list = (ArrayList<Integer>) p1;
            useArrayList(list);
        }
        else
            throw new IllegalArgumentException("Bad type chosen");
        long start = System.currentTimeMillis();



        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void useDict(HashMap<Integer,String> dictionary) {
        StringBuilder sb = new StringBuilder();
        sb.append("Your dictionary contains : \n");
        boolean first = true;
        for (Integer element : dictionary.keySet()) {
            if (!first) {
                sb.append("\n");
            }
            sb.append("key : " + element + ", value : " + dictionary.get(element));
            first = false;
        }
        System.out.println(sb + ".");
        //System.out.println("Your dict contains the value " + dictionary.get("Test") + " for 'Test'\n\n");
    }

    private static void useArrayList(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("Your list contains : ");
        boolean first = true;
        for (Integer element : list) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(element);
            first = false;
        }
        System.out.println(sb + ".");
    }

    public static void main (String[] args) {
        HashMap<Integer,String> dico = new HashMap<Integer,String>();
        dico.put(1,"Hello");
        dico.put(2,"world");
        System.out.println("Time to read the dictionary : " + getTime(dico) + " milliseconds.\n");


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Time to read the ArrayList : " + getTime(list) + " milliseconds.\n");
    }
}
