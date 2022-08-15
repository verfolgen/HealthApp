package org.example.v1.email;

import lombok.AllArgsConstructor;
import org.example.v1.base.AbstractIntegrationTest;
import org.example.v1.email.util.EmailValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EmailValidatorTest{

    @Autowired
    protected EmailValidator emailValidator;

    @Test
    void validEmail() {
        String emailAddress = "username@domain.com";
        assertTrue(emailValidator.test(emailAddress));
    }

    @Test
    void NotValidEmailNotDot() {
        String emailAddress = "username@domaincom";
        assertFalse(emailValidator.test(emailAddress));
    }

    @Test
    void NotValidEmailNotAt() {
        String emailAddress = "usernamedomain.com";
        assertFalse(emailValidator.test(emailAddress));
    }

    @Test
    void NotValidEmailNotLogin() {
        String emailAddress = "@domain.com";
        assertFalse(emailValidator.test(emailAddress));
    }

    @Test
    void NotValidEmailNotServer() {
        String emailAddress = "username@.com";
        assertFalse(emailValidator.test(emailAddress));
    }

    @Test
    void NotValidEmailNotDomain() {
        String emailAddress = "username@domain";
        assertFalse(emailValidator.test(emailAddress));
    }
}