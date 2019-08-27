import by.gsu.epamlab.beans.result.Result;
import by.gsu.epamlab.dao.IResultDAO;
import by.gsu.epamlab.dao.ResultImplCsv;
import by.gsu.epamlab.db.ResultsClear;
import by.gsu.epamlab.db.ResultsLoader;
import by.gsu.epamlab.db.ResultsSelect;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Runner1 {
    public static void main(String[] args) {
        IResultDAO resultDAO = null;
        List<Result> linkedResult = new LinkedList<>();
        try {
            resultDAO = new ResultImplCsv("results");
            ResultsClear.clearResults();
            ResultsLoader.loadResults(resultDAO);
            System.out.println("AVG Marks:");
            ResultsSelect.selectAvgMark();
            ResultsSelect.selectMonthNow(linkedResult);
            System.out.println("\nTests results for the current month:");
            for (Result linkTest : linkedResult) {
                System.out.println(linkTest);
            }
            System.out.println("\nLast Day - " + linkedResult.get(linkedResult.size() - 1));
        } catch (FileNotFoundException e) {
            System.err.println("File not found " + e.getMessage());
        }
    }
}

