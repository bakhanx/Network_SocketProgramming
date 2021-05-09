import java.awt.Color;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

//�Է� import
import javax.swing.JTextField;


import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// UI �� �����ϱ� ����  JFrame �� ��ӹ޴� Ŭ������ �����.
public class MainUI extends JFrame {

	// ������ ȭ�鿡 �ѷ��� list �� ����� �� ������, �ش� �𵨿� �����͸� ������ ����Ʈ�� ����ȴ�.
	private DefaultListModel<String> dataModel;
	
	//������� isoCode
	String isoKor[] = { "	����	", "	����	", "	���̾Ƴ�	", "	�����	", "	���� ��	", "	�������	",
			"	���׸���	", "	��	", "	�׷�����	", "	�׸���	", "	�׸�����	", "	���	", "	��Ϻ���	",
			"	���̺��	", "	�����	", "	����������	", "	����	", "	������	", "	��������ī ��ȭ��	", "	�״�����	",
			"	�״������ ��ƿ����	", "	����	", "	�븣����	", "	���� ��	", "	����Į������	", "	��������	", "	�Ͽ쿡	",
			"	������	", "	��ī���	", "	���ѹα�	", "	����ũ	", "	���̴�ī ��ȭ��	", "	���̴�ī ����	", "	����	",
			"	��Ƽ��	", "	�����	", "	���̺�����	", "	��Ʈ���	", "	���þ�	", "	���ٳ�	", "	������	",
			"	�����Ͽ�	", "	�縶�Ͼ�	", "	����θ�ũ	", "	���ϴ�	", "	�����	", "	�����ƴϾ�	", "	�����ٽ�Ÿ��	",
			"	���ٰ���ī��	", "	����Ƽ��ũ	", "	���� ����	", "	����Ʈ	", "	��ī��	", "	���ɵ��Ͼ� ��ȭ��	", "	������	",
			"	�����̽þ�	", "	����	", "	�� ��	", "	�߽���	", "	����	", "	�����	", "	�𸮼Ž�	", "	��Ÿ��	",
			"	�����ũ	", "	���׳ױ׷�	", "	��Ʈ����	", "	������	", "	�����	", "	��Ÿ	", "	����	", "	�̱�	",
			"	�̱��� ���� ����	", "	�̱��� �������Ϸ���	", "	�̾Ḷ	", "	��ũ�γ׽þ� ����	", "	�ٴ�����	", "	�ٷ���	",
			"	�ٺ��̵���	", "	��Ƽĭ �ñ�	", "	���ϸ�	", "	��۶󵥽�	", "	���´�	", "	����	", "	���׼�����	",
			"	��Ʈ��	", "	���⿡	", "	����罺	", "	������	", "	�����Ͼ� �츣ü���	", "	�����ͳ�	", "	�������	",
			"	�η��	", "	�θ�Ű���ļ�	", "	�κ� ��	", "	��ź	", "	�ϸ����Ƴ� ����	", "	�Ұ�����	", "	�����	",
			"	��糪��	", "	����	", "	����ƶ���	", "	��콺������ ��콺������ġ ����	", "	�긶����	", "	������ ��������	",
			"	���ǿ��� ��Ŭ��	", "	�����϶�	", "	���װ�	", "	�������	", "	���̼�	", "	����Ʈ��þ�	",
			"	����Ʈ��Ʈ �׷�����	", "	����ƮŰ�� �׺�	", "	����Ʈ�ﷹ��	", "	�Ҹ�����	", "	�ַθ� ����	", "	����	",
			"	������	", "	������ī	", "	���߹ٸ� �Ḷ��	", "	����������	", "	������	", "	������	", "	������	",
			"	���ι�Ű��	", "	���κ��Ͼ�	", "	�ø���	", "	�ÿ��󸮿�	", "	�̰�����	", "	�ƶ����̸�Ʈ	", "	�Ʒ��	",
			"	�Ƹ��޴Ͼ�	", "	�Ƹ���Ƽ��	", "	�Ƹ޸�ĭ����	", "	���̽�����	", "	����Ƽ	", "	���Ϸ���	", "	������������	",
			"	�������Ͻ�ź	", "	�ȵ���	", "	�˹ٴϾ�	", "	������	", "	�Ӱ��	", "	��Ƽ�� �ٺδ�	", "	�ޱж�	",
			"	����Ʈ����	", "	������Ͼ�	", "	���⵵��	", "	��Ƽ���Ǿ�	", "	����ٵ���	", "	����	",
			"	������ �������Ϸ���	", "	������ �ε��� ����	", "	����	", "	����	", "	����Ʈ���ϸ���	", "	����Ʈ����	",
			"	�µζ�	", "	�ö��� ����	", "	�и��� ǶƢ��	", "	�丣��	", "	�찣��	", "	������	", "	���Ű��ź	",
			"	��ũ���̳�	", "�̶�ũ", "	�̶�	", "	�̽���	", "	����Ʈ	", "	��Ż����	", "	�ε�	",
			"	�ε��׽þ�	", "	�Ϻ�	", "	�ڸ���ī	", "	����	", "	���� ��	", "	���� ���	", "	�������������ιΰ�ȭ��	",
			"	������	", "	�߾Ӿ�����ī ��ȭ��",  "	��ȭ�α�	"	,
			"	��ȭ�ιΰ�ȭ��	", "	����Ƽ	", "	�������	", "	���ٺ��	", "	����	", "	ü��	", "	ĥ��	", "	ī�޷�	",
			"	ī��������	", "	ī���彺ź	", "	īŸ��	", "	į�����	", "	ĳ����	", "	�ɳ�	", "	���̸� ����	",
			"	�ڸ��	", "	�ڽ�Ÿ��ī	", "	���ڽ� ����	", "	��Ʈ��ξƸ�	", "	�ݷҺ��	", "	��� ��ȭ��	",
			"	��� ���� ��ȭ��	", "	���	", "	�����Ʈ	", "	�� ����	", "	ũ�ξ�Ƽ��	", "	ũ�������� ��	",
			"	Ű���⽺��ź	", "	Ű���ٽ�	", "	Ű���ν�	", "	Ÿ��	", "	Ÿ��Ű��ź	", "	ź�ڴϾ�	",
			"	��ũ�� ����Ŀ�� ����	", "	��Ű	", "	���	", "	���̶��	", "	�밡	", "	����ũ�޴Ͻ�ź	", "	���߷�	",
			"	Ƣ����	", "	Ʈ���ϴٵ� ��ٰ�	", "	�ĳ���	", "	�Ķ����	", "	��Ű��ź	", "	��Ǫ�� �����	", "	�ȶ��	",
			"	�ȷ���Ÿ��	", "	��� ����	", "	���	", "	��������	", "	��Ŭ���� ����	", "	������	", "	Ǫ�����丮��	",
			"	������	", "	�������� ��Ƴ�	", "	�������� ���ο� ���� ����	", "	�������� �����׽þ�	", "	����	", "	�ɶ���	",
			"	�ʸ���	", "	���ɾ� ����	", "	��� �Ƶ��ε� ����	", "	�밡��	", "	ȫ��	" };

	String isoEng[] = { "	GHA	", "	GAB	", "	GUY	", "	GMB	", "	GGY	", "	GLP	", "	GTM	", "	GUM	",
			"	GRD	", "	GRC	", "	GRL	", "	GIN	", "	GNB	", "	NAM	", "	NRU	", "	NGA	", "	ATA	",
			"	SSD	", "	ZAF	", "	NLD	", "	ANT	", "	NPL	", "	NOR	", "	NFK	", "	NCL	", "	NZL	",
			"	NIU	", "	NER	", "	NIC	", "	KOR	", "	DNK	", "	DOM	", "	DMA	", "	DEU	", "	TLS	",
			"	LAO	", "	LBR	", "	LVA	", "	RUS	", "	LBN	", "	LSO	", "	REU	", "	ROU	", "	LUX	",
			"	RWA	", "	LBY	", "	LTU	", "	LIE	", "	MDG	", "	MTQ	", "	MHL	", "	MYT	", "	MAC	",
			"	MKD	", "	MWI	", "	MYS	", "	MLI	", "	IMN	", "	MEX	", "	MCO	", "	MAR	", "	MUS	",
			"	MRT	", "	MOZ	", "	MNE	", "	MSR	", "	MDA	", "	MDV	", "	MLT	", "	MNG	", "	USA	",
			"	UMI	", "	VIR	", "	MMR	", "	FSM	", "	VUT	", "	BHR	", "	BRB	", "	VAT	", "	BHS	",
			"	BGD	", "	BMU	", "	BEN	", "	VEN	", "	VNM	", "	BEL	", "	BLR	", "	BLZ	", "	BIH	",
			"	BWA	", "	BOL	", "	BDI	", "	BFA	", "	BVT	", "	BTN	", "	MNP	", "	BGR	", "	BRA	",
			"	BRN	", "	WSM	", "	SAU	", "	SGS	", "	SMR	", "	STP	", "	SPM	", "	ESH	", "	SEN	",
			"	SRB	", "	SYC	", "	LCA	", "	VCT	", "	KNA	", "	SHN	", "	SOM	", "	SLB	", "	SDN	",
			"	SUR	", "	LKA	", "	SJM	", "	SWZ	", "	SWE	", "	CHE	", "	ESP	", "	SVK	", "	SVN	",
			"	SYR	", "	SLE	", "	SGP	", "	ARE	", "	ABW	", "	ARM	", "	ARG	", "	ASM	", "	ISL	",
			"	HTI	", "	IRL	", "	AZE	", "	AFG	", "	AND	", "	ALB	", "	DZA	", "	AGO	", "	ATG	",
			"	AIA	", "	ERI	", "	EST	", "	ECU	", "	ETH	", "	SLV	", "	GBR	", "	VGB	", "	IOT	",
			"	YEM	", "	OMN	", "	AUS	", "	AUT	", "	HND	", "	ALA	", "	WLF	", "	JOR	", "	UGA	",
			"	URY	", "	UZB	", "	UKR	", "	IRQ", "		IRN	", "	ISR	", "	EGY	", "	ITA	", "	IND	",
			"	IDN	", "	JPN	", "	JAM	", "	ZMB	", "	JEY	", "	GNQ	", "	PRK	", "	GEO	", "	CAF	",
			"	TWN	", "	CHN	", "	DJI	", "	GIB	", "	ZWE	", "	TCD	", "	CZE	", "	CHL	", "	CMR	",
			"	CPV	", "	KAZ	", "	QAT	", "	KHM	", "	CAN	", "	KEN	", "	CYM	", "	COM	", "	CRI	",
			"	CCK	", "	CIV	", "	COL	", "	COG	", "	COD	", "	CUB	", "	KWT	", "	COK	", "	HRV	",
			"	CXR	", "	KGZ	", "	KIR	", "	CYP	", "	THA	", "	TJK	", "	TZA	", "	TCA	", "	TUR	",
			"	TGO	", "	TKL	", "	TON	", "	TKM	", "	TUV	", "	TUN	", "	TTO	", "	PAN	", "	PRY	",
			"	PAK	", "	PNG	", "	PLW	", "	PSE	", "	FRO	", "	PER	", "	PRT	", "	FLK	", "	POL	",
			"	PRI	", "	FRA	", "	GUF	", "	ATF	", "	PYF	", "	FJI	", "	FIN	", "	PHL	", "	PCN	",
			"	HMD	", "	HUN	", "	HKG	" };
	
	public MainUI() {
		// UI �� ���� ������
		
		//isoCode ��������
		for(int i =0 ; i<isoKor.length; i++) {
			isoKor[i] = isoKor[i].trim();
			isoEng[i] = isoEng[i].trim();
		}
		
		// ������ ����
		setSize(1024, 720);
		// ���̾ƿ��� ���� ��ǥ�� �׸� �� �ֵ��� �ϱ� ���� ���̾ƿ� ���� ����
		setLayout(null);
		// Ÿ��Ʋ ����
		setTitle("���� ����溸 �����丮");

		// ���� ��ư ������ ���α׷� ���� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ������ ���� �Ұ�
		setResizable(false);

		// ȭ�� ����� ��ġ ����
		setLocationRelativeTo(null);
		
		//�Է� ��ġ ����
		JTextField inputIso = new JTextField();
		inputIso.setBounds(770, 580, 120, 40);
		
		//3���� ��ư
		JButton buttonGreen = new JButton(new ImageIcon("./green.png"));
		JButton buttonYellow = new JButton(new ImageIcon("./yellow.png"));
		JButton buttonRed = new JButton(new ImageIcon("./red.png"));
		
		//�ʱ�ȭ�� ��ư
		JButton buttonHome = new JButton("�ʱ�ȭ��");
		JButton buttonRefresh = new JButton("��ȸ");
		
		//��ư ũ�� �� ��ġ ����
		buttonGreen.setBounds(90, 100, 264, 250 );
		buttonYellow.setBounds(380, 100, 264, 250 );
		buttonRed.setBounds(670, 100, 264, 250 );
		
		buttonRefresh.setBounds(900, 580, 60, 40);
		buttonHome.setBounds(60, 580, 100, 40);
		
		//Green Button
		buttonGreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String line;
				line = String.format("���� �����Դϴ�");
			
				buttonGreen.setEnabled(false);
				buttonYellow.setEnabled(false);
				buttonRed.setEnabled(false);
				buttonHome.setEnabled(false);
				buttonRefresh.setEnabled(false);
				
				new Thread() {
					@Override
					public void run() {
						// ���� ������ ����
						dataModel.clear();
						
						final String API_KEY = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";
					
						//��ȸ������
						String iso = inputIso.getText();
						dataModel.addElement("====�������� ����Ʈ====");
						for (int i = 0; i < isoEng.length; i++) {

							String url = String.format(
									"http://apis.data.go.kr/1262000/CountryWarningHistoryService/getCountryHistoryList?serviceKey=%s"
											+ "&numOfRows=10&pageNo=1&isoCode1=%s&",
									API_KEY, isoEng[i]);

							Document res = HttpModule.requestXmlGet(url);
							
							
							NodeList ids = res.getElementsByTagName("id");
							
							String line = "";

							// getLength�� �溸 ���� ���� ��������� ������.
							if (ids.getLength() == 0) {
								line = String.format(isoKor[i++] + "\n");
								dataModel.addElement(line);
							}
						}
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {

						}
						// ��� ������ ���� �ڿ� ��ư�� �ٽ� Ȱ��ȭ ������.
						buttonHome.setEnabled(true);
						buttonRefresh.setEnabled(true);
					}
				}.start();
			}
		});
		
		//Yellow Button
		buttonYellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String line;
				line = String.format("��� �����Դϴ�");
				
				buttonGreen.setEnabled(false);
				buttonYellow.setEnabled(false);
				buttonRed.setEnabled(false);
				buttonHome.setEnabled(false);
				buttonRefresh.setEnabled(false);
				new Thread() {
					@Override
					public void run() {
						// ���� ������ ����
						dataModel.clear();
						
						final String API_KEY = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";
					
						//��ȸ������
						String iso = inputIso.getText();
						dataModel.addElement("====�������� ����Ʈ====");
						for (int i = 0; i < isoEng.length; i++) {

							String url = String.format(
									"http://apis.data.go.kr/1262000/CountryWarningHistoryService/getCountryHistoryList?serviceKey=%s"
											+ "&numOfRows=10&pageNo=1&isoCode1=%s&",
									API_KEY, isoEng[i]);

							Document res = HttpModule.requestXmlGet(url);
							
							
							NodeList ids = res.getElementsByTagName("id");
							
							String line = "";

							// getLength�� �溸 ���� ���� ��������� ������.
							if (ids.getLength() > 0 && ids.getLength() <5) {
								line = String.format(isoKor[i++] + "\n");
								dataModel.addElement(line);
							}
						}
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {

						}

						// ��� ������ ���� �ڿ� ��ư�� �ٽ� Ȱ��ȭ ������.
						buttonHome.setEnabled(true);
						buttonRefresh.setEnabled(true);

					}
				}.start();
			}
		});
		
		//Red Button
		buttonRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String line;
				line = String.format("���� �����Դϴ�");

				buttonGreen.setEnabled(false);
				buttonYellow.setEnabled(false);
				buttonRed.setEnabled(false);
				buttonHome.setEnabled(false);
				buttonRefresh.setEnabled(false);
				
				new Thread() {
					@Override
					public void run() {
						// ���� ������ ����
						dataModel.clear();
						
						final String API_KEY = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";
					
						//��ȸ������
						String iso = inputIso.getText();
						dataModel.addElement("====���豹�� ����Ʈ====");
						for (int i = 0; i < isoEng.length; i++) {

							String url = String.format(
									"http://apis.data.go.kr/1262000/CountryWarningHistoryService/getCountryHistoryList?serviceKey=%s"
											+ "&numOfRows=10&pageNo=1&isoCode1=%s&",
									API_KEY, isoEng[i]);

							Document res = HttpModule.requestXmlGet(url);
							NodeList ids = res.getElementsByTagName("id");
							
							String line = "";

							// getLength�� �溸 ���� ���� ��������� ������.
							if (ids.getLength() >= 5) {
								line = String.format(isoKor[i++] + "\n");
								dataModel.addElement(line);
							}
						}
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {

						}
						// ��� ������ ���� �ڿ� ��ư�� �ٽ� Ȱ��ȭ ������.
						buttonHome.setEnabled(true);
						buttonRefresh.setEnabled(true);
					}
				}.start();
			}
		});
		
		
		//�ʱ� ȭ�� ��ư ����
		// ��ư �̺�Ʈ ����
		buttonHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonHome.setEnabled(true);
			
				new Thread() {
					@Override
					public void run() {
						// ���� ������ ����
						dataModel.clear();
						buttonGreen.setEnabled(true);
						buttonYellow.setEnabled(true);
						buttonRed.setEnabled(true);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {

						}
					}
				}.start();
			}

		});

		// ��ȸ ��ư
		buttonRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				buttonGreen.setEnabled(false);
				buttonYellow.setEnabled(false);
				buttonRed.setEnabled(false);

				new Thread() {
					@Override
					public void run() {
						// ���� ������ ����
						dataModel.clear();

						final String API_KEY = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";

						//��ȸ������
						String iso = inputIso.getText();
						
						String isoCode;
						int num = 0;
						while(true) {
							if(iso.equals(isoKor[num])) {
								isoCode = isoEng[num];
								break;
							}
							num++;
						}
						
						// ������ page ������ �ѹ��� ������ ������ �����ؼ� ����ϰ� ,�ʿ�� ���� ����.
						String url = String.format(
								"http://apis.data.go.kr/1262000/CountryWarningHistoryService/getCountryHistoryList?serviceKey=%s"
								+ "&numOfRows=10&pageNo=1&isoCode1=%s&",
								API_KEY, isoCode);

			
						Document res = HttpModule.requestXmlGet(url);
						NodeList ids = res.getElementsByTagName("id");
						NodeList titles = res.getElementsByTagName("title");
						NodeList wrtDts = res.getElementsByTagName("wrtDt");
					
						String line;
						
						// head �κ��� �־��ֱ� ���� �κ�
						// ������ space ���� �ؾ� ����.
						dataModel.addElement(" ID                                                  Title    "
								+ "                			        							                         WrtDt");
						
						//getLength�� �溸 ���� ���� ��������� ������.
						if(ids.getLength() == 0) {
							dataModel.clear();
							line = String.format("���� �����Դϴ�\n �����ü�� ��õ�մϴ�.\n");
							dataModel.addElement(line);
							
							//���� ���� �� ��� ��õ �����ü
							dataModel.addElement(" ����                    ���̼���        "
									+ "                			        �����");
							final String API_KEY2 = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";
							
							String url2 = String.format(
									"https://openapi.gg.go.kr/ForeignCountryTour?%s",
									API_KEY2);
							
							Document res2 = HttpModule.requestXmlGet(url2);
							
							NodeList sigun_nms = res2.getElementsByTagName("SIGUN_NM");
							NodeList bizplc_nms = res2.getElementsByTagName("BIZPLC_NM");
							NodeList licenses = res2.getElementsByTagName("LICENSG_DE");
							
							for (int i = 0 ; i <sigun_nms.getLength(); ++i) {
								// ���⼭ Node �� org.w3c.dom.Node

								Node sigun_nm = sigun_nms.item(i);
								Node bizplc_nm = bizplc_nms.item(i);
								Node license = licenses.item(i);

								line = String.format(" %s           %s               %s   ",
										sigun_nm.getFirstChild().getNodeValue(),
										license.getFirstChild().getNodeValue(),
										bizplc_nm.getFirstChild().getNodeValue());

								// list�� �־��ش�.
								dataModel.addElement(line);
							
							}
						}
						
						else if(ids.getLength() > 5) {
							line = String.format("���� �����Դϴ�");
							dataModel.addElement(line);
						}
						else {
							line = String.format("��� �����Դϴ�");
							dataModel.addElement(line);
						}
								
						for (int i = 0 ; i <ids.getLength(); ++i) {
							// ���⼭ Node �� org.w3c.dom.Node

							Node id = ids.item(i);
							Node title = titles.item(i);
							Node wrtDt = wrtDts.item(i);
							
							line = String.format(" %s       %s              %s",
									id.getFirstChild().getNodeValue(),
									wrtDt.getFirstChild().getNodeValue(),
									title.getFirstChild().getNodeValue()
									);
						
							dataModel.addElement(line);
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {

							}
						}
						// ��� ������ ���� �ڿ� ��ư�� �ٽ� Ȱ��ȭ ������.
						buttonRefresh.setEnabled(true);
					}
				}.start();

				// ===========================================================
			}
		});

		// ����Ʈ ��ġ ���� �� �ʱ�ȭ, ��ũ�� ����
		JList<String> dataList = new JList<String>(new DefaultListModel<String>());
		JScrollPane scrollPane = new JScrollPane(dataList);
		scrollPane.setBounds(60, 60, 900, 500);

		// �ش� ����Ʈ�� ����� �� ���� �����Ѵ�.
		dataModel = (DefaultListModel<String>) dataList.getModel();

		// ��ư �� ����Ʈ�� UI �� �ֱ�
		add(buttonRefresh);
		add(buttonRed);
		add(buttonYellow);
		add(buttonGreen);
		add(buttonHome);
		add(scrollPane);
		add(inputIso);
	}

	// UI ���� �Լ�
	public void showUI() {
		setVisible(true);
	}
}
