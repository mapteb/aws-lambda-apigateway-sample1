package example;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Hello implements RequestHandler<Request, Response> {

	@Override
	public Response handleRequest(Request req, Context context) {
		Response res = new Response();
		res.setBody("Hello queryString param#1 value = " + req.getQueryStringParameters().getOne() + ", param#2 value = " + req.getQueryStringParameters().getTwo());
		res.setBase64Encoded(false);
		res.setStatusCode(200);
		return res;
	}
}

class QueryParams {

	private String one;
	private String two;

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Request {

	private QueryParams queryStringParameters;

	public QueryParams getQueryStringParameters() {
		return queryStringParameters;
	}

	public void setQueryStringParameters(QueryParams queryStringParameters) {
		this.queryStringParameters = queryStringParameters;
	}

}

class Response {
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public boolean isBase64Encoded() {
		return base64Encoded;
	}

	public void setBase64Encoded(boolean base64Encoded) {
		this.base64Encoded = base64Encoded;
	}

	private String body;
	private int statusCode;
	private boolean base64Encoded;
	private Map<String, String> headers;
}

class ResponseBody {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}