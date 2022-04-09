package com.josecarlos.jcdecrypt.controllers;

import com.josecarlos.jcdecrypt.models.DecryptResponse;
import com.josecarlos.jcdecrypt.models.EncryptRequest;
import com.josecarlos.jcdecrypt.models.EncryptResponse;
import com.josecarlos.jcdecrypt.services.AESEncryptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptionController {

    private final AESEncryptService aesEncryptService;

    public EncryptionController(AESEncryptService aesEncryptService) {
        this.aesEncryptService = aesEncryptService;
    }

    @PostMapping("/encrypt")
    public ResponseEntity<EncryptResponse> encrypt(@RequestBody EncryptRequest request) {
        String encrypted = AESEncryptService.encrypt(request.getTexto(), request.getSeed());
        EncryptResponse response = new EncryptResponse(encrypted);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/decrypt")
    public ResponseEntity<DecryptResponse> decrypt(@RequestBody EncryptRequest request) {
        String encrypted = AESEncryptService.decrypt(request.getTexto(), request.getSeed());
        DecryptResponse response = new DecryptResponse(encrypted);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
