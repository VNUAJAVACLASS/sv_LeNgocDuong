package TKB.model;

import java.util.*;

public class Tuan {
    Map<Integer, Thu> dsThu = new HashMap<>();

    public void themLichHoc(int thu, LichHoc lh) {
        dsThu.putIfAbsent(thu, new Thu());
        dsThu.get(thu).themLichHoc(lh);
    }

    public void inTuan() {
        for (int thu : dsThu.keySet()) {
            System.out.println("Thứ " + thu + ":");
            dsThu.get(thu).inLichHoc();
        }
    }

    public void inThu(int thu) {
        if (dsThu.containsKey(thu)) {
            System.out.println("Thứ " + thu + ":");
            dsThu.get(thu).inLichHoc();
        } else {
            System.out.println("Không có lịch học cho thứ này.");
        }
    }
}