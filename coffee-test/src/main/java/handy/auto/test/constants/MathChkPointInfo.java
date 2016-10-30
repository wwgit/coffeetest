package handy.auto.test.constants;

import handy.tools.aop.BasicClazDesc;
import handy.tools.aop.BasicMethodDesc;

import java.util.ArrayList;
import java.util.List;

public abstract class MathChkPointInfo {

	public static final String clazName = "handy.auto.test.aop.checkpoints.MathChkPoint";
	public static final String[] parentClazNames = new String[]{"handy.auto.test.interfaces.TestChkPoint"};
	
	private static String[] methodBodies;
	
	public static List<BasicMethodDesc> getBasicMethodDesces(String inParamType) {
		
		String[] symbols = new String[]{"==","<",">","!="};
		String[] names = new String[]{"equal","smaller","bigger","notEqual"};
		
		String[] bodies = getBasicMethodBodies(symbols);
		List<BasicMethodDesc> bmds = new ArrayList<BasicMethodDesc>();
		for(int i = 0; i < bodies.length; i++) {
			
			BasicMethodDesc bmd = new BasicMethodDesc();
			bmd.inParamsType = new String[]{inParamType, inParamType};
			bmd.returnType = "handy.auto.test.interfaces.TestResult";
			bmd.methodAccess = "public";
			bmd.methodName = names[i];
			bmd.methodBody = bodies[i];			
			bmds.add(bmd);
			
		}
		
		return bmds;
		
	}
	
	public static BasicClazDesc getClazInfo(String inParamType) {
		
		BasicClazDesc bcd = new BasicClazDesc();
		bcd.clazName = clazName;
		bcd.interfaces = new ArrayList<String>();
		for(int i = 0 ; i < parentClazNames.length; i++) {
			bcd.interfaces.add(parentClazNames[i]);
		}
		bcd.construDesc = null;
		bcd.methodsDesc = getBasicMethodDesces(inParamType);
				
		return bcd;
	}
	
	private static String[] getBasicMethodBodies(String[] symbols) {
		methodBodies = new String[symbols.length];
		for(int i = 0; i < symbols.length; i++) {
			methodBodies[i] = setMethodBody(symbols[i]);
		}
		return methodBodies;
	}
	
	private static String setMethodBody(String symbol) {
		String body = "{"
						+ "TestResult result = new TestResult();"
						+ "if($1 " + symbol + " $2) {"
								+ "result.setPass(true);return result;"
							+ "};"
						+ "result.setPass(false);return result;"
						+ "}";
		return body;
	}
	
	
	
	
}
