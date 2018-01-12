package com.example.service.security.impl;

import com.example.service.security.EncryptionService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    private StrongPasswordEncryptor encryptor;

    @Autowired
    public void setEncryptor(StrongPasswordEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    @Override
    public String encryptString(String input) {
        return encryptor.encryptPassword(input);
    }

    @Override
    public Boolean checkPassword(String plainPassword, String encryptedPassword) {
        return encryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
