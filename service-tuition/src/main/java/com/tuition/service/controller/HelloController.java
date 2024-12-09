package com.tuition.service.controller;

import com.stubs.grpc.HelloRequest;
import com.stubs.grpc.HelloResponse;
import com.stubs.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GrpcClient("auth")
    HelloServiceGrpc.HelloServiceStub stub;

    @GetMapping("/")
    public String test() {
        HelloRequest request = HelloRequest.newBuilder()
                .setId(1)
                .setName("Tuition")
                .build();
        StreamObserver<HelloResponse> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(HelloResponse response) {
                // Xử lý phản hồi trả về
                System.out.println("Received message: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                // Xử lý lỗi nếu có
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Xử lý khi stream hoàn tất
                System.out.println("Stream completed.");
            }
        };
        stub.sayHello(request, responseObserver);
        return "";
    }
}
