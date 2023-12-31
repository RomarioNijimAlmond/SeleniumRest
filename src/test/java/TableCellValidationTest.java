import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.w3choolstable.W3SchoolHtmlTablesPage;
import utils.Utils;

public class TableCellValidationTest extends BaseTest {
    W3SchoolHtmlTablesPage w3SchoolHtmlTablesPage;

    @BeforeMethod
    public void beforeMethod() {
        w3SchoolHtmlTablesPage = new W3SchoolHtmlTablesPage(driver);
    }

    @Test(description = "get the table cell value by using a function that accepts xpath")
    public void tc01_getTableCellValueByXpath() {
        String actual = w3SchoolHtmlTablesPage.getTableCellByXpath(4);
        String expected = "Austria";
        Assert.assertEquals(actual, expected);
    }

//    @Test
//    public void tc03_getTableCellValueByXpath() {
////        w3SchoolHtmlTablesPage.goTo(ApplicationUrl.W3SCHOOLS_WEB);
//        String actual = w3SchoolHtmlTablesPage.getTableCellByXpath(4, "Ernst Handel");
//        String expected = "Ernst Handel";
//        Assert.assertEquals(actual, expected);
//    }

    @Test(description = "get the table cell text in the same row as the searched for text")
    public void tc02_getTableCellText() {
        String text = "Island Trading";
        int searchColumn = 1;
        String actual = w3SchoolHtmlTablesPage.getTableCountryCellText(searchColumn, text, Utils.readProperty("columnName"));
        String expected = "UK";
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "verify tabel cell text by returning true or false")
    public void tc03_verifyTableCellText() {
        String text = "Ernst Handel";
        int searchColumn = 1;
        Boolean actual = w3SchoolHtmlTablesPage.validateTableCellValue(searchColumn, text, "Company");
        Boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "negative test to check that is returns false when searching for a non existing text")
    public void tc04_validateTextDoesNotExist() {
        String text = "none existing text";
        int searchColumn = 2;
        Boolean actual = w3SchoolHtmlTablesPage.validateTableCellValue(searchColumn, text, "Company");
        Boolean expected = false;
        Assert.assertEquals(actual, expected);
    }
}
