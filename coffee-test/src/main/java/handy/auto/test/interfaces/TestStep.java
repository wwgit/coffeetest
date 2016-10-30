package handy.auto.test.interfaces;

import java.util.ArrayList;
import java.util.List;

public abstract class TestStep {
	
	private int stepId;
	private String stepDesc;
	private List<TestResult> expectedResults;
	private List<TestChkPoint> chkPoints;
	
	public TestStep(int id, String desc, List<TestResult> expects, List<TestChkPoint> points) {
		this.setStepId(id);
		this.setStepDesc(desc);
		this.setExpectedResults(expects);
		this.setChkPoints(points);
	}
	
	public abstract List<TestResult> RunCurrentStep();

	public int getStepId() {
		return stepId;
	}

	public void setStepId(int stepId) {
		this.stepId = stepId;
	}

	public String getStepDesc() {
		return stepDesc;
	}

	public void setStepDesc(String stepDesc) {
		this.stepDesc = stepDesc;
	}

	public List<TestResult> getExpectedResults() {
		return expectedResults;
	}

	public void setExpectedResults(List<TestResult> expectedResults) {
		this.expectedResults = expectedResults;
	}

	public List<TestChkPoint> getChkPoints() {
		return chkPoints;
	}

	public void setChkPoints(List<TestChkPoint> chkPoints) {
		this.chkPoints = chkPoints;
	}
	
	
	public List<TestResult> DoStep() throws Exception {
		
		if(null == expectedResults || expectedResults.size() < 1) {
			throw new Exception("No expected result for step " + stepDesc);
		}
		if(null == chkPoints || chkPoints.size() < 1) {
			throw new Exception("No check points for step " + stepDesc);
		}
		
		List<TestResult> actualResults = RunCurrentStep();
		List<TestResult> finalResults = new ArrayList<TestResult>();
		
		for(int i = 0; i < getChkPoints().size(); i++) {
			TestResult ret = getChkPoints().get(i).CheckTestResult(getExpectedResults().get(i), 
																	actualResults.get(i));
			if(null != ret) {
				finalResults.add(ret);
			}
			
		}
		return finalResults;
		
	}
	 
}
