package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.example.constant.Constants.PREDATOR_FOODS;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;
    private final int kittensCount;
    private final boolean hasMane;
    private Feline feline;
    private Lion lion;

    public LionParametrizedTest(String sex, int kittensCount, boolean hasMane) throws Exception {
        this.sex = sex;
        this.kittensCount = kittensCount;
        this.hasMane = hasMane;
        this.feline = Mockito.spy(new Feline());
        this.lion = Mockito.spy(new Lion(feline, sex));
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Самец", 1, true},
                {"Самка", 1, false},
        };
    }

    @Test
    public void shouldReturnOneKittens() {
        int actual = lion.getKittens();
        Assertions.assertEquals(1, actual);
    }

    @Test
    public void shouldReturnHasMane() {
        boolean actual = lion.doesHaveMane();
        Assertions.assertEquals(hasMane, actual);
    }

    @Test
    public void shouldReturnLionFoodList() throws Exception {
        List<String> actual = lion.getFood();
        Assertions.assertEquals(PREDATOR_FOODS, actual);
    }
}