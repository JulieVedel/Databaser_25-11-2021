package com.company;

class studcontainer {
    public int antal;
    public Studerende[] array;

    studcontainer(){
        antal = 0;
        array = new Studerende[100];
        for (int i = 0; i < 100; i++)
            array[i] = new Studerende();
    }

    public int hentantal(){
        return antal;
    }

    public Studerende[] hentarray(){
        return array;
    }
}

