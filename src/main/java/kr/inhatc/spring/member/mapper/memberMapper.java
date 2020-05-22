package kr.inhatc.spring.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inhatc.spring.member.dto.FileDto;
import kr.inhatc.spring.member.dto.MemberDto;
import kr.inhatc.spring.utils.FileMemberUtils;

@Mapper
public interface memberMapper {
	List<MemberDto> memberList();

	void memberInsert(MemberDto member);

	MemberDto memberDetail(String memberid);

	void memberUpdate(MemberDto member);

	void memberDelete(String memberid);

	void memberFileInsert(List<FileDto> list);

	List<FileDto> selectMemberFileList(String memberid);

	FileDto selectFileInfo(int idx, String memberid);


}
