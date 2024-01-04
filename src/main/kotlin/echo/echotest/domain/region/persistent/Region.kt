package echo.echotest.domain.region.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.country.persistent.Country
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "regions")
class Region(
    @Id
    @Column(name = "region_id")
    var regionId: Long = 0,

    @Column(name = "region_name", nullable = true)
    var regionName: String,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val countryList:  List<Country> = emptyList()
) {
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Region::regionId)
        private val toStringProperties = arrayOf(
            Region::regionId,
        )
    }
}