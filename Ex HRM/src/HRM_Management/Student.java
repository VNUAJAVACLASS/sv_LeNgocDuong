package HRM_Management;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Human {
	private String class_;
	private ArrayList<Subject> subjectList = new ArrayList<>();
	
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

	 public void addSubject(Subject sub) {
		 
	 }
	 
	 public float calTermAverageMark() {
		 return 0;
	 }
	 
	 public void enterInfo(Scanner sc) {
		 super.enterInfor(sc);
	 }
	 
	public String getClass_() {
		return class_;
	}
	public void setClass_(String class_) {
		this.class_ = class_;
	}
	@Override
	public String toString() {
		return "Student [class_=" + class_ + ", address=" + address + ", code=" + code + ", fullname=" + fullname + "]";
	}
	
	
	
	 
	 
}
