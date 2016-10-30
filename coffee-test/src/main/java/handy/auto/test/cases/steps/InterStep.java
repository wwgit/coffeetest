package handy.auto.test.cases.steps;

import java.util.List;

import handy.auto.test.interfaces.TestChkPoint;
import handy.auto.test.interfaces.TestResult;
import handy.auto.test.interfaces.TestStep;

public class InterStep extends TestStep {

	private String attri;
	
	
	public InterStep(int id, String desc, List<TestResult> expects,
			 List<TestChkPoint> points, String attribute) {
		super(id, desc, expects, points);
		this.setAttri(attribute);
	}
	
	@Override
	public List<TestResult> RunCurrentStep() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttri() {
		return attri;
	}

	public void setAttri(String attri) {
		this.attri = attri;
	}
	
	

}
