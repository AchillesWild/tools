package com.tool.file.excel;

public class EasyExcelUtil {
    ///**
    // * 最简单的读
    // * <p>
    // * 1. 创建excel对应的实体对象 参照{@link DemoData}
    // * <p>
    // * 2. 由于默认异步读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
    // * <p>
    // * 3. 直接读即可
    // */
    //
    public void simpleRead() {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
      //  EasyExcel.read("/Users/achilleswild/Desktop/test.xls", Citizen.class, new UploadExcelListener(null)).sheet().doRead();
    }
}
