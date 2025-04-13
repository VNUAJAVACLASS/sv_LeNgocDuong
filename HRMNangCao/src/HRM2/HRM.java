package HRM2;

import java.util.HashMap;
import java.util.Scanner;

public class HRM {
	private HashMap<String, Human> hrList = new HashMap<>();
	private HashMap<String, Subject> subList = new HashMap<>();

	public HRM() {
	}

	public void addHm(Human hm) {
		hrList.put(hm.getCode(), hm);
	}

	public void addSub(Subject sub) {
		subList.put(sub.getSubjectCode(), sub);
	}

	public void addHR(Scanner sc) {
		System.out.print("Nhap loai nhan su (1 - Lecturer, 2 - Student): ");
		int type = sc.nextInt();
		sc.nextLine();

		Human hm;
		if (type == 1) {
			hm = new Lecturer();
		} else if (type == 2) {
			hm = new Student();
		} else {
			System.out.println("Loai nhan su khong hop le!");
			return;
		}

		hm.enterInfor(sc);
		addHm(hm);
	}

	public void printHRList() {
		System.out.println("\n--------DANH SACH NHAN SU--------\n");
		int index = 1;
		for (Human human : hrList.values()) {
			System.out.println("--------------------------------------");
			System.out.println("      Thong tin nhan su thu " + index );
			System.out.println("--------------------------------------");
			System.out.println(human);
			index++;
		}
	}

	public void printLecturer() {
		System.out.println("\n--------DANH SACH GIANG VIEN--------\n");
		int index = 1;
		for (Human human : hrList.values()) {
			if (human instanceof Lecturer) {
				System.out.println("--------------------------------------");
				System.out.println("      Thong tin giang vien thu " + index );
				System.out.println("--------------------------------------");
				System.out.println(human);
				index++;
			}
		}
	}

	public void printStudent() {
		System.out.println("\n--------DANH SACH SINH VIEN--------\n");
		int index = 1;
		for (Human human : hrList.values()) {
			if (human instanceof Student) {
				System.out.println("--------------------------------------");
				System.out.println("      Thong tin sinh vien thu " + index );
				System.out.println("--------------------------------------");
				System.out.println(human);
				index++;
			}
		}
	}

	public Human searchHuman(String code) {
		return hrList.get(code.toLowerCase());
	}

	public Subject searchSubject(String code) {
		return subList.get(code.toLowerCase());
	}

	public void printAllSubject() {
		for (Subject sub : subList.values()) {
			System.out.println("(" + sub.getSubjectCode() + ") " + sub.getSubjectName() + " | " + sub.getCredit() + " tin chi");
		}
	}

	public void registerSubject(Scanner sc) {
		System.out.println("Chon sinh vien: ");
		printStudent();
		System.out.print("Nhap ma sinh vien muon dang ky: ");
		String studentCode = sc.nextLine();

		System.out.println("Chon mon hoc muon dang ky: ");
		printAllSubject();
		System.out.print("Nhap ma mon hoc muon dang ky: ");
		String subjectCode = sc.nextLine();

		Student student = (Student) searchHuman(studentCode);
		if (student == null) {
			System.out.println("Khong tim thay sinh vien!");
			return;
		}
		Subject subject = searchSubject(subjectCode);
		if (subject == null) {
			System.out.println("Khong tim thay mon hoc!");
			return;
		}
		student.addSubject(subject);
		System.out.println("Dang ky thanh cong!");
	}



	public void initDemoData() {
		addHm(new Lecturer("CNTT01", "Nguyen Van A", "Ha Noi"));
		addHm(new Lecturer("CNTT02", "Dao Van B", "Vinh Phuc"));

		addHm(new Student("671100", "Le Van A", "Quang Ninh", "K67CNTTA"));
		addHm(new Student("671101", "Nguyen Thi B", "Ha Noi", "K67CNTTB"));

		addSub(new JavaSubject("TH01", "Lap trinh Java", 3));
		addSub(new PythonSubject("TH02", "Lap trinh Python", 2));
	}

	public static void main(String[] args) {
		HRM hrm = new HRM();
		boolean continue_ = true;
		hrm.initDemoData();
		Scanner sc = new Scanner(System.in);

		while (continue_) {
			System.out.println("\n======== MENU ========");
			System.out.println("1. Xem danh sach nhan su.");
			System.out.println("2. Xem danh sach sinh vien.");
			System.out.println("3. Xem danh sach giang vien.");
			System.out.println("4. Tim nhan su theo ma.");
			System.out.println("5. Them nhan su.");
			System.out.println("6. Nhap diem sinh vien.");
			System.out.println("7. Dang ky mon hoc.");
			System.out.println("8. Thoat.");
			System.out.print("Lua chon: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1 -> hrm.printHRList();
				case 2 -> hrm.printStudent();
				case 3 -> hrm.printLecturer();
				case 4 -> {
					System.out.print("Nhap ma nhan su: ");
					String code = sc.nextLine();
					System.out.println(hrm.searchHuman(code));
				}
				case 5 -> hrm.addHR(sc);
//				case 6 -> hrm.enterMarks(sc);
				case 7 -> hrm.registerSubject(sc);
				case 8 -> continue_ = false;
				default -> System.out.println("Chuc nang khong hop le!");
			}
			if (continue_) {
				System.out.print("\nNhan Enter de tiep tuc...");
				sc.nextLine();
			}
		}
		sc.close();
	}
}
