package pl.sda.micgeb.thymeleafworkshop.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @NotEmpty(message = "Pole nie może być puste")
    private String title;

    @NotNull(message = "Nie może być puste")
    private String author;
}
