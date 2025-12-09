package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    private Bar bar;
    private List<Grault> graults;
    private Qux qux;
    private List<Baz> bazs;

    public Foo(final Bar bar) {
        this.bar = bar;
        this.graults = new ArrayList<>();
        this.qux = new Qux();
        this.bazs = new ArrayList<>();
    }

    public Bar getBar() {
        return this.bar;
    }

    public List<Baz> getBazs() {
        return this.bazs;
    }

    public void addBaz(final Baz baz) {
        this.bazs.add(baz);
    }

    public Qux getQux() {
         return this.qux;  
    }

    public List<Grault> getGraults() {
        return this.graults;
    }

    public void addGrault() {
        this.graults.add(new Grault(this));
    }

    public Corge getCorge() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setCorge(final Corge firstCorge) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
