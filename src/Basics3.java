import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//start from section-6 lesson 21

public class Basics3 {
	
	
	@Test
	public void addPlace()
	{
		
		String bobyDetails="{" + "\"location\": {" + "\"lat\": -33.8669710," + "\"lng\": 151.1958750" + "},"
				+ "\"accuracy\": 50," + "\"name\": \"Google Shoes!\"," + "\"phone_number\": \"(02) 9374 4000\","
				+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
				+ "\"types\": [\"shoe_store\"]," + "\"website\": \"http://www.google.com.au/\","
				+ "\"language\": \"en-AU\"" + "}";
		RestAssured.baseURI = "http://216.10.245.166";
		Response res=given().

				queryParam("key", "qaclick123")
				.body(bobyDetails)
				.when().post("/maps/api/place/add/json").
				then().
				assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().
				body("status",equalTo("OK")).and().extract().response(); 
		System.out.println("Response is :  "+res.asString());
		String responseString=res.asString();
		JsonPath jpath= new JsonPath(responseString);
		String place_id=jpath.get("place_id");
		System.out.println("Extraced the place ID "+place_id);
		
		//get the place id and delete it
		given().

		queryParam("key", "qaclick123").
		body("{"+
				  "\"place_id\": \""+place_id+"\""+
				"}").when().post("/maps/api/place/delete/json").
		then().
		assertThat().statusCode(200).and()
		.contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).and().extract().response(); 
		
		
		
	}
	


}

