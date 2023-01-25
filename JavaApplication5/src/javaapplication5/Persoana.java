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
public class Persoana {

    private String nume;
    private int id;
    private int idDept;
    private String adresa;
    private String telefon;
    private String email;
    private String iban;
    private int zileConcediu;
    private float salar;

    private static int idPersoanaLogata;

    public static int getIdPersoanaLogata() {
        return idPersoanaLogata;
    }

    public Persoana(int id, String nume, int id_dept, String adresa, String telefon, String email, String iban, int zileConcediu, float salar) {
        this.id = id;
        this.nume = nume;
        this.idDept = id_dept;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.iban = iban;
        this.zileConcediu = zileConcediu;
        this.salar = salar;
    }

    int getId() {
        return id;
    }

    public static void setIdPersoanaLogata(int idPersoanaLogata) {
        Persoana.idPersoanaLogata = idPersoanaLogata;
    }

    String getNume() {
        return nume;
    }

    String getIban() {
        return iban;
    }

    float getSalar() {
        return salar;
    }

    String getMail() {
        return email;
    }

    int getZileConcediu() {
        return zileConcediu;
    }

    String getTelefon() {
        return telefon;
    }

    String getAdresa() {
        return adresa;
    }

    int getIdDept() {
        return idDept;
    }

    /**
     * Adaugă o înregistrare în tabela Persoana din baza de date
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insert() throws ClassNotFoundException, SQLException {
        Connection c = openConn();
        PreparedStatement ps = c.prepareStatement("INSERT INTO PERSOANA(nume,"
                + "id_dept, adresa, telefon, email, iban,"
                + "zile_concediu, salar) values (?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, nume);
        ps.setInt(2, idDept);
        ps.setString(3, adresa);
        ps.setString(4, telefon);
        ps.setString(5, email);
        ps.setString(6, iban);
        ps.setInt(7, zileConcediu);
        ps.setFloat(8, salar);
        ps.execute();
    }

    /**
     * Șterge o înregistrare din tabela Persoană din baza de date.
     *
     * @param idPersoana identificatorul unic al persoanei care se șterge din
     * registru
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void delete(int idPersoana) throws ClassNotFoundException, SQLException {
        Connection c = openConn();
        PreparedStatement ps = c.prepareStatement("DELETE FROM PERSOANA WHERE ID = ?");
        ps.setInt(1, idPersoana);
        ps.execute();
    }
}
