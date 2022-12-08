package ru.job4j.ex;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest extends TestCase {

    @Test
    public void testCalc() {
        int num = 3;
        int exp = 6;
        int res =new Fact().calc(num);
        assertThat(res).isEqualTo(exp);
    }

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                new Fact().calc(-1);
            });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }
}