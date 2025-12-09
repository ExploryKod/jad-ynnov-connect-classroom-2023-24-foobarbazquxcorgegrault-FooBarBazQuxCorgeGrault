package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Moulin {
    private NeighborFarm neighborFarm;
    private List<WoodCrateProduction> woodCrateProductions;
    private CabbageFarm cabbageFarm;
    private List<GrainFarmProductor> grains;
    private WindmillMarket windmillMarket;

    public Moulin(final NeighborFarm neighborFarm) {
        this.neighborFarm = neighborFarm;
        this.woodCrateProductions = new ArrayList<>();
        this.cabbageFarm = new CabbageFarm();
        this.grains = new ArrayList<>();
        this.windmillMarket = null;
    }

    public NeighborFarm getNeighborFarm() {
        return this.neighborFarm;
    }

    public List<GrainFarmProductor> getGrains() {
        return this.grains;
    }

    public void addGrain(final GrainFarmProductor grain) {
        this.grains.add(grain);
    }

    public CabbageFarm getCabbageFarm() {
         return this.cabbageFarm;  
    }

    public List<WoodCrateProduction> getWoodCrateProductions() {
        return this.woodCrateProductions;
    }

    public void addWoodCrateProduction() {
        this.woodCrateProductions.add(new WoodCrateProduction(this));
    }

    public WindmillMarket getWindmillMarket() {
        return this.windmillMarket;
    }

    public void setWindmillMarket(final WindmillMarket windmillMarket) {
      
        if (this.windmillMarket == windmillMarket) {
            return;
        }

        if (this.windmillMarket != null) {
            WindmillMarket temp = this.windmillMarket;
            this.windmillMarket = null;
            temp.setMoulin(null);
        }
        
        this.windmillMarket = windmillMarket;
        if (windmillMarket != null) {
            windmillMarket.setMoulin(this);
        }
       
    }
}
