package com.auth.service.controller;

import com.stubs.grpc.HelloRequest;
import com.stubs.grpc.HelloResponse;
import com.stubs.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class HelloController extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Received message: " + request.getName());
    }
}
