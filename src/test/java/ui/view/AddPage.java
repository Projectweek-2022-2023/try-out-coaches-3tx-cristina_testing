package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPage extends Page {

    @FindBy(id="name")
    private WebElement nameField;

    @FindBy(id="type")
    private WebElement typeField;

    @FindBy(id="food")
    private WebElement foodField;

    @FindBy(id="submit")
    private WebElement submitButton;

    public AddPage (WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL+"add.jsp");
    }

    public void setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setType(String type) {
        typeField.clear();
        typeField.sendKeys(type);
    }

    public void setFood(String food) {
        foodField.clear();
        foodField.sendKeys(food);
    }

    public void add() {
        submitButton.click();
    }

    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public boolean hasStickyType (String type) {
        return type.equals(typeField.getAttribute("value"));
    }

    public boolean hasStickyFood (String food) {
        return food.equals(foodField.getAttribute("value"));
    }

    public boolean hasEmptyName () {
        return nameField.getAttribute("value").isEmpty();
    }

}
