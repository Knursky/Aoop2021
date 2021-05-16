package wsb;


public class SuperNumber<x extends Number> {


    x obj;

    public SuperNumber(x obj) {
        this.obj = obj;
    }

    void printType() {
        System.out.println(this.obj.getClass().getName());
    }

    double toDouble() {
        return obj.doubleValue();
    }

    int toInteger() {
        return obj.intValue();
    }

    boolean isIntegerEqualsDoubleValue() {
        return this.toDouble() == this.toInteger();
    }

    boolean compareInteger(SuperNumber other) {
        return toInteger() == other.toInteger();
    }

    boolean compareDouble(SuperNumber other) {
        return this.toDouble() == other.toDouble();
    }
}