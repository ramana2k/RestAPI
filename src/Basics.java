import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Basics {
	
	@Test
	public  void test()
	
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
	           param("type","hotels").
		       param("location","51.524703,-0.075907").
		       param("raduis","500").
		       param("key","AIzaSyDfWcmIKnM7Jn_jdX2tZweVbH0GsP5d09Q").
			   when().
			   get("/maps/api/place/nearbysearch/json").
			   then().
			   assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
			  .body("results[0].name",equalTo("London")).and()
			  .header("Server", "scaffolding on HTTPServer2");
			  
	}

}
