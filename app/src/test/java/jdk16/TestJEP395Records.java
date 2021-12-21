package jdk16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestJEP395Records {

    record Person(String firstName, String lastName) {
        Person {
            Objects.requireNonNull(firstName);
            Objects.requireNonNull(lastName);
        }
    }
    private Person ramana;

    @BeforeEach
    void setUp(){
        ramana = new Person("Ramana", "Maharishi");
    }

    @Test
    void test(){
        assertThat(ramana.firstName(), is("Ramana"));
        assertThat(ramana.lastName(), is("Maharishi"));
        assertThat(ramana, is(new Person("Ramana", "Maharishi")));
    }

    @Test
    void testExceptionThrownOnInstantiation(){
        assertThrows(NullPointerException.class, () -> new Person("Elroy", null));
        assertThrows(NullPointerException.class, () -> new Person(null, "Ludivine"));
        assertThrows(NullPointerException.class, () -> new Person(null, null));
    }
}
