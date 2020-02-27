import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

/*
Type of parameters : 3 types
--path parameter : http//example.com/1234
--query parameter: http://example.com?q=searchterm
--header parameter

path parameter is not allowed for POST Request
*/


public class Post {
	
	@Test
	public void postData()
	{
		RestAssured.baseURI=" http://216.10.245.166";
		//given().queryParam("key", "qaclick123").
		

	}

}
