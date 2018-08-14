package syluna.board;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import syluna.common.common.CommandMap;

@Controller
public class BoardController {
    Logger log = Logger.getLogger(this.getClass());
    @Resource(name = "boardService")
    private BoardService boardService;

    @RequestMapping({"/board/openBoardList.do"})
    public ModelAndView openBoardList(Map<String, Object> commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardList");
        List<Map<String, Object>> list = this.boardService.selectBoardList(commandMap);
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping({"/board/testMapArgumentResolver.do"})
    public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("");
        if (!commandMap.isEmpty()) {
            Iterator<Entry<String, Object>> iterator = commandMap.getMap().entrySet().iterator();
            Entry entry = null;

            while (iterator.hasNext()) {
                entry = (Entry) iterator.next();
                this.log.debug("key : " + (String) entry.getKey() + ", value : " + entry.getValue());
            }
        }

        return mv;
    }

    @RequestMapping({"/board/openBoardWrite.do"})
    public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardWrite");
        return mv;
    }

    @RequestMapping({"/board/insertBoard.do"})
    public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/board/openBoardList.do");
        this.boardService.insertBoard(commandMap.getMap(), request);
        return mv;
    }

    @RequestMapping({"/board/openBoardDetail.do"})
    public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardDetail");
        Map<String, Object> map = this.boardService.selectBoardDetail(commandMap.getMap());
        mv.addObject("map", map.get("map"));
        mv.addObject("list", map.get("list"));
        return mv;
    }

    @RequestMapping({"/board/openBoardUpdate.do"})
    public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardUpdate");
        Map<String, Object> map = this.boardService.selectBoardDetail(commandMap.getMap());
        mv.addObject("map", map.get("map"));
        mv.addObject("list", map.get("list"));
        return mv;
    }

    @RequestMapping({"/board/updateBoard.do"})
    public ModelAndView updateBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/board/openBoardDetail.do");
        this.boardService.updateBoard(commandMap.getMap(), request);
        mv.addObject("IDX", commandMap.get("IDX"));
        return mv;
    }

    @RequestMapping({"/board/deleteBoard.do"})
    public ModelAndView deleteBoard(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/board/openBoardList.do");
        this.boardService.deleteBoard(commandMap.getMap());
        return mv;
    }
}