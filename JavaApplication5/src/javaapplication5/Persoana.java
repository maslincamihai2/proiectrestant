/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author User
 */
public class Persoana {

    private String nume;
    private int id;
    private int id_dept;
    private String adresa;
    private String telefon;
    private String email;
    private String iban;
    private int zileConcediu;
    private float salar;

    private static int idPersoanaLogata;
    
    public static int getIdPersoanaLogata(){
        return idPersoanaLogata;
    }
    
    public Persoana(int id, String nume, int id_dept, String adresa, String telefon, String email, String iban, int zileConcediu, float salar) {
        this.id = id;
        this.nume = nume;
        this.id_dept = id_dept;
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
        return id_dept;
    }
}
