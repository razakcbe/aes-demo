package com.razak.decrypt.aesdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decrypt/message")
public class MyController {

    @PostMapping
    public ResponseEntity<String> decryptMessages(@RequestBody MessageDto messageDto)
    {
        return ResponseEntity.ok(AESEncryptUtil.
                aesDecrypt(messageDto.getData(), messageDto.getKey(), messageDto.getIv()));
    }
}
