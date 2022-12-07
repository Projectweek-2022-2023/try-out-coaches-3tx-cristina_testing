package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import ui.view.AddPage;
import ui.view.DriverHelper;
import ui.view.OverviewPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddAnimalSteps {
    private AddPage addPage;

    private String randomName = "TestAnimal" + (int) (Math.random() * 1000000);
    private String randomType = "TestType" + (int) (Math.random() * 1000000);

    @Given("{word} is at the add animal page")
    public void userIsAtTheAddAnimalPage(String user) {
        addPage = PageFactory.initElements(DriverHelper.getDriver(), AddPage.class);
    }

    @When("{word} adds animal with food equal to {int}")
    public void userAddsAnAnimalWithAFoodEqualTo(String user, int foodAmount) {
        addPage.setName(randomName);
        addPage.setType(randomType);
        addPage.setFood(String.valueOf(foodAmount));
        addPage.add();
    }

    @Then("The animal should be added to the overview of animals")
    public void theAnimalShouldBeAddedToTheOverviewOfAnimals() {
        OverviewPage overviewPage = PageFactory.initElements(DriverHelper.getDriver(), OverviewPage.class);
        assertTrue(overviewPage.containsAnimalWithName(randomName));
    }

    @Then("The animal should not be added to the overview of animals")
    public void theAnimalShouldNotBeAddedToTheOverviewOfAnimals() {
        OverviewPage overviewPage = PageFactory.initElements(DriverHelper.getDriver(), OverviewPage.class);
        assertFalse(overviewPage.containsAnimalWithName(randomName));
    }

    @After
    public void clean() {
        DriverHelper.quitDriver();
    }
}
