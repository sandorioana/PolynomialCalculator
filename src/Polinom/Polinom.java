package Polinom;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Polinom {
    List<Monom> listaMonoame= new ArrayList<Monom>();

    public List<Monom> getListaMonoame() {
        return listaMonoame;
    }

    public void setListaMonoame(List<Monom> listaMonoame) {
        this.listaMonoame = listaMonoame;
    }

    public Polinom adunare(Polinom polinom1) {
        Polinom rezultat = new Polinom();
        Monom monom1;
        Monom monom2;
        int monomPol1=0;
        int monomPol2=0;
        Monom monom = new Monom(0, 0);

        while((this.listaMonoame.size() > monomPol1) && (polinom1.listaMonoame.size() > monomPol2))
        {
            monom1=this.listaMonoame.get(monomPol1);
            monom2=polinom1.listaMonoame.get(monomPol2);

            if (monom1.getExponent() < monom2.getExponent()) {
                rezultat.listaMonoame.add(monom2);
                monomPol2 = monomPol2 + 1;
            }
            else
            if (monom1.getExponent() > monom2.getExponent()) {
                rezultat.listaMonoame.add(monom1);
                monomPol1 = monomPol1 + 1;
            }
            else
            {
                monom=monom.adunareMonoame(monom1,  monom2);
                rezultat.listaMonoame.add(monom);
                monomPol1 = monomPol1 + 1;
                monomPol2 = monomPol2 + 1;
            }
        }

        while(this.listaMonoame.size() > monomPol1) {
            monom1=this.listaMonoame.get(monomPol1);
            rezultat.listaMonoame.add(monom1);
            monomPol1 = monomPol1 + 1;
        }
        while (polinom1.listaMonoame.size() > monomPol2)
        {
            monom2=polinom1.listaMonoame.get(monomPol2);
            rezultat.listaMonoame.add(monom2);
            monomPol2++;
        }
        return rezultat;
    }


    public Polinom scadere(Polinom polinom1) {
        Polinom rezultat = new Polinom();
        Monom monom=new Monom(0, 0);
        Monom monom1;
        Monom monom2;

        int monomPol1=0;
        int monomPol2=0;
        while((this.listaMonoame.size() > monomPol1) && (polinom1.listaMonoame.size() > monomPol2))
        {
            monom1=this.listaMonoame.get(monomPol1);
            monom2=polinom1.listaMonoame.get(monomPol2);

            if (monom1.getExponent() < monom2.getExponent()) {
                monom2.coeficient=-monom2.getCoeficient();
                rezultat.listaMonoame.add(monom2);
                monomPol2 = monomPol2 + 1;
            }
            else
            if (monom1.getExponent() > monom2.getExponent()) {
                rezultat.listaMonoame.add(monom1);
                monomPol1 = monomPol1 + 1;
            }
            else {
                monom=monom.scadereMonoame(monom1,  monom2);
                rezultat.listaMonoame.add(monom);
                monomPol1 = monomPol1 + 1;
                monomPol2 = monomPol2 + 1;
            }
        }

        while(this.listaMonoame.size() > monomPol1) {
            monom1=this.listaMonoame.get(monomPol1);
            rezultat.listaMonoame.add(monom1);
            monomPol1 = monomPol1 + 1;
        }

        while (polinom1.listaMonoame.size() > monomPol2)
        {
            monom2=polinom1.listaMonoame.get(monomPol2);
            monom2.coeficient=-monom2.getCoeficient();
            rezultat.listaMonoame.add(monom2);
            monomPol2 = monomPol2 + 1;
        }
        return rezultat;
    }

    public Polinom inmultire(Polinom polinom1) {
        Monom monom=new Monom(0, 0);
        Polinom polinom2 =new Polinom();

        for (Monom monom1:this.listaMonoame)
        {
            Polinom p1 =new Polinom();
            for (Monom monom2:polinom1.listaMonoame)
            {
                monom=monom.inmultireMonoame(monom1,monom2);
                p1.listaMonoame.add(monom);
            }
            polinom2=polinom2.adunare(p1);
        }
        return polinom2;
    }

    public Polinom derivare(Polinom polinom1) {
        int monomPol1 = 0;
        Polinom rez = new Polinom();

        while(monomPol1 < polinom1.listaMonoame.size()) {
            Monom monom1 = polinom1.listaMonoame.get(monomPol1);
            monomPol1 = monomPol1 + 1;
            if(monom1.getExponent() != 0) {
                Monom monom2 = new Monom(monom1.getCoeficient() * monom1.getExponent(), monom1.getExponent()-1);
                rez.listaMonoame.add(monom2);
            }
        }
        return rez;
    }

    public Polinom integrare(Polinom polinom1) {
        int monomPol1 = 0;
        Polinom rez = new Polinom();

        while(monomPol1 < polinom1.listaMonoame.size()) {
            Monom monom1 = polinom1.listaMonoame.get(monomPol1);
            monomPol1 = monomPol1 + 1;
            Monom monom2 = new Monom(monom1.getCoeficient()/(monom1.getExponent() + 1), monom1.getExponent() + 1);
            rez.listaMonoame.add(monom2);
        }
        return rez;
    }

    public String afisare() {
        String polinom1 = "";
        String polinom2 = "";
        String formaPolinom = "";

        for(Monom monom : listaMonoame) {

            if(monom.getCoeficient()== 0)
                continue;
            if(monom.getCoeficient() == 1) {
                polinom2 = "";
            }
            else
            if((monom.getCoeficient() != -1) && (monom.getCoeficient() != 1)) {
                polinom2 = monom.getCoeficient() + "";
            }
            else
            {
                polinom2 = "-";
            }

            if(monom.getExponent() == 0){
                if(monom.getCoeficient() == -1){
                    polinom2 = "-1";
                }
                if(monom.getCoeficient() == 1) {
                    polinom2 = "1";
                }
            }

            if(monom.getExponent() == 1)
            {
                polinom1 = "x";
            }
            else
            if((monom.getExponent() != 0) && (monom.getExponent() != 1)) {
                polinom1 = "x^" + monom.getExponent();
            }
            else
                polinom1 = "";

            formaPolinom = formaPolinom + polinom2 + polinom1 + "+";
            formaPolinom = formaPolinom.replace("+-", "-");
        }


        if(formaPolinom.length() > 0)
            formaPolinom = formaPolinom.substring(0, formaPolinom.length() - 1);
        formaPolinom = formaPolinom.replace("+-", "-");
        if(listaMonoame.isEmpty()) {
            formaPolinom = "0";
        }
        if(formaPolinom.compareTo("-") == 0)
            formaPolinom = "-1";
        return formaPolinom;
    }

    public Polinom formaPolinom(String text) {
        String MonomFormat1 = "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)";
        String MonomFormat2 = "([+-]?[\\d\\.]*[a-zA-Z]?\\^?\\d*)";
        Pattern pattern1 = Pattern.compile(MonomFormat2);
        Matcher matcher1 = pattern1.matcher(text);
        Polinom polinom1 = new Polinom();
        while (!matcher1.hitEnd()) {
            int coef = 0;
            int exp = 0;
            matcher1.find();
            Pattern pattern2 = Pattern.compile(MonomFormat1);
            Matcher matcher2 = pattern2.matcher(matcher1.group());
            if (matcher2.find()) {
                coef = Integer.valueOf(matcher2.group(1));
                exp = Integer.valueOf(matcher2.group(3));
            }
            Monom monom1 = new Monom(coef, exp);
            polinom1.listaMonoame.add(monom1);
        }
        return polinom1;
    }
}
