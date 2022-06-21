package in.co.gorest.usersinfo;

import in.co.gorest.constants.EndPoints;
import in.co.gorest.model.UsersPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UsersSteps {

    @Step("Get List Of Users")
    public ValidatableResponse getListOfUsers() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 57c4fad1064029dd06a46f13e636994a133c8f90239026665b53365529904944")
                .when()
                .get(EndPoints.GET_ALL_USERS)
                .then();

    }

    @Step("Create User with name:{0},gender:{1},email:{2},status:{4}")
    public ValidatableResponse createUser(String name, String gender, String email, String status) {

        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName(name);
        usersPojo.setGender(gender);
        usersPojo.setEmail(email);
        usersPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 57c4fad1064029dd06a46f13e636994a133c8f90239026665b53365529904944")
                .body(usersPojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then();

    }

    @Step("Update User with Id{0},name:{1},gender:{2},email:{3},status:{4}")
    public ValidatableResponse updateUser(int id, String name, String gender, String email, String status) {

        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName(name);
        usersPojo.setGender(gender);
        usersPojo.setEmail(email);
        usersPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 57c4fad1064029dd06a46f13e636994a133c8f90239026665b53365529904944")
                .body(usersPojo)
                .pathParam("id", id)
                .when()
                .patch(EndPoints.UPDATE_USER_BY_ID)
                .then();

    }

    @Step("Delete User With Id:{0}")
    public ValidatableResponse deleteUserById(int id) {

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 57c4fad1064029dd06a46f13e636994a133c8f90239026665b53365529904944")
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }
}