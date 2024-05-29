package CrudOperation;

//import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
public class JSONSchemaValidation {
	private Matcher<?> JsonSchemaValidator;

	@Test
	void jsonschemavalidation()
	{
		given()
		.when()
		 .get("")
		 .then()
		 // .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storejson.json"));
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("storejson.json"));
	}

}
