package com.example;

import com.example.constant.AnimalType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.example.constant.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    @Spy
    private Animal spyAnimal;
    private String expectMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldExecuteMethodAnimalGetFood() throws Exception {
        spyAnimal.getFood(AnimalType.HERBIVORE.getType());
        Mockito.verify(spyAnimal, Mockito.times(1)).getFood(AnimalType.HERBIVORE.getType());
    }

    @Test
    public void shouldReturnHerbivalFoods() throws Exception {
        List<String> actual = spyAnimal.getFood(AnimalType.HERBIVORE.getType());
        Assertions.assertEquals(HERBIVORE_FOODS, actual);
    }

    @Test
    public void shouldReturnPredatorFoods() throws Exception {
        List<String> actual = spyAnimal.getFood(AnimalType.PREDATOR.getType());
        Assertions.assertEquals(PREDATOR_FOODS, actual);
    }

    @Test
    public void shouldReturnException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage(expectMessage);
        spyAnimal.getFood(AnimalType.UNKNOW.getType());
    }

    @Test
    public void shoulReturnFamily() {
        String actual = spyAnimal.getFamily();
        Assertions.assertEquals(EXPECTED_FAMILY, actual);
    }
}