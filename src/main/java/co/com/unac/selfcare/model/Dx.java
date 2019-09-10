package co.com.unac.selfcare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Dx implements Serializable {

    @Id
    private String id;
    private int respuesta1;
    private int respuesta2;
    private int respuesta3;
    private int respuesta4;
    private int respuesta5;
}
