package by.ylstudio.theater.domain

import javax.persistence.*

@Entity
data class Booking(@Id @GeneratedValue(strategy= GenerationType.AUTO)
                   val id: Long,
                   val customerName : String) {

    @ManyToOne(cascade = [CascadeType.PERSIST])
    lateinit var seat : Seat

    @ManyToOne(cascade = [CascadeType.PERSIST])
    lateinit var performance: Performance
}
