package syluna.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import syluna.common.util.FileUtils;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    Logger log = Logger.getLogger(this.getClass());
    @Resource(name = "fileUtils")
    private FileUtils fileUtils;
    @Resource(name = "boardDAO")
    private BoardDAO boardDAO;

    public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
        return this.boardDAO.selectBoardList(map);
    }

    public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
        this.boardDAO.insertBoard(map);
        List<Map<String, Object>> list = this.fileUtils.parseInsertFileInfo(map, request);
        int i = 0;

        for (int size = list.size(); i < size; ++i) {
            this.boardDAO.insertFile((Map) list.get(i));
        }

    }

    public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
        this.boardDAO.updateHitCnt(map);
        Map<String, Object> resultMap = new HashMap();
        Map<String, Object> tempMap = this.boardDAO.selectBoardDetail(map);
        resultMap.put("map", tempMap);
        List<Map<String, Object>> list = this.boardDAO.selectFileList(map);
        resultMap.put("list", list);
        return resultMap;
    }

    public void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
        this.boardDAO.updateBoard(map);
        this.boardDAO.deleteFileList(map);
        List<Map<String, Object>> list = this.fileUtils.parseUpdateFileInfo(map, request);
        Map<String, Object> tempMap = null;
        int i = 0;

        for (int size = list.size(); i < size; ++i) {
            tempMap = (Map) list.get(i);
            if (tempMap.get("IS_NEW").equals("Y")) {
                this.boardDAO.insertFile(tempMap);
            } else {
                this.boardDAO.updateFile(tempMap);
            }
        }

    }

    public void deleteBoard(Map<String, Object> map) throws Exception {
        this.boardDAO.deleteBoard(map);
    }
}