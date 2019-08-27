package by.gsu.epamlab.dao;

import by.gsu.epamlab.beans.result.Result;

import java.text.ParseException;

public interface IResultDAO { //аббревиатура от Data Access Object
    Result nextResult() throws ParseException;

    boolean hasResult();

    void closeReader();
    //возможно, будут еще методы.
    //Выяснится в процессе написания метода загрузки.

}

