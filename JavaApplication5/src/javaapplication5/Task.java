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
public class Task {
    private int idPersoana;
    private String descriere;
    private Date deadline;

    public Task(int idPersoana, String descriere, Date deadline) {
        this.idPersoana = idPersoana;
        this.descriere = descriere;
        this.deadline = deadline;
    }

    public int getIdPersoana() {
        return idPersoana;
    }

    public String getDescriere() {
        return descriere;
    }

    public Date getDeadline() {
        return deadline;
    }


}
