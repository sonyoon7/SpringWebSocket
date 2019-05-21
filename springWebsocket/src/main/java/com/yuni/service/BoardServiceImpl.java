package com.yuni.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuni.model.BoardVO;
import com.yuni.model.Criteria;
import com.yuni.persistence.BoardMapper;


@Service
public class BoardServiceImpl  implements BoardService{
	
	@Autowired
	private BoardMapper  mapper;

	@Override
	public int regist(BoardVO board) throws Exception {
		return mapper.regist(board);
		
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) throws Exception {
		return mapper.update(board);
		
	}

	@Override
	public int remove(Integer bno) throws Exception {
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		
		return mapper.getList();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int listCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
