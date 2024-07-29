package kz.dar.university.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    private String clientId; // ID клиента
    @NotNull(message = "Имя обязательно для заполнения")
    private String name; // Имя клиента
    @NotNull(message = "Фамилия обязательна для заполнения")
    private String surname; // Фамилия клиента
    @Email
    @NotNull(message = "Email обязателен для заполнения")
    private String email; // Email клиента
}
