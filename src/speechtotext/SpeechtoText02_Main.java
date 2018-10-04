package speechtotext;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;

public class SpeechtoText02_Main {

			  public static void main(String[] args) throws FileNotFoundException {
			    SpeechToText service = new SpeechToText();
			    service.setUsernameAndPassword("1821004", "1821004");

			    File audio = new File("audio/info-lady1_info-lady1-datawoyomikondeimasu1.mp3");
			    RecognizeOptions options = new RecognizeOptions.Builder()
			    	.model("ja-JP_BroadbandModel")
			        .audio(audio)
			        .contentType(RecognizeOptions.ContentType.AUDIO_MP3)
			        .build();
			    SpeechRecognitionResults transcript = service.recognize(options).execute();

			    System.out.println(transcript);
			  }
	}
