package wyNLSc;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.wy.controller.UserController;
import com.cn.wy.pojo.User;
import com.cn.wy.service.UserService;
import com.cn.wy.utils.WebUtil;
@Controller
@RequestMapping("/sys/user")
public class UserNameTest {
	private static Logger logger = LoggerFactory.getLogger(UserController.class); 
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping("/userInfo.do")
	public String getUserInfo(HttpServletRequest request,Long userId)throws Exception{
		User user = this.userService.selectByPrimaryKey(userId);
		return WebUtil.getSuccessJson(user);
	}
}
