package ru.job4j.ood.lsp.examples;

public class Child extends Parent {


    public Child(int a, int b) {
        super(a, b);
    }

    @Override
    public void say() {
        System.out.println("Bye");

    }

    @Override
    public String checkWordsAndAddNew() {
        String sentence = null;
        sentence += "hey";

        /** different logic.... etc... */
        return sentence;
    }

    @Override
    public void methodCall() {
        String check = this.checkWordsAndAddNew();
    }
}
