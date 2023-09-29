package practiceReqres;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetUsersUsingQueryParam {

	@Test
	public static void main(String[] args) {

		baseURI = "https://reqres.in";
		
			Response resp = given().queryParam("page", 2) 
							.when().get("/api/users");
			
			resp.then().assertThat().statusCode(200).log().all();
			
	}
}