package ejemplo;

import java.io.IOException;

public class ejemploNotepad {

		public static void main(String[] args) {
			Runtime r=Runtime.getRuntime();
			String com="gedit";
			Process p;
			try {
				p=r.exec(com);
			} catch (IOException e) {
				System.out.println("Error en: "+com);
			}
		}
}
