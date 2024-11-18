package cn.tedu.ivos.geofence.service.impl;

import cn.tedu.ivos.geofence.mapper.GeofenceMapper;
import cn.tedu.ivos.geofence.pojo.dto.GeofenceQuery;
import cn.tedu.ivos.geofence.pojo.dto.GeofenceSaveParam;
import cn.tedu.ivos.geofence.pojo.entity.Geofence;
import cn.tedu.ivos.geofence.pojo.vo.GeofenceVO;
import cn.tedu.ivos.geofence.service.GeofenceService;
import cn.tedu.ivos.vehicle.mapper.VehicleMapper;
import cn.tedu.ivos.vehicle.pojo.entity.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class GeofenceServiceImpl implements GeofenceService {
    @Autowired
    GeofenceMapper geofenceMapper;
    VehicleMapper vehicleMapper;

    @Override
    public List<GeofenceVO> selectGeofence(GeofenceQuery geofenceQuery) {
        log.debug("查询电子围栏业务:geofenceQuery={}",geofenceQuery);
        List<GeofenceVO> list = geofenceMapper.selectGeofence(geofenceQuery);
        return list;
    }

    @Override
    public void saveGeofence(GeofenceSaveParam geofenceSaveParam) {
        log.debug("保存电子围栏业务:geofenceSaveParam={}",geofenceSaveParam);
        Geofence geofence = new Geofence();
        BeanUtils.copyProperties(geofenceSaveParam,geofence);
        log.debug("中间数据:geofence={}",geofence);
        if(geofence.getId()!=null){//修改
            geofence.setUpdateTime(new Date());
            geofenceMapper.update(geofence);
        }else{//新增
            geofence.setStatus("1");//启用状态
            geofence.setCreateTime(new Date());
            geofenceMapper.insert(geofence);
        }
    }

    @Override
    public void deleteGeofence(Long id) {
        Vehicle vehicle=new Vehicle();
        vehicle.setGeofenceId(id);
        vehicle.setGeofenceBindStatus("0");
        vehicle.setUpdateTime(new Date());
        vehicleMapper.updateGeofenceId(vehicle);
        geofenceMapper.deleteGeofence(id);
    }

}
