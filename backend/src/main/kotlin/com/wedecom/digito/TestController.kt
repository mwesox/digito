package com.wedecom.digito

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController2 {


    @PostMapping("/api2/{id}/test2")
    fun test(@PathVariable id: String) {
        println(id)
    }

}