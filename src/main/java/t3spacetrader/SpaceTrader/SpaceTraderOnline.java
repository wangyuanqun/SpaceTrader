package t3spacetrader.SpaceTrader;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import org.apache.hc.core5.net.URIBuilder;
import org.json.*;

public class SpaceTraderOnline implements SpaceTrader {

    private final CloseableHttpClient httpClient;

    public SpaceTraderOnline() {
        httpClient = HttpClients.createDefault();
    }

    @Override
    public JSONObject getStatus() {

        HttpGet httpget = new HttpGet("https://api.spacetraders.io/game/status");

        JSONObject status = null;
        try{
            CloseableHttpResponse response = httpClient.execute(httpget);
            String content = EntityUtils.toString(response.getEntity());
            status = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public JSONObject getUserToken(String name){

        JSONObject token = null;
        try{
            HttpPost httpPost = new HttpPost("https://api.spacetraders.io/users/"+name+"/token");
            httpPost.setEntity(new StringEntity(""));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String content = EntityUtils.toString(response.getEntity());
            token = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public JSONObject getUserInfo(String token, String username){
        JSONObject info = null;
        try {
            HttpGet httpget = new HttpGet("https://api.spacetraders.io/users/"+username);
            httpget.setHeader("Authorization", "Bearer "+token);
            CloseableHttpResponse response = httpClient.execute(httpget);
            String content = EntityUtils.toString(response.getEntity());
            info = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return info;
    }

    @Override
    public JSONObject getLoansInfo(String token) {

        JSONObject loanInfo = null;
        try {
            HttpGet httpget = new HttpGet("https://api.spacetraders.io/game/loans");
            httpget.setHeader("Authorization", "Bearer "+token);
            CloseableHttpResponse response1 = httpClient.execute(httpget);
            String content1 = EntityUtils.toString(response1.getEntity());
            loanInfo = new JSONObject(content1);
            EntityUtils.consume(response1.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loanInfo;
    }

    @Override
    public JSONObject obtainLoan(String token, String username, String type) {
        JSONObject loan = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+username+"/loans");
            builder.setParameter("type", type);
            HttpPost httpPost = new HttpPost(builder.build());
            httpPost.setHeader("Authorization", "Bearer "+token);
            httpPost.setEntity(new StringEntity(""));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String content = EntityUtils.toString(response.getEntity());
            loan = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loan;
    }

    @Override
    public JSONObject payOffLoan(String token, String username, String loanID) {
        JSONObject payOff = null;
        try {
            HttpPut httpput = new HttpPut("https://api.spacetraders.io/users/"+username+"/loans/"+loanID);
            httpput.setHeader("Authorization", "Bearer "+token);
            httpput.setEntity(new StringEntity(""));
            CloseableHttpResponse response = httpClient.execute(httpput);
            String content = EntityUtils.toString(response.getEntity());
            payOff = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payOff;
    }

    @Override
    public JSONObject getShipsInfo(String token, String Class) {
        JSONObject shipInfo = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.spacetraders.io/game/ships");
            builder.setParameter("class", Class);
            HttpGet httpget = new HttpGet(builder.build());
            httpget.setHeader("Authorization", "Bearer "+token);
            CloseableHttpResponse response = httpClient.execute(httpget);
            String content = EntityUtils.toString(response.getEntity());
            shipInfo = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shipInfo;
    }

    @Override
    public JSONObject purchaseShip(String token, String username, String type, String location) {
        JSONObject ship = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+username+"/ships");
            builder.setParameter("type", type);
            builder.setParameter("location", location);
            HttpPost httpPost = new HttpPost(builder.build());
            httpPost.setHeader("Authorization", "Bearer "+token);
            httpPost.setEntity(new StringEntity(""));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String content = EntityUtils.toString(response.getEntity());
            ship = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ship;
    }

    @Override
    public JSONObject purchaseGoods(String token, String username, String shipID, String good, String quantity) {
        JSONObject goods = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+username+"/purchase-orders");
            builder.setParameter("shipId", shipID);
            builder.setParameter("good", good);
            builder.setParameter("quantity", quantity);
            HttpPost httpPost = new HttpPost(builder.build());
            httpPost.setHeader("Authorization", "Bearer "+token);
            httpPost.setEntity(new StringEntity(""));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String content = EntityUtils.toString(response.getEntity());
            goods = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public JSONObject viewMarketDetails(String token, String marketSymbol) {
        JSONObject detail = null;
        try {
            HttpGet httpget = new HttpGet("https://api.spacetraders.io/game/locations/"+marketSymbol+"/marketplace");
            httpget.setHeader("Authorization", "Bearer "+token);
            CloseableHttpResponse response = httpClient.execute(httpget);
            String content = EntityUtils.toString(response.getEntity());
            detail = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    @Override
    public JSONObject getNearbyLocation(String token, String systemSymbol, String type) {
        JSONObject location = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.spacetraders.io/game/systems/"+systemSymbol+"/locations");
            builder.setParameter("type", type);
            HttpGet httpget = new HttpGet(builder.build());
            httpget.setHeader("Authorization", "Bearer "+token);
            CloseableHttpResponse response = httpClient.execute(httpget);
            String content = EntityUtils.toString(response.getEntity());
            location = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public JSONObject createFlightPlan(String token, String username, String shipID, String destiantion) {
        JSONObject plan = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+username+"/flight-plans");
            builder.setParameter("shipId", shipID);
            builder.setParameter("destination", destiantion);
            HttpPost httpPost = new HttpPost(builder.build());
            httpPost.setHeader("Authorization", "Bearer "+token);
            httpPost.setEntity(new StringEntity(""));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String content = EntityUtils.toString(response.getEntity());
            plan = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plan;
    }

    @Override
    public JSONObject viewFlightPan(String token, String username, String flightPlanID) {
        JSONObject view = null;
        try {
            HttpGet httpget = new HttpGet("https://api.spacetraders.io/users/"+username+"/flight-plans/"+flightPlanID);
            httpget.setHeader("Authorization", "Bearer "+token);
            CloseableHttpResponse response = httpClient.execute(httpget);
            String content = EntityUtils.toString(response.getEntity());
            view = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public JSONObject sellGoods(String token, String username, String shipID, String good, String quantity) {
        JSONObject sell = null;
        try {
            URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+username+"/sell-orders");
            builder.setParameter("shipId", shipID);
            builder.setParameter("good", good);
            builder.setParameter("quantity", quantity);
            HttpPost httpPost = new HttpPost(builder.build());
            httpPost.setHeader("Authorization", "Bearer "+token);
            httpPost.setEntity(new StringEntity(""));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String content = EntityUtils.toString(response.getEntity());
            sell = new JSONObject(content);
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sell;
    }


}
