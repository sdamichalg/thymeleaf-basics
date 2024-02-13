package pl.sda.micgeb.thymeleafworkshop.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @NotEmpty(message = "Pole tytuł nie może być puste")
    private String title;

    @NotEmpty(message = "Pole autor nie może być puste")
    private String author;
}
