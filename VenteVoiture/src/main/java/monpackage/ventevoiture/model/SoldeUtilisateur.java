package monpackage.ventevoiture.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class SoldeUtilisateur {
    private int idCompteUtilisateur;
    private String idUtilisateur;

    private double solde;

    public int getIdCompteUtilisateur() {
        return idCompteUtilisateur;
    }

    public void setIdCompteUtilisateur(int idCompteUtilisateur) {
        this.idCompteUtilisateur = idCompteUtilisateur;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

}
