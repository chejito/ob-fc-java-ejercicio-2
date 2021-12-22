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
            User user = findUserByEmail(email);
            if (user == null) {
                int passwordHash = getHash(password);
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
        User user = findUserByEmail(email);
        if (user == null) {
            return -1;
        }

        int hash = getHash(password);
        if (hash != user.getPasswordHash()) {
            return -2;
        }
        return 1;
    }
    /**
     * Método que devuelve un usuario almacenado en el ArrayList de usuarios.
     * Lo busca por su e-mail.
     *
     * @param email E-mail del usuario a buscar.
     * @return En caso afirmativo, el usuario. En caso negativo devuelve null.
     */
    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Método que genera un código hash a partir de la contraseña aportada como String.
     *
     * @param password String contraseña del usuario.
     * @return int número entero que representa un código hash.
     */
    private int getHash(String password) {
        String secret = "secret";
        return password.hashCode() * secret.hashCode();
    }
}
