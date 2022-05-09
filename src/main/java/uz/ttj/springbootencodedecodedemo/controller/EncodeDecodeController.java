package uz.ttj.springbootencodedecodedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.ttj.springbootencodedecodedemo.payload.ApiResponse;
import uz.ttj.springbootencodedecodedemo.payload.CharsetType;
import uz.ttj.springbootencodedecodedemo.service.CharsetService;

import java.io.UnsupportedEncodingException;

@CrossOrigin(origins = {"http://localhost:8080/", "http://localhost:8081/"})
@RestController
@RequestMapping("/api")
public class EncodeDecodeController {

    @Autowired
    CharsetService charsetService;

    @PostMapping("/encode")
    public HttpEntity<?> encoder(@RequestBody CharsetType charsetType) throws UnsupportedEncodingException {
        ApiResponse apiResponse = charsetService.encoder(charsetType);
        System.out.println(charsetType);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @PostMapping("/decode")
    public HttpEntity<?> decoder(@RequestBody CharsetType charsetType) throws UnsupportedEncodingException {
        ApiResponse apiResponse = charsetService.decoder(charsetType);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
}
