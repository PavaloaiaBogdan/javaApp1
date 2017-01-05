package CompressionAlgorithms.LZ.LZ77;

public class MappingLZ77 {
    private int offset;
    private int match_length;
    private int lookbuf_start;
    private char nextchar;

    public MappingLZ77(int offset, int match_length, int lookbuf_start, char next_char) {
        this.offset = offset;
        this.match_length = match_length;
        this.lookbuf_start = lookbuf_start;
        this.nextchar = (char)next_char;
    }

    public int getLength() {
        return this.match_length;
    }

    public int getLookbufstart() {
        return this.lookbuf_start;
    }

    public char getNextchar() {
        return this.nextchar;
    }

    public int getOffset() {
        return this.offset;
    }
}