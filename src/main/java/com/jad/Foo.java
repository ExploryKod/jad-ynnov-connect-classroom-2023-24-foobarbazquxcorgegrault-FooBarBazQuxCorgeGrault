package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    private Bar bar;
    private List<Grault> graults;
    private Qux qux;

    public Foo(final Bar bar) {
        this.bar = bar;
        this.graults = new ArrayList<>();
        this.qux = new Qux();
    }

    public Bar getBar() {
        return this.bar;
    }

    public List<Baz> getBazs() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addBaz(final Baz baz) {
        throw new UnsupportedOperationException("Not implemented yet");
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
