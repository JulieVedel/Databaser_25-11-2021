package com.company;

public class Studfag {
    private int stdnr;
    private int fagnr;
    private Studerende s = new Studerende();
    private Fag f = new Fag();

    public Studfag(int stdnr, int fagnr) {
        this.stdnr = stdnr;
        this.fagnr = fagnr;
    }

    public Studfag() {

    }

    public Studerende getS() {
        return s;
    }

    public void setS(Studerende s) {
        this.s = s;
    }

    public Fag getF() {
        return f;
    }

    public void setF(Fag f) {
        this.f = f;
    }

    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public int getFagnr() {
        return fagnr;
    }

    public void setFagnr(int fagnr) {
        this.fagnr = fagnr;
    }
}
