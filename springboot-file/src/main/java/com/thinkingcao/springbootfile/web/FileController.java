package com.thinkingcao.springbootfile.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * <pre>
 * @Desc:
 * @Package: com.thinkingcao.springbootfile.web
 * @Author: cao_wencao
 * @Date: 2019-03-08 17:18
 * </pre>
 */
@Controller
public class FileController {
    @Value("{file.path}")
    private String filePath;

    public String fileUpload(){
       return "";
    }
}
