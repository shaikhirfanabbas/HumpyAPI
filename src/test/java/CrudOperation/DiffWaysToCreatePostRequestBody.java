package CrudOperation;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;

public class DiffWaysToCreatePostRequestBody {

	@Test
	void testPostusingHashMap()
	{
//		HashMap data= new HashMap();
//		String courseArr[]= {"C","C++"};
//		data.put("courses", courseArr);
//		data.put("phone", "123456");
//		data.put("location", "USA");
//		data.put("name", "Smith");
//		data.put("id", "2");
		
//		JSONObject data=new JSONObject();
//		String courseArr[]= {"C","C++"};
//		data.put("courses", courseArr);
//		data.put("phone", "123456");
//		data.put("location", "USA");
//		data.put("name", "Smith");
//		data.put("id", "2");
		
		Pojoclass data=new Pojoclass();
		
		data.setId("1");
		data.setName("irfan");
		
		String coursesArr[]= {"c","c++"};
		data.setCourses(coursesArr);
		
//		File f=new File("./Test.json");
//		FileReader fr=new FileReader(); 
//		JSONTokener jt=new JSONTokener(fr);
//		
//		JSONObject data=new JsonObject(jt);
		

		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/items")
		.then()
		.statusCode(200)
		.log().all()
		
		//.body("data.students.findAll { it.name == 'Smith' }.name", hasItems("Smith"));
		//.body("data.students.name", everyItem(equalTo("Smith")))
		.body("data.students.courses[0]", everyItem(equalTo("c")));

		
		
		
	}
	@Test(priority=2)
	void testDelete() {
		given()
		.when()
		.delete("")
		.then();
	}
}
