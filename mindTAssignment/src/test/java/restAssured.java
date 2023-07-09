import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Constants.APIConstants;

public class restAssured {
    public RequestSpecification reqBuilderUt()
    {
        RestAssured.baseURI = APIConstants.baseURI;
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        // Set headers
        //requestSpec.header("Content-Type", "application/json");
        //requestSpec.header("Authorization", "Bearer "+"");
        return requestSpec;
    }

    public Response createEntitiesPost( String postBody)
    {
        RequestSpecification reqB = reqBuilderUt();
        reqB.body(postBody);
        Response response = reqB.when().post(APIConstants.multipleUsersArray).then().assertThat().statusCode(200).extract().response().prettyPeek();
        return response;
    }

    public Response getEntities(String getUSerName)
    {
        RequestSpecification reqB = reqBuilderUt();
        Response response = reqB.when().pathParam("username",getUSerName).get("/user/{username}").then().assertThat().statusCode(200).extract().response().prettyPeek();
        //(Response) reqB.response();
        return response;
    }
    public Response putUsername(String getUSerName, String payLoad)
    {
        RequestSpecification reqB = reqBuilderUt();
        reqB.when().pathParam("username",getUSerName);
        reqB.body(payLoad);
        Response response = (Response) reqB.when().put("/user/{username}").then().assertThat().statusCode(200).extract().response().prettyPeek();;
        return response;
    }

    public Response createPetsEntities(String postBody)
    {
        RequestSpecification reqB = reqBuilderUt();
        reqB.body(postBody);
        Response response = reqB.when().post(APIConstants.createPets).then().assertThat().statusCode(200).extract().response().prettyPeek();
        return response;
    }
    public Response updatePetsEntities(String postBody)
    {
        RequestSpecification reqB = reqBuilderUt();
        reqB.body(postBody);
        Response response = reqB.when().put(APIConstants.createPets).then().assertThat().statusCode(200).extract().response().prettyPeek();
        return response;
    }
    public Response getPets(String status)
    {
        RequestSpecification reqB = reqBuilderUt();
        reqB.queryParam("status",status);
        Response response = reqB.when().get(APIConstants.createPets+"/findByStatus").then().assertThat().statusCode(200).extract().response().prettyPeek();
        return response;
    }
}
