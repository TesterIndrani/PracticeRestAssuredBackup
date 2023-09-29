package practiceReqres;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUserUsingJSONObject {

	public static void main(String[] args) {

		baseURI = "https://reqres.in/";
		
		//Step 1: Create the required data
		JSONObject obj = new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job", "leader");
		
		
		//Step 2: Send the request (using method chaining)
	 Response resp = given().body(obj).contentType(ContentType.JSON).
			 		 when().post("/api/users");
	 	
	 
		//Step 3: Validate the response
	 		resp.then().assertThat().statusCode(201).log().all();
			System.out.println("PASS");
		
	}
}
