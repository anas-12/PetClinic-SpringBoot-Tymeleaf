package org.animal.gestionclinique.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vet {
    private Integer code;
    private String name;
    private String address;

}
