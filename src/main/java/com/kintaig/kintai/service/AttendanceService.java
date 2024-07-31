package com.kintaig.kintai.service;

import com.kintaig.kintai.domain.Attendance;
import com.kintaig.kintai.domain.AttendanceDTO;
import com.kintaig.kintai.repository.AttendanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Transactional
    public Attendance recordAttendance(AttendanceDTO attendanceDTO) {
        Attendance attendance = new Attendance();
        attendance.setUserId(attendanceDTO.getUserId());
        attendance.setType(attendanceDTO.getType());
        attendance.setTimestamp(attendanceDTO.getTimestamp());
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceHistory(Long userId) {
        return attendanceRepository.findByUserIdOrderByTimestampDesc(userId);
    }
}
