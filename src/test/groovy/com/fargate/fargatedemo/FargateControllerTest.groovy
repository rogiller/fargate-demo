package com.fargate.fargatedemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FargateControllerTest {

    FargateController tested = new FargateController();

    @Test
    void chuckNorrisJoke() {

        def resultMap = tested.chuckNorrisJoke()

        println(resultMap.joke)

        assertNotNull(resultMap.joke);
    }
}