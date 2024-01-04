package echo.echotest.domain.country.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.location.persistent.Location
import echo.echotest.domain.region.persistent.Region
import jakarta.persistence.*

@Entity
@Table(name = "countries")
class Country(
    @Id
    @Column(name = "country_id",)
    var countryId: String,

    @Column(name = "country_name", nullable = true)
    var countryName: String,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "region_id")
    val region: Region,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val locationList:  List<Location> = emptyList()
) {
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Country::countryId)
        private val toStringProperties = arrayOf(
            Country::countryId
        )
    }
}