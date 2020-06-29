package by.ylstudio.theater.service


import by.ylstudio.theater.domain.Booking
import by.ylstudio.theater.domain.Performance
import by.ylstudio.theater.domain.Seat
import by.ylstudio.theater.repository.BookingRepository
import by.ylstudio.theater.repository.PerformanceRepository
import by.ylstudio.theater.repository.SeatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookingService {

    @Autowired
    lateinit var bookingRepository: BookingRepository

    @Autowired
    lateinit var seatRepository: SeatRepository

    @Autowired
    lateinit var performanceRepository: PerformanceRepository

    fun isSeatFree(seat : Seat, performance: Performance) : Boolean {
        val matchedBookings = findBooking(seat, performance)
        return matchedBookings == null
    }

    fun findSeat(seatNum: Int, seatRow: Char) : Seat? {
        val allSeats = seatRepository.findAll()
        val foundSeat = allSeats.filter { it.num == seatNum && it.rowNum == seatRow}
        return foundSeat.firstOrNull()
    }

    fun findBooking(seat: Seat, performance: Performance) : Booking? {
        val bookings = bookingRepository.findAll()
        val matchedBookings = bookings.filter { it.seat == seat && it.performance == performance }
        return matchedBookings.firstOrNull()
    }

    fun reserveSeat(sid: Long, pid: Long, customerName: String) : Booking {
        val booking = Booking(0,customerName)
        booking.seat = seatRepository.findById(sid).get()
        booking.performance = performanceRepository.findById(pid).get()

        bookingRepository.save(booking)
        return booking
    }
}
