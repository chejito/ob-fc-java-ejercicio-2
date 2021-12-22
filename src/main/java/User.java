/**
 * Entidad que representa a los usuarios que se almacenan en el ArrayList de usuarios.
 */
public class User {
    private String email;
    private Integer passwordHash;

    public User(String email, Integer passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(Integer passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "entity.User{" + "email='" + email + '\'' + ", passwordHash=" + passwordHash + '}';
    }
}
