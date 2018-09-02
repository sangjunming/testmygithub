package com.yuanbao.park.controller;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.yuanbao.park.common.utils.MyStringUtils;


/**
 * @author: CrazyZhou
 * @description: 上传图片接口
 * @date: 2018-06-28 10:06
 * @param:
 */
@Api("文件上传相关接口")
@Controller
@RequestMapping("/fileUploadServer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileUploadController {

    @Autowired
    private Environment environment;

    private Logger logger = LoggerFactory.getLogger(getClass());


    //上传文件方法
    //@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, headers = "Accept=*/*;charset=UTF-8")
    @ApiOperation("上传图片相关接口")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ajaxUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
        //上传文件属于什么类型的图片:公司基本信息,公司资料......
        String fileOwner = request.getParameter("fileOwner");
        //从配置文件读取保存根目录路径
        String uploadRootPath = environment.getProperty("ybpark.sourcesSavePath.companyDataImage");
        //根据上传文件不同分类 设置不同的保存路径
        String uploadPath = uploadRootPath + "/" + fileOwner;
        //转换请求
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获得上传的文件
        MultipartFile mulfile = multipartRequest.getFile("file");
        //获取之前的文件名
        String fileOldName = mulfile.getOriginalFilename();
        //文件名称处理
        String fileNewName = new Date().getTime() + "" + fileOldName;
        //根据日期 构建新的存储路径
        String uploadNewPath = getAbsolutePath(uploadPath + "/");
        File file = new File(uploadNewPath + "/" + fileNewName);
        //设置可读权限
        file.setReadable(true);
        //设置可写权限
        file.setWritable(true);
        //保存文件
        mulfile.transferTo(file);
        //返回路径
        return JSON.toJSONString(file.getAbsolutePath().replaceAll("\\\\", "/").replace(uploadPath, ""));
    }

    //文件名称处理
    private String handlerFileName(String fileName) {
        //此处不用fileName,有中文的名称时会出问题,采用时间撮加随机字符
        int dotIndex = fileName.lastIndexOf(".");
        String fileType = fileName.substring(dotIndex);
        fileName = (new Date()).getTime() + "_" + MyStringUtils.getRandomChar(8) + fileType;
        //时间戳+文件名，防止覆盖重名文件
        return fileName;
    }

    private static String getAbsolutePath(String rootDir) {
        Calendar date = Calendar.getInstance();
        File file = new File(rootDir + File.separator + date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1) + File.separator
                + date.get(Calendar.DAY_OF_MONTH));
        //目录不存在则直接创建
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }


    /*//预览，获取图片流
    @RequestMapping(value = "/readImage", produces = "text/plain;charset=UTF-8")
    public void readImage(HttpServletRequest request, HttpServletResponse response){
        String imagePath = request.getSession().getServletContext().getRealPath("/")+request.getParameter("imagePath");
        try{
            File file = new File(imagePath);
            if (file.exists()) {
                DataOutputStream temps = new DataOutputStream(response
                        .getOutputStream());
                DataInputStream in = new DataInputStream(
                        new FileInputStream(imagePath));
                byte[] b = new byte[2048];
                while ((in.read(b)) != -1) {
                    temps.write(b);
                    temps.flush();
                }
                in.close();
                temps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    /**
     * @author: CrazyZhou
     * @description: 上传EXCEL文件的方法
     * @date: 10:37 2018/6/28
     * @param:  * @param null
     * @return:
     */
    @RequestMapping(value = "/uploadExcelFile", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String uploadExcelFile(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException,
            IOException {
        String mediaSourcesFileSavePath = environment.getProperty("ybpark.sourcesSavePath.excelSavePath");
        //转换请求
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获得上传的文件
        MultipartFile mulfile = multipartRequest.getFile("file");
        //获取之前的文件名
        String fileOldName = mulfile.getOriginalFilename();
        //文件名称处理
        String fileNewName = new Date().getTime() + "" + fileOldName;
        //根据日期 构建新的存储路径
        String uploadNewPath = getAbsolutePath(mediaSourcesFileSavePath + "/");
        File file = new File(uploadNewPath + "/" + fileNewName);
        //设置可读权限
        file.setReadable(true);
        //设置可写权限
        file.setWritable(true);
        //保存文件
        mulfile.transferTo(file);
        //返回路径
        return JSON.toJSONString(file.getAbsolutePath().replaceAll("\\\\", "/").replace(mediaSourcesFileSavePath, ""));
    }

    private static String getAbsolutePathC1(String rootDir) {
        Calendar date = Calendar.getInstance();
        File file = new File(rootDir + File.separator + date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1) + File.separator
                + date.get(Calendar.DAY_OF_MONTH) + System.currentTimeMillis());
        //目录不存在则直接创建
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
