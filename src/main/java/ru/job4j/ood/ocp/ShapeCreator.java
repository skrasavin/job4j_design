package ru.job4j.ood.ocp;

public class ShapeCreator {
    int aSide;
    int bSide;
    int cSide;

    public ShapeCreator(int a, int b, int c) {
        this.aSide = a;
        this.bSide = b;
        this.cSide = c;
    }

    public void constructTriangle() {
        System.out.println(",,,");
    }
}
