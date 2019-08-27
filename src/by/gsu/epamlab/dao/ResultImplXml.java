package by.gsu.epamlab.dao;

import by.gsu.epamlab.beans.result.Result;
import by.gsu.epamlab.parsers.SaxHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static by.gsu.epamlab.constants.Constant.*;

public class ResultImplXml implements IResultDAO {
    private List<Result> resultList;
    private final Iterator<Result> resultIterator;

    public ResultImplXml(String results) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        SaxHandler saxHandler = new SaxHandler();
        saxParser.parse(new File(PATH_TO_RESOURCES + results + EXT_XML), saxHandler);
        resultList = saxHandler.getResults();
        resultIterator = resultList.iterator();
    }

    @Override
    public Result nextResult() {
        return resultIterator.next();
    }

    @Override
    public boolean hasResult() {
        return resultIterator.hasNext();
    }

    @Override
    public void closeReader() {
        resultList = null;
    }
}
