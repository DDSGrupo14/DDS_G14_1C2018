package utilidades;


public class Path {

    public static class Web{

        public static final String TEST = "/test/";
        public static final String HOME = "/home/";
        public static final String LOGIN = "/login/";
        public static final String MAPA = "/mapa/";

    }

    public static class Template{

        public static final String HOMEADMIN = "vistas/home_admin.vm";
        public static final String HOMECLIENTE = "vistas/home_cliente.vm";
        public static final String TEST = "vistas/bootstrapTest.vm";
        public static final String LOGIN = "vistas/login.vm";
        public static final String MAPA = "vistas/mapa.vm";
    }

    public static class Archivos {

        public final static String CLIENTE_COMPLETO = "src/main/resources/json/clientes.json";

        public final static String LOGIN_CLIENTES = "src/main/resources/json/clientes_login.json";

        public final static String LOGIN_ADMINISTRADORES = "src/main/resources/json/administradores_login.json";

        public final static String TIPOS_CONCRETOS = "src/main/resources/json/tipos_concretos.json";

        public final static String CATEGORIAS = "src/main/resources/json/categorias.json";

        public final static String ZONA = "src/main/resources/json/zona.json";

    }
}
