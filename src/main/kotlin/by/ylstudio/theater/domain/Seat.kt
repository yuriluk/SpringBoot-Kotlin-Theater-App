package by.ylstudio.theater.domain

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Seat(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long,
                val rowNum: Char,
                val num: Int,
                val price: BigDecimal,
                val description: String) {

    override fun toString(): String = "Seat $rowNum-$num $$price ($description)"
}
