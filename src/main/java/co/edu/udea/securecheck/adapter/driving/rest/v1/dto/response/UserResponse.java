package co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String name;
    private String lastname;
}
