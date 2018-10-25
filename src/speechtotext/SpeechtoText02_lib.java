package speechtotext;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;

//フィールドとコンストラクタをつくってライブラリ化する->再利用しやすい
public class SpeechtoText02_lib {
	//コンストラクタ：サービス、オプションの初期化
	//引数はAudioのパス
    SpeechToText service ;
    RecognizeOptions options = null;
	public SpeechtoText02_lib(File audio) {
	    service = new SpeechToText();
	    service.setUsernameAndPassword("b33bea4d-0cbf-4928-b72c-b9f193fc4f02", "t7AaLjHnUhGS");

		 try {
			    options = new RecognizeOptions.Builder()
				    	.model("ja-JP_BroadbandModel")
				        .audio(audio)
				        .contentType(RecognizeOptions.ContentType.AUDIO_MP3)
				        .build();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public SpeechRecognitionResults getTranscript() {
		SpeechRecognitionResults transcript = service.recognize(options).execute();
		return transcript;
}
	
	public void getJson (SpeechRecognitionResults transcript) {
		String s = String.valueOf(transcript);
	    ObjectMapper mapper = new ObjectMapper();
	    //JSONは毎回階層がかわるので、Mainに残す
	    try {
			JsonNode node = mapper.readTree(s);
			for (int i = 0; i < node.get("results").size(); i++) {
				String text = node.get("results").get(i).get("alternatives").get(0).get("transcript").toString();
				double jishin = node.get("results").get(i).get("alternatives").get(0).get("confidence").asDouble();
				System.out.println("Transcript: " + text);
				System.out.println("Confidence: " + jishin);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

    

}
