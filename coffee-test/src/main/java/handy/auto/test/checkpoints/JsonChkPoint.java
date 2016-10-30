package handy.auto.test.checkpoints;

import handy.auto.test.interfaces.TestChkPoint;
import handy.auto.test.interfaces.TestResult;
import handy.tools.files.JsonHelper;

public class JsonChkPoint extends TestChkPoint {

	@Override
	public TestResult CheckTestResult(TestResult expectedResult,
									  TestResult actualResult) {
		// TODO Auto-generated method stub
		
		TestResult result = jsonFormatChk(actualResult);		
		return result;
	}

		
	public TestResult jsonFormatChk(TestResult actualResult) {
		TestResult result = new TestResult();
		
		result.setPass(JsonHelper.canBeJsonObj(actualResult.getResultDesc()));
		if(!result.isPass()) {
			result.setPass(JsonHelper.canBeJsonArray(actualResult.getResultDesc()));
			if(!result.isPass()) {
				result.setResultDesc("Json format is Not valid !\r\n" + actualResult.getResultDesc());
				return result;
			}
		}
	
		return result;
	}

}
