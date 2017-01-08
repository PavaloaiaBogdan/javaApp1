package CompressionAlgorithms.LZ.LZ78;

class Table78 {
    private String[] table = new String[1000];
    private int root_code = 1;

    public Table78() {
        this.clear();
        this.initial();
    }

    public void addRootToTables(String string) {
        this.table[this.root_code] = string;
        this.incrementRootCode();
    }

    public void clear() {
        this.root_code = 1;
        int n = 0;
        while (n < this.table.length) {
            this.table[n] = "";
            ++n;
        }
    }

    public String getEntry(int n) {
        return this.table[n];
    }

    public int getRootCode() {
        return this.root_code;
    }

    public int getRootNum() {
        return "".length();
    }

    public String[] getTable() {
        return this.table;
    }

    public void incrementRootCode() {
        this.root_code++;
    }

    public void initial() {
        int n = 0;
        while (n < "".length()) {
            this.addRootToTables("".substring(n, n + 1));
            ++n;
        }
    }

    public int rootExist(String string) {
        int poz = -1;
        int index = 0;
        while (index < this.table.length) {
            if (this.table[index].equals(string)) {
                poz = index;
                break;
            }
            ++index;
        }
        return poz;
    }
    

}
