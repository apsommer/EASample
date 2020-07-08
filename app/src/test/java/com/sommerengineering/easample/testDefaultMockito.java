package com.sommerengineering.easample;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class testDefaultMockito {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private List list;

    @Test
    public void testDefault() {

        // set a default for every value in the list
        when(list.get(anyInt())).thenReturn("Default element");

        // test the default behavior
        int randomElement = 42;
        Assert.assertEquals("Default element", list.get(randomElement));
    }
}
