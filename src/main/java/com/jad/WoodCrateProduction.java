package com.jad;

// Un producteur de caisses ne peut pas être créé sans son Moulin, 
// Moulin créé une collection de production de caisses par composition.
public class WoodCrateProduction {
    private Moulin moulin;

    /**
     * Construire un nouveau production de caisses avec son Moulin.
     * @param Moulin the Moulin associé au producteur de caisses (WoodCrateProduction)
     */
    public WoodCrateProduction(final Moulin moulin) {
        this.moulin = moulin;
    }

    /**
     * Retourne le Moulin associé au producteur de caisses (WoodCrateProduction).
     * @return le Moulin associé au producteur de caisses (WoodCrateProduction)
     */
    public Moulin getMoulin() {
        return this.moulin;
    }
}
