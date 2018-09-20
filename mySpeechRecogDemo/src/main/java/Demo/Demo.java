package Demo;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;


public class Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        
        //
        //configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        System.out.println(configuration.getSampleRate());
        
        configuration.setGrammarPath("C://Users/Luis Rivera Doi/Desktop/grammars.gram");
		configuration.setGrammarName("grammar");
		configuration.setUseGrammar(true);
   
        
        
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
     // Start recognition process pruning previously cached data.
     recognizer.startRecognition(true);
     SpeechResult result;// = recognizer.getResult();
     // Pause recognition process. It can be resumed then with startRecognition(false).
     //recognizer.stopRecognition();
     
        while ((result = recognizer.getResult()) != null) {
	    System.out.format("Hypothesis: %s\n", result.getHypothesis());

	}
        
	recognizer.stopRecognition();
	
	
	
	
    }

}

/*




public class TranscriberDemo {       

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

	StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
	InputStream stream = new FileInputStream(new File("test.wav"));

        recognizer.startRecognition(stream);
	SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
	    System.out.format("Hypothesis: %s\n", result.getHypothesis());
	}
	recognizer.stopRecognition();
    }
}





*/