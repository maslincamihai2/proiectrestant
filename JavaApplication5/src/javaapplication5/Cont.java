/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Cont {

    private String user;
    private String parola;

    public Cont(String user, String parola) {
        this.user = user;
        this.parola = parola;
    }

    Boolean valideaza() throws ClassNotFoundException, SQLException {
        Connection c = Bd.openConn();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM CONT WHERE USER = ? AND PAROLA = ?");
        ps.setString(1, user);
        ps.setString(2, parola);
        ResultSet rs = ps.executeQuery();
        if (rs.next() == false){
            return false;
        }
        return true;
    }
    
    public int getDept() throws ClassNotFoundException, SQLException{
        Connection c = Bd.openConn();
        
        PreparedStatement ps = c.prepareStatement("SELECT id_dept FROM PERSOANA, CONT WHERE ID_CONT = (SELECT ID FROM CONT WHERE USER = ? AND PAROLA = ?)");
        ps.setString(1, user);
        ps.setString(2, parola);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
