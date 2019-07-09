package jmeter.encode;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Encode64 {
	public Encode64() {
		
	}
	public String Encode(String str) {
		String charset="UTF-8";
		String str1="";
		try {
			final Encoder encoder=Base64.getEncoder();
			final byte[] textByte=str.getBytes(charset);//java.lang.IllegalArgumentException
			str1=encoder.encodeToString(textByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str1;
	}
	public String Decode(String str) {
		String charset="UTF-8";
		String str1="";
		try {
			final Decoder decoder=Base64.getDecoder();
			byte[] decodeStr=decoder.decode(str);
			str1=new String(decodeStr,charset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str1;
	}
}
