package OOPs.OOPs1.DynamicArray;

public class DynamicArrayUse {

    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();

        for (int i = 0; i < 100; i++) {
            d.add(i);
        }
        System.out.println(d.size());
        System.out.println(d.get(99));
        d.set(3, 170);
        System.out.println(d.get(3));
        d.removeLast();
        System.out.println(d.get(98));
        // while (!d.isEmpty()) {
        // System.out.println(d.removeLast());
        // System.out.println("size- " + d.size());
        // }

    }
}
