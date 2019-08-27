package by.gsu.epamlab.factory;

import by.gsu.epamlab.beans.mark.DecimalMark;
import by.gsu.epamlab.beans.mark.HalfMark;
import by.gsu.epamlab.beans.mark.Mark;
import by.gsu.epamlab.beans.result.Result;
import by.gsu.epamlab.constants.Constant;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ResultFactory {
    private ResultFactory() {
    }

    public static Result getResultFromFactory(String login, String test, Date date, String markString) {
        Mark mark = null;

        Pattern p = Pattern.compile(Constant.STR_DECIMAL_MARH);
        Matcher m = p.matcher(markString);
        if (m.matches()) {
            mark = new DecimalMark(Double.parseDouble(markString));
        }

        p = Pattern.compile(Constant.STR_HALF_MARH);
        m = p.matcher(markString);
        if (m.matches()) {
            mark = new HalfMark(Double.parseDouble(markString));
        }

        p = Pattern.compile(Constant.STR_MARH);
        m = p.matcher(markString);
        if (m.matches()) {
            mark = new Mark(Integer.parseInt(markString));
        }
        return new Result(login, test, date, mark);

    }
}
