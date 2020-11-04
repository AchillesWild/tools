package com.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

/**
 * 上传的excel数据解析时对应的实体
 * 字段中index为excel列的值，第一列为0;
 */
public class DreamBenefitExcelUploadVO implements Serializable {

    private static final long serialVersionUID = -4486741818794596662L;

    /**
     *   商品id
     */
    @ExcelProperty(index = 0)
    private Long itemId;

    @ExcelProperty("名称")
    private String name;

    /**
     *   投放时间
     */
    @ExcelProperty(index = 1)
    private Date publishDate;

    /**
     * 投放结束时间
     */
    @ExcelProperty(index = 2)
    private Date publishDateEnd;

    /**
     *   参加权益商品数量
     */
    @ExcelProperty(index = 3)
    private Integer itemCount;

    /**
     *   最大可参与人数
     */
    @ExcelProperty(index = 4)
    @ColumnWidth(18)
    private Integer maxUserCount;

    @ExcelIgnore
    private Integer fire;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getPublishDateEnd() {
        return publishDateEnd;
    }

    public void setPublishDateEnd(Date publishDateEnd) {
        this.publishDateEnd = publishDateEnd;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getMaxUserCount() {
        return maxUserCount;
    }

    public void setMaxUserCount(Integer maxUserCount) {
        this.maxUserCount = maxUserCount;
    }

    public Integer getFire() {
        return fire;
    }

    public void setFire(Integer fire) {
        this.fire = fire;
    }
}
