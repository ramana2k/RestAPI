import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class Basics {
	
	@Test
	public  void Test()
	
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
	           param("type","hospitals").
		       param("key","AIzaSyDfWcmIKnM7Jn_jdX2tZweVbH0GsP5d09Q").
		       param("location","51.524703,-0.075907").
		       param("raduis","100").
	    when().
			   get("/maps/api/place/nearbysearch/json").
		then().
			   assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
			  .body("results[0].name",equalTo("London")).and()
			  .body("results[0].place_id",equalTo("ChIJdd4hrwug2EcRmSrV3Vo6llI"));
			  
	}

}
