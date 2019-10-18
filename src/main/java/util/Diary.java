package main.java.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.text.Document;

public class Diary {
	public static void addDiary(String pathname, String title, String txt) {
		File dirFile = new File(pathname);
		BufferedWriter bufw = null;
		dirFile.mkdirs();
		File file = new File(dirFile, title + ".ky");
		try {
			bufw = new BufferedWriter(new FileWriter(file, true));
			bufw.write(txt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufw != null) {
				try {
					bufw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void read(File file, Document doc) {
		try (BufferedReader bufr = new BufferedReader(new FileReader(file));) {
			String txt = null;
			String line = System.getProperty("line.separator");
			while ((txt = bufr.readLine()) != null) {
				doc.insertString(doc.getLength(), txt + line, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
