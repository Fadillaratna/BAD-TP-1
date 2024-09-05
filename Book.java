public class Book {
    private String type;
    private int fineFee;

    public Book(String type, int fineFee) {
        this.type = type;
        this.fineFee = fineFee;
    }

    public String getType() {
        return type;
    }

    public int getFineFee() {
        return fineFee;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setFineFee(int fineFee){
        this.fineFee = fineFee;
    }

    public long calculateFineFee(long totalDaysLate){
        return totalDaysLate * fineFee;
    }

    @Override
    public String toString() {
        return "Jenis Buku: " + type + "\nFine Fee: " + "Rp" + fineFee + "/hari";
    }
}
