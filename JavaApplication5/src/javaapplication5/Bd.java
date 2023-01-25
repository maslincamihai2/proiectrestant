/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Clasa execută operațiuni cu baza de date.
 *
 * @author User
 */
public class Bd {

    /**
     * Stabilește o conexiune cu baza de date.
     *
     * @return obiect de tip Connection utilizat în executarea de statement-uri
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection openConn() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        String url = "jdbc:mysql://127.0.0.1:3306/demo";
        String user = "root";
        String password = "";
        return (Connection) DriverManager.getConnection(url, user, password);
    }

    /**
     * Returnează înregistrările din tabela Persoana
     *
     * @return ArrayList de obiecte de tip Persoana
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Persoana> getPersoane() throws ClassNotFoundException, SQLException {
        ArrayList<Persoana> persoane = new ArrayList();
        Connection c = openConn();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PERSOANA");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nume = rs.getString(4);
            int id_dept = rs.getInt(3);
            String adresa = rs.getString(6);
            String telefon = rs.getString(7);
            String email = rs.getString(8);
            String iban = rs.getString(10);
            int zileConcediu = rs.getInt(11);
            float salar = rs.getFloat(9);
            persoane.add(new Persoana(id, nume, id_dept, adresa, telefon, email, iban, zileConcediu, salar));
        }
        return persoane;
    }

    /**
     * Returnează înregistrările din tabela Formular
     *
     * @return ArrayList de obiecte de tip Formular
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Formular> getFormulare() throws ClassNotFoundException, SQLException {
        ArrayList<Formular> formulare = new ArrayList();
        Connection c = openConn();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM FORMULAR");
        while (rs.next()) {
            formulare.add(new Formular(rs.getString(3), rs.getString(4)));
        }
        return formulare;
    }

    /**
     * Returnează înregistrările din tabela Task
     *
     * @return ArrayList de obiecte de tip Task
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Task> getTaskuri() throws ClassNotFoundException, SQLException {
        ArrayList<Task> taskuri = new ArrayList();
        Connection c = openConn();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM TASK");
        while (rs.next()) {
            taskuri.add(new Task(rs.getInt(4), rs.getString(3), rs.getDate(2)));
        }
        return taskuri;
    }

    /**
     * Returnează înregistrările din tabela Departament
     *
     * @return ArrayList de obiecte de tip Departament
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Departament> getDepartamente() throws ClassNotFoundException, SQLException {
        ArrayList<Departament> departamente = new ArrayList();
        Connection c = openConn();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Departament");
        while (rs.next()) {
            departamente.add(new Departament(rs.getInt(1), rs.getString(2)));
        }
        return departamente;
    }
}
