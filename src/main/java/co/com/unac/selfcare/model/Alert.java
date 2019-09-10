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
public class Alert implements Serializable {

    @Id
    private String id;
    private int valoracion;
    private Recomendaciones recomendaciones;
}
