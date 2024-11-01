package com.market.Dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDto {
    private String correo;
    private String contrasena;
}
