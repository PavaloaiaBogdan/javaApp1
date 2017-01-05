package CompressionAlgorithms.LZ.LZ77;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

public class LZ77Encoder {

	private Vector<MappingLZ77> data;
	private String input = "";
	private char[] inputArray = new char[100];
	private int len = 0;
	private SearchBuffer sbuf;
	private LookAheadBuffer lbuf;
	// private static final int invalid = -1;
	private int bufsize;
	private String compressedText;

	public LZ77Encoder(String string) {
		this.input = string;
		this.data = new Vector<MappingLZ77>();
		this.sbuf = new SearchBuffer();
		this.lbuf = new LookAheadBuffer();
		this.bufsize = 10;
		this.newEncoding77(string);
		this.compressedText = this.outputCode();

	}

	public void encodeProcess() {
		int last_match_len = 0;
		int match_len = 0;
		int charIndex = 0;
		int offset = 0;
		int last_offset = 0;
		char current_char = inputArray[lbuf.get_lookstartbuf()];
		do {
			charIndex = input.lastIndexOf(current_char, lbuf.get_lookstartbuf() - last_offset - 1);
			last_offset = lbuf.get_lookstartbuf() - charIndex;
			last_match_len = get_length_of_match(charIndex, lbuf);
			if (charIndex < sbuf.get_searchstartbuf() || match_len >= last_match_len)
				continue;
			match_len = last_match_len;
			offset = lbuf.get_lookstartbuf() - charIndex;
		} while (charIndex >= sbuf.get_searchstartbuf());

		char next_char = inputArray[lbuf.get_lookstartbuf() + match_len];
		updateResultData(offset, match_len, next_char, lbuf.get_lookstartbuf());
		lbuf.setlookbufstart(lbuf.get_lookstartbuf() + match_len + 1);
		if (lbuf.get_lookstartbuf() < bufsize) {
			sbuf.setsbufstart(0);
		} else {
			sbuf.setsbufstart(lbuf.get_lookstartbuf() - bufsize);
		}
		sbuf.setsbufend(lbuf.get_lookendbuf() - bufsize);
	}

	public Vector<MappingLZ77> getDataVector() {
		return this.data;
	}

	public void VectorData() {
		for (MappingLZ77 m : data) {
			if (m.getLength() != 0) {
				System.out.println("<" + m.getOffset() + "," + m.getLength() + "," + m.getNextchar() + ">");
			} else {
				System.out.println(m.getNextchar());
			}
		}
	}
	
	public String getCompressedText(){
		return this.compressedText;
	}

	private String outputCode() {
		StringBuilder temp = new StringBuilder();
		StringBuilder coder = new StringBuilder();
		for (MappingLZ77 m : data) {
			int offset = m.getOffset();
			int length = m.getLength();
			char c = m.getNextchar();
			if (length > 0) {
				if(length>=2){
					coder.append("<"+offset+","+length+">"+c);
				}else{
					coder.append(temp.substring(temp.length() - offset, temp.length() - offset + length));
					coder.append(c);
				}
				temp.append(temp.substring(temp.length() - offset, temp.length() - offset + length));
				temp.append(c);
			} else {
				coder.append(c);
				temp.append(c);
			}
		}
		return new String(coder);
	}

	public int get_length_of_match(int n, LookAheadBuffer lookaheadBuffer) {
		boolean match = true;
		int matched = 0;
		int lbuffPosition = lookaheadBuffer.get_lookstartbuf();
		while (match && lbuffPosition < this.len && n != -1) {
			match = false;
			if (this.inputArray[n] == this.inputArray[lbuffPosition]) {
				match = true;
				++n;
				++lbuffPosition;
			}
			++matched;
		}
		return matched - 1;
	}

	public void newEncoding77(String text) {
		if (!this.data.isEmpty()) {
			this.data.removeAllElements();
		}
		this.input = text;
		this.inputArray = this.input.toCharArray();
		this.len = this.input.length();
		this.lbuf.setlookbufstart(0);
		this.lbuf.setlookbufend(this.bufsize);
		while (this.lbuf.get_lookstartbuf() < this.len) {
			this.encodeProcess();
		}
	}

	public void setBufSize(int n) {
		this.bufsize = n;
	}

	public void updateResultData(int offset, int match_length, char next_char, int lookbuf_start) {
		this.data.addElement(new MappingLZ77(offset, match_length, lookbuf_start, next_char));
	}
}