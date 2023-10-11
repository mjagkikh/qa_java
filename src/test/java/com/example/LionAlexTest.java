package com.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    @Mock
    private Feline feline;
    @Spy
    private LionAlex spyAlex = new LionAlex(feline);
    private List<String> expectedFriend = List.of("Марти", "Глории ", "Мелман");
    private String expectedLocation = "Нью-Йоркский зоопарк";

    public LionAlexTest() throws Exception {
    }

    @Test
    public void shouldReturnFriendList() {
        List<String> actual = spyAlex.getFriends();
        Assertions.assertEquals(expectedFriend, actual);
    }

    @Test
    public void shouldReturnLocation() {
        String actual = spyAlex.getPlaceOfLiving();
        Assertions.assertEquals(expectedLocation, actual);
    }

    @Test
    public void shouldReturnZeroLittens() {
        int actual = spyAlex.getKittens();
        Assertions.assertEquals(0, actual);
    }
}