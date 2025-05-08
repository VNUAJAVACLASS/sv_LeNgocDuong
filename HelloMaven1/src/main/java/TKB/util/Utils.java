package TKB.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Utils {
 
    public static List<Integer> tachChuoiTuan(String raw) {
        List<Integer> ds = new ArrayList<>();
        for (int i = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            if (Character.isDigit(c) && c != '0') {
                ds.add(i + 1); 
            }
        }
        return ds;
    }

    public static int chuyenThuSangSo(String thu) {
        thu = thu.toLowerCase().trim();
        if (thu.contains("2")) return 2;
        if (thu.contains("3")) return 3;
        if (thu.contains("4")) return 4;
        if (thu.contains("5")) return 5;
        if (thu.contains("6")) return 6;
        if (thu.contains("7")) return 7;
        if (thu.contains("cn") || thu.contains("chủ nhật")) return 8;
        return -1;
    }

    // Tính tuần học dựa trên ngày bắt đầu
    public static int tinhTuanHoc(LocalDate ngay) {
        LocalDate start = LocalDate.of(2025, 1, 13); // Tuần 1 bắt đầu
        return (int) ChronoUnit.WEEKS.between(start, ngay) + 1;
    }
}
