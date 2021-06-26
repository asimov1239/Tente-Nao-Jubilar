package dataSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader implements IDataReader {
	private String dataSource;
	private String[][] data;

	public DataReader() {
		this.data = null;
		this.dataSource = null;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
		if (dataSource == null) {
			data = null;
		}
	}

	public String[][] requestData() {
		return data;
	}

   public void readData(int lines, int columns, String sep) {
		String[][] data = null;
		try {
			BufferedReader file = new BufferedReader(new FileReader(dataSource));
			String line = file.readLine();
			int i = 0;
			data = new String[lines][columns];
			while (line != null) {
				data[i] = line.split(sep);
				line = file.readLine();
				i++;
			}
			file.close();
		} catch (IOException erro) {
			erro.printStackTrace();
		}
		finally {
			this.data = data;;
		}   
	}
}