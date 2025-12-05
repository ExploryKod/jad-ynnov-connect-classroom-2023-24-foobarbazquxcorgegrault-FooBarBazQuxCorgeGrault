package com.jad;

// Un Grault ne peut pas être créé sans son Foo, 
// Foo créé une collection de Grault par composition.
public class Grault {
    private Foo foo;

    /**
     * Construire un nouveau Grault avec son Foo.
     * @param foo the Foo associé au Grault
     */
    public Grault(final Foo foo) {
        this.foo = foo;
    }

    /**
     * Retourne le Foo associé au Grault.
     * @return le Foo associé au Grault
     */
    public Foo getFoo() {
        return this.foo;
    }
}
