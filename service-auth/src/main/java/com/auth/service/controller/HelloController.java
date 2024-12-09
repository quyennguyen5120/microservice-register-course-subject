package com.auth.service.controller;

import com.stubs.grpc.HelloRequest;
import com.stubs.grpc.HelloServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String test(){
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(null);
        return "Hello from auth service";
    }
}
