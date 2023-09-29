package practiceReqres;
import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserUsingJSONFile {

	public static void main(String[] args) throws FileNotFoundException {

		//Step 1: Prepare required data
		FileInputStream fis = new FileInputStream("./src/test/resources/createUserData.json");
		baseURI = "https://reqres.in";
		
		//Step2 : send request
		Response resp = given().body(fis).contentType(ContentType.JSON).
						when().post("/api/users");
		
		//Step3: validate response
		resp.then().assertThat().statusCode(201).log().all();
		System.out.println("PASS");
		
	}

}
