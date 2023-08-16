package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		;
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("/Users/nabi/Downloads/dora.png");
			os = new FileOutputStream("/Users/nabi/Downloads/dora.copy.png");

			int data = -1;
			while ((data = is.read()) != -1) {
				os.write(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found" + e);
		} catch (IOException e) {
			System.err.println("error : " + e);
		} finally {

			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

		}
	}

}
