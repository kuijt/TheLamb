package com.lamb.dao;

import java.util.List;

import com.lamb.domain.BoardVO;

public interface BoardDAO {

	public void writer(BoardVO vo) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
	public BoardVO view(int bno) throws Exception;
	public List<BoardVO> list() throws Exception;
	public int count() throws Exception;
	public List<BoardVO> listPage(int displayPost, int PostNum) throws Exception;
	
}
