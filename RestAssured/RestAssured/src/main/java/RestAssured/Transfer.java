package RestAssured;

import RestAssured.utils.UserInfo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Transfer {

    UserInfo user = new UserInfo();
    String URL = "https://parabank.parasoft.com/parabank/";

    String fromAccountId = "20226";
    String toAccountId = "20670";

    String endpoint = URL + "services_proxy/bank/transfer?fromAccountId=" + fromAccountId + "&toAccountId=" + toAccountId + "&amount=100";

    Response response = given().auth().basic(user.getUsername(), user.getPassword()).when().post(endpoint);

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
