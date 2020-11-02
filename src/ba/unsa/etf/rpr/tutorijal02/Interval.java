package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
double pocetna, krajnja;
boolean pocetnapripada, krajnjapripada;

    public Interval(double pocetna, double krajnja, boolean pocetnapripada, boolean krajnjapripada) {
        if(pocetna > krajnja) throw new IllegalArgumentException("Pocetna je veca od kranje");
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.pocetnapripada = pocetnapripada;
        this.krajnjapripada = krajnjapripada;
    }

    public Interval() {
        this.pocetna = 0;
        this.krajnja = 0;
        pocetnapripada = false;
        krajnjapripada = false;
    }
    public String toString(){
        if(this.pocetna==0 && this.krajnja==0 && this.pocetnapripada==false && this.krajnjapripada== false) return ("()");
        if(this.pocetnapripada == true && this.krajnjapripada == true) return ("[" + this.pocetna + "," + this.krajnja + "]");
        if(this.pocetnapripada == true && this.krajnjapripada == false) return ("[" + this.pocetna + "," + this.krajnja + ")");
        if(this.pocetnapripada == false && this.krajnjapripada == true) return ("(" + this.pocetna + "," + this.krajnja + "]");
        return ("(" + this.pocetna + "," + this.krajnja + ")");
    }

    boolean isNull(){
        if(this.pocetna == 0 && this.krajnja == 0 && !this.pocetnapripada && !this.krajnjapripada) return true;
        return false;
    }

    boolean isIn(double tacka){
        if(tacka > this.pocetna && tacka < this.krajnja) return true;
        if(tacka == this.pocetna && this.pocetnapripada) return true;
        if(tacka == this.krajnja && this.krajnjapripada) return true;
        return false;
    }

    public Interval intersect(Interval i) {
        if ((i.pocetna > this.pocetna) && (i.krajnja < this.krajnja) && (i.pocetnapripada && i.krajnjapripada))
            return new Interval(i.pocetna, i.krajnja, true, true);
        if ((i.pocetna > this.pocetna) && (i.krajnja < this.krajnja) && (!i.pocetnapripada && !i.krajnjapripada))
            return new Interval(i.pocetna, i.krajnja, false, false);
        if (i.pocetna > this.pocetna && i.krajnja < this.krajnja && !i.pocetnapripada && i.krajnjapripada)
            return new Interval(i.pocetna, i.krajnja, false, true);
        if (i.pocetna > this.pocetna && i.krajnja < this.krajnja && i.pocetnapripada && !i.krajnjapripada)
            return new Interval(i.pocetna, i.krajnja, true, true);
        if (i.pocetna > this.pocetna && i.krajnja > this.krajnja && i.pocetnapripada && this.krajnjapripada)
            return new Interval(i.pocetna, this.krajnja, true, true);
        if (i.pocetna > this.pocetna && i.krajnja > this.krajnja && !i.pocetnapripada && !this.krajnjapripada)
            return new Interval(i.pocetna, this.krajnja, false, false);
        if (i.pocetna > this.pocetna && i.krajnja > this.krajnja && !i.pocetnapripada && this.krajnjapripada)
            return new Interval(i.pocetna, this.krajnja, false, true);
        if (i.pocetna > this.pocetna && i.krajnja > this.krajnja && i.pocetnapripada && !this.krajnjapripada)
            return new Interval(i.pocetna, this.krajnja, true, false);
        if (i.pocetna < this.pocetna && i.krajnja < this.krajnja && this.pocetnapripada && i.krajnjapripada)
            return new Interval(this.pocetna, i.krajnja, true, true);
        if (i.pocetna < this.pocetna && i.krajnja < this.krajnja && !this.pocetnapripada && !i.krajnjapripada)
            return new Interval(this.pocetna, i.krajnja, false, false);
        if (i.pocetna < this.pocetna && i.krajnja < this.krajnja && !this.pocetnapripada && i.krajnjapripada)
            return new Interval(this.pocetna, i.krajnja, false, true);
        if (i.pocetna < this.pocetna && i.krajnja < this.krajnja && this.pocetnapripada && !i.krajnjapripada)
            return new Interval(this.pocetna, i.krajnja, true, false);
        return this;
    }

    public static Interval intersect(Interval j, Interval i) {
        if ((i.pocetna > j.pocetna) && (i.krajnja < j.krajnja) && (i.pocetnapripada && i.krajnjapripada))
            return new Interval(i.pocetna, i.krajnja, true, true);
        if ((i.pocetna > j.pocetna) && (i.krajnja < j.krajnja) && (!i.pocetnapripada && !i.krajnjapripada))
            return new Interval(i.pocetna, i.krajnja, false, false);
        if (i.pocetna > j.pocetna && i.krajnja < j.krajnja && !i.pocetnapripada && i.krajnjapripada)
            return new Interval(i.pocetna, i.krajnja, false, true);
        if (i.pocetna > j.pocetna && i.krajnja < j.krajnja && i.pocetnapripada && !i.krajnjapripada)
            return new Interval(i.pocetna, i.krajnja, true, true);
        if (i.pocetna > j.pocetna && i.krajnja > j.krajnja && i.pocetnapripada && j.krajnjapripada)
            return new Interval(i.pocetna, j.krajnja, true, true);
        if (i.pocetna > j.pocetna && i.krajnja > j.krajnja && !i.pocetnapripada && !j.krajnjapripada)
            return new Interval(i.pocetna, j.krajnja, false, false);
        if (i.pocetna > j.pocetna && i.krajnja > j.krajnja && !i.pocetnapripada && j.krajnjapripada)
            return new Interval(i.pocetna, j.krajnja, false, true);
        if (i.pocetna > j.pocetna && i.krajnja > j.krajnja && i.pocetnapripada && !j.krajnjapripada)
            return new Interval(i.pocetna, j.krajnja, true, false);
        if (i.pocetna < j.pocetna && i.krajnja < j.krajnja && j.pocetnapripada && i.krajnjapripada)
            return new Interval(j.pocetna, i.krajnja, true, true);
        if (i.pocetna < j.pocetna && i.krajnja < j.krajnja && !j.pocetnapripada && !i.krajnjapripada)
            return new Interval(j.pocetna, i.krajnja, false, false);
        if (i.pocetna < j.pocetna && i.krajnja < j.krajnja && !j.pocetnapripada && i.krajnjapripada)
            return new Interval(j.pocetna, i.krajnja, false, true);
        if (i.pocetna < j.pocetna && i.krajnja < j.krajnja && j.pocetnapripada && !i.krajnjapripada)
            return new Interval(j.pocetna, i.krajnja, true, false);
        return j;
    }

    public boolean equals(Interval i){
        if(this.pocetna == i.pocetna && this.krajnja == i.krajnja && this.pocetnapripada == i.pocetnapripada && this.krajnjapripada == i.krajnjapripada) return true;
        return false;
    }
}
