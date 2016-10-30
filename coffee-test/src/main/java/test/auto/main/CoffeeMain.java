package test.auto.main;

import handy.auto.test.constants.MathChkPointInfo;
import handy.auto.test.interfaces.TestChkPoint;
import handy.tools.aop.BasicClazDesc;
import handy.tools.aop.BasicMethodDesc;
import handy.tools.interfaces.AspectHandler;
import handy.tools.interfaces.ClassFactory;
import handy.tools.interfaces.FileHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javassist.ClassPool;

public class CoffeeMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//DataFile dataFile = null;
		
		//String[] data = new String[26];
		//Scanner sc = new Scanner(System.in);
		/*while(sc.hasNextLine()) {
			System.out.println("output:" + sc.nextLine());
		}*/
		
		
		/*
		 * example of reading Contents from File
		 * 
		 * */
		//String result = JsonHelper.findTargetInJsonFile("D:\\test2.json", "123123");		
		
		long startTime = System.currentTimeMillis();
		//String contents2 = FileHelper.readFileContents("D:\\test3.txt");
		String contents = FileHelper.readContentsFrmFile("D:\\test2.json", "utf-8",1024*1024);
		long endTime = System.currentTimeMillis();
		System.out.println("reading complete,using total time:" + (endTime-startTime));
		//String contents = sb.toString();
		//sb.delete(0, sb.length());
		
		//System.out.println(contents);
		
		
		/*
		 * 
		 * example of using javassist - aop programing
		 * 
		 * */
		
		
		ClassFactory.getInstance().replaceMethod("handy.tools.aop.InstGenerator", 
				"newInstance","{List obj = new ArrayList<>();return obj;}"
				, new String[]{}, "java.util.List");
		
		//GenInstance maker = new InstGenerator();
		
		
		ClassFactory.getInstance().buildClazz(MathChkPointInfo.getClazInfo("int"),new String[]{"handy.auto.test.interfaces.TestResult"});
		
		//TestChkPoint tcp = new MathChkPoint();
		
		System.out.println("change class method logic");
		
		ClassFactory.getInstance().insertAspect("handy.auto.test.aop.checkpoints.MathChkPoint", "smaller",
												"{System.out.println(\"hello modifier\");}", "before");
		
		
		//System.out.println(System.getProperty("java.class.path"));
		//System.out.println(System.getProperty("user.dir"));
		//Class cName = Class.forName("handy.auto.test.aop.ExampleChkPoint");
		//Method m = cName.getDeclaredMethod(methodName);
		
		//Object obj = cName.newInstance();
		
		//m.invoke(obj);
		
		while(true) {
			Thread.sleep(1000);
		}
		
		//System.out.println("key found,related value: " + result);
		//System.out.println("reading contents: " + contents);
		//fnioPack.CloseReadResources();
		//fnioPack.CloseWriteResources();

		
		//System.out.println("avg: " + MathHelper.getAverage(data));
		//System.out.println("StandardDevition: " + MathHelper.getStandardDevition(data));
		
		//IndicatorCalcHelper.getBollIndicators(data, 2);
		
		//System.out.println("MB from main: " + IndicatorCalcHelper.BollMB(data));
		//System.out.println("UP frm main: " + IndicatorCalcHelper.BollUP(data, 2));
		//System.out.println("DN frm main: " + IndicatorCalcHelper.BollDN(data, 2));

		
		
		/*
		try {
			dataFile = new ExcelFile("D:\\Book4.xlsx");
			//((ExcelFile)dataFile).getAllSheetNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("hello world");
		try {
			((ExcelFile)dataFile).getAllSheetNames();
			String[] values = ((ExcelFile)dataFile).getRowValues(0, 0);
			for(int i = 0; i < values.length; i ++) {
				//System.out.println(values[i]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dataFile.closeStreams();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
