package practiceReqres;
import static io.restassured.RestAssured.*;


public class DeleteUserUsingPathParam {

	public static void main(String[] args) {

		baseURI = "https://reqres.in";

		
		given().pathParam("userId", 2)
		.when().delete("/api/users/{userId}")
		.then().assertThat().statusCode(204).log().all();
	}

}
