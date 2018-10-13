import com.despegar.http.client.GetMethod;
import com.despegar.http.client.HttpResponse;
import com.despegar.http.client.PostMethod;
import com.despegar.sparkjava.test.SparkServer;
import com.google.gson.Gson;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import spark.servlet.SparkApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.invoke.MethodHandles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SparkGetTest {

    public static class TestContollerTestSparkApplication implements SparkApplication {
        @Override
        public void init() {
            System.out.println("Test application initialized");
            new TestGetController();
        }

        @Override
        public void destroy() {
            System.out.println("Test application stopped");
        }


    }

    @ClassRule
    public static SparkServer<SparkPostTest.TestContollerTestSparkApplication> testServer =
            new SparkServer<>(SparkPostTest.TestContollerTestSparkApplication.class, 4567);

    @Test
    public void test() throws Exception {


        GetMethod get = testServer.get("/users",false);
        HttpResponse httpResponse = testServer.execute(get);

        assertEquals(200, httpResponse.code());

        assertEquals("hola", new String(httpResponse.body()));
        assertNotNull(testServer.getApplication(),"Es nulo");

    }
}
