import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAccessSystemTest {

    @Test
    void register() {
        UserAccessSystem access = new UserAccessSystem();

        assertAll(
                () -> assertTrue(access.register("user1@user.com", "12345")),
                () -> assertFalse(access.register("user1@user.com", "dogandcat")),
                () -> assertFalse(access.register("", "mytaylorisrich")),
                () -> assertFalse(access.register("user4@user.com", "")),
                () -> assertFalse(access.register("", ""))
        );
    }

    @Test
    void login() {
        UserAccessSystem access = new UserAccessSystem();

        String[][] users = {
                {"user6@user.com", "12345"},
                {"user7@user.com", "dogandcat"},
                {"user8@user.com", "mytaylorisrich"},
                {"user9@user.com", "01012000"},
                {"user10@user.com", "imbored"}
        };

        for (String[] user : users) {
            access.register(user[0], user[1]);
        }

        assertAll(
                () ->assertEquals(access.login("user6@user.com", "12345"), 1),
                () -> assertEquals(access.login("user7@user.com", "catandmouse"), -2),
                () -> assertEquals(access.login("user18@user.com", "mytaylorisrich"), -1),
                () -> assertEquals(access.login("", "01012000"), -1),
                () -> assertEquals(access.login("user10@user.com", ""), -2)
        );
    }
}