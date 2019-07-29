package com.example.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Room;
import com.example.mapper.RoomMapper;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service

@Transactional(readOnly = false)
public class RoomService extends ServiceImpl<RoomMapper,Room> {
    @Resource
    private RoomMapper roomMapper;
public int addRoom(Room room)
{
    if(roomMapper.getRoom(room.getRoomId())==null) {
        roomMapper.insert(room);
        return 0;
    }
    return -1;
}
public Room gerRoom(String roomId){

        if(roomMapper.getRoom(roomId)!=null)
        return roomMapper.getRoom(roomId);
        else
            return null;

}
public List<Room> getAll(){
    return roomMapper.getAll();
}

public List<Room> likeRId(String roomId){
    return this.roomMapper.likeRid(roomId);

}
public int editRoom(String roomId,String roomPrice,String roomLocation,String roomNo) {
    return this.roomMapper.editRoom(roomId,roomPrice,roomLocation,roomNo);
}
    @Transactional
public boolean deleteRoom(long roomNo){
  if(roomMapper.deleteById(roomNo)!=0)
      return true;
  else
      return false;
}


}
