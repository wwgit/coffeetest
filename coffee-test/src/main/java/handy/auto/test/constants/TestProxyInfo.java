package handy.auto.test.constants;

public abstract class TestProxyInfo {
	
	private static final String clazName = "handy.auto.test.proxies.TestProxy";
	private static final String[] parentClazNames = null;
	private static final String m_name_gen_chkpoints = "generateChkPoints";
	private static final String[] inParamTypes = {"java.util.List"};
	private static final String returnType = "java.util.List";
	private static String m_body_gen_chkpoints = "{"
			+"List<TestChkPoints> chkpoints = new ArrayList<TestChkPoints>();"
			+ "for(int i = 0; i < $1.size(); i++){"						
				+ "TestChkPoints t_cp = new ();"
			+ "}"
			+ "}";
	
	
	private static final String[] consBodies = null;
	

}
