package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoomMapper extends BaseMapper<Room> {



public List<Room> likeRid(@Param("roomId") String roomId);
public int editRoom(@Param("roomId") String roomId, @Param("roomPrice") String roomPrice, @Param("roomLocation") String roomLocation, @Param("roomNo") String roomNo);
public List<Room> getAll();
public Room getRoom(@Param("roomId") String roomId);

}
