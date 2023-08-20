package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.GoogleHomepage;

import static utils.DayNumber.getDayNumber;
import static utils.ReadExcel.getData;
import static utils.StringComparison.findShortestAndLongestLine;
import static utils.WriteExcel.excelWriter;

public class TestSearch extends BaseTest {
    @Test
    public void Search() throws InterruptedException {

        GoogleHomepage homepage = new GoogleHomepage();
        Assert.assertTrue(homepage.waitForDisplayed(), "Homepage has not been displayed!");
        String[][] data = getData("src\\main\\resources\\data.xlsx", getDayNumber());
        int row = 2;
        int longestOption = 3;
        int shortestOption = 4;
        for (String[] searchData : data) {
            homepage.SearchKeyword(searchData[2]);
            Thread.sleep(1000);
            String searchResultSuggestions = homepage.getSearchResultSuggestions();
            String[] shortestAndLongest = findShortestAndLongestLine(searchResultSuggestions);
            excelWriter(shortestAndLongest[1], getDayNumber(), longestOption, row);
            excelWriter(shortestAndLongest[0], getDayNumber(), shortestOption, row);
            row++;
        }
    }
}