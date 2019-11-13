package unac.selfcare.selfcareapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebMessageDto {

    private String documentNumber;
    private String from;
    private String tituloEmail;
    private String cuerpoEmail;
}