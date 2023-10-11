package com.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.example.constant.Constants.CAT_SOUND;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    private Feline feline = new Feline();

    @Spy
    private Cat cat = new Cat(feline);

    private final List<String> PREDATOR_FOODS = List.of("Животные", "Птицы", "Рыба");

    @Test
    public void shouldReturnSound() {
        String actual = cat.getSound();
        Assertions.assertEquals(CAT_SOUND, actual);
    }

    @Test
    public void shouldReturnCatFoodList() throws Exception {
        List<String> actual = cat.getFood();
        Assertions.assertEquals(PREDATOR_FOODS, actual);
    }
}