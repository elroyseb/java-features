package jdk16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

public class TestJEP394InstanceofPatternMatching {

    @Test
    void test() {
        Object obj = "Hello";

        if(obj instanceof String s && s.length() == 5)
           assertThat(s.toString(), is("Hello"));
       else
           fail();
    }
}
