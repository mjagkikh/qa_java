package com.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.example.constant.Constants.FELINE_FAMILY;
import static com.example.constant.Constants.PREDATOR_FOODS;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void shouldReturnFelineFoodList() throws Exception {
        List<String> actualFoods = feline.eatMeat();
        Assertions.assertEquals(PREDATOR_FOODS, actualFoods);
    }

    @Test
    public void shouldReturnFelineFamilly() {
        String actual = feline.getFamily();
        Assertions.assertEquals(FELINE_FAMILY, actual);
    }

    @Test
    public void shouldCallGetKittensWithCountOneTimes() {
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }

    @Test
    public void shouldReturnOneKittens() {
        int actual = feline.getKittens();
        Assertions.assertEquals(1, actual);
    }

    @Test
    public void shouldReturnTwoKittens() {
        int actual = feline.getKittens(2);
        Assertions.assertEquals(2, actual);
    }
}