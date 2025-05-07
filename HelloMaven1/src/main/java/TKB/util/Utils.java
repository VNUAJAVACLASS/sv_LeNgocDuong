package TKB.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Utils {
    // Kiểu cũ: "1-3, 5, 7"
    public static List<Integer> tachChuoiTuan(String tuanStr) {
        List<Integer> result = new ArrayList<>();
        String[] parts = tuanStr.split(",");
        for (String p : parts) {
            p = p.trim();
            if (!p.matches("^[0-9\\-]+$")) continue;
            if (p.contains("-")) {
                String[] range = p.split("-");
                try {
                    int start = Integer.parseInt(range[0].trim());
                    int end = Integer.parseInt(range[1].trim());
                    for (int i = start; i <= end; i++) result.add(i);
                } catch (NumberFormatException ignored) {}
            } else {
                try {
                    result.add(Integer.parseInt(p));
                } catch (NumberFormatException ignored) {}
            }
        }
        return result;
    }

    // ✅ Mới: kiểu bitmask "----567890--------------"
    public static List<Integer> tachChuoiTuanBitmask(String raw) {
        List<Integer> ds = new ArrayList<>();
        for (int i = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            if (Character.isDigit(c) && c != '0') {
                ds.add(i + 1); // tuần đánh số từ 1
            }
        }
        return ds;
    }

    // Chuyển "Thứ 2", "Thứ ba", "CN" → số
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
