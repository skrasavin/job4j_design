package ru.job4j.ood.lsp.examples;

import java.util.List;

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

    @Override
    public String characterLimit(String word) {
        if (word.length() > 10) {
            throw new IllegalArgumentException();
        }
        return word + " - small wort";
    }

    @Override
    public List<String> censure(List<String> words) {
        List<String> newList = null;
        for (var w : words) {
            if (w.length() > 15) {
                newList.add(w);
            }
        }
        return newList;
    }
}
