import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorBasic {
    public static void main(String[] args) {
        Vector<Integer> vectors = new Vector<>();
        System.out.println(vectors);
        System.out.println(vectors.capacity());
        vectors.add(1);
        System.out.println(vectors);
        System.out.println(vectors.size());
        System.out.println(vectors.capacity());
        vectors.add(2);
        vectors.add(3);
        vectors.add(4);
        vectors.add(5);
        vectors.add(6);
        vectors.add(7);
        vectors.add(8);
        vectors.add(9);
        vectors.add(10);
        vectors.add(11);
        vectors.add(12);
        System.out.println(vectors);
        System.out.println(vectors.capacity());
        vectors.remove(0);
        System.out.println(vectors);
        System.out.println(vectors.capacity());
        vectors.add(0, 1);
        System.out.println(vectors.get(0));
        System.out.println(vectors.firstElement());
        System.out.println(vectors.lastElement());
        System.out.println(vectors.get(vectors.size() - 1));
        System.out.println(vectors.elementAt(11));
        System.out.println(vectors.lastIndexOf(2));
        System.out.println(vectors.indexOf(vectors.lastElement()));

        System.out.println("-------------------------");
        for (int i = 0; i < vectors.size(); i ++) {
            System.out.println(vectors.get(i));
        }

    }
}
