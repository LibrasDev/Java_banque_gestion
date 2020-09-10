package fr.pgah.slam5;

import java.util.*;

public class GGBanque {
  private HashMap<Integer, Integer> comptes = new HashMap<>();
  private double taux = 0.01;
  private int numDernierCompte = 0;
  private int numCompteSelectionne = 0;
  private Scanner scanner;
  private boolean fin = false;

  public static void main(String[] args) {
    GGBanque laBanque = new GGBanque();
    laBanque.run();
  }

  private void run() {
    scanner = new Scanner(System.in);
    while (!fin) {
      System.out.print(
          "Entrez une commande (0 = quitter, 1 = nouveau compte, 2 = changer compte, 3 = créditer compte, 4 = demander emprunt, 5 = afficher infos comptes, 6 = appliquer intérêts): ");
      int choix = scanner.nextInt();
      traiterCommande(choix);
    }
    scanner.close();
  }

  private void traiterCommande(int cmd) {
    if (cmd == 0) {
      fin = true;
      System.out.println("À bientôt.");
    } else if (cmd == 1) {
      numCompteSelectionne = numDernierCompte++;
      comptes.put(numCompteSelectionne, 0);
      System.out.println("Le numéro de votre nouveau compte est : " + numCompteSelectionne);
    } else if (cmd == 2) {
      System.out.print("Entrez le numéro du compte : ");
      numCompteSelectionne = scanner.nextInt();
      int solde = comptes.get(numCompteSelectionne);
      System.out.println("Le solde du compte " + numCompteSelectionne + " est " + solde);
    } else if (cmd == 3) {
      System.out.print("Entrez le montant : ");
      int montant = scanner.nextInt();
      int solde = comptes.get(numCompteSelectionne);
      comptes.put(numCompteSelectionne, solde + montant);
    } else if (cmd == 4) {
      System.out.print("Entrez le montant de l'emprunt souhaité : ");
      int montant = scanner.nextInt();
      int solde = comptes.get(numCompteSelectionne);
      if (solde >= montant / 2) {
        System.out.println("Votre demande est approuvée.");
      } else {
        System.out.println("Votre demande est refusée.");
      }
    } else if (cmd == 5) {
      Set<Integer> numerosDesComptes = comptes.keySet();
      System.out.println("La banque gère " + numerosDesComptes.size() + " comptes.");
      for (int num : numerosDesComptes) {
        System.out.println("\tCompte " + num + ": solde = " + comptes.get(num));
      }
    } else if (cmd == 6) {
      Set<Integer> numerosDesComptes = comptes.keySet();
      for (int num : numerosDesComptes) {
        int solde = comptes.get(num);
        int nouveauSolde = (int) (solde * (1 + taux));
        comptes.put(num, nouveauSolde);
      }
    }
  }
}
