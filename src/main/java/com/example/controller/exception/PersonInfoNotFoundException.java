package com.example.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "PersonInfo not found")
public class PersonInfoNotFoundException extends RuntimeException{
}
