package handy.auto.test.interfaces;

import java.util.HashMap;
import java.util.List;

public abstract class TestCase {

	private String testName;
	private long testId;
	private List<TestStep> Steps;
	//private HashMap<String,TestChkPoint> chkPoints; 
		
	public abstract List<TestResult> RunCase();
	
}
