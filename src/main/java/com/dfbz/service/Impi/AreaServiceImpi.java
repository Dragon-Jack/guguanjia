package com.dfbz.service.Impi;

import com.dfbz.entity.Area;
import com.dfbz.service.AreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AreaServiceImpi extends TserviceImpi<Area> implements AreaService {
}
