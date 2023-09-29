package practiceReqres;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateUserUsingPayload {

	public static void main(String[] args) {
		
		baseURI = "https://reqres.in";
		
	/*	Response resp = given().formParam("name", "morpheus").formParam("job","leader").contentType(ContentType.JSON).	
						when().post("/api/users");
	
		resp.then().assertThat().statusCode(201).log().all();
		System.out.println("PASS");
	*/	
		
		String payload = "{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}" ;
				
		Response resp = given().body(payload).contentType(ContentType.JSON).	
						when().post("/api/users");
			
		resp.then().assertThat().statusCode(201).log().all();
		System.out.println("PASS");
	
		
	}

}
