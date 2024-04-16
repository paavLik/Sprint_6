package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AnimalTests {
    private Animal animal;
    private static final String FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private static final String EXCEPTION_TEXT = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void getFamilyIsCorrect() {
        animal = new Animal();
        String actual = animal.getFamily();

        assertEquals("Некорректный список семейств", FAMILY, actual);
    }

    @Test
    public void getFoodThrowsException() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage(EXCEPTION_TEXT);

        new Animal().getFood("");
    }
}