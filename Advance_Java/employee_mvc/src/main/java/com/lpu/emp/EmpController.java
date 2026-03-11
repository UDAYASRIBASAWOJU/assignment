package com.lpu.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpController {
	
	@Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/reg")
    public String showRegisterPage() {
        return "employeeRegister";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeDAO.saveEmployee(employee);
        return "redirect:/displayAll";
    }

    @RequestMapping("/displayAll")
    public String displayAll(Model model) {
        List<Employee> list = employeeDAO.getAllEmployees();
        model.addAttribute("employees", list);
        return "displayAll";
    }

    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeDAO.deleteEmployee(id);
        return "redirect:/displayAll";
    }

    @RequestMapping("/edit")
    public String editEmployee(@RequestParam("id") int id, Model model) {
        Employee emp = employeeDAO.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "updateEmployee";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeDAO.updateEmployee(employee);
        return "redirect:/displayAll";
    }
	
}
