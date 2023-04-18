package controladora;

import conexion.AccedoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.DtoEmpleado;

/**
 *
 * @author fernando leon
 */
public class DaoEmpleado {
    
    private DtoEmpleado dtoInsertar = null;
    DtoEmpleado dtoBuscar = new DtoEmpleado();
    private Connection con;
    private PreparedStatement objInsertar, objBuscar, objEditar, objEliminar;
    private AccedoBD datosBD = new AccedoBD();
    
    
    public DaoEmpleado() throws SQLException {
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(datosBD.getUrl(), datosBD.getUser(), datosBD.getPass());
        }catch(ClassNotFoundException classNotFound) {
           System.out.print(classNotFound + " Error, No se a encontrado el driver");
           System.exit(1);
        }
    }
    
    public void transferir(DtoEmpleado datos) {
        this.dtoInsertar = datos;
    }
    
    public void insertarEmppleado() {
    try {
    objInsertar = con.prepareStatement("INSERT INTO tb_empleados(apellido_paterno, apellido_materno, nombre, fecha_contratacion, salario_diario) VALUES(?,?,?,?,?)");
    
    objInsertar.setString(1, dtoInsertar.getApellidoPaterno());
    objInsertar.setString(2, dtoInsertar.getApellidoMaterno());
    objInsertar.setString(3, dtoInsertar.getNombre());
    objInsertar.setDate(4, (Date) dtoInsertar.getFechaContratacion());
    objInsertar.setFloat(5, dtoInsertar.getSalarioDiario());
    objInsertar.execute();
    }catch(SQLException e){
        System.out.print("Error al agregar empleado: " + e);
    }finally {
        try {
            objInsertar.close();
        }catch (SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
    }

    public void eliminarEmpleado() {
        try {
            objEliminar = con.prepareStatement("DELETE FROM tb_empleados WHERE id_empleado = ?");
            objEliminar.setInt(1, dtoInsertar.getIdEmpeado());
            objEliminar.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error al borrar el empleado");
        }finally {
            try {
                dtoInsertar = null;
                objEliminar.close();
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    
    public void editarEmpleado() {
        try {
            objEditar = con.prepareStatement("UPDATE tb_empleados SET apellido_paterno = ?, apellido_materno = ?, nombre = ?, fecha_contratacion = ?, salario_diario = ? WHERE id_empleado = ?");
            objEditar.setString(1, dtoInsertar.getApellidoPaterno());
            objEditar.setString(2, dtoInsertar.getApellidoMaterno());
            objEditar.setString(3, dtoInsertar.getNombre());

            objEditar.setDate(4, (Date) dtoInsertar.getFechaContratacion());
            objEditar.setDouble(5, dtoInsertar.getSalarioDiario());
            objEditar.setInt(6, dtoInsertar.getIdEmpeado());
            objEditar.executeUpdate();
            System.out.println("Empleado actualizado correctamente");
        }catch (SQLException ex){
            System.out.println("Error al editar al empleado");
        }finally {
            try {
                objEditar.close();
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public DtoEmpleado buscarEmpleadoId(int idEmpleado) throws SQLException {
        objBuscar = con.prepareStatement("SELECT * FROM tb_empleados WHERE id_empleado = ?");
        objBuscar.setInt(1, idEmpleado);
        ResultSet rs = objBuscar.executeQuery();

        while(rs.next()) {
            dtoBuscar.setIdEmpeado(rs.getInt("id_empleado"));
            dtoBuscar.setApellidoPaterno(rs.getString("apellido_paterno"));
            dtoBuscar.setApellidoMaterno(rs.getString("apellido_materno"));
            dtoBuscar.setNombre(rs.getString("nombre"));
            dtoBuscar.setFechaContratacion(rs.getDate("fecha_contratacion"));
            dtoBuscar.setSalarioDiario(rs.getFloat("salario_diario"));
        }
        return dtoBuscar;
    }

    public DtoEmpleado buscarEmpleadoApellido(String apellido_pa) throws SQLException {
        objBuscar = con.prepareStatement("SELECT * FROM tb_empleados WHERE apellido_paterno = ?");
        objBuscar.setString(1, apellido_pa);
        ResultSet rs = objBuscar.executeQuery();

        while(rs.next()) {
            dtoBuscar.setIdEmpeado(rs.getInt("id_empleado"));
            dtoBuscar.setApellidoPaterno(rs.getString("apellido_paterno"));
            dtoBuscar.setApellidoMaterno(rs.getString("apellido_materno"));
            dtoBuscar.setNombre(rs.getString("nombre"));
            dtoBuscar.setFechaContratacion(rs.getDate("fecha_contratacion"));
            dtoBuscar.setSalarioDiario(rs.getFloat("salario_diario"));
        }
        return dtoBuscar;
    }


    
}
