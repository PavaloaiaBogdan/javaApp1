package CompressionAlgorithms.LZ.LZ77;


public class LZ77Decoder {
	private String input = "";
	private String output = "";

	public LZ77Decoder(String input) {
		this.input = input;
		this.output = this.decode();
	}
	
	public String getOutput(){
		return this.output;
	}

	private String decode() {
		StringBuilder sb = new StringBuilder(input);
		int startIndex = 0;
		int endIndex = 0;
		while (startIndex >= 0) {
			startIndex = sb.indexOf("<", endIndex - 1);
			endIndex = sb.indexOf(">", startIndex);
			if (startIndex < 0)
				break;
			String pair = sb.substring(startIndex + 1, endIndex);
			if (pair.length() < 2)
				continue;
			int offset = 0;
			int length = 0;
			try {
				offset = Integer.parseInt(pair.split(",")[0]);
				length = Integer.parseInt(pair.split(",")[1]);
			} catch (NumberFormatException e) {
				continue;
			}
			sb.replace(startIndex, endIndex + 1, sb.substring(startIndex - offset, startIndex - offset + length));

		}

		return sb.toString();

	}
/*
	public static void main(String[] args) {

		File selectedFile = new File("C:\\Users\\Bogdan\\Desktop\\test.txt");
		if (selectedFile != null) {
			StringBuilder temp = new StringBuilder();
			try {
				for (String line : Files.readAllLines(Paths.get(selectedFile.getAbsolutePath()))) {
					temp.append(line);
				}
				String s = new String(temp);
				LZ77Decoder lz = new LZ77Decoder(s);
				// System.out.println(lz.output);
			} catch (IOException e) {
			}
		}
	}
 */
 
}
