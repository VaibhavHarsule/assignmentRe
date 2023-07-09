import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import Constants.APIConstants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class testPart1 {
    restAssured apiCurl = new restAssured();
    JsonUtils JsonObjectUtil = new JsonUtils();
    @Test
    public void runTestPart1()
    {
        JsonArray jsonA = new JsonArray();
        JsonObject user1 = JsonObjectUtil.createUserObject("1","user1","pass1","last1","user1@pet.com","pass1","123456789",0);
        jsonA.add(user1);
        JsonObject user2 = JsonObjectUtil.createUserObject("2","user2","pass2","last2","user2@pet.com","pass2","123456780",1);
        jsonA.add(user2);
        apiCurl.createEntitiesPost(jsonA.toString());
        JsonObject updateUser = JsonObjectUtil.createUserObject("1","vaibhav","pass1","last1","user1@pet.com","pass1","123456789",0);
        apiCurl.putUsername("user1",updateUser.toString());
        apiCurl.getEntities("vaibhav");
    }

    @Test
    public void runTestPart2()
    {
        JsonObject germanS = JsonObjectUtil.createPetPayload(1, "petDogs", "GermanShepard", "string", 1, "pet1", "available");
        JsonObject goldenL = JsonObjectUtil.createPetPayload(2, "petDogs", "GoldenRetriever", "string", 2, "pet1", "available");
        JsonObject blackL = JsonObjectUtil.createPetPayload(3, "petDogs", "Black Labror", "string", 3, "pet1", "available");
        JsonObject elephant = JsonObjectUtil.createPetPayload(4, "petWild", "African Ele", "string", 4, "pet2", "available");
        JsonObject tiger = JsonObjectUtil.createPetPayload(5, "petWild", "White Tiger", "string", 5, "pet2", "available");
        JsonObject rabbit = JsonObjectUtil.createPetPayload(6, "pet", "Rabbit", "string", 6, "pet3", "available");
        apiCurl.createPetsEntities(germanS.toString());
        apiCurl.createPetsEntities(goldenL.toString());
        apiCurl.createPetsEntities(blackL.toString());
        apiCurl.createPetsEntities(elephant.toString());
        apiCurl.createPetsEntities(tiger.toString());
        apiCurl.createPetsEntities(rabbit.toString());
        tiger = JsonObjectUtil.createPetPayload(5, "petWild", "White Tiger", "string", 5, "pet2", "pending");
        blackL = JsonObjectUtil.createPetPayload(3, "petDogs", "Black Labror", "string", 3, "pet1", "sold");
        apiCurl.updatePetsEntities(tiger.toString());
        apiCurl.updatePetsEntities(blackL.toString());
       Response response2 = apiCurl.getPets(APIConstants.statusSold);
    }

}
