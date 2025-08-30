package com.saymeevetime.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.saymeevetime.entity.Appointment;
import org.springframework.stereotype.Service;

/**
 *
 * @author jiacheng
 * @date 28/8/25 23:21 Thursday
 * @description :
 *
 */

public interface AppointmentService  extends IService<Appointment>{

    Appointment getOne(Appointment appointment);
}
