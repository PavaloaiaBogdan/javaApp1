package CompressionAlgorithms.LZ.LZ77;

public class SearchBuffer {
    private int sbufstart = 0;
    private int sbufend = 0;
    
    SearchBuffer(){
    }

    public int get_searchendbuf() {
        return this.sbufend;
    }

    public int get_searchstartbuf() {
        return this.sbufstart;
    }

    public void setsbufend(int end) {
        this.sbufend = end;
    }

    public void setsbufstart(int start) {
        this.sbufstart = start;
    }
}
