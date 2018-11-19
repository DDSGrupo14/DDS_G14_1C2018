package spark;

import controladores.HomeController;
import controladores.LoginController;
import controladores.MapaController;
import controladores.TestController;
import org.apache.log4j.PropertyConfigurator;
import utilidades.Path;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class SparkTest {

    public static void main(String[] args) {

        PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j2.properties"));

        Spark.staticFileLocation("/customStyles");
        port(getHerokuAssignedPort());

        get(Path.Web.HOME, HomeController.home);
        get(Path.Web.TEST, TestController.testBootstrap);
        get(Path.Web.LOGIN, LoginController.loginGet);
        get(Path.Web.MAPA, MapaController.obtenerMApa);

        post(Path.Web.LOGIN, LoginController.loginPost);

     /*   get(Path.Web.TEST, (Request req, Response res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("message","otra forma");
            return new ModelAndView(model, Path.Template.HOME);
        }, new VelocityTemplateEngine());
*/
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
