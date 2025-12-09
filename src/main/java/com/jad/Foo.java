package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    private Bar bar;
    private List<Grault> graults;
    private Qux qux;
    private List<Baz> bazs;
    private Corge corge;

    public Foo(final Bar bar) {
        this.bar = bar;
        this.graults = new ArrayList<>();
        this.qux = new Qux();
        this.bazs = new ArrayList<>();
        this.corge = null;
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
        return this.corge;
    }

    public void setCorge(final Corge corge) {
      
        if (this.corge == corge) {
            return;
        }

        if (this.corge != null) {
            Corge temp = this.corge;
            this.corge = null;
            temp.setFoo(null);
        }
        
        this.corge = corge;
        if (corge != null) {
            corge.setFoo(this);
        }
       
    }
}
