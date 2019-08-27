package by.gsu.epamlab.parsers;

import by.gsu.epamlab.beans.mark.DecimalMark;
import by.gsu.epamlab.beans.result.Result;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {
    private List<Result> resultsList;
    private Result result;
    private String login;
    private String loginValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (TagNames.valueOf(qName.toUpperCase())) {
            case RESULTS:
                resultsList = new ArrayList<>();
                break;
            case STUDENT:
                break;
            case LOGIN:
                break;
            case TESTS:
                break;
            case TEST:
                result = new Result();
                try {
                    result.setLogin(loginValue);
                    result.setTest(attributes.getValue("name"));
                    result.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(attributes.getValue("date")));
                    result.setMark(new DecimalMark(Double.parseDouble(attributes.getValue("mark"))));
                } catch (ParseException e) {
                    System.err.println("Error read line xml " + e.getMessage());
                }
                break;
            default:
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (TagNames.valueOf(qName.toUpperCase())) {
            case RESULTS:
                break;
            case STUDENT:
                break;
            case LOGIN:
                loginValue = login;
                break;
            case TESTS:
                break;
            case TEST:
                resultsList.add(result);
                break;
            default:
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        login = new String(ch, start, length);
    }

    public List<Result> getResults() {
        return resultsList;
    }

    private enum TagNames {
        RESULTS,
        STUDENT,
        LOGIN,
        TESTS,
        TEST
    }
}