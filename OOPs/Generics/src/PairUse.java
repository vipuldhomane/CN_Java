package OOPs.Generics.src;

public class PairUse {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(20, 10);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());

        Pair<String> pS = new Pair<>("Audi", "BMW");
        System.out.println(pS.getFirst());
        pS.setFirst("Tesla");
        System.out.println(pS.getFirst());

    }
}
