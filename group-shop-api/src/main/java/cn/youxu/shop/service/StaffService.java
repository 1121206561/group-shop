package cn.youxu.shop.service;

import cn.youxu.shop.entity.EmployeeDTO;
import cn.youxu.shop.entity.EmployeeVO;
import cn.youxu.shop.entity.StaffDTO;
import com.github.pagehelper.PageInfo;

public interface StaffService {
    PageInfo<StaffDTO> getStaffs(String name, String jobNumber, String userRole, Integer page, Integer size);

    PageInfo<EmployeeDTO> getEmployees(EmployeeVO employeeVO, Integer page, Integer size);

    void updateTypeByJNumber(String jobNumber) throws Exception;

    void updateEmployeeByJNumber(EmployeeDTO employeeDTO) throws Exception;

    String getEmployeeAddress(String name, String jobNumber, String shopName);
}
