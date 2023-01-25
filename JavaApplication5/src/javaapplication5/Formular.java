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
public class Formular {

    private String titlu;
    private String continut;

    public Formular(String titlu, String continut) {
        this.titlu = titlu;
        this.continut = continut;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getContinut() {
        return continut;
    }
    
        /**
     * Adaugă o înregistrare în tabela Formular din baza de date
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void insert() throws ClassNotFoundException, SQLException {
        Connection c = openConn();
        PreparedStatement ps = c.prepareStatement("INSERT INTO FORMULAR(titlu, descriere)"
                + "values (?, ?)");
        ps.setString(1, titlu);
        ps.setString(2, continut);
        ps.execute();
    }
}
