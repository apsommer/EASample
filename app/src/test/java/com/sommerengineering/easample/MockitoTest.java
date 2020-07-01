package com.sommerengineering.easample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock // creates a List class for testing
    private List list;

    @Test
    public void testQuery()  {

        // WHEN the first element of the list is accessed THEN RETURN a string
        when(list.get(1)).thenReturn("apples");

        // ASSERT the mock object behaved as expected
        assertEquals("apples", list.get(1));
    }
}
