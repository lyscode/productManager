package cn.LysGroup.dao;

import cn.LysGroup.domain.SysLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDao {
    /**
     * 保存日志信息
     * @param sysLog
     */
    void save(SysLog sysLog);

    /**
     * 查询所有日志
     * @return
     */
    List<SysLog> findAll();
}
