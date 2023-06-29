 
package BaseDatos;
 
public class Usuarios {
     private int id;
     private String usuario, password;
     private int privilegio;

    public Usuarios(int id, String usuario, String password, int privilegio) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.privilegio = privilegio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }

    @Override
    public String toString() {
        return "\nUsuarios{" + "id=" + id + ", usuario=" + usuario + ", password=" + password + ", privilegio=" + privilegio + '}';
    }
     
     
}
