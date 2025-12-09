package com.jad;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MoulinTest {
    @Test
    void neighborFarmTest() {
        NeighborFarm neighborFarm = new NeighborFarm();
        Moulin moulin = new Moulin(neighborFarm);
        assertEquals(neighborFarm, moulin.getNeighborFarm(), "Neighbor farm should be the same as the one passed to the constructor");
    }

    @Test
    void grainFarmProductorTest() {
        final int grainCount = 10;
        ArrayList<GrainFarmProductor> grains = new ArrayList<>();
        for (int i = 0; i < grainCount; i++) {
            grains.add(new GrainFarmProductor());
        }
        Moulin moulin = new Moulin(new NeighborFarm());
        assertEquals(0, moulin.getGrains().size(), "Grains farms should be empty by default");
        for (GrainFarmProductor grain : grains) {
            moulin.addGrain(grain);
        }
        assertEquals(grainCount, moulin.getGrains().size(), "Grains farms should have " + grainCount + " elements");
        assertTrue(moulin.getGrains().containsAll(grains), "Grains farms should contain all the Grains that were added");
    }

    @Test
    void cabbageFarmTest() {
        Moulin moulin = new Moulin(new NeighborFarm());
        assertNotNull(moulin.getCabbageFarm(), "The cabbage farm should not be null");
    }

    @Test
    void woodCrateProductionTest() {
        final int woodCrateCount = 10;
        Moulin moulin = new Moulin(new NeighborFarm());
        assertEquals(0, moulin.getWoodCrateProductions().size(), "Wood crate productions should be empty by default");
        for (int i = 0; i < woodCrateCount; i++) {
            moulin.addWoodCrateProduction();
        }
        assertEquals(woodCrateCount, moulin.getWoodCrateProductions().size(), "Wood crate productions should have " + woodCrateCount + " elements");
        for (WoodCrateProduction woodCrateProduction : moulin.getWoodCrateProductions()) {
            assertNotNull(woodCrateProduction, "Wood crate production should not be null");
            assertEquals(moulin, woodCrateProduction.getMoulin(), "Wood crate production should have a reference to the Moulin that created it");
        }
    }

    @Test
    void windmillMarketTest() {
        Moulin moulin = new Moulin(new NeighborFarm());
        WindmillMarket firstWindmillMarket = new WindmillMarket(moulin);
        assertEquals(moulin, firstWindmillMarket.getMoulin(), "Moulin should be the same as the one passed to the constructor");
        assertEquals(firstWindmillMarket, moulin.getWindmillMarket(), "Windmill market should be the same as the one passed to the constructor");
        WindmillMarket secondWindmillMarket = new WindmillMarket(moulin);
        assertEquals(moulin, secondWindmillMarket.getMoulin(), "Moulin should be the same as the one passed to the constructor");
        assertEquals(secondWindmillMarket, moulin.getWindmillMarket(), "Windmill market should be the same as the one passed to the constructor");
        assertNull(firstWindmillMarket.getMoulin(), "Moulin should be null after the second Windmill market is created");
        moulin.setWindmillMarket(firstWindmillMarket);
        assertEquals(firstWindmillMarket, moulin.getWindmillMarket(), "Windmill market should be the same as the one passed to the setter");
        assertEquals(moulin, firstWindmillMarket.getMoulin(), "Moulin should be the same as the one passed to the setter");
        assertNull(secondWindmillMarket.getMoulin(), "Moulin should be null after the second Windmill market is set to a different Moulin");
        secondWindmillMarket.setMoulin(moulin);
        assertEquals(moulin, secondWindmillMarket.getMoulin(), "Moulin should be the same as the one passed to the setter");
        assertEquals(secondWindmillMarket, moulin.getWindmillMarket(), "Windmill market should be the same as the one passed to the setter");
        assertNull(firstWindmillMarket.getMoulin(), "Moulin should be null after the second Windmill market is set to a different Moulin");
    }
}
