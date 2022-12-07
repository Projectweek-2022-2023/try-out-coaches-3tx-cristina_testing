package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import ui.view.AddPage;
import ui.view.DriverHelper;
import ui.view.OverviewPage;

import static org.junit.Assert.assertTrue;

public class AddAnimalUISteps {
    private AddPage addPage;
    private String randomName = "TestAnimal" + (int) (Math.random() * 1000000);
    private String randomType = "TestType" + (int) (Math.random() * 1000000);

    @Given("{word} has chosen to add a new animal")
    public void user_has_chosen_to_add_a_new_animal(String user) {
        addPage = PageFactory.initElements(DriverHelper.getDriver(), AddPage.class);
    }

    @When("{word} registers {int} as the amount of food")
    public void user_registers_as_the_amount_of_food(String user, Integer amount) {
        addPage.setName(randomName);
        addPage.setType(randomType);
        addPage.setFood(String.valueOf(amount));
        addPage.add();
    }

    @Then("the animal should be added to the overview of animals")
    public void the_animal_should_be_added_to_the_overview_of_animals() {
        OverviewPage overviewPage = PageFactory.initElements(DriverHelper.getDriver(), OverviewPage.class);
        assertTrue(overviewPage.containsAnimalWithName(randomName));
    }

    @Then("an error message should be shown")
    public void an_error_message_should_be_shown() {


    }

    @After
    public void clean() {
        DriverHelper.quitDriver();
    }
}
