package co.com.unac.selfcare.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class Recomendaciones implements Serializable {

    private String recomendacion1 = "";
    private String recomendacion2 = "";
    private String recomendacion3 = "";
    private String recomendacion4 = "";
    private String recomendacion5 = "";
}
