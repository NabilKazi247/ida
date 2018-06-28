package upb.ida.provider;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rivescript.macro.Subroutine;

import upb.ida.bean.ResponseBean;
import upb.ida.constant.IDALiteral;
import upb.ida.temp.DemoMain;
@Component
public class BgdHandler implements Subroutine {
	@Autowired
	DemoMain DemoMain;
	@Autowired
	ResponseBean responseBean;
	public String call (com.rivescript.RiveScript rs, String[] args) {
		
		//		String user = rs.currentUser();
		try {
			String actvTbl = (String) responseBean.getPayload().get("actvTbl");
			String actvDs = (String) responseBean.getPayload().get("actvDs");
			Map<String, Object> dataMap = responseBean.getPayload();
			dataMap.put("label", "Bar Graph");
			
//			dataMap.put("dsName", message);
			String path = DemoMain.getFilePath(actvDs,actvTbl );
			dataMap.put("dataset", DemoMain.getJsonData(path,args[0],args[1]));
			responseBean.setPayload(dataMap);
			responseBean.setActnCode(IDALiteral.UIA_BG);
			return "pass";
		} catch (IOException e) {
			e.printStackTrace();
		
		}
		return "fail";
	
	}
}
