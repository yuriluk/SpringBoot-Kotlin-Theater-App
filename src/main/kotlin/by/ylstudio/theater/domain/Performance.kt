package by.ylstudio.theater.domain

import javax.persistence.*

@Entity
data class Performance(@Id @GeneratedValue(strategy= GenerationType.AUTO)
                       val id: Long,
                       val title: String) {

    @OneToMany(mappedBy = "performance", cascade = [CascadeType.ALL])
    lateinit var bookings: List<Booking>
}
