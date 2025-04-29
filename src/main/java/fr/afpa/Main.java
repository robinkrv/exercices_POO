package fr.afpa;

import fr.afpa.constants.ModeRestauration;
import fr.afpa.models.Agence;
import fr.afpa.models.Directeur;
import fr.afpa.models.Employe;
import fr.afpa.models.Enfant;
import fr.afpa.services.DirecteurService;
import fr.afpa.services.EmployeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Agence agence1 = new Agence();
        agence1.setModeRestauration(ModeRestauration.RESTAURANT_ENTREPRISE);

        Agence agence2 = new Agence();
        agence2.setModeRestauration(ModeRestauration.TICKETS_RESTAURANTS);

        Enfant enfant1 = new Enfant();
        enfant1.setPrénom("Alice");
        enfant1.setAge(9);

        Enfant enfant2 = new Enfant();
        enfant2.setPrénom("Charles");
        enfant2.setAge(12);

        Enfant enfant3 = new Enfant();
        enfant3.setPrénom("Snoop");
        enfant3.setAge(19);


        Employe emp1 = new Employe();
        emp1.setName("Durand");
        emp1.setFirstname("Paul");
        emp1.setEntryDate(LocalDate.of(2015, 3, 15));
        emp1.setJob("Comptable");
        emp1.setSalary(3000.0);
        emp1.setService("Finance");
        emp1.setAgence(agence1);
        emp1.getEnfants().addAll(List.of(enfant1, enfant2, enfant3));

        Employe emp2 = new Employe();
        emp2.setName("Martin");
        emp2.setFirstname("Sophie");
        emp2.setEntryDate(LocalDate.of(2018, 7, 1));
        emp2.setJob("Développeur");
        emp2.setSalary(3500.0);
        emp2.setService("Informatique");
        emp2.setAgence(agence2);

        Employe emp3 = new Employe();
        emp3.setName("Lemoine");
        emp3.setFirstname("Antoine");
        emp3.setEntryDate(LocalDate.of(2020, 1, 20));
        emp3.setJob("Technicien");
        emp3.setSalary(2800.0);
        emp3.setService("Maintenance");
        emp3.setAgence(agence1);

        Employe emp4 = new Employe();
        emp4.setName("Bernard");
        emp4.setFirstname("Claire");
        emp4.setEntryDate(LocalDate.of(2012, 11, 5));
        emp4.setJob("Chef de projet");
        emp4.setSalary(4500.0);
        emp4.setService("Projets");
        emp4.setAgence(agence2);

        Employe emp5 = new Employe();
        emp5.setName("Dubois");
        emp5.setFirstname("Julien");
        emp5.setEntryDate(LocalDate.of(2019, 9, 10));
        emp5.setJob("Analyste");
        emp5.setSalary(3200.0);
        emp5.setService("Business Intelligence");
        emp5.setAgence(agence1);

        List<Employe> employes = new ArrayList<>();
        employes.add(emp1);
        employes.add(emp2);
        employes.add(emp3);
        employes.add(emp4);
        employes.add(emp5);

        Directeur dir = new Directeur();
        dir.setName("Dupont");
        dir.setFirstname("Michel");
        dir.setEntryDate(LocalDate.of(2015, 9, 10));
        dir.setSalary(10000);


        //System.out.println(employes.size());

        //employes.sort(Comparator
                //.comparing(Employe::getService)
                //.thenComparing(Employe::getName)
                //.thenComparing(Employe::getFirstname));


        //for (Employe e : employes) {
           // System.out.println(e.getService() + " - " + e.getFirstname() + " " + e.getName());
       // }


        //double masseSalariale = EmployeService.calculMasseSalariale(employes);
        //System.out.println(masseSalariale);

        //EmployeService.checkModeRestauration(emp1);

        //EmployeService.checkChequeVacances(emp1);

        //EmployeService.checkChequeNoel(emp1);

        System.out.println(DirecteurService.calculPrime(dir));
    }


}