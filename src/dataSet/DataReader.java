package dataSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader implements IDataReader {
	private String dataSourceBoard, dataSourceQuestions;
	private String[][] board, questions;

	public DataReader() {
		this.board = null;
		this.dataSourceBoard = null;
		this.dataSourceQuestions = null;
	}

	public void setDataSourceBoard(String dataSourceBoard) {
		this.dataSourceBoard = dataSourceBoard;
		if (dataSourceBoard == null) {
			board = null;
		}
		else {
			readBoard();
		}
	}
	
	public void setDataSourceQuestions(String dataSourceQuestions) {
		this.dataSourceQuestions = dataSourceQuestions;
		this.dataSourceQuestions = dataSourceQuestions;
		if (dataSourceQuestions == null) {
			questions = null;
		}
		else {
			readQuestions();
		}
	}

	public String[][] requestBoard() {
		return board;
	}
	
	public String[][] requestQuestions() {
		return questions;
	}
	
	public void readBoard() {
		board = readData(dataSourceBoard, 34, 6, ",");
	}
	
	public void readQuestions() {
		questions = readData(dataSourceQuestions, 10, 2, "&");
	}
	
   @SuppressWarnings("finally")
   private String[][] readData(String dataSource, int lines, int columns, String sep) {
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
			return data;
		}   
	}
}