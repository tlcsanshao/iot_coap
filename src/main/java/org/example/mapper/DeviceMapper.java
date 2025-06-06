package org.example.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Device;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 设备信息表 Mapper 接口
 * </p>
 *
 * @author sanshao
 * @since 2025-06-04
 */
public interface DeviceMapper extends BaseMapper<Device> {
    //    @Select("<script>" +
    //            "SELECT * FROM device " +
    //            "<where>" +
    //            "   <if test='keyword != null and keyword != \"\"'> AND (company_name LIKE CONCAT('%', #{keyword}, '%'))</if>" +
    //            "   <if test='priority != null'> AND priority = #{priority}</if>" +
    //            "</where>" +
    //            "ORDER BY " +
    //            "   CASE priority " +
    //            "      WHEN 'URGENT' THEN 1 " +
    //            "      WHEN 'HIGH' THEN 2 " +
    //            "      WHEN 'MEDIUM' THEN 3 " +
    //            "      WHEN 'LOW' THEN 4 " +
    //            "      ELSE 5 " +
    //            "   END, " +
    //            "   create_time DESC" +
    //            "</script>")


    @Select("<script>" +
            "SELECT * FROM device " +
            "<where>" +
            "   <if test='keyword != null and keyword != \"\"'>" +
            "       AND (name LIKE CONCAT('%', #{keyword}, '%') OR sn LIKE CONCAT('%', #{keyword}, '%'))" +
            "   </if>" +
            "</where>" +
            "</script>")
    Page<Device> selectDeviceList(Page<Device> page, @Param("keyword") String keyword);

}
