package by.gsu.epamlab.constants;

public class Constant {

    public static final String PATH_TO_RESOURCES = "src/resources/";
    public static final String EXT_CSV = ".csv";
    public static final String EXT_XML = ".xml";
    public static final int IDLOGEN_INDEX = 1;
    public static final int IDTEST_INDEX = 2;
    public static final int DATE_INDEX = 3;
    public static final int MARK_INDEX= 4;

    public static final String STR_MARH = "^[1-9]{1}$|^(10){1}$";
    public static final String STR_HALF_MARH = "^[0-9]{1}[.](5){1}$|^[0-9]$|^(1)[0-9]$|^(1)[0-9][.](5){1}$|^(20)$";
    public static final String STR_DECIMAL_MARH = "^[0-9]{1}[.][0-9]{1}$|^(10){1}[.](0){1}$";
    public static final String DEL_TABLE_LOGINS = "truncate logins";
    public static final String DEL_TABLE_RESULTS = "truncate results";
    public static final String DEL_TABLE_TESTS = "truncate tests";
    public static final String PS_INSERT_LOGIN = "INSERT INTO logins (name) VALUES (?)";
    public static final String PS_INSERT_TEST = "INSERT INTO tests (name) VALUES (?)";
    public static final String PS_SELECT_LOGIN = "SELECT idLogin AS id FROM logins WHERE name like ";
    public static final String PS_SELECT_TEST = "SELECT idTest AS id FROM tests WHERE name like ";
    public static final String INSERT_RESULT = "INSERT INTO results (loginId, testId, dat, mark) VALUES (?,?,?,?)";
    public static final String SELECT_AVG_MARKS = "select logins.name as name, cast(AVG(mark) as decimal(5,2)) as avgMark FROM results, logins where logins.idLogin=loginId group by `loginId` order by avgMark";
    public static final String SELECT_MONTH_NOW = "select logins.name as student, tests.name as test, dat,  mark from logins, tests, results where logins.idLogin=results.loginId and tests.idTest=results.testId\n" +
            "and  MONTH(results.dat) = MONTH(now()) order by dat";
}
