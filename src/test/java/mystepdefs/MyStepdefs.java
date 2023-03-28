package mystepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class MyStepdefs {
    private WebDriver driver;

    int time = 1000;

    @Given("user start a {string}")
    public void iStartA(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\selenium\\msedgedriver");
            driver = new EdgeDriver();

        }

    }


    @And("user navigate to {string}")
    public void iNavigateTo(String webSite) {
        driver.get(webSite);
        driver.manage().window().maximize();

    }


    @When("user have entered a vaild email, username and password")
    public void userHaveEnteredAVaildEmailUsernameAndPassword() throws InterruptedException {

        WebElement email = driver.findElement(By.id("email"));
        email.click();
        Thread.sleep(time);
        email.sendKeys("hello@hotmail.com");

        WebElement clickUsername = driver.findElement(By.id("new_username"));
        clickUsername.click();
        clickUsername.clear();

        WebElement username = driver.findElement(By.id("new_username"));
        username.click();
        Thread.sleep(time);
        username.sendKeys("hellohelllllo");


        WebElement password = driver.findElement(By.id("new_password"));
        password.click();
        Thread.sleep(time);
        password.sendKeys("A1s?pppp");
        Thread.sleep(time);

    }

    @Then("user can sign up")
    public void userCanSignUp() throws InterruptedException {
        WebElement signup = driver.findElement(By.id("create.account-enabled"));
        signup.click();
        Thread.sleep(time);
    }

    @After
    public void exit() {
        driver.close();
        driver.quit();

    }
}
