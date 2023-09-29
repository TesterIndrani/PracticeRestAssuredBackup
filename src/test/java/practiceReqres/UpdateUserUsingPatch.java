package practiceReqres;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class UpdateUserUsingPatch {

	public static void main(String[] args) {
		baseURI = "https://reqres.in";
		
		JSONObject obj = new JSONObject();
		obj.put("job", "fireman");
		
		given().body(obj).contentType(ContentType.JSON).pathParam("userId", 2)
		.when().patch("/api/users/{userId}")
		.then().assertThat().statusCode(200).log().all();
	}

}
