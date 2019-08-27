package by.gsu.epamlab.beans.mark;

public class DecimalMark extends Mark {

    public DecimalMark(double mark) {
        super((int) (mark * 10));
    }

    @Override
    public String toString() {
        return getMark() / 10 + "." + getMark() % 10;
    }
}
