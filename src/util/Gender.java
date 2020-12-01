package util;

public enum Gender {
    UNKNOWN(0), MALE(1), FEMALE(2), NOT_APPLICABLE(9);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public static Gender valueOf(int value) {
        switch (value) {
            case 0:
                return UNKNOWN;
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            case 9:
                return NOT_APPLICABLE;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return value;
    }
}
