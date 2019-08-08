package jmeter.asser;


public class AssertTest {

	public static void main(String[] args) {
		//String response_data = prev.getResponseDataAsString();
		String response_data = "";
		String assert_data="科目${num}";
		TxtWriter writeData=new TxtWriter("D:\\\\bak\\\\workspace\\\\improve190703\\\\new.txt");
		if(response_data.indexOf(assert_data)!=-1)//请求的response中有包含自定义字符，则断言结果为false
		{
		    //Failure=false;
		    String message="${__time(yyyy-MM-dd HH:mm:ss,)}   新建科目【"+assert_data+"】成功";
		    //FailureMessage=message;
		    writeData.WriteTxt(message);
		    
		}else
		{
		    //Failure=true;
		    String message="${__time(yyyy-MM-dd HH:mm:ss,)}   新建科目【"+assert_data+"】失败----------";
		    String response="本次请求response数据：prev.getResponseDataAsString()----------";
		    String need_assert="需要断言的数据："+assert_data;
		    //FailureMessage=message+response+need_assert;
		    writeData.WriteTxt(message+response+need_assert);
		}


	}

}
