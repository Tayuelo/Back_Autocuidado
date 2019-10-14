package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "texts")
@NoArgsConstructor
@AllArgsConstructor
public class Home {

    @Id
    private String id;
    private String textsByColor;
    List<String> texts;
}