package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(name = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[text()='Epic sadface: Sorry, this user has been locked out.']")
    private WebDriver lockedUserErrorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ProductsPage login(String username, String password){
        userNameInput.clear();
        userNameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginButton.click();

        return new ProductsPage(driver);
    }
}


