import com.google.gson.Gson;

import static spark.Spark.get;

public class TestGetController {

    public void getTets(){

        final UserService userService = new UserServiceMapImpl();

        get("/users", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUsers())));
        });
    }
}
