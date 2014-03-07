package com.senapapa.baby2;

import android.os.Bundle;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.ads.*;

public class MainActivity extends Activity {

	private AdView adView;
	
	public static final String preferences_name = "jword_conf";
	public SharedPreferences preferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*
		// Create the adView
	    adView = new AdView(this, AdSize.BANNER, "a1530ea42bc175b");

	    // Lookup your LinearLayout assuming it's been given
	    // the attribute android:id="@+id/mainLayout"

	    TableRow layout = (TableRow)findViewById(R.id.tableRow2);

	    // Add the adView to it
	    layout.addView(adView);
	    
	    // Create an ad request. Check logcat output for the hashed device ID to
	    // get test ads on a physical device.
	    AdRequest adRequest = new AdRequest();
	    adRequest.addTestDevice(AdRequest.TEST_EMULATOR);

	    // Initiate a generic request to load it with an ad
	    adView.loadAd(new AdRequest());
	    */
		
		AdView adView = (AdView)this.findViewById(R.id.ad);
		adView.loadAd(new AdRequest());
		
		preferences = getSharedPreferences(preferences_name, Service.MODE_PRIVATE);
		int db_set_flg = preferences.getInt("app_ver", 0);
		
		if(db_set_flg == 0) {
		//if(true) {
			SharedPreferences.Editor editor = preferences.edit();
			editor.putInt("app_ver", 1);
			editor.commit();
			
			MySQLiteOpenHelper helper = new MySQLiteOpenHelper(MainActivity.this, "basic_jwords_1.db", null, 1);
			
			//db = helper.getWritableDatabase ();
	        //db.execSQL ("drop table "+TABLE_NAME);
	        //db.close ();
			
			//SQLiteDatabase db = helper.getWritableDatabase();
			//db.delete("t_word", null, null);
			
			helper.insert(helper,	"夜"	,	"や"	,	"よ·よる"	,	"night"	,	"밤"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"昼"	,	"ちゅう"	,	"ひる"	,	"daytime"	,	"낮"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"朝"	,	"ちょう"	,	"あさ·あした"	,	"morning"	,	"아침"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"北"	,	"ほく"	,	"きた"	,	"north"	,	"북쪽"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"南"	,	"な·なん"	,	"みなみ"	,	"south"	,	"남쪽"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"東"	,	"とう"	,	"あずま·ひがし"	,	"east"	,	"동쪽"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"西"	,	"さい·せい"	,	"にし"	,	"west"	,	"서쪽"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"春"	,	"しゅん"	,	"はる"	,	"spring"	,	"봄"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"夏"	,	"か·げ"	,	"なつ"	,	"summer"	,	"여름"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"秋"	,	"しゅう"	,	"あき·とき"	,	"autumn"	,	"가을"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"冬"	,	"とう"	,	"ふゆ"	,	"winter"	,	"겨울"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"風"	,	"ふ·ふう"	,	"かざ·かぜ"	,	"wind"	,	"바람"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"谷"	,	"こく"	,	"たに"	,	"valley"	,	"산골짜기.골짜기 모양을 이룬 것・골"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"池"	,	"ち"	,	"いけ"	,	"pond"	,	"못・연못"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"地"	,	"じ·ち"	,	"つち"	,	"ground,land"	,	"땅.지면"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"星"	,	"しょう·せい"	,	"ほし"	,	"star"	,	"별.세월"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"雪"	,	"せつ"	,	"すすぐ·ゆき"	,	"snow"	,	"눈"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"雲"	,	"うん"	,	"くも"	,	"Cloud"	,	"구름"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"晴"	,	"せい"	,	"はらす·はれる"	,	"Sunny"	,	"하늘이 갬・날씨가 좋음"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"野"	,	"や"	,	"の"	,	"Field"	,	"들・논밭"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"原"	,	"げん"	,	"はら·もと "	,	"Original"	,	"사물의 시작・처음・기원・본래"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"岩"	,	"がん"	,	"いわ"	,	"Rock"	,	"바위"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"海"	,	"かい"	,	"うみ"	,	"Sea"	,	"바다"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"里"	,	"り"	,	"さと"	,	"Village"	,	"마을・촌락・시골"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"回"	,	"え·かい"	,	"かえる·まわす·まわる·めぐる"	,	"Time"	,	"횟수・회"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"内"	,	"だい·ない"	,	"うち"	,	"Inside"	,	"안・내부・속"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"外"	,	"がい·げ"	,	"そと·はずす·はずれる·ほか"	,	"Outside"	,	"밖・바깥・겉・외부"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"茶"	,	"さ·ちゃ"	,	"ちゃ"	,	"Tea"	,	"차・찻잎"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"黒"	,	"こく"	,	"くろ·くろい"	,	"Black"	,	"검은 빛깔・검정"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"黄"	,	"おう·こう"	,	"き·こ"	,	"Yellow"	,	"노랑"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"色"	,	"しき·しょく"	,	"いろ"	,	"Color"	,	"색・빛"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"形"	,	"ぎょう·けい"	,	"かた·かたち"	,	"Form"	,	"모양・형상・꼴・형체"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"丸"	,	"がん"	,	"まる·まるい·まるめる"	,	"Circle"	,	"동그라미・공・원"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"線"	,	"せん"	,	"せん"	,	"Line"	,	"선・가늘고 긴 것"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"点"	,	"てん"	,	"つく·つける·ともす"	,	"Point"	,	"점・점수"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"絵"	,	"え·かい"	,	"え"	,	"Picture"	,	"그림"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"図"	,	"ず·と "	,	"はかる"	,	"Figure"	,	"도면・도형"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"画"	,	"え·かく·が"	,	"えがく·くぎる"	,	"Picture"	,	"그림"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"紙"	,	"し"	,	"かみ"	,	"Paper"	,	"종이"	,	2	,	"自然・図・色"	,	"nature・map・color"	,	"자연・지도・색"	);
			helper.insert(helper,	"間"	,	"かん·けん"	,	"あいだ·ま"	,	"Time"	,	"사이"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"分"	,	"ふん·ぶ·ぶん"	,	"わかつ·わかる·わかれる·わける"	,	"Minute"	,	"분・분수"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"時"	,	"し·じ"	,	"とき"	,	"When"	,	"시간・시각"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"午"	,	"ご"	,	"うま·ひる"	,	"Horse"	,	"오・낮 12시"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"今"	,	"きん·こん"	,	"いま"	,	"Now"	,	"지금・이제・현재"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"週"	,	"しゅう"	,	"しゅう"	,	"Week"	,	"주・7일간"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"曜"	,	"よう"	,	"よう"	,	"Sunday"	,	"빛나다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"読"	,	"とう·とく·どく"	,	"よむ"	,	"Read"	,	"읽다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"聞"	,	"ぶん·もん"	,	"きく·きこえる"	,	"Hear"	,	"듣다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"話"	,	"わ"	,	"はなし·はなす"	,	"Story"	,	"이야기・말"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"会"	,	"え·かい"	,	"あう"	,	"Meeting"	,	"모임・회・단체"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"活"	,	"かつ"	,	"いきる"	,	"Active"	,	"삶・살림"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"行"	,	"あん·ぎょう·こう"	,	"いく·おこなう·ゆく"	,	"Line"	,	"행・글자의 가로·세로의 줄"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"記"	,	"き"	,	"しるす"	,	"Ki"	,	"기록・적는 일"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"書"	,	"しょ"	,	"かく"	,	"Calligraphy"	,	"글씨를 씀・쓰는법"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"教"	,	"きょう"	,	"おしえる·おそわる"	,	"Professor"	,	"가르치다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"作"	,	"さ·さく"	,	"つくる"	,	"Work"	,	"만들다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"思"	,	"し"	,	"おぼす·おもう"	,	"Think"	,	"생각"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"言"	,	"げん·ごん"	,	"いう·こと"	,	"Word"	,	"말・이야기"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"来"	,	"らい"	,	"きたす·きたる·くる"	,	"Future"	,	"오다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"知"	,	"ち"	,	"しる"	,	"Knowledge"	,	"앎・지각・지식"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"合"	,	"かっ·がっ·ごう"	,	"あう·あわす·あわせる"	,	"Synthesis"	,	"합・합하다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"食"	,	"しょく·じき"	,	"くう·くらう·たべる"	,	"Eclipse"	,	"식사・음식・먹는 양"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"当"	,	"とう"	,	"あたる·あてる"	,	"This"	,	"도리에 맞음・그 일에 해당함"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"用"	,	"よう"	,	"もちいる"	,	"Use"	,	"용도・용무・용건・일"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"引"	,	"いん"	,	"ひく·ひける"	,	"Argument"	,	"끌다・당기다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"切"	,	"さい·せつ"	,	"きる·きれる"	,	"Off"	,	"끊다・간절함"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"帰"	,	"き"	,	"かえす·かえる"	,	"Null"	,	"돌아가다・돌아오다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"通"	,	"つ·つう"	,	"かよう·とおす·とおる"	,	"Through"	,	"그 방면에 훤함・통하다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"走"	,	"そう"	,	"はしる"	,	"Strike Dip Rake Mo"	,	"달리다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"歩"	,	"ふ·ぶ·ほ"	,	"あゆむ·あるく"	,	"Step"	,	"걸음,걷다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"止"	,	"し"	,	"とどめる·とまる·とめる·やむ·やめる"	,	"Stop"	,	"그치다,멈추다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"交"	,	"こう"	,	"かわす·まざる·まじる·まじわる·まぜる"	,	"Exchange"	,	"사귐・교제"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"考"	,	"こう"	,	"かんがえる"	,	"Considered"	,	"생각함"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"答"	,	"とう"	,	"こたえ·こたえる"	,	"Answer"	,	"대답・해답・답안"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"鳴"	,	"めい"	,	"なく·ならす·なる"	,	"Tinnitus"	,	"울리다・소리나다・떨치다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"買"	,	"ばい"	,	"かう"	,	"Purchase"	,	"사다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"売"	,	"ばい·まい"	,	"うる·うれる"	,	"Sales"	,	"팔다"	,	2	,	"時間・動き"	,	"time・verb"	,	"시간・움직임"	);
			helper.insert(helper,	"兄"	,	"きょう·けい"	,	"あに"	,	"Brother"	,	"형・오빠"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"弟"	,	"だい·てい·で"	,	"おとうと"	,	"Brother"	,	"남동생・아우"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"妹"	,	"まい"	,	"いもうと"	,	"Sister"	,	"누이동생"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"姉"	,	"し"	,	"あね"	,	"Sister"	,	"언니・손위 누이"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"元"	,	"がん·げん"	,	"はじめ·もと"	,	"Yuan"	,	"처음・기원・본디・본래"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"親"	,	"しん"	,	"おや·したしい·したしむ"	,	"Parent"	,	"육친・근친・친함"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"母"	,	"ぼ·も"	,	"はは"	,	"Mother"	,	"모친・어머니"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"父"	,	"ふ"	,	"ちち"	,	"Father"	,	"아버지"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"顔"	,	"がん·げん"	,	"かお"	,	"Face"	,	"얼굴・낯・얼굴 표정"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"頭"	,	"ず·と·とう"	,	"あたま·かしら"	,	"Head"	,	"머리・두부"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"首"	,	"しゅ"	,	"くび"	,	"Neck"	,	"목・모가지"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"体"	,	"たい·てい"	,	"からだ"	,	"Body"	,	"몸・육체・신체"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"自"	,	"し·じ"	,	"おのずから·みずから·より"	,	"Own"	,	"자신・스스로"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"心"	,	"しん"	,	"こころ"	,	"Heart"	,	"마음・느낌・기분・의사"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"友"	,	"ゆう"	,	"とも"	,	"Friend"	,	"친구・벗・동무"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"光"	,	"こう"	,	"ひかり·ひかる"	,	"Light"	,	"빛・서광"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"肉"	,	"にく"	,	"しし"	,	"Meat"	,	"살・동물의 근육・고기"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"歌"	,	"か"	,	"うた·うたう"	,	"Song"	,	"노래"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"声"	,	"しょう·せい"	,	"こえ·こわ"	,	"Voice"	,	"목소리"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"弱"	,	"じゃく·にゃく"	,	"よわい·よわまる·よわめる·よわる"	,	"Weak"	,	"약함・약한 사람"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"強"	,	"きょう·ごう"	,	"しいる·つよい·つよまる·つよめる"	,	"Strength"	,	"강・세력이 강함"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"近"	,	"きん·こん"	,	"ちかい"	,	"Near"	,	"가깝다"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"遠"	,	"えん·おん"	,	"とおい"	,	"Distant"	,	"멀다"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"多"	,	"た"	,	"おおい"	,	"Multi-"	,	"많음"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"少"	,	"しょう"	,	"すくない·すこし"	,	"Small"	,	"적음"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"太"	,	"た·たい"	,	"ふとい·ふとる"	,	"Thick"	,	"크다"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"細"	,	"さい"	,	"こまか·こまかい·ほそい·ほそる"	,	"Fine"	,	"가늘다,작다"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"古"	,	"こ"	,	"いにしえ·ふるい·ふるす"	,	"Antiquity"	,	"낡음.헌 것"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"新"	,	"しん"	,	"あたらしい·あらた·にい"	,	"New"	,	"새로움.새로운 것"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"後"	,	"こう·ご"	,	"あと·うしろ·おくれる·のち"	,	"Later"	,	"뒤,뒤쪽,후방"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"前"	,	"ぜん"	,	"まえ"	,	"Before"	,	"앞,먼저"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"直"	,	"じき·ちょく"	,	"ただちに·なおす·なおる"	,	"Direct"	,	"바름,곧음,직접"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"高"	,	"こう"	,	"たか·たかい·たかまる·たかめる"	,	"High"	,	"높다"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"長"	,	"ちょう"	,	"おさ·ながい"	,	"Head"	,	"우두머리・긴・오랜"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"半"	,	"はん"	,	"なかば"	,	"Half"	,	"반・절반"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"同"	,	"どう"	,	"おなじ"	,	"Same"	,	"같음"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"毎"	,	"まい"	,	"ごと·ごとに"	,	"Every"	,	"매・그때마다의"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"楽"	,	"がく·らく"	,	"たのしい·たのしむ"	,	"Ease"	,	"편안함・안락함・용이함・쉬움"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"明"	,	"みょう·めい"	,	"あかす·あからむ·あかり·あかるい"	,	"Ming"	,	"분명함・밝음"	,	2	,	"人・様子"	,	"family・status"	,	"사람・상태"	);
			helper.insert(helper,	"園"	,	"えん"	,	"その"	,	"Garden"	,	"원(유치원·공원등, 원의이름을 가진 설비·조직)"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"公"	,	"く·こう"	,	"おおやけ·きみ"	,	"Public"	,	"공・공공・사회・국가"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"門"	,	"もん"	,	"かど"	,	"Gate"	,	"문・대문・출입구"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"家"	,	"か·け"	,	"いえ·や"	,	"Home"	,	"집・주택・자택"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"船"	,	"せん"	,	"ふな·ふね"	,	"Ship"	,	"배・선박"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"市"	,	"し"	,	"いち"	,	"City"	,	"시・번화한 거리・도회"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"国"	,	"こく"	,	"くに"	,	"Country"	,	"나라・국가"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"京"	,	"きょう·きん·けい"	,	"みやこ"	,	"Kyoto"	,	"서울・수도"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"道"	,	"とう·どう"	,	"みち"	,	"Road"	,	"길.도로.도중"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"店"	,	"てん"	,	"たな·みせ"	,	"Shop"	,	"가게・상점・점포"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"場"	,	"じょう"	,	"ば"	,	"Place"	,	"장소・곳・자리・때"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"広"	,	"こう"	,	"ひろい·ひろがる·ひろげる·ひろまる"	,	"Wide"	,	"넓다・크다・많다"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"寺"	,	"じ"	,	"てら"	,	"Temple"	,	"절"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"社"	,	"しゃ"	,	"やしろ"	,	"Shrine"	,	"회사・단체"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"戸"	,	"こ"	,	"と"	,	"Door"	,	"문짝・대문・집의 출입구"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"室"	,	"しつ"	,	"むろ"	,	"Room"	,	"방"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"算"	,	"さん"	,	"かぞえる"	,	"Calculation"	,	"주판・셈함・계산"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"計"	,	"けい"	,	"はからう·はかる"	,	"Total"	,	"계・계획・합계"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"万"	,	"ばん·まん"	,	"よろず"	,	"Ten thousand"	,	"만・일만.수가 많음"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"数"	,	"す·すう"	,	"かず·かぞえる"	,	"Number"	,	"수・숫자"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"矢"	,	"し"	,	"や"	,	"Arrow"	,	"화살・힐책·공격등의 방향"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"弓"	,	"きゅう"	,	"ゆみ"	,	"Bow"	,	"활.궁술"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"刀"	,	"とう"	,	"かたな"	,	"Sword"	,	"외날의 칼・큰 칼・검"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"工"	,	"く·こう"	,	"たくみ"	,	"Engineering"	,	"공사・공정"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"科"	,	"か"	,	"しな·とが"	,	"Family"	,	"과.교육·학문 등 분야 등을 나타내는 구분"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"理"	,	"り"	,	"おさめる·ことわり"	,	"Management"	,	"법칙・원리・이유・이치・도리"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"組"	,	"そ"	,	"くみ·くむ"	,	"Set"	,	"세트・쌍・짝"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"何"	,	"か"	,	"なに·なん"	,	"What"	,	"왜・어째서・무엇때문에"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"電"	,	"でん"	,	"いなずま"	,	"Power"	,	"번개.전기"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"汽"	,	"き"	,	"き"	,	"Brackish"	,	"수증기"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"番"	,	"ばん"	,	"つがい·つがう"	,	"Turn"	,	"순서・차례・지키는 일・파수꾼"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"才"	,	"さい·ざい"	,	"さい·ざい"	,	"Sai"	,	"타고난 능력・소질"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"語"	,	"ぎょ·ご"	,	"かたらう·かたる"	,	"Word"	,	"말・언어・말씨"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"麦"	,	"ばく"	,	"むぎ"	,	"Wheat"	,	"보리・밀・귀리"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"米"	,	"べい·まい"	,	"こめ·よね"	,	"Rice"	,	"쌀"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"方"	,	"ほう"	,	"かた·ならべる·まさに"	,	"Person"	,	"방면・방향・쪽"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"台"	,	"たい·だい"	,	"うてな"	,	"Stand"	,	"높은전각・물건을 올려놓는 대"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"角"	,	"かく"	,	"かど·すみ·つの"	,	"Corner"	,	"모난 귀퉁이・구석"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"牛"	,	"ぎゅう·ご"	,	"うし"	,	"Cattle"	,	"소"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"馬"	,	"ば·め "	,	"うま·ま"	,	"Horse"	,	"말"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"毛"	,	"もう"	,	"け"	,	"Hair"	,	"털.체모"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"羽"	,	"う"	,	"は·はね"	,	"Feather"	,	"날개・새털・깃"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"鳥"	,	"ちょう"	,	"とり"	,	"Birds"	,	"새・조류"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);
			helper.insert(helper,	"魚"	,	"ぎょ"	,	"うお·さかな"	,	"Fish"	,	"물고기・생선"	,	2	,	"住まい・文化・生物"	,	"living・culture・living things"	,	"주거・문화・생물"	);



			helper.close();
		}		
		Button button;
		
		button = (Button) findViewById(R.id.startBtn);
		button.setOnClickListener(mStartListener);
		
		button = (Button) findViewById(R.id.listBtn);
		button.setOnClickListener(mListListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	View.OnClickListener mStartListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, DetailActivity.class);
			startActivity(intent);
		}
		
	};
	
	View.OnClickListener mListListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, ListActivity.class);
			startActivity(intent);
			
		}
		
	};
	
	@Override
	  public void onDestroy() {
	    if (adView != null) {
	      adView.destroy();
	    }
	    super.onDestroy();
	  }

}
