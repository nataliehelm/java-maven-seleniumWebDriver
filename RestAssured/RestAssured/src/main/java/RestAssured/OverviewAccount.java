package RestAssured;

import RestAssured.utils.UserInfo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class OverviewAccount {

    UserInfo user = new UserInfo();
    String URL = "https://parabank.parasoft.com/parabank/";

    String endpoint = URL + "services_proxy/bank/customers/" + user.getCustomerId() + "/accounts";

    Response response = given().auth().basic(user.getUsername(), user.getPassword()).when().get(endpoint);

    @Test
    public void test01() {

        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
    }

    @Test
    public void test02() {

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
