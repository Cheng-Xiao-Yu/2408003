package cn.tedu.ivos.vehicle.mapper;

import cn.tedu.ivos.vehicle.pojo.dto.VehicleQuery;
import cn.tedu.ivos.vehicle.pojo.entity.Vehicle;
import cn.tedu.ivos.vehicle.pojo.vo.VehicleVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleMapper {
    VehicleVO selectByUsername(String username);
    List<VehicleVO> selectUser(VehicleQuery vehicleQuery);
    void insert(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(Long userId);
}
