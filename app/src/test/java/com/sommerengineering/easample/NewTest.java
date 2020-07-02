package com.sommerengineering.easample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NewTest {

    // new test stub

    @Before
    public void prepare() {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


//
//    @Mock
//    private List list;
//
//    @Test
//    public void testDefault() {
//    }
}
