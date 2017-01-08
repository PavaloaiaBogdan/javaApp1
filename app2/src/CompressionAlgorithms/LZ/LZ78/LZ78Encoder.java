package CompressionAlgorithms.LZ.LZ78;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

import application.model.BinaryStdOut;

class LZ78Encoder {
	private int len = 0;
	private Table78 table;
	private Vector<MappingLZ78> data;
	private String input = "";
	private String currString = "";
	private String nextChar = "";
	private int currIndex = 0;
	private int code = 0;
	private int newcode = 0;

	public LZ78Encoder(String paramString, Table78 paramTable78) {
		table = paramTable78;

		data = new Vector<MappingLZ78>();
		input = paramString;

		newEncodingLZ78(paramString);
	}

	private void printData() {
		for (MappingLZ78 m : data) {
			System.out.println( "<"+m.getCodeNum() + "," + m.getCodeWord()+">");
		}
	}

	private void printTable() {
		System.out.println("table data :");
		System.out.println("-----------------------------");
		int i = 0;
		for (String tab : table.getTable()) {
			if (!tab.equals(""))
				System.out.println(i + ":" + tab);
			i++;
		}
		System.out.println("-----------------------------");
	}

	public void newEncodingLZ78(String paramString) {
		input = paramString;
		len = input.length();

		table.clear();
		table.initial();

		if (!data.isEmpty()) {
			data.removeAllElements();
		}
		if (len != 0) {
			currString = "";
			nextChar = "";
			currIndex = 0;
			while (currIndex < len) {
				encodeProcess();
			}
		}
//		printData();
//		printTable();
	}

	public void encodeProcess() {
		currString = "";
		currString = input.substring(currIndex, currIndex + 1);

		if (table.rootExist(currString) < 0) {
			table.addRootToTables(currString);
			newcode = table.rootExist(currString);
			updateResultData(currIndex, 0, "C( " + currString + " )", newcode, 1);
			currIndex += 1;
		} else {
			code = table.rootExist(currString);
			int i = 1;
			do {
				if (currIndex + 1 >= len)
					break;
				currString = input.substring(currIndex, currIndex + 1 + i);
				if (table.rootExist(currString) != -1)
					code = table.rootExist(currString);
				i++;
			} while (table.rootExist(currString) >= 0);
			currString = table.getEntry(code);
			currIndex += currString.length();
			if (currIndex < len) {
				nextChar = input.substring(currIndex, currIndex + 1);
				if (table.rootExist(nextChar) >= 0) {
					table.addRootToTables(currString + nextChar);
					newcode = table.rootExist(currString + nextChar);
					updateResultData(currIndex - currString.length(), code,"C( " + table.getEntry(table.rootExist(nextChar))+" )",
							newcode, currString.length());
				} else {
					table.addRootToTables(currString + nextChar);
					newcode = table.rootExist(currString + nextChar);

					updateResultData(currIndex, code, "C( " + nextChar + " )", newcode, currString.length());
				}
				currIndex += 1;
			} else {
				updateResultData(currIndex, code, Integer.toString(0), -1, currString.length());
			}
		}
	}

	public void updateResultData(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4) {
		data.addElement(new MappingLZ78(paramInt1, paramInt2, paramString, paramInt3, paramInt4));
	}

	public Vector<MappingLZ78> getDataVector() {
		return data;
	}

	public static void main(String[] args) {

		File selectedFile = new File("C:\\Users\\Bogdan\\Desktop\\test.txt");
		if (selectedFile != null) {
			StringBuilder temp = new StringBuilder();
			try {
				for (String line : Files.readAllLines(Paths.get(selectedFile.getAbsolutePath()))) {
					temp.append(line);
				}
				String s = new String(temp);
				new LZ78Encoder(s, new Table78());
			} catch (IOException e) {
			}
		}
		FileOutputStream out = null;
		try {
			 out = new FileOutputStream("C:\\Users\\Bogdan\\Desktop\\text1.txt");
		} catch (FileNotFoundException e) {}

		new BinaryStdOut(out);
		BinaryStdOut.write("c",8);
		BinaryStdOut.write(56, 8);
		BinaryStdOut.flush();
	}
}