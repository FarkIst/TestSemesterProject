package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mappers.UserMapper;
import org.junit.Assert;
import units.Role;
import units.Student;
import units.User;
import units.UserFactory;

public class UserPersistence {
    private UserMapper userMapper = new UserMapper("test");

    private User testUser = new User();
    @When("^I ask to create a new Student$")
    public void iAskToCreateANewStudent() {
        Student student = new Student();
        testUser = userMapper.createEntity(student);
    }

    @Then("^A new Student should be created in the Database$")
    public void aNewStudentShouldBeCreatedInTheDatabase() {
        //Student newStudent = UserFactory.createUser(Role.S);
        //Student studentUser = userMapper.readEntity(testUser.getId());
        //Assert.assertEquals(studentUser.getId(), studentUser.getId());
        //Assert.assertEquals("S", studentUser.getType());
    }

    @When("^I ask to create a new TeachingStaff$")
    public void iAskToCreateANewTeachingStaff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^A new TeachingStaff should be created in the Database$")
    public void aNewTeachingStaffShouldBeCreatedInTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to create a new NonTeachingStaff$")
    public void iAskToCreateANewNonTeachingStaff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^A new NonTeachingStaff should be created in the Database$")
    public void aNewNonTeachingStaffShouldBeCreatedInTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to read an existing TeachingStaff$")
    public void iAskToReadAnExistingTeachingStaff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a TeachingStaff of requested ID exists$")
    public void thatATeachingStaffOfRequestedIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified TeachingStaff should be returned from the Database$")
    public void theSpecifiedTeachingStaffShouldBeReturnedFromTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to read an existing NonTeachingStaff$")
    public void iAskToReadAnExistingNonTeachingStaff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a NonTeachingStaff of requested ID exists$")
    public void thatANonTeachingStaffOfRequestedIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified NonTeachingStaff should be returned from the Database$")
    public void theSpecifiedNonTeachingStaffShouldBeReturnedFromTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to read an existing Student$")
    public void iAskToReadAnExistingStudent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a Student of requested ID exists$")
    public void thatAStudentOfRequestedIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified Student should be returned from the Database$")
    public void theSpecifiedStudentShouldBeReturnedFromTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to update an existing Student$")
    public void iAskToUpdateAnExistingStudent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a Student of the same ID exists$")
    public void thatAStudentOfTheSameIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified Student should be updated in the Database$")
    public void theSpecifiedStudentShouldBeUpdatedInTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to update an existing TeachingStaff$")
    public void iAskToUpdateAnExistingTeachingStaff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a TeachingStaff of the same ID exists$")
    public void thatATeachingStaffOfTheSameIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified TeachingStaff should be updated in the Database$")
    public void theSpecifiedTeachingStaffShouldBeUpdatedInTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to update an existing NonTeachingStaff$")
    public void iAskToUpdateAnExistingNonTeachingStaff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a NonTeachingStaff of the same ID exists$")
    public void thatANonTeachingStaffOfTheSameIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified NonTeachingStaff should be updated in the Database$")
    public void theSpecifiedNonTeachingStaffShouldBeUpdatedInTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to delete an existing Student$")
    public void iAskToDeleteAnExistingStudent() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a Student of the specified ID exists$")
    public void thatAStudentOfTheSpecifiedIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified Student should be deleted from Database$")
    public void theSpecifiedStudentShouldBeDeletedFromDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to delete an existing TeachingStaff$")
    public void iAskToDeleteAnExistingTeachingStaff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a TeachingStaff of the specified ID exists$")
    public void thatATeachingStaffOfTheSpecifiedIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified TeachingStaff should be deleted from Database$")
    public void theSpecifiedTeachingStaffShouldBeDeletedFromDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I ask to delete an existing NonTeachingStaff$")
    public void iAskToDeleteAnExistingNonTeachingStaff() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^That a NonTeachingStaff of the specified ID exists$")
    public void thatANonTeachingStaffOfTheSpecifiedIDExists() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^The specified NonTeachingStaff should be deleted from Database$")
    public void theSpecifiedNonTeachingStaffShouldBeDeletedFromDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
