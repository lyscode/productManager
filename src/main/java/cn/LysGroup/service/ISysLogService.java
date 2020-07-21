package cn.LysGroup.service;

import cn.LysGroup.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    //保存日志
    void save(SysLog sysLog);

    /**
     * 查询所有
     * @return
     */
    List<SysLog> findAll(int page,int size);

}
