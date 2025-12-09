package com.jad;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MoulinTest {
    @Test
    void barTest() {
        Bar bar = new Bar();
        Moulin moulin = new Moulin(bar);
        assertEquals(bar, moulin.getBar(), "Bar should be the same as the one passed to the constructor");
    }

    @Test
    void grainFarmProductorTest() {
        final int grainCount = 10;
        ArrayList<GrainFarmProductor> grains = new ArrayList<>();
        for (int i = 0; i < grainCount; i++) {
            grains.add(new GrainFarmProductor());
        }
        Moulin moulin = new Moulin(new Bar());
        assertEquals(0, moulin.getGrains().size(), "Grains farms should be empty by default");
        for (GrainFarmProductor grain : grains) {
            moulin.addGrain(grain);
        }
        assertEquals(grainCount, moulin.getGrains().size(), "Grains farms should have " + grainCount + " elements");
        assertTrue(moulin.getGrains().containsAll(grains), "Grains farms should contain all the Grains that were added");
    }

    @Test
    void cabbageFarmTest() {
        Moulin moulin = new Moulin(new Bar());
        assertNotNull(moulin.getCabbageFarm(), "The cabbage farm should not be null");
    }

    @Test
    void woodCrateProductionTest() {
        final int woodCrateCount = 10;
        Moulin moulin = new Moulin(new Bar());
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
    void corgeTest() {
        Moulin moulin = new Moulin(new Bar());
        Corge firstCorge = new Corge(moulin);
        assertEquals(moulin, firstCorge.getMoulin(), "Moulin should be the same as the one passed to the constructor");
        assertEquals(firstCorge, moulin.getCorge(), "Corge should be the same as the one passed to the constructor");
        Corge secondCorge = new Corge(moulin);
        assertEquals(moulin, secondCorge.getMoulin(), "Moulin should be the same as the one passed to the constructor");
        assertEquals(secondCorge, moulin.getCorge(), "Corge should be the same as the one passed to the constructor");
        assertNull(firstCorge.getMoulin(), "Moulin should be null after the second Corge is created");
        moulin.setCorge(firstCorge);
        assertEquals(firstCorge, moulin.getCorge(), "Corge should be the same as the one passed to the setter");
        assertEquals(moulin, firstCorge.getMoulin(), "Moulin should be the same as the one passed to the setter");
        assertNull(secondCorge.getMoulin(), "Moulin should be null after the first Corge is set to a different Moulin");
        secondCorge.setMoulin(moulin);
        assertEquals(moulin, secondCorge.getMoulin(), "Moulin should be the same as the one passed to the setter");
        assertEquals(secondCorge, moulin.getCorge(), "Corge should be the same as the one passed to the setter");
        assertNull(firstCorge.getMoulin(), "Moulin should be null after the second Corge is set to a different Moulin");
    }
}
