package com.itheima.ruiji.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.ruiji.common.R;
import com.itheima.ruiji.entity.Employee;
import com.itheima.ruiji.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登录
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        String password = employee.getPassword();
        password = DigestUtil.md5Hex(password);

        //2,根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);
        //3.如果没有查到
        if(emp == null){
            return R.error("登录失败");
        }
        // 2. 判断密码是否 正确
        if (!password.equals(emp.getPassword())){
            return R.error("登录失败");
        }

        // 3. 判断用户是否被禁用
        if (emp.getStatus() == 0){
            return R.error("账号已禁用");
        }
        // 4. 返回用户信息，并保存到session中
        request.getSession().setAttribute("employee", emp.getId());
        // 将数据写入到threadLocal中
        return R.success(emp);
    }

    @PostMapping("/logout")
    public R<String> logOut(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    /**
     * 新增员工
     */
    @PostMapping("")
    public R<String> save(@RequestBody Employee employee,HttpServletRequest request){
        log.info("新增员工,员工信息： {}", employee.toString());
        //设置初始密码 需要进行md5加密处理
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        employee.setCreateTime(new Date());
        employee.setUpdateTime(new Date());
        Long empId = (Long)request.getSession().getAttribute("employee");
        employee.setCreateUser(empId);
        employee.setUpdateUser(empId);
        employeeService.save(employee);
        return R.success("新增员工成功");

    }
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name){
        log.info("page = {},pageSize = {}, name = {}",page,pageSize,name);
        // 创建分页
        Page pageInfo = new Page(page, pageSize);
        QueryWrapper<Employee> employeeQueryWrapper = new QueryWrapper<>();
        employeeQueryWrapper.orderByDesc("create_time");
        if(name !=null){
            employeeQueryWrapper.like("name", name);
        }
        employeeService.page(pageInfo, employeeQueryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 根据id修改员工信息
     * @param employee
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Employee employee,HttpServletRequest request){
        log.info(employee.toString());
        Long empId = (Long) request.getSession().getAttribute("employee");
        employee.setUpdateUser(empId);
        employeeService.updateById(employee);
        return R.success("员工信息修改成功");
    }

    @GetMapping("/{id}")
    public R<Employee> getBtId(@PathVariable Long id){
        log.info("根据id查询员工信息...");
        Employee employee = employeeService.getById(id);
        return R.success(employee);
    }

}
