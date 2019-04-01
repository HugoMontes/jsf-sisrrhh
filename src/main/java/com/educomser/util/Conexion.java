package com.educomser.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class Conexion {

    final static Logger LOGGER = Logger.getLogger(Conexion.class);

    private DataSource dataSource;
    private Connection connection;

    public Conexion() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/Educomser");
        } catch (NamingException ex) {
            LOGGER.error("Error en el pool de conexion: " + ex);
        }
    }

    public Connection getConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            LOGGER.error("Error en la conexion: " + ex);
        }
        return connection;
    }
}
