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
}
