package TKB.model;

import java.util.*;

public class Thu {
    List<LichHoc> dsLichHoc = new ArrayList<>();

    public void themLichHoc(LichHoc lh) {
        dsLichHoc.add(lh);
    }

    public void inLichHoc() {
        for (LichHoc lh : dsLichHoc) {
            System.out.println("  - " + lh);
        }
    }
}