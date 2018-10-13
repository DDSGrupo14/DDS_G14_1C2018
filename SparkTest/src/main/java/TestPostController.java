import com.google.gson.Gson;

import static spark.Spark.post;

@SuppressWarnings("ALL")
public class TestPostController {

    public void postTest(){
        final UserService userService = new UserServiceMapImpl();

        post("/users", (request, response) -> {
            response.type("application/json");

            User user = new Gson().fromJson(request.body(), User.class);
            userService.addUser(user);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
    }
}
