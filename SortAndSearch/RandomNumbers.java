import java.util.Random;
import java.util.Arrays;
public class RandomNumbers {
    Random generator;
    Integer [ ] collection;
    public RandomNumbers(int cap, int totVal)    {
        generator = new Random();
        collection = new Integer [totVal];
        for (int i=0; i<totVal; i++) {
            int primitive = generator.nextInt(cap);
            Integer obj = new Integer(primitive);
            collection[i] = obj;
        }
    }
    public void printAll(String desc) {
        int size = collection.length;
        System.out.printf("--- %s ---\n",desc);
        for (int i=0; i<size; i++) {
            System.out.printf(" %d",collection[i]);
        }
        System.out.println();
    }
    public void sortAll() {
        Arrays.sort(collection);
    }
    public int whereIs(int num) {
        return Arrays.binarySearch(collection,num);
    }
    public static void main () {
        RandomNumbers rn = new RandomNumbers(100,10);
        rn.printAll("Random numbers");
        rn.sortAll();
        rn.printAll("Sorted numbers");
        int where = rn.whereIs(50);
        rn.printAll("50 is at "+where);
    }
}
