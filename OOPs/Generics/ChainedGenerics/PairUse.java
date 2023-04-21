package OOPs.Generics.ChainedGenerics;

public class PairUse {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>();
        Pair<String, Integer> pair2 = new Pair<>();
        Pair<Pair<Integer, String>, Pair<String, Integer>> p = new Pair<>();
        p.setFirst(pair1);
        p.setSecond(pair2);
        pair1.setFirst(250);
        pair1.setSecond("Mercedes Benz");
        pair2.setFirst("Audi");
        pair2.setSecond(400);
        System.out.println(p.getFirst().getSecond());
        System.out.println(p.getSecond();
    }
}
