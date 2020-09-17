package fr.pgah.slam5;

import java.util.*;

public class Banque {
    private HashMap<Integer, Compte> comptes = new HashMap<>();
    private double taux = 0.01;
    private int numDernierCompte = 0;

    public int creerCompte(boolean estEtranger) {
        int numCompte = numDernierCompte++;
        Compte nouveau = new Compte(estEtranger);
        comptes.put(numCompte, nouveau);
        return numCompte;
    }

    public int getSolde(int numCompte) {
        return comptes.get(numCompte).getSolde();
    }

    public void crediter(int numCompte, int montant) {
        Compte compte = comptes.get(numCompte);
        int solde = comptes.get(numCompte).getSolde();
        int nouveauSolde = solde + montant;
        compte.setSolde(nouveauSolde);
    }

    public void appliquerInteret() {
        for (Compte compte : comptes.values()) {
            int solde = compte.getSolde();
            int nouveauSolde = (int) (solde * (1 + taux));
            compte.setSolde(nouveauSolde);
        }
    }

    public String toString() {
        Set<Integer> numerosDesComptes = comptes.keySet();
        String res = "La banque gère " + numerosDesComptes.size() + " comptes.";
        String provenance;
        for (int num : numerosDesComptes) {
            if (comptes.get(num).getEstEntanger()) {
                provenance = "étranger";
            } else {
                provenance = "non-étranger";
            }
            res += "\n\tCompte " + num + ": solde = " + comptes.get(num).getSolde() + " ( " + provenance + " ) ";
        }
        return res;
    }

    public boolean autoriserEmprunt(int numCompte, int montant) {
        int solde = comptes.get(numCompte).getSolde();
        return (solde >= montant / 2);
    }
}
