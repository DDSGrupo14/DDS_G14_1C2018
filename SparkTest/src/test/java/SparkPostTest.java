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

public class SparkPostTest {

    public static class TestContollerTestSparkApplication implements SparkApplication {
        @Override
        public void init() {
            System.out.println("Test application initialized");
            new TestPostController();
        }

        @Override
        public void destroy() {
            System.out.println("Test application stopped");
        }


    }

    @ClassRule
    public static SparkServer<TestContollerTestSparkApplication> testServer =
            new SparkServer<>(SparkPostTest.TestContollerTestSparkApplication.class, 4567);

    @Test
    public void test() throws Exception {

      //  GetMethod get = testServer.get("/test", false);
       // get.addHeader("Test-Header", "test");

        Gson gson = new Gson();
        String jsonString = "";

        ClassLoader classLoader = MethodHandles.lookup().lookupClass().getClassLoader();
        File jsonFile = new File(classLoader.getResource("user.json").getFile());

        final StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }

            jsonString = sb.toString();
        } catch (Exception e){
            System.err.println(e);
        }

        PostMethod post = testServer.post("/users",jsonString,false);

        HttpResponse httpResponse = testServer.execute(post);
        assertEquals(200, httpResponse.code());
        assertEquals(jsonString, new String(httpResponse.body()));
    }

}
