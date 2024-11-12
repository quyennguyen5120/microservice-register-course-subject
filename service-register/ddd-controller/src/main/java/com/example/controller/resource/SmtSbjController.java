package com.example.controller.resource;

import com.example.application.service.smtsbj.SmtSbjService;
import com.example.domain.common.DefaultRes;
import com.example.domain.common.ResponseMessage;
import com.example.domain.common.StatusCode;
import com.example.domain.model.SmtSbjModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.controller.Const.API_VERSION;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_VERSION + "/smt-sbj")
public class SmtSbjController {
    private final SmtSbjService smtSbjService;

    @GetMapping
    public ResponseEntity<DefaultRes<List<SmtSbjModel>>> getAll(){
        return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.GET_LIST, smtSbjService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{smt_sbj_id}")
    public ResponseEntity<DefaultRes<SmtSbjModel>> findBySmtSbjId(@PathVariable(name = "smt_sbj_id") int smtSbjId){
        return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.GET_ONE, smtSbjService.findById(smtSbjId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultRes<Integer>> createSmtSbj(@RequestBody SmtSbjModel model){
        return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.CREATED, smtSbjService.createSmtSbj(model)), HttpStatus.OK);
    }

    @PostMapping("/register/{smt_sbj_id}")
    public ResponseEntity<DefaultRes<String>> registerSubject(@PathVariable(name = "smt_sbj_id") int smtSbjId){
        return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.CREATED, smtSbjService.registerSubject(smtSbjId)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DefaultRes<Integer>> updateSmtSbj(@RequestBody SmtSbjModel model){
        return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.UPDATED, smtSbjService.updateSmtSbj(model)), HttpStatus.OK);
    }

}
