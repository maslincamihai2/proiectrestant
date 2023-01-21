/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Bd {

    public static Connection openConn() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        String url = "jdbc:mysql://127.0.0.1:3306/demo";
        String user = "root";
        String password = "";
        return (Connection) DriverManager.getConnection(url, user, password);
    }

    public static ArrayList<Persoana> getPersoane() throws ClassNotFoundException, SQLException {
        ArrayList<Persoana> persoane = new ArrayList();
        Connection c = openConn();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PERSOANA");
        while (rs.next()) {
            String nume = rs.getString(4);
            int id_dept = rs.getInt(3);
            String adresa = rs.getString(6);
            String telefon = rs.getString(7);
            String email = rs.getString(8);
            String iban = rs.getString(10);
            int zileConcediu = rs.getInt(11);
            float salar = rs.getFloat(9);
            persoane.add(new Persoana(nume, id_dept, adresa, telefon, email, iban, zileConcediu, salar));
        }
        return persoane;
    }

    public static void adaugaPersoana(Persoana p) throws ClassNotFoundException, SQLException {
        Connection c = openConn();
        PreparedStatement ps = c.prepareStatement("INSERT INTO PERSOANA(nume,"
                + "id_dept, adresa, telefon, email, iban,"
                + "zile_concediu, salar) values (?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, p.getNume());
        ps.setInt(2, p.getIdDept());
        ps.setString(3, p.getAdresa());
        ps.setString(4, p.getTelefon());
        ps.setString(5, p.getMail());
        ps.setString(6, p.getIban());
        ps.setInt(7, p.getZileConcediu());
        ps.setFloat(8, p.getSalar());
        ps.execute();
    }

    public static void trimiteFormular(Formular f) throws ClassNotFoundException, SQLException {
        Connection c = openConn();
        PreparedStatement ps = c.prepareStatement("INSERT INTO FORMULAR(titlu, descriere)"
                + "values (?, ?)");
        ps.setString(1, f.getTitlu());
        ps.setString(2, f.getContinut());
    }
}
