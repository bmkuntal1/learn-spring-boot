package com.bmkuntal.springbootjsp.services;

import com.bmkuntal.springbootjsp.models.LoginModel;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    public boolean login(LoginModel model)
    {
        return Objects.equals(model.getEmail(), "user@gmail.com") && Objects.equals(model.getPassword(), "Pass@123");
    }
}
