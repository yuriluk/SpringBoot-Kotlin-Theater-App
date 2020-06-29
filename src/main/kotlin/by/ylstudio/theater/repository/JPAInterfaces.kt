package by.ylstudio.theater.repository

import by.ylstudio.theater.domain.Booking
import by.ylstudio.theater.domain.Performance
import by.ylstudio.theater.domain.Seat
import org.springframework.data.jpa.repository.JpaRepository


interface SeatRepository : JpaRepository<Seat, Long>

interface PerformanceRepository: JpaRepository<Performance, Long>

interface BookingRepository: JpaRepository<Booking, Long>
