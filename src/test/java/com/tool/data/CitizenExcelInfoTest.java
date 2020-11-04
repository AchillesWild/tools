package com.tool.data;

import com.service.impl.CitizenServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CitizenExcelInfoTest{

    @Spy
    @InjectMocks
    private CitizenServiceImpl citizenServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void simpleRead() {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
      //  EasyExcel.read("/Users/achilleswild/Desktop/test.xls", DreamBenefitExcelUploadVO.class, new UploadExcelListener(citizenServiceImpl)).sheet().doRead();
    }
}
