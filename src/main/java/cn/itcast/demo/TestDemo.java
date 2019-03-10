package cn.itcast.demo;

import org.csource.fastdfs.*;

public class TestDemo {
    /**
     * 上传
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1。加载配置文件
        ClientGlobal.init("E:\\IdeaProjects\\fastDFSdemo\\src\\main\\resources\\fdfs_client.conf");
        //E:\IdeaProjects\fastDFSdemo\src\main\resources
        //2.创建TrackerClient:管理者客户端
        TrackerClient trackerClient = new TrackerClient();
        //3.链接管理者服务端
        TrackerServer trackerServer = trackerClient.getConnection();
        //4.声明构建存储服务端
        StorageServer storageServer = null;
        //5.获取储存客户端对象
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //上传.参数1：文件所在地址，文件名。参数2.文件扩展名，一般不改版。参数3.文件扩展信息。strings上传结果（文件在服务器的路径文件名）
        String[] strings = storageClient.upload_appender_file("D:\\JAVA\\aaa.jpg", "jpg", null);

        /**
         * 便利结果
         *group1
         *M00/00/00/wKgZhVxLNCSEJexcAAAAAFBNDuU369.jpg
         */
        for (String string : strings) {
            System.out.println(string);
        }


    }
}
