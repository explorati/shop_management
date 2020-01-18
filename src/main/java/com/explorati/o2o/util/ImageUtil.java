package com.explorati.o2o.util;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 21:36 2020/1/10 0010
 * @ Description ：图片处理工具类
 */
@Slf4j
public class ImageUtil {
    //1.获取项目的路径 如：D:\商城商铺管理系统\shop_management
    //  File file = new File("");
    //  String courseFile = file.getCanonicalPath();
    //  System.out.println(courseFile);
    //2.获取当前类的所在工程路径
    //  public static String path = this.class.getResource("").getPath() + "watermark.jpg";
    //3.根据当前线程去获取根路径
//    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//    private static String basePath = Thread.currentThread().getClass().getResource("/").getPath();
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * 将CommonMultipartFile转换成File
     *
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 生成图片,并返回图片的相对地址(对应shop的shop_img字段)
     *
     * @param fileName：输入的图片
     * @param targetAddr：输出路径
     * @return
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        log.debug("current relativeAddr is : " + PathUtil.getImgBasePath() + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        log.debug("current completeAddr is : " + dest);
        try {
            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            log.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取文件扩展名
     *
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     *
     * @return
     */
    public static String getRandomFileName() {
        //获取五位随机数
        int r = random.nextInt(10000, 99999);
        String dateTimeStr = dtf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(new Date().getTime()),
                ZoneId.of("Asia/Shanghai")));
        //字符串 + int 归为字符串
        return dateTimeStr + r;
    }

    //对Thumbnailator工具进行测试
    public static void main(String[] args) throws IOException {
        System.out.println(basePath);
        Thumbnails.of(new File("E:\\o2o_2.0\\pic\\金融.jpg"))
                .size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                .outputQuality(0.8)
                .toFile(new File("E:\\o2o_2.0\\pic\\financial.jpg"));
    }
}
