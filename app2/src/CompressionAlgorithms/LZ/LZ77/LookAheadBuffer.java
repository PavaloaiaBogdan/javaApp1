package CompressionAlgorithms.LZ.LZ77;

public class LookAheadBuffer{
    private int lookbufstart = 0;
    private int lookbufend = 0;

    LookAheadBuffer() {
    }

    public int get_lookendbuf() {
        return this.lookbufend;
    }

    public int get_lookstartbuf() {
        return this.lookbufstart;
    }

    public void setlookbufend(int end) {
        this.lookbufend = end;
    }

    public void setlookbufstart(int start) {
        this.lookbufstart = start;
    }
}
