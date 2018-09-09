package samples;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RandomCatFactGenerator {

    public String generateCatFact() {
        String text = "";
        try {
            HttpResponse<JsonNode> response = Unirest
                    .get("https://cat-fact.herokuapp.com/facts/random")
                    .asJson();
            text = (String) response.getBody().getObject().get("text");

        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return text;
    }
}
