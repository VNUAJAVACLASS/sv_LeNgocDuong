package TKB;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import TKB.model.*;
import TKB.util.Utils;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File input = new File("src/main/resources/tkb_lengocduong.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Element table = doc.select("table").first();

        CtrinhChinh ctrinh = new CtrinhChinh();

        Elements rows = table.select("tr");
        for (Element row : rows) {
            Elements cols = row.select("td");

            // Bỏ qua các dòng không đủ dữ liệu
            if (cols.size() < 13) continue;

            try {
                String maMon = cols.get(0).text().trim();
                String tenMon = cols.get(1).text().trim(); 
                String tiet = cols.get(2).text().trim();   
                String thuStr = cols.get(3).text().trim(); 
                String lop = cols.get(6).text().trim();    
                String phong = cols.get(11).text().trim(); 
                String gv = cols.get(12).text().trim();    
                String rawTuan = cols.get(13).text().trim(); 

                int thu = Integer.parseInt(thuStr);
                List<Integer> cacTuan = Utils.tachChuoiTuan(rawTuan);

                LichHoc lh = new LichHoc(tenMon, phong, gv, tiet, lop);
                for (int tuan : cacTuan) {
                    ctrinh.themLichHoc(tuan, thu, lh);
                }
            } catch (Exception e) {
                System.out.println("Bỏ qua dòng lỗi: " + e.getMessage());
            }
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Xem TKB hôm nay");
            System.out.println("2. Xem TKB cả tuần");
            System.out.println("3. Xem TKB theo tuần và thứ");
            System.out.println("4. Xem TKB theo ngày (dd/MM/yyyy)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
                continue;
            }

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    ctrinh.xemTKBHomNay();
                    break;
                case 2:
                    System.out.print("Nhập số tuần (1-22): ");
                    int tuan = Integer.parseInt(sc.nextLine());
                    ctrinh.xemTKBTheoTuan(tuan);
                    break;
                case 3:
                    System.out.print("Nhập tuần: ");
                    int tuan2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập thứ (2-8, với CN là 8): ");
                    int thu = Integer.parseInt(sc.nextLine());
                    ctrinh.xemTKBTheoTuanThu(tuan2, thu);
                    break;
                case 4:
                    System.out.print("Nhập ngày (dd/MM/yyyy): ");
                    String ngayStr = sc.nextLine();
                    try {
                        String[] parts = ngayStr.split("/");
                        int day = Integer.parseInt(parts[0]);
                        int month = Integer.parseInt(parts[1]);
                        int year = Integer.parseInt(parts[2]);
                        LocalDate date = LocalDate.of(year, month, day);
                        ctrinh.xemTKBTheoNgay(date);
                    } catch (Exception e) {
                        System.out.println("Ngày không hợp lệ.");
                    }
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
        sc.close();
    }
}