
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpModule {
	// 라이브러리 초기화
	private static OkHttpClient client = new OkHttpClient();
	
	// 요청한 url 로 GET 방식으로 요청하는 방식
	public static String requestGet(String url) {
		// GET 요청을 위한 request header 만들기.
		Request request = new Request.Builder()
				.url(url)
				.build();
		
		// 기본 result 를 "" 로 설정하여, request 에 실패한 경우, 빈 값을 리턴하도록 하기 위한 result 를 리턴함.
		String result = "";
		
		try {
			// 비동기적으로 request 를 실행한다.
			// 웹으로부터 요청이 올때까지 아래의 코드에서 머물러 있음.
			Response response = client.newCall(request).execute();
			result = response.body().string();
		}catch(Exception e) {
			// 에러가 난 경우, 로그로 출력하도록 한다.
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 요청한 url 로 GET 방식 요청하여 xml 데이터를 받는 방법
	public static Document requestXmlGet(String url) {
		// XML 을 얻기 위한 클래스 초기화
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(url);
			
			// root tag 설정
			doc.getDocumentElement().normalize();
			
			// Document 형태로 리턴하여 받는 쪽에서 값을 얻는거는 별도로 하도록 한다.
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 에러가 발생한 경우 null 이 리턴됨.
		return null;
	}
}

