package syluna.board;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import syluna.common.dao.AbstractDAO;

@Repository("boardDAO")
public class BoardDAO extends AbstractDAO {
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
        String strPageNo = (String)map.get("pageNo");
        int nPageNo = 0;
        if(StringUtils.isEmpty(strPageNo) == false) {
            nPageNo = Integer.parseInt(strPageNo);
        }
        map.put("START", nPageNo*20);
        return (List<Map<String,Object>>)selectList("board.selectBoardList", map);
    }

    public void insertBoard(Map<String, Object> map) throws Exception {
        this.insert("board.insertBoard", map);
    }

    public void updateHitCnt(Map<String, Object> map) throws Exception {
        this.update("board.updateHitCnt", map);
    }

    public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
        return (Map) this.selectOne("board.selectBoardDetail", map);
    }

    public void updateBoard(Map<String, Object> map) throws Exception {
        this.update("board.updateBoard", map);
    }

    public void deleteBoard(Map<String, Object> map) throws Exception {
        this.update("board.deleteBoard", map);
    }

    public void insertFile(Map<String, Object> map) throws Exception {
        this.insert("board.insertFile", map);
    }

    public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
        return this.selectList("board.selectFileList", map);
    }

    public void deleteFileList(Map<String, Object> map) throws Exception {
        this.update("board.deleteFileList", map);
    }

    public void updateFile(Map<String, Object> map) throws Exception {
        this.update("board.updateFile", map);
    }
}