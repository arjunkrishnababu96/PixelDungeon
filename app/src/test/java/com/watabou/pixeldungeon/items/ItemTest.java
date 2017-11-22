package com.watabou.pixeldungeon.items;

import com.watabou.pixeldungeon.actors.hero.Hero;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by arjun on 21/11/17.
 */
public class ItemTest {
    Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item();

    }

    @After
    public void tearDown() throws Exception {
        item = null;
    }

    @Test
    public void test_actions() throws Exception {
        ArrayList<String> actionList = item.actions(new Hero());

        assertTrue(actionList.contains(Item.AC_DROP));
        assertTrue(actionList.contains(Item.AC_THROW));
        assertEquals(2, actionList.size());
    }

    @Test
    public void test_upgrade()  {
        final int INIT_LEVEL = item.level();
        item.upgrade();
        assertEquals((INIT_LEVEL + 1), item.level());
    }

    @Test
    public void test_upgrade_5() throws Exception{
        final int INIT_LEVEL = item.level();
        final int UPGRADE_COUNT = 5;

        item.upgrade(UPGRADE_COUNT);
        assertEquals(INIT_LEVEL + UPGRADE_COUNT,item.level());
    }

    @Test
    public void test_upgrade_0() throws Exception  {
        final int INIT_LEVEL = item.level();

        item.upgrade(0);
        assertEquals(INIT_LEVEL, item.level());
    }

    /*
        TODO: Test upgrade(n) with n = 5
        TODO: Test upgrade(n) with n = 0
        TODO: Test degrade()
        TODO: Test degrade(n)
        TODO: set durability < 0 and verify isBroken() returns true
        TODO: set durability = 0 and verify isBroken() returns true
        TODO: call fix(), and then verify isBroken() returns false
        TODO: call fix(), and then verify durability is maximum possible
        TODO: call polish() and ensure durability gets incremented
    */

}