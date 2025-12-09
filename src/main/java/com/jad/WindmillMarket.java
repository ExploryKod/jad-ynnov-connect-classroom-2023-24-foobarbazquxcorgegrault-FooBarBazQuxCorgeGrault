package com.jad;

public class WindmillMarket {

    private Moulin moulin;

    public WindmillMarket(final Moulin moulin) {

        if (moulin != null && moulin.getWindmillMarket() != null) {
            moulin.getWindmillMarket().setMoulin(null);
        }
      
        this.moulin = moulin;
        if (moulin != null) {
            moulin.setWindmillMarket(this);
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
            temp.setWindmillMarket(null);
        }
        
        this.moulin = moulin;
        if (moulin != null) {
            moulin.setWindmillMarket(this);
        }
    }
}
