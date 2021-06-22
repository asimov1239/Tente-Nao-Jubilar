package dataSet;

public interface IDataReader {

	public void setDataSourceBoard(String dataSourceBoard);
	
	public void setDataSourceQuestions(String dataSourceQuestions);

	public String[][] requestBoard();
	
	public String[][] requestQuestions();
	
}
