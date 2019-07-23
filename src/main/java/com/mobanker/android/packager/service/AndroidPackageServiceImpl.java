package com.mobanker.android.packager.service;

import com.mobanker.android.packager.utils.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mobanker.android.packager.utils.ErrorCode;
import com.mobanker.android.packager.utils.FileUtil;
import com.mobanker.android.packager.utils.ResponseEntityBuilder;

import java.io.*;
import java.util.logging.Logger;

/**
 * @author: liuhanqing
 * @desc:
 * @date 2019/1/18 17:48
 */
@Service
public class AndroidPackageServiceImpl implements AndroidPackageService {
    private String iconPath = "";
    private String copyCodePath = "";

    private String[] commands = new String[]{"cd " + copyCodePath, "gradle assembleRelease"};
    //config.txt的路径
    private String configPath = "";

    /**
     * 参数顺序为:仓库地址 仓库名
     *
     * @return
     */
    @Override
    public ResponseEntity updateCode(String... cmdParam) {
        ResponseEntity ResponseEntity = null;
        try {
            //这里固定取第二个参数即仓库名
            copyCodePath = "~/" + cmdParam[1];
            iconPath = copyCodePath + "/app/src/main/res/drawable/";
            //config文件保存到代码顶级目录
            configPath = copyCodePath;
            //脚本的存放路径
            StringBuilder scriptPath = new StringBuilder("/Users/wangfaguo/Documents/javaTest.sh");
            //为了解决参数中包含空格
            for (String s : cmdParam) {
                scriptPath.append(" ").append(s);
            }
            System.out.println(scriptPath);
            //解决脚本没有执行权限
//            ProcessBuilder builder = new ProcessBuilder("/bin/chmod", "755", scriptPath);
//            Process process = builder.start();
//            process.waitFor();
            Process process = Runtime.getRuntime().exec(scriptPath.toString());
            SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            // next command
            InputStreamReader isr = new InputStreamReader(sis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n"
                );
            }
            String result = sb.toString();
            br.close();
            isr.close();
            process.destroy();
            //执行结果
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntityBuilder.buildErrorResponse("40000080", "代码仓库拉取或更新出错");
        }
        return ResponseEntity;

    }

    /**
     * @param upLoadFile
     * @return
     */
    @Override
    public ResponseEntity uploadIcon(MultipartFile upLoadFile) {
        //检验参数
        ResponseEntity ResponseEntity = checkFileParam(upLoadFile);
        if (!ResponseEntityBuilder.isSuccess2(ResponseEntity)) {
            return ResponseEntity;
        }
        String refoundImg = "ic_launcher.png";
        File fileDir = new File(iconPath);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        File iconFile = new File(iconPath + refoundImg);
        try {
            upLoadFile.transferTo(iconFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return ResponseEntityBuilder.buildErrorResponse(ErrorCode.SYS_FIlE_EXCEPTION);
        }
        return ResponseEntityBuilder.buildNormalResponse();
    }

    @Override
    public ResponseEntity uploadLoadingPic(MultipartFile upLoadFile) {
        //检验参数
        ResponseEntity ResponseEntity = checkFileParam(upLoadFile);
        if (!com.mobanker.android.packager.utils.ResponseEntityBuilder.isSuccess2(ResponseEntity)) {
            return ResponseEntity;
        }
        String refoundImg = "launching.png";

        File fileDir = new File(iconPath);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        File iconFile = new File(iconPath + refoundImg);
        try {
            upLoadFile.transferTo(iconFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            ResponseEntityBuilder.buildErrorResponse(ErrorCode.SYS_FIlE_EXCEPTION);
        }
        return ResponseEntityBuilder.buildNormalResponse();
    }

    /**
     * 上传config文件
     *
     * @return
     */
    @Override
    public ResponseEntity replaceConfig(MultipartFile configFile) {
        String fileName = "config.txt";
        File fileDir = new File(configPath);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        try {
            configFile.transferTo(new File(copyCodePath + fileName));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return ResponseEntityBuilder.buildErrorResponse(ErrorCode.SYS_FIlE_EXCEPTION);
        }
        return ResponseEntityBuilder.buildNormalResponse();
    }

    @Override
    public ResponseEntity packageApk() {
        ResponseEntity ResponseEntity = ResponseEntityBuilder.buildNormalResponse();
        try {
            Process process = Runtime.getRuntime().exec("cmd");
            SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            // next command
            OutputStreamWriter osw = new OutputStreamWriter(process.getOutputStream());
            InputStreamReader isr = new InputStreamReader(sis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(osw);
            for (String s : commands) {
                System.out.println("待执行的语句是" + s);
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            osw.close();
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
                if (line.startsWith("BUILD SUCCESSFUL")) {
                    //打包成功
                    ResponseEntity = ResponseEntityBuilder.buildNormalResponse();
                } else if (line.startsWith("BUILD FAILED")) {
                    ResponseEntity = ResponseEntityBuilder.buildErrorResponse(ErrorCode.SYS_ERROR);
                }
            }
            String result = sb.toString();
            br.close();
            isr.close();
            process.destroy();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntityBuilder.buildErrorResponse(ErrorCode.SYS_ERROR);
        }
        return ResponseEntity;
    }

    @Override
    public ResponseEntity downLoadUrl() {
        //复制文件到容器文件夹下
        String newFilePath = "F:/IDEAworkspace/qingjie/war-uzone-llcs-manage2/llcs_manage_application/target/uzone-llcs-manage2/WEB-INF/app-release.apk";
        try {
            FileUtil.copyFile(copyCodePath + "\\app\\release\\app-release.apk", newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseEntity ResponseEntity = ResponseEntityBuilder.buildNormalResponse();
        ResponseEntity.setData("http://192.168.33.83:8090/uzone-llcs-manage2/file/app-release.apk");
        return ResponseEntity;
    }

    /**
     * 检验前端传入上传参数
     *
     * @param upLoadFileParam
     * @return
     */
    private ResponseEntity checkFileParam(MultipartFile upLoadFileParam) {
        boolean IS_FILE_EMPTY = upLoadFileParam == null;
        if (IS_FILE_EMPTY) {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCode.PARAM_VALID);
        }
        return ResponseEntityBuilder.buildNormalResponse();
    }
    //测试代码，已成功.这个暂时只是一种思路，具体完善还有很多路要走
    //脚本内容--更新代码库
//    #!/bin/bash
//#此处默认用户主目录,如有必要可以把目标路径传进来，需要与对应的service在同一机器上
//    cd ~
//    echo "$1"
//    echo "$2"
//            if [[ ! -d $2 ]]; then
//    git clone $1&&cd $2&&git pull
//else
//    cd $2&&git pull
//    fi
    public static void main(String... cmdParam) {
        try {
            cmdParam = new String[]{"git@gitlab.ql.corp:root/android-kdc.git", "android-kdc"};
            //脚本的存放路径
            StringBuilder scriptPath = new StringBuilder("/Users/wangfaguo/Documents/javaTest.sh");
            //为了解决参数中包含空格
            for (String s : cmdParam) {
                scriptPath.append(" ").append(s);
            }
            System.out.println(scriptPath);
            //解决脚本没有执行权限
//            ProcessBuilder builder = new ProcessBuilder("/bin/chmod", "755", scriptPath);
//            Process process = builder.start();
//            process.waitFor();
            Process process = Runtime.getRuntime().exec(scriptPath.toString());
            SequenceInputStream sis = new SequenceInputStream(process.getInputStream(), process.getErrorStream());
            // next command
            InputStreamReader isr = new InputStreamReader(sis, "GBK");
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n"
                );
            }
            String result = sb.toString();
            br.close();
            isr.close();
            process.destroy();
            //执行结果
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
