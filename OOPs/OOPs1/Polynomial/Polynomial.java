package OOPs.OOPs1.Polynomial;

public class Polynomial {

    /*
     * This function sets coefficient for a particular degree value, if degree is
     * not there in the polynomial
     * then corresponding term with specified degree and value is added int the
     * polynomial. If the degree
     * is already present in the polynomial then previous coefficient is replaced by
     * new coefficient value passed as function argument
     */
    int cof[] = new int[1000];

    public void setCoefficient(int degree, int coeff) {
        this.cof[degree] = coeff;

    }

    // Prints all the terms(only terms with non zero coefficients are to be printed)
    // in increasing order of degree.
    public void print() {
        for (int i = 0; i < this.cof.length; i++) {
            if (this.cof[i] != 0) {
                System.out.print(this.cof[i] + "x" + i + " ");
            }
        }

    }

    // Adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p) {
        for (int i = 0; i < this.cof.length; i++) {
            for (int j = 0; j < p.cof.length; j++) {
                if (i == j && (this.cof[i] != 0 || p.cof[j] != 0)) {
                    this.cof[i] = this.cof[i] + p.cof[j];
                }
            }
        }
        return this;

    }

    // Subtracts two polynomials and returns a new polynomial which has result
    public Polynomial subtract(Polynomial p) {
        for (int i = 0; i < this.cof.length; i++) {
            for (int j = 0; j < p.cof.length; j++) {
                if (i == j && (this.cof[i] != 0 || p.cof[j] != 0)) {
                    this.cof[i] = this.cof[i] - p.cof[j];
                }
            }
        }
        return this;

    }

    // Multiply two polynomials and returns a new polynomial which has result
    public Polynomial multiply(Polynomial p) {
        Polynomial a = new Polynomial();
        for (int i = 0; i < this.cof.length / 2; i++) {
            for (int j = 0; j < p.cof.length / 2; j++) {
                if (this.cof[i] != 0 && p.cof[j] != 0) {
                    a.cof[i + j] += this.cof[i] * p.cof[j];
                }
            }
        }
        return a;
    }

}
