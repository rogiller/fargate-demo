package com.fargate.fargatedemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class FargateController {

    @GetMapping("")
    String fargate(){

        return 'YO!!'
    }
}
