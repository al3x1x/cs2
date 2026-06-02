package app.infrastructure.persitence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "affected_individuals")
public class AffectedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String riskLevel;
    private Integer aggressivenessLevel;
    private String location;

    public AffectedEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public Integer getAggressivenessLevel() { return aggressivenessLevel; }
    public void setAggressivenessLevel(Integer aggressivenessLevel) { this.aggressivenessLevel = aggressivenessLevel; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
