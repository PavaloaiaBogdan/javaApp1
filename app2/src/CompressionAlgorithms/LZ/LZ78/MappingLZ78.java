package CompressionAlgorithms.LZ.LZ78;

class MappingLZ78 {
    private int currIndex;
    private int codeNum;
    private String codeword;
    private int newcodeNum;
    private int matchLen;

    public MappingLZ78(int currIndex, int codeNum, String codeword, int newcodeNum, int matchLen) {
        this.currIndex = currIndex;
        this.codeNum = codeNum;
        this.codeword = codeword;
        this.newcodeNum = newcodeNum;
        this.matchLen = matchLen;
    }

    public int getCodeNum() {
        return this.codeNum;
    }

    public String getCodeWord() {
        return this.codeword;
    }

    public int getCurrIndex() {
        return this.currIndex;
    }

    public int getLength() {
        return this.matchLen;
    }

    public int getNewCodeNum() {
        return this.newcodeNum;
    }
}