package com.cognizant;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class AAATest {
    
    private List<String> shoppingList;

    @Before
    public void setUp() {
        shoppingList = new ArrayList<>();
    }

    @After
    public void tearDown() {
        shoppingList.clear();
        shoppingList = null;
    }

    @Test
    public void testAddItemsUsingAAAPattern() {
        String item1 = "Milk";
        String item2 = "Bread";

        shoppingList.add(item1);
        shoppingList.add(item2);

        assertEquals(2, shoppingList.size());
        assertTrue(shoppingList.contains("Milk"));
        assertTrue(shoppingList.contains("Bread"));
    }
}