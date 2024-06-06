package com.example.backapp.model;

import ch.qos.logback.core.model.INamedModel;
import lombok.Data;

@Data
public class User {
    private String num;
    private Double latitud;
    private Double longitud;
    private Double potencia;
}
