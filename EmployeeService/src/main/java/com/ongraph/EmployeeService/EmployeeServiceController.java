package com.ongraph.EmployeeService;

import com.ongraph.EmployeeService.dto.ResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


@RestController
public class EmployeeServiceController {

    private static final Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>() {

        private static final long serialVersionUID = -3970206781360313502L;

        {
            put(111, new Employee(111, "Employee1"));
            put(222, new Employee(222, "Employee2"));
        }

    };

    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO getEmployeeDetails(@PathVariable int employeeId) {
        ResponseDTO<Employee> responseDTO = new ResponseDTO<>();
        try {
            System.out.println("Getting Employee details for " + employeeId);

            Employee employee = employeeData.get(employeeId);
            if (employee == null) {

                employee = new Employee(0, "N/A");
            }
            responseDTO.setSuccessResponse(employee, "Success");
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            responseDTO.setErrorResponse(ex, "Some error occured");
        }
        return responseDTO;
    }

}
