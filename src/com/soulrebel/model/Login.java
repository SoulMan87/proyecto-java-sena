package com.soulrebel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    private String usuario, contrasena;

}
