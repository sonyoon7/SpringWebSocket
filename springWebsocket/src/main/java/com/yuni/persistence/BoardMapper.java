package com.yuni.persistence;

import java.util.List;

import com.yuni.model.BoardVO;
import com.yuni.model.Criteria;


// 이름이 겹치는 것을 방지하기 위해 자기 이름을 붙여서 사용해주세요. (ex) BoardMapperTJ.java)
public interface BoardMapper {
	
	// BoardService listAll()와 연결된다.
	public List<BoardVO> getList();
	// BoardService listCriteria()와 연결된다.
	public List<BoardVO> getListWithPaging(Criteria cri);
    // BoardService regist()와 연결된다.
	public int regist(BoardVO board);
	// BoardService read()와 연결된다.
	public BoardVO read(Integer bno);
	// BoardService modify()와 연결된다.
	public int update(BoardVO board);
    // BoardService delete()와 연결된다.
	public int delete(Integer bno);
	// BoardService listCount()와 연결된다.
	public int getTotalCount(Criteria cri);
	
	
}