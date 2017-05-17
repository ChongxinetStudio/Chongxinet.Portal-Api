package chongxinet.portal.api.Entity;

import java.util.List;

public class Task {
	private int id;// ���
	private String taskTitle;// ����
	private String taskType;// ��������
	private String taskDescription;// ����
	private String member;// ��Ա
	private String startDate;// �ϴ�ʱ��
	private String endDate;// ���ʱ��
	private double taskPrice;// �۸�
	private List<Comment> comment;// ����

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getTaskPrice() {
		return taskPrice;
	}

	public void setTaskPrice(double taskPrice) {
		this.taskPrice = taskPrice;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

}
