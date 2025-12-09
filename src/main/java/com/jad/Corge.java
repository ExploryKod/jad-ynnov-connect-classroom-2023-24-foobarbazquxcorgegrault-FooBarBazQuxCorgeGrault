package com.jad;

public class Corge {

    private Foo foo;

    public Corge(final Foo foo) {

        if (foo != null && foo.getCorge() != null) {
            foo.getCorge().setFoo(null);
        }
      
        this.foo = foo;
        if (foo != null) {
            foo.setCorge(this);
        }
    }

    public Foo getFoo() {
        return this.foo;
    }

    public void setFoo(final Foo foo) {

        if (this.foo == foo) {
            return;
        }
        
        if (this.foo != null) {
            Foo temp = this.foo;
            this.foo = null;
            temp.setCorge(null);
        }
        
        this.foo = foo;
        if (foo != null) {
            foo.setCorge(this);
        }
    }
}
