/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javaapplication5.Bd.openConn;

/**
 *
 * @author User
 */
public class Task {
    private int idPersoana;
    private String descriere;
    private Date deadline;

    /**
     * Contructorul clasei
     * @param idPersoana identificatorul unic din baza de date al persoanei căreia îi este destinat task-ul
     * @param descriere descrierea sarcinii
     * @param deadline  termenul limită până când trebuie finalizată sarcina
     */
    public Task(int idPersoana, String descriere, Date deadline) {
        this.idPersoana = idPersoana;
        this.descriere = descriere;
        this.deadline = deadline;
    }

    /**
     * Returneaza identificatorul persoanei căreia îi este destinat task-ul
     * @return identificatorul unei persoane din baza de date ca număr întreg
     */
    public int getIdPersoana() {
        return idPersoana;
    }

    /**
     * Returnează descrierea task-ului
     * @return descrierea task-ului ca șir de caractere
     */
    public String getDescriere() {
        return descriere;
    }

    /**
     * Returnează termenul limită
     * @return deadline-ul unui task in format Date SQL
     */
    public Date getDeadline() {
        return deadline;
    }

     /**
     * Adaugă o înregistrare în tabela Task din baza de date
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void insert() throws ClassNotFoundException, SQLException {
        Connection c = openConn();
        PreparedStatement ps = c.prepareStatement("INSERT INTO TASK(id_utilizator, descriere, deadline)"
                + "values (?, ?, ?)");
        ps.setInt(1, idPersoana);
        ps.setString(2, descriere);
        ps.setDate(3, deadline);
        ps.execute();
    }
    
}
