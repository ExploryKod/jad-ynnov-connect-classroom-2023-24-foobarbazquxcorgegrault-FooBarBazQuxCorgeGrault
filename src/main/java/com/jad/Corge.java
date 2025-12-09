package com.jad;

public class Corge {

    private Moulin moulin;

    public Corge(final Moulin moulin) {

        if (moulin != null && moulin.getCorge() != null) {
            moulin.getCorge().setMoulin(null);
        }
      
        this.moulin = moulin;
        if (moulin != null) {
            moulin.setCorge(this);
        }
    }

    public Moulin getMoulin() {
        return this.moulin;
    }

    public void setMoulin(final Moulin moulin) {

        if (this.moulin == moulin) {
            return;
        }
        
        if (this.moulin != null) {
            Moulin temp = this.moulin;
            this.moulin = null;
            temp.setCorge(null);
        }
        
        this.moulin = moulin;
        if (moulin != null) {
            moulin.setCorge(this);
        }
    }
}
