/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.controller;


import com.example.entity.Employee;
import com.example.entity.Room;
import com.example.service.EmployeeService;
import com.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.pkcs11.Secmod;

import java.util.HashMap;
import java.util.List;

/**
 * 图书控制器
 *
 * @author fengshuonan
 * @Date 2017年2月17日20:27:22
 */
@Controller
@RequestMapping("/room")
public class BookController {

    @Autowired
    private RoomService roomservice;

    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/addroom")
    @ResponseBody

    public String addroom(Room room) {
        if(roomservice.addRoom(room)==0)

        return "SuccessResponseData.success()";
        else return "已有的房间号！";
    }
    @RequestMapping(value ="/admin" ,method = RequestMethod.GET)
    public String admin(@ModelAttribute(value="adminid") String adminid,HashMap<String,Object>map, Model model){
        List<Room> rooms=roomservice.getAll();
        List<Employee> employees=employeeService.showEmployee();
        model.addAttribute("adminid",adminid);
        model.addAttribute("rooms",rooms);
        model.addAttribute("hello","hello");
        model.addAttribute("admin","adminname");
        model.addAttribute("employees",employees);


        return "admin";
    }
   @RequestMapping(value = "/delete")
    @ResponseBody
    public String deleteRoom(@RequestParam(value = "roomId") int roomId){
        if(this.roomservice.deleteRoom(roomId))
        return "delete success";
        return  "error";
   }



    @RequestMapping(value = "/getAll")
    @ResponseBody
   public List<Room> getAll(){

      List<Room> rooms=roomservice.getAll();
      for(Room room:rooms)
          System.out.println(room.toString());
          return rooms;


    };
    @RequestMapping(value = "/getByName")
    @ResponseBody
    public Room getByName(@RequestParam(value= "roomId")String roomId){

      Room room=roomservice.gerRoom(roomId);

           if(room!=null)
        return room;
return null;
    };
    @RequestMapping(value = "/likeBid")
    @ResponseBody
    public List<Room> likeBid(@RequestParam(value = "roomId") String Rid){

        List<Room> rooms=roomservice.likeRId(Rid);
        for(Room room:rooms)
            System.out.println(room.toString());

        return rooms;

    };


}
