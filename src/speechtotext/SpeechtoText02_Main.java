package speechtotext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;

public class SpeechtoText02_Main {

			  public static void main(String[] args) throws FileNotFoundException {
			    SpeechToText service = new SpeechToText();
			    service.setUsernameAndPassword("b33bea4d-0cbf-4928-b72c-b9f193fc4f02", "t7AaLjHnUhGS");

			    SpeechtoText02_lib slib = new SpeechtoText02_lib(new File("audio/track06.mp3"));
	    		SpeechRecognitionResults transcript = slib.getTranscript();
	    		//System.out.println(transcript);
	    		slib.getJson(transcript);

			  }
	}
