package com.company;

public class Studfag {
    private int stdnr;
    private int fagnr;

    public Studfag(int stdnr, int fagnr) {
        this.stdnr = stdnr;
        this.fagnr = fagnr;
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
