package cn.youxu.shop.controller;

import cn.youxu.shop.common.CommonResponse;
import cn.youxu.shop.entity.EmployeeDTO;
import cn.youxu.shop.entity.EmployeeVO;
import cn.youxu.shop.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "员工接口实现")
@RequestMapping("/person")
@CrossOrigin
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/staff")
    @ApiOperation("员工信息查询")
    public CommonResponse getEmployee(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String jobNumber,
                                      @RequestParam(required = false) String userRole,
                                      @RequestParam(required = false, defaultValue = "1") Integer page,
                                      @RequestParam(required = false, defaultValue = "10") Integer size) {
        try {
            return CommonResponse.ok().data("content", staffService.getStaffs(name, jobNumber, userRole, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/employee")
    @ApiOperation("团长信息查询")
    public CommonResponse getEmployee(@RequestBody(required = false) EmployeeVO employeeVO,
                                      @RequestParam(required = false, defaultValue = "1") Integer page,
                                      @RequestParam(required = false, defaultValue = "10") Integer size) {
        try {
            return CommonResponse.ok().data("content", staffService.getEmployees(employeeVO, page, size));
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateEmployeeByJNumber")
    @ApiOperation("团长信息更新")
    public CommonResponse getEmployee(@RequestBody(required = false) EmployeeDTO employeeDTO) {
        try {
            staffService.updateEmployeeByJNumber(employeeDTO);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error();
        }
    }

    @PostMapping("/updateTypeByJNumber")
    @ApiOperation("团长审核")
    public CommonResponse updateTypeByJNumber(@RequestParam String jobNumber) {
        try {
            staffService.updateTypeByJNumber(jobNumber);
            return CommonResponse.ok();
        } catch (Exception e) {
            return CommonResponse.error().message(e.getMessage());
        }
    }
}
