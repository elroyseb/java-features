package jdk10;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestJEP286LocalVariableTypeInference {

    @Test
    void test(){
        var list = new ArrayList<String>();
        ArrayList<String> listString = new ArrayList<String>();

        assertThat(list.getClass(), is(list.getClass()));
        assertThat(list.getClass(), is(ArrayList.class));
        assertThat(list.getClass(), is(not(LinkedList.class)));
        assertThat(list.getClass(), is(not(String.class)));

    }
}
