package cn.youxu.shop.service.impl;

import cn.youxu.shop.entity.EmployeeDTO;
import cn.youxu.shop.entity.EmployeeVO;
import cn.youxu.shop.entity.StaffDTO;
import cn.youxu.shop.exception.ServiceException;
import cn.youxu.shop.mapper.StaffMapper;
import cn.youxu.shop.service.StaffService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public PageInfo<StaffDTO> getStaffs(String name, String jobNumber,String userRole, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<StaffDTO> staffs = staffMapper.getStaffs(name, jobNumber, userRole);
        PageInfo staffDTOPageInfo = new PageInfo<>(staffs);
        return staffDTOPageInfo;
    }

    @Override
    public PageInfo<EmployeeDTO> getEmployees(EmployeeVO employeeVO, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(staffMapper.getEmployees(employeeVO));
    }

    @Override
    @Transactional
    public void updateTypeByJNumber(String jobNumber) throws Exception {
        Integer type = 1;
        if (staffMapper.updateTypeByJNumber(jobNumber, type) != 1){
            throw new ServiceException("该团长不能被审核");
        }
    }

    @Override
    @Transactional
    public void updateEmployeeByJNumber(EmployeeDTO employeeDTO) throws Exception {
        if (staffMapper.updateEmployeeByJNumber(employeeDTO) != 1){
            throw new ServiceException("团长信息更新失败");
        }
    }

    @Override
    public String getEmployeeAddress(String name, String jobNumber, String shopName) {
        return staffMapper.getEmployeeAddress(name,jobNumber,shopName);
    }
}
