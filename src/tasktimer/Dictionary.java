package tasktimer;

import java.io.InputStream;
/**
 * Read a text file.
 * @author  Nutcharuta Sihirunwong 5810545866
 *
 */
public class Dictionary {
	private static String DICTIONARY = "wordlist.txt";
	
	/**
	 * get wordAsStream in text file.
	 * @return InputStream from wordlist.txt
	 */
	public static InputStream getWordsAsStream() {
		return TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
	}
}
