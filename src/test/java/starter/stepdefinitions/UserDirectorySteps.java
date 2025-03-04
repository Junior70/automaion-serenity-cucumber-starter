package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.assertj.core.api.SoftAssertions;
import starter.model.DirectoryUser;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDirectorySteps {
    @Given("Dirk s a Directory Administratos")
    public void dirkSADirectoryAdministratos() {
    }

    @When("he asks for the available user using the default search configuration")
    public void heAsksForTheAvailableUserUsingTheDefaultSearchConfiguration() {
        SerenityRest.get("https://reqres.in/api/users")
                .then()
                .statusCode(200);
    }

    @Then("he should be presented with the nfollowing results:")
    public void heShouldBePresentedWithTheNfollowingResults(Map<String, Integer> resultSummary) {
        SoftAssertions.assertSoftly(softy -> {
            for (String field : resultSummary.keySet()) {
                int expected = resultSummary.get(field);
                int actual = SerenityRest.lastResponse().jsonPath().getInt(field);
                softy.assertThat(actual).isEqualTo(expected);
            }
        });
    }

    @DataTableType
    public DirectoryUser directoryUser(Map<String, String> fields) {
        return new DirectoryUser(
                Integer.parseInt(fields.get("id")),
                fields.get("email"),
                fields.get("first_name"),
                fields.get("last_name"),
                fields.get("avatar")
        );
    }

    @And("the matching users should include the following")
    public void theMatchingUsersShouldIncludeTheFollowing(List<DirectoryUser> expectedUsers) {
        List<DirectoryUser> actualUsers = SerenityRest.lastResponse().jsonPath().getList("data", DirectoryUser.class);
        assertThat(actualUsers).containsAll(expectedUsers);
    }
}
