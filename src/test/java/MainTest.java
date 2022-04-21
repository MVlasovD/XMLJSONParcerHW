import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    @Test
    public void listToJson() {
        String actual = Main.listToJson(new ArrayList<>());
        assertInstanceOf(String.class, actual);
        assertNotNull(actual);
    }

    @Test
    void writeString() {

        String expected = Main.listToJson(Main.parseXML("data.xml"));
        String actual = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Inav\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

        Main.writeString(expected, actual);
//        Assertions.assertThat(actual).containsOnlyElementsOf(expected);
//        assertTrue(expected.contains(actual));
//        assertEquals(expected,actual, "Something wrong");
//        assertSame(expected,actual);
        assertTrue(actual.length() == expected.length());
        assertNotNull(expected);
        assertInstanceOf(String.class, expected);
        assertInstanceOf(String.class, actual);
        assertThrows(IOException.class, () -> {
            throw new IOException();
        });
    }


    @Test
    void parseXML() {

        Employee emp1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee emp2 = new Employee(2, "Inav", "Petrov", "RU", 24);

        List<Employee> expected = new ArrayList<>();
        expected.add(emp1);
        expected.add(emp2);

        List<Employee> actual = Main.parseXML("data.xml");

        System.out.println(expected);
        System.out.println(actual);

//        assertIterableEquals(expected,actual,"Message");
//        assertEquals(expected, actual);
        assertInstanceOf(List.class, actual);
        assertInstanceOf(List.class, expected);
        assertEquals(expected.size(), 2);
        assertNotSame(expected, actual);
        assertNotEquals(expected, actual);
        assertNotNull(actual);
        assertNotNull(expected);
    }

    @Test
    @RepeatedTest(3)
    void read() {

    }
}