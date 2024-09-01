package com.app.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/get")
//    @PreAuthorize("hasAuthority('READ')")
    public String helloGet(){
        return "Hello from  GET";
    }

    @PostMapping("/post")
//    @PreAuthorize("hasAuthority('CREATE') or hasAuthority('DELETE')")
    public String herroPost(){
        return "Hello from  POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello from  PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello from  DELETE";
    }

    @PatchMapping("/patch")
//    @PreAuthorize("hasAuthority('REFACTOR')")
    public String helloPatch(){
        return "Hello from PATCH";
    }
}
