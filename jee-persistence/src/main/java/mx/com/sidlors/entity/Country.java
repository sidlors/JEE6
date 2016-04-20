package mx.com.sidlors.entity;

import javax.persistence.*;
import java.util.List;
import mx.com.sidlors.base.entity.AbstractEntity;


/**
 * The persistent class for the COUNTRIES database table.
 * 
 */
@Entity
@Table(name="COUNTRIES")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country extends AbstractEntity<Country>{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COUNTRIES_COUNTRYID_GENERATOR", sequenceName="SEQ_HR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COUNTRIES_COUNTRYID_GENERATOR")
	@Column(name="COUNTRY_ID")
	private String countryId;

	@Column(name="COUNTRY_NAME")
	private String countryName;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="REGION_ID")
	private Region region;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="country")
	private List<Location> locations;

	public Country() {
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setCountry(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setCountry(null);

		return location;
	}

  @Override
  public int compareTo( Country o ) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean equals( Object obj ) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return 0;
  }

 

}