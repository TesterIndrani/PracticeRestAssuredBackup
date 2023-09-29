package practicePetstore;
import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.restassured.http.ContentType;

public class CreateOrder {

	public static void main(String[] args) throws FileNotFoundException {

		baseURI = "https://petstore.swagger.io/v2";

		FileInputStream fis = new FileInputStream("./src/test/resources/petstore.json");
		
		given().body(fis).contentType(ContentType.JSON)
		.when().post("/store/order")
		.then().assertThat().statusCode(200).log().all();
		
	}

}
