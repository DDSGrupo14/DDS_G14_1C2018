package parser;

import modelos.Usuario;
import org.junit.Test;

public class ParserJsonTest {


    @Test
    public void test(){
        final Usuario usuario = new Usuario("Pepe", "Garcia", "1234", "1512312312");
        System.out.println(usuario.getObj().toString());
    }
}
