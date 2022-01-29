package hello.login.domain.member;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Member {

    private Long id;

    @NotBlank
    private String loginId;
    @NotBlank
    private String name;
    @NotBlank
    private String password;

    public boolean equalsLoginId(String loginId) {
        if(Objects.isNull(loginId)) {
            return false;
        }

        return loginId.equals(this.loginId);
    }
}
