package syluna.board;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface BoardService {
    List<Map<String, Object>> selectBoardList(Map<String, Object> var1) throws Exception;

    void insertBoard(Map<String, Object> var1, HttpServletRequest var2) throws Exception;

    Map<String, Object> selectBoardDetail(Map<String, Object> var1) throws Exception;

    void updateBoard(Map<String, Object> var1, HttpServletRequest var2) throws Exception;

    void deleteBoard(Map<String, Object> var1) throws Exception;
}