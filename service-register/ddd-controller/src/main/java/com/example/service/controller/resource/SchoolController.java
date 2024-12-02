package com.example.service.controller.resource;

import com.example.service.application.service.school.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.service.controller.Const.API_VERSION;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_VERSION + "/school")
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping("/test")
    public List<Object> test(){
        return schoolService.test();
    }
}
