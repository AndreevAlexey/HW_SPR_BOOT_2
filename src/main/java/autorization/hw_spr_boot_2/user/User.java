package autorization.hw_spr_boot_2.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Pattern(regexp = "^[a-zA-z0-9]{3,}")
    private String name;
    @Size(min=6, max=15)
    private String pass;

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != User.class) {
            return false;
        }
        User user = (User) obj;
        return user.name.equals(this.name) && user.pass.equals(this.pass);
    }
}
