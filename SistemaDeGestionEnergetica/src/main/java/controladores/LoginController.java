package controladores;

import modelos.usuarios.Administrador;
import modelos.usuarios.Cliente;
import spark.Request;
import spark.Response;
import spark.Route;
import utilidades.AdministradorDAO;
import utilidades.ClienteDAO;
import utilidades.Path;
import utilidades.ViewUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginController {

    static final String falloLogin = "falloLogin";

    public static Route loginGet = (Request request, Response response) ->{
        Map<String, Object> model = new HashMap<>();
        model.put(falloLogin, false);
        return ViewUtil.render(model, Path.Template.LOGIN);

    };

    public static Route loginPost = (Request request, Response response) ->{

        Map<String, Object> model = new HashMap<>();
        String username = request.queryParams("username");
        String password = request.queryParams("password");

        System.out.println(request.body());

        AdministradorDAO adminDAO = new AdministradorDAO();

        Administrador administrador = adminDAO.obtenerAdministradorPorUsername(username);

        if( administrador != null ){
            if( administrador.getPassword().equals(password))
                return ViewUtil.render( model, Path.Template.HOMEADMIN);
        } else {
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.obtenerClientePorUsername(username);
            if( cliente != null) {
                if (cliente.getPassword().equals(password))
                    return ViewUtil.render(model, Path.Template.HOMECLIENTE);
            }
        }
        model.put(falloLogin, true);
        return ViewUtil.render(model, Path.Template.LOGIN);
    };
}
