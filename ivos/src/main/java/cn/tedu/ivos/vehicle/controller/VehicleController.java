package cn.tedu.ivos.vehicle.controller;

import cn.tedu.ivos.base.response.JsonResult;
import cn.tedu.ivos.vehicle.pojo.dto.VehicleQuery;
import cn.tedu.ivos.vehicle.pojo.dto.VehicleSaveParam;
import cn.tedu.ivos.vehicle.pojo.vo.VehicleVO;
import cn.tedu.ivos.vehicle.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @GetMapping("/select")
    public JsonResult selectVehicle(VehicleQuery vehicleQuery){
        log.debug("");
        List<VehicleVO>list=vehicleService.selectVehicle(vehicleQuery);
        log.debug("{}"+list);
        return JsonResult.ok(list);
    }
    @PostMapping("/save")
    public JsonResult saveVehicle(VehicleSaveParam vehicleSaveParam){
        log.debug("");
        vehicleService.saveVehicle(vehicleSaveParam);
        return JsonResult.ok();
    }
    @PostMapping("/delete")
    public JsonResult deleteVehicle(@PathVariable Long id){
        log.debug("");
        vehicleService.deleteVehicle(id);
        return JsonResult.ok();
    }
    @PostMapping("/unbind/{id}")
    public JsonResult UnbindById(@PathVariable Long id){
        log.debug("");
        vehicleService.unbindById(id);
        return JsonResult.ok();
    }
    @PostMapping("bind/{geofenceId}/{vehicleId}")
    public JsonResult bindVehicle(
            @PathVariable Long geofenceId,@PathVariable Long vehicleId){
        log.debug("绑定车辆:geofenceId={},vehicleId={}",geofenceId,vehicleId);
        vehicleService.bindVehicle(geofenceId,vehicleId);
        return JsonResult.ok();
    }
}
