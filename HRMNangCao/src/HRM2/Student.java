package HRM2;


import java.util.HashMap;
import java.util.Scanner;

public class Student extends Human {
	private String class_;
	private HashMap<String, Subject> subjectList  = new HashMap<>();
	
	public Student() {
		super();
		
	}
	public Student(String code, String fullname, String address, String class_) {
		super(code, fullname, address);
		this.class_  = class_;
	}
	public Student(String code, String fullname, String class_) {
		super(code, fullname);
		this.class_  = class_;
	}
	public Student(String code, String fullname) {
		super(code, fullname);
		
	}
	public Student(String code) {
		super(code);
	}

	 
	 
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	
	
	public void addSubject(Subject sub) {
		subjectList.put(sub.getSubjectCode(), sub);
	 }
	 public Subject findSubject(String subjectCode) {
	        return subjectList.get(subjectCode);
	    }
	 public Subject findSubjectByName(String subjectName) {
	        for (Subject s : subjectList.values()) {
	            if (s.getSubjectName().equalsIgnoreCase(subjectName)) return s;
	        }
	        return null;
	    }

	    public void removeSubject(String subjectCode) {
	        subjectList.remove(subjectCode);
	    }
	    
	    public float calTermAverageMark() {
	        float totalMark = 0;
	        int totalCredit = 0;
	        for (Subject s : subjectList.values()) {
	            totalMark += s.calConversionMark() * s.getCredit();
	            totalCredit += s.getCredit();
	        }
	        return totalCredit == 0 ? 0 : totalMark / totalCredit;
	    }
	    
	@Override
    public void enterInfor(Scanner sc) {
        System.out.println("Nhap vao ten: ");
        this.fullname = sc.nextLine();
        System.out.println("Nhap vao ma code: ");
        this.code = sc.nextLine();
        System.out.println("Nhap vao dia chi: ");
        this.address = sc.nextLine();
        System.out.println("Nhap vao lop: ");
        this.class_ = sc.nextLine();
	}
    
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-15s: %-25s \n", "Ho ten", fullname ));
		sb.append(String.format("%-15s: %-25s \n", "Ma Sinh Vien", code ));
		sb.append(String.format("%-15s: %-25s \n", "Lop", class_ ));
		sb.append(String.format("%-15s: %-25s \n", "Dia chi", address ));
		
		 if (subjectList.isEmpty()) {
			    sb.append("Sinh vien khong co mon hoc nao trong ky");
			    sb.append("\n------------------------------------------\n");
			    return sb.toString();
		    }
		 sb.append("Danh sach mon hoc:\n");
		    for (Subject s : subjectList.values()) {
		        sb.append(s).append("\n");
		    }	
		    sb.append(String.format("%-15s: %-25s \n","Diem trung binh hoc ky: ",calTermAverageMark()));
		    sb.append("------------------------------------------\n");
		    
		    return sb.toString();

	}
	
	 
}