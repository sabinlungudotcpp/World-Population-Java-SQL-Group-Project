package com.grouproject.sem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void first_test()
    {
        int cheese = 19;
        assertEquals(cheese, 19);
    }

    @Test
    void testGetCountry() {
//        Country romania = new Country()
//        assertEquals(bulgaria.getContinent(), "Europe");
    }

    @AfterAll
    static void finalise()
    {
        app.disconnect();
    }
}
