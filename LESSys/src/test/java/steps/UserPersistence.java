package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mappers.UserMapper;
import org.junit.Assert;
import units.*;

public class UserPersistence {
    private UserMapper userMapper = new UserMapper("test");

    private Student testSUser = (Student) UserFactory.createUser(Role.S);

    @When("^I ask to create a new Student$")
    public void iAskToCreateANewStudent() {
        Student student = (Student) UserFactory.createUser(Role.S);
        testSUser = (Student) userMapper.createEntity(student);
    }

    @Then("^A new Student should be created in the Database$")
    public void aNewStudentShouldBeCreatedInTheDatabase() {
        Student studentUser = (Student) userMapper.readEntity(testSUser.getId());
        Assert.assertEquals( testSUser.getId(), studentUser.getId() );
    }

    private TeachingStaff testTSUser = (TeachingStaff) UserFactory.createUser(Role.TS);

    @When("^I ask to create a new TeachingStaff$")
    public void iAskToCreateANewTeachingStaff(){
        TeachingStaff teachingStaff = (TeachingStaff) UserFactory.createUser(Role.TS);
        testTSUser = (TeachingStaff) userMapper.createEntity(teachingStaff);
    }

    @Then("^A new TeachingStaff should be created in the Database$")
    public void aNewTeachingStaffShouldBeCreatedInTheDatabase() {
        TeachingStaff teachingStaffUser = (TeachingStaff) userMapper.readEntity(testTSUser.getId());
        Assert.assertEquals( testTSUser.getId(), teachingStaffUser.getId() );
    }

    private NonTeachingStaff testNTSUser = (NonTeachingStaff) UserFactory.createUser(Role.NTS);

    @When("^I ask to create a new NonTeachingStaff$")
    public void iAskToCreateANewNonTeachingStaff() {
        NonTeachingStaff nonTeachingStaff = (NonTeachingStaff) UserFactory.createUser(Role.NTS);
        testNTSUser = (NonTeachingStaff) userMapper.createEntity(nonTeachingStaff);
    }

    @Then("^A new NonTeachingStaff should be created in the Database$")
    public void aNewNonTeachingStaffShouldBeCreatedInTheDatabase() {
        NonTeachingStaff nonTeachingStaffUser = (NonTeachingStaff) userMapper.readEntity(testNTSUser.getId());
        Assert.assertEquals( testNTSUser.getId(), nonTeachingStaffUser.getId() );
    }

    private TeachingStaff readableTS;

    @When("^I ask to read an existing TeachingStaff$")
    public void iAskToReadAnExistingTeachingStaff() throws Throwable {
        readableTS = (TeachingStaff) userMapper.readEntity(4447);
    }

    @Given("^That a TeachingStaff of requested ID exists$")
    public void thatATeachingStaffOfRequestedIDExists() {
        Assert.assertNotNull(readableTS);
    }

    @Then("^The specified TeachingStaff should be returned from the Database$")
    public void theSpecifiedTeachingStaffShouldBeReturnedFromTheDatabase() {
        Assert.assertEquals(4447, readableTS.getId());
    }

    private NonTeachingStaff readableNTS;

    @When("^I ask to read an existing NonTeachingStaff$")
    public void iAskToReadAnExistingNonTeachingStaff() {
         readableNTS = (NonTeachingStaff) userMapper.readEntity(4446);
    }

    @Given("^That a NonTeachingStaff of requested ID exists$")
    public void thatANonTeachingStaffOfRequestedIDExists() {
        Assert.assertNotNull(readableNTS);
    }

    @Then("^The specified NonTeachingStaff should be returned from the Database$")
    public void theSpecifiedNonTeachingStaffShouldBeReturnedFromTheDatabase() throws Throwable {
        Assert.assertEquals(4446, readableNTS.getId());
    }

    private Student readableS;

    @When("^I ask to read an existing Student$")
    public void iAskToReadAnExistingStudent() {
        readableS = (Student) userMapper.readEntity(4541);
    }

    @Given("^That a Student of requested ID exists$")
    public void thatAStudentOfRequestedIDExists() {
        Assert.assertNotNull(readableS);
    }

    @Then("^The specified Student should be returned from the Database$")
    public void theSpecifiedStudentShouldBeReturnedFromTheDatabase() {
        Assert.assertEquals(4541, readableS.getId());
    }

    private Student editStudent;
    private Student newStudent;
    @When("^I ask to update an existing Student$")
    public void iAskToUpdateAnExistingStudent() {
        editStudent = (Student) UserFactory.createUser(Role.S);
        editStudent.setName("Monkey Jones");
        newStudent = (Student) userMapper.createEntity(editStudent);
        newStudent.setName("Sheman");
        userMapper.editEntity(newStudent);
    }

    @Given("^That a Student of the same ID exists$")
    public void thatAStudentOfTheSameIDExists() {
        Assert.assertNotNull(userMapper.readEntity(newStudent.getId()));
    }

    @Then("^The specified Student should be updated in the Database$")
    public void theSpecifiedStudentShouldBeUpdatedInTheDatabase() {
        Student student = (Student) userMapper.readEntity(newStudent.getId());
        Assert.assertEquals("Sheman", student.getName());
    }

    private TeachingStaff editTS;
    private TeachingStaff newTS;
    @When("^I ask to update an existing TeachingStaff$")
    public void iAskToUpdateAnExistingTeachingStaff() {
        editTS = (TeachingStaff) UserFactory.createUser(Role.TS);
        editTS.setName("Monkey Jones");
        newTS = (TeachingStaff) userMapper.createEntity(editTS);
        newTS.setName("Sheman");
        userMapper.editEntity(newTS);
    }

    @Given("^That a TeachingStaff of the same ID exists$")
    public void thatATeachingStaffOfTheSameIDExists() {
        Assert.assertNotNull(userMapper.readEntity(newTS.getId()));
    }

    @Then("^The specified TeachingStaff should be updated in the Database$")
    public void theSpecifiedTeachingStaffShouldBeUpdatedInTheDatabase() {
        TeachingStaff teachingStaff = (TeachingStaff) userMapper.readEntity(newTS.getId());
        Assert.assertEquals("Sheman", teachingStaff.getName());
    }

    private NonTeachingStaff editNTS;
    private NonTeachingStaff newNTS;
    @When("^I ask to update an existing NonTeachingStaff$")
    public void iAskToUpdateAnExistingNonTeachingStaff() {
        editNTS = (NonTeachingStaff) UserFactory.createUser(Role.NTS);
        editNTS.setName("Monkey Jones");
        newNTS = (NonTeachingStaff) userMapper.createEntity(editNTS);
        newNTS.setName("Sheman");
        userMapper.editEntity(newNTS);
    }

    @Given("^That a NonTeachingStaff of the same ID exists$")
    public void thatANonTeachingStaffOfTheSameIDExists() {
        Assert.assertNotNull(userMapper.readEntity(newNTS.getId()));
    }

    @Then("^The specified NonTeachingStaff should be updated in the Database$")
    public void theSpecifiedNonTeachingStaffShouldBeUpdatedInTheDatabase() {
        NonTeachingStaff nonTeachingStaff = (NonTeachingStaff) userMapper.readEntity(newNTS.getId());
        Assert.assertEquals("Sheman", nonTeachingStaff.getName());
    }

    private Student delStud;

    @When("^I ask to delete an existing Student$")
    public void iAskToDeleteAnExistingStudent() {
        Student myS = (Student) UserFactory.createUser(Role.S);
        delStud = (Student) userMapper.createEntity(myS);
    }

    @Given("^That a Student of the specified ID exists$")
    public void thatAStudentOfTheSpecifiedIDExists() {
        Assert.assertNotNull(userMapper.readEntity(delStud.getId()));
    }

    @Then("^The specified Student should be deleted from Database$")
    public void theSpecifiedStudentShouldBeDeletedFromDatabase() {
        userMapper.deleteEntity(delStud.getId());
        Assert.assertNull(userMapper.readEntity(delStud.getId()));
    }

    private TeachingStaff delTS;

    @When("^I ask to delete an existing TeachingStaff$")
    public void iAskToDeleteAnExistingTeachingStaff() {
        TeachingStaff myTS = (TeachingStaff) UserFactory.createUser(Role.TS);
        delTS = (TeachingStaff) userMapper.createEntity(myTS);
    }

    @Given("^That a TeachingStaff of the specified ID exists$")
    public void thatATeachingStaffOfTheSpecifiedIDExists() {
        Assert.assertNotNull(userMapper.readEntity(delTS.getId()));
    }

    @Then("^The specified TeachingStaff should be deleted from Database$")
    public void theSpecifiedTeachingStaffShouldBeDeletedFromDatabase() {
        userMapper.deleteEntity(delTS.getId());
        Assert.assertNull(userMapper.readEntity(delTS.getId()));
    }

    private NonTeachingStaff delNTS;

    @When("^I ask to delete an existing NonTeachingStaff$")
    public void iAskToDeleteAnExistingNonTeachingStaff() {
        NonTeachingStaff myNTS = (NonTeachingStaff) UserFactory.createUser(Role.NTS);
        delNTS = (NonTeachingStaff) userMapper.createEntity(myNTS);
    }

    @Given("^That a NonTeachingStaff of the specified ID exists$")
    public void thatANonTeachingStaffOfTheSpecifiedIDExists() {
        Assert.assertNotNull(userMapper.readEntity(delNTS.getId()));
    }

    @Then("^The specified NonTeachingStaff should be deleted from Database$")
    public void theSpecifiedNonTeachingStaffShouldBeDeletedFromDatabase() throws Throwable {
        userMapper.deleteEntity(delNTS.getId());
        Assert.assertNull(userMapper.readEntity(delNTS.getId()));
    }

}
