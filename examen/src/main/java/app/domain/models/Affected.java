package app.domain.models;

public class Affected {
    private Long id;
    private String name;
    private String riskLevel; // LOW, MEDIUM, HIGH
    private Integer aggressivenessLevel; // 1 to 10
    private String location;

    public Affected() {}

    public Affected(Long id, String name, String riskLevel, Integer aggressivenessLevel, String location) {
        this.id = id;
        this.name = name;
        this.riskLevel = riskLevel;
        this.aggressivenessLevel = aggressivenessLevel;
        this.location = location;
    }

    // Getters and Setters
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