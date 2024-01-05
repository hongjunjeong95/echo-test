package echo.echotest.domain.location.persistent

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import echo.echotest.domain.country.persistent.Country
import echo.echotest.domain.department.persistent.Department
import echo.echotest.domain.jobHistory.persistent.JobHistory
import jakarta.persistence.*

@Entity
@Table(name = "locations")
class Location(
    @Id
    @Column(name = "location_id")
    var locationId: Long = 0,

    @Column(name = "street_address", nullable = true)
    var streetAddress: String,

    @Column(name = "postal_code", nullable = true)
    var postalCode: String,

    @Column(name = "city")
    var city: String,

    @Column(name = "state_province", nullable = true)
    var stateProvince: String,

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "country_id")
    val country: Country? = null,

    @OneToMany(mappedBy = "location")
    val departments:  List<Department> = emptyList(),
) {
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Location::locationId)
        private val toStringProperties = arrayOf(
            Location::locationId
        )
    }
}