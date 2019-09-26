package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Dx {


    @Id
    private String userId;
    public String caa;
    public String rcv;
    public String dx;
}
