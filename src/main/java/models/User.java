
package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@Builder
public class User {
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    private Integer id;
    @JsonProperty("last_name")
    private String lastName;
    private String password;
    private String phone;
    private Integer userStatus;
    private String username;
}
