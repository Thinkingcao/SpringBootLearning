package com.thinkingcao.springbootfile.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @desc: 文件下载Controller
 * @author: cao_wencao
 * @date: 2019-11-21 17:10
 */
@Controller
public class DownloadController {
    /**
     * 文件下载
     *
     * @return
     */
    @RequestMapping("/download")
    public String downLoadFile(HttpServletRequest request, HttpServletResponse response) {
        // 文件名可以从request中获取, 这儿为方便, 写死了
        String fileName = "rtsch_ex.json";
        // String path = request.getServletContext().getRealPath("/");
        String path = "E:/test";
        File   file = new File(path, fileName);

        if (file.exists()) {
            // 设置强制下载打开
            response.setContentType("application/force-download");
            // 文件名乱码, 使用new String() 进行反编码
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);

            // 读取文件
            BufferedInputStream bi = null;
            try {
                byte[] buffer = new byte[1024];
                bi = new BufferedInputStream(new FileInputStream(new File("")));
                ServletOutputStream outputStream = response.getOutputStream();
                int                 i            = -1;
                while (-1 != (i = bi.read(buffer))) {
                    outputStream.write(buffer, 0, i);
                }
                return "下载成功";
            } catch (Exception e) {
                return "程序猿真不知道为什么, 反正就是下载失败了";
            } finally {
                if (bi != null) {
                    try {
                        bi.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "文件不存在";
    }
}
