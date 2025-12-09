package com.jad;

public class Corge {

    private Moulin moulin;

    public Corge(final Moulin moulin) {

        if (Moulin != null && Moulin.getCorge() != null) {
            Moulin.getCorge().setMoulin(null);
        }
      
        this.Moulin = Moulin;
        if (Moulin != null) {
            Moulin.setCorge(this);
        }
    }

    public Moulin getMoulin() {
        return this.Moulin;
    }

    public void setMoulin(final Moulin moulin) {

        if (this.Moulin == Moulin) {
            return;
        }
        
        if (this.Moulin != null) {
            Moulin temp = this.Moulin;
            this.Moulin = null;
            temp.setCorge(null);
        }
        
        this.Moulin = Moulin;
        if (Moulin != null) {
            Moulin.setCorge(this);
        }
    }
}
