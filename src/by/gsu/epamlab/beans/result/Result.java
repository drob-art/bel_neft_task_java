package by.gsu.epamlab.beans.result;

import by.gsu.epamlab.beans.mark.Mark;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
    private String login;
    private String test;
    private Date date;
    private Mark mark;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");


    public Result() {
    }

    public Result(String login, String test, Date date, Mark mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark.getMark();
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return login + ";" + test + ";" + dateFormat.format(date) + ";" + mark;
    }
}
