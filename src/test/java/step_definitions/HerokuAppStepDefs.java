package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HerokuAppStepDefs {

    WebDriver driver;
    @Given("User is on The Internet home page")
    public void user_is_on_the_internet_home_page() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @When("User clicks on add element button {string} times")
    public void userClicksOnAddElementButtonTimes(String n) {

        for(int i =0; i<Integer.parseInt(n); i++){

            driver.findElement(By.xpath("//button[.='Add Element']")).click();
        }
    }

    @Then("{string} times elements exists on page")
    public void times_elements_exists_on_page(String n) {

        List<WebElement> elements = driver.findElements(By.xpath("//button[@class='added-manually']"));

        Assert.assertEquals(elements.size(), Integer.parseInt(n));

        System.out.println(elements.size());


    }


}
