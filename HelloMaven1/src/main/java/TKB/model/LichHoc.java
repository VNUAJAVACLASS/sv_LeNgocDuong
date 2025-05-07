package TKB.model;

public class LichHoc {
    String monHoc, phong, giangVien, tiet, lop;

    public LichHoc(String monHoc, String phong, String giangVien, String tiet, String lop) {
        this.monHoc = monHoc;
        this.phong = phong;
        this.giangVien = giangVien;
        this.tiet = tiet;
        this.lop = lop;
    }

    public String toString() {
        return tiet + ": " + monHoc + " (" + phong + ", " + giangVien + ", " + lop + ")";
    }
}

