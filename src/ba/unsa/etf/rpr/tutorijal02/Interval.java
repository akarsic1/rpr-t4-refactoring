package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetna, krajnja;
    boolean a, b;

    public boolean getA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public boolean getB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }


    public double getKrajnja() {
        return krajnja;
    }

    public void setKrajnja(double krajnja) {
        this.krajnja = krajnja;
    }

    public double getPocetna() {
        return pocetna;
    }

    public void setPocetna(double pocetna) {
        this.pocetna = pocetna;
    }

    public Interval(double poc, double kraj, boolean c, boolean d){
        if(poc > kraj) throw new IllegalArgumentException();
        pocetna = poc;
        krajnja = kraj;
        a = c;
        b = d;
    }

    public Interval(){
        pocetna = 0.;
        krajnja = 0.;
        a = false;
        b = false;
    }

    public boolean isNull(){
        if(pocetna == 0 && krajnja == 0) return true;
        return false;
    }

    public boolean isIn(double tacka){
        if(tacka >= pocetna && tacka <= krajnja && a== true && b==true)return  true;
        if(tacka > pocetna && tacka <= krajnja && a== false && b==true)return  true;
        if(tacka >= pocetna && tacka < krajnja && a== true && b==false)return  true;
        if(tacka > pocetna && tacka < krajnja && a== false && b==false)return  true;
        return false;
    }

    @Override
    public String toString(){
        String string_za_ispis = "";
        if(a == true && b == true) string_za_ispis = ("["+pocetna+","+krajnja+"]");
        if(a == false && b == true) string_za_ispis = ("("+pocetna+","+krajnja+"]");
        if(a == true && b == false) string_za_ispis = ("["+pocetna+","+krajnja+")");
        if(a == false && b == false) string_za_ispis = ("("+pocetna+","+krajnja+")");
        if(getPocetna() == 0 && getKrajnja() == 0&& a == false && b == false)string_za_ispis ="()";
        return string_za_ispis;
    }

    @Override
    public boolean equals(Object neko){
        Interval novi = (Interval) neko;
        if(pocetna == novi.getPocetna() && krajnja == novi.getKrajnja() && a == novi.getA() && b == novi.getB())return  true;
        return false;
    }

    public static Interval intersect(Interval prvi, Interval drugi){
        Interval povratni = new Interval();
        if(prvi.getPocetna() > drugi.getPocetna()){ povratni.pocetna = prvi.getPocetna(); povratni.a = prvi.getA();}
        if(prvi.getPocetna() < drugi.getPocetna()){ povratni.pocetna = drugi.getPocetna(); povratni.a = drugi.getA();}
        if(prvi.getKrajnja() > drugi.getKrajnja()){ povratni.krajnja = drugi.getKrajnja(); povratni.b = drugi.getB();}
        if(prvi.getKrajnja() < drugi.getKrajnja()){ povratni.krajnja = prvi.getKrajnja(); povratni.b = prvi.getB();}
        return povratni;
    }

    public Interval intersect(Interval prvi){
        Interval povratni = new Interval();
        if(prvi.getPocetna() > getPocetna()){ povratni.pocetna = prvi.getPocetna(); povratni.a = prvi.getA();}
        if(prvi.getPocetna() < getPocetna()){ povratni.pocetna = pocetna; povratni.a = a;}
        if(prvi.getKrajnja() > getKrajnja()){ povratni.krajnja = krajnja; povratni.b = b;}
        if(prvi.getKrajnja() < getKrajnja()){ povratni.krajnja = prvi.getKrajnja(); povratni.b = prvi.getB();}
        return povratni;
    }

}
