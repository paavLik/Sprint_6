package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    private static final int EXPECTED_COUNT_KITTENS = 1;

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyTest() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();

        String expected = "Кошачьи";
        assertEquals("Некорректное название семейства кошачьих", expected, actual);
    }

    @Test
    public void getKittensTest() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(EXPECTED_COUNT_KITTENS);

        assertEquals("Некорректное количество котят", EXPECTED_COUNT_KITTENS, actual);
    }

    @Test
    public void getKittensTwoTest() {
        int kittensCount = 5;
        int actual = feline.getKittens(kittensCount);
        Mockito.verify(feline).getKittens(Mockito.anyInt());

        assertEquals("Некорректное количество котят", kittensCount, actual);
    }
}