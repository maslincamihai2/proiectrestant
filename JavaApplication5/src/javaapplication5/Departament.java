/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javaapplication5.Bd.openConn;

/**
 *
 * @author User
 */
public class Departament {

    private int id;
    private String nume;

    public Departament(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    /**
     * Actualizează o înregistrare din tabela Departament din baza de date.
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void update() throws ClassNotFoundException, SQLException {
        Connection c = openConn();
        PreparedStatement ps = c.prepareStatement("UPDATE DEPARTAMENT SET nume = ? WHERE ID = ?");
        ps.setString(1, nume);
        ps.setInt(2, id);
        ps.execute();
    }

    public void delete() throws ClassNotFoundException, SQLException {
        Connection c = openConn();
        PreparedStatement ps = c.prepareStatement("DELETE FROM DEPARTAMENT WHERE nume = ? AND id = ?");
        ps.setString(1, nume);
        ps.setInt(2, id);
        ps.execute();
    }

}
