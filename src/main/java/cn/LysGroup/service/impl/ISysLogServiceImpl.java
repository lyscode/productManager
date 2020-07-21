package cn.LysGroup.service.impl;

import cn.LysGroup.dao.LogDao;
import cn.LysGroup.domain.SysLog;
import cn.LysGroup.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISysLogServiceImpl implements ISysLogService {
    @Autowired
    private LogDao dao;
    @Override
    public void save(SysLog sysLog) {
        try {
            dao.save(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SysLog> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        List<SysLog> all = dao.findAll();
        return all;
    }
}
