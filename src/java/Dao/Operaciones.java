package Dao;

import Modelo.Votantes;
import Dao.ConexionBBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Operaciones {

    public static boolean comprobar(Connection conexion, Votantes votante) throws SQLException {
        boolean estado = false;
        String dni = votante.getDni();
        try {
            String sentencia = " SELECT dni FROM votantes WHERE dni = ? ";

            PreparedStatement statement = conexion.prepareStatement(sentencia);
            statement.setString(1, dni);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                estado = true;
            }
        } catch (Exception e) {
        }
        return estado;
    }

    public static void registrar(Connection conexion, Votantes votante) throws SQLException {

        String dni = votante.getDni();
        String clave = votante.getClave();

        String sentencia = " INSERT INTO votantes VALUES (null, ? , AES_ENCRYPT( ? , 'manuel'), 'N') ";

        PreparedStatement sql = conexion.prepareStatement(sentencia);
        sql.setString(1, dni);
        sql.setString(2, clave);

        sql.executeUpdate();
    }

    public static boolean iniciar(Connection conexion, Votantes votante) throws SQLException {
        boolean estado = false;
        String dni = votante.getDni();
        String clave = votante.getClave();

        String sentencia = " SELECT dni FROM votantes WHERE dni=? and AES_DECRYPT(clave,'manuel')=? ";

        PreparedStatement sql = conexion.prepareStatement(sentencia);
        sql.setString(1, dni);
        sql.setString(2, clave);

        ResultSet rs = sql.executeQuery();

        if (rs.next()) {
            estado = true;
        }
        return estado;
    }

    public static boolean votarc(Connection conexion, Votantes votante) throws SQLException {
        boolean estado = false;
        //Con 1 encuentra fila.
        //Con 2 no encuentra nada.

        String dni = votante.getDni();

        String sentencia = "UPDATE votantes SET voto=? WHERE dni=?";

        PreparedStatement sql = conexion.prepareStatement(sentencia);
        sql.setString(1, "Y");
        sql.setString(2, dni);

        String comprobacion = "SELECT dni FROM votantes WHERE dni = ? AND voto = 'N'";
        PreparedStatement sqlc = conexion.prepareStatement(comprobacion);
        sqlc.setString(1, dni);
        ResultSet rs = sqlc.executeQuery();
        if (rs.next()) {
            estado = true;
        }

        if (estado == true) {
            sql.executeUpdate();
        }
        return estado;
    }

    public static void votar(Connection conexion, Votantes votante, String eleccion) throws SQLException {
        String sentencia = "UPDATE partidospoliticos SET votospar = votospar+1 WHERE siglaspar = ? ";

        PreparedStatement sql = conexion.prepareStatement(sentencia);
        sql.setString(1, eleccion);

        sql.executeUpdate();
    }

    public static boolean baja(Connection conexion, Votantes votante) throws SQLException {
        boolean estado = false;
        //Con 1 encuentra fila.
        //Con 2 no encuentra nada.

        String dni = votante.getDni();
        String clave = votante.getClave();

        String sentencia = "DELETE FROM votantes WHERE dni = ? ";

        PreparedStatement sql = conexion.prepareStatement(sentencia);
        sql.setString(1, dni);

        String comprobacion = "SELECT dni FROM votantes WHERE dni = ?";

        PreparedStatement sqlc = conexion.prepareStatement(comprobacion);
        sqlc.setString(1, dni);
        sqlc.setString(2, clave);

        ResultSet rs = sqlc.executeQuery();
        if (rs.next()) {
            estado = true;
        }
        if (estado == true) {
            sql.executeUpdate();
        }
        return estado;
    }

    public static ArrayList<Votantes> añadir(Connection conexion) throws SQLException {
        ArrayList votantes = new ArrayList();
        String sentencia = "SELECT * FROM votantes";
        PreparedStatement sql = conexion.prepareStatement(sentencia);
        ResultSet rs = sql.executeQuery();

        ArrayList Fila = new ArrayList();
        while (rs.next()) {
            for (int i = 1; i <= 4; i++) {
                Fila.add(rs.getString(i));
            }
            votantes.add(Fila);
        }
        return votantes;
    }
}
