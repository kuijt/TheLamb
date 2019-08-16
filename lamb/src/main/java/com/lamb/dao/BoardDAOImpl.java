package com.lamb.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lamb.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession sqlSession;
	
	private static String namespace= "com.lamb.mapper.boardMapper";
	
	@Override
	public void writer(BoardVO vo) throws Exception {
		sqlSession.insert(namespace+".write", vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update(namespace+".update", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(namespace+".delete", bno);
	}

	@Override
	public BoardVO view(int bno) throws Exception {
		return sqlSession.selectOne(namespace+".view", bno);
		
	}

	@Override
	public List<BoardVO> list() throws Exception {
		return sqlSession.selectList(namespace+".list");
	}

	@Override
	public int count() throws Exception {
		return sqlSession.selectOne(namespace+".count");
	}

	@Override
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception {
		
		HashMap<String, Integer> myMap = new HashMap<String, Integer>();
		
		myMap.put("displayPost", displayPost);
		myMap.put("postNum", postNum);
		
		return sqlSession.selectList(namespace+".listPage", myMap);
	}

}
