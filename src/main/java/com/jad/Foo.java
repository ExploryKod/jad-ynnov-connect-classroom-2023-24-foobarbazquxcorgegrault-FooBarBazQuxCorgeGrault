package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Foo {

    private List<Grault> graults;

    public Foo(final Bar bar) {
        this.graults = new ArrayList<>();
    }

    public Bar getBar() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<Baz> getBazs() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addBaz(final Baz baz) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Qux getQux() {
        throw new UnsupportedOperationException("Not implemented yet");
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
