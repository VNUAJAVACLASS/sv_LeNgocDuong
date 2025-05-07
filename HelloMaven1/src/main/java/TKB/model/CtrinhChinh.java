package TKB.model;

import TKB.util.Utils;

import java.time.LocalDate;
import java.util.*;

public class CtrinhChinh {
    Map<Integer, Tuan> dsTuan = new HashMap<>();

    public void themLichHoc(int tuan, int thu, LichHoc lh) {
        dsTuan.putIfAbsent(tuan, new Tuan());
        dsTuan.get(tuan).themLichHoc(thu, lh);
    }

    public void xemTKBHomNay() {
        LocalDate today = LocalDate.now();
        int tuan = TKB.util.Utils.tinhTuanHoc(today);
        int thu = today.getDayOfWeek().getValue();
        System.out.println("TKB hôm nay (Tuần " + tuan + ", Thứ " + thu + "):");
        if (dsTuan.containsKey(tuan)) dsTuan.get(tuan).inThu(thu);
        else System.out.println("Không có dữ liệu tuần này.");
    }

    public void xemTKBTheoTuan(int tuan) {
        System.out.println("TKB tuần " + tuan + ":");
        if (dsTuan.containsKey(tuan)) dsTuan.get(tuan).inTuan();
        else System.out.println("Không có dữ liệu tuần này.");
    }

    public void xemTKBTheoTuanThu(int tuan, int thu) {
        System.out.println("TKB tuần " + tuan + ", thứ " + thu + ":");
        if (dsTuan.containsKey(tuan)) dsTuan.get(tuan).inThu(thu);
        else System.out.println("Không có dữ liệu tuần này.");
    }

    public void xemTKBTheoNgay(LocalDate ngay) {
        int tuan = Utils.tinhTuanHoc(ngay);
        int thu = ngay.getDayOfWeek().getValue();
        System.out.println("TKB ngày " + ngay + ":");
        if (dsTuan.containsKey(tuan)) dsTuan.get(tuan).inThu(thu);
        else System.out.println("Không có dữ liệu tuần này.");
    } }