/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Persoana {

    String nume;
    int id_dept;
    String adresa;
    String telefon;
    String email;
    String iban;
    int zileConcediu;
    float salar;

    public Persoana(String nume, int id_dept, String adresa, String telefon, String email, String iban, int zileConcediu, float salar) {
        this.nume = nume;
        this.id_dept = id_dept;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.iban = iban;
        this.zileConcediu = zileConcediu;
        this.salar = salar;
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
