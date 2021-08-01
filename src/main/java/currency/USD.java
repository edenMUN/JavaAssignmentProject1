package currency;

public class USD extends Coin implements java.io.Serializable{

    private final double usdvalue = 3.52;

    @Override
    public double getValue() {
        return usdvalue;
    }

    @Override
    public double calculate(double useramount) {
        return useramount * getValue();
    }

    public double getUSDvalue() {
        return usdvalue;
    }

}
