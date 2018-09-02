package com.yuanbao.park.service;

import java.util.List;

import com.yuanbao.park.entity.Ceshi;

public interface TestService {
      List<Ceshi> findCeshiList();

    Ceshi insert(Ceshi ceshi);
}
