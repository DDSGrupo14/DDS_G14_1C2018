package utilidades;


public class Path {

    public static class Web{

        public static final String TEST = "/test/";
        public static final String HOME = "/home/";
        public static final String LOGIN = "/login/";

    }

    public static class Template{

        public static final String HOME = "vistas/home.vm";
        public static final String TEST = "vistas/bootstrapTest.vm";
        public static final String LOGIN = "vistas/login.vm";
    }

    public static class Archivos {

        public final static String CLIENTE_COMPLETO = "src/main/resources/json/clientes.json";

        public final static String LOGIN_CLIENTES = "src/main/resources/json/clientes_login.json";

        public final static String LOGIN_ADMINISTRADORES = "src/main/resources/json/administradores_login.json";

        public final static String TIPOS_CONCRETOS = "src/main/resources/json/tipos_concretos.json";

        public final static String CATEGORIAS = "src/main/resources/json/categorias.json";
    }
}
