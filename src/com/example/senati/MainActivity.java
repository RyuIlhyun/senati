package com.example.senati;

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
			
			helper.insert(helper, 	"一"	,	"いち"	,	"ひと,ひとつ"	,	"one"	,	"일, 하나"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"二"	,	"に"	,	"ふた,ふたつ"	,	"two"	,	"이, 둘"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"三"	,	"さん"	,	"み,みつ"	,	"three"	,	"삼, 셋"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"四"	,	"し"	,	"よん,よつ"	,	"four"	,	"사, 넷"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"五"	,	"ご"	,	"い,いつつ"	,	"five"	,	"오, 다섯"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"六"	,	"ろく"	,	"むい,むつ"	,	"six"	,	"육, 여섯"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"七"	,	"しち"	,	"なな,ななつ"	,	"seven"	,	"칠, 일곱"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"八"	,	"はち"	,	"やつ,よう"	,	"eight"	,	"팔, 여덟"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"九"	,	"く/きゅう"	,	"ここの,ここのつ"	,	"nine"	,	"구, 아홉"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"十"	,	"じゅう"	,	"と,とお"	,	"ten"	,	"열, 십"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"百"	,	"ひゃく"	,	"もも"	,	"hundred"	,	"백"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"千"	,	"せん"	,	"ち"	,	"thousand"	,	"천"	,	1	,	"数"	,	"number"	,	"숫자"	);
			helper.insert(helper, 	"日"	,	"じつ/にち"	,	"か,ひ"	,	"Sunday"	,	"일요일"	,	1	,	"曜日"	,	"day of week"	,	"요일"	);
			helper.insert(helper, 	"月"	,	"がつ/げつ"	,	"つき"	,	"Monday"	,	"월요일"	,	1	,	"曜日"	,	"day of week"	,	"요일"	);
			helper.insert(helper, 	"火"	,	"か"	,	"ひ,ほ"	,	"Tuesday"	,	"화요일"	,	1	,	"曜日"	,	"day of week"	,	"요일"	);
			helper.insert(helper, 	"水"	,	"すい"	,	"みず"	,	"Wednesday"	,	"수요일"	,	1	,	"曜日"	,	"day of week"	,	"요일"	);
			helper.insert(helper, 	"木"	,	"ぼく/もく"	,	"き,こ"	,	"Thursday"	,	"목요일"	,	1	,	"曜日"	,	"day of week"	,	"요일"	);
			helper.insert(helper, 	"金"	,	"きん/こん"	,	"かな,かね"	,	"Friday"	,	"금요일"	,	1	,	"曜日"	,	"day of week"	,	"요일"	);
			helper.insert(helper, 	"土"	,	"と/ど"	,	"つち"	,	"Saturday"	,	"토요일"	,	1	,	"曜日"	,	"day of week"	,	"요일"	);
			helper.insert(helper, 	"山"	,	"さん/せん"	,	"やま"	,	"mountain"	,	"산"	,	1	,	"自然"	,	"nature"	,	"자연"	);
			helper.insert(helper, 	"川"	,	"せん"	,	"かわ"	,	"river"	,	"강"	,	1	,	"自然"	,	"nature"	,	"자연"	);
			helper.insert(helper, 	"石"	,	"こく/しゃく/せき"	,	"いし"	,	"stone"	,	"돌"	,	1	,	"自然"	,	"nature"	,	"자연"	);
			helper.insert(helper, 	"空"	,	"くう"	,	"あく,あける,から,すく,そら"	,	"sky, air"	,	"하늘, 공기"	,	1	,	"自然"	,	"nature"	,	"자연"	);
			helper.insert(helper, 	"夕"	,	"せき"	,	"ゆう"	,	"evening"	,	"저녁"	,	1	,	"自然"	,	"nature"	,	"자연"	);
			helper.insert(helper, 	"天"	,	"てん"	,	"あま,あめ"	,	"sky, heaven"	,	"하늘, 천국"	,	1	,	"自然"	,	"nature"	,	"자연"	);
			helper.insert(helper, 	"雨"	,	"う"	,	"あま,あめ"	,	"rain"	,	"비"	,	1	,	"自然"	,	"nature"	,	"자연"	);
			helper.insert(helper, 	"大"	,	"たい/だい"	,	"おお,おおいに,おおきい"	,	"big"	,	"대, 크다"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"中"	,	"ちゅう"	,	"あたる,なか"	,	"average, inside"	,	"중, 평균, 속"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"小"	,	"しょう"	,	"お,こ,ちいさい"	,	"small"	,	"소, 작다"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"上"	,	"しょう/じょう"	,	"あがる,うえ,うわ,かみ,のぼる"	,	"up"	,	"상, 위"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"下"	,	"か/げ"	,	"くだる,さがる,した"	,	"down"	,	"하, 아래"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"右"	,	"う/ゆう"	,	"みぎ"	,	"right"	,	"우, 오른쪽"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"左"	,	"さ"	,	"ひだり"	,	"left"	,	"좌, 왼쪽"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"白"	,	"はく/びゃく"	,	"しら,しろ,しろい"	,	"white"	,	"백, 하얀색"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"青"	,	"しょう/せい"	,	"あお,あおい"	,	"blue"	,	"청, 파란색"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"赤"	,	"しゃく/せき"	,	"あか,あかい,あからむ,あからめる"	,	"red"	,	"적, 빨간색"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"円"	,	"えん"	,	"まるい"	,	"circle, round"	,	"원, 둥글다"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"玉"	,	"ぎょく"	,	"たま"	,	"ball"	,	"구슬, 공"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"音"	,	"いん/おん"	,	"おと,ね"	,	"sound"	,	"음, 소리"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"早"	,	"さっ/そう"	,	"はやい,はやまる,はやめる"	,	"fast"	,	"빠르다"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"正"	,	"しょう/せい"	,	"ただしい,ただす,まさ"	,	"correct, on the dot"	,	"바르다"	,	1	,	"様子"	,	"status"	,	"상태"	);
			helper.insert(helper, 	"貝"	,	"はい/ばい"	,	"かい"	,	"shellfish"	,	"조개"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"犬"	,	"けん"	,	"いぬ"	,	"dog"	,	"개"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"虫"	,	"ちゅう"	,	"むし"	,	"insect"	,	"곤충"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"花"	,	"か/け"	,	"はな"	,	"flower"	,	"꽃"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"竹"	,	"ちく"	,	"たけ"	,	"bamboo"	,	"대나무"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"生"	,	"しょう/せい"	,	"いかす,いきる,うむ,なま,はえる"	,	"living things"	,	"생, 날것"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"草"	,	"そう"	,	"くさ"	,	"grass"	,	"풀"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"林"	,	"りん"	,	"はやし"	,	"grove"	,	"수풀"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"森"	,	"しん"	,	"もり"	,	"forest"	,	"숲"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"田"	,	"でん"	,	"た"	,	"rice paddy"	,	"밭"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"年"	,	"ねん"	,	"とし"	,	"year"	,	"년"	,	1	,	"動物、植物"	,	"animal,plant"	,	"동물,식물"	);
			helper.insert(helper, 	"見"	,	"けん/げん"	,	"まみえる,みえる,みせる,みる"	,	"see"	,	"보다"	,	1	,	"動作"	,	"movement"	,	"동작"	);
			helper.insert(helper, 	"立"	,	"りつ/りゅう"	,	"たつ,たてる"	,	"stand"	,	"서다"	,	1	,	"動作"	,	"movement"	,	"동작"	);
			helper.insert(helper, 	"休"	,	"きゅう"	,	"やすまる,やすむ,やすめる"	,	"vacation"	,	"쉬다"	,	1	,	"動作"	,	"movement"	,	"동작"	);
			helper.insert(helper, 	"入"	,	"じゅ/にゅう"	,	"いる,いれる,はいる"	,	"go in"	,	"들어가다"	,	1	,	"動作"	,	"movement"	,	"동작"	);
			helper.insert(helper, 	"出"	,	"しゅつ/すい"	,	"だす,でる "	,	"go out"	,	"나가다"	,	1	,	"動作"	,	"movement"	,	"동작"	);
			helper.insert(helper, 	"口"	,	"く/こう"	,	"くち"	,	"mouth, entrance"	,	"입"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"人"	,	"じん/にん"	,	"ひと"	,	"human"	,	"사람"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"手"	,	"しゅ"	,	"た,て"	,	"hand"	,	"손"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"目"	,	"ぼく/もく"	,	"ま,め"	,	"eye"	,	"눈"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"耳"	,	"じ"	,	"みみ"	,	"ear"	,	"귀"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"足"	,	"そく"	,	"あし,たす,たりる,たる"	,	"leg"	,	"다리"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"子"	,	"し/す"	,	"こ"	,	"child"	,	"자식"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"男"	,	"だん/なん"	,	"おとこ"	,	"man"	,	"남자"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"女"	,	"じょ/にょ/にょう"	,	"おんな,め"	,	"woman"	,	"여자"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"王"	,	"おう"	,	"きみ　おおきみ"	,	"king"	,	"왕"	,	1	,	"人と体"	,	"human,body"	,	"사람과 신체"	);
			helper.insert(helper, 	"車"	,	"しゃ"	,	"くるま"	,	"car"	,	"차"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"文"	,	"ぶん/もん"	,	"あや,ふみ"	,	"sentence"	,	"문화"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"字"	,	"じ"	,	"あざ,あざな"	,	"character, letter"	,	"글자"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"本"	,	"ほん"	,	"もと"	,	"book"	,	"책, 오리지널"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"名"	,	"みょう/めい"	,	"な"	,	"name"	,	"이름"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"力"	,	"りき/りょく"	,	"ちから,つとめる"	,	"power"	,	"힘"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"学"	,	"がく"	,	"まなぶ"	,	"learning"	,	"배우다"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"校"	,	"きょう/こう"	,	"きょう,こう"	,	"school"	,	"학교"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"先"	,	"せん"	,	"さき"	,	"ahead"	,	"먼저"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"糸"	,	"し"	,	"いと"	,	"string, yarn"	,	"실"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"気"	,	"き/け"	,	"き,け"	,	"atmosphere"	,	"기, 기운"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"村"	,	"そん"	,	"むら"	,	"village"	,	"마을"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);
			helper.insert(helper, 	"町"	,	"ちょう"	,	"まち"	,	"town"	,	"거리"	,	1	,	"人と文化"	,	"human,culture"	,	"사람과 문화"	);

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
