package controller;

import model.Employee;
import service.EmployeeEJB;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;

import entities.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

@ManagedBean(value = "employeecontroller")
@SessionScoped
public class EmployeeController implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
    private EmployeeEJB employeeEJB;
    
  //from form
  	@ManagedProperty(value="#{employee}")
    private Employee employee;
  	
    private List<EmployeeEntity> employeeList = new ArrayList<>();
 
   public List<EmployeeEntity> getEmployeeList() {
        employeeList = employeeEJB.findEmployees();
        return employeeList;
    }
 
   public String viewEmployee(){
        return "employeeList.xhtml";
    }
   
    public String addNewEmployee() {
         employeeEJB.addNew(employee.getEntity());
         employeeList = employeeEJB.findEmployees();
        return "employeeList.xhtml?faces-redirect=true";
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
    
}