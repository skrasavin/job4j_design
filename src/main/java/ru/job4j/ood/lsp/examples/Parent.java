package ru.job4j.ood.lsp.examples;

public class Parent {
    int a;
    int b;

    public Parent(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void say() {
        System.out.println("hey");
    }

    public String checkWordsAndAddNew() {
        String sentence = null;
        sentence += "hey";

        /** logic.... etc... */
        return sentence;
    }

    public void methodCall() {
        this.say();
    }
}
