package com.tp4.programacion.business;

import com.tp4.programacion.model.Car;
import com.tp4.programacion.model.Customer;
import com.tp4.programacion.model.Insurance;
import com.tp4.programacion.persistance.ListScheduleRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class AddScheduleCommandTest {
    @Mock
    private ScheduleService scheduleService;

    @Test
    void success() {
        val date = Date.from(Instant.parse("2021-10-10T10:00:00.00Z"));
        val professionalType = "Mecánico";
        val car = Car.builder().build();
        val insurance = Insurance.builder().build();
        val customer = Customer.builder().build();
        Command command = new AddScheduleCommand(scheduleService, date, professionalType, car, insurance, customer);
        command.execute();

        verify(scheduleService, times(1)).addSchedule(Mockito.any());
    }
}