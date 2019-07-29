package com.example.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;



@TableName(value = "room")

 public class Room {

   @TableId(value = "room_no",type= IdType.AUTO)
   private int roomNo;

    @TableField("room_id")
    private String roomId;

   @TableField("room_type")
   private String roomType;


    @TableField("room_state")
   private String roomState;
   @TableField("room_price")
   private double roomPrice;
   @TableField("room_location")
   private String roomLocation;




    @Override
   public String toString() {
      return "Room{" +
              "roomId='" + roomId + '\'' +
              ", roomType='" + roomType + '\'' +
              ", roomState='" + roomState + '\'' +
              ", roomPrice='" + roomPrice + '\'' +
              ", roomLocation='" + roomLocation + '\'' +
              ", roomNo='" + roomNo + '\'' +
              '}';
   }
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    public long getRoomNo() {
        return roomNo;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

   public String getRoomId() {
      return roomId;
   }

   public void setRoomId(String roomId) {
      this.roomId = roomId;
   }

    public double getRoomPrice() {
        return roomPrice;
    }

    public String getRoomType() {
      return roomType;
   }

   public void setRoomType(String roomType) {
      this.roomType = roomType;
   }

   public String getRoomState() {
      return roomState;
   }

   public void setRoomState(String roomState) {
      this.roomState = roomState;
   }



   public String getRoomLocation() {
      return roomLocation;
   }

   public void setRoomLocation(String roomLocation) {
      this.roomLocation = roomLocation;
   }

    public Room() {

    }


}
