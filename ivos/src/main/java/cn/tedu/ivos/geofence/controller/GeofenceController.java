package cn.tedu.ivos.geofence.controller;

import cn.tedu.ivos.base.response.JsonResult;
import cn.tedu.ivos.geofence.pojo.dto.GeofenceQuery;
import cn.tedu.ivos.geofence.pojo.dto.GeofenceSaveParam;
import cn.tedu.ivos.geofence.pojo.vo.GeofenceVO;
import cn.tedu.ivos.geofence.service.GeofenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/geofence")
public class GeofenceController {
    @Autowired
    GeofenceService geofenceService;

    @GetMapping("select")
    public JsonResult selectGeofence(GeofenceQuery geofenceQuery){
        log.debug("查询电子围栏:geofenceQuery={}",geofenceQuery);
        List<GeofenceVO> list =  geofenceService.selectGeofence(geofenceQuery);
        return JsonResult.ok(list);
    }

    @PostMapping("save")
    public JsonResult saveGeofence(GeofenceSaveParam geofenceSaveParam){
        log.debug("保存电子围栏:geofenceSaveParam={}",geofenceSaveParam);
        //按Ctrl接口  按Ctrl+Alt去实现类
        geofenceService.saveGeofence(geofenceSaveParam);
        return JsonResult.ok();
    }
    @PostMapping("deleteGeofence/{geofenceId}")
    public JsonResult deleteGeofence(@PathVariable Long geofenceId){
        geofenceService.deleteGeofence(geofenceId);
        return JsonResult.ok();
    }
}
