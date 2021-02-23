package cn.youxu.shop.mapper;

import cn.youxu.shop.entity.EmployeeDTO;
import cn.youxu.shop.entity.EmployeeVO;
import cn.youxu.shop.entity.StaffDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StaffMapper {
    List<StaffDTO> getStaffs(@Param("name") String name, @Param("jobNumber") String jobNumber,@Param("userRole")String userRole);

    List<EmployeeDTO> getEmployees(@Param("employeeVO") EmployeeVO employeeVO);

    int updateTypeByJNumber(@Param("jobNumber") String jobNumber, @Param("type") Integer type);

    int updateEmployeeByJNumber(@Param("employeeDTO") EmployeeDTO employeeDTO);

    String getEmployeeAddress(@Param("name") String name, @Param("jobNumber") String jobNumber, @Param("shopName") String shopName);
}
