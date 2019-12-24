package com.fargate.fargatedemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import java.lang.management.ManagementFactory

@RestController
@RequestMapping("/")
class FargateController {

    int jokeRequestCount = 0

    @GetMapping("")
    String fargateDemo(){
        return "Hey there internet person... you've stumbled upon Roger's Fargate Demo! Hit /chuck for a random joke. :)"
    }

    @GetMapping("/chuck")
    Map chuckNorrisJoke(){

        jokeRequestCount++

        def jokeJson = new RestTemplate().getForObject('http://api.icndb.com/jokes/random', Object)

        Map mapResult = [:]

        //noinspection GrUnresolvedAccess
        mapResult.joke = jokeJson?.value?.joke as String
        mapResult.requestNumber = jokeRequestCount
        mapResult.jvm = ManagementFactory.getRuntimeMXBean().getName()
        mapResult.javaVersion = System.getProperty("java.version")

        return mapResult
    }
}
