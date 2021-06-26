package dataSet;

public interface IDataReader {

	public void setDataSource(String dataSource);
	
	public void readData(int lines, int columns, String sep);
	
	public String[][] requestData();
	
}
