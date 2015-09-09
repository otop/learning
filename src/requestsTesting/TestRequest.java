package requestsTesting;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestRequest {
	@Test
	public void testRequest() throws ClientProtocolException, IOException{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpget = new HttpGet("https://www.facebook.com/");
		HttpResponse response = httpClient.execute(httpget);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		System.out.println(responseString);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(response.getStatusLine(), "200");
		Reporter.getCurrentTestResult();
	}

}
