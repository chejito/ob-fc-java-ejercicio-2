import java.util.ArrayList;

/**
 * Clase permite registrarse e iniciar sesión a los usuarios.
 */
public class UserAccessSystem {

    private final ArrayList<User> users = new ArrayList<>();

    /**
     * Método que permite registrar a un usuario con sus datos de usuario (e-mail y contraseña).
     *
     * @param email    String e-mail del usuario.
     * @param password String contraseña del usuario.
     * @return boolean false si el usuario está almacenado en el repositorio, true si es un nuevo usuario.
     */
    public boolean register(String email, String password) {
        if (!email.equals("") && !password.equals("")) {
            User userToLogin = null;

            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    userToLogin = user;
                }
            }

            if (userToLogin == null) {
                int passwordHash = password.hashCode();
                users.add(new User(email, passwordHash));
                return true;
            }
        }
        return false;
    }

    /**
     * Método que permite iniciar sesión a un usuario con sus datos de usuario (e-mail y contraseña).
     *
     * @param email    String e-mail del usuario.
     * @param password String contraseña del usuario.
     * @return int -1 si el e-mail no existe, -2 si la contraseña es incorrecta y 1 si ambos son correctos.
     */
    public int login(String email, String password) {
        User userToLogin = null;

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                userToLogin = user;
            }
        }

        if (userToLogin == null) {
            return -1;
        }


        int hash = password.hashCode();
        if (hash != userToLogin.getPasswordHash()) {
            return -2;
        }
        return 1;
    }
}
