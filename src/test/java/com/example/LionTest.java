package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private String expectMessage = "Используйте допустимые значения пола животного - Самец или Самка";

    @Mock
    private Feline feline;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage(expectMessage);
        Lion lion = new Lion(feline, "WRONG");
    }
}