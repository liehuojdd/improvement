package jmeter.asser;

import txtWrite.*;

public class AssertTest {

	public static void main(String[] args) {
		
		String response_data = prev.getResponseDataAsString();
		String assert_data="科目${num}";
		TxtWrite writeData=new TxtWrite();
		if(response_data.indexOf(assert_data)!=-1)//请求的response中有包含自定义字符，则断言结果为false
		{
		    Failure=false;
		    String message="${__time(yyyy-MM-dd HH:mm:ss,)}   新建科目【"+assert_data+"】成功";
		    FailureMessage=message;
		    writeData.contentToTxt("D:/xykyInterfaceAutoTest.log",message);
		    
		}else
		{
		    Failure=true;
		    String message="${__time(yyyy-MM-dd HH:mm:ss,)}   新建科目【"+assert_data+"】失败----------";
		    String response="本次请求response数据："+prev.getResponseDataAsString()+"----------";
		    String need_assert="需要断言的数据："+assert_data;
		    FailureMessage=message+response+need_assert;
		    writeData.contentToTxt("D:/xykyInterfaceAutoTest.log",message+response+need_assert);
		}


	}

}
