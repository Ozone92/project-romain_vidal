package com.example.project_vidal_romain.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String firstName;
    private String lastName;
    private String address;
    private Integer postal;
    private String city;
    private Integer phone;
    private Long conseillerId;
}
