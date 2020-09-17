package fr.pgah.slam5;

public class Compte {

    private int solde;
    private boolean estEtranger;

    public Compte(boolean estEtranger) {
        this.estEtranger = estEtranger;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int montant) {
        solde = montant;
    }

    public boolean getEstEntanger() {
        return estEtranger;
    }
}