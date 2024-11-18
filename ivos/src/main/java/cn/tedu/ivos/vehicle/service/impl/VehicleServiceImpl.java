package cn.tedu.ivos.vehicle.service.impl;

import cn.tedu.ivos.base.exception.ServiceException;
import cn.tedu.ivos.base.response.StatusCode;
import cn.tedu.ivos.vehicle.mapper.VehicleMapper;
import cn.tedu.ivos.vehicle.pojo.dto.VehicleQuery;
import cn.tedu.ivos.vehicle.pojo.dto.VehicleSaveParam;
import cn.tedu.ivos.vehicle.pojo.entity.Vehicle;
import cn.tedu.ivos.vehicle.pojo.vo.VehicleVO;
import cn.tedu.ivos.vehicle.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleMapper vehicleMapper;

    @Override
    public List<VehicleVO> selectVehicle(VehicleQuery vehicleQuery) {
        log.debug("");
        List<VehicleVO>list=vehicleMapper.selectVehicle(vehicleQuery);
        return list;
    }

    @Override
    public void saveVehicle(VehicleSaveParam vehicleSaveParam) {
        log.debug("");
        Vehicle vehicle=new Vehicle();
        BeanUtils.copyProperties(vehicleSaveParam,vehicle);
        if (vehicle.getId()==null){
            vehicle.setCreateTime(new Date());
            vehicle.setStatus("1");
            vehicle.setGeofenceBindStatus("0");
            vehicleMapper.insert(vehicle);
        }else{
            vehicle.setCreateTime(new Date());
            vehicleMapper.update(vehicle);
        }
    }

    @Override
    public void deleteVehicle(Long id) {
        log.debug("");
        vehicleMapper.deleteVehicle(id);
    }

    @Override
    public void unbindById(Long id) {
        log.debug("");
        Vehicle vehicle=new Vehicle();
        vehicle.setId(id);
        vehicle.setGeofenceId(null);
        vehicle.setUpdateTime(new Date());
        vehicle.setGeofenceBindStatus("0");
        vehicleMapper.unbindById(vehicle);
    }

    @Override
    public void bindVehicle(Long geofenceId, Long vehicleId) {
        log.debug("绑定车辆业务:geofenceId={},vehicleId={}",geofenceId,vehicleId);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleId);
        vehicle.setGeofenceBindStatus("1");
        vehicle.setGeofenceId(geofenceId);
        vehicle.setUpdateTime(new Date());
        vehicleMapper.update(vehicle);
    }
}
