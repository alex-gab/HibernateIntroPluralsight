package com.example;

import org.junit.Test;

import java.util.Arrays;


public final class EntityTest {
    @Test
    public void smallTest() throws Exception {
        final Class<ProteinUser> proteinUserClass = (Class<ProteinUser>) Class.forName("com.example.ProteinUser");
        System.out.println(Arrays.asList(proteinUserClass.getDeclaredFields()));
    }
}
