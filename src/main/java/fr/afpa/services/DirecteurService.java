package fr.afpa.services;

import fr.afpa.models.Directeur;
import fr.afpa.models.Employe;

public class DirecteurService extends EmployeService{

    public static double calculPrime(Directeur directeur) {
        double salaire = directeur.getSalary();
        int anciennete = EmployeService.calculAnciennete(directeur);
        return (salaire * 0.07) + ((salaire * 0.03) * anciennete);
    }
}
