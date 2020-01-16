package service;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Params;
import model.RandomBody;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RandomService {
    public final Dotenv dotenv;

    public RandomService() {
        this.dotenv = Dotenv.load();
    }

    private List<List<Integer>> getData(String body) {
        Response r = given().contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(dotenv.get("baseURI"));

        System.out.println(r.getBody().asString());
        List<List<Integer>> data = r.getBody().jsonPath().get("result.random.data");
        return data;
    }

    public List<List<Integer>> generateIntegerSequences(int n, int count) {
//        String body = "{\"jsonrpc\": \"2.0\",\"method\": \"generateIntegerSequences\",\"params\": {\"apiKey\": \"" + dotenv.get("apiKey") + "\",\"n\": " + n + ", \"length\": " + count + ", \"min\": 1,\"max\": 6,\"replacement\": true}, \"id\": 3076}";
        return getData(prepareJSONBody(n, count));
    }

    private String prepareJSONBody(int n, int count) {
        RandomBody rBody = new RandomBody()
                .setJsonrpc("2.0")
                .setMethod("generateIntegerSequences")
                .setParams(new Params()
                        .setApiKey(dotenv.get("apiKey"))
                        .setN(n)
                        .setLength(count)
                        .setMin(1)
                        .setMax(6)
                        .setReplacement(true)
                )
                .setId(3076);

        Gson gson = new Gson();
        return gson.toJson(rBody);
    }
}
