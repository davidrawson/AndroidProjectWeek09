package example.codeclan.com.playyourcardsright;

/**
 * Created by davidrawson on 26/01/2018.
 */

public enum Rank {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "11"),
    QUEEN(12, "12"),
    KING(13, "13"),
    ACE(14, "14");

    private final int value;
    private final String stringValue;

    Rank(int value, String stringValue){
        this.value = value;
        this.stringValue = stringValue;
    }

    public int getValue() {
        return this.value;
    }

    public String getStringValue(){
        return this.stringValue;
    }


}
