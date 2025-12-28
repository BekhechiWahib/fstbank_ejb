package fstbank_ejb.services.strategy_access;

public class AccessStrategyFactory {

    public static IAccessStrategy getStrategy(Client client) {
        switch (client.getType()) {
            case PARTICULIER:
                return new AccessParticulierStrategy();
            case PROFESSIONNEL:
                return new AccessProfessionnelStrategy();
            default:
                throw new IllegalArgumentException();
        }
    }
}
