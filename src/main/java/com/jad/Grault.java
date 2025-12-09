package com.jad;

// Un Grault ne peut pas être créé sans son Moulin, 
// Moulin créé une collection de Grault par composition.
public class Grault {
    private Moulin moulin;

    /**
     * Construire un nouveau Grault avec son Moulin.
     * @param Moulin the Moulin associé au Grault
     */
    public Grault(final Moulin moulin) {
        this.moulin = moulin;
    }

    /**
     * Retourne le Moulin associé au Grault.
     * @return le Moulin associé au Grault
     */
    public Moulin getMoulin() {
        return this.moulin;
    }
}
