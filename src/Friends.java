import java.util.Stack;

public class Friends {
    private int[] initialization(int size) {
        int[] friends = new int[size];
        for (int i = 0; i < size; i++) {
            friends[i] = i;
        }
        return friends;
    }

    public int determineRepresentative(int[] friends, int citizen) {
        int representative = citizen;
        while (friends[representative] != representative) {
            int tmp = representative;
            representative = friends[representative];
            friends[tmp] = friends[representative];
        }
        return representative;
    }

    public int determineRepresentativeV2(int[] friends, int citizen) {
        int representative = citizen;
        while (friends[representative] != representative) {
            representative = friends[representative];
        }
        int f = citizen;
        while (friends[f] != f) {
            int tmp = f;
            f = friends[f];
            friends[tmp] = representative;
        }
        return f; // NOT SURE !!!
    }

    public void changeRepresentative(int[]friends, int citizen1, int citizen2) {
        int representative1 = determineRepresentative(friends,citizen1);
        int representative2 = determineRepresentative(friends,citizen2);
        friends[representative1] = representative2;
    }
}
