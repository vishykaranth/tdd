package com.basic;

import basic.FizzBuzz;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FizzBuzzTest {

    @Test
    public void shouldProcessInput() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.processNumber(1), is("1"));
        assertThat(fizzBuzz.processNumber(2), is("2"));
        assertThat(fizzBuzz.processNumber(3), is("Fizz"));
        assertThat(fizzBuzz.processNumber(5), is("Buzz"));
        assertThat(fizzBuzz.processNumber(6), is("Fizz"));
        assertThat(fizzBuzz.processNumber(10), is("Buzz"));
        assertThat(fizzBuzz.processNumber(15), is("FizzBuzz"));
    }

    @Test
    public void shouldExecute() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.execute(new int[]{1}), is("1"));
        assertThat(fizzBuzz.execute(new int[]{1, 2, 3, 5, 6, 10, 15, 30}),
                is("1, 2, Fizz, Buzz, Fizz, Buzz, FizzBuzz, FizzBuzz"));
    }
}
