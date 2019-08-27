package by.gsu.epamlab.dao;

import by.gsu.epamlab.beans.result.Result;
import by.gsu.epamlab.dao.IResultDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import static by.gsu.epamlab.constants.Constant.EXT_CSV;
import static by.gsu.epamlab.constants.Constant.PATH_TO_RESOURCES;
import static by.gsu.epamlab.factory.ResultFactory.getResultFromFactory;

public class ResultImplCsv implements IResultDAO {
    private static final int ID_STUDENT = 0;
    private static final int ID_TEST = 1;
    private static final int ID_DATE = 2;
    private static final int ID_MARK = 3;
    private Scanner csvFile;
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public ResultImplCsv(String results) throws FileNotFoundException {
        csvFile = new Scanner(new File(PATH_TO_RESOURCES + results + EXT_CSV));
    }

    @Override
    public Result nextResult() throws ParseException {
        String[] values = csvFile.nextLine().split(";");
        return getResultFromFactory(values[ID_STUDENT], values[ID_TEST], format.parse(values[ID_DATE]), values[ID_MARK]);
    }

    @Override
    public boolean hasResult() {
        return csvFile.hasNextLine();
    }

    @Override
    public void closeReader() {
        csvFile.close();
    }
}
