package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Moulin {
    private Bar bar;
    private List<Grault> graults;
    private CabbageFarm cabbageFarm;
    private List<GrainFarmProductor> grains;
    private Corge corge;

    public Moulin(final Bar bar) {
        this.bar = bar;
        this.graults = new ArrayList<>();
        this.cabbageFarm = new CabbageFarm();
        this.grains = new ArrayList<>();
        this.corge = null;
    }

    public Bar getBar() {
        return this.bar;
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
            temp.setMoulin(null);
        }
        
        this.corge = corge;
        if (corge != null) {
            corge.setMoulin(this);
        }
       
    }
}
