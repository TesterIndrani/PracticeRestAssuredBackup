package practicePetstore;
import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class CreateAndGetOrder {

	public static void main(String[] args) throws FileNotFoundException {

		baseURI = "https://petstore.swagger.io/v2";

		//Step1: Create order
		FileInputStream fis = new FileInputStream("./src/test/resources/petstore.json");
		
		Response createResp = given().body(fis).contentType(ContentType.JSON)
		.when().post("/store/order");
		
		createResp.then().assertThat().statusCode(200).log().all();	
		System.out.println("Creating Order- PASS");
		
		//Step2: Get Order using Order Id from above response
		
		int value = createResp.jsonPath().get("id");
		System.out.println("OrderId created is: "+value);
		
		given().pathParam("orderId",value)
		.when().get("/store/order/{orderId}")
		.then().assertThat().statusCode(200).log().all();
		
	}

}
