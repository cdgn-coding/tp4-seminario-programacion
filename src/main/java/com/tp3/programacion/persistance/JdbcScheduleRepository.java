package com.tp3.programacion.persistance;

import com.tp3.programacion.business.ScheduleService;
import com.tp3.programacion.model.Schedule;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcScheduleRepository implements ScheduleService {
    private static JdbcScheduleRepository instance;
    private Connection connection;
    private Long counter = 0L;

    private JdbcScheduleRepository() {
        // Establecer la conexión con la base de datos (ejemplo con JDBC)
        try {
            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JdbcScheduleRepository getInstance() {
        if (instance == null) {
            synchronized (JdbcScheduleRepository.class) {
                if (instance == null) {
                    instance = new JdbcScheduleRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public void addSchedule(Schedule schedule) {
        // Insertar el turno en la base de datos
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO schedules (date_time, professional_type) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(schedule.getDateAndTime().getTime()));
            preparedStatement.setString(2, schedule.getProfessionalType());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long scheduleId = generatedKeys.getLong(1);
                schedule.setId(scheduleId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = new ArrayList<>();

        // Recuperar todos los turnos de la base de datos
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM schedules"
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedules;
    }

    @Override
    public void update(Schedule schedule) {
        // Actualizar el turno en la base de datos
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE schedules SET date_time = ?, professional_type = ? WHERE id = ?"
            );
            preparedStatement.setDate(1, new java.sql.Date(schedule.getDateAndTime().getTime()));
            preparedStatement.setString(2, schedule.getProfessionalType());
            preparedStatement.setLong(3, schedule.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos DAO para eliminar, buscar por ID u otras operaciones según tus necesidades

    // Cierra la conexión cuando la aplicación se detiene
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
