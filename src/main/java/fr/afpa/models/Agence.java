package fr.afpa.models;

import fr.afpa.constants.ModeRestauration;

public class Agence {
    private String name;
    private String adresse;
    private String codePostal;
    private String ville;
    private ModeRestauration modeRestauration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public ModeRestauration getModeRestauration() {
        return modeRestauration;
    }

    public void setModeRestauration(ModeRestauration modeRestauration) {
        this.modeRestauration = modeRestauration;
    }
}
