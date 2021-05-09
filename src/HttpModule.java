
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpModule {
	// ���̺귯�� �ʱ�ȭ
	private static OkHttpClient client = new OkHttpClient();
	
	// ��û�� url �� GET ������� ��û�ϴ� ���
	public static String requestGet(String url) {
		// GET ��û�� ���� request header �����.
		Request request = new Request.Builder()
				.url(url)
				.build();
		
		// �⺻ result �� "" �� �����Ͽ�, request �� ������ ���, �� ���� �����ϵ��� �ϱ� ���� result �� ������.
		String result = "";
		
		try {
			// �񵿱������� request �� �����Ѵ�.
			// �����κ��� ��û�� �ö����� �Ʒ��� �ڵ忡�� �ӹ��� ����.
			Response response = client.newCall(request).execute();
			result = response.body().string();
		}catch(Exception e) {
			// ������ �� ���, �α׷� ����ϵ��� �Ѵ�.
			e.printStackTrace();
		}
		
		return result;
	}
	
	// ��û�� url �� GET ��� ��û�Ͽ� xml �����͸� �޴� ���
	public static Document requestXmlGet(String url) {
		// XML �� ��� ���� Ŭ���� �ʱ�ȭ
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(url);
			
			// root tag ����
			doc.getDocumentElement().normalize();
			
			// Document ���·� �����Ͽ� �޴� �ʿ��� ���� ��°Ŵ� ������ �ϵ��� �Ѵ�.
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ������ �߻��� ��� null �� ���ϵ�.
		return null;
	}
}

