package com.csye6225.fall2018.courseservice.lambda;

public class UpdateCourseEvent{
	private String courseId;
	private String department;
	private String boardId;
	private long length;
	private String notificationTopic;

  public UpdateCourseEvent() {

  }

	public UpdateCourseEvent(String courseId, String department, String boardId, long length,
			String notificationTopic) {
		this.courseId = courseId;
		this.department = department;
		this.boardId = boardId;
		this.length = length;
		this.notificationTopic = notificationTopic;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getNotificationTopic() {
		return notificationTopic;
	}

	public void setNotificationTopic(String notificationTopic) {
		this.notificationTopic = notificationTopic;
	}

	@Override
	public String toString() {
		return "UpdateCourseEvent [courseId=" + courseId + ", department=" + department + ", boardId=" + boardId
				+ ", length=" + length + ", notificationTopic=" + notificationTopic + "]";
	}
}