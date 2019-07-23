package com.mobanker.android.packager.service;

import com.mobanker.android.packager.utils.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: liuhanqing
 * @desc: 安卓马甲包打包apkapi
 * @date 2019/1/18 17:48
 */
public interface AndroidPackageService {

    //上传git代码
    public ResponseEntity updateCode(@RequestParam("cmdArgs") String... cmdParam);

    //上传图标
    public ResponseEntity uploadIcon(MultipartFile upLoadFileParam);

    //上传启动图片
    public ResponseEntity uploadLoadingPic(MultipartFile upLoadFileParam);

    //替换配置参数
    ResponseEntity replaceConfig(MultipartFile configFile);

    //运行打包apk脚本
    public ResponseEntity packageApk();

    //文件下载链接
    public ResponseEntity downLoadUrl();
}
