package Module3.TriesAndHuffman;

public class Triesuse {
    public static void main(String[] args) {

        Trie t = new Trie();
        t.add("AND");
        t.add("AN");
        t.add("NOT");
        System.out.println(t.search("AND"));
        t.remove("AND");
        // t.remove("AND");
        System.out.println(t.search("AND"));
    }
}
