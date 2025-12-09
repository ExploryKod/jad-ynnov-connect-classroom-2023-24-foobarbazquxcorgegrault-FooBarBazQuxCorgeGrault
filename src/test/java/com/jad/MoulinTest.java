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
    void bazTest() {
        final int bazCount = 10;
        ArrayList<Baz> bazs = new ArrayList<>();
        for (int i = 0; i < bazCount; i++) {
            bazs.add(new Baz());
        }
        Moulin moulin = new Moulin(new Bar());
        assertEquals(0, moulin.getBazs().size(), "Bazs should be empty by default");
        for (Baz baz : bazs) {
            moulin.addBaz(baz);
        }
        assertEquals(bazCount, Moulin.getBazs().size(), "Bazs should have " + bazCount + " elements");
        assertTrue(moulin.getBazs().containsAll(bazs), "Bazs should contain all the Bazs that were added");
    }

    @Test
    void quxTest() {
        Moulin moulin = new Moulin(new Bar());
        assertNotNull(moulin.getQux(), "Qux should not be null");
    }

    @Test
    void graultTest() {
        final int bazGrault = 10;
        Moulin moulin = new Moulin(new Bar());
        assertEquals(0, moulin.getGraults().size(), "Graults should be empty by default");
        for (int i = 0; i < bazGrault; i++) {
            Moulin.addGrault();
        }
        assertEquals(bazGrault, Moulin.getGraults().size(), "Graults should have " + bazGrault + " elements");
        for (Grault grault : Moulin.getGraults()) {
            assertNotNull(grault, "Grault should not be null");
            assertEquals(moulin, grault.getMoulin(), "Grault should have a reference to the Moulin that created it");
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
