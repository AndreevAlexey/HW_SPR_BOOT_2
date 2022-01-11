package autorization.hw_spr_boot_2.repository;

import autorization.hw_spr_boot_2.constants.Authorities;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private ConcurrentHashMap<String, String> loginPassword = new ConcurrentHashMap<>();

    private void init() {
        loginPassword.put("user1", "password1");
        loginPassword.put("user2", "password2");
    }

    public UserRepository() {
        init();
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        String pass = loginPassword.get(user);
        if(pass != null && pass.equals(password)) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE);
        }
        return null;
    }
}
