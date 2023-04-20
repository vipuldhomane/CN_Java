package OOPs.OOPs1.Fractionclass;

/**
 * Fraction
 */
public class Fraction {
    int Numerator;
    int Denominator;

    public Fraction(int Numerator, int Denominator) {
        this.Numerator = Numerator;
        this.Denominator = Denominator;
        // GCD
        simplify();
    }

    private void simplify() {
        // Finding Greatest Common Divisor
        int GCD = 1;
        int smaller = Math.min(Numerator, Denominator);

        for (int i = 2; i <= smaller; i++) {
            if (Numerator % 2 == 0 && Denominator % 2 == 0) {
                GCD = i;
            }
        }
        Numerator /= GCD;
        Denominator /= GCD;
    }

    public void print() {
        System.out.println(Numerator + "/" + Denominator);
    }

    public void increment() {
        Numerator = Numerator + Denominator;
        simplify();
    }

    public void setNumerator(int Numerator) {
        this.Numerator = Numerator;

    }

    public int getNumerator() {
        return this.Numerator;
    }

    public void setDenominator(int Denominator) {

        if (Denominator == 0) {
            System.out.println("ZeroDivision Error");
            return;
        }
        this.Denominator = Denominator;

    }

    public int getDenominator() {
        return this.Denominator;
    }

    public void add(Fraction f2) {
        this.Numerator = this.Numerator * f2.Denominator + this.Denominator * f2.Numerator;
        this.Denominator = this.Denominator * f2.Denominator;
        simplify();
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        int newNum = f1.Numerator * f2.Denominator + f1.Denominator * f2.Numerator;
        int newDeno = f1.Denominator * f2.Denominator;
        Fraction f3 = new Fraction(newNum, newDeno);
        return f3;

    }

}