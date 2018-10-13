package com.lxd.project2.service.impl;

import com.lxd.project2.dao.InformDao;
import com.lxd.project2.entity.Inform;
import com.lxd.project2.service.IInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/10/13 0013.
 */
@Transactional
@Service
public class InformServiceImpl implements IInformService {
    @Autowired
    private InformDao informDao;
    @Override
    public void add(Inform inform) {
        informDao.add(inform);
    }
}
