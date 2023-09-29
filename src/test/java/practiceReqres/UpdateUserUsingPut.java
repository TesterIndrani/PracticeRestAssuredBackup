package practiceReqres;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class UpdateUserUsingPut {

	public static void main(String[] args) {
		
		baseURI = "https://reqres.in";

		//Step 1: Create the required data
		JSONObject obj = new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job","zion resident");
		
		given().pathParam("userId",2).body(obj).contentType(ContentType.JSON)
		.when().put("/api/users/userId}")
		.then().assertThat().statusCode(200).log().all();
		
		
	}

}
