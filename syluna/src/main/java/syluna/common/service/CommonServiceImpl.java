package syluna.common.service;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import syluna.common.dao.CommonDAO;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	Logger log = Logger.getLogger(this.getClass());
	@Resource(name = "commonDAO")
	private CommonDAO commonDAO;

	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return this.commonDAO.selectFileInfo(map);
	}
}