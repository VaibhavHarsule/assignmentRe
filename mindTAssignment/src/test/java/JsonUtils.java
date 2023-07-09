import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
public class JsonUtils {
    public static JsonObject createPetPayload(int id, String categoryName, String petName, String photoUrl, int tagId, String tagName, String status) {
        JsonObject payload = new JsonObject();
        JsonObject category = new JsonObject();

        category.addProperty("id", 0);
        category.addProperty("name", categoryName);
        JsonObject tag = new JsonObject();
        tag.addProperty("id", tagId);
        tag.addProperty("name", tagName);
        JsonArray photoUrls = new JsonArray();
        photoUrls.add(photoUrl);
        payload.addProperty("id", id);
        payload.add("category", category);
        payload.addProperty("name", petName);
        payload.add("photoUrls", photoUrls);
        payload.addProperty("status", status);
        JsonArray tags = new JsonArray();
        JsonObject tagObject = new JsonObject();
        tagObject.addProperty("id", tagId);
        tagObject.addProperty("name", tagName);
        tags.add(tagObject);
        payload.add("tags", tags);

        return payload;
    }

    public JsonObject createUserObject(String id, String username, String firstName, String lastName, String email,
                                       String password, String phone, int userStatus) {
        JsonObject userObject = new JsonObject();

        userObject.addProperty("id", id);
        userObject.addProperty("username", username);
        userObject.addProperty("firstName", firstName);
        userObject.addProperty("lastName", lastName);
        userObject.addProperty("email", email);
        userObject.addProperty("password", password);
        userObject.addProperty("phone", phone);
        userObject.addProperty("userStatus", userStatus);

        return userObject;
    }
}
