package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna;
    private double krajnja;
    private boolean a;
    private boolean b;

    private boolean getA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    private boolean getB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }


    private double getKrajnja() {
        return krajnja;
    }

    public void setKrajnja(double krajnja) {
        this.krajnja = krajnja;
    }

    private double getPocetna() {
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
        return pocetna == 0 && krajnja == 0;
    }

    public boolean isIn(double tacka){
        if(tacka >= pocetna && tacka <= krajnja && a && b)return  true;
        if(tacka > pocetna && tacka <= krajnja && !a && b)return  true;
        if(tacka >= pocetna && tacka < krajnja && a && !b)return  true;
        return tacka > pocetna && tacka < krajnja && !a && !b;
    }

    @Override
    public String toString(){
        String string_za_ispis = "";
        if(a && b) string_za_ispis = ("["+pocetna+","+krajnja+"]");
        if(!a && b) string_za_ispis = ("("+pocetna+","+krajnja+"]");
        if(a && !b) string_za_ispis = ("["+pocetna+","+krajnja+")");
        if(!a && !b) string_za_ispis = ("("+pocetna+","+krajnja+")");
        if(getPocetna() == 0 && getKrajnja() == 0&& !a && !b)string_za_ispis ="()";
        return string_za_ispis;
    }

    @Override
    public boolean equals(Object neko){
        Interval novi = (Interval) neko;
        return pocetna == novi.getPocetna() && krajnja == novi.getKrajnja() && a == novi.getA() && b == novi.getB();
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
