package com.justrunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppRestControllerTest {

    AppRestController tested = new AppRestController();

    @Test
    void chuckNorrisJoke() {

        def resultMap = tested.chuckNorrisJoke()

        println(resultMap.joke)

        assertNotNull(resultMap.joke);
    }
}
