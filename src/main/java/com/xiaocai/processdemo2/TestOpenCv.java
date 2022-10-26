package com.xiaocai.processdemo2;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.net.URL;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.imgproc.Imgproc.COLOR_RGB2GRAY;
import static org.opencv.imgproc.Imgproc.cvtColor;

/**
 * @description: 本测试类参考网上用例，先从github上下载openCv后，引入到java项目中，将灰色图片导成灰度图再打开
 *
 * https://blog.csdn.net/m0_67400973/article/details/126392091
 * @author: xiaocai
 * @time: 2022/10/25 14:44
 */
public class TestOpenCv {
    public static void main(String[] args) throws Exception {

        // 加载动态库
//        URL url = ClassLoader.getSystemResource("lib/opencv/opencv_java440.dll");
//        System.load(url.getPath());

        //测试将图片转成灰度图
//        testImg2Gray();
        // 解决awt报错问题
        System.setProperty("java.awt.headless", "false");
        System.out.println(System.getProperty("java.library.path"));
        // 加载动态库
        URL url = ClassLoader.getSystemResource("lib/opencv_java460.dll");
        System.load(url.getPath());

        Mat faceImag = imread("C:\\Users\\xiaocai\\Pictures\\wall\\11.jpg");
        // 人脸识别器
        CascadeClassifier faceDetector = new CascadeClassifier("F:\\openCvFile\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
        // 在图片中检测人脸
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(faceImag,faceDetections);
        Rect[] rects = faceDetections.toArray();
        if(rects != null && rects.length >= 1){
            for (Rect rect : rects) {

                Imgproc.rectangle(faceImag,rect, Scalar.all(1));
            }
        }
        imshow("人脸检测图片",faceImag);
        waitKey();
//        原文链接：https://blog.csdn.net/qq_44654974/article/details/116355598

    }

    private static void testImg2Gray() throws Exception {
        // 解决awt报错问题
        System.setProperty("java.awt.headless", "false");
        System.out.println(System.getProperty("java.library.path"));
        // 加载动态库
        URL url = ClassLoader.getSystemResource("lib/opencv_java460.dll");
        System.load(url.getPath());
        // 读取图像
        Mat image = imread("C:\\Users\\xiaocai\\Pictures\\backiee-113407(1).jpg");
        if (image.empty()) {
            throw new Exception("image is empty");
        }
        imshow("Original Image", image);

        // 创建输出单通道图像
        Mat grayImage = new Mat(image.rows(), image.cols(), CvType.CV_8SC1);
        // 进行图像色彩空间转换
        cvtColor(image, grayImage, COLOR_RGB2GRAY);

        imshow("Processed Image", grayImage);
        imwrite("d:/backiee-113407(1).jpg", grayImage);
        waitKey();
    }
}
