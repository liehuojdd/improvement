package jmeter.asser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import jdk.jfr.events.FileWriteEvent;

public class TxtWriter {
	private File file;
	private String charset="UTF-8";
	
	/*./File/new.txt(folder File should be exits)
	 * D:\\bak\\workspace\\improve190703\\new.txt
	 * */
	public TxtWriter(String path) {
		try {
			file=new File(path);
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String ReadTxt() {
		
		try {
			FileInputStream fileInputStream=new FileInputStream(file);
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream, charset);
			BufferedReader bufferReader=new BufferedReader(inputStreamReader);
			
			StringBuffer sb=new StringBuffer();
			String text=null;
			while((text=bufferReader.readLine())!=null) {
				sb.append(text);
			}
			return sb.toString();
		//} catch (FileNotFoundException e,UnsupportedEncodingException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Boolean WriteTxt(String content) {
		try {
			FileWriter fw=new FileWriter(file);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			fw.close();
			System.out.println("test done!");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void WriteTxt2(String content) {
		try {
			FileOutputStream fileOutPutStream=new FileOutputStream(file);
			fileOutPutStream.write(content.getBytes());
			fileOutPutStream.flush();
			fileOutPutStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
