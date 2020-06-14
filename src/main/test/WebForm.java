import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{

    private final String mail = "Email";
    private final String passwordUpdate = "Password";
    private final String passwordRepeat="Password Repeat";
    private final String mailLogin = "minhmom98@gmail.com";
    private final String passwordLogin = "123456";

    private final String name = "Tran Nhat Minh";
    private final String household = "Ha Noi";
    private final String address = "So 35 to 3 Hoan Kiem Ha Noi";
    private final String salary = "20000000";
    private final String idPerson = "198234567";
    private final String phone = "0364398123";
    private final String ethnic = "Kinh";
    private final String gender = "Nữ";
    private final String cityID = "01 - Hà Nội";
    private final String dobDay = "23";
    private final String dobMonth = "10";
    private final String dobYear = "1998";
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-repeat")
    private WebElement passwordrepeat;

    @FindBy(xpath = "//input[@class='registerbtn']")
    private WebElement submit_button;

    @FindBy(xpath = "//div[contains(text(),'The form was successfully submitted!')]")
    private WebElement alertSuccess;


    @FindBy(xpath = "//input[@class='logbtn']")
    private WebElement login_button;

    @FindBy(xpath = "//input[@id='submit']")
    private WebElement declare_button;

    @FindBy(id = "name")
    private WebElement tname;

    @FindBy(id = "home-address")
    private WebElement thousehold;

    @FindBy(id = "address")
    private WebElement taddress;

    @FindBy(id = "salary")
    private WebElement tsalary;

    @FindBy(id = "idPerson")
    private WebElement idPersonal;

    @FindBy(id = "phone")
    private WebElement tphone;

    @FindBy(id = "ethnic")
    private WebElement tethnic;

    @FindBy(id = "gender")
    private WebElement tgender;

    @FindBy(id = "cityID")
    private WebElement tcityID;

    @FindBy(id = "dob-day")
    private WebElement tday;

    @FindBy(id = "dob-month")
    private WebElement tmonth;

    @FindBy(id = "dob-year")
    private WebElement tyear;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(){
        this.email.sendKeys(mail);
    }

    public void enterPasswordRepeat()
    {
        this.passwordrepeat.sendKeys(passwordRepeat);
    }

    public void enterLastName(){
        this.password.sendKeys(passwordUpdate);
    }

    public void enterEmailLogin()
    {
        this.email.sendKeys(mailLogin);
    }

    public void enterPasswordLogin()
    {
        this.password.sendKeys(passwordLogin);
    }

    public void enterName()
    {
        this.tname.sendKeys(name);
    }

    public void enterHousehold()
    {
        this.thousehold.sendKeys(household);
    }

    public void enterAddress()
    {
        this.taddress.sendKeys(address);
    }
    public void enterSalary()
    {
        this.tsalary.sendKeys(salary);
    }

    public void enterID()
    {
        this.idPersonal.sendKeys(idPerson);
    }

    public void enterGender()
    {
        this.tgender.sendKeys(gender);
    }

    public void enterPhone()
    {
        this.tphone.sendKeys(phone);
    }

    public void enterEthnic()
    {
        this.tethnic.sendKeys(ethnic);
    }

    public void enterCityID()
    {
        this.tcityID.sendKeys(cityID);
    }

    public void enterDay()
    {
        this.tday.sendKeys(dobDay);
    }

    public void enterMonth()
    {
        this.tmonth.sendKeys(dobMonth);
    }

    public void enterYear()
    {
        this.tyear.sendKeys(dobYear);
    }


    public void verifyAlertSuccess(){
        this.alertSuccess.isDisplayed();
    }

    public void loginButton()
    {
        this.login_button.click();
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void declareButton()
    {
        this.declare_button.click();
    }

}