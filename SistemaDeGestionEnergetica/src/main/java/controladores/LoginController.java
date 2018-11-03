package controladores;

import spark.Request;
import spark.Response;
import spark.Route;
import utilidades.Path;
import utilidades.ViewUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginController {

    public static Route login = (Request request, Response response) ->{

        Map<String, Object> model = new HashMap<>();
        model.put("message","esto es para login");

        return ViewUtil.render( model, Path.Template.LOGIN);
    };
}
