package com.example.backapp;

import com.example.backapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SomeController {

    @Autowired
    private SomeService someService;

    @GetMapping("/testFirebase")
    public String testFirebase() {
        someService.testFirebaseConnection();
        return "Test de conexión a Firebase iniciado. Revisa la consola para ver los resultados.";
    }
    @PostMapping("/users")
    public String saveUser(@RequestBody User user) {
        someService.saveUser(user);
        return "Usuario guardado con éxito.";
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return someService.getUsers();
    }
}