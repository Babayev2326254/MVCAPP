package az.edu.turing.mvcapp.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {


    private long id;

    @NonNull
    @Size(min = 3)
    private String name;
}
