package kr.inhatc.spring.board.dto;

import java.util.List;

import lombok.Data;

// DTO ; Data Transfer Object

@Data
public class BoardDto {
	
	private int  boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private String CreateDatetime;
	
	private List<FileDto> fileList;
}
