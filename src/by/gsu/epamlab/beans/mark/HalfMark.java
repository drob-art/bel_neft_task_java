package by.gsu.epamlab.beans.mark;

public class HalfMark extends Mark {
    public HalfMark(double mark) {
        super((int) (mark * 10));
    }


    public String toString() {
        if (getMark() % 10 == 0) {
            return getMark() / 10 + "";
        }
        return getMark() / 10 + "." + getMark() % 10;
    }
}
