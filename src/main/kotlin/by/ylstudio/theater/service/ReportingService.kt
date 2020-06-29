package by.ylstudio.theater.service

import by.ylstudio.theater.repository.BookingRepository
import by.ylstudio.theater.domain.Booking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ReportingService {

    @Autowired
    lateinit var bookingRepository: BookingRepository


    fun allBookings(): List<Booking> {
        return bookingRepository.findAll()
    }


    fun premiumBookings(): List<Booking> {
        return bookingRepository.findAll().filter { it.seat.price > BigDecimal(15) }
    }
}
