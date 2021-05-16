import com.sun.tools.javac.util.Assert;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SearchTest extends Helper {

    WebElement queryInput = driver.findElement(By.id("search-input"));
    WebElement searchButton = driver.findElement(By.id("search-button"));
    WebElement errorField = driver.findElement(By.id("error-empty-query"));
    List<WebElement> resultList =  driver.findElements(By.cssSelector("#search-results>li"));



    public void test_verifyButtons()
    {
        Assert.check(queryInput.isDisplayed(),"Query Input is not visible");
        Assert.check(searchButton.isDisplayed(),"Search button is not visible");
        System.out.println("Verified search button and query");

    }

    public void test_searchEmptyQuery()
    {
        searchButton.click();
        Assert.check(errorField.isDisplayed(),"Error is not visible");
        System.out.println("Verified Error is displaying with empty query");

    }

    public void test_ResultReturned()
    {
        queryInput.sendKeys("isla");
        searchButton.click();
        Assert.check(resultList.size() > 0,"No results found");
        System.out.println("Can see atleast one result");


    }

    public void test_NoResultsMessage()
    {
        queryInput.sendKeys("castle");
        searchButton.click();
        Assert.check(errorField.getText().equals("No Results"),"Results message is not shown");
        System.out.println("Can see the right text for No results");

    }

    public void test_ResultsCount()
    {
        queryInput.sendKeys("Port Royal");
        searchButton.click();
        Assert.check(resultList.size() ==1 ,"Right amount of results not found");
        System.out.println("Can see the right amount of results");

    }


}
