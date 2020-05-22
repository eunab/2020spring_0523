package kr.inhatc.spring.member.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.member.dto.FileDto;
import kr.inhatc.spring.member.dto.MemberDto;

public interface memberService {

	List<MemberDto> memberList();

	void memberInsert(MemberDto member, MultipartHttpServletRequest multipartHttpServletRequest);

	MemberDto memberDetail(String memberid);

	void memberUpdate(MemberDto member);

	void memberDelete(String memberid);

	FileDto selectFileInfo(int idx, String memberid);

}
