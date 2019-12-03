package com.dfbz.service;

import com.dfbz.entity.Area;

import java.io.InputStream;

public interface AreaService extends Tservice<Area>{

    void writeExcel();


    void readExcel(InputStream inputStream);

}
