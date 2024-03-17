package Polinom;

public class Monom {
    public int coeficient;
    public int exponent;

    public Monom(int coeficient, int exponent)
    {
        this.coeficient=coeficient;
        this.exponent=exponent;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public Monom adunareMonoame(Monom monom1, Monom monom2)
    {
        int coeficient1 = monom1.getCoeficient();
        int exponent1 = monom1.getExponent();
        int coeficient2 = monom2.getCoeficient();
        int exponent2 = monom2.getExponent();
        Monom monom= new Monom(coeficient1 + coeficient2,exponent1);
        return monom;
    }
    public Monom scadereMonoame (Monom monom1, Monom monom2){
        int coeficient1 = monom1.getCoeficient();
        int exponent1 = monom1.getExponent();
        int coeficient2 = monom2.getCoeficient();
        int exponent2 = monom2.getExponent();
        Monom monom= new Monom(coeficient1 - coeficient2,exponent1);
        return monom;
    }
    public Monom inmultireMonoame (Monom monom1, Monom monom2)
    {
        int coeficient1 = monom1.getCoeficient();
        int exponent1 = monom1.getExponent();
        int coeficient2 = monom2.getCoeficient();
        int exponent2 = monom2.getExponent();
        Monom monom= new Monom(coeficient1 * coeficient2,exponent1 + exponent2);
        return monom;
    }
}

