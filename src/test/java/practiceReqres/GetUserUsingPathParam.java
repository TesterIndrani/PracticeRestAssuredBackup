package practiceReqres;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetUserUsingPathParam {

	@Test
	public static void main(String[] args) {

		baseURI = "https://reqres.in";
		
			Response resp = given().pathParam("userId", 2). 
					when().get("/api/users/{userId}");
			
			resp.then().assertThat().statusCode(200).log().all();
			
			//to get status line
			System.out.println("Status Line: " + resp.getStatusLine());
			System.out.println();
			
			//to get status code and validate it
			int statusCode = resp.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			System.out.println();

			//to get response body as String
			System.out.println("Response body: " + resp.asString());
			System.out.println();

			//to get headers and validate them
			Headers allHeaders = resp.getHeaders();
			for(Header h : allHeaders)
			{
				System.out.println("Header Key: "+ h.getName()+ ", Header Value: "+ h.getValue());
			}
			System.out.println();

			//to extract particular header and validate it
			String contentTypeValue = resp.getHeader("Content-Type");
			System.out.println("Content Type header value: "+ contentTypeValue);
			Assert.assertEquals(contentTypeValue, "application/json; charset=utf-8");
			System.out.println();			

			//to get response body as String and check if it contains a specific String
			ResponseBody respBody = resp.getBody();
			String responseBodyasString = respBody.asString();
			Assert.assertEquals(responseBodyasString.contains("first_name"), true);			
			System.out.println();
			
			//to get response and verify a particular Node text using JsonPath
			 String lastName = resp.jsonPath().get("data.last_name");
			 System.out.println("Last name received in response is : "+lastName);
			 Assert.assertEquals(lastName, "Weaver");
			  					 
	}

}
