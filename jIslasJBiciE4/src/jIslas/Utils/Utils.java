package jIslas.Utils;

import java.io.FileReader;
import java.io.IOException;

public class Utils {

	public static StringBuffer getContent(String pathContent)
			throws IOException {
		java.io.FileReader entrada = null;
		StringBuffer str=new StringBuffer();
		try {
			entrada = new FileReader(pathContent);
			int c;
			while ((c = entrada.read()) != -1) {
				str.append((char) c);
			}
		} catch (IOException ex) {
			throw (ex);
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException ex) {
				}
			}
		}
		return str;

	}

}
