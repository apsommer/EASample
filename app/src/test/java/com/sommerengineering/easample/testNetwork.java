package com.sommerengineering.easample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import javax.inject.Inject;

import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class testNetwork {

    @Before
    public void prepare() {

    }

    @Test
    public void testQuery()  {

        MockWebServer mockWebServer = new MockWebServer();

        // converter between JSON <--> Java POJO
        Gson gson = new GsonBuilder()
                .setLenient() // relax the conditions for what the parser considers valid JSON syntax
                .create();

        // initialize retrofit with the JSON parser and base URL
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-stage.greenlotstest.com/ocpi/cpo/2.1.1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //


        // WHEN the first element of the list is accessed THEN RETURN a string
//        when(list.get(1)).thenReturn("apples");

        // ASSERT the mock object behaved as expected
//        assertEquals("apples", list.get(1));
    }

    @After
    public void tearDown() {

    }
}
