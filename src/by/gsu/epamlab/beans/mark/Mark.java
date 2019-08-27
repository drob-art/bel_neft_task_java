package by.gsu.epamlab.beans.mark;

public class Mark {
    private int mark;

    public Mark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        if (mark / 10 == 0) {
            return mark + "";
        }
        if (mark % 10 == 0) {
            return mark / 10 + "";
        }
        return mark / 10 + "." + mark % 10;
    }
}
