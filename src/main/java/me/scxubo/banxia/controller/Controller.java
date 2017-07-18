package me.scxubo.banxia.controller;


import com.github.pagehelper.PageHelper;
import me.scxubo.banxia.dao.testdao;
import me.scxubo.banxia.domain.Result;
import me.scxubo.banxia.domain.user;
import me.scxubo.banxia.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@RestController
public class Controller {
    @Autowired
    private testdao testdao;
    Logger log=Logger.getLogger( "hello" );

    @RequestMapping("/")
    public String home() {
        return "我的spring boot程序启动了";
    }

    @RequestMapping("/login")
    public Result login() {
        PageHelper.startPage(1,2);
        return ResultUtils.login(null,"亲！要登录额");
    }

    @RequestMapping("/test")
    public String add() {


        log.info( "" );
        return "你好;!";
    }

    @RequestMapping(value = "/params")
    public Iterable<user> findAll(Pageable pageable) {
        Pageable Pageables= new PageRequest(0,20);
        Iterable<user> persons = testdao.findAll(Pageables);
        return persons;
    }

    @RequestMapping(value = "/finid")
    public Iterable<user> finid(Pageable pageable) {
        Pageable Pageables= new PageRequest(0,20,Sort.Direction.ASC, "userid");
        Iterable<user> persons = testdao.findAll(Pageables);
        return persons;
    }

    //    通过HttpServletRequest接收，post方式和get方式
    @RequestMapping("/addUser2")
    public String addUser2(HttpServletRequest request) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        return "username is:"+username+"password is:"+password;
    }

    /**
     * 通过一个bean来接收
     * @param user
     * @return
     */
    @RequestMapping("/addUser3")
    public String addUser3(user user) {
        System.out.println("username is:"+user.getUser_name());
        System.out.println("password is:"+user.getUser_pwd());
        return "demo/index";
    }

    /**
     * 通过@PathVariable获取路径中的参数
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/addUser4/{username}/{password}",method= RequestMethod.GET)
    public String addUser4(@PathVariable String username, @PathVariable String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "demo/index";
    }

    /**
     * 用注解@RequestParam绑定请求参数到方法入参
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/addUser6",method=RequestMethod.GET)
    public String addUser6(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "demo/index";
    }
}
