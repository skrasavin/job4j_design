package ru.job4j.ood.lsp.examples;

import java.util.List;

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

    public String characterLimit(String word) {
        if (word.length() > 15) {
            throw new IllegalArgumentException();
        }
        return word + " - small wort";
    }


    public List<String> censure(List<String> words) {
        List<String> newList = null;
        for (var w : words) {
            if (w.equals("***")) {
                throw new IllegalArgumentException();
            }
            if (w.length() > 15) {
                newList.add(w);
            }
        }
        return newList;
    }
}
