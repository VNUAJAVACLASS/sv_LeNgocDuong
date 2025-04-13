package HRM2;

public class PythonSubject extends Subject {
	private float attendanceMark;
	private float quizMark;
	private float midExamMark;
	private float finalExamMark;
	
	
	public PythonSubject() {
		super();
	}


	public PythonSubject(String subjectCode, String subjectName, int credit) {
		super(subjectCode, subjectName, credit);
		
	}



	public void setAttendanceMark(float attendanceMark) {
		this.attendanceMark = attendanceMark;
	}


	public void setQuizMark(float quizMark) {
		this.quizMark = quizMark;
	}


	public void setMidExamMark(float midExamMark) {
		this.midExamMark = midExamMark;
	}


	public void setFinalExamMark(float finalExamMark) {
		this.finalExamMark = finalExamMark;
	}


	@Override
	public float calSubjectMark() {
		return (attendanceMark + quizMark + midExamMark*2 + finalExamMark *6) / 10;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-15s: %-5s \n", "Diem Chuyen Can", attendanceMark ));
		sb.append(String.format("%-15s: %-5s \n", "Diem Hoi Dap", quizMark ));
		sb.append(String.format("%-15s: %-5s \n", "Diem Giua Ky", midExamMark ));
		sb.append(String.format("%-15s: %-5s \n", "Diem Cuoi Ky", finalExamMark ));
		sb.append(String.format("%-15s: %-5s \n", "Diem Tong Ket", calSubjectMark() ));
		
		return sb.toString();
	}
	
	
}
