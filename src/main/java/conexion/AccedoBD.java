package conexion;

/**
 *
 * @author fernando leon
 */
public class AccedoBD {
    
    private String url = "jdbc:mysql://localhost:3306/bdempleados";
    private String user = "root"; // Tu usuario
    private String pass = "1234"; //Tu contraseña de MYSQL

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }

    public String getPass() { return pass; }

    public void setPass(String pass) { this.pass = pass; }
    
    
}
