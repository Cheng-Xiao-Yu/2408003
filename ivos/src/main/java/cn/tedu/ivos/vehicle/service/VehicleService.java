package cn.tedu.ivos.vehicle.service;

import cn.tedu.ivos.vehicle.pojo.dto.VehicleQuery;
import cn.tedu.ivos.vehicle.pojo.dto.VehicleSaveParam;
import cn.tedu.ivos.vehicle.pojo.vo.VehicleVO;

import java.util.List;

public interface VehicleService {

    List<VehicleVO> selectVehicle(VehicleQuery vehicleQuery);

    void saveVehicle(VehicleSaveParam vehicleSaveParam);

    void deleteVehicle(Long id);

    void unbindById(Long id);

    void bindVehicle(Long geofenceId, Long vehicleId);
}
