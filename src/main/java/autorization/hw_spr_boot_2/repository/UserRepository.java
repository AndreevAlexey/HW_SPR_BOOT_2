package autorization.hw_spr_boot_2.repository;

import autorization.hw_spr_boot_2.constants.Authorities;
import autorization.hw_spr_boot_2.user.User;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    private void init() {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
    }

    public UserRepository() {
        init();
    }

    public List<Authorities> getUserAuthorities(User user) {
        User chkUser = users.get(user.getName());
        if(chkUser != null && chkUser.equals(user)) {
            return Arrays.asList(Authorities.READ, Authorities.WRITE);
        }
        return null;
    }
}
