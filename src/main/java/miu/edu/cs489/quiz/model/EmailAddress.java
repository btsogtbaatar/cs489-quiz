package miu.edu.cs489.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailAddress {
    private String email;
    private String label;

    public String toJsonString() {
        return String.format("{\"email\": \"%s\", \"label\": \"%s\"}", email, label);
    }
}
