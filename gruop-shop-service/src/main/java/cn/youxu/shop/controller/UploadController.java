package cn.youxu.shop.controller;

import cn.youxu.shop.common.CommonResponse;
import cn.youxu.shop.utils.QcloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private QcloudProvider qcloudProvider;

    @PostMapping("/img")
    public CommonResponse uploadTeacherImg(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            String url = qcloudProvider.FileToCos(inputStream);
            return CommonResponse.ok().data("images", url);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResponse.error();
        }
    }
}
