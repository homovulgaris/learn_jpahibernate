package com.homovulgaris.learn.jpahibernate.domain;

public class Chapter {
	private String title;
	private Integer chapterNumber;

	public String getTitle() {
		return title;
	}

	public Integer getChapterNumber() {
		return chapterNumber;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	private void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public Chapter(String title, Integer chapterNumber) {
		super();
		setTitle(title);
		setChapterNumber(chapterNumber);
	}

}
