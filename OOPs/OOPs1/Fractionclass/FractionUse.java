package OOPs.OOPs1.Fractionclass;

public class FractionUse {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(8, 24);
        Fraction f2 = new Fraction(16, 64);

        // f1.print();
        // f2.print();
        // f1.add(f2);
        // f1.setNumerator(12);
        // f1.setDenominator(25);
        // f1.print();
        // System.out.println(f1.getDenominator());
        ;

        // f1.increment();
        // f1.print();
        Fraction f3 = Fraction.add(f1, f2);
        f3.print();

    }

}
