import by.gsu.epamlab.beans.result.Result;
import by.gsu.epamlab.dao.IResultDAO;
import by.gsu.epamlab.dao.ResultImplXml;
import by.gsu.epamlab.db.ResultsClear;
import by.gsu.epamlab.db.ResultsLoader;
import by.gsu.epamlab.db.ResultsSelect;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Runner2 {
    public static void main(String[] args) {
        List<Result> linkedResult = new LinkedList<>();
        try {
            IResultDAO resultDAO = new ResultImplXml("results");
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

        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println("Read file error " + e.getMessage());
        }

    }
}
