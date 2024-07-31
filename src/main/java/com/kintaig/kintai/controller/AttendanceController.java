package com.kintaig.kintai.controller;

import com.kintaig.kintai.domain.Attendance;
import com.kintaig.kintai.domain.AttendanceDTO;
import com.kintaig.kintai.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping
    public ResponseEntity<AttendanceDTO> recordAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        Attendance savedAttendance = attendanceService.recordAttendance(attendanceDTO);
        return ResponseEntity.ok(convertToDTO(savedAttendance));
    }

    @GetMapping("/history")
    public ResponseEntity<List<AttendanceDTO>> getAttendanceHistory(@RequestParam Long userId) {
        List<Attendance> history = attendanceService.getAttendanceHistory(userId);
        List<AttendanceDTO> historyDTOs = history.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(historyDTOs);
    }

    private AttendanceDTO convertToDTO(Attendance attendance) {
        return new AttendanceDTO(
                attendance.getUserId(),
                attendance.getType(),
                attendance.getTimestamp()
        );
    }
}
