package com.yuni.service;

import java.util.List;

import com.yuni.model.BoardVO;
import com.yuni.model.Criteria;


public interface BoardService {

	// 게시글을 새로 추가한다.
	public int regist(BoardVO board) throws Exception;
	// 특정 게시글을 읽어온다.
	public BoardVO read(Integer bno) throws Exception;
	// 특정 게시글을 수정한다.
	public int modify(BoardVO board) throws Exception;
	// 특정 게시글을 삭제한다.
	public int remove(Integer bno) throws Exception;
	// 게시글 모두를 읽어온다.
	public List<BoardVO> listAll() throws Exception;
	// 게시글을 Criteria로 정하는 수만큼 읽어온다.
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	// 게시글의 총 개수를 센다. (count)
	public int listCount(Criteria cri) throws Exception;
}
