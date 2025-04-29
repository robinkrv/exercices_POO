package fr.afpa.services;

import fr.afpa.constants.ModeRestauration;
import fr.afpa.models.Agence;
import fr.afpa.models.Employe;
import fr.afpa.models.Enfant;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class EmployeService {

    public static int calculAnciennete(Employe employe) {

        LocalDate entryDate = employe.getEntryDate();
        if (entryDate == null) {
            return 0;
        }
        LocalDate currentDate = LocalDate.now();
        return (int) ChronoUnit.YEARS.between(entryDate, currentDate);
    }

    public double calculPrime(Employe employe) {

        double salaire = employe.getSalary();
        int ancienneté = calculAnciennete(employe);
        double prime = (salaire * 5 / 100) + ((salaire * 2 / 100) * ancienneté);
        LocalDate today = LocalDate.now();

        //if (today.getMonthValue() == 11 && today.getDayOfMonth() == 30) {
            //System.out.println("La prime d'un montant de " + prime + " a été versée sur votre compte");
       // } else {
            //System.out.println("Votre prime sera versée le 30/11");
        //}
        return prime;
    }

    public double calculMasseSalariale(List<Employe> employes) {

        double masseSalariale = 0;

        for (Employe e : employes) {
            masseSalariale += e.getSalary() + calculPrime(e);
        }
        return masseSalariale;
    }

    public static void checkModeRestauration(Employe employe) {
        String nom = employe.getName() + " " + employe.getFirstname();

        Agence agence = employe.getAgence();
        if (agence != null) {
            ModeRestauration mode = agence.getModeRestauration();
            System.out.println(nom + " bénéficie du mode de restauration : " + mode);
        } else {
            System.out.println(nom + " - Pas d'agence assignée");
        }
    }

    public static void checkChequeVacances(Employe employe) {
        String nom = employe.getName() + " " + employe.getFirstname();

        if (EmployeService.calculAnciennete(employe) > 1) {
            System.out.println(nom + " peut bénéficier de chèques vancances.");
        }
        else {
            System.out.println(nom + " ne peut pas bénéficier de chèques vancances;");
        }
    }

    public static void checkChequeNoel(Employe employe) {
        int nbCheques20 = 0;
        int nbCheques30 = 0;
        int nbCheques50 = 0;

        for (Enfant enfant : employe.getEnfants()) {
            int age = enfant.getAge();
            if (age >= 0 && age <= 10) {
                nbCheques20++;
            } else if (age >= 11 && age <= 15) {
                nbCheques30++;
            } else if (age >= 16 && age <= 18) {
                nbCheques50++;
            }
        }
        String nom = employe.getName() + " " + employe.getFirstname();

        if (nbCheques20 + nbCheques30 + nbCheques50 > 0) {
            System.out.println(nom + " a droit aux chèques Noël : OUI");
            if (nbCheques20 > 0) System.out.println(" - " + nbCheques20 + " chèque(s) de 20€");
            if (nbCheques30 > 0) System.out.println(" - " + nbCheques30 + " chèque(s) de 30€");
            if (nbCheques50 > 0) System.out.println(" - " + nbCheques50 + " chèque(s) de 50€");
        } else {
            System.out.println(nom + " a droit aux chèques Noël : NON");
        }
    }
}

