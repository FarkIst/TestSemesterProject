package mappers;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import units.User;

public class UserPersistence {
    protected UserMapper userMapper = new UserMapper("test");

    @When("^I ask to create a new User$")
    public void iAskToCreateANewUser() throws Throwable {

        User user = new User();
        userMapper.createEntity(user);
    }

    @Then("^A new User should be created in the Database$")
    public void aNewUserShouldBeCreatedInTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to read an existing User$")
    public void iAskToReadAnExistingUser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
