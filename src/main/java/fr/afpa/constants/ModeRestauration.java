package fr.afpa.constants;

public enum ModeRestauration {
    RESTAURANT_ENTREPRISE,
    TICKETS_RESTAURANTS;

    @Override
    public String toString() {
        return switch (this) {
            case RESTAURANT_ENTREPRISE -> "Restaurant d'entreprise";
            case TICKETS_RESTAURANTS -> "Tickets restaurants";
            default -> name().toLowerCase().replace("_", " ");
        };
    }
    }
