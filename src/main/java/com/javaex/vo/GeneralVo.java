package com.javaex.vo;

public class GeneralVo {

	//필드
	private int no;
	private String name; 
	private String registerDate;
	private int remainDate;
	private String entryTime;
	private String leaveTime;
	
	//생성자
	public GeneralVo() {
		super();
	}
	
	

	public GeneralVo(int no, int remainDate) {
		super();
		this.no = no;
		this.remainDate = remainDate;
	}



	public GeneralVo(int no, String name, String registerDate, int remainDate, String entryTime, String leaveTime) {
		super();
		this.no = no;
		this.name = name;
		this.registerDate = registerDate;
		this.remainDate = remainDate;
		this.entryTime = entryTime;
		this.leaveTime = leaveTime;
	}

	//메소드 - g/s
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public int getRemainDate() {
		return remainDate;
	}

	public void setRemainDate(int remainDate) {
		this.remainDate = remainDate;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	//메소드 - 일반
	@Override
	public String toString() {
		return "GeneralVo [no=" + no + ", name=" + name + ", registerDate=" + registerDate + ", remainDate="
				+ remainDate + ", entryTime=" + entryTime + ", leaveTime=" + leaveTime + "]";
	}
	
	
}
