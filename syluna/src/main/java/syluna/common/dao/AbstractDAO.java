package syluna.common.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO {
	protected Log log = LogFactory.getLog(AbstractDAO.class);
	@Autowired
	private SqlSessionTemplate sqlSession;

	protected void printQueryId(String queryId) {
		if (this.log.isDebugEnabled()) {
			this.log.debug("\t QueryId  \t:  " + queryId);
		}

	}

	public Object insert(String queryId, Object params) {
		this.printQueryId(queryId);
		return this.sqlSession.insert(queryId, params);
	}

	public Object update(String queryId, Object params) {
		this.printQueryId(queryId);
		return this.sqlSession.update(queryId, params);
	}

	public Object delete(String queryId, Object params) {
		this.printQueryId(queryId);
		return this.sqlSession.delete(queryId, params);
	}

	public Object selectOne(String queryId) {
		this.printQueryId(queryId);
		return this.sqlSession.selectOne(queryId);
	}

	public Object selectOne(String queryId, Object params) {
		this.printQueryId(queryId);
		return this.sqlSession.selectOne(queryId, params);
	}

	public List selectList(String queryId) {
		this.printQueryId(queryId);
		return this.sqlSession.selectList(queryId);
	}

	public List selectList(String queryId, Object params) {
		this.printQueryId(queryId);
		return this.sqlSession.selectList(queryId, params);
	}
}