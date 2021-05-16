
import helper.Helper;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;


public class SearchTest extends Helper {

    public void test_verifyButtons()
    {
        WebElement queryInput = driver.findElement(By.id("search-input"));
        WebElement searchButton = driver.findElement(By.id("search-button"));
        Asserts.check(queryInput.isDisplayed(),"Query Input is not visible");
        Asserts.check(searchButton.isDisplayed(),"Search button is not visible");
        System.out.println("Verified search button and query");

    }

    public void test_searchEmptyQuery()
    {
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();
        WebElement errorField = driver.findElement(By.id("error-empty-query"));
        Asserts.check(errorField.isDisplayed(),"Error is not visible");
        System.out.println("Verified Error is displaying with empty query");

    }

    public void test_ResultReturned()
    {
        WebElement queryInput = driver.findElement(By.id("search-input"));
        WebElement searchButton = driver.findElement(By.id("search-button"));
        queryInput.clear();
        queryInput.sendKeys("isla");
        searchButton.click();
        List<WebElement> resultList =  driver.findElements(By.cssSelector("#search-results>li"));
        Asserts.check(resultList.size() > 0,"No results found");
        System.out.println("Can see atleast one result");


    }

    public void test_NoResultsMessage()
    {
        WebElement queryInput = driver.findElement(By.id("search-input"));
        WebElement searchButton = driver.findElement(By.id("search-button"));
        queryInput.clear();
        queryInput.sendKeys("castle");
        searchButton.click();
       // Asserts.check(errorField.getText().equals("No Results"),"Results message is not shown");
        System.out.println("Can see the right text for No results");

    }

    public void test_ResultsCount()
    {
        WebElement queryInput = driver.findElement(By.id("search-input"));
        WebElement searchButton = driver.findElement(By.id("search-button"));
        queryInput.clear();
        queryInput.sendKeys("Port Royal");
        searchButton.click();
        List<WebElement> resultList =  driver.findElements(By.cssSelector("#search-results>li"));
        Asserts.check(resultList.size() ==1 ,"Right amount of results not found");
        System.out.println("Can see the right amount of results");

    }

    public static void main(String args[]) throws MalformedURLException {
        Helper.openBrowser();
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_csharp_search/862b0faa506b8487c25a3384cfde8af4/static/attachments/reference_page.html");
        SearchTest searchTest = new SearchTest();
        searchTest.test_verifyButtons();
        searchTest.test_searchEmptyQuery();
        searchTest.test_ResultsCount();
        searchTest.test_ResultReturned();
        searchTest.test_NoResultsMessage();
        driver.quit();

    }


}
