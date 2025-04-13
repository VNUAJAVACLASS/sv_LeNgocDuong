package HRM2;

import java.util.Scanner;

public class Lecturer extends Human {
	private String password;


	public Lecturer() {
		super();
		
	}

	public Lecturer(String code, String fullname, String address) {
		super(code, fullname, address);
	}


	public Lecturer(String code, String password) {
		super(code);
		this.password = password;
	};
	
	@Override
	public void enterInfor(Scanner sc) {
		System.out.print("Nhap vao ten: ");
		this.fullname = sc.nextLine();
		System.out.print("Nhap vao ma code: ");
		this.code = sc.nextLine();
		System.out.print("Nhap vao dia chi: ");
		this.address = sc.nextLine();
		System.out.print("Nhap vao password: ");
		this.password = sc.nextLine();
	}
	
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append(String.format("%-15s: %-20s \n", "Ho ten", fullname));
	    sb.append(String.format("%-15s: %-20s \n ", "Ma giang vien", code));
	    sb.append(String.format("%-15s: %-20s \n ", "Đia chi", address ));
	    sb.append(String.format("%-15s: %-20s \n", "Password", password));
	    sb.append("--------------------------------------\n");
	    return sb.toString();
	}
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		Lecturer l = new Lecturer();
//		l.enterInfor(sc);
//		
//		System.out.print(l.toString() );
//	}
	
}
