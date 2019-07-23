package com.mobanker.android.packager.controller;

import com.mobanker.android.packager.service.AndroidPackageService;
import com.mobanker.android.packager.utils.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("package")
public class AndroidPackageController {
    @Resource
    AndroidPackageService androidPackageService;

    /**
     * 更新git代码
     *
     * @return
     */
    @RequestMapping(value = "/updateCode", method = RequestMethod.POST)
    public ResponseEntity updateCode(@RequestParam("param") String... cmdParam) {
        return androidPackageService.updateCode(cmdParam);
    }

    /**
     * 上传文件
     *
     * @return
     */
    @RequestMapping(value = "/uploadIcon", method = RequestMethod.POST)
    public ResponseEntity uploadIcon(HttpServletRequest httpServletRequest) {
        DefaultMultipartHttpServletRequest multipartHttpServletRequest = (DefaultMultipartHttpServletRequest) httpServletRequest;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartHttpServletRequest.getFile("file");
        return androidPackageService.uploadIcon(file);
    }


    /**
     * 上传启动图片
     */
    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
    public ResponseEntity uploadLoadingPic(HttpServletRequest httpServletRequest) {
        DefaultMultipartHttpServletRequest multipartHttpServletRequest = (DefaultMultipartHttpServletRequest) httpServletRequest;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartHttpServletRequest.getFile("file");
        return androidPackageService.uploadLoadingPic(file);
    }


    /**
     * 替换对应文件及变量
     */
    @RequestMapping(value = "/replaceConfig", method = RequestMethod.POST)
    public ResponseEntity replaceConfig(HttpServletRequest httpServletRequest) {
        DefaultMultipartHttpServletRequest multipartHttpServletRequest = (DefaultMultipartHttpServletRequest) httpServletRequest;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartHttpServletRequest.getFile("file");
        return androidPackageService.replaceConfig(file);
    }

    /**
     * 执行打包脚本
     */
    @RequestMapping(value = "/com/mobanker/android/packager/service", method = RequestMethod.POST)
    public ResponseEntity packageApk() {
        return androidPackageService.packageApk();
    }

    /**
     * 执行打包脚本
     */
    @RequestMapping(value = "/downloadUrl", method = RequestMethod.POST)
    public ResponseEntity downloadUrl() {
        return androidPackageService.downLoadUrl();
    }

}
