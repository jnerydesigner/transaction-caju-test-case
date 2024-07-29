package br.com.jandernery.transaction_caju.application.enums;

public enum BalanceType {
    FOOD,
    MEAL,
    CASH;

    public static BalanceType fromMcc(String mcc){
        switch (mcc){
            case "5411":
            case "5412":
                return FOOD;
            case "5811":
            case "5812":
                return MEAL;
            default:
                return CASH;
        }
    }
}
