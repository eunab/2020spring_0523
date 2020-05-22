package kr.inhatc.spring.member.dto;

import java.util.List;

import lombok.Data;

@Data
public class MemberDto {
	
	private String joindate;
	private String memberid;
	private String email;
	private String enabled;
	private String name;
	private String pw;
	private String role;
	
	private List<FileDto> fileList;
}
