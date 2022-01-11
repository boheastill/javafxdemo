package cn.i623.alpha.javafxdemo.db.mapper;

import cn.i623.alpha.javafxdemo.db.domain.XsElement;
import org.apache.ibatis.annotations.Param;

public interface XsElementMapper {
    int deleteByPrimaryKey(@Param("eleSn") Integer eleSn, @Param("isDel") Integer isDel);

    int insert(XsElement record);

    int insertSelective(XsElement record);

    XsElement selectByPrimaryKey(@Param("eleSn") Integer eleSn, @Param("isDel") Integer isDel);

    int updateByPrimaryKeySelective(XsElement record);

    int updateByPrimaryKey(XsElement record);
}