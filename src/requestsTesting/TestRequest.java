package requestsTesting;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestRequest {
	@Test
	public void testRequest() throws ClientProtocolException, IOException {
		SoftAssert softAssert = new SoftAssert();
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpget = new HttpGet("https://www.facebook.com/");
		HttpResponse response = httpClient.execute(httpget);
		int responseSttus = response.getStatusLine().getStatusCode();
		Reporter.log("Response status is " + responseSttus, 3);
		int expectedStatus = 200;
		softAssert.assertEquals(responseSttus, expectedStatus);
		HttpEntity entity = response.getEntity();
		String contentType = entity.getContentType().toString();
		String expectedContentType = "text/html";
		softAssert.assertEquals(contentType, expectedContentType);
		String content = EntityUtils.toString(entity);
		StringBuffer sb = new StringBuffer();
		String cont = "id=\"facebook\"";
		softAssert.assertTrue(content.contains(sb.append(cont)));
		Reporter.getOutput();
	}

}
