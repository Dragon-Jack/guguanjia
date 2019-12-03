package com.dfbz.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.dfbz.dao.AreaMapper;
import com.dfbz.entity.Area;

import java.util.ArrayList;

public class ListenerArea extends AnalysisEventListener<Area> {
    private ArrayList<Area> list = new ArrayList<>();
    private AreaMapper areaMapper;

    public ListenerArea() {
    }

    public ListenerArea(AreaMapper mapper) {
        this.areaMapper = mapper;
    }


    @Override
    public void invoke(Area area, AnalysisContext analysisContext) {
        list.add(area);
        if (list.size() >= 5) {
            areaMapper.insertBatch(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (list.size()>0){
            areaMapper.insertBatch(list);
            list.clear();
        }
    }
}
