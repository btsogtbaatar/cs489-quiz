package miu.edu.cs489.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    private String phoneNumber;
    private String label;

    public String toJsonString() {
        return String.format("{\"phoneNumber\": \"%s\", \"label\": \"%s\"}", phoneNumber, label);
    }
}
