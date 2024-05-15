package Yavirac.Vin.Vinculacion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormDto {

    private String name;
    private String phone;
    private String email;
    private String comment;
    
}
