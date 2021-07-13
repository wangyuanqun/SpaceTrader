package t3spacetrader;

import t3spacetrader.SpaceTrader.SpaceMaker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class SpaceTraderApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Parameters para = getParameters();
		if(para.getRaw().size() != 2) {
			if((!("offline".equals(para.getRaw().get(0))) && !("online".equals(para.getRaw().get(0))))) {
				Alert alert = new Alert(Alert.AlertType.WARNING, "You need to specify online or offline in command line.");
				alert.show();
			} else {
				// initialize the SpaceTrader with offline or online
				SpaceMaker.init(para.getRaw().get(0));

				// create the main window to display
				try {
					Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
					primaryStage.setScene(new Scene(root, 500, 300));
					primaryStage.setTitle("SpaceTrader");
					primaryStage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING, "You need to pass in a parameter.");
			alert.show();
		}
	}

	@Override
	public void stop() {

	}
}


//====================================== need to comment above before using below=================
//====================================== commandline testing======================================

//import org.apache.hc.client5.http.classic.methods.HttpGet;
//import org.apache.hc.client5.http.classic.methods.HttpPost;
//import org.apache.hc.client5.http.classic.methods.HttpPut;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
//import org.apache.hc.client5.http.impl.classic.HttpClients;
//import org.apache.hc.core5.http.io.entity.EntityUtils;
//import org.apache.hc.core5.http.io.entity.StringEntity;
//import org.apache.hc.core5.net.URIBuilder;
//import org.json.JSONObject;
//
//public class App {
//	public static void main(String[] args) {
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		String name = "TestForGUI";
//		String token = "8fc3b43e-6332-4afc-8b1c-6c922584174f";
//		String loadID = "cko7uhk2m11793611bs6chuhfm9v";
//		String shipID = "cko7wz7v615985621bs6fzi2oxkz";
//		String marketSymbol = "OE-PM-TR";
//		String systemSymbol = "OE";
//		String flightPlanID = "cko7z226o16603561bs6frmwigsu";
//		try{
			// get status
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/game/status");
//			CloseableHttpResponse response2 = httpClient.execute(httpget);
//			String content2 = EntityUtils.toString(response2.getEntity());
//			System.out.println(content2);
//			EntityUtils.consume(response2.getEntity());


			// get token
//			HttpPost httpPost = new HttpPost("https://api.spacetraders.io/users/"+name+"/token");
//			httpPost.setEntity(new StringEntity(""));
//			CloseableHttpResponse response = httpClient.execute(httpPost);
//			String content = EntityUtils.toString(response.getEntity());
//			JSONObject t = new JSONObject(content);
//			String token = t.getString("token");
//			EntityUtils.consume(response.getEntity());


			//get user info
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/users/"+name);
//			httpget.setHeader("Authorization", "Bearer "+token);
//			CloseableHttpResponse response1 = httpClient.execute(httpget);
//			String content1 = EntityUtils.toString(response1.getEntity());
//			System.out.println(content1);
//			EntityUtils.consume(response1.getEntity());


			//get loans info
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/game/loans");
//			httpget.setHeader("Authorization", "Bearer "+token);
//			CloseableHttpResponse response1 = httpClient.execute(httpget);
//			String content1 = EntityUtils.toString(response1.getEntity());
//			System.out.println(content1);
//			EntityUtils.consume(response1.getEntity());

			// obtain a loan
//			URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+name+"/loans");
//			builder.setParameter("type", "STARTUP");
//			HttpPost httpPost = new HttpPost(builder.build());
//			httpPost.setHeader("Authorization", "Bearer "+token);
//			httpPost.setEntity(new StringEntity(""));
//			CloseableHttpResponse response = httpClient.execute(httpPost);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// get your loans
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/users/"+name+"/loans");
//			httpget.setHeader("Authorization", "Bearer "+token);
//			CloseableHttpResponse response = httpClient.execute(httpget);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// pay off your loans
//			HttpPut httpput = new HttpPut("https://api.spacetraders.io/users/"+name+"/loans/"+loadID);
//			httpput.setHeader("Authorization", "Bearer "+token);
//			httpput.setEntity(new StringEntity(""));
//			CloseableHttpResponse response = httpClient.execute(httpput);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());
			// {"error":{"message":"Insufficient funds to pay for loan.","code":400}}

			// get ships info ( class is optional)
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/game/ships");
//			httpget.setHeader("Authorization", "Bearer "+token);
//			CloseableHttpResponse response = httpClient.execute(httpget);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// purchase a ship
//			URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+name+"/ships");
//			builder.setParameter("type", "JW-MK-I");
//			builder.setParameter("location", "OE-PM-TR");
//			HttpPost httpPost = new HttpPost(builder.build());
//			httpPost.setHeader("Authorization", "Bearer "+token);
//			httpPost.setEntity(new StringEntity(""));
//			CloseableHttpResponse response = httpClient.execute(httpPost);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// list user ship info
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/users/"+name+"/ships");
//			httpget.setHeader("Authorization", "Bearer "+token);
//			CloseableHttpResponse response = httpClient.execute(httpget);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// purchase ship fuel
//			URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+name+"/purchase-orders");
//			builder.setParameter("shipId", shipID);
//			builder.setParameter("good", "FUEL");
//			builder.setParameter("quantity", "20");
//			HttpPost httpPost = new HttpPost(builder.build());
//			httpPost.setHeader("Authorization", "Bearer "+token);
//			httpPost.setEntity(new StringEntity(""));
//			CloseableHttpResponse response = httpClient.execute(httpPost);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// view the marketplace details for a given location
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/game/locations/"+marketSymbol+"/marketplace");
//			httpget.setHeader("Authorization", "Bearer "+token);
//			CloseableHttpResponse response = httpClient.execute(httpget);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			//purchase goods from the marketplace
//			URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+name+"/purchase-orders");
//			builder.setParameter("shipId", shipID);
//			builder.setParameter("good", "METALS");
//			builder.setParameter("quantity", "30");
//			HttpPost httpPost = new HttpPost(builder.build());
//			httpPost.setHeader("Authorization", "Bearer "+token);
//			httpPost.setEntity(new StringEntity(""));
//			CloseableHttpResponse response = httpClient.execute(httpPost);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// list nearby locations and their details(type is optional)
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/game/systems/"+systemSymbol+"/locations");
//			httpget.setHeader("Authorization", "Bearer "+token);
//			CloseableHttpResponse response = httpClient.execute(httpget);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// create a flight plan and journey to a nearby location
//			URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+name+"/flight-plans");
//			builder.setParameter("shipId", shipID);
//			builder.setParameter("destination", "OE-PM");
//			HttpPost httpPost = new HttpPost(builder.build());
//			httpPost.setHeader("Authorization", "Bearer "+token);
//			httpPost.setEntity(new StringEntity(""));
//			CloseableHttpResponse response = httpClient.execute(httpPost);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// view their current flight plan
//			HttpGet httpget = new HttpGet("https://api.spacetraders.io/users/"+name+"/flight-plans/"+flightPlanID);
//			httpget.setHeader("Authorization", "Bearer "+token);
//			CloseableHttpResponse response = httpClient.execute(httpget);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());

			// sell goods to the marketplace
//			URIBuilder builder = new URIBuilder("https://api.spacetraders.io/users/"+name+"/sell-orders");
//			builder.setParameter("shipId", shipID);
//			builder.setParameter("good", "FUEL");
//			builder.setParameter("quantity", "2");
//			HttpPost httpPost = new HttpPost(builder.build());
//			httpPost.setHeader("Authorization", "Bearer "+token);
//			httpPost.setEntity(new StringEntity(""));
//			CloseableHttpResponse response = httpClient.execute(httpPost);
//			String content = EntityUtils.toString(response.getEntity());
//			System.out.println(content);
//			EntityUtils.consume(response.getEntity());


//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
