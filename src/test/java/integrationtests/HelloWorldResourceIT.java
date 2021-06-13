package integrationtests;

import integrationtests.base.BaseIntegrationTest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.HttpStatus.OK;

class HelloWorldResourceIT extends BaseIntegrationTest {

    @Test
    @DisplayName("Must get hello world message successfully")
    void getHelloWorldMessage200() {
        String expected = getExpectedResponse("get_hello_world_message_success");
        ValidatableResponse response  = given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .get(getRequestPath("/hello?name=claudivan"))
                .then();
        response.statusCode(OK.value()).body(equalTo(expected));
    }
}
