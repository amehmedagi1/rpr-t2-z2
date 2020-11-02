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

    boolean isNull(){
        if(this.pocetna == 0 && this.krajnja == 0 && !this.pocetnapripada && !this.krajnjapripada) return true;
        return false;
    }

    boolean isIn(double tacka){
        if(tacka >= this.pocetna && tacka <= this.krajnja) return true;
        return false;
    }

    public Interval intersect(Interval i){
        if(i.pocetna >= this.pocetna && i.krajnja <= this.krajnja) return new Interval(i.pocetna,i.krajnja,true, true);
        else if(i.pocetna >= this.pocetna && i.krajnja > this.krajnja) return new Interval(i.pocetna,this.krajnja,true, true);
        else if(i.pocetna <= this.pocetna && i.krajnja <= this.krajnja) return new Interval(this.pocetna,i.krajnja,true, true);
        return new Interval(this.pocetna,this.krajnja,true, true);
    }

    public static Interval intersect(Interval j, Interval i){
        if(i.pocetna >= j.pocetna && i.krajnja <= j.krajnja) return new Interval(i.pocetna,i.krajnja,true, true);
        else if(i.pocetna >= j.pocetna && i.krajnja > j.krajnja) return new Interval(i.pocetna,j.krajnja,true, true);
        else if(i.pocetna <= j.pocetna && i.krajnja <= j.krajnja) return new Interval(j.pocetna,i.krajnja,true, true);
        return new Interval(j.pocetna,j.krajnja,true, true);
    }
}
