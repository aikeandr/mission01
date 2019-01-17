package edu.isu.cs.cs3308;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fate
 */
public class ScoreboardTest {

    private Scoreboard fixture;

    public ScoreboardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new Scoreboard(10);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Scoreboard.
     */
    @Test
    public void testAdd() {
        for (int i = 0; i < 10; i++) {
            fixture.add(GameEntry.createRandomEntry());
        }

        assertEquals("Scoreboard is not correctly adding entities", 10, fixture.size());
    }

    /**
     * Test of add method, of class Scoreboard.
     */
    @Test
    public void testAdd_2() {
        for (int i = 0; i < 11; i++) {
            fixture.add(GameEntry.createRandomEntry());
        }

        assertEquals("Scoreboard capacity constraint is not maintained", 10, fixture.size());
    }

    /**
     * Test of add method, of class Scoreboard.
     */
    @Test
    public void testAdd_3() {
        assertEquals("Scoreboard size is not correct for empty scoreboard", 0, fixture.size());
        fixture.add(GameEntry.createRandomEntry());
        assertEquals("Scoreboard does not correctly add new items", 1, fixture.size());
    }

    /**
     * Test of remove method, of class Scoreboard.
     */
    @Test
    public void testRemove() {
        for (int i = 0; i < 10; i++) {
            fixture.add(GameEntry.createRandomEntry());
        }

        fixture.remove(9);
        assertEquals("Removal is not correctly implemented", 9, fixture.size());
    }

    /**
     * Test of remove method, of class Scoreboard.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemove_2() {
        for (int i = 0; i < 10; i++) {
            fixture.add(GameEntry.createRandomEntry());
        }

        fixture.remove(11);
        fail("IndexOutOfBoundsException is not thrown for removal of index > capacity.");
    }

    /**
     * Test of remove method, of class Scoreboard.
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemove_3() {
        for (int i = 0; i < 10; i++) {
            fixture.add(GameEntry.createRandomEntry());
        }

        fixture.remove(10);
        fail("IndexOutOfBoundsException is not thrown for removal of index >= capacity.");
    }

    /**
     * Test of remove method, of class Scoreboard.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemove_4() {
        for (int i = 0; i < 10; i++) {
            fixture.add(GameEntry.createRandomEntry());
        }

        fixture.remove(-1);
        fail("IndexOutOfBoundsException is not thrown for removal of negative index.");
    }
}
