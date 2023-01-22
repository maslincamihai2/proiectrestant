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
 * Clasa responsabilă de validarea conturilor în faza de autentificare.
 * @author User
 */
public class Cont {

    private String user;
    private String parola;

    /**
     * Constructorul clasei
     * @param user Numele de utilizator introdus
     * @param parola Parola introdusa
     */
    public Cont(String user, String parola) {
        this.user = user;
        this.parola = parola;
    }

    /**
     * Metoda de validare a contului.
     * @return false dacă creditențialele sunt incorecte, true dacă este valid contul
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    Boolean valideaza() throws ClassNotFoundException, SQLException {
        Connection c = Bd.openConn();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM CONT WHERE USER = ? AND PAROLA = ?");
        ps.setString(1, user);
        ps.setString(2, parola);
        ResultSet rs = ps.executeQuery();
        if (rs.next() == false) {
            return false;
        }
        return true;
    }

    /**
     * Returnează departamentul persoanei căreia îi corespunde contul de utilizator
     * @return Număr întreg ce reprezintă identificatorul unic al deparamentului
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int getDept() throws ClassNotFoundException, SQLException {
        Connection c = Bd.openConn();

        PreparedStatement ps = c.prepareStatement("SELECT id_dept FROM PERSOANA, CONT WHERE ID_CONT = (SELECT ID FROM CONT WHERE USER = ? AND PAROLA = ?)");
        ps.setString(1, user);
        ps.setString(2, parola);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    /**
     * Returnează identificatorul persoanei care s-a autentificat
     * @return Număr întreg ce reprezintă identificatorul unic al persoanei autentificate
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public int getIdPersoana() throws ClassNotFoundException, SQLException {
        Connection c = Bd.openConn();

        PreparedStatement ps = c.prepareStatement("SELECT PERSOANA.ID FROM PERSOANA,CONT WHERE PERSOANA.ID_CONT = (SELECT CONT.ID FROM CONT WHERE USER = ? AND PAROLA = ?)");
        ps.setString(1, user);
        ps.setString(2, parola);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
