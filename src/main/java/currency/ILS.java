package currency;

public class ILS extends Coin implements java.io.Serializable{

    private final double ILSvalue = 0.28;

    @Override
    public double getValue() {
        return ILSvalue;
    }

    @Override
    public double calculate(double useramount) {
        return useramount * getValue();
    }

    public double getILSvalue() {
        return ILSvalue;
    }

}
