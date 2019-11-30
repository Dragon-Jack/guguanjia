package com.dfbz.service;

import com.dfbz.entity.Detail;
import com.dfbz.entity.Transfer;
import com.dfbz.entity.Work;
import com.github.pagehelper.PageInfo;
import java.util.Map;

public interface WorkService extends Tservice<Work> {

    PageInfo<Work> selectSponsor(Map<String, Object> map);

    Work order(long id);

    Detail waste(long id);

    Transfer transport(long id);
}
