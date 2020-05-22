package kr.inhatc.spring.member.dto;

import java.util.List;

import lombok.Data;

@Data
public class FileDto {
	private int idx;
	private String memberid;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
	
	private List<FileDto> fileList;
}
