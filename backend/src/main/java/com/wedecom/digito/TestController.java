package com.wedecom.digito;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/{id}/test")
    public String test(@PathVariable String id, @RequestBody String body) {
        System.out.println(id);
        return null;
    }
}
