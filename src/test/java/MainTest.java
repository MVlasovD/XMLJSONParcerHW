import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.rules.ExpectedException;

class MainTest {

    @Test
    public void listToJson() {
    }

    @Test
    void writeString() {
        String file = null;
        assertNull(file);
    }


    @Test
    void parseXML() {

        List<Employee> actual = Arrays.asList(new Employee());
        List<Employee> expected = Arrays.asList(new Employee());

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());
        assertNotNull(actual);
        assertNotNull(expected);
    }
}