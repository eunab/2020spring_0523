package kr.inhatc.spring.member.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.inhatc.spring.board.mapper.BoardMapper;
import kr.inhatc.spring.member.dto.FileDto;
import kr.inhatc.spring.member.dto.MemberDto;
import kr.inhatc.spring.member.mapper.memberMapper;
import kr.inhatc.spring.utils.FileMemberUtils;

@Service
public class memberServiceImpl implements memberService {
		@Autowired
		private memberMapper memberMapper;
		
		@Autowired
		private FileMemberUtils fileMemberUtils;
		@Override
		public List<MemberDto> memberList() {
			return memberMapper.memberList();
		}

		@Override
		public void memberInsert(MemberDto member, MultipartHttpServletRequest multipartHttpServletRequest) {
			memberMapper.memberInsert(member);
			
			if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
				Iterator<String> iter = multipartHttpServletRequest.getFileNames();
				
				while(iter.hasNext()) {
					String name = iter.next();
					
					List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
					for(MultipartFile multipartFile : list) {
						System.out.println("===============> file name" + multipartFile.getOriginalFilename());
						System.out.println("===============> file name" + multipartFile.getSize());
						System.out.println("===============> file name" + multipartFile.getContentType());
						
					}
				}
			}
			List<FileDto> list = fileMemberUtils.parseFileInfo(member.getMemberid(), multipartHttpServletRequest);
			if(CollectionUtils.isEmpty(list) == false) {
				memberMapper.memberFileInsert(list);
			}
		}

		@Override
		public MemberDto memberDetail(String memberid) {
			MemberDto member = memberMapper.memberDetail(memberid);
			
			List<FileDto> fileList = memberMapper.selectMemberFileList(memberid);
			member.setFileList(fileList);
			
			return member;
		}

		@Override
		public void memberUpdate(MemberDto member) {
			memberMapper.memberUpdate(member);
		}

		@Override
		public void memberDelete(String memberid) {
			memberMapper.memberDelete(memberid);
		}

		@Override
		public FileDto selectFileInfo(int idx, String memberid) {
			FileDto memberFile = memberMapper.selectFileInfo(idx, memberid);
			return memberFile;
		}
}
