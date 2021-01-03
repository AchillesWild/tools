package com.achilles.wild.server.listener;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class UploadExcelListener<T>  extends AnalysisEventListener<T> {


    private List<T> list = new ArrayList<>();


    public List<T> getList() {
        return list;
    }

    /**
     * 逐条读取，加入集合
     * @param excelModel
     * @param analysisContext
     */
    @Override
    public void invoke(T excelModel, AnalysisContext analysisContext) {
        list.add(excelModel);
    }

    /**
     * 最终处理
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
