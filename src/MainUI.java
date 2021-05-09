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

//입력 import
import javax.swing.JTextField;


import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// UI 를 설정하기 위해  JFrame 을 상속받는 클래스로 만든다.
public class MainUI extends JFrame {

	// 정보를 화면에 뿌려줄 list 에 연결된 모델 데이터, 해당 모델에 데이터를 넣으면 리스트에 저장된다.
	private DefaultListModel<String> dataModel;
	
	//국가명과 isoCode
	String isoKor[] = { "	가나	", "	가봉	", "	가이아나	", "	감비아	", "	건지 섬	", "	과들루프	",
			"	과테말라	", "	괌	", "	그레나다	", "	그리스	", "	그린란드	", "	기니	", "	기니비사우	",
			"	나미비아	", "	나우루	", "	나이지리아	", "	남극	", "	남수단	", "	남아프리카 공화국	", "	네덜란드	",
			"	네덜란드령 안틸레스	", "	네팔	", "	노르웨이	", "	노퍽 섬	", "	누벨칼레도니	", "	뉴질랜드	", "	니우에	",
			"	니제르	", "	니카라과	", "	대한민국	", "	덴마크	", "	도미니카 공화국	", "	도미니카 연방	", "	독일	",
			"	동티모르	", "	라오스	", "	라이베리아	", "	라트비아	", "	러시아	", "	레바논	", "	레소토	",
			"	레위니옹	", "	루마니아	", "	룩셈부르크	", "	르완다	", "	리비아	", "	리투아니아	", "	리히텐슈타인	",
			"	마다가스카르	", "	마르티니크	", "	마셜 제도	", "	마요트	", "	마카오	", "	마케도니아 공화국	", "	말라위	",
			"	말레이시아	", "	말리	", "	맨 섬	", "	멕시코	", "	모나코	", "	모로코	", "	모리셔스	", "	모리타니	",
			"	모잠비크	", "	몬테네그로	", "	몬트세랫	", "	몰도바	", "	몰디브	", "	몰타	", "	몽골	", "	미국	",
			"	미국령 군소 제도	", "	미국령 버진아일랜드	", "	미얀마	", "	미크로네시아 연방	", "	바누아투	", "	바레인	",
			"	바베이도스	", "	바티칸 시국	", "	바하마	", "	방글라데시	", "	버뮤다	", "	베냉	", "	베네수엘라	",
			"	베트남	", "	벨기에	", "	벨라루스	", "	벨리즈	", "	보스니아 헤르체고비나	", "	보츠와나	", "	볼리비아	",
			"	부룬디	", "	부르키나파소	", "	부베 섬	", "	부탄	", "	북마리아나 제도	", "	불가리아	", "	브라질	",
			"	브루나이	", "	사모아	", "	사우디아라비아	", "	사우스조지아 사우스샌드위치 제도	", "	산마리노	", "	상투메 프린시페	",
			"	생피에르 미클롱	", "	서사하라	", "	세네갈	", "	세르비아	", "	세이셸	", "	세인트루시아	",
			"	세인트빈센트 그레나딘	", "	세인트키츠 네비스	", "	세인트헬레나	", "	소말리아	", "	솔로몬 제도	", "	수단	",
			"	수리남	", "	스리랑카	", "	스발바르 얀마옌	", "	스와질란드	", "	스웨덴	", "	스위스	", "	스페인	",
			"	슬로바키아	", "	슬로베니아	", "	시리아	", "	시에라리온	", "	싱가포르	", "	아랍에미리트	", "	아루바	",
			"	아르메니아	", "	아르헨티나	", "	아메리칸사모아	", "	아이슬란드	", "	아이티	", "	아일랜드	", "	아제르바이잔	",
			"	아프가니스탄	", "	안도라	", "	알바니아	", "	알제리	", "	앙골라	", "	앤티가 바부다	", "	앵귈라	",
			"	에리트레아	", "	에스토니아	", "	에콰도르	", "	에티오피아	", "	엘살바도르	", "	영국	",
			"	영국령 버진아일랜드	", "	영국령 인도양 지역	", "	예멘	", "	오만	", "	오스트레일리아	", "	오스트리아	",
			"	온두라스	", "	올란드 제도	", "	왈리스 퓌튀나	", "	요르단	", "	우간다	", "	우루과이	", "	우즈베키스탄	",
			"	우크라이나	", "이라크", "	이란	", "	이스라엘	", "	이집트	", "	이탈리아	", "	인도	",
			"	인도네시아	", "	일본	", "	자메이카	", "	잠비아	", "	저지 섬	", "	적도 기니	", "	조선민주주의인민공화국	",
			"	조지아	", "	중앙아프리카 공화국",  "	중화민국	"	,
			"	중화인민공화국	", "	지부티	", "	지브롤터	", "	짐바브웨	", "	차드	", "	체코	", "	칠레	", "	카메룬	",
			"	카보베르데	", "	카자흐스탄	", "	카타르	", "	캄보디아	", "	캐나다	", "	케냐	", "	케이맨 제도	",
			"	코모로	", "	코스타리카	", "	코코스 제도	", "	코트디부아르	", "	콜롬비아	", "	콩고 공화국	",
			"	콩고 민주 공화국	", "	쿠바	", "	쿠웨이트	", "	쿡 제도	", "	크로아티아	", "	크리스마스 섬	",
			"	키르기스스탄	", "	키리바시	", "	키프로스	", "	타이	", "	타지키스탄	", "	탄자니아	",
			"	터크스 케이커스 제도	", "	터키	", "	토고	", "	토켈라우	", "	통가	", "	투르크메니스탄	", "	투발루	",
			"	튀니지	", "	트리니다드 토바고	", "	파나마	", "	파라과이	", "	파키스탄	", "	파푸아 뉴기니	", "	팔라우	",
			"	팔레스타인	", "	페로 제도	", "	페루	", "	포르투갈	", "	포클랜드 제도	", "	폴란드	", "	푸에르토리코	",
			"	프랑스	", "	프랑스령 기아나	", "	프랑스령 남부와 남극 지역	", "	프랑스령 폴리네시아	", "	피지	", "	핀란드	",
			"	필리핀	", "	핏케언 제도	", "	허드 맥도널드 제도	", "	헝가리	", "	홍콩	" };

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
		// UI 에 대한 설정들
		
		//isoCode 공백제거
		for(int i =0 ; i<isoKor.length; i++) {
			isoKor[i] = isoKor[i].trim();
			isoEng[i] = isoEng[i].trim();
		}
		
		// 사이즈 설정
		setSize(1024, 720);
		// 레이아웃을 절대 좌표로 그릴 수 있도록 하기 위해 레이아웃 설정 제거
		setLayout(null);
		// 타이틀 설정
		setTitle("국가 여행경보 히스토리");

		// 종료 버튼 누르면 프로그램 종료 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 사이즈 변경 불가
		setResizable(false);

		// 화면 가운데로 위치 설정
		setLocationRelativeTo(null);
		
		//입력 위치 설정
		JTextField inputIso = new JTextField();
		inputIso.setBounds(770, 580, 120, 40);
		
		//3가지 버튼
		JButton buttonGreen = new JButton(new ImageIcon("./green.png"));
		JButton buttonYellow = new JButton(new ImageIcon("./yellow.png"));
		JButton buttonRed = new JButton(new ImageIcon("./red.png"));
		
		//초기화면 버튼
		JButton buttonHome = new JButton("초기화면");
		JButton buttonRefresh = new JButton("조회");
		
		//버튼 크기 및 위치 설정
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
				line = String.format("안전 국가입니다");
			
				buttonGreen.setEnabled(false);
				buttonYellow.setEnabled(false);
				buttonRed.setEnabled(false);
				buttonHome.setEnabled(false);
				buttonRefresh.setEnabled(false);
				
				new Thread() {
					@Override
					public void run() {
						// 이전 데이터 제거
						dataModel.clear();
						
						final String API_KEY = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";
					
						//조회국가명
						String iso = inputIso.getText();
						dataModel.addElement("====안전국가 리스트====");
						for (int i = 0; i < isoEng.length; i++) {

							String url = String.format(
									"http://apis.data.go.kr/1262000/CountryWarningHistoryService/getCountryHistoryList?serviceKey=%s"
											+ "&numOfRows=10&pageNo=1&isoCode1=%s&",
									API_KEY, isoEng[i]);

							Document res = HttpModule.requestXmlGet(url);
							
							
							NodeList ids = res.getElementsByTagName("id");
							
							String line = "";

							// getLength로 경보 내역 수로 위험수위를 나눈다.
							if (ids.getLength() == 0) {
								line = String.format(isoKor[i++] + "\n");
								dataModel.addElement(line);
							}
						}
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {

						}
						// 모든 동작이 끝난 뒤에 버튼을 다시 활성화 시켜줌.
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
				line = String.format("경계 국가입니다");
				
				buttonGreen.setEnabled(false);
				buttonYellow.setEnabled(false);
				buttonRed.setEnabled(false);
				buttonHome.setEnabled(false);
				buttonRefresh.setEnabled(false);
				new Thread() {
					@Override
					public void run() {
						// 이전 데이터 제거
						dataModel.clear();
						
						final String API_KEY = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";
					
						//조회국가명
						String iso = inputIso.getText();
						dataModel.addElement("====안전국가 리스트====");
						for (int i = 0; i < isoEng.length; i++) {

							String url = String.format(
									"http://apis.data.go.kr/1262000/CountryWarningHistoryService/getCountryHistoryList?serviceKey=%s"
											+ "&numOfRows=10&pageNo=1&isoCode1=%s&",
									API_KEY, isoEng[i]);

							Document res = HttpModule.requestXmlGet(url);
							
							
							NodeList ids = res.getElementsByTagName("id");
							
							String line = "";

							// getLength로 경보 내역 수로 위험수위를 나눈다.
							if (ids.getLength() > 0 && ids.getLength() <5) {
								line = String.format(isoKor[i++] + "\n");
								dataModel.addElement(line);
							}
						}
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {

						}

						// 모든 동작이 끝난 뒤에 버튼을 다시 활성화 시켜줌.
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
				line = String.format("위험 국가입니다");

				buttonGreen.setEnabled(false);
				buttonYellow.setEnabled(false);
				buttonRed.setEnabled(false);
				buttonHome.setEnabled(false);
				buttonRefresh.setEnabled(false);
				
				new Thread() {
					@Override
					public void run() {
						// 이전 데이터 제거
						dataModel.clear();
						
						final String API_KEY = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";
					
						//조회국가명
						String iso = inputIso.getText();
						dataModel.addElement("====위험국가 리스트====");
						for (int i = 0; i < isoEng.length; i++) {

							String url = String.format(
									"http://apis.data.go.kr/1262000/CountryWarningHistoryService/getCountryHistoryList?serviceKey=%s"
											+ "&numOfRows=10&pageNo=1&isoCode1=%s&",
									API_KEY, isoEng[i]);

							Document res = HttpModule.requestXmlGet(url);
							NodeList ids = res.getElementsByTagName("id");
							
							String line = "";

							// getLength로 경보 내역 수로 위험수위를 나눈다.
							if (ids.getLength() >= 5) {
								line = String.format(isoKor[i++] + "\n");
								dataModel.addElement(line);
							}
						}
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {

						}
						// 모든 동작이 끝난 뒤에 버튼을 다시 활성화 시켜줌.
						buttonHome.setEnabled(true);
						buttonRefresh.setEnabled(true);
					}
				}.start();
			}
		});
		
		
		//초기 화면 버튼 설정
		// 버튼 이벤트 설정
		buttonHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonHome.setEnabled(true);
			
				new Thread() {
					@Override
					public void run() {
						// 이전 데이터 제거
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

		// 조회 버튼
		buttonRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				buttonGreen.setEnabled(false);
				buttonYellow.setEnabled(false);
				buttonRed.setEnabled(false);

				new Thread() {
					@Override
					public void run() {
						// 이전 데이터 제거
						dataModel.clear();

						final String API_KEY = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";

						//조회국가명
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
						
						// 나머지 page 정보나 한번에 보여줄 정보는 고정해서 사용하고 ,필요시 변경 가능.
						String url = String.format(
								"http://apis.data.go.kr/1262000/CountryWarningHistoryService/getCountryHistoryList?serviceKey=%s"
								+ "&numOfRows=10&pageNo=1&isoCode1=%s&",
								API_KEY, isoCode);

			
						Document res = HttpModule.requestXmlGet(url);
						NodeList ids = res.getElementsByTagName("id");
						NodeList titles = res.getElementsByTagName("title");
						NodeList wrtDts = res.getElementsByTagName("wrtDt");
					
						String line;
						
						// head 부분을 넣어주기 위한 부분
						// 구분은 space 으로 해야 보임.
						dataModel.addElement(" ID                                                  Title    "
								+ "                			        							                         WrtDt");
						
						//getLength로 경보 내역 수로 위험수위를 나눈다.
						if(ids.getLength() == 0) {
							dataModel.clear();
							line = String.format("안전 국가입니다\n 여행업체를 추천합니다.\n");
							dataModel.addElement(line);
							
							//안전 국가 일 경우 추천 여행업체
							dataModel.addElement(" 지역                    라이센스        "
									+ "                			        여행사");
							final String API_KEY2 = "7fc4ACWyyv3mG1tPaIduNC3m0hmr28VjKuShmyD9Y7kHvf7%2FnfrQRZoxQZ3qjC94Egx9AtlRPLkVLde%2FFWG98Q%3D%3D";
							
							String url2 = String.format(
									"https://openapi.gg.go.kr/ForeignCountryTour?%s",
									API_KEY2);
							
							Document res2 = HttpModule.requestXmlGet(url2);
							
							NodeList sigun_nms = res2.getElementsByTagName("SIGUN_NM");
							NodeList bizplc_nms = res2.getElementsByTagName("BIZPLC_NM");
							NodeList licenses = res2.getElementsByTagName("LICENSG_DE");
							
							for (int i = 0 ; i <sigun_nms.getLength(); ++i) {
								// 여기서 Node 는 org.w3c.dom.Node

								Node sigun_nm = sigun_nms.item(i);
								Node bizplc_nm = bizplc_nms.item(i);
								Node license = licenses.item(i);

								line = String.format(" %s           %s               %s   ",
										sigun_nm.getFirstChild().getNodeValue(),
										license.getFirstChild().getNodeValue(),
										bizplc_nm.getFirstChild().getNodeValue());

								// list에 넣어준다.
								dataModel.addElement(line);
							
							}
						}
						
						else if(ids.getLength() > 5) {
							line = String.format("위험 국가입니다");
							dataModel.addElement(line);
						}
						else {
							line = String.format("경계 국가입니다");
							dataModel.addElement(line);
						}
								
						for (int i = 0 ; i <ids.getLength(); ++i) {
							// 여기서 Node 는 org.w3c.dom.Node

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
						// 모든 동작이 끝난 뒤에 버튼을 다시 활성화 시켜줌.
						buttonRefresh.setEnabled(true);
					}
				}.start();

				// ===========================================================
			}
		});

		// 리스트 위치 설정 및 초기화, 스크롤 설정
		JList<String> dataList = new JList<String>(new DefaultListModel<String>());
		JScrollPane scrollPane = new JScrollPane(dataList);
		scrollPane.setBounds(60, 60, 900, 500);

		// 해당 리스트와 연결된 모델 값을 저장한다.
		dataModel = (DefaultListModel<String>) dataList.getModel();

		// 버튼 및 리스트를 UI 에 넣기
		add(buttonRefresh);
		add(buttonRed);
		add(buttonYellow);
		add(buttonGreen);
		add(buttonHome);
		add(scrollPane);
		add(inputIso);
	}

	// UI 띄우는 함수
	public void showUI() {
		setVisible(true);
	}
}
