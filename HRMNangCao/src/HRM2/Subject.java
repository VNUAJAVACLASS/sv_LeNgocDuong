package HRM2;

public abstract class Subject {
	private String subjectCode;
	private String subjectName;
	private int credit;
	
	
	
	public Subject() {};
	
	public Subject(String subjectCode, String subjectName, int credit) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}
	
	public abstract float calSubjectMark() ;
	
	 public float calConversionMark() {
	        return calConversionMark(calGrade());
	    }
	
	public float calConversionMark(String grade) {
		switch (grade) {
	        case "A": return 4.0f;
	        case "B+": return 3.5f;
	        case "B": return 3.0f;
	        case "C+": return 2.5f;
	        case "C": return 2.0f;
	        case "D+": return 1.5f;
	        case "D": return 1.0f;
	        default: return 0.0f;
        }
	}
	
	public String calGrade() {
		float subjectMark = calSubjectMark();
        
        if (subjectMark >= 8.5) return "A";
        if (subjectMark >= 7.5) return "B+";
        if (subjectMark >= 7.0) return "B";
        if (subjectMark >= 6.5) return "C+";
        if (subjectMark >= 6.0) return "C";
        if (subjectMark >= 5.5) return "D+";
        if (subjectMark >= 5.0) return "D";
        return "F";
	}	
	
	

	public String getSubjectCode() {
		return subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}


	public int getCredit() {
		return credit;
	}
	
	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 sb.append(String.format("%-15s: %-20s \n", "Ma Mon Hoc", subjectCode ));
		 sb.append(String.format("%-15s: %-20s \n", "Ten Mon Hoc", subjectName ));
		 sb.append(String.format("%-15s: %-20s \n", "So Tin Chi", credit ));
		 
		 return sb.toString();
	}
	

	
}
